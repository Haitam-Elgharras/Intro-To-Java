import java.util.ArrayList;
import java.util.List;

public class EntierNaturel {
    private int value;

    public EntierNaturel(int value) throws NegatifNumberException{
        if (value < 0) {
            // store
            throw new NegatifNumberException("Entier naturel doit etre positif",value);
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) throws NegatifNumberException{
        if (value < 0)
            throw new NegatifNumberException("On ne peut pas mettre une valeur negative",value);
        this.value = value;
    }

    public void decrement() throws NegatifNumberException{
        if (value == 0)
            throw new NegatifNumberException("On ne peut pas decrementer",value - 1);

        value--;
    }
}
