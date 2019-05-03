// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: grpc_dept.proto

package com.qianxun.grpc.lib.dept;

/**
 * Protobuf type {@code dept.DeptRes}
 */
public  final class DeptRes extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:dept.DeptRes)
    DeptResOrBuilder {
private static final long serialVersionUID = 0L;
  // Use DeptRes.newBuilder() to construct.
  private DeptRes(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private DeptRes() {
    id_ = 0;
    parentId_ = 0;
    sort_ = 0;
    status_ = 0;
    dbSource_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private DeptRes(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {

            id_ = input.readInt32();
            break;
          }
          case 16: {

            parentId_ = input.readInt32();
            break;
          }
          case 24: {

            sort_ = input.readInt32();
            break;
          }
          case 34: {
            com.google.protobuf.Timestamp.Builder subBuilder = null;
            if (createdAt_ != null) {
              subBuilder = createdAt_.toBuilder();
            }
            createdAt_ = input.readMessage(com.google.protobuf.Timestamp.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(createdAt_);
              createdAt_ = subBuilder.buildPartial();
            }

            break;
          }
          case 42: {
            com.google.protobuf.Timestamp.Builder subBuilder = null;
            if (updatedAt_ != null) {
              subBuilder = updatedAt_.toBuilder();
            }
            updatedAt_ = input.readMessage(com.google.protobuf.Timestamp.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(updatedAt_);
              updatedAt_ = subBuilder.buildPartial();
            }

            break;
          }
          case 48: {

            status_ = input.readInt32();
            break;
          }
          case 58: {
            java.lang.String s = input.readStringRequireUtf8();

            dbSource_ = s;
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.qianxun.grpc.lib.dept.DeptProto.internal_static_dept_DeptRes_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.qianxun.grpc.lib.dept.DeptProto.internal_static_dept_DeptRes_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.qianxun.grpc.lib.dept.DeptRes.class, com.qianxun.grpc.lib.dept.DeptRes.Builder.class);
  }

  public static final int ID_FIELD_NUMBER = 1;
  private int id_;
  /**
   * <code>int32 id = 1;</code>
   */
  public int getId() {
    return id_;
  }

  public static final int PARENT_ID_FIELD_NUMBER = 2;
  private int parentId_;
  /**
   * <code>int32 parent_id = 2;</code>
   */
  public int getParentId() {
    return parentId_;
  }

  public static final int SORT_FIELD_NUMBER = 3;
  private int sort_;
  /**
   * <code>int32 sort = 3;</code>
   */
  public int getSort() {
    return sort_;
  }

  public static final int CREATED_AT_FIELD_NUMBER = 4;
  private com.google.protobuf.Timestamp createdAt_;
  /**
   * <code>.google.protobuf.Timestamp created_at = 4;</code>
   */
  public boolean hasCreatedAt() {
    return createdAt_ != null;
  }
  /**
   * <code>.google.protobuf.Timestamp created_at = 4;</code>
   */
  public com.google.protobuf.Timestamp getCreatedAt() {
    return createdAt_ == null ? com.google.protobuf.Timestamp.getDefaultInstance() : createdAt_;
  }
  /**
   * <code>.google.protobuf.Timestamp created_at = 4;</code>
   */
  public com.google.protobuf.TimestampOrBuilder getCreatedAtOrBuilder() {
    return getCreatedAt();
  }

  public static final int UPDATED_AT_FIELD_NUMBER = 5;
  private com.google.protobuf.Timestamp updatedAt_;
  /**
   * <code>.google.protobuf.Timestamp updated_at = 5;</code>
   */
  public boolean hasUpdatedAt() {
    return updatedAt_ != null;
  }
  /**
   * <code>.google.protobuf.Timestamp updated_at = 5;</code>
   */
  public com.google.protobuf.Timestamp getUpdatedAt() {
    return updatedAt_ == null ? com.google.protobuf.Timestamp.getDefaultInstance() : updatedAt_;
  }
  /**
   * <code>.google.protobuf.Timestamp updated_at = 5;</code>
   */
  public com.google.protobuf.TimestampOrBuilder getUpdatedAtOrBuilder() {
    return getUpdatedAt();
  }

  public static final int STATUS_FIELD_NUMBER = 6;
  private int status_;
  /**
   * <code>int32 status = 6;</code>
   */
  public int getStatus() {
    return status_;
  }

  public static final int DB_SOURCE_FIELD_NUMBER = 7;
  private volatile java.lang.Object dbSource_;
  /**
   * <code>string db_source = 7;</code>
   */
  public java.lang.String getDbSource() {
    java.lang.Object ref = dbSource_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      dbSource_ = s;
      return s;
    }
  }
  /**
   * <code>string db_source = 7;</code>
   */
  public com.google.protobuf.ByteString
      getDbSourceBytes() {
    java.lang.Object ref = dbSource_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      dbSource_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (id_ != 0) {
      output.writeInt32(1, id_);
    }
    if (parentId_ != 0) {
      output.writeInt32(2, parentId_);
    }
    if (sort_ != 0) {
      output.writeInt32(3, sort_);
    }
    if (createdAt_ != null) {
      output.writeMessage(4, getCreatedAt());
    }
    if (updatedAt_ != null) {
      output.writeMessage(5, getUpdatedAt());
    }
    if (status_ != 0) {
      output.writeInt32(6, status_);
    }
    if (!getDbSourceBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 7, dbSource_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (id_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, id_);
    }
    if (parentId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, parentId_);
    }
    if (sort_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, sort_);
    }
    if (createdAt_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(4, getCreatedAt());
    }
    if (updatedAt_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(5, getUpdatedAt());
    }
    if (status_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(6, status_);
    }
    if (!getDbSourceBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(7, dbSource_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.qianxun.grpc.lib.dept.DeptRes)) {
      return super.equals(obj);
    }
    com.qianxun.grpc.lib.dept.DeptRes other = (com.qianxun.grpc.lib.dept.DeptRes) obj;

    boolean result = true;
    result = result && (getId()
        == other.getId());
    result = result && (getParentId()
        == other.getParentId());
    result = result && (getSort()
        == other.getSort());
    result = result && (hasCreatedAt() == other.hasCreatedAt());
    if (hasCreatedAt()) {
      result = result && getCreatedAt()
          .equals(other.getCreatedAt());
    }
    result = result && (hasUpdatedAt() == other.hasUpdatedAt());
    if (hasUpdatedAt()) {
      result = result && getUpdatedAt()
          .equals(other.getUpdatedAt());
    }
    result = result && (getStatus()
        == other.getStatus());
    result = result && getDbSource()
        .equals(other.getDbSource());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + ID_FIELD_NUMBER;
    hash = (53 * hash) + getId();
    hash = (37 * hash) + PARENT_ID_FIELD_NUMBER;
    hash = (53 * hash) + getParentId();
    hash = (37 * hash) + SORT_FIELD_NUMBER;
    hash = (53 * hash) + getSort();
    if (hasCreatedAt()) {
      hash = (37 * hash) + CREATED_AT_FIELD_NUMBER;
      hash = (53 * hash) + getCreatedAt().hashCode();
    }
    if (hasUpdatedAt()) {
      hash = (37 * hash) + UPDATED_AT_FIELD_NUMBER;
      hash = (53 * hash) + getUpdatedAt().hashCode();
    }
    hash = (37 * hash) + STATUS_FIELD_NUMBER;
    hash = (53 * hash) + getStatus();
    hash = (37 * hash) + DB_SOURCE_FIELD_NUMBER;
    hash = (53 * hash) + getDbSource().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.qianxun.grpc.lib.dept.DeptRes parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.qianxun.grpc.lib.dept.DeptRes parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.qianxun.grpc.lib.dept.DeptRes parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.qianxun.grpc.lib.dept.DeptRes parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.qianxun.grpc.lib.dept.DeptRes parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.qianxun.grpc.lib.dept.DeptRes parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.qianxun.grpc.lib.dept.DeptRes parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.qianxun.grpc.lib.dept.DeptRes parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.qianxun.grpc.lib.dept.DeptRes parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.qianxun.grpc.lib.dept.DeptRes parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.qianxun.grpc.lib.dept.DeptRes parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.qianxun.grpc.lib.dept.DeptRes parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.qianxun.grpc.lib.dept.DeptRes prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code dept.DeptRes}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:dept.DeptRes)
      com.qianxun.grpc.lib.dept.DeptResOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.qianxun.grpc.lib.dept.DeptProto.internal_static_dept_DeptRes_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.qianxun.grpc.lib.dept.DeptProto.internal_static_dept_DeptRes_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.qianxun.grpc.lib.dept.DeptRes.class, com.qianxun.grpc.lib.dept.DeptRes.Builder.class);
    }

    // Construct using com.qianxun.grpc.lib.dept.DeptRes.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      id_ = 0;

      parentId_ = 0;

      sort_ = 0;

      if (createdAtBuilder_ == null) {
        createdAt_ = null;
      } else {
        createdAt_ = null;
        createdAtBuilder_ = null;
      }
      if (updatedAtBuilder_ == null) {
        updatedAt_ = null;
      } else {
        updatedAt_ = null;
        updatedAtBuilder_ = null;
      }
      status_ = 0;

      dbSource_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.qianxun.grpc.lib.dept.DeptProto.internal_static_dept_DeptRes_descriptor;
    }

    @java.lang.Override
    public com.qianxun.grpc.lib.dept.DeptRes getDefaultInstanceForType() {
      return com.qianxun.grpc.lib.dept.DeptRes.getDefaultInstance();
    }

    @java.lang.Override
    public com.qianxun.grpc.lib.dept.DeptRes build() {
      com.qianxun.grpc.lib.dept.DeptRes result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.qianxun.grpc.lib.dept.DeptRes buildPartial() {
      com.qianxun.grpc.lib.dept.DeptRes result = new com.qianxun.grpc.lib.dept.DeptRes(this);
      result.id_ = id_;
      result.parentId_ = parentId_;
      result.sort_ = sort_;
      if (createdAtBuilder_ == null) {
        result.createdAt_ = createdAt_;
      } else {
        result.createdAt_ = createdAtBuilder_.build();
      }
      if (updatedAtBuilder_ == null) {
        result.updatedAt_ = updatedAt_;
      } else {
        result.updatedAt_ = updatedAtBuilder_.build();
      }
      result.status_ = status_;
      result.dbSource_ = dbSource_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.qianxun.grpc.lib.dept.DeptRes) {
        return mergeFrom((com.qianxun.grpc.lib.dept.DeptRes)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.qianxun.grpc.lib.dept.DeptRes other) {
      if (other == com.qianxun.grpc.lib.dept.DeptRes.getDefaultInstance()) return this;
      if (other.getId() != 0) {
        setId(other.getId());
      }
      if (other.getParentId() != 0) {
        setParentId(other.getParentId());
      }
      if (other.getSort() != 0) {
        setSort(other.getSort());
      }
      if (other.hasCreatedAt()) {
        mergeCreatedAt(other.getCreatedAt());
      }
      if (other.hasUpdatedAt()) {
        mergeUpdatedAt(other.getUpdatedAt());
      }
      if (other.getStatus() != 0) {
        setStatus(other.getStatus());
      }
      if (!other.getDbSource().isEmpty()) {
        dbSource_ = other.dbSource_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.qianxun.grpc.lib.dept.DeptRes parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.qianxun.grpc.lib.dept.DeptRes) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int id_ ;
    /**
     * <code>int32 id = 1;</code>
     */
    public int getId() {
      return id_;
    }
    /**
     * <code>int32 id = 1;</code>
     */
    public Builder setId(int value) {
      
      id_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 id = 1;</code>
     */
    public Builder clearId() {
      
      id_ = 0;
      onChanged();
      return this;
    }

    private int parentId_ ;
    /**
     * <code>int32 parent_id = 2;</code>
     */
    public int getParentId() {
      return parentId_;
    }
    /**
     * <code>int32 parent_id = 2;</code>
     */
    public Builder setParentId(int value) {
      
      parentId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 parent_id = 2;</code>
     */
    public Builder clearParentId() {
      
      parentId_ = 0;
      onChanged();
      return this;
    }

    private int sort_ ;
    /**
     * <code>int32 sort = 3;</code>
     */
    public int getSort() {
      return sort_;
    }
    /**
     * <code>int32 sort = 3;</code>
     */
    public Builder setSort(int value) {
      
      sort_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 sort = 3;</code>
     */
    public Builder clearSort() {
      
      sort_ = 0;
      onChanged();
      return this;
    }

    private com.google.protobuf.Timestamp createdAt_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder> createdAtBuilder_;
    /**
     * <code>.google.protobuf.Timestamp created_at = 4;</code>
     */
    public boolean hasCreatedAt() {
      return createdAtBuilder_ != null || createdAt_ != null;
    }
    /**
     * <code>.google.protobuf.Timestamp created_at = 4;</code>
     */
    public com.google.protobuf.Timestamp getCreatedAt() {
      if (createdAtBuilder_ == null) {
        return createdAt_ == null ? com.google.protobuf.Timestamp.getDefaultInstance() : createdAt_;
      } else {
        return createdAtBuilder_.getMessage();
      }
    }
    /**
     * <code>.google.protobuf.Timestamp created_at = 4;</code>
     */
    public Builder setCreatedAt(com.google.protobuf.Timestamp value) {
      if (createdAtBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        createdAt_ = value;
        onChanged();
      } else {
        createdAtBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp created_at = 4;</code>
     */
    public Builder setCreatedAt(
        com.google.protobuf.Timestamp.Builder builderForValue) {
      if (createdAtBuilder_ == null) {
        createdAt_ = builderForValue.build();
        onChanged();
      } else {
        createdAtBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp created_at = 4;</code>
     */
    public Builder mergeCreatedAt(com.google.protobuf.Timestamp value) {
      if (createdAtBuilder_ == null) {
        if (createdAt_ != null) {
          createdAt_ =
            com.google.protobuf.Timestamp.newBuilder(createdAt_).mergeFrom(value).buildPartial();
        } else {
          createdAt_ = value;
        }
        onChanged();
      } else {
        createdAtBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp created_at = 4;</code>
     */
    public Builder clearCreatedAt() {
      if (createdAtBuilder_ == null) {
        createdAt_ = null;
        onChanged();
      } else {
        createdAt_ = null;
        createdAtBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp created_at = 4;</code>
     */
    public com.google.protobuf.Timestamp.Builder getCreatedAtBuilder() {
      
      onChanged();
      return getCreatedAtFieldBuilder().getBuilder();
    }
    /**
     * <code>.google.protobuf.Timestamp created_at = 4;</code>
     */
    public com.google.protobuf.TimestampOrBuilder getCreatedAtOrBuilder() {
      if (createdAtBuilder_ != null) {
        return createdAtBuilder_.getMessageOrBuilder();
      } else {
        return createdAt_ == null ?
            com.google.protobuf.Timestamp.getDefaultInstance() : createdAt_;
      }
    }
    /**
     * <code>.google.protobuf.Timestamp created_at = 4;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder> 
        getCreatedAtFieldBuilder() {
      if (createdAtBuilder_ == null) {
        createdAtBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder>(
                getCreatedAt(),
                getParentForChildren(),
                isClean());
        createdAt_ = null;
      }
      return createdAtBuilder_;
    }

    private com.google.protobuf.Timestamp updatedAt_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder> updatedAtBuilder_;
    /**
     * <code>.google.protobuf.Timestamp updated_at = 5;</code>
     */
    public boolean hasUpdatedAt() {
      return updatedAtBuilder_ != null || updatedAt_ != null;
    }
    /**
     * <code>.google.protobuf.Timestamp updated_at = 5;</code>
     */
    public com.google.protobuf.Timestamp getUpdatedAt() {
      if (updatedAtBuilder_ == null) {
        return updatedAt_ == null ? com.google.protobuf.Timestamp.getDefaultInstance() : updatedAt_;
      } else {
        return updatedAtBuilder_.getMessage();
      }
    }
    /**
     * <code>.google.protobuf.Timestamp updated_at = 5;</code>
     */
    public Builder setUpdatedAt(com.google.protobuf.Timestamp value) {
      if (updatedAtBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        updatedAt_ = value;
        onChanged();
      } else {
        updatedAtBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp updated_at = 5;</code>
     */
    public Builder setUpdatedAt(
        com.google.protobuf.Timestamp.Builder builderForValue) {
      if (updatedAtBuilder_ == null) {
        updatedAt_ = builderForValue.build();
        onChanged();
      } else {
        updatedAtBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp updated_at = 5;</code>
     */
    public Builder mergeUpdatedAt(com.google.protobuf.Timestamp value) {
      if (updatedAtBuilder_ == null) {
        if (updatedAt_ != null) {
          updatedAt_ =
            com.google.protobuf.Timestamp.newBuilder(updatedAt_).mergeFrom(value).buildPartial();
        } else {
          updatedAt_ = value;
        }
        onChanged();
      } else {
        updatedAtBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp updated_at = 5;</code>
     */
    public Builder clearUpdatedAt() {
      if (updatedAtBuilder_ == null) {
        updatedAt_ = null;
        onChanged();
      } else {
        updatedAt_ = null;
        updatedAtBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.google.protobuf.Timestamp updated_at = 5;</code>
     */
    public com.google.protobuf.Timestamp.Builder getUpdatedAtBuilder() {
      
      onChanged();
      return getUpdatedAtFieldBuilder().getBuilder();
    }
    /**
     * <code>.google.protobuf.Timestamp updated_at = 5;</code>
     */
    public com.google.protobuf.TimestampOrBuilder getUpdatedAtOrBuilder() {
      if (updatedAtBuilder_ != null) {
        return updatedAtBuilder_.getMessageOrBuilder();
      } else {
        return updatedAt_ == null ?
            com.google.protobuf.Timestamp.getDefaultInstance() : updatedAt_;
      }
    }
    /**
     * <code>.google.protobuf.Timestamp updated_at = 5;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder> 
        getUpdatedAtFieldBuilder() {
      if (updatedAtBuilder_ == null) {
        updatedAtBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder>(
                getUpdatedAt(),
                getParentForChildren(),
                isClean());
        updatedAt_ = null;
      }
      return updatedAtBuilder_;
    }

    private int status_ ;
    /**
     * <code>int32 status = 6;</code>
     */
    public int getStatus() {
      return status_;
    }
    /**
     * <code>int32 status = 6;</code>
     */
    public Builder setStatus(int value) {
      
      status_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 status = 6;</code>
     */
    public Builder clearStatus() {
      
      status_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object dbSource_ = "";
    /**
     * <code>string db_source = 7;</code>
     */
    public java.lang.String getDbSource() {
      java.lang.Object ref = dbSource_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        dbSource_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string db_source = 7;</code>
     */
    public com.google.protobuf.ByteString
        getDbSourceBytes() {
      java.lang.Object ref = dbSource_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        dbSource_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string db_source = 7;</code>
     */
    public Builder setDbSource(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      dbSource_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string db_source = 7;</code>
     */
    public Builder clearDbSource() {
      
      dbSource_ = getDefaultInstance().getDbSource();
      onChanged();
      return this;
    }
    /**
     * <code>string db_source = 7;</code>
     */
    public Builder setDbSourceBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      dbSource_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:dept.DeptRes)
  }

  // @@protoc_insertion_point(class_scope:dept.DeptRes)
  private static final com.qianxun.grpc.lib.dept.DeptRes DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.qianxun.grpc.lib.dept.DeptRes();
  }

  public static com.qianxun.grpc.lib.dept.DeptRes getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<DeptRes>
      PARSER = new com.google.protobuf.AbstractParser<DeptRes>() {
    @java.lang.Override
    public DeptRes parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new DeptRes(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<DeptRes> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DeptRes> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.qianxun.grpc.lib.dept.DeptRes getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
