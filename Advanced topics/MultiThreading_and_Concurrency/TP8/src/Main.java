public class Main {
    public static void main(String[] args) {

        for (int i=1;i<=10;i++){
            var thread = new Thread(new Talkative(i));
            thread.start();
        }

    }
}