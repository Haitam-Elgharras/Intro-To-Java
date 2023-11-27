import java.util.List;

public interface IMetier<T> {
    public boolean add(T t);
    public void delete(long id);
    public T findById(long id);
    public List<T> getAll();
}
