package programming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FP05JoiningStrings {

    public static void main(String[] args) {
        List<String> courses = List.of("Spring", "Kubernetes", "Azure", "AWS", "Docker");

        // we can join strings using the collector joining
        System.out.println(courses.stream().collect(Collectors.joining(" ")));

        // also we can separate by other characters like the Coma
        System.out.println(courses.stream().collect(Collectors.joining(",")));

        List<Integer> numbers = List.of(2,4,6,5,7,8);

        int suma =numbers.stream().reduce(0, (x,y) -> x +y);
        System.out.println(suma);
        List<Integer> numbers2 = List.of(1,2,3,4,5,5);
        System.out.println(numbers2.stream().collect(Collectors.groupingBy(Integer::intValue, Collectors.counting())));
        // {1=1, 2=1, 3=1, 4=1, 5=2}

        // we want to search what are the characters what are presents in each on of theses strings
        courses.stream().map(course -> course.split("")).collect(Collectors.toList());
        // here we are passing an stream with array of strings

        // but in order to pass only the String we have to ensure to flatten the array of the strings using flatMap
        System.out.println(courses.stream().map(course -> course.split("")).flatMap(Arrays::stream).collect(Collectors.toList()));
        // [S, p, r, i, n, g, K, u, b, e, r, n, e, t, e, s, A, z, u, r, e, A, W, S, D, o, c, k, e, r]
        // also in order to just see the characters we can use the distinct
        System.out.println(courses.stream().map(course -> course.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList()));
        // [S, p, r, i, n, g, K, u, b, e, t, s, A, z, W, D, o, c, k]

        // here we are taking each of teh course from one list and try to map each of the courses
        List<String> courses2 = List.of("Spring", "Kubernetes", "Azure", "AWS", "Docker");
        System.out.println(courses.stream().flatMap( course -> courses2.stream().map(course2 -> List.of(course, course2))).collect(Collectors.toList()));
        // [[Spring, Spring], [Spring, Kubernetes], [Spring, Azure], [Spring, AWS], [Spring, Docker], [Kubernetes, Spring], [Kubernetes, Kubernetes], [Kubernetes, Azure], [Kubernetes, AWS], [Kubernetes, Docker], [Azure, Spring], [Azure, Kubernetes], [Azure, Azure], [Azure, AWS], [Azure, Docker], [AWS, Spring], [AWS, Kubernetes], [AWS, Azure], [AWS, AWS], [AWS, Docker], [Docker, Spring], [Docker, Kubernetes], [Docker, Azure], [Docker, AWS], [Docker, Docker]]

        // here we are having some items that are repeated we are gonna filter
        System.out.println(courses.stream().flatMap( course -> courses2.stream().map(course2 -> List.of(course, course2)))
                        .filter(list -> !list.get(0).equals(list.get(1)))
                .collect(Collectors.toList()));

        // then we wanna filter by the length of the course1 and course2
        System.out.println(courses.stream().flatMap( course -> courses2.stream().filter(course2 -> course2.length() == course.length())
                        .map(course2 -> List.of(course, course2)))
                .filter(list -> !list.get(0).equals(list.get(1)))
                .collect(Collectors.toList()));







    }
}
