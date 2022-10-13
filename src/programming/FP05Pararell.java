package programming;

import java.util.stream.LongStream;

public class FP05Pararell {

    public static void main(String[] args) {

        // Parallelization of Streams
        // when we write code we would want to make use of that

        // 0 , 100000000000

        long time = System.currentTimeMillis();

        //System.out.println(LongStream.range(0,1000000000).sum());
        // it prints 499999999500000000
        // 1769
        System.out.println(LongStream.range(0,1000000000).parallel().sum());
        // it prints 499999999500000000
        // 218

        System.out.println(System.currentTimeMillis() - time);

        // now lets run the same but in parallel

        // why is it easier to parallelize functional code?
        // they basically can split but in structured code is imposible because a value change constantly
        // performance code with fucnional programming

    }
}
