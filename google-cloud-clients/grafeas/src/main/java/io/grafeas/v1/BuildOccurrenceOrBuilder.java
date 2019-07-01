/*
 * Copyright 2019 The Grafeas Authors. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: grafeas/v1/build.proto

package io.grafeas.v1;

public interface BuildOccurrenceOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:grafeas.v1.BuildOccurrence)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * Required. The actual provenance for the build.
   * </pre>
   *
   * <code>.grafeas.v1.BuildProvenance provenance = 1;</code>
   */
  boolean hasProvenance();
  /**
   *
   *
   * <pre>
   * Required. The actual provenance for the build.
   * </pre>
   *
   * <code>.grafeas.v1.BuildProvenance provenance = 1;</code>
   */
  io.grafeas.v1.BuildProvenance getProvenance();
  /**
   *
   *
   * <pre>
   * Required. The actual provenance for the build.
   * </pre>
   *
   * <code>.grafeas.v1.BuildProvenance provenance = 1;</code>
   */
  io.grafeas.v1.BuildProvenanceOrBuilder getProvenanceOrBuilder();

  /**
   *
   *
   * <pre>
   * Serialized JSON representation of the provenance, used in generating the
   * build signature in the corresponding build note. After verifying the
   * signature, `provenance_bytes` can be unmarshalled and compared to the
   * provenance to confirm that it is unchanged. A base64-encoded string
   * representation of the provenance bytes is used for the signature in order
   * to interoperate with openssl which expects this format for signature
   * verification.
   * The serialized form is captured both to avoid ambiguity in how the
   * provenance is marshalled to json as well to prevent incompatibilities with
   * future changes.
   * </pre>
   *
   * <code>string provenance_bytes = 2;</code>
   */
  java.lang.String getProvenanceBytes();
  /**
   *
   *
   * <pre>
   * Serialized JSON representation of the provenance, used in generating the
   * build signature in the corresponding build note. After verifying the
   * signature, `provenance_bytes` can be unmarshalled and compared to the
   * provenance to confirm that it is unchanged. A base64-encoded string
   * representation of the provenance bytes is used for the signature in order
   * to interoperate with openssl which expects this format for signature
   * verification.
   * The serialized form is captured both to avoid ambiguity in how the
   * provenance is marshalled to json as well to prevent incompatibilities with
   * future changes.
   * </pre>
   *
   * <code>string provenance_bytes = 2;</code>
   */
  com.google.protobuf.ByteString getProvenanceBytesBytes();
}