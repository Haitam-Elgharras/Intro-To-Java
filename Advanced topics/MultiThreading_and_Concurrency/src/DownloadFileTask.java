public class DownloadFileTask implements Runnable {
    private final DownloadStatus status;

    public DownloadFileTask(DownloadStatus status) {
        this.status = status;
    }

    @Override
    public void run() {
        System.out.println("Downloading a file: " + Thread.currentThread().getName());

        // Simulate a long download
        for (var i = 0; i < 1_000_000; i++) {
            status.incrementTotalBytes();
        }
        System.out.println("Download complete: " + Thread.currentThread().getName());
        status.done();
        synchronized (status) {
            status.notifyAll();
        }
    }

//    @Override
//    public void run() {
//        System.out.println("Downloading a file: " + Thread.currentThread().getName());
//
//        // Simulate a long download
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Download complete: " + Thread.currentThread().getName());
//
//    }



}
