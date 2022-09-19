package programming;

import java.util.List;
import java.util.function.Supplier;

public class FP03MethodReferences {

    public static void main(String[] args) {
        List<String> courses = List.of("Spring","Spring Boot","API", "microservices");
        courses.stream()
                .map(String::toUpperCase) //here is being called with
                .forEach(FP03MethodReferences::print);

        Supplier<String> sup = String::new;
    }

    private static void print(String s){
        System.out.println(s);
    }
}
