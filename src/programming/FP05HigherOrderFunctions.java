package programming;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP05HigherOrderFunctions {

    public static void main(String[] args) {


        // HIGHER ORDER FUNCTIONS
        // this is a function that returns a function

        List<Course> courses = List.of(new Course("Spring", "Framework", 98, 20000),
                new Course("Azure", "Cloud", 95, 18000),
                new Course("API", "Microservices", 96, 11000),
                new Course("Microservices", "Framework", 97, 17000),
                new Course("AWS", "Cloud", 100, 30000),
                new Course("FullStack", "FullStack", 91, 10000)
        );



        Predicate<Course> lessThan90Predicate = course -> course.getReviewScore() < 90 ;


        // here we have a couple of predicates
        // we want to return the logic from a new nethod

        int cutOffReviewScore = 95;


        // then use it here
        Predicate<Course> moreThan95Predicate =  createPredicateWithCutOffReviewScore(95);

        Predicate<Course> moreThan90Predicate =  createPredicateWithCutOffReviewScore(90);

        // then here we extract the logic into a method
        // click refactor extract method
        // AND is called a HIGHER ORDER FUNCTION


        List<Integer> numbers = List.of(12, 9, 4, 6, 12, 15);

        // Function<Integer, Integer> squareFunction = x -> x * x;

        List<Integer> squareNumbers = getListBasedOnFunction(numbers, x -> x * x);

        List<Integer> cubedNumbers = getListBasedOnFunction(numbers, x -> x * x);

        List<Integer> doubledNumbers = getListBasedOnFunction(numbers, x -> x + x);

        System.out.println(doubledNumbers);

        // here we can see the differences between behavior parametrization and returning a method from a method


    }

    private static Predicate<Course> createPredicateWithCutOffReviewScore(int cutOffReviewScore) {
         return course ->  course.getReviewScore() > cutOffReviewScore;
         // here we are returning logic back
    }

    private static List<Integer> getListBasedOnFunction(List<Integer> numbers, Function<Integer, Integer> numerFunction) {
        return numbers.stream().map(numerFunction).collect(Collectors.toList());
    }
}
