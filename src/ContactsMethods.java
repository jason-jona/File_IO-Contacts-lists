import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

//***************************** PATH *****************************
public class ContactsMethods {
    public static Path contactsPath = Paths.get("data", "Contacts.txt");
    public static Scanner sc = new Scanner(System.in);

    //***************************** GETTER *****************************
    public static void getContacts() {
        // displays Contacts
        List<String> contactsList = null;
        try {
            contactsList = Files.readAllLines(contactsPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Name | Phone number \n---------------");

        for (String s : contactsList) {
            System.out.println(s);
        }
    }

    //***************************** METHODS ****************************
    // Add Contact
    public static void addContact() {
        //adds contact from user input
        System.out.println("Enter new contact name: ");
        String nameInput = sc.nextLine();
        contactsCheck(nameInput);
        System.out.println("Enter new contact number");
        String numInput = sc.nextLine();
        String numberInput = numInput.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "$1-$2-$3");
        String newEntry = nameInput + " | " + numberInput;
        try {
            Files.write(
                    contactsPath,
                    Arrays.asList(newEntry),
                    StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Display Contacts
        List<String> contactsList = null;
        try {
            contactsList = Files.readAllLines(contactsPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Name | Phone number \n---------------");

        for (String s : contactsList) {
            System.out.println(s);
        }
    }

    public static void removeContacts() {
//        // Display Contacts
        List<String> contactsList = null;
        try {
            contactsList = Files.readAllLines(contactsPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Remove Contacts
        System.out.println("Remove entries that match user input: ");
        String removeInput = sc.nextLine();
        Iterator<String> listIterator = contactsList.iterator();
        while (listIterator.hasNext()) {
            String item = listIterator.next();
            if (item.contains(removeInput)) {
                listIterator.remove();
            }
        }
        // Write to Contacts
        try {
            Files.write(
                    contactsPath, contactsList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Print List Again
        System.out.println("Name | Phone number \n---------------");

        for (String s : contactsList) {
            System.out.println(s);
        }
    }

    public static void searchContacts() {
        // Display Contacts
        List<String> contactsList = null;
        try {
            contactsList = Files.readAllLines(contactsPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Search Contacts
        System.out.println("Search contacts by name: ");
        ArrayList<String> arrlist = new ArrayList<>();
        String searchInput = sc.nextLine();

        for (String s : contactsList) {
            if (s.contains(searchInput)) {
                arrlist.add(s);
            }
        }
        if (arrlist.size() > 0) {
            System.out.println(arrlist);
        } else if (arrlist.size() == 0) {
            System.out.println("No entries found.");
        }
    }

    public static void contactsCheck(String input) {
        // Display Contacts
        ArrayList<Iterator> checkList = new ArrayList<>();
        List<String> contactsList = null;
        try {
            contactsList = Files.readAllLines(contactsPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Remove Contacts
        for (String s : contactsList) {
            if (s.contains(input)) {
                System.out.println("Entry name " + s + " already exists. Overwrite? Y/N");
            }
        }
        String response = sc.nextLine();
        Iterator<String> listIterator = contactsList.iterator();
        if (response.matches("(?i)Y|Yes|1")) {
            removeContacts();
        }
    }
}

