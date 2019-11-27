/*
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner;

import com.google.api.client.util.Preconditions;
import com.google.cloud.Timestamp;
import com.google.common.collect.ImmutableMap;
import com.google.spanner.v1.Transaction;
import io.opencensus.contrib.grpc.util.StatusConverter;
import io.opencensus.implcore.internal.SimpleEventQueue;
import io.opencensus.implcore.trace.RecordEventsSpanImpl;
import io.opencensus.implcore.trace.export.ExportComponentImpl;
import io.opencensus.implcore.trace.export.InProcessSampledSpanStoreImpl;
import io.opencensus.testing.common.TestClock;
import io.opencensus.trace.AttributeValue;
import io.opencensus.trace.EndSpanOptions;
import io.opencensus.trace.Span;
import io.opencensus.trace.SpanContext;
import io.opencensus.trace.SpanId;
import io.opencensus.trace.Status;
import io.opencensus.trace.TraceId;
import io.opencensus.trace.TraceOptions;
import io.opencensus.trace.Tracestate;
import io.opencensus.trace.config.TraceParams;
import java.util.Map;
import java.util.Random;

/** Utility methods for tracing. */
class TraceUtil {

  private static final InProcessSampledSpanStoreImpl sampledSpanStore =
      (InProcessSampledSpanStoreImpl)
          ExportComponentImpl.createWithInProcessStores(new SimpleEventQueue())
              .getSampledSpanStore();
  private static final RecordEventsSpanImpl.StartEndHandler recordEventSpan =
      new RecordEventsSpanImpl.StartEndHandler() {
        @Override
        public void onStart(RecordEventsSpanImpl span) {
          // Do nothing.
        }

        @Override
        public void onEnd(RecordEventsSpanImpl span) {
          sampledSpanStore.considerForSampling(span);
        }
      };

  static Map<String, AttributeValue> getTransactionAnnotations(Transaction t) {
    return ImmutableMap.of(
        "Id",
        AttributeValue.stringAttributeValue(t.getId().toStringUtf8()),
        "Timestamp",
        AttributeValue.stringAttributeValue(Timestamp.fromProto(t.getReadTimestamp()).toString()));
  }

  static ImmutableMap<String, AttributeValue> getExceptionAnnotations(RuntimeException e) {
    if (e instanceof SpannerException) {
      return ImmutableMap.of(
          "Status",
          AttributeValue.stringAttributeValue(((SpannerException) e).getErrorCode().toString()));
    }
    return ImmutableMap.of();
  }

  static ImmutableMap<String, AttributeValue> getExceptionAnnotations(SpannerException e) {
    return ImmutableMap.of(
        "Status", AttributeValue.stringAttributeValue(e.getErrorCode().toString()));
  }

  static void endSpanWithFailure(Span span, Throwable e) {
    if (e instanceof SpannerException) {
      endSpanWithFailure(span, (SpannerException) e);
    } else {
      span.setStatus(Status.INTERNAL.withDescription(e.getMessage()));
      span.end();
    }
  }

  static void endSpanWithFailure(Span span, SpannerException e) {
    span.setStatus(
        StatusConverter.fromGrpcStatus(e.getErrorCode().getGrpcStatus())
            .withDescription(e.getMessage()));
    span.end();
  }

  /**
   * Appends a list of span names.
   *
   * <p>If called multiple times the library keeps the list of unique span names from all the calls.
   *
   * @param spans list of span names.
   */
  static void exportSpans(String... spans) {
    Preconditions.checkNotNull(spans);
    for (String spanName : spans) {
      RecordEventsSpanImpl recordEventsSpan = createSampledSpan(spanName);
      recordEventsSpan.end(EndSpanOptions.builder().setSampleToLocalSpanStore(true).build());
    }
  }

  /**
   * Create span to records trace events.
   *
   * @param spanName span names.
   */
  private static RecordEventsSpanImpl createSampledSpan(String spanName) {
    Random random = new Random();
    SpanId parentSpanId = SpanId.generateRandomId(random);
    SpanContext sampledSpanContext =
        SpanContext.create(
            TraceId.generateRandomId(random),
            SpanId.generateRandomId(random),
            TraceOptions.builder().setIsSampled(true).build(),
            Tracestate.builder().build());
    return RecordEventsSpanImpl.startSpan(
        sampledSpanContext,
        spanName,
        Span.Kind.CLIENT,
        parentSpanId,
        false,
        TraceParams.DEFAULT,
        recordEventSpan,
        null,
        TestClock.create());
  }
}
