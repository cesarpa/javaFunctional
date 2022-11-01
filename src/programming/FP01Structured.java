package programming;

import java.util.List;
import java.util.stream.Collectors;

public class FP01Structured {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4);
        Integer sum = numbers.stream().reduce(0, (x, y) -> x + y);
        System.out.println(sum);


    }

    private static void printAllValuesInListSctructured(List<Integer> numbers) {
        for (Integer i : numbers) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}
