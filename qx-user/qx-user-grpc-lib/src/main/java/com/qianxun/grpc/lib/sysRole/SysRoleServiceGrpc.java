package com.qianxun.grpc.lib.sysRole;

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
    comments = "Source: sys_role.proto")
public final class SysRoleServiceGrpc {

  private SysRoleServiceGrpc() {}

  public static final String SERVICE_NAME = "sysRole.SysRoleService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.ByIdReq,
      com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.SysRole> getGetByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetById",
      requestType = com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.ByIdReq.class,
      responseType = com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.SysRole.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.ByIdReq,
      com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.SysRole> getGetByIdMethod() {
    io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.ByIdReq, com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.SysRole> getGetByIdMethod;
    if ((getGetByIdMethod = SysRoleServiceGrpc.getGetByIdMethod) == null) {
      synchronized (SysRoleServiceGrpc.class) {
        if ((getGetByIdMethod = SysRoleServiceGrpc.getGetByIdMethod) == null) {
          SysRoleServiceGrpc.getGetByIdMethod = getGetByIdMethod = 
              io.grpc.MethodDescriptor.<com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.ByIdReq, com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.SysRole>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "sysRole.SysRoleService", "GetById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.ByIdReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.SysRole.getDefaultInstance()))
                  .setSchemaDescriptor(new SysRoleServiceMethodDescriptorSupplier("GetById"))
                  .build();
          }
        }
     }
     return getGetByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.GetListReq,
      com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.PageList> getGetListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetList",
      requestType = com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.GetListReq.class,
      responseType = com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.PageList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.GetListReq,
      com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.PageList> getGetListMethod() {
    io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.GetListReq, com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.PageList> getGetListMethod;
    if ((getGetListMethod = SysRoleServiceGrpc.getGetListMethod) == null) {
      synchronized (SysRoleServiceGrpc.class) {
        if ((getGetListMethod = SysRoleServiceGrpc.getGetListMethod) == null) {
          SysRoleServiceGrpc.getGetListMethod = getGetListMethod = 
              io.grpc.MethodDescriptor.<com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.GetListReq, com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.PageList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "sysRole.SysRoleService", "GetList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.GetListReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.PageList.getDefaultInstance()))
                  .setSchemaDescriptor(new SysRoleServiceMethodDescriptorSupplier("GetList"))
                  .build();
          }
        }
     }
     return getGetListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.BaseSysRole,
      com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.Result> getInsertMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Insert",
      requestType = com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.BaseSysRole.class,
      responseType = com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.BaseSysRole,
      com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.Result> getInsertMethod() {
    io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.BaseSysRole, com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.Result> getInsertMethod;
    if ((getInsertMethod = SysRoleServiceGrpc.getInsertMethod) == null) {
      synchronized (SysRoleServiceGrpc.class) {
        if ((getInsertMethod = SysRoleServiceGrpc.getInsertMethod) == null) {
          SysRoleServiceGrpc.getInsertMethod = getInsertMethod = 
              io.grpc.MethodDescriptor.<com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.BaseSysRole, com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "sysRole.SysRoleService", "Insert"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.BaseSysRole.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.Result.getDefaultInstance()))
                  .setSchemaDescriptor(new SysRoleServiceMethodDescriptorSupplier("Insert"))
                  .build();
          }
        }
     }
     return getInsertMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.SysRole,
      com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.Result> getUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Update",
      requestType = com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.SysRole.class,
      responseType = com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.SysRole,
      com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.Result> getUpdateMethod() {
    io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.SysRole, com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.Result> getUpdateMethod;
    if ((getUpdateMethod = SysRoleServiceGrpc.getUpdateMethod) == null) {
      synchronized (SysRoleServiceGrpc.class) {
        if ((getUpdateMethod = SysRoleServiceGrpc.getUpdateMethod) == null) {
          SysRoleServiceGrpc.getUpdateMethod = getUpdateMethod = 
              io.grpc.MethodDescriptor.<com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.SysRole, com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "sysRole.SysRoleService", "Update"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.SysRole.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.Result.getDefaultInstance()))
                  .setSchemaDescriptor(new SysRoleServiceMethodDescriptorSupplier("Update"))
                  .build();
          }
        }
     }
     return getUpdateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.ByIdReq,
      com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.Result> getDeleteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Delete",
      requestType = com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.ByIdReq.class,
      responseType = com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.ByIdReq,
      com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.Result> getDeleteMethod() {
    io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.ByIdReq, com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.Result> getDeleteMethod;
    if ((getDeleteMethod = SysRoleServiceGrpc.getDeleteMethod) == null) {
      synchronized (SysRoleServiceGrpc.class) {
        if ((getDeleteMethod = SysRoleServiceGrpc.getDeleteMethod) == null) {
          SysRoleServiceGrpc.getDeleteMethod = getDeleteMethod = 
              io.grpc.MethodDescriptor.<com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.ByIdReq, com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "sysRole.SysRoleService", "Delete"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.ByIdReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.Result.getDefaultInstance()))
                  .setSchemaDescriptor(new SysRoleServiceMethodDescriptorSupplier("Delete"))
                  .build();
          }
        }
     }
     return getDeleteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.RolePermsReq,
      com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.Result> getAddRolePermsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddRolePerms",
      requestType = com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.RolePermsReq.class,
      responseType = com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.RolePermsReq,
      com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.Result> getAddRolePermsMethod() {
    io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.RolePermsReq, com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.Result> getAddRolePermsMethod;
    if ((getAddRolePermsMethod = SysRoleServiceGrpc.getAddRolePermsMethod) == null) {
      synchronized (SysRoleServiceGrpc.class) {
        if ((getAddRolePermsMethod = SysRoleServiceGrpc.getAddRolePermsMethod) == null) {
          SysRoleServiceGrpc.getAddRolePermsMethod = getAddRolePermsMethod = 
              io.grpc.MethodDescriptor.<com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.RolePermsReq, com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "sysRole.SysRoleService", "AddRolePerms"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.RolePermsReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.Result.getDefaultInstance()))
                  .setSchemaDescriptor(new SysRoleServiceMethodDescriptorSupplier("AddRolePerms"))
                  .build();
          }
        }
     }
     return getAddRolePermsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SysRoleServiceStub newStub(io.grpc.Channel channel) {
    return new SysRoleServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SysRoleServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SysRoleServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SysRoleServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SysRoleServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class SysRoleServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getById(com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.ByIdReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.SysRole> responseObserver) {
      asyncUnimplementedUnaryCall(getGetByIdMethod(), responseObserver);
    }

    /**
     */
    public void getList(com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.GetListReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.PageList> responseObserver) {
      asyncUnimplementedUnaryCall(getGetListMethod(), responseObserver);
    }

    /**
     */
    public void insert(com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.BaseSysRole request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.Result> responseObserver) {
      asyncUnimplementedUnaryCall(getInsertMethod(), responseObserver);
    }

    /**
     */
    public void update(com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.SysRole request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.Result> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateMethod(), responseObserver);
    }

    /**
     */
    public void delete(com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.ByIdReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.Result> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteMethod(), responseObserver);
    }

    /**
     */
    public void addRolePerms(com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.RolePermsReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.Result> responseObserver) {
      asyncUnimplementedUnaryCall(getAddRolePermsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetByIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.ByIdReq,
                com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.SysRole>(
                  this, METHODID_GET_BY_ID)))
          .addMethod(
            getGetListMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.GetListReq,
                com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.PageList>(
                  this, METHODID_GET_LIST)))
          .addMethod(
            getInsertMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.BaseSysRole,
                com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.Result>(
                  this, METHODID_INSERT)))
          .addMethod(
            getUpdateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.SysRole,
                com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.Result>(
                  this, METHODID_UPDATE)))
          .addMethod(
            getDeleteMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.ByIdReq,
                com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.Result>(
                  this, METHODID_DELETE)))
          .addMethod(
            getAddRolePermsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.RolePermsReq,
                com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.Result>(
                  this, METHODID_ADD_ROLE_PERMS)))
          .build();
    }
  }

  /**
   */
  public static final class SysRoleServiceStub extends io.grpc.stub.AbstractStub<SysRoleServiceStub> {
    private SysRoleServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SysRoleServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SysRoleServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SysRoleServiceStub(channel, callOptions);
    }

    /**
     */
    public void getById(com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.ByIdReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.SysRole> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getList(com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.GetListReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.PageList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void insert(com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.BaseSysRole request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.Result> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInsertMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void update(com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.SysRole request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.Result> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void delete(com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.ByIdReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.Result> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addRolePerms(com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.RolePermsReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.Result> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddRolePermsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SysRoleServiceBlockingStub extends io.grpc.stub.AbstractStub<SysRoleServiceBlockingStub> {
    private SysRoleServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SysRoleServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SysRoleServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SysRoleServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.SysRole getById(com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.ByIdReq request) {
      return blockingUnaryCall(
          getChannel(), getGetByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.PageList getList(com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.GetListReq request) {
      return blockingUnaryCall(
          getChannel(), getGetListMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.Result insert(com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.BaseSysRole request) {
      return blockingUnaryCall(
          getChannel(), getInsertMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.Result update(com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.SysRole request) {
      return blockingUnaryCall(
          getChannel(), getUpdateMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.Result delete(com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.ByIdReq request) {
      return blockingUnaryCall(
          getChannel(), getDeleteMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.Result addRolePerms(com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.RolePermsReq request) {
      return blockingUnaryCall(
          getChannel(), getAddRolePermsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SysRoleServiceFutureStub extends io.grpc.stub.AbstractStub<SysRoleServiceFutureStub> {
    private SysRoleServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SysRoleServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SysRoleServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SysRoleServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.SysRole> getById(
        com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.ByIdReq request) {
      return futureUnaryCall(
          getChannel().newCall(getGetByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.PageList> getList(
        com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.GetListReq request) {
      return futureUnaryCall(
          getChannel().newCall(getGetListMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.Result> insert(
        com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.BaseSysRole request) {
      return futureUnaryCall(
          getChannel().newCall(getInsertMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.Result> update(
        com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.SysRole request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.Result> delete(
        com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.ByIdReq request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.Result> addRolePerms(
        com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.RolePermsReq request) {
      return futureUnaryCall(
          getChannel().newCall(getAddRolePermsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_BY_ID = 0;
  private static final int METHODID_GET_LIST = 1;
  private static final int METHODID_INSERT = 2;
  private static final int METHODID_UPDATE = 3;
  private static final int METHODID_DELETE = 4;
  private static final int METHODID_ADD_ROLE_PERMS = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SysRoleServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SysRoleServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_BY_ID:
          serviceImpl.getById((com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.ByIdReq) request,
              (io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.SysRole>) responseObserver);
          break;
        case METHODID_GET_LIST:
          serviceImpl.getList((com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.GetListReq) request,
              (io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.PageList>) responseObserver);
          break;
        case METHODID_INSERT:
          serviceImpl.insert((com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.BaseSysRole) request,
              (io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.Result>) responseObserver);
          break;
        case METHODID_UPDATE:
          serviceImpl.update((com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.SysRole) request,
              (io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.Result>) responseObserver);
          break;
        case METHODID_DELETE:
          serviceImpl.delete((com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.ByIdReq) request,
              (io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.Result>) responseObserver);
          break;
        case METHODID_ADD_ROLE_PERMS:
          serviceImpl.addRolePerms((com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.RolePermsReq) request,
              (io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.Result>) responseObserver);
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

  private static abstract class SysRoleServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SysRoleServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.qianxun.grpc.lib.sysRole.SysRoleOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SysRoleService");
    }
  }

  private static final class SysRoleServiceFileDescriptorSupplier
      extends SysRoleServiceBaseDescriptorSupplier {
    SysRoleServiceFileDescriptorSupplier() {}
  }

  private static final class SysRoleServiceMethodDescriptorSupplier
      extends SysRoleServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SysRoleServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (SysRoleServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SysRoleServiceFileDescriptorSupplier())
              .addMethod(getGetByIdMethod())
              .addMethod(getGetListMethod())
              .addMethod(getInsertMethod())
              .addMethod(getUpdateMethod())
              .addMethod(getDeleteMethod())
              .addMethod(getAddRolePermsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
