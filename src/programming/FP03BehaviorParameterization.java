package programming;

import java.util.List;
import java.util.function.Predicate;

public class FP03BehaviorParameterization {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 4, 6, 12, 15);

     //   Predicate<Integer> evenPredicate = x -> x % 2 == 0;
        filterAndPrint(numbers,  x -> x % 2 == 0);


     //   Predicate<Integer> oddPredicate = x -> x % 2 != 0;

        // we are passing the logic of the method as an argument of the method
        // this is called Behavior Parameterization
        filterAndPrint(numbers,  x -> x % 2 != 0);
    }

    private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate) {
        // as you can see a method has been created, we are passing argument as a parameter

        numbers.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }
}
