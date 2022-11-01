package programming;

import java.util.List;

public class FP01Functional {

    public static void main(String[] args) {
        printSquaresOfEvenNumbers(List.of(12, 5, 8, 9, 88));
    }

    private static void printAllValuesInListSctructured(List<Integer> numbers) {
        // here we'll focus in what to do instead of how to do
        // we want to convert it into a sequence of elements (stream of elements)
        numbers.stream().forEach(System.out::println); // :: method reference (for each element this method should be called)
        // then we have to specify what to do with each of them (a system print)
        //numbers.stream().forEach( (i) -> System.out.println(i));


        for (int number : numbers){
            System.out.println(numbers);
        }
    }

    private static boolean isEven(Integer number) {
        return number % 2 == 0;
    }

    private static void printEvenNumbers(List<Integer> numbers) {
        //   numbers.stream().filter(FP01Functional::isEven).forEach(System.out::println);
        // we can do a lamba expressoin that should be better for this scenario
        numbers.stream().filter(i -> i % 2 == 0) // lamda expression
                .forEach(System.out::println);

        // functional programming is focusing on what to do, a paradigm shift
    }

    private static void printSquaresOfEvenNumbers(List<Integer> numbers){
        // think about what we what to do.. is map
        // map in java functional is take the number and do something , in this case multiplying
        numbers.stream().filter(i -> i % 2 == 0).map(i -> i * i).forEach(System.out::println);
    }


    // RESUME:
    // Functional Programming is Focus on What to do
    // Stream is a sequence of elements
    // Filter to review a condition that has to be check
    // Map is used to map/pass one value to another value
    // Lambda Expressions are being used on filter and map
    // Lambda is just a simplified representation of a method

    // Until now the method references calls static methods
}
