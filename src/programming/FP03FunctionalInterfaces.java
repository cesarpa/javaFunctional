package programming;

import java.util.List;
import java.util.Random;
import java.util.function.*;

public class FP03FunctionalInterfaces {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4);




        Predicate<Integer> isEvenPredicate = x -> x % 2 == 0;
        // Represents a predicate (boolean-valued function) of one argument.

        Function<Integer, Integer> squareFunction = x -> x * x;
        // Represents a function that accepts one argument and produces a result.

        Consumer<Integer> sysoutConsumer = x -> System.out.println(x);
        // Represents an operation that accepts a single input argument and returns no result.

        numbers.stream()
                .filter(isEvenPredicate)
                .map(squareFunction)
                .forEach(sysoutConsumer);




        BinaryOperator<Integer> sumBinaryOperator = (x,y) -> x+y;
        // use to pass lambda expressions

        //Supplier, does not have any input but we want to return something back
        // just have the get() method
        // like a factory pattern
        Supplier<Integer> randomIntegerSupplier = () -> 2;

        // also we can add multiple lines of code in a lambda expression
        Supplier<Integer> randomIntegerSupplier2 = () -> {
            Random random = new Random();
            return random.nextInt(1000);
        };

        System.out.println(randomIntegerSupplier2.get());

        //Unary operator will take  on parameter  as the input  and return a result of the same type as the output
        UnaryOperator<Integer> unaryOperator = x -> x*3;

        System.out.println(unaryOperator.apply(2));

        //Lets explore the other functions.
        //BiPredicate is similar to Predicate.. but here we have 2 inputs and the output is boolean as the predicate
        BiPredicate<Integer,String> biPredicate = (number,str) -> {
            return number>5 && str.length()>4;
        };
        System.out.println(biPredicate.test(6,"cesar"));

        //BiFunction can receive 2 inputs and return one output back
        BiFunction<Integer,String, String> biFunction = (x , y) -> x + " string -> "+y;

        System.out.println(biFunction.apply(2,"dos"));

        //BiConsumer, this consumes 2 inputs and consumes it, in this cas print
        BiConsumer<Integer,String> biConsumer = (x,y) -> System.out.println(x+"--"+y);

        biConsumer.accept(3,"hi");

        //Also her we can chek other Functions that are inside the package java.util.function; package

        // this operator exists because its better use primitive lamda expression because we are not wrapping clases no boxing and unboxing classes

        IntBinaryOperator intBinaryOperator = (x,y) -> x+y;

        //later we can look how to create an stream of primitives

        //IntBinaryOperator
        //IntConsumer
        //IntFunction
        //IntPredicate
        //IntSupplier
        //IntToDoubleFunction
        //IntToLongFunction
        //IntToUnaryOperator


    }

    public static void imprimir(Integer a){
        System.out.println(a);
    }
}
