import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;


public class Contacts {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
     String userInput = sc.nextLine();
        ContactsMethods.getContacts();
        System.out.println("\nContacts Menu Actions\n Add | Remove | Search | Quit");
        System.out.println("Enter Menu Action: " + userInput);
        do {

            if (userInput.matches("(?i)Add")) {
                ContactsMethods.addContact();
            } else if (userInput.matches("(?i)Remove")) {
                ContactsMethods.removeContacts();
            } else if (userInput.matches("(?i)Search")) {
                ContactsMethods.searchContacts();
            } else {
                System.out.println("Could not find method, please check spelling.");
            }
        } while (userInput.matches("(?i)Quit"));


        }
    }

