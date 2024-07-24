import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int command = -1;
            do {
                PhoneBookApp.showMainMenu();
                scanner.nextLine();
            } while (true);
        }
    }
}