import java.util.function.Consumer;

public class ConsumerInteger implements Consumer<Integer> {

    @Override
    public void accept(Integer s) {
        System.out.println(s);
    }
}
