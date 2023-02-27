import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class Contacts {
    public static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {

        //adds contact from user input
        System.out.println("Enter new contact info: ");
        try {
            Files.write(
                    Paths.get("data", "Contacts.txt"),
                    Arrays.asList(sc.nextLine()),
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

        //search contacts
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
    }

