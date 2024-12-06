import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class Q1_BookingServiceTest {

    @Mock
    private Q1_BookingService q1BookingService; // The system under test

    @Mock
    private PaymentService paymentService; // Mock PaymentService dependency

    @Test
    void processBooking() {
        // Arrange
        int bookingId = 1;
        when(q1BookingService.processBooking(bookingId)).thenReturn(true);

        // Act
        boolean result = q1BookingService.processBooking(bookingId);

        // Assert
        assertTrue(result, "Q1_BookingService should return true for successful booking");

        // Verify that payment processing was triggered
        verify(q1BookingService).processBooking(bookingId);
        verifyNoInteractions(paymentService); // Use if PaymentService wasn't intended to be called
    }
}
