package mypkg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import mypkg.UserServiceGrpc.UserServiceBlockingStub;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MyGrpcClientServiceDiffblueTest {
  /**
   * Test {@link MyGrpcClientService#getUserName(String)}.
   *
   * <ul>
   *   <li>Given {@link UserResponse} {@link UserResponse#getName()} return {@code Name}.
   *   <li>When {@code 42}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link MyGrpcClientService#getUserName(String)}
   */
  @Test
  @DisplayName(
      "Test getUserName(String); given UserResponse getName() return 'Name'; when '42'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String MyGrpcClientService.getUserName(String)"})
  void testGetUserName_givenUserResponseGetNameReturnName_when42_thenReturnName() {
    // Arrange
    UserResponse userResponse = mock(UserResponse.class);
    when(userResponse.getName()).thenReturn("Name");
    UserServiceBlockingStub stub = mock(UserServiceBlockingStub.class);
    when(stub.getUser(Mockito.<UserRequest>any())).thenReturn(userResponse);

    // Act
    String actualUserName = new MyGrpcClientService(stub).getUserName("42");

    // Assert
    verify(userResponse).getName();
    verify(stub).getUser(isA(UserRequest.class));
    assertEquals("Name", actualUserName);
  }
}
