import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBookApp {
    private static UserManager userManager = new UserManager();

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        startMenu();
    }

    private static void startMenu() throws InterruptedException {
        while (true) {
            userManager.loadUsers();
            Menu.showStartMenu();

            int command = scanner.nextInt();
            scanner.nextLine();


            switch (command) {
                case 0:
                    userManager.saveUsers();
                    System.exit(0);
                case 1:
                    userManager.signIn();
                    break;
                case 2:
                    userManager.signUp();
                    break;
                case 3:
                    userManager.printUsers();
                    break;
                default:
                    System.out.println("Unknown command... Try again!");
            }
        }
    }
}
