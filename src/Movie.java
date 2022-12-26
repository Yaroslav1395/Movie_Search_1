import java.util.ArrayList;
import java.util.List;

public class Movie {
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
    private void printCast(){
        for (Actor actor: this.cast) {
            System.out.printf("%s ", actor);
        }
        System.out.println();
    }

}
