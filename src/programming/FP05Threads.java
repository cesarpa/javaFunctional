package programming;

import java.util.stream.IntStream;

public class FP05Threads {

    public static void main(String[] args) {
        // playing with threads using functional programming
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    System.out.println(Thread.currentThread().getId() + ":" + i);

                }
            }
        };

        // lets do de same thing using functional approach

        Runnable runnableFunctional = () -> {
            IntStream.range(0,10000).forEach(i -> System.out.println(Thread.currentThread().getId() + ":" + i));
        };

        // runnable is a functional interfaces then we can create the implementation

        Thread thread = new Thread(runnableFunctional);
        thread.start();

        Thread thread2 = new Thread(runnableFunctional);
        thread2.start();

        Thread thread3 = new Thread(runnableFunctional);
        thread3.start();


        // Using Functional Programming in Java Language
        // use the functional programming using list sets collections  or map
        // its important that everybodyis introduced to functional programming
    }

}
