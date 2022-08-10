package programming;

import java.util.List;

public class FP01 {

    public static void main(String[] args) {
        printAllValuesInListSctructured(List.of(12,5,8,9,7));
    }

    private static void printAllValuesInListSctructured(List<Integer> numbers) {
        // how to loop the numbers
        // enhance loop
        for (Integer i : numbers){
            System.out.println(i);
        }
    }
}
