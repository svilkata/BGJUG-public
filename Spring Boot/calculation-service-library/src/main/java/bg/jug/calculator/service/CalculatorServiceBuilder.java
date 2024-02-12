package bg.jug.calculator.service;

public class CalculatorServiceBuilder {
    private String startMessage;
    private String finishMessage;

    public CalculatorServiceBuilder setStartMessage(String startMessage) {
        this.startMessage = startMessage;
        return this;
    }

    public CalculatorServiceBuilder setFinishMessage(String finishMessage) {
        this.finishMessage = finishMessage;
        return this;
    }

    public CalculatorService build(){
        return new AdditionCalculatorService(startMessage, finishMessage);
    }
}
