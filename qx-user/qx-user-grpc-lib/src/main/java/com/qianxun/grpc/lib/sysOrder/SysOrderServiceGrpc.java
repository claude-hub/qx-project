package com.qianxun.grpc.lib.sysOrder;

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
    comments = "Source: sys_order.proto")
public final class SysOrderServiceGrpc {

  private SysOrderServiceGrpc() {}

  public static final String SERVICE_NAME = "sysOrder.SysOrderService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.ByIdReq,
      com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.SysOrder> getGetByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetById",
      requestType = com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.ByIdReq.class,
      responseType = com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.SysOrder.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.ByIdReq,
      com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.SysOrder> getGetByIdMethod() {
    io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.ByIdReq, com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.SysOrder> getGetByIdMethod;
    if ((getGetByIdMethod = SysOrderServiceGrpc.getGetByIdMethod) == null) {
      synchronized (SysOrderServiceGrpc.class) {
        if ((getGetByIdMethod = SysOrderServiceGrpc.getGetByIdMethod) == null) {
          SysOrderServiceGrpc.getGetByIdMethod = getGetByIdMethod = 
              io.grpc.MethodDescriptor.<com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.ByIdReq, com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.SysOrder>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "sysOrder.SysOrderService", "GetById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.ByIdReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.SysOrder.getDefaultInstance()))
                  .setSchemaDescriptor(new SysOrderServiceMethodDescriptorSupplier("GetById"))
                  .build();
          }
        }
     }
     return getGetByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.GetListReq,
      com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.PageList> getGetListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetList",
      requestType = com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.GetListReq.class,
      responseType = com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.PageList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.GetListReq,
      com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.PageList> getGetListMethod() {
    io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.GetListReq, com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.PageList> getGetListMethod;
    if ((getGetListMethod = SysOrderServiceGrpc.getGetListMethod) == null) {
      synchronized (SysOrderServiceGrpc.class) {
        if ((getGetListMethod = SysOrderServiceGrpc.getGetListMethod) == null) {
          SysOrderServiceGrpc.getGetListMethod = getGetListMethod = 
              io.grpc.MethodDescriptor.<com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.GetListReq, com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.PageList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "sysOrder.SysOrderService", "GetList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.GetListReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.PageList.getDefaultInstance()))
                  .setSchemaDescriptor(new SysOrderServiceMethodDescriptorSupplier("GetList"))
                  .build();
          }
        }
     }
     return getGetListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.BaseSysOrder,
      com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.Result> getInsertMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Insert",
      requestType = com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.BaseSysOrder.class,
      responseType = com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.BaseSysOrder,
      com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.Result> getInsertMethod() {
    io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.BaseSysOrder, com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.Result> getInsertMethod;
    if ((getInsertMethod = SysOrderServiceGrpc.getInsertMethod) == null) {
      synchronized (SysOrderServiceGrpc.class) {
        if ((getInsertMethod = SysOrderServiceGrpc.getInsertMethod) == null) {
          SysOrderServiceGrpc.getInsertMethod = getInsertMethod = 
              io.grpc.MethodDescriptor.<com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.BaseSysOrder, com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "sysOrder.SysOrderService", "Insert"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.BaseSysOrder.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.Result.getDefaultInstance()))
                  .setSchemaDescriptor(new SysOrderServiceMethodDescriptorSupplier("Insert"))
                  .build();
          }
        }
     }
     return getInsertMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.SysOrder,
      com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.Result> getUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Update",
      requestType = com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.SysOrder.class,
      responseType = com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.SysOrder,
      com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.Result> getUpdateMethod() {
    io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.SysOrder, com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.Result> getUpdateMethod;
    if ((getUpdateMethod = SysOrderServiceGrpc.getUpdateMethod) == null) {
      synchronized (SysOrderServiceGrpc.class) {
        if ((getUpdateMethod = SysOrderServiceGrpc.getUpdateMethod) == null) {
          SysOrderServiceGrpc.getUpdateMethod = getUpdateMethod = 
              io.grpc.MethodDescriptor.<com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.SysOrder, com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "sysOrder.SysOrderService", "Update"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.SysOrder.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.Result.getDefaultInstance()))
                  .setSchemaDescriptor(new SysOrderServiceMethodDescriptorSupplier("Update"))
                  .build();
          }
        }
     }
     return getUpdateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.ByIdReq,
      com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.Result> getDeleteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Delete",
      requestType = com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.ByIdReq.class,
      responseType = com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.ByIdReq,
      com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.Result> getDeleteMethod() {
    io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.ByIdReq, com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.Result> getDeleteMethod;
    if ((getDeleteMethod = SysOrderServiceGrpc.getDeleteMethod) == null) {
      synchronized (SysOrderServiceGrpc.class) {
        if ((getDeleteMethod = SysOrderServiceGrpc.getDeleteMethod) == null) {
          SysOrderServiceGrpc.getDeleteMethod = getDeleteMethod = 
              io.grpc.MethodDescriptor.<com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.ByIdReq, com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "sysOrder.SysOrderService", "Delete"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.ByIdReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.Result.getDefaultInstance()))
                  .setSchemaDescriptor(new SysOrderServiceMethodDescriptorSupplier("Delete"))
                  .build();
          }
        }
     }
     return getDeleteMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SysOrderServiceStub newStub(io.grpc.Channel channel) {
    return new SysOrderServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SysOrderServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SysOrderServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SysOrderServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SysOrderServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class SysOrderServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getById(com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.ByIdReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.SysOrder> responseObserver) {
      asyncUnimplementedUnaryCall(getGetByIdMethod(), responseObserver);
    }

    /**
     */
    public void getList(com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.GetListReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.PageList> responseObserver) {
      asyncUnimplementedUnaryCall(getGetListMethod(), responseObserver);
    }

    /**
     */
    public void insert(com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.BaseSysOrder request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.Result> responseObserver) {
      asyncUnimplementedUnaryCall(getInsertMethod(), responseObserver);
    }

    /**
     */
    public void update(com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.SysOrder request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.Result> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateMethod(), responseObserver);
    }

    /**
     */
    public void delete(com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.ByIdReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.Result> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetByIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.ByIdReq,
                com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.SysOrder>(
                  this, METHODID_GET_BY_ID)))
          .addMethod(
            getGetListMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.GetListReq,
                com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.PageList>(
                  this, METHODID_GET_LIST)))
          .addMethod(
            getInsertMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.BaseSysOrder,
                com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.Result>(
                  this, METHODID_INSERT)))
          .addMethod(
            getUpdateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.SysOrder,
                com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.Result>(
                  this, METHODID_UPDATE)))
          .addMethod(
            getDeleteMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.ByIdReq,
                com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.Result>(
                  this, METHODID_DELETE)))
          .build();
    }
  }

  /**
   */
  public static final class SysOrderServiceStub extends io.grpc.stub.AbstractStub<SysOrderServiceStub> {
    private SysOrderServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SysOrderServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SysOrderServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SysOrderServiceStub(channel, callOptions);
    }

    /**
     */
    public void getById(com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.ByIdReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.SysOrder> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getList(com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.GetListReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.PageList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void insert(com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.BaseSysOrder request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.Result> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInsertMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void update(com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.SysOrder request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.Result> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void delete(com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.ByIdReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.Result> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SysOrderServiceBlockingStub extends io.grpc.stub.AbstractStub<SysOrderServiceBlockingStub> {
    private SysOrderServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SysOrderServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SysOrderServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SysOrderServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.SysOrder getById(com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.ByIdReq request) {
      return blockingUnaryCall(
          getChannel(), getGetByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.PageList getList(com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.GetListReq request) {
      return blockingUnaryCall(
          getChannel(), getGetListMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.Result insert(com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.BaseSysOrder request) {
      return blockingUnaryCall(
          getChannel(), getInsertMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.Result update(com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.SysOrder request) {
      return blockingUnaryCall(
          getChannel(), getUpdateMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.Result delete(com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.ByIdReq request) {
      return blockingUnaryCall(
          getChannel(), getDeleteMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SysOrderServiceFutureStub extends io.grpc.stub.AbstractStub<SysOrderServiceFutureStub> {
    private SysOrderServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SysOrderServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SysOrderServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SysOrderServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.SysOrder> getById(
        com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.ByIdReq request) {
      return futureUnaryCall(
          getChannel().newCall(getGetByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.PageList> getList(
        com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.GetListReq request) {
      return futureUnaryCall(
          getChannel().newCall(getGetListMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.Result> insert(
        com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.BaseSysOrder request) {
      return futureUnaryCall(
          getChannel().newCall(getInsertMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.Result> update(
        com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.SysOrder request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.Result> delete(
        com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.ByIdReq request) {
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
    private final SysOrderServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SysOrderServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_BY_ID:
          serviceImpl.getById((com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.ByIdReq) request,
              (io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.SysOrder>) responseObserver);
          break;
        case METHODID_GET_LIST:
          serviceImpl.getList((com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.GetListReq) request,
              (io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.PageList>) responseObserver);
          break;
        case METHODID_INSERT:
          serviceImpl.insert((com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.BaseSysOrder) request,
              (io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.Result>) responseObserver);
          break;
        case METHODID_UPDATE:
          serviceImpl.update((com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.SysOrder) request,
              (io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.Result>) responseObserver);
          break;
        case METHODID_DELETE:
          serviceImpl.delete((com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.ByIdReq) request,
              (io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.Result>) responseObserver);
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

  private static abstract class SysOrderServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SysOrderServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.qianxun.grpc.lib.sysOrder.SysOrderOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SysOrderService");
    }
  }

  private static final class SysOrderServiceFileDescriptorSupplier
      extends SysOrderServiceBaseDescriptorSupplier {
    SysOrderServiceFileDescriptorSupplier() {}
  }

  private static final class SysOrderServiceMethodDescriptorSupplier
      extends SysOrderServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SysOrderServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (SysOrderServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SysOrderServiceFileDescriptorSupplier())
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
