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
public final class sysDeptServiceGrpc {

  private sysDeptServiceGrpc() {}

  public static final String SERVICE_NAME = "sysDept.sysDeptService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.GetByIdReq,
      com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept> getGetByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetById",
      requestType = com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.GetByIdReq.class,
      responseType = com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.GetByIdReq,
      com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept> getGetByIdMethod() {
    io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.GetByIdReq, com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept> getGetByIdMethod;
    if ((getGetByIdMethod = sysDeptServiceGrpc.getGetByIdMethod) == null) {
      synchronized (sysDeptServiceGrpc.class) {
        if ((getGetByIdMethod = sysDeptServiceGrpc.getGetByIdMethod) == null) {
          sysDeptServiceGrpc.getGetByIdMethod = getGetByIdMethod = 
              io.grpc.MethodDescriptor.<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.GetByIdReq, com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "sysDept.sysDeptService", "GetById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.GetByIdReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept.getDefaultInstance()))
                  .setSchemaDescriptor(new sysDeptServiceMethodDescriptorSupplier("GetById"))
                  .build();
          }
        }
     }
     return getGetByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.GetListReq,
      com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept> getGetListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetList",
      requestType = com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.GetListReq.class,
      responseType = com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.GetListReq,
      com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept> getGetListMethod() {
    io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.GetListReq, com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept> getGetListMethod;
    if ((getGetListMethod = sysDeptServiceGrpc.getGetListMethod) == null) {
      synchronized (sysDeptServiceGrpc.class) {
        if ((getGetListMethod = sysDeptServiceGrpc.getGetListMethod) == null) {
          sysDeptServiceGrpc.getGetListMethod = getGetListMethod = 
              io.grpc.MethodDescriptor.<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.GetListReq, com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "sysDept.sysDeptService", "GetList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.GetListReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept.getDefaultInstance()))
                  .setSchemaDescriptor(new sysDeptServiceMethodDescriptorSupplier("GetList"))
                  .build();
          }
        }
     }
     return getGetListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept,
      com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result> getInsertMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Insert",
      requestType = com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept.class,
      responseType = com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept,
      com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result> getInsertMethod() {
    io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept, com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result> getInsertMethod;
    if ((getInsertMethod = sysDeptServiceGrpc.getInsertMethod) == null) {
      synchronized (sysDeptServiceGrpc.class) {
        if ((getInsertMethod = sysDeptServiceGrpc.getInsertMethod) == null) {
          sysDeptServiceGrpc.getInsertMethod = getInsertMethod = 
              io.grpc.MethodDescriptor.<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept, com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "sysDept.sysDeptService", "Insert"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result.getDefaultInstance()))
                  .setSchemaDescriptor(new sysDeptServiceMethodDescriptorSupplier("Insert"))
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
    if ((getUpdateMethod = sysDeptServiceGrpc.getUpdateMethod) == null) {
      synchronized (sysDeptServiceGrpc.class) {
        if ((getUpdateMethod = sysDeptServiceGrpc.getUpdateMethod) == null) {
          sysDeptServiceGrpc.getUpdateMethod = getUpdateMethod = 
              io.grpc.MethodDescriptor.<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept, com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "sysDept.sysDeptService", "Update"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result.getDefaultInstance()))
                  .setSchemaDescriptor(new sysDeptServiceMethodDescriptorSupplier("Update"))
                  .build();
          }
        }
     }
     return getUpdateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept,
      com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result> getDeleteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Delete",
      requestType = com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept.class,
      responseType = com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept,
      com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result> getDeleteMethod() {
    io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept, com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result> getDeleteMethod;
    if ((getDeleteMethod = sysDeptServiceGrpc.getDeleteMethod) == null) {
      synchronized (sysDeptServiceGrpc.class) {
        if ((getDeleteMethod = sysDeptServiceGrpc.getDeleteMethod) == null) {
          sysDeptServiceGrpc.getDeleteMethod = getDeleteMethod = 
              io.grpc.MethodDescriptor.<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept, com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "sysDept.sysDeptService", "Delete"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result.getDefaultInstance()))
                  .setSchemaDescriptor(new sysDeptServiceMethodDescriptorSupplier("Delete"))
                  .build();
          }
        }
     }
     return getDeleteMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static sysDeptServiceStub newStub(io.grpc.Channel channel) {
    return new sysDeptServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static sysDeptServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new sysDeptServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static sysDeptServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new sysDeptServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class sysDeptServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getById(com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.GetByIdReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept> responseObserver) {
      asyncUnimplementedUnaryCall(getGetByIdMethod(), responseObserver);
    }

    /**
     */
    public void getList(com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.GetListReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept> responseObserver) {
      asyncUnimplementedUnaryCall(getGetListMethod(), responseObserver);
    }

    /**
     */
    public void insert(com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept request,
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
    public void delete(com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetByIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.GetByIdReq,
                com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept>(
                  this, METHODID_GET_BY_ID)))
          .addMethod(
            getGetListMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.GetListReq,
                com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept>(
                  this, METHODID_GET_LIST)))
          .addMethod(
            getInsertMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept,
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
                com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept,
                com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result>(
                  this, METHODID_DELETE)))
          .build();
    }
  }

  /**
   */
  public static final class sysDeptServiceStub extends io.grpc.stub.AbstractStub<sysDeptServiceStub> {
    private sysDeptServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private sysDeptServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected sysDeptServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new sysDeptServiceStub(channel, callOptions);
    }

    /**
     */
    public void getById(com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.GetByIdReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getList(com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.GetListReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void insert(com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept request,
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
    public void delete(com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class sysDeptServiceBlockingStub extends io.grpc.stub.AbstractStub<sysDeptServiceBlockingStub> {
    private sysDeptServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private sysDeptServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected sysDeptServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new sysDeptServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept getById(com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.GetByIdReq request) {
      return blockingUnaryCall(
          getChannel(), getGetByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept> getList(
        com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.GetListReq request) {
      return blockingServerStreamingCall(
          getChannel(), getGetListMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result insert(com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept request) {
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
    public com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result delete(com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept request) {
      return blockingUnaryCall(
          getChannel(), getDeleteMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class sysDeptServiceFutureStub extends io.grpc.stub.AbstractStub<sysDeptServiceFutureStub> {
    private sysDeptServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private sysDeptServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected sysDeptServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new sysDeptServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept> getById(
        com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.GetByIdReq request) {
      return futureUnaryCall(
          getChannel().newCall(getGetByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result> insert(
        com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept request) {
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
        com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept request) {
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
    private final sysDeptServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(sysDeptServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_BY_ID:
          serviceImpl.getById((com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.GetByIdReq) request,
              (io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept>) responseObserver);
          break;
        case METHODID_GET_LIST:
          serviceImpl.getList((com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.GetListReq) request,
              (io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept>) responseObserver);
          break;
        case METHODID_INSERT:
          serviceImpl.insert((com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept) request,
              (io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result>) responseObserver);
          break;
        case METHODID_UPDATE:
          serviceImpl.update((com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept) request,
              (io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.Result>) responseObserver);
          break;
        case METHODID_DELETE:
          serviceImpl.delete((com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.SysDept) request,
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

  private static abstract class sysDeptServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    sysDeptServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.qianxun.grpc.lib.sysDept.SysDeptOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("sysDeptService");
    }
  }

  private static final class sysDeptServiceFileDescriptorSupplier
      extends sysDeptServiceBaseDescriptorSupplier {
    sysDeptServiceFileDescriptorSupplier() {}
  }

  private static final class sysDeptServiceMethodDescriptorSupplier
      extends sysDeptServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    sysDeptServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (sysDeptServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new sysDeptServiceFileDescriptorSupplier())
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
