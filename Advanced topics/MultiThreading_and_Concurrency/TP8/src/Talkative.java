public class Talkative implements Runnable {

    public int nb;

    public Talkative(int nb) {
        this.nb =nb;
    }

    @Override
    public void run() {
        for (int i=0;i<10;i++)
            System.out.println(nb);
    }
}
