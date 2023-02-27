public class Contacts {
    public static void main(String[] args) {
        String userInput;
            ContactsMethods.getContacts();
        do {
            System.out.println("\nContacts Menu Actions\n1. Add\n2. Remove\n3. Search\n4. Display \n5. Quit");
            System.out.println("Enter Menu Action: ");
            userInput = ContactsMethods.sc.nextLine();

            if (userInput.matches("(?i)1|Add")) {
                ContactsMethods.addContact();
            } else if (userInput.matches("(?i)2|Remove")) {
                ContactsMethods.removeContacts();
            } else if (userInput.matches("(?i)3|Search")) {
                ContactsMethods.searchContacts();
            } else if (userInput.matches("(?i)4|Display")){
                ContactsMethods.getContacts();
            } else if (userInput.matches("(?i)5|Quit")){
                System.out.println("Goodbye");
            } else {
                System.out.println("Could not find method, please check spelling.");
            }
        } while (!userInput.matches("(?i)5|Quit"));


    }
    }

