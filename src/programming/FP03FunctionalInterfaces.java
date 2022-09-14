package programming;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP03FunctionalInterfaces {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12,9,13,4,6,2,4);

        Predicate<Integer> isEvenPredicate = x -> x %2==0;

        Function<Integer, Integer> squareFunction = x-> x*x;
        //recive an integer returns an integer

        Consumer<Integer> sysoutCOnsumer = x -> System.out.println(x);
        // take and indput but do not return anything

        BinaryOperator<Integer> sumBinaryOperator = (x,y) -> x+y;
        // use to pass lambda expressions

        //Suplier
        
    }
}
