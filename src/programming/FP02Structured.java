package programming;

import java.util.List;

public class FP02Structured {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1 ,4 ,8 ,5,20 ,4,23);
        System.out.println(addListStructured(numbers));
    }

    private static int sum(int a , int b){
        System.out.println("a:" +a +" b:"+b);
        return Integer.max(a,b);
    }

    private static int addListStructured(List<Integer> numbers) {

        // functional way , how do we add the numbers
        // combine into a 1 result
        // 0 and  (a,b) -> a+b FP02Functional::sum
        // trying to convert the number in one result --> this is called as reduce operation
        // we have sequence of numbers and we want to reduce it  to one result
        // here we have to specify what is thje method to reduce and the first parameter
        // first parameter is the identity value then the accumulation function then returns the reduce value parallelize
        return numbers.stream().reduce(0,(x,y)->(x+y));
                //.reduce(0, FP02Structured::sum);
                //.reduce(0, Integer::sum);
    }

    // traditional way: how to loop?, or how to store the sum
    /*int sum = 0;
        for (Integer n : numbers) {
        sum += n;
    }
        return sum;*/
}
