import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsDemo {
public void show() {
    System.out.println("############ What streams come to solve ############");

    List<Movie> movies = List.of(
        new Movie("a", 10, Genre.THRILLER),
        new Movie("b", 15, Genre.ACTION),
        new Movie("c", 20,Genre.ACTION)
    );
    // Imperative programming: How to do things
    int count = 0;
    for (var movie : movies)
        if (movie.getLikes() > 10)
            count++;

    // Streams: Declarative programming: What to do
    var count2 = movies.stream()
        .filter(movie -> movie.getLikes() > 10)
        .count();
    System.out.println(count2);//2


    System.out.println("################## Creating Streams ############");
    // From a collection
    List<Integer> list = new ArrayList<>();
    list.stream()
            .forEach(n -> System.out.println(n));

    // From an array: array doesnt have a stream
    int[] array = { 1, 2, 3 };
    Arrays.stream(array)
            .forEach(System.out::println);

    // From an arbitrary number of objects
    Stream.of(1, 2, 3)
            .forEach(n -> System.out.println(n));

    // Generate from scratch: infinite generator that we don't have in collections
    Stream.generate(Math::random)
            .limit(3)
            .forEach(n -> System.out.println(n));

    // Generate from scratch
    Stream.iterate(1, n -> n + 1)
            .limit(10)
            .forEach(System.out::println);


    System.out.println("################## Mapping ############");

    // map: transform an object into another type of object
    var moviesList=movies.stream()
            .map(movie -> movie.getTitle())
            .toList();
    System.out.println(moviesList);//[a, b, c]

    // flatMap: transform an object into a stream of objects
    // for example a stream of lists into a stream of objects inside the lists
    var stream = Stream.of(List.of(1, 2, 3), List.of(4, 5, 6));
    stream
            .flatMap(list1 -> list1.stream())
            .forEach(System.out::println);


    System.out.println("################## Filtering ############");

    Predicate<Movie> isPopular = movie -> movie.getLikes() > 10;
    movies.stream()
            .filter(isPopular)
            .forEach(movie -> System.out.println(movie.getTitle()));


    System.out.println("################## Slicing ############");
    // example for pagination
    // 1000 movies
    // 10 movies per page
    // 3rd page
    // skip(20) skip first 20 movies= skip((page-1)*pageSize)
    // limit(10) limit to 10 movies= limit(pageSize)
    movies.stream()
            .skip(20)
            .limit(10)
            .forEach(movie -> System.out.println(movie.getTitle()));

    // takeWhile: take movies while the condition is true
    movies.stream()
            .takeWhile(movie -> movie.getLikes() < 30)
            .forEach(movie -> System.out.println(movie.getTitle()));
    // dropWhile: drop movies while the condition is true and then take the rest
    movies.stream()
            .dropWhile(movie -> movie.getLikes() >20)
            .forEach(movie -> System.out.println(movie.getTitle()));// movies with likes under 20


    System.out.println("################## Sorting ############");

    movies.stream()
            .sorted((a, b) -> a.getTitle().compareTo(b.getTitle()))             // passing a lambda expression
            .sorted(Comparator.comparing((Movie movie) -> movie.getTitle()))   // passing a comparator
            .sorted(Comparator.comparing(Movie::getTitle))
            .forEach(movie -> System.out.println(movie.getTitle()));

    // to get Distinct elements
    movies.stream()
            .map(Movie::getLikes)
            .distinct()
            .forEach(System.out::println);


    System.out.println("################## Peeking ############");
    // peek: to debug the stream
    movies.stream()
            .filter(movie -> movie.getLikes() > 10)
            .peek(movie -> System.out.println("filtered: " + movie.getTitle()))
            .map(Movie::getTitle)
            .peek(title -> System.out.println("mapped: " + title))
            .forEach(System.out::println);


    System.out.println("################## Reducing ############");
   // to get the movie with the highest likes
    var result2 = movies.stream()
            .max(Comparator.comparing(Movie::getLikes))
            .get();
            System.out.println(result2.getTitle());//Movie [title=c,...]

    // allMatch, anyMatch, noneMatch
    var result3 = movies.stream()
            .allMatch(movie -> movie.getLikes() > 10);
            System.out.println(result3);//false cause not all movies have likes over 10

    var result4 = movies.stream()
                        .anyMatch(movie -> movie.getLikes() > 10);
    System.out.println(result4); //true cause at least one movie has likes over 10

    var result5 = movies.stream()
                        .noneMatch(movie -> movie.getLikes() > 10);
    System.out.println(result5); //false cause at least one movie has likes over 10

    // findFirst, findAny
    var result6 = movies.stream()
                        .findAny();
    // cause the get method can throw an exception we use orElse
    System.out.println(result6.orElse(null)); //Movie [title=a,...]


     // reduce method: to reduce the stream to a single value
    var result = movies.stream()
            .map(Movie::getLikes)
            .reduce(0, (a, b) -> a + b);
    // the initial value is 0, and the accumulator is the sum
    // this initial value protects us from null pointer exception
    System.out.println(result);//45



    System.out.println("################## Collectors: Streams into Data Structures ############");

    var result7 = movies.stream()
            .filter(movie -> movie.getLikes() > 10)
            .collect(Collectors.toMap(
                    Movie::getTitle,
                    Function.identity()// movie -> movie
            ));
    System.out.println(result7);//{b=Movie [title=b,...], c=Movie [title=c,...]}

    // the best one is summarizingInt, it gives us a summary of the stream
    var result8 = movies.stream().collect(Collectors.summarizingInt(Movie::getLikes));
    //IntSummaryStatistics{count=3, sum=45, min=10, average=15.000000, max=20}
    System.out.println(result8);

    // joining values using a delimiter (into a string)
    var result9 = movies.stream()
                        .map(Movie::getTitle)
                        .collect(Collectors.joining("|"));//a|b|c



    System.out.println("################## Grouping ############");
    // groupingBy: to group the movies Genre
    var result10 = movies.stream()
            .collect(Collectors.groupingBy(Movie::getGenre));

    // groupingBy: to group the movies Genre and count the number of movies in each group
    var result11 = movies.stream()
            .collect(Collectors.groupingBy(Movie::getGenre, Collectors.counting()));

    // groupingBy: to group the movies Genre and get the titles of the movies in each group
    var result12 = movies.stream()
            .collect(Collectors.groupingBy(Movie::getGenre,
            Collectors.mapping(Movie::getTitle, Collectors.joining(","))));

    System.out.println(result12);//{ACTION=b,c, THRILLER=a}



    System.out.println("################## Partitioning ############");

    // partitioningBy: to partition the movies into two groups
    // movies with likes over 10 and movies with likes under 10
    var result13 = movies.stream()
            .collect(Collectors.partitioningBy(movie -> movie.getLikes() > 10));
    System.out.println(result13);//{false=[Movie [title=a,...]], true=[Movie [title=b,...], Movie [title=c,...]]

    // partitioningBy: straming the movies and partitioning
    var result14 = movies.stream()
            .collect(Collectors.partitioningBy(
                    movie -> movie.getLikes() > 10,
                    Collectors.mapping(Movie::getTitle,
                                        Collectors.joining(","))));


    System.out.println("################## Primitive Streams ############");
    // IntStream, LongStream, DoubleStream
    var result15 = IntStream.rangeClosed(1, 5)
            .sum(); // 15
    // mapToInt: to convert a stream of objects into a stream of ints (IntStream)
    var movies2 = movies.stream()
            .mapToInt(Movie::getLikes)
            .sum(); // 45

}


}
