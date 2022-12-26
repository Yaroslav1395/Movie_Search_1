import java.util.Comparator;

public class DirectorComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie o1, Movie o2) {
        return o1.getDirector().getFullName().compareTo(o2.getDirector().getFullName());
    }
}
