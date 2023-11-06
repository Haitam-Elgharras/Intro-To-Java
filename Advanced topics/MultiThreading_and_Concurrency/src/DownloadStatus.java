import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DownloadStatus {
    private int totalBytes;
    private final Lock lock = new ReentrantLock();


    public int getTotalBytes() {
        return totalBytes;
    }

    public void incrementTotalBytes() {
        // when a thread is inside a critical section, we need to lock the object
        lock.lock();
        try {
            totalBytes++;
        } finally {
            lock.unlock();
        }
    }

}
