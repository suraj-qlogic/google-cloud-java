// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/cloud/automl/v1beta1/video.proto

package com.google.cloud.automl.v1beta1;

public final class VideoProto {
  private VideoProto() {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistryLite registry) {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions((com.google.protobuf.ExtensionRegistryLite) registry);
  }

  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_automl_v1beta1_VideoClassificationDatasetMetadata_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_automl_v1beta1_VideoClassificationDatasetMetadata_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_cloud_automl_v1beta1_VideoClassificationModelMetadata_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_cloud_automl_v1beta1_VideoClassificationModelMetadata_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }

  private static com.google.protobuf.Descriptors.FileDescriptor descriptor;

  static {
    java.lang.String[] descriptorData = {
      "\n\'google/cloud/automl/v1beta1/video.prot"
          + "o\022\033google.cloud.automl.v1beta1\032\034google/a"
          + "pi/annotations.proto\0320google/cloud/autom"
          + "l/v1beta1/classification.proto\"$\n\"VideoC"
          + "lassificationDatasetMetadata\"\"\n VideoCla"
          + "ssificationModelMetadataB\220\001\n\037com.google."
          + "cloud.automl.v1beta1B\nVideoProtoP\001ZAgoog"
          + "le.golang.org/genproto/googleapis/cloud/"
          + "automl/v1beta1;automl\312\002\033Google\\Cloud\\Aut"
          + "oMl\\V1beta1b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(
        descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.api.AnnotationsProto.getDescriptor(),
          com.google.cloud.automl.v1beta1.ClassificationProto.getDescriptor(),
        },
        assigner);
    internal_static_google_cloud_automl_v1beta1_VideoClassificationDatasetMetadata_descriptor =
        getDescriptor().getMessageTypes().get(0);
    internal_static_google_cloud_automl_v1beta1_VideoClassificationDatasetMetadata_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_automl_v1beta1_VideoClassificationDatasetMetadata_descriptor,
            new java.lang.String[] {});
    internal_static_google_cloud_automl_v1beta1_VideoClassificationModelMetadata_descriptor =
        getDescriptor().getMessageTypes().get(1);
    internal_static_google_cloud_automl_v1beta1_VideoClassificationModelMetadata_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_cloud_automl_v1beta1_VideoClassificationModelMetadata_descriptor,
            new java.lang.String[] {});
    com.google.api.AnnotationsProto.getDescriptor();
    com.google.cloud.automl.v1beta1.ClassificationProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}