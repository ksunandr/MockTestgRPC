package mypkg;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class MyGrpcClientService {

    private final UserServiceGrpc.UserServiceBlockingStub stub;

    public MyGrpcClientService(UserServiceGrpc.UserServiceBlockingStub stub) {
        this.stub = stub;
    }

    public String getUserName(String userId) {
        UserRequest request = UserRequest.newBuilder().setId(userId).build();
        UserResponse response = stub.getUser(request);
        return response.getName();
    }
}