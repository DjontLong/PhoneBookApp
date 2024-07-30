//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardOpenOption;
//import java.util.*;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//import java.util.stream.Collectors;
//
//public class ContactManager {
//    private static final Scanner scanner = new Scanner(System.in);
//    private static final Path CONTACTS_FILE_PATH = Paths.get("PhoneBookApp/src/resources/contacts.txt");
//
//    public static void contactMenu(User user) {
//        while (true) {
//            Menu.showContactMenu();
//            int command = scanner.nextInt();
//            scanner.nextLine();
//            switch (command) {
//                case -1: return;
//                case 0: addContact(user); break;
//                case 1: editContact(user); break;
//                case 2: deleteContact(user); break;
//                default: System.out.println("Invalid command... Try again!");
//            }
//        }
//    }
//
//    private static void addContact(User user) {
//        System.out.print("Enter the name of the new contact: ");
//        String name = scanner.nextLine();
//        System.out.print("Enter the surname of the new contact: ");
//        String surName = scanner.nextLine();
//        System.out.print("Enter the phone number of the new contact: ");
//        String phoneNumber = scanner.nextLine();
//        user.addContacts(new Contact(name, surName, phoneNumber));
//    }
//
//    public static void loadContacts(User user) {
//        user.getContacts().clear();
//        try (BufferedReader reader = Files.newBufferedReader(CONTACTS_FILE_PATH)) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] parts = line.split(",");
//                if (parts.length >= 4 && user.getName().equals(parts[0].trim())) {
//                    user.addContacts(new Contact(parts[1].trim(), parts[2].trim(), parts[3].trim()));
//                }
//            }
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    public static void saveContacts(User user) {
//        try (BufferedWriter writer = Files.newBufferedWriter(CONTACTS_FILE_PATH, StandardOpenOption.TRUNCATE_EXISTING)) {
//            for (Contact contact : user.getContacts()) {
//                writer.write(user.getName() + "," + contact.getName() + "," + contact.getSurname() + "," + contact.getPhoneNumber());
//                writer.newLine();
//            }
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    public static void printContacts(User user) {
//        Menu.showPrintMenu();
//        while (true) {
//            int command = scanner.nextInt();
//            scanner.nextLine();
//            switch (command) {
//                case -1: return;
//                case 0: printContactsAll(user); break;
//                case 1: printContactsSpecific(user); break;
//                default: System.out.println("Invalid command... Try again!");
//            }
//        }
//    }
//
//    private static void printContactsAll(User user) {
//        System.out.println("Contact list for " + user.getName() + ": ");
//        for (int i = 0; i < user.getContacts().size(); i++) {
//            Contact contact = user.getContacts().get(i);
//            System.out.printf("%d >>\nName: %s\nSurname: %s\nPhone number: %s\n\n", i, contact.getName(), contact.getSurname(), contact.getPhoneNumber());
//        }
//        System.out.println("To return to the previous menu, enter -1 >>> ");
//    }
//
//    private static void printContactsSpecific(User user) {
//        System.out.println("Введите шаблон для вывода определённых контактов >>> ");
//        System.out.println("\"*\"" + " - " + "любой символ, любое количество раз\"");
//        System.out.println("\"-\"" + " - " + "любой один символ\"");
//        System.out.println("Пример: +7_21* Ro_");
//
//        String pattern = scanner.nextLine();
//        String escapedPattern = pattern.replaceAll("([\\\\.^$|?+(){}\\[\\]])", "\\\\$1").replace("*", ".*").replace("_", ".");
//        Pattern compilePattern = Pattern.compile(escapedPattern);
//
//        System.out.println("Результат поиска: ");
//        System.out.println("___________________________________________________");
//        boolean matchFound = false;
//        for (Contact contact : user.getContacts()) {
//            Matcher matcher = compilePattern.matcher(contact.toString());
//            if (matcher.find()) {
//                System.out.println(contact.getName() + " " + contact.getSurname() + " " + contact.getPhoneNumber());
//                matchFound = true;
//            }
//        }
//        System.out.println("___________________________________________________");
//        if (!matchFound) {
//            System.out.println("No contacts match the given pattern.");
//        }
//        Menu.showPrintMenu();
//    }
//
//    private static void editContact(User user) {
//        printContactsAll(user);
//        System.out.print("Enter the number of the contact to edit: ");
//        int index = scanner.nextInt();
//        scanner.nextLine();
//        if (index == -1 || index >= user.getContacts().size()) {
//            System.out.println("Invalid data... Try again!");
//            return;
//        }
//        Contact contact = user.getContacts().get(index);
//        Menu.showEditContactMenu();
//        int command = scanner.nextInt();
//        scanner.nextLine();
//        switch (command) {
//            case -1: return;
//            case 0: updateContactField(contact::setName, "name"); break;
//            case 1: updateContactField(contact::setSurname, "surname"); break;
//            case 2: updateContactField(contact::setPhoneNumber, "phone number"); break;
//            case 3: editFullContact(contact); break;
//            default: System.out.println("Unknown command... Try again!");
//        }
//    }
//
//    private static void updateContactField(Consumer<String> setter, String fieldName) {
//        System.out.printf("Enter a new contact %s: ", fieldName);
//        setter.accept(scanner.nextLine());
//        System.out.printf("Contact %s changed successfully!\n", fieldName);
//    }
//
//    private static void editFullContact(Contact contact) {
//        System.out.print("Enter a new contact name: ");
//        contact.setName(scanner.nextLine());
//        System.out.print("Enter a new contact surname: ");
//        contact.setSurname(scanner.nextLine());
//        System.out.print("Enter a new contact phone number: ");
//        contact.setPhoneNumber(scanner.nextLine());
//        System.out.println("Contact changed successfully!");
//    }
//
//    private static void deleteContact(User user) {
//        printContactsAll(user);
//        System.out.print("Enter contact number to delete: ");
//        int index = scanner.nextInt();
//        scanner.nextLine();
//        if (index >= 0 && index < user.getContacts().size()) {
//            user.removeContacts(user.getContacts().get(index));
//            System.out.println("Contact successfully deleted!");
//        } else {
//            System.out.println("Invalid contact number... Try again!");
//        }
//    }
//
//    public static void sortingContactsMenu(User user) {
//        while (true) {
//            Menu.showSortingMenu();
//            int command = scanner.nextInt();
//            scanner.nextLine();
//            switch (command) {
//                case -1: return;
//                case 0: sortContactsByField(user, Comparator.comparing(Contact::getName), "Name"); break;
//                case 1: sortContactsByField(user, Comparator.comparing(Contact::getSurname), "Surname"); break;
//                case 2: sortContactsByField(user, Comparator.comparing(Contact::getPhoneNumber), "Number"); break;
//                default: System.out.println("Invalid command... Try again!");
//            }
//        }
//    }
//
//    private static void sortContactsByField(User user, Comparator<Contact> comparator, String fieldName) {
//        Menu.showSortingMenuByField(fieldName);
//        while (true) {
//            int command = scanner.nextInt();
//            scanner.nextLine();
//            switch (command) {
//                case -1: return;
//                case 0: user.getContacts().sort(comparator); break;
//                case 1: user.getContacts().sort(comparator.reversed()); break;
//                default: System.out.println("Unknown command... Try again!");
//            }
//            printSortedContacts(user, fieldName);
//        }
//    }
//
//    private static void printSortedContacts(User user, String fieldName) {
//        System.out.printf("Sorted contacts by %s:\n", fieldName);
//        for (Contact contact : user.getContacts()) {
//            System.out.println("  " + contact.getName() + " " + contact.getSurname() + " " + contact.getPhoneNumber());
//        }
//    }
//}
