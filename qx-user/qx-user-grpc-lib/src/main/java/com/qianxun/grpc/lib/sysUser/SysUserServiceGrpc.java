package com.qianxun.grpc.lib.sysUser;

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
    comments = "Source: sys_user.proto")
public final class SysUserServiceGrpc {

  private SysUserServiceGrpc() {}

  public static final String SERVICE_NAME = "sysUser.SysUserService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysUser.SysUserOuterClass.ByIdReq,
      com.qianxun.grpc.lib.sysUser.SysUserOuterClass.SysUser> getGetByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetById",
      requestType = com.qianxun.grpc.lib.sysUser.SysUserOuterClass.ByIdReq.class,
      responseType = com.qianxun.grpc.lib.sysUser.SysUserOuterClass.SysUser.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysUser.SysUserOuterClass.ByIdReq,
      com.qianxun.grpc.lib.sysUser.SysUserOuterClass.SysUser> getGetByIdMethod() {
    io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysUser.SysUserOuterClass.ByIdReq, com.qianxun.grpc.lib.sysUser.SysUserOuterClass.SysUser> getGetByIdMethod;
    if ((getGetByIdMethod = SysUserServiceGrpc.getGetByIdMethod) == null) {
      synchronized (SysUserServiceGrpc.class) {
        if ((getGetByIdMethod = SysUserServiceGrpc.getGetByIdMethod) == null) {
          SysUserServiceGrpc.getGetByIdMethod = getGetByIdMethod = 
              io.grpc.MethodDescriptor.<com.qianxun.grpc.lib.sysUser.SysUserOuterClass.ByIdReq, com.qianxun.grpc.lib.sysUser.SysUserOuterClass.SysUser>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "sysUser.SysUserService", "GetById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysUser.SysUserOuterClass.ByIdReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysUser.SysUserOuterClass.SysUser.getDefaultInstance()))
                  .setSchemaDescriptor(new SysUserServiceMethodDescriptorSupplier("GetById"))
                  .build();
          }
        }
     }
     return getGetByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysUser.SysUserOuterClass.GetListReq,
      com.qianxun.grpc.lib.sysUser.SysUserOuterClass.PageList> getGetListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetList",
      requestType = com.qianxun.grpc.lib.sysUser.SysUserOuterClass.GetListReq.class,
      responseType = com.qianxun.grpc.lib.sysUser.SysUserOuterClass.PageList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysUser.SysUserOuterClass.GetListReq,
      com.qianxun.grpc.lib.sysUser.SysUserOuterClass.PageList> getGetListMethod() {
    io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysUser.SysUserOuterClass.GetListReq, com.qianxun.grpc.lib.sysUser.SysUserOuterClass.PageList> getGetListMethod;
    if ((getGetListMethod = SysUserServiceGrpc.getGetListMethod) == null) {
      synchronized (SysUserServiceGrpc.class) {
        if ((getGetListMethod = SysUserServiceGrpc.getGetListMethod) == null) {
          SysUserServiceGrpc.getGetListMethod = getGetListMethod = 
              io.grpc.MethodDescriptor.<com.qianxun.grpc.lib.sysUser.SysUserOuterClass.GetListReq, com.qianxun.grpc.lib.sysUser.SysUserOuterClass.PageList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "sysUser.SysUserService", "GetList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysUser.SysUserOuterClass.GetListReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysUser.SysUserOuterClass.PageList.getDefaultInstance()))
                  .setSchemaDescriptor(new SysUserServiceMethodDescriptorSupplier("GetList"))
                  .build();
          }
        }
     }
     return getGetListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysUser.SysUserOuterClass.BaseSysUser,
      com.qianxun.grpc.lib.sysUser.SysUserOuterClass.Result> getInsertMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Insert",
      requestType = com.qianxun.grpc.lib.sysUser.SysUserOuterClass.BaseSysUser.class,
      responseType = com.qianxun.grpc.lib.sysUser.SysUserOuterClass.Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysUser.SysUserOuterClass.BaseSysUser,
      com.qianxun.grpc.lib.sysUser.SysUserOuterClass.Result> getInsertMethod() {
    io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysUser.SysUserOuterClass.BaseSysUser, com.qianxun.grpc.lib.sysUser.SysUserOuterClass.Result> getInsertMethod;
    if ((getInsertMethod = SysUserServiceGrpc.getInsertMethod) == null) {
      synchronized (SysUserServiceGrpc.class) {
        if ((getInsertMethod = SysUserServiceGrpc.getInsertMethod) == null) {
          SysUserServiceGrpc.getInsertMethod = getInsertMethod = 
              io.grpc.MethodDescriptor.<com.qianxun.grpc.lib.sysUser.SysUserOuterClass.BaseSysUser, com.qianxun.grpc.lib.sysUser.SysUserOuterClass.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "sysUser.SysUserService", "Insert"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysUser.SysUserOuterClass.BaseSysUser.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysUser.SysUserOuterClass.Result.getDefaultInstance()))
                  .setSchemaDescriptor(new SysUserServiceMethodDescriptorSupplier("Insert"))
                  .build();
          }
        }
     }
     return getInsertMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysUser.SysUserOuterClass.BaseSysUser,
      com.qianxun.grpc.lib.sysUser.SysUserOuterClass.Result> getUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Update",
      requestType = com.qianxun.grpc.lib.sysUser.SysUserOuterClass.BaseSysUser.class,
      responseType = com.qianxun.grpc.lib.sysUser.SysUserOuterClass.Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysUser.SysUserOuterClass.BaseSysUser,
      com.qianxun.grpc.lib.sysUser.SysUserOuterClass.Result> getUpdateMethod() {
    io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysUser.SysUserOuterClass.BaseSysUser, com.qianxun.grpc.lib.sysUser.SysUserOuterClass.Result> getUpdateMethod;
    if ((getUpdateMethod = SysUserServiceGrpc.getUpdateMethod) == null) {
      synchronized (SysUserServiceGrpc.class) {
        if ((getUpdateMethod = SysUserServiceGrpc.getUpdateMethod) == null) {
          SysUserServiceGrpc.getUpdateMethod = getUpdateMethod = 
              io.grpc.MethodDescriptor.<com.qianxun.grpc.lib.sysUser.SysUserOuterClass.BaseSysUser, com.qianxun.grpc.lib.sysUser.SysUserOuterClass.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "sysUser.SysUserService", "Update"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysUser.SysUserOuterClass.BaseSysUser.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysUser.SysUserOuterClass.Result.getDefaultInstance()))
                  .setSchemaDescriptor(new SysUserServiceMethodDescriptorSupplier("Update"))
                  .build();
          }
        }
     }
     return getUpdateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysUser.SysUserOuterClass.ByIdReq,
      com.qianxun.grpc.lib.sysUser.SysUserOuterClass.Result> getDeleteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Delete",
      requestType = com.qianxun.grpc.lib.sysUser.SysUserOuterClass.ByIdReq.class,
      responseType = com.qianxun.grpc.lib.sysUser.SysUserOuterClass.Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysUser.SysUserOuterClass.ByIdReq,
      com.qianxun.grpc.lib.sysUser.SysUserOuterClass.Result> getDeleteMethod() {
    io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysUser.SysUserOuterClass.ByIdReq, com.qianxun.grpc.lib.sysUser.SysUserOuterClass.Result> getDeleteMethod;
    if ((getDeleteMethod = SysUserServiceGrpc.getDeleteMethod) == null) {
      synchronized (SysUserServiceGrpc.class) {
        if ((getDeleteMethod = SysUserServiceGrpc.getDeleteMethod) == null) {
          SysUserServiceGrpc.getDeleteMethod = getDeleteMethod = 
              io.grpc.MethodDescriptor.<com.qianxun.grpc.lib.sysUser.SysUserOuterClass.ByIdReq, com.qianxun.grpc.lib.sysUser.SysUserOuterClass.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "sysUser.SysUserService", "Delete"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysUser.SysUserOuterClass.ByIdReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysUser.SysUserOuterClass.Result.getDefaultInstance()))
                  .setSchemaDescriptor(new SysUserServiceMethodDescriptorSupplier("Delete"))
                  .build();
          }
        }
     }
     return getDeleteMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SysUserServiceStub newStub(io.grpc.Channel channel) {
    return new SysUserServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SysUserServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SysUserServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SysUserServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SysUserServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class SysUserServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getById(com.qianxun.grpc.lib.sysUser.SysUserOuterClass.ByIdReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysUser.SysUserOuterClass.SysUser> responseObserver) {
      asyncUnimplementedUnaryCall(getGetByIdMethod(), responseObserver);
    }

    /**
     */
    public void getList(com.qianxun.grpc.lib.sysUser.SysUserOuterClass.GetListReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysUser.SysUserOuterClass.PageList> responseObserver) {
      asyncUnimplementedUnaryCall(getGetListMethod(), responseObserver);
    }

    /**
     */
    public void insert(com.qianxun.grpc.lib.sysUser.SysUserOuterClass.BaseSysUser request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysUser.SysUserOuterClass.Result> responseObserver) {
      asyncUnimplementedUnaryCall(getInsertMethod(), responseObserver);
    }

    /**
     */
    public void update(com.qianxun.grpc.lib.sysUser.SysUserOuterClass.BaseSysUser request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysUser.SysUserOuterClass.Result> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateMethod(), responseObserver);
    }

    /**
     */
    public void delete(com.qianxun.grpc.lib.sysUser.SysUserOuterClass.ByIdReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysUser.SysUserOuterClass.Result> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetByIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.qianxun.grpc.lib.sysUser.SysUserOuterClass.ByIdReq,
                com.qianxun.grpc.lib.sysUser.SysUserOuterClass.SysUser>(
                  this, METHODID_GET_BY_ID)))
          .addMethod(
            getGetListMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.qianxun.grpc.lib.sysUser.SysUserOuterClass.GetListReq,
                com.qianxun.grpc.lib.sysUser.SysUserOuterClass.PageList>(
                  this, METHODID_GET_LIST)))
          .addMethod(
            getInsertMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.qianxun.grpc.lib.sysUser.SysUserOuterClass.BaseSysUser,
                com.qianxun.grpc.lib.sysUser.SysUserOuterClass.Result>(
                  this, METHODID_INSERT)))
          .addMethod(
            getUpdateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.qianxun.grpc.lib.sysUser.SysUserOuterClass.BaseSysUser,
                com.qianxun.grpc.lib.sysUser.SysUserOuterClass.Result>(
                  this, METHODID_UPDATE)))
          .addMethod(
            getDeleteMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.qianxun.grpc.lib.sysUser.SysUserOuterClass.ByIdReq,
                com.qianxun.grpc.lib.sysUser.SysUserOuterClass.Result>(
                  this, METHODID_DELETE)))
          .build();
    }
  }

  /**
   */
  public static final class SysUserServiceStub extends io.grpc.stub.AbstractStub<SysUserServiceStub> {
    private SysUserServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SysUserServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SysUserServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SysUserServiceStub(channel, callOptions);
    }

    /**
     */
    public void getById(com.qianxun.grpc.lib.sysUser.SysUserOuterClass.ByIdReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysUser.SysUserOuterClass.SysUser> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getList(com.qianxun.grpc.lib.sysUser.SysUserOuterClass.GetListReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysUser.SysUserOuterClass.PageList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void insert(com.qianxun.grpc.lib.sysUser.SysUserOuterClass.BaseSysUser request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysUser.SysUserOuterClass.Result> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInsertMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void update(com.qianxun.grpc.lib.sysUser.SysUserOuterClass.BaseSysUser request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysUser.SysUserOuterClass.Result> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void delete(com.qianxun.grpc.lib.sysUser.SysUserOuterClass.ByIdReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysUser.SysUserOuterClass.Result> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SysUserServiceBlockingStub extends io.grpc.stub.AbstractStub<SysUserServiceBlockingStub> {
    private SysUserServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SysUserServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SysUserServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SysUserServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.qianxun.grpc.lib.sysUser.SysUserOuterClass.SysUser getById(com.qianxun.grpc.lib.sysUser.SysUserOuterClass.ByIdReq request) {
      return blockingUnaryCall(
          getChannel(), getGetByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.qianxun.grpc.lib.sysUser.SysUserOuterClass.PageList getList(com.qianxun.grpc.lib.sysUser.SysUserOuterClass.GetListReq request) {
      return blockingUnaryCall(
          getChannel(), getGetListMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.qianxun.grpc.lib.sysUser.SysUserOuterClass.Result insert(com.qianxun.grpc.lib.sysUser.SysUserOuterClass.BaseSysUser request) {
      return blockingUnaryCall(
          getChannel(), getInsertMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.qianxun.grpc.lib.sysUser.SysUserOuterClass.Result update(com.qianxun.grpc.lib.sysUser.SysUserOuterClass.BaseSysUser request) {
      return blockingUnaryCall(
          getChannel(), getUpdateMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.qianxun.grpc.lib.sysUser.SysUserOuterClass.Result delete(com.qianxun.grpc.lib.sysUser.SysUserOuterClass.ByIdReq request) {
      return blockingUnaryCall(
          getChannel(), getDeleteMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SysUserServiceFutureStub extends io.grpc.stub.AbstractStub<SysUserServiceFutureStub> {
    private SysUserServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SysUserServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SysUserServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SysUserServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.qianxun.grpc.lib.sysUser.SysUserOuterClass.SysUser> getById(
        com.qianxun.grpc.lib.sysUser.SysUserOuterClass.ByIdReq request) {
      return futureUnaryCall(
          getChannel().newCall(getGetByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.qianxun.grpc.lib.sysUser.SysUserOuterClass.PageList> getList(
        com.qianxun.grpc.lib.sysUser.SysUserOuterClass.GetListReq request) {
      return futureUnaryCall(
          getChannel().newCall(getGetListMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.qianxun.grpc.lib.sysUser.SysUserOuterClass.Result> insert(
        com.qianxun.grpc.lib.sysUser.SysUserOuterClass.BaseSysUser request) {
      return futureUnaryCall(
          getChannel().newCall(getInsertMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.qianxun.grpc.lib.sysUser.SysUserOuterClass.Result> update(
        com.qianxun.grpc.lib.sysUser.SysUserOuterClass.BaseSysUser request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.qianxun.grpc.lib.sysUser.SysUserOuterClass.Result> delete(
        com.qianxun.grpc.lib.sysUser.SysUserOuterClass.ByIdReq request) {
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
    private final SysUserServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SysUserServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_BY_ID:
          serviceImpl.getById((com.qianxun.grpc.lib.sysUser.SysUserOuterClass.ByIdReq) request,
              (io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysUser.SysUserOuterClass.SysUser>) responseObserver);
          break;
        case METHODID_GET_LIST:
          serviceImpl.getList((com.qianxun.grpc.lib.sysUser.SysUserOuterClass.GetListReq) request,
              (io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysUser.SysUserOuterClass.PageList>) responseObserver);
          break;
        case METHODID_INSERT:
          serviceImpl.insert((com.qianxun.grpc.lib.sysUser.SysUserOuterClass.BaseSysUser) request,
              (io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysUser.SysUserOuterClass.Result>) responseObserver);
          break;
        case METHODID_UPDATE:
          serviceImpl.update((com.qianxun.grpc.lib.sysUser.SysUserOuterClass.BaseSysUser) request,
              (io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysUser.SysUserOuterClass.Result>) responseObserver);
          break;
        case METHODID_DELETE:
          serviceImpl.delete((com.qianxun.grpc.lib.sysUser.SysUserOuterClass.ByIdReq) request,
              (io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysUser.SysUserOuterClass.Result>) responseObserver);
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

  private static abstract class SysUserServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SysUserServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.qianxun.grpc.lib.sysUser.SysUserOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SysUserService");
    }
  }

  private static final class SysUserServiceFileDescriptorSupplier
      extends SysUserServiceBaseDescriptorSupplier {
    SysUserServiceFileDescriptorSupplier() {}
  }

  private static final class SysUserServiceMethodDescriptorSupplier
      extends SysUserServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SysUserServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (SysUserServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SysUserServiceFileDescriptorSupplier())
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
