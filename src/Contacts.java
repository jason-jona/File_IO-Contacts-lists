import java.util.Scanner;


public class Contacts {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String userInput;
        do {
            ContactsMethods.getContacts();
            System.out.println("\nContacts Menu Actions\n Add | Remove | Search | Quit");
            System.out.println("Enter Menu Action: ");
            userInput = sc.nextLine();

            if (userInput.matches("(?i)Add")) {
                ContactsMethods.addContact();
            } else if (userInput.matches("(?i)Remove")) {
                ContactsMethods.removeContacts();
            } else if (userInput.matches("(?i)Search")) {
                ContactsMethods.searchContacts();
            } else if (userInput.matches("(?i)Quit")){
                System.out.println("Goodbye");
            } else {
                System.out.println("Could not find method, please check spelling.");
            }
        } while (!userInput.matches("(?i)Quit"));


    }
    }

