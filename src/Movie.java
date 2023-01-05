import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Movie implements Comparator<Movies>{
    private String name;
    private int year;
    private String description;
    private Director director;
    private List<Actor> cast = new ArrayList<>();

    public Movie() {
    }

    public Movie(String name, int year, String description, Director director, List<Actor> cast) {
        this.name = name;
        this.year = year;
        this.description = description;
        this.director = director;
        this.cast = cast;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<Actor> getCast() {
        return new ArrayList<>(this.cast);

    }

    public void setCast(List<Actor> cast) {
        this.cast = cast;
    }

    public void printMovie(){
        System.out.printf("%s", this);
        printCast();
        System.out.println("-----------------------------------------------------");
    }

    @Override
    public String toString() {
        return  "Название: " + name +
                "\nГод: " + year +
                "\nОписание: " + description +
                "\nРежиссер: " + director +
                "\nВ ролях: ";
    }

    @Override
    public int compare(Movies o1, Movies o2) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return year == movie.year && name.equals(movie.name) && description.equals(movie.description) && director.equals(movie.director) && cast.equals(movie.cast);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year, description, director, cast);
    }

    private void printCast(){
        for (Actor actor: this.cast) {
            System.out.printf("%s ", actor);
        }
        System.out.println();
    }

    public void printSearchMovie(String userMovieSearch){
        if(name.contains(userMovieSearch)){
            System.out.println(this);
        }
    }
}
