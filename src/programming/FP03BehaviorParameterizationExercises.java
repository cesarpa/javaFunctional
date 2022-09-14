package programming;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FP03BehaviorParameterizationExercises {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 4, 6, 12, 15);

        // Function<Integer, Integer> squareFunction = x -> x * x;

        List<Integer> squareNumbers = getListBasedOnFunction(numbers, x -> x * x);

        List<Integer> cubedNumbers = getListBasedOnFunction(numbers, x -> x * x);

        List<Integer> doubledNumbers = getListBasedOnFunction(numbers, x -> x + x);

        System.out.println(doubledNumbers);
    }

    private static List<Integer> getListBasedOnFunction(List<Integer> numbers, Function<Integer, Integer> numerFunction) {
        return numbers.stream().map(numerFunction).collect(Collectors.toList());
    }
}
