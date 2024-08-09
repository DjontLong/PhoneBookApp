package phonebook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactManager {
    private static Scanner scanner = new Scanner(System.in);
    private static final Path CONTACTS_FILE_PATH = Paths.get("PhoneBookApp/src/resources/contacts.txt");

    public static void contactMenu(User user) {
        while (true) {
            Menu.showContactMenu();

            try {
                int command = scanner.nextInt();
                scanner.nextLine();
                switch (command) {
                    case -1:
                        return;
                    case 0:
                        addContact(user);
                        break;
                    case 1:
                        editContact(user);
                        break;
                    case 2:
                        deleteContact(user);
                        break;
                    default:
                        System.out.println("Invalid command... Try again!");
                }
            } catch (Exception e) {
                System.out.println("Incorrect input! Try again!");
                scanner.nextLine();
            }
        }

    }

    private static void addContact(User user) {
        System.out.print("Enter the name of the new contact: ");
        String name = scanner.nextLine();

        System.out.print("Enter the surname of the new contact: ");
        String surName = scanner.nextLine();

        System.out.print("Enter the phone number of the new contact: ");
        String phoneNumber = scanner.nextLine();

        user.addContacts(new Contact(name, surName, phoneNumber));
    }

    public static void loadContacts(User user) {
        user.getContacts().clear();

        try (BufferedReader reader = Files.newBufferedReader(CONTACTS_FILE_PATH)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    String userName = parts[0].trim();
                    if (user.getName().equals(userName)) {
                        String contactName = parts[1].trim();
                        String contactSurname = parts[2].trim();
                        String contactPhone = parts[3].trim();

                        user.addContacts(new Contact(contactName, contactSurname, contactPhone));
                    }
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void saveContacts(User user) {
        List<String> allLines = new ArrayList<>();

        // Чтение всех существующих контактов из файла
        try (BufferedReader reader = Files.newBufferedReader(CONTACTS_FILE_PATH)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    String userName = parts[0].trim();
                    // Добавляем в allLines только те строки, которые не относятся к текущему пользователю
                    if (!userName.equals(user.getName())) {
                        allLines.add(line);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading contacts: " + e.getMessage());
        }

        // Добавление контактов текущего пользователя
        for (Contact contact : user.getContacts()) {
            String contactLine = user.getName() + "," + contact.getName() + "," + contact.getSurname() + "," + contact.getPhoneNumber();
            allLines.add(contactLine);
        }

        // Перезапись файла с обновленными данными
        try (BufferedWriter writer = Files.newBufferedWriter(CONTACTS_FILE_PATH, StandardOpenOption.TRUNCATE_EXISTING)) {
            for (String line : allLines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving contacts: " + e.getMessage());
        }
    }

    public static void printContacts(User user) {
        while (true) {
            Menu.showPrintMenu();
            try {
                int command = scanner.nextInt();
                scanner.nextLine(); // Чистим буфер после nextInt()
                switch (command) {
                    case -1:
                        return;
                    case 0:
                        printContactsAll(user);
                        break;
                    case 1:
                        printContactsSpecific(user);
                        break;
                    default:
                        System.out.println("Invalid command... Try again!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Incorrect input! Please enter a number.");
                scanner.nextLine(); // Чистим буфер, чтобы избежать бесконечного цикла ошибки
            }
        }
    }

    public static List<Contact> searchContactsByPattern(List<Contact> contacts, String pattern) {
        // Экранируем все специальные символы, кроме '*' и '_'
        String escapedPattern = pattern.replaceAll("([\\\\.^$|?+(){}\\[\\]])", "\\\\$1");

        // Заменяем '*' на '.*', чтобы он соответствовал любому количеству любых символов
        // Заменяем '_' на '.', чтобы он соответствовал любому одному символу
        String regex = escapedPattern.replace("*", ".*").replace("_", ".");

        // Компилируем итоговое регулярное выражение
        Pattern compilePattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        List<Contact> matchingContacts = new ArrayList<>();

        for (Contact contact : contacts) {
            String contactString = contact.toString(); // Это должно включать номер телефона
            Matcher matcher = compilePattern.matcher(contactString);
            if (matcher.find()) {
                matchingContacts.add(contact);
            }
        }

        return matchingContacts;
    }

    public static void printContactsAll(User user) {
        System.out.println("phonebook.Contact list for " + user.getName() + ": ");
        for (int i = 0; i < user.getContacts().size(); i++) {
            Contact contact = user.getContacts().get(i);
            System.out.println(i + ">>" + "\n" + "Name: " + contact.getName() + "\n"
                    + "Surname: " + contact.getSurname() + "\n"
                    + "Phone number: " + contact.getPhoneNumber() +
                    "\n");
        }
        System.out.println("To return to the previous menu, enter -1 >>> ");
    }

    public static void printContactsSpecific(User user) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите шаблон для вывода определённых контактов >>> ");
        System.out.println("\"*\"" + " - " + "любой символ, любое количество раз");
        System.out.println("\"-\"" + " - " + "любой один символ");
        System.out.println();
        System.out.println("Пример: " + " +7_21* Ro_");
        System.out.println();

        String pattern = scanner.nextLine();

        List<Contact> matchingContacts = searchContactsByPattern(user.getContacts(), pattern);

        boolean matchFound = !matchingContacts.isEmpty();

        System.out.println("Результат поиска: ");
        System.out.println("___________________________________________________");

        for (Contact contact : matchingContacts) {
            System.out.println(contact.getName() + " " + contact.getSurname() + " " + contact.getPhoneNumber());
        }

        System.out.println("___________________________________________________");

        if (!matchFound) {
            System.out.println("No contacts match the given pattern.");
        }

        System.out.println("Press Enter to return to the Print Menu...");
        scanner.nextLine();  // Ждем ввода пользователя перед возвратом в меню
    }

    public static void editContact(User user) {
        printContactsAll(user);
        System.out.print("Enter the number of the contact to edit: ");
        System.out.println();
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index == -1 || index >= user.getContacts().size()) {
            System.out.println("Invalid data... Try again!");
            return;
        }

        Contact contact = user.getContacts().get(index);
        Menu.showEditContactMenu();
        int command = scanner.nextInt();
        scanner.nextLine();
        switch (command) {
            case -1:
                return;
            case 0:
                System.out.print("Enter a new contact name: ");
                String newContactName = scanner.nextLine();
                contact.setName(newContactName);
                System.out.println("phonebook.Contact name changed successfully!");
                break;
            case 1:
                System.out.print("Enter a new contact surname: ");
                String newContactSurname = scanner.nextLine();
                contact.setSurname(newContactSurname);
                System.out.println("phonebook.Contact surname changed successfully!");
                break;
            case 2:
                System.out.print("Enter a new contact phone number: ");
                String phoneNumber = scanner.nextLine();
                contact.setPhoneNumber(phoneNumber);
                System.out.println("phonebook.Contact phone number changed successfully!");
                break;
            case 3:
                System.out.print("Enter a new contact name: ");
                String editContactName = scanner.nextLine();
                System.out.print("Enter a new contact surname: ");
                String editContactSurname = scanner.nextLine();
                System.out.print("Enter a new contact phone number: ");
                String editPhoneNumber = scanner.nextLine();

                contact.setName(editContactName);
                contact.setSurname(editContactSurname);
                contact.setPhoneNumber(editPhoneNumber);

                System.out.println("phonebook.Contact changed successfully!");
        }
    }

    public static void deleteContact(User user) {
        printContacts(user);
        System.out.print("Enter contact number to delete: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index >= 0 && index < user.getContacts().size()) {
            user.removeContacts(user.getContacts().get(index));
            System.out.println("phonebook.Contact successfully deleted!");
        }
    }

    public static void sortingContactsMenu(User user) throws InterruptedException {
        while (true) {
            Menu.showSortingMenu();

            try {
                int command = scanner.nextInt();
                scanner.nextLine();
                switch (command) {
                    case -1:
                        return;
                    case 0:
                        sortContactsByField(user, Comparator.comparing(Contact::getName), "Name");
                        break;
                    case 1:
                        sortContactsByField(user, Comparator.comparing(Contact::getSurname), "Surname");
                        break;
                    case 2:
                        sortContactsByField(user, Comparator.comparing(Contact::getPhoneNumber), "Number");
                        break;
                    default:
                        System.out.println("Invalid command... Try again!");
                }
            } catch (Exception e) {
                System.out.println();
                scanner.nextLine();
            }
        }
    }


    // Реализация сортировки контактов по полю
    private static void sortContactsByField(User user, Comparator<Contact> comparator, String fieldName) throws InterruptedException {
        while (true) {
            Menu.showSortMenuByField(fieldName);
            try {
                int command = scanner.nextInt();
                scanner.nextLine();

                switch (command) {
                    case -1:
                        return;
                    case 0:
                        user.getContacts().sort(comparator);
                        Menu.showSortName(fieldName, true);
                        printSortedContacts(user, fieldName);
                        break;
                    case 1:
                        user.getContacts().sort(comparator.reversed());
                        Menu.showSortName(fieldName, false);
                        printSortedContacts(user, fieldName);
                        break;
                    default:
                        System.out.println("Unknown command... Try again!");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Unknown command... Try again!");
                scanner.nextLine();
            }
        }
    }

    private static void printSortedContacts(User user, String fieldName) {
        for (Contact contact : user.getContacts()) {
            System.out.println("  " + contact.getName() + " " + contact.getSurname() + " " + contact.getPhoneNumber());
        }
    }

    public static void searchMenu(User user) throws InterruptedException {
        while (true) {
            Menu.showSearchMenu();
            try {
                int command = scanner.nextInt();
                scanner.nextLine();

                switch (command) {
                    case -1:
                        return;
                    case 0:
                        searchContactsByName(user);
                        break;
                    case 1:
                        searchContactsBySurname(user);
                        break;
                    case 2:
                        searchContactsByNumber(user);
                        break;
                    default:
                        System.out.print("Unknown command! Try again!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Unknown command... Try again!");
                scanner.nextLine();
            }
        }
    }

    public static List<Contact> searchContactsByField(List<Contact> contacts, String field, String value) {
        List<Contact> matchingContacts = new ArrayList<>();

        for (Contact contact : contacts) {
            switch (field.toLowerCase()) {
                case "name":
                    if (contact.getName().equalsIgnoreCase(value)) {
                        matchingContacts.add(contact);
                    }
                    break;
                case "surname":
                    if (contact.getSurname().equalsIgnoreCase(value)) {
                        matchingContacts.add(contact);
                    }
                    break;
                case "number":
                    if (contact.getPhoneNumber().equalsIgnoreCase(value)) {
                        matchingContacts.add(contact);
                    }
                    break;
            }
        }

        return matchingContacts;
    }

    public static void searchContactsByName(User user) {
        System.out.print("Enter the name to search for: ");
        String name = new Scanner(System.in).nextLine();

        List<Contact> matchingContacts = searchContactsByField(user.getContacts(), "name", name);

        if (matchingContacts.isEmpty()) {
            System.out.println("No contacts found with the name: " + name);
        } else {
            for (Contact contact : matchingContacts) {
                System.out.println(contact.getName() + " " + contact.getSurname() + " " + contact.getPhoneNumber());
            }
        }
    }

    public static void searchContactsBySurname(User user) {
        System.out.print("Enter the surname to search for: ");
        String surname = new Scanner(System.in).nextLine();

        List<Contact> matchingContacts = searchContactsByField(user.getContacts(), "surname", surname);

        if (matchingContacts.isEmpty()) {
            System.out.println("No contacts found with the surname: " + surname);
        } else {
            for (Contact contact : matchingContacts) {
                System.out.println(contact.getName() + " " + contact.getSurname() + " " + contact.getPhoneNumber());
            }
        }
    }

    public static void searchContactsByNumber(User user) {
        System.out.print("Enter the phone number to search for: ");
        String number = new Scanner(System.in).nextLine();

        List<Contact> matchingContacts = searchContactsByField(user.getContacts(), "number", number);

        if (matchingContacts.isEmpty()) {
            System.out.println("No contacts found with the phone number: " + number);
        } else {
            for (Contact contact : matchingContacts) {
                System.out.println(contact.getName() + " " + contact.getSurname() + " " + contact.getPhoneNumber());
            }
        }
    }
}