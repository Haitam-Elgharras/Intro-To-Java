public class VideoProcessor {
    private CanEncodeVideo encoder;
    private CanStore database;
    private CanNotify service;

    public VideoProcessor(CanEncodeVideo encoder, CanStore database, CanNotify service) {
        this.encoder = encoder;
        this.database = database;
        this.service = service;
    }
    public void process(Video video) {
        encoder.encode(video);

        database.store(video);

         service.notify(video.getUser());
    }
}
