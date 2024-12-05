abstract class Calculator {
    public abstract int calc(int a, int b);
}

class SimpleCalculator extends Calculator {
    @Override
    public int calc(int a, int b) {
        return a + b;
    }
}

abstract class CalculatorDecorator extends Calculator {
    protected Calculator decoratedCalculator;
    public CalculatorDecorator(Calculator calculator) {
        this.decoratedCalculator = calculator;
    }
    @Override
    public int calc(int a, int b) {
        return decoratedCalculator.calc(a, b);
    }
}

class LoggingCalculatorDecorator extends CalculatorDecorator {
    public LoggingCalculatorDecorator(Calculator calculator) {
        super(calculator);
    }
    @Override
    public int calc(int a, int b) {
        int result = super.calc(a, b);
        System.out.println("add executed <<" + result + ">>");
        return result;
    }
}

class TimingCalculatorDecorator extends CalculatorDecorator {
    public TimingCalculatorDecorator(Calculator calculator) {
        super(calculator);
    }
    @Override
    public int calc(int a, int b) {
        long startTime = System.nanoTime();
        int result = super.calc(a, b);
        long endTime = System.nanoTime();
        System.out.println("Time taken: " + (endTime - startTime) + " ns");
        return result;
    }
}


// 메인 클래스
// 클라이언트 메인 클래스
public class Main {
    public static void main(String[] args) {
        Calculator calculator = new SimpleCalculator();
        calculator = new LoggingCalculatorDecorator(calculator);
        calculator = new TimingCalculatorDecorator(calculator);
        calculator.calc(10, 20);
    }
}