import java.io.BufferedReader;
import java.util.Scanner;

public class PhoneBookApp {
    private static Scanner scanner = new Scanner(System.in);

    public static void showMainMenu() {
        System.out.println(" _________________________________________________ ");
        System.out.println("|                                                 |");
        System.out.println("|               << Phone book  >>                 |");
        System.out.println("|                Choose action :                  |");
        System.out.println("|_________________________________________________|");
        System.out.println("|                                                 |");
        System.out.println("| 0 - Exit           ( Exit the program )         |");
        System.out.println("|-------------------------------------------------|");
        System.out.println("| 1 - Sign In        ( Enter go to existing user )|");
        System.out.println("|-------------------------------------------------|");
        System.out.println("| 2 - Sign Up        ( Register new user )        |");
        System.out.println("|-------------------------------------------------|");
        System.out.println("| 3 - Print Users    ( Print existing user )      |");
        System.out.println("|_________________________________________________|");
        System.out.println();
        System.out.print("Введите команду: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 0 -> System.exit(0);
//            case 1 -> signIn();
//            case 2 -> signUp();
//            case 3 -> printUsers();
//            default -> System.out.println("Unknown command. Try again!");
        }
    }
}
