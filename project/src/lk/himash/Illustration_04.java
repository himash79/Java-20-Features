package lk.himash;

import jdk.incubator.concurrent.ScopedValue;

public class Illustration_04 {

    // Scoped value usage with return value

    final static ScopedValue<Integer> MAIN_SCOPE = ScopedValue.newInstance();

    public static void main(String[] args) throws Exception {
        // we use `call` to run a scope and get it returned value
        var result = ScopedValue.where(MAIN_SCOPE, 42)
                .call(() -> { // throws Exception
                    var calculator = new Calculator_02();
                    return calculator.calculate();
                });
        System.out.println("Result from calculation: " + result);
    }
}

class Calculator_02 {
    public int calculate() {
        var seed = Illustration_04.MAIN_SCOPE.get();
        return seed + 42;
    }

}
