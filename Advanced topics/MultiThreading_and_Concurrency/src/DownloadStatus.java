import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DownloadStatus {
    private LongAdder  totalBytes=  new LongAdder();
    private int totalFiles;
    private final Object totalFilesLock = new Object();
    private volatile Boolean isDone = false;



    public void incrementTotalBytes() {
        totalBytes.increment();
    }

    // if we use synchronized keyword in different methods, with the same object,
    // so the two methods will be executed sequentially, not concurrently.
    public void incrementTotalFiles() {
        synchronized (totalFilesLock) {
            totalFiles++;
        }
    }

    public void done() {
        isDone = true;
    }

    public int getTotalBytes(){
        return totalBytes.intValue();
    }
    public int getTotalFiles() {
        return totalFiles;
    }

    public boolean isDone() {
        return isDone;
    }
}
