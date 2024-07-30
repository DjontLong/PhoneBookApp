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
import java.util.stream.Collectors;

public class ContactManager {
    private static Scanner scanner = new Scanner(System.in);
    private static final Path CONTACTS_FILE_PATH = Paths.get("PhoneBookApp/src/resources/contacts.txt");

    public static void contactMenu(User user) {
        while (true) {
            Menu.showContactMenu();
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
        // Сохранение контактов в файл
        try (BufferedWriter writer = Files.newBufferedWriter(CONTACTS_FILE_PATH, StandardOpenOption.TRUNCATE_EXISTING)) {
            for (Contact contact : user.getContacts()) {
                writer.write(user.getName() + "," + contact.getName() + "," + contact.getSurname() + "," + contact.getPhoneNumber());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void printContacts(User user) {
        Menu.showPrintMenu();
        while (true) {
            int command = scanner.nextInt();
            scanner.nextLine();
            switch (command) {
                case -1: return;
                case 0: printContactsAll(user); break;
                case 1: printContactsSpecific(user); break;
                default: System.out.println("Invalid command... Try again!");
            }
        }
    }

    public static void printContactsAll(User user) {
        System.out.println("Contact list for " + user.getName() + ": ");
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
        // Поиск контактов по определённому шаблону
        System.out.println("Введите шаблон для вывода определённых контактов >>> ");
        System.out.println("\"*\"" + " - " + "любой символ, любое количество раз\"");
        System.out.println("\"-\"" + " - " + "любой один символ\"");
        System.out.println();
        System.out.println("Пример: " + " +7_21* Ro_");
        System.out.println();

        // Считываем шаблон поиска, введённый пользователем
        String pattern = scanner.nextLine();

        // Экранируем все специальные символы, кроме '*' и '_'
        // Специальные символы в регулярных выражениях включают \, ., ^, $, |, ?, +, (, ), {, }, [, ]
        // Экранирование необходимо, чтобы эти символы воспринимались как обычные символы
        String escapedPattern = pattern.replaceAll("([\\\\.^$|?+(){}\\[\\]])", "\\\\$1");

        // Заменяем '*' на '.*', чтобы он соответствовал любому количеству любых символов
        // Заменяем '_' на '.', чтобы он соответствовал любому одному символу
        String escapedPatternResult = escapedPattern.replace("*", ".*").replace("_", ".");

        // Компилируем итоговое регулярное выражение
        Pattern compilePattern = Pattern.compile(escapedPatternResult);

        // Флаг для отслеживания, найдены ли совпадения
        boolean matchFound = false;

        System.out.println("Результат поиска: ");
        System.out.println("___________________________________________________");
        // Проходим по каждому контакту в списке контактов пользователя
        for (Contact contact : user.getContacts()) {
            // Преобразуем объект Contact в строку
            String contactString = contact.toString();

            // Создаём Matcher для сопоставления строки контакта с регулярным выражением
            Matcher matcher = compilePattern.matcher(contactString);
            // Если найдены совпадения, выводим контакт и устанавливаем флаг matchFound в true
            if (matcher.find()) {
                System.out.println(contact.getName() + " " + contact.getSurname() + " " + contact.getPhoneNumber());
                matchFound = true;
            }
        }
        System.out.println("___________________________________________________");

        // Если ни один контакт не соответствует шаблону, выводим соответствующее сообщение
        if (!matchFound) {
            System.out.println("No contacts match the given pattern.");
        }

        Menu.showPrintMenu();
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
            case -1: return;
            case 0:
                System.out.print("Enter a new contact name: ");
                String newContactName = scanner.nextLine();
                contact.setName(newContactName);
                System.out.println("Contact name changed successfully!");
                break;
            case 1:
                System.out.print("Enter a new contact surname: ");
                String newContactSurname = scanner.nextLine();
                contact.setSurname(newContactSurname);
                System.out.println("Contact surname changed successfully!");
                break;
            case 2:
                System.out.print("Enter a new contact phone number: ");
                String phoneNumber = scanner.nextLine();
                contact.setPhoneNumber(phoneNumber);
                System.out.println("Contact phone number changed successfully!");
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

                System.out.println("Contact changed successfully!");
        }
    }

    public static void deleteContact(User user) {
        printContacts(user);
        System.out.print("Enter contact number to delete: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index >= 0 && index < user.getContacts().size()) {
            user.removeContacts(user.getContacts().get(index));
            System.out.println("Contact successfully deleted!");
        }
    }

    public static void sortingContactsMenu(User user) throws InterruptedException {
        while (true) {
            Menu.showSortingMenu();
            int command = scanner.nextInt();
            scanner.nextLine();
            switch (command) {
                case -1: return;
                case 0: sortContactsByField(user, Comparator.comparing(Contact::getName), "Name"); break;
                case 1:  break;
                case 2:  break;
                default: System.out.println("Invalid command... Try again!");
            }
        }
    }

    // Реализация сортировки контактов по полю
    private static void sortContactsByField(User user, Comparator<Contact> comparator, String fieldName) throws InterruptedException {
        Menu.showSortMenuByField(fieldName);
        while (true) {
            int command = scanner.nextInt();
            scanner.nextLine();
            switch (command) {
                case -1: return;
                case 0: user.getContacts().sort(comparator); break;
                case 1:
                default: System.out.println("Unknown command... Try again!");
            }
            Menu.showSortNameAZ();
            printSortedContacts(user, fieldName);
            System.out.println();
            Thread.sleep(3_000);
            System.out.print("To return to the previous menu, enter -1: ");
        }
    }

    private static void printSortedContacts(User user, String fieldName) {
        for (Contact contact : user.getContacts()) {
            System.out.println("  " + contact.getName() + " " + contact.getSurname() + " " + contact.getPhoneNumber());
        }
    }





//    public static void sortContactsByNameMenu(User user) {
//        while (true) {
//            Menu.showSortingMenuByName();
//            int command = scanner.nextInt();
//            scanner.nextLine();
//
//            switch (command) {
//                case -1:
//                    return;
//                case 0:
//                    sortContactByNameAscending(user);
//                    break;
//                case 1:
//                    sortContactByNameDescending(user);
//                    break;
//                default:
//                    System.out.println("Unknown command... Try again!");
//            }
//        }
//    }
//
//    public static void sortContactByNameAscending(User user) {
//        // Получаем список контактов и сохраняем в contacts
//        List<Contact> contacts = user.getContacts();
//
//        // Вызываем метод sort
//        // Создаём аноанимный класс, который реализует интерфейс "Comparator"
//        contacts.sort(new Comparator<Contact>() {
//            // Реализуем метод "compare"
//            @Override
//            public int compare(Contact c1, Contact c2) {
//                return c1.getName().compareToIgnoreCase(c2.getName());
//            }
//        });
//
//        Menu.showSortNameAZ();
//
//        // Выводим отсортированный список контактов
//        for (Contact contact : contacts) {
//            System.out.println("  " + contact.getName() + " " + contact.getSurname() + " " + contact.getPhoneNumber());
//        }
//    }
//
//    public static void sortContactByNameDescending(User user) {
//        // Получаем список контактов и сохраняем в contacts
//        List<Contact> contacts = user.getContacts();
//
//        // Вызываем метод sort
//        // Создаём аноанимный класс, который реализует интерфейс "Comparator"
//        contacts.sort(new Comparator<Contact>() {
//            @Override
//            public int compare(Contact c1, Contact c2) {
//                return c2.getName().compareToIgnoreCase(c1.getName());
//            }
//        });
//
//        Menu.showSortNameZA();
//
//        // Выводим отсортированный список контактов
//        for (Contact contact : contacts) {
//            System.out.println("  " + contact.getName() + " " + contact.getSurname() + " " + contact.getPhoneNumber());
//        }
//    }
//
//    public static void sortContactsBySurnameMenu(User user) {
//        while (true) {
//            Menu.showSortingMenuBySurname();
//
//            int command = scanner.nextInt();
//            scanner.nextLine();
//
//            switch (command) {
//                case -1:
//                    return;
//                case 0:
//                    sortContactBySurnameAscending(user);
//                    break;
//                case 1:
//                    sortContactBySurnameDescending(user);
//                    break;
//                default:
//                    System.out.println("Unknown command... Try again!");
//            }
//        }
//    }
//
//    public static void sortContactBySurnameAscending(User user) {
//        List<Contact> contacts = user.getContacts();
//
//        contacts.sort(new Comparator<Contact>() {
//            // Реализуем метод "compare"
//            @Override
//            public int compare(Contact c1, Contact c2) {
//                return c1.getSurname().compareToIgnoreCase(c2.getSurname());
//            }
//        });
//
//        Menu.showSortSurnameAZ();
//
//        // Выводим отсортированный список контактов
//        for (Contact contact : contacts) {
//            System.out.println("  " + contact.getName() + " " + contact.getSurname() + " " + contact.getPhoneNumber());
//        }
//    }
//
//    public static void sortContactBySurnameDescending(User user) {
//        List<Contact> contacts = user.getContacts();
//
//        contacts.sort(new Comparator<Contact>() {
//            // Реализуем метод "compare"
//            @Override
//            public int compare(Contact c1, Contact c2) {
//                return c2.getSurname().compareToIgnoreCase(c1.getSurname());
//            }
//        });
//
//        Menu.showSortSurnameZA();
//
//        // Выводим отсортированный список контактов
//        for (Contact contact : contacts) {
//            System.out.println("  " + contact.getName() + " " + contact.getSurname() + " " + contact.getPhoneNumber());
//        }
//    }
//
//    public static void sortContactByNumberMenu(User user) {
//        while (true) {
//            Menu.showSortingMenuByNumber();
//
//            int command = scanner.nextInt();
//            scanner.nextLine();
//
//            switch (command) {
//                case -1:
//                    return;
//                case 0:
//                    sortContactByNumberAscending(user);
//                    break;
//                case 1:
//                    sortContactByNumberDescending(user);
//                    break;
//                default:
//                    System.out.println("Unknown command... Try again!");
//            }
//        }
//    }
//
//    public static void sortContactByNumberAscending(User user) {
//        List<Contact> contacts = user.getContacts();
//
//        contacts.sort(new Comparator<Contact>() {
//            // Реализуем метод "compare"
//            @Override
//            public int compare(Contact c1, Contact c2) {
//                return c1.getPhoneNumber().compareToIgnoreCase(c2.getPhoneNumber());
//            }
//        });
//
//        Menu.showSortNumberAsc();
//
//        // Выводим отсортированный список контактов
//        for (Contact contact : contacts) {
//            System.out.println("  " + contact.getName() + " " + contact.getSurname() + " " + contact.getPhoneNumber());
//        }
//    }
//
//    public static void sortContactByNumberDescending(User user) {
//        List<Contact> contacts = user.getContacts();
//
//        contacts.sort(new Comparator<Contact>() {
//            // Реализуем метод "compare"
//            @Override
//            public int compare(Contact c1, Contact c2) {
//                return c2.getPhoneNumber().compareToIgnoreCase(c1.getPhoneNumber());
//            }
//        });
//
//        Menu.showSortNumberAsc();
//
//        // Выводим отсортированный список контактов
//        for (Contact contact : contacts) {
//            System.out.println("  " + contact.getName() + " " + contact.getSurname() + " " + contact.getPhoneNumber());
//        }
//    }
}
