import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// working with the Iterable interface
public class Iterable<T> implements java.lang.Iterable<T> {
    // when using bounded type parameters, we can't use private T[] items = (T[]) new Object[10];
    // cause the T will be erased to the bound type (in this case Comparable) and we can't cast Object[] to Comparable[]
    // instead we use the following:
    private List<T> items = new ArrayList<>();
    public void add(T item) {
        items.add(item);
    }
    public T get(int index) {
        return items.get(index);
    }


    @Override
    public Iterator<T> iterator() {
        return new ListIterator(this);
    }

    private class ListIterator implements Iterator<T> {
        private Iterable<T> list;
        private int index;

        public ListIterator(Iterable<T> list) {
            this.list = list;
        }

        // we have access to the private fields of the outer class
        // because the inner class is a member of the outer class
        @Override
        public boolean hasNext() {
            return index < list.items.size();
        }

        @Override
        public T next() {
            return list.get(index++);
        }
    }
}
