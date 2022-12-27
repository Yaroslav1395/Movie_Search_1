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
        System.out.println("�������� � ����������");
        System.out.println("1 - ������� ��� ���������");
        System.out.println("2 - ����� �� ��������");
        System.out.println("3 - ����������� �� ��������");
        System.out.println("4 - ����������� �� ����");
        System.out.println("5 - ����������� �� ���������");
        System.out.println("6 - ����� ������� �� ������");
        System.out.println("7 - ����� ������� �� ���������");
        System.out.println("6 - ����� ������� �� ����");
        System.out.println("9 - �����");
    }
    private int userNumberInput(){
        System.out.println("������� ����� ��������");
        int userNumber = 0;
        try{
             userNumber = scanner.nextInt();
             if(userNumber > 9 || userNumber == 0){
                throw new RuntimeException();
             }
             else {
                 return userNumber;
             }
        }
        catch (InputMismatchException e){
            System.out.println("����� ������ ������ �����. ���������� �����");
            userNumberInput();
        }
        catch (RuntimeException e){
            System.out.println("������ �������� ���. ���������� �����");
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
                case 6 -> this.movies.searchByActor();
                case 7 -> this.movies.searchByDirector();
                case 8 -> this.movies.searchByYear();
                case 9 -> isEnd = true;
            }
        }

    }
}
