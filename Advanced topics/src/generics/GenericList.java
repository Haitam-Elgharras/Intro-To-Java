package generics;

import java.util.ArrayList;
import java.util.List;

public class GenericList<T extends Comparable<T>> {
    // when using bounded type parameters, we can't use private T[] items = (T[]) new Object[10];
    // cause the T will be erased to the bound type (in this case Comparable) and we can't cast Object[] to Comparable[]
    // instead we use the following:
    private List<T> items = new ArrayList<>();
    private int count;

    public void add(T item) {
        items.add(item);
    }
    public T get(int index) {
       return items.get(index);
    }
}
