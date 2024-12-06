public class Q1_CalculatorService {
    private Q1_Calculator q1Calculator;

    public Q1_CalculatorService(Q1_Calculator q1Calculator) {
        this.q1Calculator = q1Calculator;
    }

    public int performAddition(int a, int b) {
        return q1Calculator.add(a, b);
    }
}

// Mockito Testing