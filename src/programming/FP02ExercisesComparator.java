package programming;

import java.util.Comparator;
import java.util.List;

public class FP02ExercisesComparator {

    public static void main(String[] args) {
        List<String> courses = List.of("Spring", "API", "Kubernetes", "Microservices", "AWS", "Azure");

        courses.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
        courses.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        //here we want to sort the courses by the length of the string
        courses.stream().sorted(Comparator.comparing(str -> str.length())).forEach(System.out::println);
    }
}
