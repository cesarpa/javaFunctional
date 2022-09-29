package programming;

import java.util.List;
import java.util.function.Predicate;

public class FP04CustomClass {

    public static void main(String[] args) {
        List<Course> courses = List.of(new Course("Spring", "Framework", 98, 20000),
                new Course("Azure", "Cloud", 95, 18000),
                new Course("API", "Microservices", 96, 11000),
                new Course("Microservices", "Framework", 97, 17000),
                new Course("AWS", "Cloud", 100, 30000),
                new Course("FullStack", "FullStack", 91, 10000)
                );

        // all match, noneMatch, anyMatch


        Predicate<Course> moreThan90Predicate = course -> course.getReviewScore() > 90;

        // I want to find out all the courses  that have a review socre greater than 95
        Predicate<Course> moreThan95Predicate = course -> course.getReviewScore() > 95;

        Predicate<Course> lessThan90Predicate = course -> course.getReviewScore() < 90 ;

        Predicate<Course> equalsTo100Predicate = course -> course.getReviewScore() == 100 ;

        System.out.println(courses.stream().allMatch(moreThan90Predicate));
        System.out.println(courses.stream().allMatch(moreThan95Predicate));
        System.out.println(courses.stream().allMatch(lessThan90Predicate));

        System.out.println(courses.stream().noneMatch(lessThan90Predicate));

        System.out.println(courses.stream().anyMatch(equalsTo100Predicate));
    }
}

class Course {
    public Course(String name, String category, int reviewScore, int noOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }

    private  String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", reviewScore=" + reviewScore +
                ", noOfStudents=" + noOfStudents +
                '}';
    }
}

