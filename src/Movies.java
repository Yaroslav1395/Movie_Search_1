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
        this.movies.forEach(movie -> movie.printSearchMovie(movieName));
    }

    public void sortByYear(){
        this.movies.sort(Comparator.comparingInt(Movie::getYear));
        printMovies();
    }
    public void sortByDirector(){
        this.movies.sort(Comparator.comparing(o -> o.getDirector().getFullName()));
        printMovies();
    }
    public void sortByName(){
        this.movies.sort(Comparator.comparing(Movie::getName));
        printMovies();
    }
    public void searchByActor(){
        Map<String, List<Movie>> actorMap= new HashMap<>();
        Set<String> actorName = new HashSet<>();
        for (Movie movie : this.movies) {
            for (int j = 0; j < movie.getCast().size(); j++) {
                actorName.add(movie.getCast().get(j).getFullName());
            }
        }
        for (String actor: actorName) {
            List<Movie> movies1 = new ArrayList<>();
            for (Movie movie : this.movies) {
                for (int i = 0; i < movie.getCast().size(); i++){
                    if(actor.contains(movie.getCast().get(i).getFullName())){
                        movies1.add(movie);
                    }
                }
            }
            actorMap.put(actor, movies1);
        }
        System.out.println(actorMap.get(userInputSearch("¬ведите им€")));
    }
    public void searchByDirector(){
        Map<String, List<Movie>> directorMap= new HashMap<>();
        Set<String> directorName = new HashSet<>();
        for (Movie movie : this.movies) {
            directorName.add(movie.getDirector().getFullName());
        }
        for (String director: directorName) {
            List<Movie> movies1 = new ArrayList<>();
            for (Movie movie : this.movies) {
                if(movie.getDirector().getFullName().equals(director)){
                    movies1.add(movie);
                }
            }
            directorMap.put(director, movies1);
        }
        System.out.println(directorMap.get(userInputSearch("¬ведите им€")));
    }
    public void searchByYear(){
        Map<String, List<Movie>> yearMap= new HashMap<>();
        Set<String> year = new HashSet<>();
        for (Movie movie : this.movies) {
            year.add(String.valueOf(movie.getYear()));
        }
        for (String year1: year) {
            List<Movie> movies1 = new ArrayList<>();
            for (Movie movie : this.movies) {
                if(String.valueOf(movie.getYear()).equals(year1)){
                    movies1.add(movie);
                }
            }
            yearMap.put(year1, movies1);
        }
        System.out.println(yearMap.get(userInputSearch("¬ведите год")));
    }
    private String userInputSearch(String whatSearch){
        System.out.println(whatSearch);
        return new Scanner(System.in).nextLine();
    }
}
