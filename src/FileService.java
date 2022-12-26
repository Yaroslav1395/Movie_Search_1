import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileService {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static Movies readGson(){
        Path path = Paths.get("movies.json");
        String jsonAsString = null;
        try {
            jsonAsString = Files.readString(path);
        }
        catch (IOException e){
            System.out.println("Файл не найден");
            e.printStackTrace();
        }
        return GSON.fromJson(jsonAsString, Movies.class);
    }

    public static void writeGson(Movies movies){
        String json = GSON.toJson(movies);
        Path path = Paths.get("movies.json");
        try {
            byte[] moviesAsString = json.getBytes();
            Files.write(path, moviesAsString);
        }
        catch (IOException e){
            System.out.println("Файл не записался");
            e.printStackTrace();
        }
    }
}
