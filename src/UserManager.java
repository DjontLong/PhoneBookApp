import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManager {
    private static List<User> users = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);

    private void userMenu(User user) throws InterruptedException {
        while (true) {
            Menu.showUserMenu();

            int command = scanner.nextInt();
            scanner.nextLine();

            switch (command) {
                case 0:
                    saveAndExit();
                    break;
                case 1:
                    ContactManager.contactMenu(user);
                    break;
                case 2:
                    ContactManager.printContacts(user);
                    break;
                case 3:
                    // Sorting
                    ContactManager.sortingContactsMenu(user);
                    break;
                case 4:
                    // Search
                    break;
                case 5:
                    saveUsers();
                    return;
                default:
                    System.out.print("Unknown command! Try again!");
            }
        }
    }

    public void signIn() throws InterruptedException {
        System.out.print("Enter login: ");
        String login = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if (login.equals(user.getLogin()) && password.equals(user.getPassword())) {
                userMenu(user);
                return;
            }
        }
        System.out.println("Invalid login or password!");
    }


    public void signUp() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter login: ");
        String login = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Repeat password: ");
        String repeatPassword = scanner.nextLine();

        if (!password.equals(repeatPassword)) {
            System.out.println("Password mismatch... Try again!");
            return;
        }

        for (User user : users) {
            if (login.equals(user.getLogin())) {
                System.out.println("Login: **" + login + " ** is already taken! Come up with another one and try again!");
                return;
            }
        }
        User newUser = new User(name, login, password);
        users.add(newUser);
        System.out.println("User registered successfully!");
        saveUsers();
    }

    public void printUsers() {
        System.out.println("Список зарегистрированных пользователей: ");
        for (User user : users) {
            System.out.println(user.getLogin());
        }
    }

    public void loadUsers() {
        // Загрузка пользователей из файла
        String filePathUsers = "PhoneBookApp/src/resources/users.txt";
        users.clear();

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePathUsers))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    String name = parts[0].trim();
                    String login = parts[1].trim();
                    String password = parts[2].trim();

                    User user = new User(name, login, password);
                    users.add(user);
                    ContactManager.loadContacts(user);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveUsers() {
        // Сохранение пользователей в файл
        String filepathUsers = "PhoneBookApp/src/resources/users.txt";

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filepathUsers))) {
            for (User user : users) {
                writer.write(user.getName() + ", " + user.getLogin() + ", " + user.getPassword());
                writer.newLine();
                ContactManager.saveContacts(user);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveAndExit() {
        saveUsers();
        System.exit(0);
    }
}