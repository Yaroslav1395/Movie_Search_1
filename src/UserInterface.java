import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    private final Movies movies = FileService.readGson();
    private final Scanner scanner = new Scanner(System.in);

    public UserInterface() {
        actionDo();
    }

    private void printActions(){
        System.out.println("Действие с коллекцией");
        System.out.println("1 - Вывести всю коллекцию");
        System.out.println("2 - Найти по названию");
        System.out.println("3 - Сортировать по названию");
        System.out.println("4 - Сортировать по дате");
        System.out.println("5 - Сортировать по режиссеру");
        System.out.println("6 - Выход");
    }
    private int userNumberInput(){
        System.out.println("Введите номер действия");
        int userNumber = 0;
        try{
             userNumber = scanner.nextInt();
             if(userNumber > 6 || userNumber == 0){
                throw new RuntimeException();
             }
             else {
                 return userNumber;
             }
        }
        catch (InputMismatchException e){
            System.out.println("Ввели строку вместо цифры. Попробуйте снова");
            userNumberInput();
        }
        catch (RuntimeException e){
            System.out.println("Такого действия нет. Попробуйте снова");
            userNumberInput();
        }
        return 0;
    }

    private void actionDo(){
        boolean isEnd = false;
        printActions();
        while (!isEnd){
            switch (userNumberInput()) {
                case 1 -> this.movies.printMovies();
                case 2 -> {
                    this.movies.movieSearch();
                }
                case 3 -> this.movies.sortByName();
                case 4 -> this.movies.sortByYear();
                case 5 -> this.movies.sortByDirector();
                case 6 -> isEnd = true;
            }
        }

    }
}
