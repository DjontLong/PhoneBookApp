package phonebook;

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
        System.out.println("| -1 - Come back    ( Return to the phonebook.Contact menu) |");
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

//    public static void showSortingMenuByName() {
//        System.out.println("  _________________________________________________");
//        System.out.println(" |                                                 |");
//        System.out.println(" |               << Phone book  >>                 |");
//        System.out.println(" |          Main  menu -> Sorting -> Name          |");
//        System.out.println(" |                                                 |");
//        System.out.println(" |_________________________________________________|");
//        System.out.println(" |                                                 |");
//        System.out.println(" | -1 - Come back    ( Return to the Sorting )     |");
//        System.out.println(" |-------------------------------------------------|");
//        System.out.println(" |  0 - Name         ( Sort  A - Z )               |");
//        System.out.println(" |-------------------------------------------------|");
//        System.out.println(" |  1 - Name         ( Sort  Z - A )               |");
//        System.out.println(" |_________________________________________________|");
//        System.out.print("Enter the command: ");
//    }

    public static void showSortName(String fieldName, boolean ascending) {
        String sortOrder = ascending ? "A to Z" : "Z to A";

        // Специальное форматирование для полей "Number"
        if (fieldName.equals("Number")) {
            sortOrder = ascending ? "1 to 9" : "9 to 1";
        }

        // Формируем строку и добавляем нужное количество пробелов для центрирования
        String sortMessage = "You sort " + fieldName + " " + sortOrder;
        int totalLength = 49; // Общая длина строки внутри границ
        int padding = (totalLength - sortMessage.length()) / 2; // Количество пробелов для добавления слева и справа
        StringBuilder paddedSortMessage = new StringBuilder();
        for (int i = 0; i < padding; i++) {
            paddedSortMessage.append(" ");
        }
        paddedSortMessage.append(sortMessage);
        while (paddedSortMessage.length() < totalLength) {
            paddedSortMessage.append(" ");
        }

        System.out.println("  _________________________________________________");
        System.out.println(" |                                                 |");
        System.out.println(" |               << Phone book  >>                 |");
        System.out.println(" |" + paddedSortMessage + "|");
        System.out.println(" |_________________________________________________|");
    }


//    public static void showSortNameZA() {
//        System.out.println("  _________________________________________________");
//        System.out.println(" |                                                 |");
//        System.out.println(" |               << Phone book  >>                 |");
//        System.out.println(" |             You sort Name Z to A                |");
//        System.out.println(" |_________________________________________________|");
//
//    }
//
//    public static void showSortingMenuBySurname() {
//        System.out.println("  _________________________________________________");
//        System.out.println(" |                                                 |");
//        System.out.println(" |               << Phone book  >>                 |");
//        System.out.println(" |          Main  menu -> Sorting -> Surname       |");
//        System.out.println(" |                                                 |");
//        System.out.println(" |_________________________________________________|");
//        System.out.println(" |                                                 |");
//        System.out.println(" | -1 - Come back    ( Return to the Sorting )     |");
//        System.out.println(" |-------------------------------------------------|");
//        System.out.println(" |  0 - Surname         ( Sort  A - Z )            |");
//        System.out.println(" |-------------------------------------------------|");
//        System.out.println(" |  1 - Surname      ( Sort  Z - A )               |");
//        System.out.println(" |_________________________________________________|");
//        System.out.print("Enter the command: ");
//    }
//
//    public static void showSortSurnameAZ() {
//        System.out.println("  _________________________________________________");
//        System.out.println(" |                                                 |");
//        System.out.println(" |               << Phone book  >>                 |");
//        System.out.println(" |             You sort Surname A to Z             |");
//        System.out.println(" |_________________________________________________|");
//    }
//
//    public static void showSortSurnameZA() {
//        System.out.println("  _________________________________________________");
//        System.out.println(" |                                                 |");
//        System.out.println(" |               << Phone book  >>                 |");
//        System.out.println(" |             You sort Surname Z to A             |");
//        System.out.println(" |_________________________________________________|");
//
//    }

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
        // Здесь пришлось использовать форматирование строк, так как имя сортируемого поля(Name или Surname, или Number)
        // подставляются динамически, длины наименований разный и границы таблицы ломались

        // %-18s - вырыванивает текст по левому краю и обеспечивает минимальную ширину в 18 символов

        String menuTitle = String.format(" |      Main  menu -> Sorting -> %-18s|", fieldName);
//        String option0 = String.format(" |  0 - %-18s ( Sort  A - Z )         |", fieldName);
//        String option1 = String.format(" |  1 - %-18s ( Sort  Z - A )         |", fieldName);

        String sortType = fieldName.equals("Number") ?
                String.format(" |  0 - %-18s ( Sort  1 - 9 )         |", fieldName) :
                String.format(" |  0 - %-18s ( Sort  A - Z )         |", fieldName);

        String sortTypeReversed = fieldName.equals("Number") ?
                String.format(" |  1 - %-18s ( Sort  9 - 1 )         |", fieldName) :
                String.format(" |  1 - %-18s ( Sort  Z - A )         |", fieldName);

        System.out.println("  _________________________________________________");
        System.out.println(" |                                                 |");
        System.out.println(" |               << Phone book  >>                 |");
        System.out.println(menuTitle);
        System.out.println(" |                                                 |");
        System.out.println(" |_________________________________________________|");
        System.out.println(" |                                                 |");
        System.out.println(" | -1 - Come back    ( Return to the Sorting )     |");
        System.out.println(" |-------------------------------------------------|");
        System.out.println(sortType);
        System.out.println(" |-------------------------------------------------|");
        System.out.println(sortTypeReversed);
        System.out.println(" |_________________________________________________|");
        System.out.print("Enter the command: ");
    }

    public static void showSearchMenu() {
        System.out.println("  _________________________________________________");
        System.out.println(" |                                                 |");
        System.out.println(" |               << Phone book  >>                 |");
        System.out.println(" |             Main  menu -> Search                |");
        System.out.println(" |                                                 |");
        System.out.println(" |_________________________________________________|");
        System.out.println(" |                                                 |");
        System.out.println(" | -1 - Come back  ( Return to the Main menu )     |");
        System.out.println(" |-------------------------------------------------|");
        System.out.println(" |  0 - Name       ( Search by Name  )             |");
        System.out.println(" |-------------------------------------------------|");
        System.out.println(" |  1 - Surname    ( Search by Surname )           |");
        System.out.println(" |-------------------------------------------------|");
        System.out.println(" |  2 - Number     ( Search by  Number )           |");
        System.out.println(" |_________________________________________________|");
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
