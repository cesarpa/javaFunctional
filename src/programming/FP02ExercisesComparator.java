package programming;

import java.util.Comparator;
import java.util.List;

public class FP02ExercisesComparator {

    public static void main(String[] args) {
        List<String> colours = List.of("Red", "Green", "White", "Black");
        colours.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
        // Black Green Orange Red White
        //here we want to sort the courses by the length of the string
        colours.stream().sorted(Comparator.comparing(str -> str.length() == 3 ? Integer.MAX_VALUE : str.length())).forEach(System.out::println);
        // Red Green White Black Orange
    }
}
