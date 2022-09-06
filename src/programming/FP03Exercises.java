package programming;

import java.util.List;
import java.util.function.BinaryOperator;

public class FP03Exercises {


    public static void main(String[] args) {

        List<Integer> numbers = List.of(12, 9, 4, 6, 12, 15);
        BinaryOperator<Integer> sumBinaryOperator = (a, b) -> a + b;
        BinaryOperator<Integer> sumBinaryOperator2 = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer a, Integer b) {
                return a+b;
            }
        }; // Represents an operation upon two operands of the same type, producing a result of the same type as the operands.


        // typically the abstract method (apply,accept test) is called a function descriptor

        int sum = numbers
                .stream()
                .reduce(0, sumBinaryOperator2);
        System.out.println(sum);
    }
}
