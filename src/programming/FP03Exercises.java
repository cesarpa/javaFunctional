package programming;

import java.util.List;
import java.util.function.BinaryOperator;

public class FP03Exercises {


    public static void main(String[] args) {




        BinaryOperator<Integer> sumBinaryOperator = (a, b) -> a + b;
        BinaryOperator<Integer> sumBinaryOperator2 = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer a, Integer b) {
                return a+b;
            }
        }; // Represents an operation upon two operands of the same type, producing a result of the same type as the operands.


        // typically the abstract method (apply,accept test) is called a function descriptor

        List<Integer> numbers = List.of(1, 2, 3, 4);
        int sum = numbers
                .stream()
                .distinct()
                .reduce(0, (x, y) -> x + y);
        // 6

        List<String> emails = List.of("abc@gmail.com","xyz@gmail.com","abc@gmail.com");
        emails.stream().distinct().forEach(System.out::println);
        // abc@gmail.com
        // xyz@gmail.com
        System.out.println(sum);


        List<String> sports = List.of("Soccer", "NBA", "Volleyball", "Tennis");
        sports.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}
