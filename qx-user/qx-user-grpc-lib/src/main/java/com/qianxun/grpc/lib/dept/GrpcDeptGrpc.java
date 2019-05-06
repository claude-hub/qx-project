package com.qianxun.grpc.lib.dept;

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
    comments = "Source: grpc_dept.proto")
public final class GrpcDeptGrpc {

  private GrpcDeptGrpc() {}

  public static final String SERVICE_NAME = "dept.GrpcDept";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptReq,
      com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptRes> getGetDeptMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDept",
      requestType = com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptReq.class,
      responseType = com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptRes.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptReq,
      com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptRes> getGetDeptMethod() {
    io.grpc.MethodDescriptor<com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptReq, com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptRes> getGetDeptMethod;
    if ((getGetDeptMethod = GrpcDeptGrpc.getGetDeptMethod) == null) {
      synchronized (GrpcDeptGrpc.class) {
        if ((getGetDeptMethod = GrpcDeptGrpc.getGetDeptMethod) == null) {
          GrpcDeptGrpc.getGetDeptMethod = getGetDeptMethod = 
              io.grpc.MethodDescriptor.<com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptReq, com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptRes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "dept.GrpcDept", "GetDept"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptRes.getDefaultInstance()))
                  .setSchemaDescriptor(new GrpcDeptMethodDescriptorSupplier("GetDept"))
                  .build();
          }
        }
     }
     return getGetDeptMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptReq,
      com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptRes> getGetDeptListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDeptList",
      requestType = com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptReq.class,
      responseType = com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptRes.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptReq,
      com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptRes> getGetDeptListMethod() {
    io.grpc.MethodDescriptor<com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptReq, com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptRes> getGetDeptListMethod;
    if ((getGetDeptListMethod = GrpcDeptGrpc.getGetDeptListMethod) == null) {
      synchronized (GrpcDeptGrpc.class) {
        if ((getGetDeptListMethod = GrpcDeptGrpc.getGetDeptListMethod) == null) {
          GrpcDeptGrpc.getGetDeptListMethod = getGetDeptListMethod = 
              io.grpc.MethodDescriptor.<com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptReq, com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptRes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "dept.GrpcDept", "GetDeptList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptRes.getDefaultInstance()))
                  .setSchemaDescriptor(new GrpcDeptMethodDescriptorSupplier("GetDeptList"))
                  .build();
          }
        }
     }
     return getGetDeptListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptRes,
      com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.UpdateDeptRes> getUpdateDeptMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDept",
      requestType = com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptRes.class,
      responseType = com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.UpdateDeptRes.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptRes,
      com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.UpdateDeptRes> getUpdateDeptMethod() {
    io.grpc.MethodDescriptor<com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptRes, com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.UpdateDeptRes> getUpdateDeptMethod;
    if ((getUpdateDeptMethod = GrpcDeptGrpc.getUpdateDeptMethod) == null) {
      synchronized (GrpcDeptGrpc.class) {
        if ((getUpdateDeptMethod = GrpcDeptGrpc.getUpdateDeptMethod) == null) {
          GrpcDeptGrpc.getUpdateDeptMethod = getUpdateDeptMethod = 
              io.grpc.MethodDescriptor.<com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptRes, com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.UpdateDeptRes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "dept.GrpcDept", "UpdateDept"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptRes.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.UpdateDeptRes.getDefaultInstance()))
                  .setSchemaDescriptor(new GrpcDeptMethodDescriptorSupplier("UpdateDept"))
                  .build();
          }
        }
     }
     return getUpdateDeptMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptReq,
      com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.UpdateDeptRes> getDeleteDeptMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDept",
      requestType = com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptReq.class,
      responseType = com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.UpdateDeptRes.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptReq,
      com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.UpdateDeptRes> getDeleteDeptMethod() {
    io.grpc.MethodDescriptor<com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptReq, com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.UpdateDeptRes> getDeleteDeptMethod;
    if ((getDeleteDeptMethod = GrpcDeptGrpc.getDeleteDeptMethod) == null) {
      synchronized (GrpcDeptGrpc.class) {
        if ((getDeleteDeptMethod = GrpcDeptGrpc.getDeleteDeptMethod) == null) {
          GrpcDeptGrpc.getDeleteDeptMethod = getDeleteDeptMethod = 
              io.grpc.MethodDescriptor.<com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptReq, com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.UpdateDeptRes>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "dept.GrpcDept", "DeleteDept"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.UpdateDeptRes.getDefaultInstance()))
                  .setSchemaDescriptor(new GrpcDeptMethodDescriptorSupplier("DeleteDept"))
                  .build();
          }
        }
     }
     return getDeleteDeptMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GrpcDeptStub newStub(io.grpc.Channel channel) {
    return new GrpcDeptStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GrpcDeptBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new GrpcDeptBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GrpcDeptFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new GrpcDeptFutureStub(channel);
  }

  /**
   */
  public static abstract class GrpcDeptImplBase implements io.grpc.BindableService {

    /**
     */
    public void getDept(com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptRes> responseObserver) {
      asyncUnimplementedUnaryCall(getGetDeptMethod(), responseObserver);
    }

    /**
     */
    public void getDeptList(com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptRes> responseObserver) {
      asyncUnimplementedUnaryCall(getGetDeptListMethod(), responseObserver);
    }

    /**
     */
    public void updateDept(com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptRes request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.UpdateDeptRes> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateDeptMethod(), responseObserver);
    }

    /**
     */
    public void deleteDept(com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.UpdateDeptRes> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteDeptMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetDeptMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptReq,
                com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptRes>(
                  this, METHODID_GET_DEPT)))
          .addMethod(
            getGetDeptListMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptReq,
                com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptRes>(
                  this, METHODID_GET_DEPT_LIST)))
          .addMethod(
            getUpdateDeptMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptRes,
                com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.UpdateDeptRes>(
                  this, METHODID_UPDATE_DEPT)))
          .addMethod(
            getDeleteDeptMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptReq,
                com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.UpdateDeptRes>(
                  this, METHODID_DELETE_DEPT)))
          .build();
    }
  }

  /**
   */
  public static final class GrpcDeptStub extends io.grpc.stub.AbstractStub<GrpcDeptStub> {
    private GrpcDeptStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GrpcDeptStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrpcDeptStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GrpcDeptStub(channel, callOptions);
    }

    /**
     */
    public void getDept(com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptRes> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetDeptMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getDeptList(com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptRes> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetDeptListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateDept(com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptRes request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.UpdateDeptRes> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateDeptMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteDept(com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.UpdateDeptRes> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteDeptMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class GrpcDeptBlockingStub extends io.grpc.stub.AbstractStub<GrpcDeptBlockingStub> {
    private GrpcDeptBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GrpcDeptBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrpcDeptBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GrpcDeptBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptRes getDept(com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptReq request) {
      return blockingUnaryCall(
          getChannel(), getGetDeptMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptRes> getDeptList(
        com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptReq request) {
      return blockingServerStreamingCall(
          getChannel(), getGetDeptListMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.UpdateDeptRes updateDept(com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptRes request) {
      return blockingUnaryCall(
          getChannel(), getUpdateDeptMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.UpdateDeptRes deleteDept(com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptReq request) {
      return blockingUnaryCall(
          getChannel(), getDeleteDeptMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class GrpcDeptFutureStub extends io.grpc.stub.AbstractStub<GrpcDeptFutureStub> {
    private GrpcDeptFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GrpcDeptFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrpcDeptFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GrpcDeptFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptRes> getDept(
        com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptReq request) {
      return futureUnaryCall(
          getChannel().newCall(getGetDeptMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.UpdateDeptRes> updateDept(
        com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptRes request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateDeptMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.UpdateDeptRes> deleteDept(
        com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptReq request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteDeptMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_DEPT = 0;
  private static final int METHODID_GET_DEPT_LIST = 1;
  private static final int METHODID_UPDATE_DEPT = 2;
  private static final int METHODID_DELETE_DEPT = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GrpcDeptImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GrpcDeptImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_DEPT:
          serviceImpl.getDept((com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptReq) request,
              (io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptRes>) responseObserver);
          break;
        case METHODID_GET_DEPT_LIST:
          serviceImpl.getDeptList((com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptReq) request,
              (io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptRes>) responseObserver);
          break;
        case METHODID_UPDATE_DEPT:
          serviceImpl.updateDept((com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptRes) request,
              (io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.UpdateDeptRes>) responseObserver);
          break;
        case METHODID_DELETE_DEPT:
          serviceImpl.deleteDept((com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.DeptReq) request,
              (io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.UpdateDeptRes>) responseObserver);
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

  private static abstract class GrpcDeptBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GrpcDeptBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.qianxun.grpc.lib.dept.GrpcDeptOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GrpcDept");
    }
  }

  private static final class GrpcDeptFileDescriptorSupplier
      extends GrpcDeptBaseDescriptorSupplier {
    GrpcDeptFileDescriptorSupplier() {}
  }

  private static final class GrpcDeptMethodDescriptorSupplier
      extends GrpcDeptBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GrpcDeptMethodDescriptorSupplier(String methodName) {
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
      synchronized (GrpcDeptGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GrpcDeptFileDescriptorSupplier())
              .addMethod(getGetDeptMethod())
              .addMethod(getGetDeptListMethod())
              .addMethod(getUpdateDeptMethod())
              .addMethod(getDeleteDeptMethod())
              .build();
        }
      }
    }
    return result;
  }
}
