import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class Q1_CalculatorServiceTest {

    @Mock
    private Q1_Calculator q1Calculator;

    @InjectMocks
    private Q1_CalculatorService q1CalculatorService;

    @Test
    void performAddition() {
        when(q1Calculator.add(3, 2)).thenReturn(5);
        assertEquals(5, q1CalculatorService.performAddition(3, 2));

        verify(q1Calculator).add(3, 2);
    }
}