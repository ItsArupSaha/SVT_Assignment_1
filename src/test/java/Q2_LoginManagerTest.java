import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class Q2_LoginManagerTest {

    @Mock
    private AuthenticationService authService;

    @InjectMocks
    private Q2_LoginManager loginManager;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void login() throws Exception {
        String validUsername = "user1";
        String validPassword = "pass1";

        // Stub the mock methods
        when(authService.authenticate(validUsername, validPassword)).thenReturn(true);
        when(authService.authenticate("invalidUser", "invalidPass")).thenReturn(false);

        // Test valid credentials
        assertTrue(loginManager.login(validUsername, validPassword));
        verify(authService).authenticate(validUsername, validPassword);

        // Test invalid credentials
        assertFalse(loginManager.login("invalidUser", "invalidPass"));
        verify(authService).authenticate("invalidUser", "invalidPass");

        // Test for null username or password
        assertThrows(IllegalArgumentException.class,
                () -> loginManager.login(null, validPassword),
                "An exception should be thrown for null username.");

        assertThrows(IllegalArgumentException.class,
                () -> loginManager.login(validUsername, null),
                "An exception should be thrown for null password.");
    }

}