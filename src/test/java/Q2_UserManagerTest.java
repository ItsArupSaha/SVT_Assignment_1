import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class Q2_UserManagerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private Q2_UserManager userManager;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void registerUser() {
        String username = "newUser";
        String password = "password123";

        // Stub the mock methods
        when(userService.usernameExists(username)).thenReturn(false);
        when(userService.saveUser(username, password)).thenReturn(true);

        // Call the method under test
        boolean isRegistered = userManager.registerUser(username, password);

        verify(userService).usernameExists(username);
        verify(userService).saveUser(username, password);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 32",
            "25, 77",
            "-40, -40"
    })
    void testCelsiusToFahrenheit(double celsius, double expectedFahrenheit) {
        double actualFahrenheit = userManager.celsiusToFahrenheit(celsius);
        assertEquals(expectedFahrenheit, actualFahrenheit);
    }

    @Test
    void testCelsiusToFahrenheitException() {
        assertThrows(IllegalArgumentException.class,
                () -> userManager.celsiusToFahrenheit(-274),
                "An exception should be thrown for temperatures below absolute zero.");
    }
}