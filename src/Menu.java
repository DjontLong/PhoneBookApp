public class Menu {
    public static void showStartMenu() {
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
        System.out.print("Enter the command: ");
    }
    public static void showUserMenu() {
        System.out.println(" _________________________________________________ ");
        System.out.println("|                                                 |");
        System.out.println("|               << Phone book  >>                 |");
        System.out.println("|                  Main  menu                     |");
        System.out.println("|_________________________________________________|");
        System.out.println("|                                                 |");
        System.out.println("| 0 - Save and Exit ( Save and Exit the program)  |");
        System.out.println("|-------------------------------------------------|");
        System.out.println("| 1 - Contacts      ( Add / Edit / Delete)        |");
        System.out.println("|-------------------------------------------------|");
        System.out.println("| 2 - Print         ( All / Specific)             |");
        System.out.println("|-------------------------------------------------|");
        System.out.println("| 3 - Sorting       ( Name / Surname / Number )   |");
        System.out.println("|-------------------------------------------------|");
        System.out.println("| 4 - Search        ( by Name / Surname / Number )|");
        System.out.println("|-------------------------------------------------|");
        System.out.println("| 5 - Come Back     ( Save and Exit phonebook )   |");
        System.out.println("|_________________________________________________|");
        System.out.print("Enter the command: ");
    }
    public static void showContactMenu() {
        System.out.println(" _________________________________________________ ");
        System.out.println("|                                                 |");
        System.out.println("|               << Phone book  >>                 |");
        System.out.println("|           Main  menu -> Contact menu            |");
        System.out.println("|                                                 |");
        System.out.println("|_________________________________________________|");
        System.out.println("|                                                 |");
        System.out.println("| -1 - Come back    ( Return to the main menu)    |");
        System.out.println("|-------------------------------------------------|");
        System.out.println("|  0 - Add          ( Add new contact )           |");
        System.out.println("|-------------------------------------------------|");
        System.out.println("|  1 - Edit         ( Edit contact )              |");
        System.out.println("|-------------------------------------------------|");
        System.out.println("|  2 - Delete       ( Delete contact )            |");
        System.out.println("|_________________________________________________|");
        System.out.print("Enter the command: ");
    }

    public static void showEditContactMenu() {
        System.out.println(" _________________________________________________ ");
        System.out.println("|                                                 |");
        System.out.println("|               << Phone book  >>                 |");
        System.out.println("|      Main  menu -> Contact menu -> Edit         |");
        System.out.println("|_________________________________________________|");
        System.out.println("| -1 - Come back    ( Return to the Contact menu) |");
        System.out.println("|-------------------------------------------------|");
        System.out.println("|  0 - Name         ( Edit contact name )         |");
        System.out.println("|-------------------------------------------------|");
        System.out.println("|  1 - Surname      ( Edit contact surname )      |");
        System.out.println("|-------------------------------------------------|");
        System.out.println("|  2 - Number       ( Edit contact number )       |");
        System.out.println("|-------------------------------------------------|");
        System.out.println("|  3 - All          ( Edit name/surname/number )  |");
        System.out.println("|_________________________________________________|");
        System.out.print("What data do you want to edit ? ");
    }
}
