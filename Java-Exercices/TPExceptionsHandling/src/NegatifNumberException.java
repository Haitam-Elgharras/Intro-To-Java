import java.util.ArrayList;
import java.util.List;

public class NegatifNumberException  extends Exception{
    public static  List<Integer> notAcceptedValues = new ArrayList<Integer>();

    public NegatifNumberException(String message, int value) {
        super(message);
        notAcceptedValues.add(value);
    }
}
