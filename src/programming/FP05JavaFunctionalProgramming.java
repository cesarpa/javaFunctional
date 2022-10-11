package programming;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class FP05JavaFunctionalProgramming {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(2,9,13,4,16,8,15);
        System.out.println(numbers.stream());

        // also we can create a stream in a different way
        Stream.of(2,9,13,4,16,8,15).count();

        Stream.of(2,9,13,4,16,8,15).reduce(0, (x,y) -> x +y );

        int [] numbers2 = { 2,9,13,4,16,8,15};
        System.out.println(Arrays.stream(numbers2));

        System.out.println(Arrays.stream(numbers2).max());

        // new algorithm to streams numbers

        IntStream.range(1,10);

        System.out.println(IntStream.range(1,10).sum());
        //excludes the last number in this case 10


        System.out.println(IntStream.rangeClosed(1,10).sum()); // 55
        //also here the 10 is included

        System.out.println(IntStream.iterate(1, e -> e+2).limit(10).sum());

        System.out.println(IntStream.iterate(1, e -> e+2).limit(10).peek(System.out::println).sum());
        // here the peek allow us to look into the stream without making any changes

        // calculate the first 10 even numbers and the sume
        IntStream.iterate(2 , e ->e + 2).limit(10).peek(System.out::println).sum();


        // same but instead the first 10 powers of 2
        IntStream.iterate(2 , e ->e * 2).limit(10).peek(System.out::println).sum();


        // also we can convert it into a list
        // calculate the first 10 even numbers and the sume
        IntStream.iterate(2 , e ->e + 2).limit(10).boxed().collect(Collectors.toList());
        // but first is needed the boxed function then we have the list of numbers

        // tip for calculate large numbers
        // Integer.MAX_VALUE;

        System.out.println(IntStream.rangeClosed(1,50).reduce(1, (x,y) -> x*y)); //returns 0
        // why returns Zero ?? because the result exceeds the limit of an Integer Value

        System.out.println(LongStream.rangeClosed(1,50).reduce(1L, (x, y) -> x*y));
        // notice that even when we use a LongSteam it returns a negative value
        // -3258495067890909184


        // then we can use something that is called Big Integer value
        System.out.println(LongStream.rangeClosed(1,50).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply));
        // then the result is 30414093201713378043612608166064768844377641568960512000000000000
    }
}
