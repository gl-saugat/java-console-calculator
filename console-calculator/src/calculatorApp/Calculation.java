package calculatorApp;

public class Calculation {

    public double add(double input1, double input2){
        return input1 + input2;
    }

    public double difference(double input1, double input2){
        return input1 - input2;
    }

    public double multiplication(double input1, double input2){
        return input1 * input2;
    }

    public double division(double input1, double input2){
        double result = 0.0;
        if(input2 == 0.0){
            throw new ArithmeticException("Number can't be divided by zero.");
        }
        return input1 / input2;
    }
}
