import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class Q1_UserServiceTest {

    @Mock
    UserRepository userRepo;

    @InjectMocks
    Q1_UserService q1UserService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findUserById() {

        int userId = 1;
        Q1_User mockQ1User = new Q1_User(userId, "Arup", 24);

        // Mock the repository's behavior
        when(userRepo.findUserById(userId)).thenReturn(mockQ1User);

        // Act
        Q1_User result = q1UserService.findUserById(userId);

        // Verify that the repository method was called
        verify(userRepo).findUserById(userId);

    }
}