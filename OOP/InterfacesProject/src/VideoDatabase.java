public class VideoDatabase implements CanStore {
    @Override
    public void store(Video video) {
        System.out.println("Storing video metadata in a database...");
    }
}
