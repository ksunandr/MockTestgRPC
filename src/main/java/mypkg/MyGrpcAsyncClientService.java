package mypkg;

import com.diffblue.cover.annotations.InTestsMock;
import com.diffblue.cover.annotations.InTestsMockStatic;
import com.diffblue.cover.annotations.MockDecision;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.Random;
@InTestsMockStatic(value = UserServiceGrpc.class, decision = MockDecision.REQUIRED)
@InTestsMock(value =  UserServiceGrpc.UserServiceStub.class, decision = MockDecision.REQUIRED)
public class MyGrpcAsyncClientService {

    private UserServiceGrpc.UserServiceStub stub;

    public void getUserName(String userId) {

        String host= "test";
        int port =1;


        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        this.stub = UserServiceGrpc.newStub(channel);
        UserRequest request = UserRequest.newBuilder()
                .setId(userId)
                .build();

        stub.getUser(request, new StreamObserver<UserResponse>() {
            @Override
            public void onNext(UserResponse value) {
                System.out.println("Received user name: " + value.getName());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error during gRPC call: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("gRPC call completed.");
            }
        });
    }
}