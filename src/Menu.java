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

    public static void showPrintMenu() {
        System.out.println("  _________________________________________________");
        System.out.println(" |                                                 |");
        System.out.println(" |               << Phone book  >>                 |");
        System.out.println(" |            Main  menu -> Print menu             |");
        System.out.println(" |                                                 |");
        System.out.println(" |_________________________________________________|");
        System.out.println(" |                                                 |");
        System.out.println(" | -1 - Come back    ( Return to the main menu )   |");
        System.out.println(" |-------------------------------------------------|");
        System.out.println(" |  0 - Print        ( All )                       |");
        System.out.println(" |-------------------------------------------------|");
        System.out.println(" |  1 - Print        ( Specific )                  |");
        System.out.println(" |_________________________________________________|");
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

    public static void showSortingMenu() {
        System.out.println("  _________________________________________________");
        System.out.println(" |                                                 |");
        System.out.println(" |               << Phone book  >>                 |");
        System.out.println(" |            Main  menu -> Sorting                |");
        System.out.println(" |                                                 |");
        System.out.println(" |_________________________________________________|");
        System.out.println(" |                                                 |");
        System.out.println(" | -1 - Come back    ( Return to the main menu )   |");
        System.out.println(" |-------------------------------------------------|");
        System.out.println(" |  0 - Name         ( Sort  A-Z / Z-A )           |");
        System.out.println(" |-------------------------------------------------|");
        System.out.println(" |  1 - Surname      ( Sort  A-Z / Z-A )           |");
        System.out.println(" |-------------------------------------------------|");
        System.out.println(" |  2 - Number       ( Sort  1-9 / 9-1 )           |");
        System.out.println(" |_________________________________________________|");
        System.out.print("Enter the command: ");
    }

    public static void showSortingMenuByName() {
        System.out.println("  _________________________________________________");
        System.out.println(" |                                                 |");
        System.out.println(" |               << Phone book  >>                 |");
        System.out.println(" |          Main  menu -> Sorting -> Name          |");
        System.out.println(" |                                                 |");
        System.out.println(" |_________________________________________________|");
        System.out.println(" |                                                 |");
        System.out.println(" | -1 - Come back    ( Return to the Sorting )     |");
        System.out.println(" |-------------------------------------------------|");
        System.out.println(" |  0 - Name         ( Sort  A - Z )               |");
        System.out.println(" |-------------------------------------------------|");
        System.out.println(" |  1 - Name         ( Sort  Z - A )               |");
        System.out.println(" |_________________________________________________|");
        System.out.print("Enter the command: ");
    }

    public static void showSortNameAZ() {
        System.out.println("  _________________________________________________");
        System.out.println(" |                                                 |");
        System.out.println(" |               << Phone book  >>                 |");
        System.out.println(" |             You sort Name A to Z                |");
        System.out.println(" |_________________________________________________|");
    }

    public static void showSortNameZA() {
        System.out.println("  _________________________________________________");
        System.out.println(" |                                                 |");
        System.out.println(" |               << Phone book  >>                 |");
        System.out.println(" |             You sort Name Z to A                |");
        System.out.println(" |_________________________________________________|");

    }

    public static void showSortingMenuBySurname() {
        System.out.println("  _________________________________________________");
        System.out.println(" |                                                 |");
        System.out.println(" |               << Phone book  >>                 |");
        System.out.println(" |          Main  menu -> Sorting -> Surname       |");
        System.out.println(" |                                                 |");
        System.out.println(" |_________________________________________________|");
        System.out.println(" |                                                 |");
        System.out.println(" | -1 - Come back    ( Return to the Sorting )     |");
        System.out.println(" |-------------------------------------------------|");
        System.out.println(" |  0 - Surname         ( Sort  A - Z )            |");
        System.out.println(" |-------------------------------------------------|");
        System.out.println(" |  1 - Surname      ( Sort  Z - A )               |");
        System.out.println(" |_________________________________________________|");
        System.out.print("Enter the command: ");
    }

    public static void showSortSurnameAZ() {
        System.out.println("  _________________________________________________");
        System.out.println(" |                                                 |");
        System.out.println(" |               << Phone book  >>                 |");
        System.out.println(" |             You sort Surname A to Z             |");
        System.out.println(" |_________________________________________________|");
    }

    public static void showSortSurnameZA() {
        System.out.println("  _________________________________________________");
        System.out.println(" |                                                 |");
        System.out.println(" |               << Phone book  >>                 |");
        System.out.println(" |             You sort Surname Z to A             |");
        System.out.println(" |_________________________________________________|");

    }

//    public static void showSortingMenuByNumber() {
//        System.out.println("  _________________________________________________");
//        System.out.println(" |                                                 |");
//        System.out.println(" |               << Phone book  >>                 |");
//        System.out.println(" |          Main  menu -> Sorting -> Number        |");
//        System.out.println(" |                                                 |");
//        System.out.println(" |_________________________________________________|");
//        System.out.println(" |                                                 |");
//        System.out.println(" | -1 - Come back    ( Return to the Sorting )     |");
//        System.out.println(" |-------------------------------------------------|");
//        System.out.println(" |  0 - Number         ( Sort  1 - 9 )             |");
//        System.out.println(" |-------------------------------------------------|");
//        System.out.println(" |  1 - Number      ( Sort  9 - 1 )                |");
//        System.out.println(" |_________________________________________________|");
//        System.out.print("Enter the command: ");
//    }

    public static void showSortMenuByField(String fieldName) {
        System.out.println("  ______________________________________________________");
        System.out.println(" |                                                      |");
        System.out.println(" |               << Phone book  >>                      |");
        System.out.println(" |      Main  menu -> Sorting -> " + fieldName +"                   |");
        System.out.println(" |                                                      |");
        System.out.println(" |______________________________________________________|");
        System.out.println(" |                                                      |");
        System.out.println(" | -1 - Come back    ( Return to the Sorting )          |");
        System.out.println(" |------------------------------------------------------|");
        System.out.println(" |  0 - " + fieldName + "         ( Sort  A - Z )"+    "|");
        System.out.println(" |------------------------------------------------------|");
        System.out.println(" |  1 - " + fieldName + "         ( Sort  Z - A )"+    "|");
        System.out.println(" |______________________________________________________|");
        System.out.print("Enter the command: ");
        
    }

//    public static void showSortNumberAsc() {
//        System.out.println("  _________________________________________________");
//        System.out.println(" |                                                 |");
//        System.out.println(" |               << Phone book  >>                 |");
//        System.out.println(" |             You sort Number 1 to 9              |");
//        System.out.println(" |_________________________________________________|");
//    }
//
//    public static void showSortNumberDesc() {
//        System.out.println("  _________________________________________________");
//        System.out.println(" |                                                 |");
//        System.out.println(" |               << Phone book  >>                 |");
//        System.out.println(" |             You sort Number 9 to 1              |");
//        System.out.println(" |_________________________________________________|");
//    }

}
