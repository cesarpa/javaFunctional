package programming;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

        List<Team> teams = List.of(new Team("Barcelona", 2, 25, "La liga"),
                new Team("Madrid", 1, 28, "La liga"),
                new Team("Arsenal", 2, 27, "Premier"),
                new Team("Tottenham", 3, 23, "Premier"),
                new Team("Man City", 2, 23, "Premier"));

        System.out.println(teams.stream().allMatch(t -> t.getPoints() > 25)); // false
        System.out.println(teams.stream().noneMatch(t -> t.getPoints() == 30)); // true
        System.out.println(teams.stream().anyMatch(t -> t.getPoints() == 30)); // true

        teams.stream().sorted(Comparator.comparing(Team::getPoints).reversed()).forEach(System.out::println);


        System.out.println(teams.stream().collect(Collectors.groupingBy(Team::getLeague)));

        System.out.println(teams.stream().collect(Collectors.groupingBy(Team::getLeague, Collectors.counting())));

        System.out.println(teams.stream().collect(Collectors.groupingBy(Team::getPoints, Collectors.mapping( Team::getName, Collectors.toList()))));

        System.out.println(teams.stream().collect(Collectors.groupingBy(Team::getLeague, Collectors.averagingInt(Team::getPoints))));




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

        // lets sort the courses
        Comparator comparingByNoOfStudentsIncreasing = Comparator.comparing(Course::getNoOfStudents);
        Comparator comparingByNoOfStudentsDecreasing = Comparator.comparing(Course::getNoOfStudents).reversed();

        System.out.println(
        courses.stream().sorted(comparingByNoOfStudentsIncreasing).collect(Collectors.toList()));

        System.out.println(
                courses.stream().sorted(comparingByNoOfStudentsDecreasing).collect(Collectors.toList()));

        // lets compare by numbers of reviews
        Comparator comparingByNoOfReviews = Comparator.comparing(Course::getReviewScore);
        System.out.println(
                courses.stream().sorted(comparingByNoOfReviews).collect(Collectors.toList())
        );

        // lets compare by numbers of students and Number of reviews
        Comparator comparingByNoOfStudentsAndNoOfReviews = Comparator.comparing(Course::getNoOfStudents)
                                    .thenComparing(Course::getReviewScore).reversed();
        System.out.println(
                courses.stream().sorted(comparingByNoOfStudentsAndNoOfReviews).collect(Collectors.toList())
        );


        // right here we wanna get the top five the first five
        // we can use a Limit
        System.out.println(
                courses.stream().sorted(comparingByNoOfStudentsAndNoOfReviews).limit(5).collect(Collectors.toList())
        );

        // skip function, would skip the first elements
        // also we can combine these operations too
        System.out.println(
                courses.stream().sorted(comparingByNoOfStudentsAndNoOfReviews).skip(3).limit(2).collect(Collectors.toList())
        );

        // here we can put a condition for take the courses
        System.out.println(courses.stream().takeWhile(c -> c.getReviewScore()>= 95).collect(Collectors.toList()));

        // but also we can do the opposite using dropWhile
        System.out.println(courses.stream().dropWhile(c -> c.getReviewScore()>= 95).collect(Collectors.toList()));

        System.out.println(courses.stream().max(Comparator.comparing(Course::getNoOfStudents).thenComparing(Course::getReviewScore)));

        System.out.println(courses.stream()
                        .filter( c -> c.getReviewScore() <= 90)
                        .min(Comparator.comparing(Course::getNoOfStudents).thenComparing(Course::getReviewScore))
                        .orElse(new Course("Kuberntes", "Cloud",91, 20000)));
        // Optional.empty

        // lets find the first Element with tha criteria

        System.out.println(courses.stream().filter(  c -> c.getReviewScore() <= 95)
                .findFirst());

        System.out.println(courses.stream().filter(  c -> c.getReviewScore() <= 95)
                .findAny());

        // SUM AVERAGE AND COUNT

        System.out.println(courses.stream()
                .filter(moreThan95Predicate)
                .mapToInt(Course::getNoOfStudents)
                .sum()); // 78000

        courses.stream()
                .filter(moreThan95Predicate)
                .mapToInt(Course::getNoOfStudents)
                .average();

        courses.stream()
                .filter(moreThan95Predicate)
                .count();


        // USING GROUP AND GROUPING BY

        // for example we want to group in a category like Cloud , Microservices or Framework
        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory)));
        // {Cloud=[Course{name='Azure', category='Cloud', reviewScore=95, noOfStudents=18000}, Course{name='AWS', category='Cloud', reviewScore=100, noOfStudents=30000}], FullStack=[Course{name='FullStack', category='FullStack', reviewScore=91, noOfStudents=10000}], Microservices=[Course{name='API', category='Microservices', reviewScore=96, noOfStudents=11000}], Framework=[Course{name='Spring', category='Framework', reviewScore=98, noOfStudents=20000}, Course{name='Microservices', category='Framework', reviewScore=97, noOfStudents=17000}]}


        // lets find just for a category and the numbers of courses for categories, we'll use counting()
        System.out.println(
                courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.counting()))
        );
        // {Cloud=2, FullStack=1, Microservices=1, Framework=2}

        // now we gonna group by category by just getting the max ReviewScore from each category

        System.out.println(
                courses.stream().collect(
                        Collectors.groupingBy(Course::getCategory, Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))
                )
        );
        // {Cloud=Optional[Course{name='AWS', category='Cloud', reviewScore=100, noOfStudents=30000}], FullStack=Optional[Course{name='FullStack', category='FullStack', reviewScore=91, noOfStudents=10000}], Microservices=Optional[Course{name='API', category='Microservices', reviewScore=96, noOfStudents=11000}], Framework=Optional[Course{name='Spring', category='Framework', reviewScore=98, noOfStudents=20000}]}

        // lets do the same but just mapping the name of the course

        System.out.println(
                courses.stream().collect(
                        Collectors.groupingBy(Course::getCategory, Collectors.mapping( Course::getName, Collectors.toList()))
                )
        );
        // {Cloud=[Azure, AWS], FullStack=[FullStack], Microservices=[API], Framework=[Spring, Microservices]}

        // with this  functional approach we understand what are we doing here

    }

}

class Team {
    private String name;
    private Integer position;
    private Integer points;
    private String league;

    public Team(String name, Integer position, Integer points, String league) {
        this.name = name;
        this.position = position;
        this.points = points;
        this.league = league;
    }

    @Override
    public String toString() {
        return "(Team:" + name +
                ", position=" + position +
                ", points=" + points +
                ", league='" + league + ")";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
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

