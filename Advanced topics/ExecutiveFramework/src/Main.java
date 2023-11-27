import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        try {
            for (int i = 0; i < 10; i++)
                executor.submit(() -> {
                    System.out.println(Thread.currentThread().getName());
                });
        } finally {
            executor.shutdown();
        }

    }
}