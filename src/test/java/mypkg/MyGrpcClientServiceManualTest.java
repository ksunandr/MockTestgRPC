package mypkg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import mypkg.UserServiceGrpc.UserServiceBlockingStub;

class MyGrpcClientServiceManualTest {

    /**
     * Test {@link MyGrpcClientService#MyGrpcClientService(UserServiceGrpc.UserServiceBlockingStub)}.
     * <p>
     * Method under test: {@link MyGrpcClientService#MyGrpcClientService(UserServiceGrpc.UserServiceBlockingStub)}
     */
    @Test
    void testNewMyGrpcClientService() {
        //0 static mock?
        //1
        UserServiceBlockingStub mockStub = mock(UserServiceBlockingStub.class);
        //2
        UserResponse.Builder builder = UserResponse.newBuilder();
        UserResponse response = builder.setName("Alice").build();
        when(mockStub.getUser(any(UserRequest.class))).thenReturn(response);


        String s = new MyGrpcClientService(mockStub).getUserName("42");

        assertEquals("Alice", s);
    }

    @Test
    void testNewMyGrpcClientService2() {
        //0 static mock?
        //1
        UserServiceBlockingStub mockStub = mock(UserServiceBlockingStub.class);
        //2
//        UserResponse.Builder builder = UserResponse.newBuilder();
//        UserResponse response = builder.setName("Alice").build();

        UserResponse response = mock(UserResponse.class);


        when(mockStub.getUser(any(UserRequest.class))).thenReturn(response);
        when(response.getName()).thenReturn("Alice");


        String s = new MyGrpcClientService(mockStub).getUserName("42");

        assertEquals("Alice", s);
    }


//    @Test
//
//    void test() {
//        // Arrange and Act
//        mock(UserServiceBlockingStub.class, withSettings().serializable());
//    }
//    @Test
//    void test2() {
//        // Arrange and Act
//        mock(UserServiceBlockingStub.class, withSettings().extraInterfaces());
//    }
//
//    @Test
//
//    void test3() {
//        // Arrange and Act
//        new MyGrpcClientService(mock(UserServiceBlockingStub.class)).getUserName("42");
//    }
//
//
//
//
//    @Test
//    void test4() {
//        // Arrange and Act
//        mock(UserServiceBlockingStub.class, withSettings().withoutAnnotations());
//    }





}