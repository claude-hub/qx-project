package com.qianxun.grpc.lib.sysDept;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.20.0)",
    comments = "Source: sys_dept.proto")
public final class SysDeptServiceGrpc {

  private SysDeptServiceGrpc() {}

  public static final String SERVICE_NAME = "sysDept.SysDeptService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.ByIdReq,
      com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept> getGetByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetById",
      requestType = com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.ByIdReq.class,
      responseType = com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.ByIdReq,
      com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept> getGetByIdMethod() {
    io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.ByIdReq, com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept> getGetByIdMethod;
    if ((getGetByIdMethod = SysDeptServiceGrpc.getGetByIdMethod) == null) {
      synchronized (SysDeptServiceGrpc.class) {
        if ((getGetByIdMethod = SysDeptServiceGrpc.getGetByIdMethod) == null) {
          SysDeptServiceGrpc.getGetByIdMethod = getGetByIdMethod = 
              io.grpc.MethodDescriptor.<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.ByIdReq, com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "sysDept.SysDeptService", "GetById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.ByIdReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept.getDefaultInstance()))
                  .setSchemaDescriptor(new SysDeptServiceMethodDescriptorSupplier("GetById"))
                  .build();
          }
        }
     }
     return getGetByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.GetListReq,
      com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.PageList> getGetListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetList",
      requestType = com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.GetListReq.class,
      responseType = com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.PageList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.GetListReq,
      com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.PageList> getGetListMethod() {
    io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.GetListReq, com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.PageList> getGetListMethod;
    if ((getGetListMethod = SysDeptServiceGrpc.getGetListMethod) == null) {
      synchronized (SysDeptServiceGrpc.class) {
        if ((getGetListMethod = SysDeptServiceGrpc.getGetListMethod) == null) {
          SysDeptServiceGrpc.getGetListMethod = getGetListMethod = 
              io.grpc.MethodDescriptor.<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.GetListReq, com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.PageList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "sysDept.SysDeptService", "GetList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.GetListReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.PageList.getDefaultInstance()))
                  .setSchemaDescriptor(new SysDeptServiceMethodDescriptorSupplier("GetList"))
                  .build();
          }
        }
     }
     return getGetListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.BaseSysDept,
      com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result> getInsertMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Insert",
      requestType = com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.BaseSysDept.class,
      responseType = com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.BaseSysDept,
      com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result> getInsertMethod() {
    io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.BaseSysDept, com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result> getInsertMethod;
    if ((getInsertMethod = SysDeptServiceGrpc.getInsertMethod) == null) {
      synchronized (SysDeptServiceGrpc.class) {
        if ((getInsertMethod = SysDeptServiceGrpc.getInsertMethod) == null) {
          SysDeptServiceGrpc.getInsertMethod = getInsertMethod = 
              io.grpc.MethodDescriptor.<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.BaseSysDept, com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "sysDept.SysDeptService", "Insert"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.BaseSysDept.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result.getDefaultInstance()))
                  .setSchemaDescriptor(new SysDeptServiceMethodDescriptorSupplier("Insert"))
                  .build();
          }
        }
     }
     return getInsertMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept,
      com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result> getUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Update",
      requestType = com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept.class,
      responseType = com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept,
      com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result> getUpdateMethod() {
    io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept, com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result> getUpdateMethod;
    if ((getUpdateMethod = SysDeptServiceGrpc.getUpdateMethod) == null) {
      synchronized (SysDeptServiceGrpc.class) {
        if ((getUpdateMethod = SysDeptServiceGrpc.getUpdateMethod) == null) {
          SysDeptServiceGrpc.getUpdateMethod = getUpdateMethod = 
              io.grpc.MethodDescriptor.<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept, com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "sysDept.SysDeptService", "Update"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result.getDefaultInstance()))
                  .setSchemaDescriptor(new SysDeptServiceMethodDescriptorSupplier("Update"))
                  .build();
          }
        }
     }
     return getUpdateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.ByIdReq,
      com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result> getDeleteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Delete",
      requestType = com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.ByIdReq.class,
      responseType = com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.ByIdReq,
      com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result> getDeleteMethod() {
    io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.ByIdReq, com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result> getDeleteMethod;
    if ((getDeleteMethod = SysDeptServiceGrpc.getDeleteMethod) == null) {
      synchronized (SysDeptServiceGrpc.class) {
        if ((getDeleteMethod = SysDeptServiceGrpc.getDeleteMethod) == null) {
          SysDeptServiceGrpc.getDeleteMethod = getDeleteMethod = 
              io.grpc.MethodDescriptor.<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.ByIdReq, com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "sysDept.SysDeptService", "Delete"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.ByIdReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result.getDefaultInstance()))
                  .setSchemaDescriptor(new SysDeptServiceMethodDescriptorSupplier("Delete"))
                  .build();
          }
        }
     }
     return getDeleteMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SysDeptServiceStub newStub(io.grpc.Channel channel) {
    return new SysDeptServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SysDeptServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SysDeptServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SysDeptServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SysDeptServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class SysDeptServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getById(com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.ByIdReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept> responseObserver) {
      asyncUnimplementedUnaryCall(getGetByIdMethod(), responseObserver);
    }

    /**
     */
    public void getList(com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.GetListReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.PageList> responseObserver) {
      asyncUnimplementedUnaryCall(getGetListMethod(), responseObserver);
    }

    /**
     */
    public void insert(com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.BaseSysDept request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result> responseObserver) {
      asyncUnimplementedUnaryCall(getInsertMethod(), responseObserver);
    }

    /**
     */
    public void update(com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateMethod(), responseObserver);
    }

    /**
     */
    public void delete(com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.ByIdReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetByIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.ByIdReq,
                com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept>(
                  this, METHODID_GET_BY_ID)))
          .addMethod(
            getGetListMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.GetListReq,
                com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.PageList>(
                  this, METHODID_GET_LIST)))
          .addMethod(
            getInsertMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.BaseSysDept,
                com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result>(
                  this, METHODID_INSERT)))
          .addMethod(
            getUpdateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept,
                com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result>(
                  this, METHODID_UPDATE)))
          .addMethod(
            getDeleteMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.ByIdReq,
                com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result>(
                  this, METHODID_DELETE)))
          .build();
    }
  }

  /**
   */
  public static final class SysDeptServiceStub extends io.grpc.stub.AbstractStub<SysDeptServiceStub> {
    private SysDeptServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SysDeptServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SysDeptServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SysDeptServiceStub(channel, callOptions);
    }

    /**
     */
    public void getById(com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.ByIdReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getList(com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.GetListReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.PageList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void insert(com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.BaseSysDept request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInsertMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void update(com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void delete(com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.ByIdReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SysDeptServiceBlockingStub extends io.grpc.stub.AbstractStub<SysDeptServiceBlockingStub> {
    private SysDeptServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SysDeptServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SysDeptServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SysDeptServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept getById(com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.ByIdReq request) {
      return blockingUnaryCall(
          getChannel(), getGetByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.PageList getList(com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.GetListReq request) {
      return blockingUnaryCall(
          getChannel(), getGetListMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result insert(com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.BaseSysDept request) {
      return blockingUnaryCall(
          getChannel(), getInsertMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result update(com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept request) {
      return blockingUnaryCall(
          getChannel(), getUpdateMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result delete(com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.ByIdReq request) {
      return blockingUnaryCall(
          getChannel(), getDeleteMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SysDeptServiceFutureStub extends io.grpc.stub.AbstractStub<SysDeptServiceFutureStub> {
    private SysDeptServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SysDeptServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SysDeptServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SysDeptServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept> getById(
        com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.ByIdReq request) {
      return futureUnaryCall(
          getChannel().newCall(getGetByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.PageList> getList(
        com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.GetListReq request) {
      return futureUnaryCall(
          getChannel().newCall(getGetListMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result> insert(
        com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.BaseSysDept request) {
      return futureUnaryCall(
          getChannel().newCall(getInsertMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result> update(
        com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result> delete(
        com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.ByIdReq request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_BY_ID = 0;
  private static final int METHODID_GET_LIST = 1;
  private static final int METHODID_INSERT = 2;
  private static final int METHODID_UPDATE = 3;
  private static final int METHODID_DELETE = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SysDeptServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SysDeptServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_BY_ID:
          serviceImpl.getById((com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.ByIdReq) request,
              (io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept>) responseObserver);
          break;
        case METHODID_GET_LIST:
          serviceImpl.getList((com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.GetListReq) request,
              (io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.PageList>) responseObserver);
          break;
        case METHODID_INSERT:
          serviceImpl.insert((com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.BaseSysDept) request,
              (io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result>) responseObserver);
          break;
        case METHODID_UPDATE:
          serviceImpl.update((com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept) request,
              (io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result>) responseObserver);
          break;
        case METHODID_DELETE:
          serviceImpl.delete((com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.ByIdReq) request,
              (io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SysDeptServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SysDeptServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SysDeptService");
    }
  }

  private static final class SysDeptServiceFileDescriptorSupplier
      extends SysDeptServiceBaseDescriptorSupplier {
    SysDeptServiceFileDescriptorSupplier() {}
  }

  private static final class SysDeptServiceMethodDescriptorSupplier
      extends SysDeptServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SysDeptServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (SysDeptServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SysDeptServiceFileDescriptorSupplier())
              .addMethod(getGetByIdMethod())
              .addMethod(getGetListMethod())
              .addMethod(getInsertMethod())
              .addMethod(getUpdateMethod())
              .addMethod(getDeleteMethod())
              .build();
        }
      }
    }
    return result;
  }
}
