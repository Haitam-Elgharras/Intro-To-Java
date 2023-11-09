import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

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

      /*  System.out.println("#################### Confinement ####################");
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

        System.out.println(totalBytes);*/


        //
      /*  System.out.println("#################### Locks ####################");

        var status = new DownloadStatus();
        var threads = new ArrayList<Thread>();
        for (int i = 0; i < 10; i++) {
            var thread = new Thread(new DownloadFileTask(status));
            thread.start();
            threads.add(thread);
        }

        for (var thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(status.getTotalBytes());*/


     /*   System.out.println("#################### Synchronized ####################");
        var status = new DownloadStatus();
        var threads = new ArrayList<Thread>();
        for (int i = 0; i < 10; i++) {
            var thread = new Thread(new DownloadFileTask(status));
            thread.start();
            threads.add(thread);
        }

        for (var thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(status.getTotalBytes());
    }*/


        /*System.out.println("#################### Volatile ####################");
        var status = new DownloadStatus();
        Thread thread1 = new Thread(new DownloadFileTask(status));
        Thread thread2 = new Thread(() -> {
            while (!status.isDone()) {
            }
            System.out.println(status.getTotalBytes());
        });
        thread1.start();
        thread2.start();*/

       /* System.out.println("#################### wait and notify ####################");
        var status = new DownloadStatus();
        Thread thread1 = new Thread(new DownloadFileTask(status));
        Thread thread2 = new Thread(() -> {
            while (!status.isDone()) {
                synchronized (status) {
                    try {
                        status.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println(status.getTotalBytes());
        });

        thread1.start();
        thread2.start();*/


        System.out.println("#################### Thread safe collections ####################");
        Collection<Integer> collection = Collections.synchronizedCollection(new ArrayList<>());
        var threadC1 = new Thread(() -> {
            collection.addAll(List.of(1, 2, 3));
        });
        var threadC2 = new Thread(() -> {
            collection.addAll(List.of(4, 5, 6));
        });

        threadC1.start();
        threadC2.start();

        try {
            threadC1.join();
            threadC2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(collection);


        System.out.println("#################### Concurrent collections ####################");
        Map<Integer, String> map = new ConcurrentHashMap<>();

    }
}
