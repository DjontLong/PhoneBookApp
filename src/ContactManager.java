import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactManager {
    private static Scanner scanner = new Scanner(System.in);

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

        Contact contact = new Contact(name, surName, phoneNumber);
        user.addContacts(contact);
    }

    public static void loadContacts(User user) {
        String filePathContacts = "PhoneBookApp/src/resources/contacts.txt";
        user.getContacts().clear();

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePathContacts))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    String userName = parts[0].trim();
                    if (user.getName().equals(userName)) {
                        String contactName = parts[1].trim();
                        String contactSurname = parts[2].trim();
                        String contactPhone = parts[3].trim();

                        Contact contact = new Contact(contactName, contactSurname, contactPhone);
                        user.addContacts(contact);
                    }
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void saveContacts(User user) {
        // Сохранение контактов в файл
        String contactsFilePath = "PhoneBookApp/src/resources/contacts.txt";

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(contactsFilePath), StandardOpenOption.TRUNCATE_EXISTING)) {
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
                case -1:
                    return;
                case 0:
                    printContactsAll(user);
                    break;
                case 1:
                    // Print Specific
                    printContactsSpecific(user);
                    break;
            }
        }
    }

    public static void printContactsAll(User user) {
        System.out.println("Contact list for " + user.getName() + ": ");
        int indexForContact = -1;
        for (Contact contact : user.getContacts()) {
            indexForContact++;
            System.out.println(indexForContact + ">>" + "\n" + "Name: " + contact.getName() + "\n"
                    + "Surname: " + contact.getSurname() + "\n"
                    + "Phone number: " + contact.getPhoneNumber() +
                    "\n");
        }
        System.out.print("To return to the previous menu, enter -1 >>> ");
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
        printContacts(user);
        System.out.print("Enter the number of the contact to edit: ");
        int index = scanner.nextInt();
        scanner.nextLine();

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

        Contact contact = user.getContacts().get(index);
        user.removeContacts(contact);
        System.out.println("Contact successfully deleted!");
    }
}
