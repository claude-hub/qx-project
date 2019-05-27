package com.qianxun.grpc.lib.authUser;

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
    comments = "Source: auth_user.proto")
public final class AuthUserServiceGrpc {

  private AuthUserServiceGrpc() {}

  public static final String SERVICE_NAME = "authUser.AuthUserService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.qianxun.grpc.lib.authUser.AuthUserOuterClass.ByAccountReq,
      com.qianxun.grpc.lib.authUser.AuthUserOuterClass.AuthUser> getGetByAccountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetByAccount",
      requestType = com.qianxun.grpc.lib.authUser.AuthUserOuterClass.ByAccountReq.class,
      responseType = com.qianxun.grpc.lib.authUser.AuthUserOuterClass.AuthUser.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.qianxun.grpc.lib.authUser.AuthUserOuterClass.ByAccountReq,
      com.qianxun.grpc.lib.authUser.AuthUserOuterClass.AuthUser> getGetByAccountMethod() {
    io.grpc.MethodDescriptor<com.qianxun.grpc.lib.authUser.AuthUserOuterClass.ByAccountReq, com.qianxun.grpc.lib.authUser.AuthUserOuterClass.AuthUser> getGetByAccountMethod;
    if ((getGetByAccountMethod = AuthUserServiceGrpc.getGetByAccountMethod) == null) {
      synchronized (AuthUserServiceGrpc.class) {
        if ((getGetByAccountMethod = AuthUserServiceGrpc.getGetByAccountMethod) == null) {
          AuthUserServiceGrpc.getGetByAccountMethod = getGetByAccountMethod = 
              io.grpc.MethodDescriptor.<com.qianxun.grpc.lib.authUser.AuthUserOuterClass.ByAccountReq, com.qianxun.grpc.lib.authUser.AuthUserOuterClass.AuthUser>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "authUser.AuthUserService", "GetByAccount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.authUser.AuthUserOuterClass.ByAccountReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.authUser.AuthUserOuterClass.AuthUser.getDefaultInstance()))
                  .setSchemaDescriptor(new AuthUserServiceMethodDescriptorSupplier("GetByAccount"))
                  .build();
          }
        }
     }
     return getGetByAccountMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.qianxun.grpc.lib.authUser.AuthUserOuterClass.SignInReq,
      com.qianxun.grpc.lib.authUser.AuthUserOuterClass.AuthUser> getSignInMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SignIn",
      requestType = com.qianxun.grpc.lib.authUser.AuthUserOuterClass.SignInReq.class,
      responseType = com.qianxun.grpc.lib.authUser.AuthUserOuterClass.AuthUser.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.qianxun.grpc.lib.authUser.AuthUserOuterClass.SignInReq,
      com.qianxun.grpc.lib.authUser.AuthUserOuterClass.AuthUser> getSignInMethod() {
    io.grpc.MethodDescriptor<com.qianxun.grpc.lib.authUser.AuthUserOuterClass.SignInReq, com.qianxun.grpc.lib.authUser.AuthUserOuterClass.AuthUser> getSignInMethod;
    if ((getSignInMethod = AuthUserServiceGrpc.getSignInMethod) == null) {
      synchronized (AuthUserServiceGrpc.class) {
        if ((getSignInMethod = AuthUserServiceGrpc.getSignInMethod) == null) {
          AuthUserServiceGrpc.getSignInMethod = getSignInMethod = 
              io.grpc.MethodDescriptor.<com.qianxun.grpc.lib.authUser.AuthUserOuterClass.SignInReq, com.qianxun.grpc.lib.authUser.AuthUserOuterClass.AuthUser>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "authUser.AuthUserService", "SignIn"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.authUser.AuthUserOuterClass.SignInReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.authUser.AuthUserOuterClass.AuthUser.getDefaultInstance()))
                  .setSchemaDescriptor(new AuthUserServiceMethodDescriptorSupplier("SignIn"))
                  .build();
          }
        }
     }
     return getSignInMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.qianxun.grpc.lib.authUser.AuthUserOuterClass.SignInByTokenReq,
      com.qianxun.grpc.lib.authUser.AuthUserOuterClass.AuthUser> getSignInByTokenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SignInByToken",
      requestType = com.qianxun.grpc.lib.authUser.AuthUserOuterClass.SignInByTokenReq.class,
      responseType = com.qianxun.grpc.lib.authUser.AuthUserOuterClass.AuthUser.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.qianxun.grpc.lib.authUser.AuthUserOuterClass.SignInByTokenReq,
      com.qianxun.grpc.lib.authUser.AuthUserOuterClass.AuthUser> getSignInByTokenMethod() {
    io.grpc.MethodDescriptor<com.qianxun.grpc.lib.authUser.AuthUserOuterClass.SignInByTokenReq, com.qianxun.grpc.lib.authUser.AuthUserOuterClass.AuthUser> getSignInByTokenMethod;
    if ((getSignInByTokenMethod = AuthUserServiceGrpc.getSignInByTokenMethod) == null) {
      synchronized (AuthUserServiceGrpc.class) {
        if ((getSignInByTokenMethod = AuthUserServiceGrpc.getSignInByTokenMethod) == null) {
          AuthUserServiceGrpc.getSignInByTokenMethod = getSignInByTokenMethod = 
              io.grpc.MethodDescriptor.<com.qianxun.grpc.lib.authUser.AuthUserOuterClass.SignInByTokenReq, com.qianxun.grpc.lib.authUser.AuthUserOuterClass.AuthUser>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "authUser.AuthUserService", "SignInByToken"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.authUser.AuthUserOuterClass.SignInByTokenReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.qianxun.grpc.lib.authUser.AuthUserOuterClass.AuthUser.getDefaultInstance()))
                  .setSchemaDescriptor(new AuthUserServiceMethodDescriptorSupplier("SignInByToken"))
                  .build();
          }
        }
     }
     return getSignInByTokenMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AuthUserServiceStub newStub(io.grpc.Channel channel) {
    return new AuthUserServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AuthUserServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AuthUserServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AuthUserServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AuthUserServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class AuthUserServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getByAccount(com.qianxun.grpc.lib.authUser.AuthUserOuterClass.ByAccountReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.authUser.AuthUserOuterClass.AuthUser> responseObserver) {
      asyncUnimplementedUnaryCall(getGetByAccountMethod(), responseObserver);
    }

    /**
     */
    public void signIn(com.qianxun.grpc.lib.authUser.AuthUserOuterClass.SignInReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.authUser.AuthUserOuterClass.AuthUser> responseObserver) {
      asyncUnimplementedUnaryCall(getSignInMethod(), responseObserver);
    }

    /**
     */
    public void signInByToken(com.qianxun.grpc.lib.authUser.AuthUserOuterClass.SignInByTokenReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.authUser.AuthUserOuterClass.AuthUser> responseObserver) {
      asyncUnimplementedUnaryCall(getSignInByTokenMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetByAccountMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.qianxun.grpc.lib.authUser.AuthUserOuterClass.ByAccountReq,
                com.qianxun.grpc.lib.authUser.AuthUserOuterClass.AuthUser>(
                  this, METHODID_GET_BY_ACCOUNT)))
          .addMethod(
            getSignInMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.qianxun.grpc.lib.authUser.AuthUserOuterClass.SignInReq,
                com.qianxun.grpc.lib.authUser.AuthUserOuterClass.AuthUser>(
                  this, METHODID_SIGN_IN)))
          .addMethod(
            getSignInByTokenMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.qianxun.grpc.lib.authUser.AuthUserOuterClass.SignInByTokenReq,
                com.qianxun.grpc.lib.authUser.AuthUserOuterClass.AuthUser>(
                  this, METHODID_SIGN_IN_BY_TOKEN)))
          .build();
    }
  }

  /**
   */
  public static final class AuthUserServiceStub extends io.grpc.stub.AbstractStub<AuthUserServiceStub> {
    private AuthUserServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AuthUserServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthUserServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AuthUserServiceStub(channel, callOptions);
    }

    /**
     */
    public void getByAccount(com.qianxun.grpc.lib.authUser.AuthUserOuterClass.ByAccountReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.authUser.AuthUserOuterClass.AuthUser> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetByAccountMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void signIn(com.qianxun.grpc.lib.authUser.AuthUserOuterClass.SignInReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.authUser.AuthUserOuterClass.AuthUser> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSignInMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void signInByToken(com.qianxun.grpc.lib.authUser.AuthUserOuterClass.SignInByTokenReq request,
        io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.authUser.AuthUserOuterClass.AuthUser> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSignInByTokenMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AuthUserServiceBlockingStub extends io.grpc.stub.AbstractStub<AuthUserServiceBlockingStub> {
    private AuthUserServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AuthUserServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthUserServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AuthUserServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.qianxun.grpc.lib.authUser.AuthUserOuterClass.AuthUser getByAccount(com.qianxun.grpc.lib.authUser.AuthUserOuterClass.ByAccountReq request) {
      return blockingUnaryCall(
          getChannel(), getGetByAccountMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.qianxun.grpc.lib.authUser.AuthUserOuterClass.AuthUser signIn(com.qianxun.grpc.lib.authUser.AuthUserOuterClass.SignInReq request) {
      return blockingUnaryCall(
          getChannel(), getSignInMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.qianxun.grpc.lib.authUser.AuthUserOuterClass.AuthUser signInByToken(com.qianxun.grpc.lib.authUser.AuthUserOuterClass.SignInByTokenReq request) {
      return blockingUnaryCall(
          getChannel(), getSignInByTokenMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AuthUserServiceFutureStub extends io.grpc.stub.AbstractStub<AuthUserServiceFutureStub> {
    private AuthUserServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AuthUserServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuthUserServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AuthUserServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.qianxun.grpc.lib.authUser.AuthUserOuterClass.AuthUser> getByAccount(
        com.qianxun.grpc.lib.authUser.AuthUserOuterClass.ByAccountReq request) {
      return futureUnaryCall(
          getChannel().newCall(getGetByAccountMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.qianxun.grpc.lib.authUser.AuthUserOuterClass.AuthUser> signIn(
        com.qianxun.grpc.lib.authUser.AuthUserOuterClass.SignInReq request) {
      return futureUnaryCall(
          getChannel().newCall(getSignInMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.qianxun.grpc.lib.authUser.AuthUserOuterClass.AuthUser> signInByToken(
        com.qianxun.grpc.lib.authUser.AuthUserOuterClass.SignInByTokenReq request) {
      return futureUnaryCall(
          getChannel().newCall(getSignInByTokenMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_BY_ACCOUNT = 0;
  private static final int METHODID_SIGN_IN = 1;
  private static final int METHODID_SIGN_IN_BY_TOKEN = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AuthUserServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AuthUserServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_BY_ACCOUNT:
          serviceImpl.getByAccount((com.qianxun.grpc.lib.authUser.AuthUserOuterClass.ByAccountReq) request,
              (io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.authUser.AuthUserOuterClass.AuthUser>) responseObserver);
          break;
        case METHODID_SIGN_IN:
          serviceImpl.signIn((com.qianxun.grpc.lib.authUser.AuthUserOuterClass.SignInReq) request,
              (io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.authUser.AuthUserOuterClass.AuthUser>) responseObserver);
          break;
        case METHODID_SIGN_IN_BY_TOKEN:
          serviceImpl.signInByToken((com.qianxun.grpc.lib.authUser.AuthUserOuterClass.SignInByTokenReq) request,
              (io.grpc.stub.StreamObserver<com.qianxun.grpc.lib.authUser.AuthUserOuterClass.AuthUser>) responseObserver);
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

  private static abstract class AuthUserServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AuthUserServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.qianxun.grpc.lib.authUser.AuthUserOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AuthUserService");
    }
  }

  private static final class AuthUserServiceFileDescriptorSupplier
      extends AuthUserServiceBaseDescriptorSupplier {
    AuthUserServiceFileDescriptorSupplier() {}
  }

  private static final class AuthUserServiceMethodDescriptorSupplier
      extends AuthUserServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AuthUserServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (AuthUserServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AuthUserServiceFileDescriptorSupplier())
              .addMethod(getGetByAccountMethod())
              .addMethod(getSignInMethod())
              .addMethod(getSignInByTokenMethod())
              .build();
        }
      }
    }
    return result;
  }
}
