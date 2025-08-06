package mypkg;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.grpc.Channel;
import io.grpc.stub.StreamObserver;
import mypkg.UserServiceGrpc.UserServiceStub;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

class MyGrpcAsyncClientServiceDiffblueTest {
  /**
   * Test {@link MyGrpcAsyncClientService#getUserName(String)}.
   *
   * <ul>
   *   <li>Given {@link UserServiceStub} {@link UserServiceStub#getUser(UserRequest,
   *       StreamObserver)} does nothing.
   *   <li>When {@code 42}.
   *   <li>Then calls {@link UserServiceGrpc#newStub(Channel)}.
   * </ul>
   *
   * <p>Method under test: {@link MyGrpcAsyncClientService#getUserName(String)}
   */
  @Test
  @DisplayName(
      "Test getUserName(String); given UserServiceStub getUser(UserRequest, StreamObserver) does nothing; when '42'; then calls newStub(Channel)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MyGrpcAsyncClientService.getUserName(String)"})
  void testGetUserName_givenUserServiceStubGetUserDoesNothing_when42_thenCallsNewStub() {
    // Arrange
    try (MockedStatic<UserServiceGrpc> mockUserServiceGrpc = mockStatic(UserServiceGrpc.class)) {
      UserServiceStub userServiceStub = mock(UserServiceStub.class);
      doNothing()
          .when(userServiceStub)
          .getUser(Mockito.<UserRequest>any(), Mockito.<StreamObserver<UserResponse>>any());
      mockUserServiceGrpc
          .when(() -> UserServiceGrpc.newStub(Mockito.<Channel>any()))
          .thenReturn(userServiceStub);

      // Act
      new MyGrpcAsyncClientService().getUserName("42");

      // Assert
      mockUserServiceGrpc.verify(() -> UserServiceGrpc.newStub(Mockito.<Channel>any()));
      verify(userServiceStub).getUser(isA(UserRequest.class), isA(StreamObserver.class));
    }
  }
}
