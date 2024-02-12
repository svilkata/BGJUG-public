package bg.jug.calculator.service;

public class AdditionCalculatorService implements CalculatorService {

    private final String startMessage;
    private final String finishMessage;

    public AdditionCalculatorService(String startMessage, String finishMessage) {

        this.startMessage = startMessage;
        this.finishMessage = finishMessage;
    }

    @Override
    public int apply(int op1, int op2) {
        System.out.printf(startMessage, op1, op2);
        System.out.println();

        int result = op1 + op2;

        System.out.printf(finishMessage, result);
        System.out.println();

        return result;
    }
}
