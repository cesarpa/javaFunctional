package programming;

import java.util.ArrayList;
import java.util.List;

public class FP06ModifyingLists {

    public static void main(String[] args) {
        // lets do a simple modifications on a list using java functional
        List<String> courses = List.of("Spring", "Spring Boot" ,"API", "Microservices", "AWS", "Kubernetes");
        // courses.replaceAll(str -> str.toUpperCase()); // acept a funcition as a parameter
        // it fails then we are gonna create a list of modify courses, lets crete an ArrayList

        List<String> modifyableCourses = new ArrayList(courses);
        modifyableCourses.replaceAll(str -> str.toUpperCase());
        System.out.println(modifyableCourses);
        // [SPRING, SPRING BOOT, API, MICROSERVICES, AWS, KUBERNETES]

        System.out.println(modifyableCourses.removeIf(course -> course.length() < 6));
        // true
        System.out.println(modifyableCourses);
        // [SPRING, SPRING BOOT, MICROSERVICES, KUBERNETES]
    }
}
