package com.qianxun.grpc.lib.sysLang;

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
    comments = "Source: sys_lang.proto")
public final class SysLangServiceGrpc {

  private SysLangServiceGrpc() {}

  public static final String SERVICE_NAME = "sysLang.SysLangService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysLang.SysLangOuterClass.ByIdReq,
      com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang> getGetByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetById",
      requestType = com.qianxun.grpc.lib.sysLang.SysLangOuterClass.ByIdReq.class,
      responseType = com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysLang.SysLangOuterClass.ByIdReq,
      com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang> getGetByIdMethod() {
    io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysLang.SysLangOuterClass.ByIdReq, com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang> getGetByIdMethod;
    if ((getGetByIdMethod = SysLangServiceGrpc.getGetByIdMethod) == null) {
      synchronized (SysLangServiceGrpc.class) {
        if ((getGetByIdMethod = SysLangServiceGrpc.getGetByIdMethod) == null) {
          SysLangServiceGrpc.getGetByIdMethod = getGetByIdMethod = 
              io.grpc.MethodDescriptor.<com.qianxun.grpc.lib.sysLang.SysLangOuterClass.ByIdReq, com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "sysLang.SysLangService", "GetById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysLang.SysLangOuterClass.ByIdReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang.getDefaultInstance()))
                  .setSchemaDescriptor(new SysLangServiceMethodDescriptorSupplier("GetById"))
                  .build();
          }
        }
     }
     return getGetByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysLang.SysLangOuterClass.GetListReq,
      com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang> getGetListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetList",
      requestType = com.qianxun.grpc.lib.sysLang.SysLangOuterClass.GetListReq.class,
      responseType = com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysLang.SysLangOuterClass.GetListReq,
      com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang> getGetListMethod() {
    io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysLang.SysLangOuterClass.GetListReq, com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang> getGetListMethod;
    if ((getGetListMethod = SysLangServiceGrpc.getGetListMethod) == null) {
      synchronized (SysLangServiceGrpc.class) {
        if ((getGetListMethod = SysLangServiceGrpc.getGetListMethod) == null) {
          SysLangServiceGrpc.getGetListMethod = getGetListMethod = 
              io.grpc.MethodDescriptor.<com.qianxun.grpc.lib.sysLang.SysLangOuterClass.GetListReq, com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "sysLang.SysLangService", "GetList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysLang.SysLangOuterClass.GetListReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang.getDefaultInstance()))
                  .setSchemaDescriptor(new SysLangServiceMethodDescriptorSupplier("GetList"))
                  .build();
          }
        }
     }
     return getGetListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang,
      com.qianxun.grpc.lib.sysLang.SysLangOuterClass.Result> getInsertMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Insert",
      requestType = com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang.class,
      responseType = com.qianxun.grpc.lib.sysLang.SysLangOuterClass.Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang,
      com.qianxun.grpc.lib.sysLang.SysLangOuterClass.Result> getInsertMethod() {
    io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang, com.qianxun.grpc.lib.sysLang.SysLangOuterClass.Result> getInsertMethod;
    if ((getInsertMethod = SysLangServiceGrpc.getInsertMethod) == null) {
      synchronized (SysLangServiceGrpc.class) {
        if ((getInsertMethod = SysLangServiceGrpc.getInsertMethod) == null) {
          SysLangServiceGrpc.getInsertMethod = getInsertMethod = 
              io.grpc.MethodDescriptor.<com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang, com.qianxun.grpc.lib.sysLang.SysLangOuterClass.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "sysLang.SysLangService", "Insert"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysLang.SysLangOuterClass.Result.getDefaultInstance()))
                  .setSchemaDescriptor(new SysLangServiceMethodDescriptorSupplier("Insert"))
                  .build();
          }
        }
     }
     return getInsertMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang,
      com.qianxun.grpc.lib.sysLang.SysLangOuterClass.Result> getUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Update",
      requestType = com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang.class,
      responseType = com.qianxun.grpc.lib.sysLang.SysLangOuterClass.Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang,
      com.qianxun.grpc.lib.sysLang.SysLangOuterClass.Result> getUpdateMethod() {
    io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang, com.qianxun.grpc.lib.sysLang.SysLangOuterClass.Result> getUpdateMethod;
    if ((getUpdateMethod = SysLangServiceGrpc.getUpdateMethod) == null) {
      synchronized (SysLangServiceGrpc.class) {
        if ((getUpdateMethod = SysLangServiceGrpc.getUpdateMethod) == null) {
          SysLangServiceGrpc.getUpdateMethod = getUpdateMethod = 
              io.grpc.MethodDescriptor.<com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang, com.qianxun.grpc.lib.sysLang.SysLangOuterClass.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "sysLang.SysLangService", "Update"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysLang.SysLangOuterClass.Result.getDefaultInstance()))
                  .setSchemaDescriptor(new SysLangServiceMethodDescriptorSupplier("Update"))
                  .build();
          }
        }
     }
     return getUpdateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysLang.SysLangOuterClass.ByIdReq,
      com.qianxun.grpc.lib.sysLang.SysLangOuterClass.Result> getDeleteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Delete",
      requestType = com.qianxun.grpc.lib.sysLang.SysLangOuterClass.ByIdReq.class,
      responseType = com.qianxun.grpc.lib.sysLang.SysLangOuterClass.Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysLang.SysLangOuterClass.ByIdReq,
      com.qianxun.grpc.lib.sysLang.SysLangOuterClass.Result> getDeleteMethod() {
    io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysLang.SysLangOuterClass.ByIdReq, com.qianxun.grpc.lib.sysLang.SysLangOuterClass.Result> getDeleteMethod;
    if ((getDeleteMethod = SysLangServiceGrpc.getDeleteMethod) == null) {
      synchronized (SysLangServiceGrpc.class) {
        if ((getDeleteMethod = SysLangServiceGrpc.getDeleteMethod) == null) {
          SysLangServiceGrpc.getDeleteMethod = getDeleteMethod = 
              io.grpc.MethodDescriptor.<com.qianxun.grpc.lib.sysLang.SysLangOuterClass.ByIdReq, com.qianxun.grpc.lib.sysLang.SysLangOuterClass.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "sysLang.SysLangService", "Delete"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysLang.SysLangOuterClass.ByIdReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysLang.SysLangOuterClass.Result.getDefaultInstance()))
                  .setSchemaDescriptor(new SysLangServiceMethodDescriptorSupplier("Delete"))
                  .build();
          }
        }
     }
     return getDeleteMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SysLangServiceStub newStub(io.grpc.Channel channel) {
    return new SysLangServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SysLangServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SysLangServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SysLangServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SysLangServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class SysLangServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getById(com.qianxun.grpc.lib.sysLang.SysLangOuterClass.ByIdReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang> responseObserver) {
      asyncUnimplementedUnaryCall(getGetByIdMethod(), responseObserver);
    }

    /**
     */
    public void getList(com.qianxun.grpc.lib.sysLang.SysLangOuterClass.GetListReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang> responseObserver) {
      asyncUnimplementedUnaryCall(getGetListMethod(), responseObserver);
    }

    /**
     */
    public void insert(com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysLang.SysLangOuterClass.Result> responseObserver) {
      asyncUnimplementedUnaryCall(getInsertMethod(), responseObserver);
    }

    /**
     */
    public void update(com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysLang.SysLangOuterClass.Result> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateMethod(), responseObserver);
    }

    /**
     */
    public void delete(com.qianxun.grpc.lib.sysLang.SysLangOuterClass.ByIdReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysLang.SysLangOuterClass.Result> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetByIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.qianxun.grpc.lib.sysLang.SysLangOuterClass.ByIdReq,
                com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang>(
                  this, METHODID_GET_BY_ID)))
          .addMethod(
            getGetListMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.qianxun.grpc.lib.sysLang.SysLangOuterClass.GetListReq,
                com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang>(
                  this, METHODID_GET_LIST)))
          .addMethod(
            getInsertMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang,
                com.qianxun.grpc.lib.sysLang.SysLangOuterClass.Result>(
                  this, METHODID_INSERT)))
          .addMethod(
            getUpdateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang,
                com.qianxun.grpc.lib.sysLang.SysLangOuterClass.Result>(
                  this, METHODID_UPDATE)))
          .addMethod(
            getDeleteMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.qianxun.grpc.lib.sysLang.SysLangOuterClass.ByIdReq,
                com.qianxun.grpc.lib.sysLang.SysLangOuterClass.Result>(
                  this, METHODID_DELETE)))
          .build();
    }
  }

  /**
   */
  public static final class SysLangServiceStub extends io.grpc.stub.AbstractStub<SysLangServiceStub> {
    private SysLangServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SysLangServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SysLangServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SysLangServiceStub(channel, callOptions);
    }

    /**
     */
    public void getById(com.qianxun.grpc.lib.sysLang.SysLangOuterClass.ByIdReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getList(com.qianxun.grpc.lib.sysLang.SysLangOuterClass.GetListReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void insert(com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysLang.SysLangOuterClass.Result> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInsertMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void update(com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysLang.SysLangOuterClass.Result> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void delete(com.qianxun.grpc.lib.sysLang.SysLangOuterClass.ByIdReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysLang.SysLangOuterClass.Result> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SysLangServiceBlockingStub extends io.grpc.stub.AbstractStub<SysLangServiceBlockingStub> {
    private SysLangServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SysLangServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SysLangServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SysLangServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang getById(com.qianxun.grpc.lib.sysLang.SysLangOuterClass.ByIdReq request) {
      return blockingUnaryCall(
          getChannel(), getGetByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang> getList(
        com.qianxun.grpc.lib.sysLang.SysLangOuterClass.GetListReq request) {
      return blockingServerStreamingCall(
          getChannel(), getGetListMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.qianxun.grpc.lib.sysLang.SysLangOuterClass.Result insert(com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang request) {
      return blockingUnaryCall(
          getChannel(), getInsertMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.qianxun.grpc.lib.sysLang.SysLangOuterClass.Result update(com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang request) {
      return blockingUnaryCall(
          getChannel(), getUpdateMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.qianxun.grpc.lib.sysLang.SysLangOuterClass.Result delete(com.qianxun.grpc.lib.sysLang.SysLangOuterClass.ByIdReq request) {
      return blockingUnaryCall(
          getChannel(), getDeleteMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SysLangServiceFutureStub extends io.grpc.stub.AbstractStub<SysLangServiceFutureStub> {
    private SysLangServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SysLangServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SysLangServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SysLangServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang> getById(
        com.qianxun.grpc.lib.sysLang.SysLangOuterClass.ByIdReq request) {
      return futureUnaryCall(
          getChannel().newCall(getGetByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.qianxun.grpc.lib.sysLang.SysLangOuterClass.Result> insert(
        com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang request) {
      return futureUnaryCall(
          getChannel().newCall(getInsertMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.qianxun.grpc.lib.sysLang.SysLangOuterClass.Result> update(
        com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.qianxun.grpc.lib.sysLang.SysLangOuterClass.Result> delete(
        com.qianxun.grpc.lib.sysLang.SysLangOuterClass.ByIdReq request) {
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
    private final SysLangServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SysLangServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_BY_ID:
          serviceImpl.getById((com.qianxun.grpc.lib.sysLang.SysLangOuterClass.ByIdReq) request,
              (io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang>) responseObserver);
          break;
        case METHODID_GET_LIST:
          serviceImpl.getList((com.qianxun.grpc.lib.sysLang.SysLangOuterClass.GetListReq) request,
              (io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang>) responseObserver);
          break;
        case METHODID_INSERT:
          serviceImpl.insert((com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang) request,
              (io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysLang.SysLangOuterClass.Result>) responseObserver);
          break;
        case METHODID_UPDATE:
          serviceImpl.update((com.qianxun.grpc.lib.sysLang.SysLangOuterClass.SysLang) request,
              (io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysLang.SysLangOuterClass.Result>) responseObserver);
          break;
        case METHODID_DELETE:
          serviceImpl.delete((com.qianxun.grpc.lib.sysLang.SysLangOuterClass.ByIdReq) request,
              (io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysLang.SysLangOuterClass.Result>) responseObserver);
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

  private static abstract class SysLangServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SysLangServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.qianxun.grpc.lib.sysLang.SysLangOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SysLangService");
    }
  }

  private static final class SysLangServiceFileDescriptorSupplier
      extends SysLangServiceBaseDescriptorSupplier {
    SysLangServiceFileDescriptorSupplier() {}
  }

  private static final class SysLangServiceMethodDescriptorSupplier
      extends SysLangServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SysLangServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (SysLangServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SysLangServiceFileDescriptorSupplier())
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
