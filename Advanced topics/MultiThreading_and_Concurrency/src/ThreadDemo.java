import java.util.ArrayList;

public class ThreadDemo {
//    public static void show() {
//        System.out.println(Thread.currentThread().getName());// main
//
//        // Ten threads are created and they are running in parallel
//        for (int i = 0; i < 10; i++) {
//            Thread thread = new Thread(new DownloadFileTask());
//            thread.start();
//        }
//
//        System.out.println("#################### Joining threads ####################");
//        // The main thread waits for all the threads to finish before it continues
//        Thread thread = new Thread(new DownloadFileTask());
//        thread.start();
//        try {
//            thread.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("File is ready to be scanned.");
//
//        System.out.println("#################### Interrupting threads ####################");
//        thread = new Thread(new DownloadFileTask());
//        thread.start();
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("Interrupting thread");
//        thread.interrupt();
//    }

    public static void show() {
  /*      System.out.println("#################### Race condition ####################");
        var status = new DownloadStatus();
        var threads = new ArrayList<Thread>();
        for (int i = 0; i < 10; i++) {
            var thread = new Thread(new DownloadFileTask(status));
            thread.start();
            threads.add(thread);
        }

        for (var thread : threads)
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        System.out.println(status.getTotalBytes());

    }*/

        System.out.println("#################### Confinement ####################");
        var threads = new ArrayList<Thread>();
        var tasks = new ArrayList<DownloadFileTask>();

        for (int i = 0; i < 10; i++) {
            var task = new DownloadFileTask();
            tasks.add(task);
            var thread = new Thread(task);
            thread.start();
            threads.add(thread);
        }

        for (var thread : threads)
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        var totalBytes = tasks.stream()
                .mapToInt(task -> task.getStatus().getTotalBytes())
                .sum();

        System.out.println(totalBytes);


    }

}
