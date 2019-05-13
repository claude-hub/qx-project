package com.qianxun.grpc.lib.sysLog;

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
    comments = "Source: sys_log.proto")
public final class SysLogServiceGrpc {

  private SysLogServiceGrpc() {}

  public static final String SERVICE_NAME = "sysLog.SysLogService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysLog.SysLogOuterClass.ByIdReq,
      com.qianxun.grpc.lib.sysLog.SysLogOuterClass.SysLog> getGetByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetById",
      requestType = com.qianxun.grpc.lib.sysLog.SysLogOuterClass.ByIdReq.class,
      responseType = com.qianxun.grpc.lib.sysLog.SysLogOuterClass.SysLog.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysLog.SysLogOuterClass.ByIdReq,
      com.qianxun.grpc.lib.sysLog.SysLogOuterClass.SysLog> getGetByIdMethod() {
    io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysLog.SysLogOuterClass.ByIdReq, com.qianxun.grpc.lib.sysLog.SysLogOuterClass.SysLog> getGetByIdMethod;
    if ((getGetByIdMethod = SysLogServiceGrpc.getGetByIdMethod) == null) {
      synchronized (SysLogServiceGrpc.class) {
        if ((getGetByIdMethod = SysLogServiceGrpc.getGetByIdMethod) == null) {
          SysLogServiceGrpc.getGetByIdMethod = getGetByIdMethod = 
              io.grpc.MethodDescriptor.<com.qianxun.grpc.lib.sysLog.SysLogOuterClass.ByIdReq, com.qianxun.grpc.lib.sysLog.SysLogOuterClass.SysLog>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "sysLog.SysLogService", "GetById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysLog.SysLogOuterClass.ByIdReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysLog.SysLogOuterClass.SysLog.getDefaultInstance()))
                  .setSchemaDescriptor(new SysLogServiceMethodDescriptorSupplier("GetById"))
                  .build();
          }
        }
     }
     return getGetByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysLog.SysLogOuterClass.GetListReq,
      com.qianxun.grpc.lib.sysLog.SysLogOuterClass.PageList> getGetListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetList",
      requestType = com.qianxun.grpc.lib.sysLog.SysLogOuterClass.GetListReq.class,
      responseType = com.qianxun.grpc.lib.sysLog.SysLogOuterClass.PageList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysLog.SysLogOuterClass.GetListReq,
      com.qianxun.grpc.lib.sysLog.SysLogOuterClass.PageList> getGetListMethod() {
    io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysLog.SysLogOuterClass.GetListReq, com.qianxun.grpc.lib.sysLog.SysLogOuterClass.PageList> getGetListMethod;
    if ((getGetListMethod = SysLogServiceGrpc.getGetListMethod) == null) {
      synchronized (SysLogServiceGrpc.class) {
        if ((getGetListMethod = SysLogServiceGrpc.getGetListMethod) == null) {
          SysLogServiceGrpc.getGetListMethod = getGetListMethod = 
              io.grpc.MethodDescriptor.<com.qianxun.grpc.lib.sysLog.SysLogOuterClass.GetListReq, com.qianxun.grpc.lib.sysLog.SysLogOuterClass.PageList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "sysLog.SysLogService", "GetList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysLog.SysLogOuterClass.GetListReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysLog.SysLogOuterClass.PageList.getDefaultInstance()))
                  .setSchemaDescriptor(new SysLogServiceMethodDescriptorSupplier("GetList"))
                  .build();
          }
        }
     }
     return getGetListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysLog.SysLogOuterClass.BaseSysLog,
      com.qianxun.grpc.lib.sysLog.SysLogOuterClass.Result> getInsertMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Insert",
      requestType = com.qianxun.grpc.lib.sysLog.SysLogOuterClass.BaseSysLog.class,
      responseType = com.qianxun.grpc.lib.sysLog.SysLogOuterClass.Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysLog.SysLogOuterClass.BaseSysLog,
      com.qianxun.grpc.lib.sysLog.SysLogOuterClass.Result> getInsertMethod() {
    io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysLog.SysLogOuterClass.BaseSysLog, com.qianxun.grpc.lib.sysLog.SysLogOuterClass.Result> getInsertMethod;
    if ((getInsertMethod = SysLogServiceGrpc.getInsertMethod) == null) {
      synchronized (SysLogServiceGrpc.class) {
        if ((getInsertMethod = SysLogServiceGrpc.getInsertMethod) == null) {
          SysLogServiceGrpc.getInsertMethod = getInsertMethod = 
              io.grpc.MethodDescriptor.<com.qianxun.grpc.lib.sysLog.SysLogOuterClass.BaseSysLog, com.qianxun.grpc.lib.sysLog.SysLogOuterClass.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "sysLog.SysLogService", "Insert"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysLog.SysLogOuterClass.BaseSysLog.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysLog.SysLogOuterClass.Result.getDefaultInstance()))
                  .setSchemaDescriptor(new SysLogServiceMethodDescriptorSupplier("Insert"))
                  .build();
          }
        }
     }
     return getInsertMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysLog.SysLogOuterClass.SysLog,
      com.qianxun.grpc.lib.sysLog.SysLogOuterClass.Result> getUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Update",
      requestType = com.qianxun.grpc.lib.sysLog.SysLogOuterClass.SysLog.class,
      responseType = com.qianxun.grpc.lib.sysLog.SysLogOuterClass.Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysLog.SysLogOuterClass.SysLog,
      com.qianxun.grpc.lib.sysLog.SysLogOuterClass.Result> getUpdateMethod() {
    io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysLog.SysLogOuterClass.SysLog, com.qianxun.grpc.lib.sysLog.SysLogOuterClass.Result> getUpdateMethod;
    if ((getUpdateMethod = SysLogServiceGrpc.getUpdateMethod) == null) {
      synchronized (SysLogServiceGrpc.class) {
        if ((getUpdateMethod = SysLogServiceGrpc.getUpdateMethod) == null) {
          SysLogServiceGrpc.getUpdateMethod = getUpdateMethod = 
              io.grpc.MethodDescriptor.<com.qianxun.grpc.lib.sysLog.SysLogOuterClass.SysLog, com.qianxun.grpc.lib.sysLog.SysLogOuterClass.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "sysLog.SysLogService", "Update"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysLog.SysLogOuterClass.SysLog.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysLog.SysLogOuterClass.Result.getDefaultInstance()))
                  .setSchemaDescriptor(new SysLogServiceMethodDescriptorSupplier("Update"))
                  .build();
          }
        }
     }
     return getUpdateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysLog.SysLogOuterClass.ByIdReq,
      com.qianxun.grpc.lib.sysLog.SysLogOuterClass.Result> getDeleteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Delete",
      requestType = com.qianxun.grpc.lib.sysLog.SysLogOuterClass.ByIdReq.class,
      responseType = com.qianxun.grpc.lib.sysLog.SysLogOuterClass.Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysLog.SysLogOuterClass.ByIdReq,
      com.qianxun.grpc.lib.sysLog.SysLogOuterClass.Result> getDeleteMethod() {
    io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysLog.SysLogOuterClass.ByIdReq, com.qianxun.grpc.lib.sysLog.SysLogOuterClass.Result> getDeleteMethod;
    if ((getDeleteMethod = SysLogServiceGrpc.getDeleteMethod) == null) {
      synchronized (SysLogServiceGrpc.class) {
        if ((getDeleteMethod = SysLogServiceGrpc.getDeleteMethod) == null) {
          SysLogServiceGrpc.getDeleteMethod = getDeleteMethod = 
              io.grpc.MethodDescriptor.<com.qianxun.grpc.lib.sysLog.SysLogOuterClass.ByIdReq, com.qianxun.grpc.lib.sysLog.SysLogOuterClass.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "sysLog.SysLogService", "Delete"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysLog.SysLogOuterClass.ByIdReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysLog.SysLogOuterClass.Result.getDefaultInstance()))
                  .setSchemaDescriptor(new SysLogServiceMethodDescriptorSupplier("Delete"))
                  .build();
          }
        }
     }
     return getDeleteMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SysLogServiceStub newStub(io.grpc.Channel channel) {
    return new SysLogServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SysLogServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SysLogServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SysLogServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SysLogServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class SysLogServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getById(com.qianxun.grpc.lib.sysLog.SysLogOuterClass.ByIdReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysLog.SysLogOuterClass.SysLog> responseObserver) {
      asyncUnimplementedUnaryCall(getGetByIdMethod(), responseObserver);
    }

    /**
     */
    public void getList(com.qianxun.grpc.lib.sysLog.SysLogOuterClass.GetListReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysLog.SysLogOuterClass.PageList> responseObserver) {
      asyncUnimplementedUnaryCall(getGetListMethod(), responseObserver);
    }

    /**
     */
    public void insert(com.qianxun.grpc.lib.sysLog.SysLogOuterClass.BaseSysLog request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysLog.SysLogOuterClass.Result> responseObserver) {
      asyncUnimplementedUnaryCall(getInsertMethod(), responseObserver);
    }

    /**
     */
    public void update(com.qianxun.grpc.lib.sysLog.SysLogOuterClass.SysLog request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysLog.SysLogOuterClass.Result> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateMethod(), responseObserver);
    }

    /**
     */
    public void delete(com.qianxun.grpc.lib.sysLog.SysLogOuterClass.ByIdReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysLog.SysLogOuterClass.Result> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetByIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.qianxun.grpc.lib.sysLog.SysLogOuterClass.ByIdReq,
                com.qianxun.grpc.lib.sysLog.SysLogOuterClass.SysLog>(
                  this, METHODID_GET_BY_ID)))
          .addMethod(
            getGetListMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.qianxun.grpc.lib.sysLog.SysLogOuterClass.GetListReq,
                com.qianxun.grpc.lib.sysLog.SysLogOuterClass.PageList>(
                  this, METHODID_GET_LIST)))
          .addMethod(
            getInsertMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.qianxun.grpc.lib.sysLog.SysLogOuterClass.BaseSysLog,
                com.qianxun.grpc.lib.sysLog.SysLogOuterClass.Result>(
                  this, METHODID_INSERT)))
          .addMethod(
            getUpdateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.qianxun.grpc.lib.sysLog.SysLogOuterClass.SysLog,
                com.qianxun.grpc.lib.sysLog.SysLogOuterClass.Result>(
                  this, METHODID_UPDATE)))
          .addMethod(
            getDeleteMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.qianxun.grpc.lib.sysLog.SysLogOuterClass.ByIdReq,
                com.qianxun.grpc.lib.sysLog.SysLogOuterClass.Result>(
                  this, METHODID_DELETE)))
          .build();
    }
  }

  /**
   */
  public static final class SysLogServiceStub extends io.grpc.stub.AbstractStub<SysLogServiceStub> {
    private SysLogServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SysLogServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SysLogServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SysLogServiceStub(channel, callOptions);
    }

    /**
     */
    public void getById(com.qianxun.grpc.lib.sysLog.SysLogOuterClass.ByIdReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysLog.SysLogOuterClass.SysLog> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getList(com.qianxun.grpc.lib.sysLog.SysLogOuterClass.GetListReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysLog.SysLogOuterClass.PageList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void insert(com.qianxun.grpc.lib.sysLog.SysLogOuterClass.BaseSysLog request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysLog.SysLogOuterClass.Result> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInsertMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void update(com.qianxun.grpc.lib.sysLog.SysLogOuterClass.SysLog request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysLog.SysLogOuterClass.Result> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void delete(com.qianxun.grpc.lib.sysLog.SysLogOuterClass.ByIdReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysLog.SysLogOuterClass.Result> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SysLogServiceBlockingStub extends io.grpc.stub.AbstractStub<SysLogServiceBlockingStub> {
    private SysLogServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SysLogServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SysLogServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SysLogServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.qianxun.grpc.lib.sysLog.SysLogOuterClass.SysLog getById(com.qianxun.grpc.lib.sysLog.SysLogOuterClass.ByIdReq request) {
      return blockingUnaryCall(
          getChannel(), getGetByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.qianxun.grpc.lib.sysLog.SysLogOuterClass.PageList getList(com.qianxun.grpc.lib.sysLog.SysLogOuterClass.GetListReq request) {
      return blockingUnaryCall(
          getChannel(), getGetListMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.qianxun.grpc.lib.sysLog.SysLogOuterClass.Result insert(com.qianxun.grpc.lib.sysLog.SysLogOuterClass.BaseSysLog request) {
      return blockingUnaryCall(
          getChannel(), getInsertMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.qianxun.grpc.lib.sysLog.SysLogOuterClass.Result update(com.qianxun.grpc.lib.sysLog.SysLogOuterClass.SysLog request) {
      return blockingUnaryCall(
          getChannel(), getUpdateMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.qianxun.grpc.lib.sysLog.SysLogOuterClass.Result delete(com.qianxun.grpc.lib.sysLog.SysLogOuterClass.ByIdReq request) {
      return blockingUnaryCall(
          getChannel(), getDeleteMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SysLogServiceFutureStub extends io.grpc.stub.AbstractStub<SysLogServiceFutureStub> {
    private SysLogServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SysLogServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SysLogServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SysLogServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.qianxun.grpc.lib.sysLog.SysLogOuterClass.SysLog> getById(
        com.qianxun.grpc.lib.sysLog.SysLogOuterClass.ByIdReq request) {
      return futureUnaryCall(
          getChannel().newCall(getGetByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.qianxun.grpc.lib.sysLog.SysLogOuterClass.PageList> getList(
        com.qianxun.grpc.lib.sysLog.SysLogOuterClass.GetListReq request) {
      return futureUnaryCall(
          getChannel().newCall(getGetListMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.qianxun.grpc.lib.sysLog.SysLogOuterClass.Result> insert(
        com.qianxun.grpc.lib.sysLog.SysLogOuterClass.BaseSysLog request) {
      return futureUnaryCall(
          getChannel().newCall(getInsertMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.qianxun.grpc.lib.sysLog.SysLogOuterClass.Result> update(
        com.qianxun.grpc.lib.sysLog.SysLogOuterClass.SysLog request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.qianxun.grpc.lib.sysLog.SysLogOuterClass.Result> delete(
        com.qianxun.grpc.lib.sysLog.SysLogOuterClass.ByIdReq request) {
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
    private final SysLogServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SysLogServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_BY_ID:
          serviceImpl.getById((com.qianxun.grpc.lib.sysLog.SysLogOuterClass.ByIdReq) request,
              (io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysLog.SysLogOuterClass.SysLog>) responseObserver);
          break;
        case METHODID_GET_LIST:
          serviceImpl.getList((com.qianxun.grpc.lib.sysLog.SysLogOuterClass.GetListReq) request,
              (io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysLog.SysLogOuterClass.PageList>) responseObserver);
          break;
        case METHODID_INSERT:
          serviceImpl.insert((com.qianxun.grpc.lib.sysLog.SysLogOuterClass.BaseSysLog) request,
              (io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysLog.SysLogOuterClass.Result>) responseObserver);
          break;
        case METHODID_UPDATE:
          serviceImpl.update((com.qianxun.grpc.lib.sysLog.SysLogOuterClass.SysLog) request,
              (io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysLog.SysLogOuterClass.Result>) responseObserver);
          break;
        case METHODID_DELETE:
          serviceImpl.delete((com.qianxun.grpc.lib.sysLog.SysLogOuterClass.ByIdReq) request,
              (io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysLog.SysLogOuterClass.Result>) responseObserver);
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

  private static abstract class SysLogServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SysLogServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.qianxun.grpc.lib.sysLog.SysLogOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SysLogService");
    }
  }

  private static final class SysLogServiceFileDescriptorSupplier
      extends SysLogServiceBaseDescriptorSupplier {
    SysLogServiceFileDescriptorSupplier() {}
  }

  private static final class SysLogServiceMethodDescriptorSupplier
      extends SysLogServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SysLogServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (SysLogServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SysLogServiceFileDescriptorSupplier())
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
