package programming;

import java.util.List;
import java.util.stream.Collectors;

public class FP02ExercisesCollectingStreams {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);

        // If I have a list of numbers  and we wanna create another list of their squares
        List<Integer> doubledNumbers = squareNumbers(numbers);
        System.out.println(doubledNumbers);



        // Exercise 10
        // Create a list with even numbers filtered from the numbers list
        System.out.println(evenNumbersFiltered(numbers));


        // Exercise 11
        // Create a list with lengths of all courses titles
        List <String> courses = List.of("Spring", "API", "Kubernetes", "Microservices", "AWS", "Azure");
        List <Integer> lengthCoursesList = getListWithLengthCourses(courses);
        System.out.println(lengthCoursesList);


        // Summarize
        // Intermediate and Terminal Stream Operations
        numbers.stream()
                .distinct() // return a Stream<T> Intermediate Operations
                .sorted()   // returns a Stream<T>
                .map(m -> 2*m) // return Stream<R> as well (this execute an streams and maps the element  into a different value but the output is an Stream
                .filter(f -> f%2==0) //  Stream<T> filter
                .forEach(System.out::println); // Terminal operation returning a void (returning other than Stream)

        // the operations mentioned above performs an Stream and returns an Steam back
    }

    private static List<Integer> squareNumbers(List<Integer> numbers) {

        //Collectors . to list returns a collector that accumulate the input elements into a new List
        return numbers.stream().map(m -> m*m).collect(Collectors.toList());
    }

    private static List<Integer> evenNumbersFiltered(List<Integer> numbers) {
        // Create a list with even numbers filtered from the numbers list
        return numbers.stream().filter(m -> m%2 ==0).collect(Collectors.toList());
    }

    private static List<Integer> getListWithLengthCourses(List<String> courses) {
        return courses.stream().map(m -> m.length()).collect(Collectors.toList()); // Return an specific type  R
    }
}
