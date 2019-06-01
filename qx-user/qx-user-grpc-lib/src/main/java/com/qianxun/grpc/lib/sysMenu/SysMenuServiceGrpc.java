package com.qianxun.grpc.lib.sysMenu;

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
    comments = "Source: sys_menu.proto")
public final class SysMenuServiceGrpc {

  private SysMenuServiceGrpc() {}

  public static final String SERVICE_NAME = "sysMenu.SysMenuService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.ByIdReq,
      com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.SysMenu> getGetByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetById",
      requestType = com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.ByIdReq.class,
      responseType = com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.SysMenu.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.ByIdReq,
      com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.SysMenu> getGetByIdMethod() {
    io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.ByIdReq, com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.SysMenu> getGetByIdMethod;
    if ((getGetByIdMethod = SysMenuServiceGrpc.getGetByIdMethod) == null) {
      synchronized (SysMenuServiceGrpc.class) {
        if ((getGetByIdMethod = SysMenuServiceGrpc.getGetByIdMethod) == null) {
          SysMenuServiceGrpc.getGetByIdMethod = getGetByIdMethod = 
              io.grpc.MethodDescriptor.<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.ByIdReq, com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.SysMenu>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "sysMenu.SysMenuService", "GetById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.ByIdReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.SysMenu.getDefaultInstance()))
                  .setSchemaDescriptor(new SysMenuServiceMethodDescriptorSupplier("GetById"))
                  .build();
          }
        }
     }
     return getGetByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.GetListReq,
      com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.PageList> getGetListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetList",
      requestType = com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.GetListReq.class,
      responseType = com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.PageList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.GetListReq,
      com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.PageList> getGetListMethod() {
    io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.GetListReq, com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.PageList> getGetListMethod;
    if ((getGetListMethod = SysMenuServiceGrpc.getGetListMethod) == null) {
      synchronized (SysMenuServiceGrpc.class) {
        if ((getGetListMethod = SysMenuServiceGrpc.getGetListMethod) == null) {
          SysMenuServiceGrpc.getGetListMethod = getGetListMethod = 
              io.grpc.MethodDescriptor.<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.GetListReq, com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.PageList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "sysMenu.SysMenuService", "GetList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.GetListReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.PageList.getDefaultInstance()))
                  .setSchemaDescriptor(new SysMenuServiceMethodDescriptorSupplier("GetList"))
                  .build();
          }
        }
     }
     return getGetListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.BaseSysMenu,
      com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.Result> getInsertMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Insert",
      requestType = com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.BaseSysMenu.class,
      responseType = com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.BaseSysMenu,
      com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.Result> getInsertMethod() {
    io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.BaseSysMenu, com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.Result> getInsertMethod;
    if ((getInsertMethod = SysMenuServiceGrpc.getInsertMethod) == null) {
      synchronized (SysMenuServiceGrpc.class) {
        if ((getInsertMethod = SysMenuServiceGrpc.getInsertMethod) == null) {
          SysMenuServiceGrpc.getInsertMethod = getInsertMethod = 
              io.grpc.MethodDescriptor.<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.BaseSysMenu, com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "sysMenu.SysMenuService", "Insert"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.BaseSysMenu.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.Result.getDefaultInstance()))
                  .setSchemaDescriptor(new SysMenuServiceMethodDescriptorSupplier("Insert"))
                  .build();
          }
        }
     }
     return getInsertMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.SysMenu,
      com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.Result> getUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Update",
      requestType = com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.SysMenu.class,
      responseType = com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.SysMenu,
      com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.Result> getUpdateMethod() {
    io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.SysMenu, com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.Result> getUpdateMethod;
    if ((getUpdateMethod = SysMenuServiceGrpc.getUpdateMethod) == null) {
      synchronized (SysMenuServiceGrpc.class) {
        if ((getUpdateMethod = SysMenuServiceGrpc.getUpdateMethod) == null) {
          SysMenuServiceGrpc.getUpdateMethod = getUpdateMethod = 
              io.grpc.MethodDescriptor.<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.SysMenu, com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "sysMenu.SysMenuService", "Update"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.SysMenu.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.Result.getDefaultInstance()))
                  .setSchemaDescriptor(new SysMenuServiceMethodDescriptorSupplier("Update"))
                  .build();
          }
        }
     }
     return getUpdateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.ByIdReq,
      com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.Result> getDeleteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Delete",
      requestType = com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.ByIdReq.class,
      responseType = com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.Result.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.ByIdReq,
      com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.Result> getDeleteMethod() {
    io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.ByIdReq, com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.Result> getDeleteMethod;
    if ((getDeleteMethod = SysMenuServiceGrpc.getDeleteMethod) == null) {
      synchronized (SysMenuServiceGrpc.class) {
        if ((getDeleteMethod = SysMenuServiceGrpc.getDeleteMethod) == null) {
          SysMenuServiceGrpc.getDeleteMethod = getDeleteMethod = 
              io.grpc.MethodDescriptor.<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.ByIdReq, com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.Result>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "sysMenu.SysMenuService", "Delete"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.ByIdReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.Result.getDefaultInstance()))
                  .setSchemaDescriptor(new SysMenuServiceMethodDescriptorSupplier("Delete"))
                  .build();
          }
        }
     }
     return getDeleteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.ByIdReq,
      com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.SysMenu> getGetUserMenusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUserMenus",
      requestType = com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.ByIdReq.class,
      responseType = com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.SysMenu.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.ByIdReq,
      com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.SysMenu> getGetUserMenusMethod() {
    io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.ByIdReq, com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.SysMenu> getGetUserMenusMethod;
    if ((getGetUserMenusMethod = SysMenuServiceGrpc.getGetUserMenusMethod) == null) {
      synchronized (SysMenuServiceGrpc.class) {
        if ((getGetUserMenusMethod = SysMenuServiceGrpc.getGetUserMenusMethod) == null) {
          SysMenuServiceGrpc.getGetUserMenusMethod = getGetUserMenusMethod = 
              io.grpc.MethodDescriptor.<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.ByIdReq, com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.SysMenu>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "sysMenu.SysMenuService", "GetUserMenus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.ByIdReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.SysMenu.getDefaultInstance()))
                  .setSchemaDescriptor(new SysMenuServiceMethodDescriptorSupplier("GetUserMenus"))
                  .build();
          }
        }
     }
     return getGetUserMenusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.GetListReq,
      com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.SysMenu> getGetAllListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllList",
      requestType = com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.GetListReq.class,
      responseType = com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.SysMenu.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.GetListReq,
      com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.SysMenu> getGetAllListMethod() {
    io.grpc.MethodDescriptor<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.GetListReq, com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.SysMenu> getGetAllListMethod;
    if ((getGetAllListMethod = SysMenuServiceGrpc.getGetAllListMethod) == null) {
      synchronized (SysMenuServiceGrpc.class) {
        if ((getGetAllListMethod = SysMenuServiceGrpc.getGetAllListMethod) == null) {
          SysMenuServiceGrpc.getGetAllListMethod = getGetAllListMethod = 
              io.grpc.MethodDescriptor.<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.GetListReq, com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.SysMenu>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "sysMenu.SysMenuService", "GetAllList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.GetListReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.SysMenu.getDefaultInstance()))
                  .setSchemaDescriptor(new SysMenuServiceMethodDescriptorSupplier("GetAllList"))
                  .build();
          }
        }
     }
     return getGetAllListMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SysMenuServiceStub newStub(io.grpc.Channel channel) {
    return new SysMenuServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SysMenuServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SysMenuServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SysMenuServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SysMenuServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class SysMenuServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getById(com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.ByIdReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.SysMenu> responseObserver) {
      asyncUnimplementedUnaryCall(getGetByIdMethod(), responseObserver);
    }

    /**
     */
    public void getList(com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.GetListReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.PageList> responseObserver) {
      asyncUnimplementedUnaryCall(getGetListMethod(), responseObserver);
    }

    /**
     */
    public void insert(com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.BaseSysMenu request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.Result> responseObserver) {
      asyncUnimplementedUnaryCall(getInsertMethod(), responseObserver);
    }

    /**
     */
    public void update(com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.SysMenu request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.Result> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateMethod(), responseObserver);
    }

    /**
     */
    public void delete(com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.ByIdReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.Result> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteMethod(), responseObserver);
    }

    /**
     */
    public void getUserMenus(com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.ByIdReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.SysMenu> responseObserver) {
      asyncUnimplementedUnaryCall(getGetUserMenusMethod(), responseObserver);
    }

    /**
     */
    public void getAllList(com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.GetListReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.SysMenu> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllListMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetByIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.ByIdReq,
                com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.SysMenu>(
                  this, METHODID_GET_BY_ID)))
          .addMethod(
            getGetListMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.GetListReq,
                com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.PageList>(
                  this, METHODID_GET_LIST)))
          .addMethod(
            getInsertMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.BaseSysMenu,
                com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.Result>(
                  this, METHODID_INSERT)))
          .addMethod(
            getUpdateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.SysMenu,
                com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.Result>(
                  this, METHODID_UPDATE)))
          .addMethod(
            getDeleteMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.ByIdReq,
                com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.Result>(
                  this, METHODID_DELETE)))
          .addMethod(
            getGetUserMenusMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.ByIdReq,
                com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.SysMenu>(
                  this, METHODID_GET_USER_MENUS)))
          .addMethod(
            getGetAllListMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.GetListReq,
                com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.SysMenu>(
                  this, METHODID_GET_ALL_LIST)))
          .build();
    }
  }

  /**
   */
  public static final class SysMenuServiceStub extends io.grpc.stub.AbstractStub<SysMenuServiceStub> {
    private SysMenuServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SysMenuServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SysMenuServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SysMenuServiceStub(channel, callOptions);
    }

    /**
     */
    public void getById(com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.ByIdReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.SysMenu> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getList(com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.GetListReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.PageList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void insert(com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.BaseSysMenu request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.Result> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getInsertMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void update(com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.SysMenu request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.Result> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void delete(com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.ByIdReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.Result> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getUserMenus(com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.ByIdReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.SysMenu> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetUserMenusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllList(com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.GetListReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.SysMenu> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetAllListMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SysMenuServiceBlockingStub extends io.grpc.stub.AbstractStub<SysMenuServiceBlockingStub> {
    private SysMenuServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SysMenuServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SysMenuServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SysMenuServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.SysMenu getById(com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.ByIdReq request) {
      return blockingUnaryCall(
          getChannel(), getGetByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.PageList getList(com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.GetListReq request) {
      return blockingUnaryCall(
          getChannel(), getGetListMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.Result insert(com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.BaseSysMenu request) {
      return blockingUnaryCall(
          getChannel(), getInsertMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.Result update(com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.SysMenu request) {
      return blockingUnaryCall(
          getChannel(), getUpdateMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.Result delete(com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.ByIdReq request) {
      return blockingUnaryCall(
          getChannel(), getDeleteMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.SysMenu> getUserMenus(
        com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.ByIdReq request) {
      return blockingServerStreamingCall(
          getChannel(), getGetUserMenusMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.SysMenu> getAllList(
        com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.GetListReq request) {
      return blockingServerStreamingCall(
          getChannel(), getGetAllListMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SysMenuServiceFutureStub extends io.grpc.stub.AbstractStub<SysMenuServiceFutureStub> {
    private SysMenuServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SysMenuServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SysMenuServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SysMenuServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.SysMenu> getById(
        com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.ByIdReq request) {
      return futureUnaryCall(
          getChannel().newCall(getGetByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.PageList> getList(
        com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.GetListReq request) {
      return futureUnaryCall(
          getChannel().newCall(getGetListMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.Result> insert(
        com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.BaseSysMenu request) {
      return futureUnaryCall(
          getChannel().newCall(getInsertMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.Result> update(
        com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.SysMenu request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.Result> delete(
        com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.ByIdReq request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_BY_ID = 0;
  private static final int METHODID_GET_LIST = 1;
  private static final int METHODID_INSERT = 2;
  private static final int METHODID_UPDATE = 3;
  private static final int METHODID_DELETE = 4;
  private static final int METHODID_GET_USER_MENUS = 5;
  private static final int METHODID_GET_ALL_LIST = 6;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SysMenuServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SysMenuServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_BY_ID:
          serviceImpl.getById((com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.ByIdReq) request,
              (io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.SysMenu>) responseObserver);
          break;
        case METHODID_GET_LIST:
          serviceImpl.getList((com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.GetListReq) request,
              (io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.PageList>) responseObserver);
          break;
        case METHODID_INSERT:
          serviceImpl.insert((com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.BaseSysMenu) request,
              (io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.Result>) responseObserver);
          break;
        case METHODID_UPDATE:
          serviceImpl.update((com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.SysMenu) request,
              (io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.Result>) responseObserver);
          break;
        case METHODID_DELETE:
          serviceImpl.delete((com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.ByIdReq) request,
              (io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.Result>) responseObserver);
          break;
        case METHODID_GET_USER_MENUS:
          serviceImpl.getUserMenus((com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.ByIdReq) request,
              (io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.SysMenu>) responseObserver);
          break;
        case METHODID_GET_ALL_LIST:
          serviceImpl.getAllList((com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.GetListReq) request,
              (io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.SysMenu>) responseObserver);
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

  private static abstract class SysMenuServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SysMenuServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.qianxun.grpc.lib.sysMenu.SysMenuOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SysMenuService");
    }
  }

  private static final class SysMenuServiceFileDescriptorSupplier
      extends SysMenuServiceBaseDescriptorSupplier {
    SysMenuServiceFileDescriptorSupplier() {}
  }

  private static final class SysMenuServiceMethodDescriptorSupplier
      extends SysMenuServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SysMenuServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (SysMenuServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SysMenuServiceFileDescriptorSupplier())
              .addMethod(getGetByIdMethod())
              .addMethod(getGetListMethod())
              .addMethod(getInsertMethod())
              .addMethod(getUpdateMethod())
              .addMethod(getDeleteMethod())
              .addMethod(getGetUserMenusMethod())
              .addMethod(getGetAllListMethod())
              .build();
        }
      }
    }
    return result;
  }
}
