package mypkg;

import io.grpc.ManagedChannel;
import io.grpc.stub.StreamObserver;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class MyGrpcAsyncClientServiceTest {
    /**
     * Test {@link MyGrpcAsyncClientService#getUserName(String)}.
     *
     * <p>Method under test: {@link MyGrpcAsyncClientService#getUserName(String)}
     */
    @Test
    void testGetUserName() {
        UserServiceGrpc.UserServiceStub mockStub = mock(UserServiceGrpc.UserServiceStub.class);

        try (MockedStatic<UserServiceGrpc> mockedStatic = mockStatic(UserServiceGrpc.class)) {
            mockedStatic.when(() -> UserServiceGrpc.newStub(any(ManagedChannel.class)))
                    .thenReturn(mockStub);

            MyGrpcAsyncClientService myGrpcAsyncClientService = new MyGrpcAsyncClientService();

            // Mock getUser behaviour to capture StreamObserver
            doAnswer(invocation -> {
                UserRequest req = invocation.getArgument(0);
                StreamObserver<UserResponse> observer = invocation.getArgument(1);

                // Simulate gRPC response
                observer.onNext(UserResponse.newBuilder().setName("TestUser").build());
                observer.onCompleted();
                return null;
            }).when(mockStub).getUser(any(UserRequest.class), any());

            // When
            myGrpcAsyncClientService.getUserName("123");

            // Then
            verify(mockStub).getUser(any(), any());
///
        }
    }

    @Test
    void testGetUserName_simple() {
        UserServiceGrpc.UserServiceStub mockStub = mock(UserServiceGrpc.UserServiceStub.class);

        try (MockedStatic<UserServiceGrpc> mockedStatic = mockStatic(UserServiceGrpc.class)) {
            mockedStatic.when(() -> UserServiceGrpc.newStub(any(ManagedChannel.class)))
                    .thenReturn(mockStub);


//mock and stub
            doNothing().when(mockStub).getUser(any(), any());
//act
            MyGrpcAsyncClientService myGrpcAsyncClientService = new MyGrpcAsyncClientService();

            myGrpcAsyncClientService.getUserName("some-id");

            verify(mockStub).getUser(any(), any());


        }
    }
}
