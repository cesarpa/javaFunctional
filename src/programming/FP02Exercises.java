package programming;

import java.util.List;

public class FP02Exercises {

    public static void main(String[] args) {
        List <Integer> numbers = List.of(2,2,3,4,1);
        System.out.println(getSumOfSquares(numbers));
        System.out.println(sumOfOddNumbers(numbers));

        //using distinct, does not print duplicated numbers
        numbers.stream().distinct().forEach(System.out::println);

        //sorted, also we can use sorted
        numbers.stream().sorted().forEach(System.out::println);
        // both
        numbers.stream().distinct().sorted().forEach(System.out::println);
    }

    private static int getSumOfSquares(List<Integer> numbers){
        return numbers.stream().map(i -> i*i).reduce(0,Integer::sum);
    }

    private static int getSumOfCubes(List<Integer> numbers){
        return numbers.stream().map(i -> i*i*i).reduce(0, (x,y) -> x+y);
    }

    private static int sumOfOddNumbers(List<Integer> numbers){
        return numbers.stream().filter(i -> i%2!=0).reduce(0, (x,y)-> x+y);
    }
}
