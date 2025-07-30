package mypkg;

import com.diffblue.cover.annotations.MockDecision;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import com.diffblue.cover.annotations.InTestsMock;

/**
 * gRPC client
 * */

@InTestsMock(UserResponse.class)
@InTestsMock(UserServiceGrpc.UserServiceBlockingStub.class)
public class MyGrpcClientService {

    final UserServiceGrpc.UserServiceBlockingStub stub;

    public MyGrpcClientService(UserServiceGrpc.UserServiceBlockingStub stub) {
        this.stub = stub;
    }

    public String getUserName(String userId) {

        UserRequest request = UserRequest.newBuilder().setId(userId).build();


        UserResponse response = stub.getUser(request);
        return response.getName();
    }
}