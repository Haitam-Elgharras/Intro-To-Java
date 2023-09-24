import java.util.Objects;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;
            
        // downcasting
        Point other = (Point) obj;
        if (x != other.x || y != other.y)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }  
}
