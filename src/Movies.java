import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class Movies {
    private List<Movie> movies = new ArrayList<>();

    public Movies() {
    }

    public Movies(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Movie> getMovies() {
        return new ArrayList<>(this.movies);
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public void printMovies(){
        for (Movie movie: this.movies) {
            movie.printMovie();
        }
    }

    public void movieSearch(){
        System.out.println("¬ведите название");
        String movieName = new Scanner(System.in).nextLine();
        boolean isMovieNameInList = false;
        for (Movie movie: this.movies) {
            if(movie.getName().equals(movieName)){
                isMovieNameInList = true;
                movie.printMovie();
            }
        }
        if(!isMovieNameInList){
            for (Movie movie : this.movies) {
                if (movie.getName().contains(movieName)) {
                    movie.printMovie();
                }
            }
        }
    }

    public void sortByYear(){
        Set<Movie> movies = new TreeSet<>(new YearComparator().thenComparing(new DirectorComparator()));
        movies.addAll(this.movies);
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }
    public void sortByDirector(){
        Set<Movie> movies = new TreeSet<>(new DirectorComparator().thenComparing(new YearComparator()));
        movies.addAll(this.movies);
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }
    public void sortByName(){
        Set<Movie> movies = new TreeSet<>(new NameComparator());
        movies.addAll(this.movies);
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }
}
