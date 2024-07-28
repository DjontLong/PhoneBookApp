import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String login;
    private String password;
    private List<Contact> contacts;

    public User(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.contacts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void addContacts(Contact contact) {
        contacts.add(contact);
    }

    public void removeContacts(Contact contact) {
        contacts.remove(contact);
    }

    public void editContacts(Contact oldContact, Contact newContact) {
        int index = contacts.indexOf(oldContact);
        if (index != -1) {
            contacts.set(index, newContact);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", contacts=" + contacts +
                '}';
    }
}