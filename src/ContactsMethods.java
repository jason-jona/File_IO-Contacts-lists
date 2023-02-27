import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class ContactsMethods {
    public static Scanner sc = new Scanner(System.in);

    public static void getContacts(){
        // displays Contacts
        Path contactsPath = Paths.get("data", "Contacts.txt");
        List<String> contactsList = null;
        try {
            contactsList = Files.readAllLines(contactsPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Name | Phone number \n---------------");

        for(int i = 0; i < contactsList.size(); i += 1) {
            System.out.println((contactsList.get(i)));
        }
    }

    public static void addContact(){
        //adds contact from user input
        System.out.println("Enter new contact info: ");
        String input = sc.nextLine();
        try {
            Files.write(
                    Paths.get("data", "Contacts.txt"),
                    Arrays.asList(input),
                    StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // displays Contacts
        Path contactsPath = Paths.get("data", "Contacts.txt");
        List<String> contactsList = null;
        try {
            contactsList = Files.readAllLines(contactsPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Name | Phone number \n---------------");

        for (int i = 0; i < contactsList.size(); i += 1) {
            System.out.println((contactsList.get(i)));
        }
    }

    public static void removeContacts(){
//        //displays contacts
        Path contactsPath = Paths.get("data", "Contacts.txt");
        List<String> contactsList = null;
        try {
            contactsList = Files.readAllLines(contactsPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //remove contact
        System.out.println("Remove entries that match user input: ");
        Scanner sb = new Scanner(System.in);
        String removeInput = sb.nextLine();
        Iterator<String> listIterator = contactsList.iterator();
        while (listIterator.hasNext()) {
            String item = listIterator.next();
            if (item.contains(removeInput)) {
                listIterator.remove();
            }
        }

        //print list again
        System.out.println("Name | Phone number \n---------------");

        for (int i = 0; i < contactsList.size(); i += 1) {
            System.out.println((contactsList.get(i)));
        }
    }

    public static void searchContacts(){
        //displays contacts
        Path contactsPath = Paths.get("data", "Contacts.txt");
        List<String> contactsList = null;
        try {
            contactsList = Files.readAllLines(contactsPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //search contacts
        System.out.println("Search contacts by name: ");
        ArrayList<String> arrlist = new ArrayList<>();
        Scanner sa = new Scanner(System.in);
        String searchInput = sa.nextLine();

        for (int i = 0; i < contactsList.size(); i += 1) {
            if(contactsList.get(i).contains(searchInput)){
                arrlist.add(contactsList.get(i));
            }
        }
        System.out.println(arrlist);
    }

    public static void contactsCheck(){
        //        //displays contacts
        ArrayList<Iterator> checkList = new ArrayList<>();
        Path contactsPath = Paths.get("data", "Contacts.txt");
        List<String> contactsList = null;
        try {
            contactsList = Files.readAllLines(contactsPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {

    }
}
