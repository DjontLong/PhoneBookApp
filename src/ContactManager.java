import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

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
                    editContactMenu(user);
                   break;
                case 2:
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

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(contactsFilePath), StandardOpenOption.APPEND)) {
            for (Contact contact : user.getContacts()) {
                writer.write(user.getName() + "," + contact.getName() + "," + contact.getSurname() + "," + contact.getPhoneNumber());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void prinContacts(User user) {
        System.out.println("Contact list for " + user.getName() + ": ");
        int indexForContact = -1;
        for (Contact contact : user.getContacts()) {
            indexForContact++;
            System.out.println(indexForContact + ">>" + "\n" + "Name: " + contact.getName() + "\n"
                    + "Surname: " + contact.getSurname() + "\n"
                    + "Phone number: " + contact.getPhoneNumber() +
                    "\n");
        }
    }

    public static void editContactMenu(User user) {
        while (true) {
            Menu.showEditContactMenu();
            int command = scanner.nextInt();
            scanner.nextLine();

            switch (command) {
                case -1:
                    return;
                case 0:
                    // Name
                case 1:
                    // Surname
                case 2:
                    // Number
                case 3:
                    // All
                default:
                    System.out.println();
            }
        }
    }

    private static void editContact(User user) {
        prinContacts(user);
        System.out.print("Enter the number of the contact to edit: ");
        int index = scanner.nextInt();


    }
}
