import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DownloadStatus {
    private int totalBytes;
    private int totalFiles;
    // it's just a convention to use object class as a lock
    // we can use any object as a lock
    private final Object totalBytesLock = new Object();
    private final Object totalFilesLock = new Object();



    public void incrementTotalBytes() {
        synchronized (totalBytesLock) {
            totalBytes++;
        }
    }

    // if we use synchronized keyword in different methods, with the same object,
    // so the two methods will be executed sequentially, not concurrently.
    public void incrementTotalFiles() {
        synchronized (totalFilesLock) {
            totalFiles++;
        }
    }

    public int getTotalBytes() {
        return totalBytes;
    }
    public int getTotalFiles() {
        return totalFiles;
    }


}
