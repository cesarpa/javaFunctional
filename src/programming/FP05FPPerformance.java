package programming;

import java.util.List;

public class FP05FPPerformance {

    public static void main(String[] args) {
        // performance conde in functional programing it was created 50 years ago
        // in these days of multicore processors we can parallelize functional code  much more easier

        List<String> courses = List.of("Spring", "Spring Boot" ,"API", "Microservices", "AWS", "Kubernetes");
        System.out.println(courses.stream().filter( c -> c.length() > 11).map(String::toUpperCase).findFirst());

        // then we wanna understand what is happening inside of the above code

        System.out.println(courses.stream().peek(System.out::println).filter( c -> c.length() > 11)
                .map(String::toUpperCase).peek(System.out::println).findFirst());

        /*
        Spring
        Spring Boot
        API
        Microservices
        MICROSERVICES
        Optional[MICROSERVICES]
         */

        // something that is interesting is that we didnt check the others elements
        // when it finds the first element it does not look for the other elements
        // all the inter    midiate operations are lazy, they are only executed when I execute  the terminal operation in this case findFirst()

        System.out.println(courses.stream().peek(System.out::println).filter( c -> c.length() > 11)
                .map(String::toUpperCase).peek(System.out::println));
        // java.util.stream.ReferencePipeline$11@566776ad

        // if you executes the same code without find first it do not return anything
    }
}
