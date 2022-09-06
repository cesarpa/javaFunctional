package programming;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP03Structured {

    /*
        boolean isEven(int a){
            return a%2==0;
        }

        int squared(int x){
            return x+x;
        }
        the lambda is the simplification
     */

    public static void main(String[] args) {
        // lets talk about how to pass a method  code to another method
        List<Integer> numbers = List.of(12, 9, 4, 6, 12, 15);
        Predicate<Integer> isEvenPredicate = f -> f % 2 == 0; // instance of a predicate
        Predicate<Integer> isEvenPredicate2 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer x) {
                return x % 2 == 0;
            }
        }; // what is happening is we are creating an instance of predicate class
        // thats why you can pass a function into a method in Java


        Function<Integer, Integer> squareNumber = x -> x * x; // instance of a function
        // function that accepts one argument and produces a result
        Function<Integer, Integer> squareNumber2 = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer x) {
                return x*x;
            }
        };

        Consumer<Integer> consumerPrintln = System.out::println; // consumer consumes whatever he gets
        // represents an operation that accepts a single input argument and return no results.
        Consumer<Integer> consumerPrintln2 = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        }; // we are creating an instance of a functional interface called consumer

        // all of the above are functional interfaces, the functional interfaces contains  only one abstract method
        numbers.stream()
                .filter(isEvenPredicate2) //we are passing logic , right click extract into a local variable (introduce variable)
                .map(squareNumber2)
                .forEach(consumerPrintln2);
    }

    // summary, behind each lambda expression that we write  is something called a functional interface
}
