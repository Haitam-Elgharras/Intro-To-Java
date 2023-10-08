import java.util.ArrayList;
import java.util.Iterator;

public class Generic <T extends Comparable<T>> implements Iterable<T> {
    private final ArrayList<T> items=new ArrayList<>();

    public void setItem(int index, T item) {
        items.add(index, item);
    }

    public T getItem(int index) {
        return items.get(index);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < items.size();
            }

            @Override
            public T next() {
                return getItem(index++);
            }
        };
    }
}
