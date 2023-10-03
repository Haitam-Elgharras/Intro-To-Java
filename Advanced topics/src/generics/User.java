package generics;

public class User implements Comparable<User> {
    private int points;

    public User(int points) {
        this.points = points;
    }

    // if we forget the type parameter <User> the compareTo method will accept an Object as a parameter
    @Override
    public int compareTo(User other) {
        System.out.println("from User.compareTo");
        return Integer.compare(points, other.points);
    }

    @Override
    public String toString() {
        return "Points=" + points;
    }

    public void print() {
        System.out.println("User");
    }
}
