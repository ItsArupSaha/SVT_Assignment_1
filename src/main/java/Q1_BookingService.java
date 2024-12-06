public class Q1_BookingService {

    private final PaymentService paymentService;

    public Q1_BookingService(PaymentService paymentService) {

        this.paymentService = paymentService;
    }

    public boolean processBooking(int paymentId) {
        return paymentService.processPayment(paymentId);
    }
}

class PaymentService{
    boolean processPayment(int paymentId){
        return true;
    }
}
