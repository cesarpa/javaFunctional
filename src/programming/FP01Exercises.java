package programming;

import java.util.List;

public class FP01Exercises {

    public static void main(String[] args) {
        printOddNumbers(List.of(12, 5, 8, 9, 88));
        printAllCoursesIndividually(List.of("Math","Physic","Algebra"));
        printCoursesSpringKeyword(List.of("Spring","Spring Course","Algebra"));
        printCoursesAtLeast4Letters(List.of("S3","Kubernetes","AWS"));
        printCubesOfOddsNumbers(List.of(12, 5, 8, 9, 88));
        printNumberOfCharactersInEachCourseName(List.of("S3","Kubernetes","AWS"));
    }

   private static void printOddNumbers(List<Integer> numbers){
        numbers.stream().filter(i -> i%2 !=0).forEach(System.out::println);
   }

   private static void printAllCoursesIndividually(List<String> courses){
        courses.stream().forEach(System.out::println);
   }

   private static void printCoursesSpringKeyword(List<String> courses){
        courses.stream().filter(i -> i.contains("Spring")).forEach(System.out::println);
   }

   private static void printCoursesAtLeast4Letters(List<String> courses){
        courses.stream().filter( i -> i.length()>= 4).forEach(System.out::println);
   }

   private static void printCubesOfOddsNumbers(List<Integer> numbers){
        numbers.stream().filter(i -> i%2 !=0).map( i -> i * i * i ).forEach(System.out::println);
   }

   private static void printNumberOfCharactersInEachCourseName(List<String> courses){
        courses.stream().map(i -> i + " " + i.length()).forEach(System.out::println);
   }
}
