public class Main {
    public static void main(String[] args) {
        var video = new Video();
        video.setFileName("birthday.mp4");
        video.setTitle("Jennifer's birthday");
        video.setUser(new User("john@domain.cm"));

        var processor = new VideoProcessor(
                new XVideoEncoder(),
                new MongodbDatabase(),
                new EmailService());

        processor.process(video);
    }
}