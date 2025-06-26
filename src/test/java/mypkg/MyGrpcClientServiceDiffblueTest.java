package mypkg;

import mypkg.UserServiceGrpc.UserServiceBlockingStub;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MyGrpcClientServiceDiffblueTest {
    /**
     * Test {@link MyGrpcClientService#MyGrpcClientService(UserServiceBlockingStub)}.
     * <p>
     * Method under test: {@link MyGrpcClientService#MyGrpcClientService(UserServiceBlockingStub)}
     */
    @Test
    @DisplayName("Test new MyGrpcClientService(UserServiceBlockingStub)")
    @Tag("MaintainedByDiffblue")
    void testNewMyGrpcClientService() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //   MyGrpcClientService.stub

        // Arrange and Act
        new MyGrpcClientService(null);
    }

    /**
     * Test {@link MyGrpcClientService#getUserName(String)}.
     * <ul>
     *   <li>When {@code 42}.</li>
     * </ul>
     * <p>
     * Method under test: {@link MyGrpcClientService#getUserName(String)}
     */
    @Test
    @DisplayName("Test getUserName(String); when '42'")
    @Disabled("TODO: Complete this test")
    @Tag("MaintainedByDiffblue")
    void testGetUserName_when42() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "mypkg.UserServiceGrpc$UserServiceBlockingStub.getUser(mypkg.UserRequest)" because "this.stub" is null
        //       at mypkg.MyGrpcClientService.getUserName(MyGrpcClientService.java:18)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange and Act
        new MyGrpcClientService(null).getUserName("42");
    }
}
