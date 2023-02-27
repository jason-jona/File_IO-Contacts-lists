public class Contacts {
    public static void main(String[] args) {
        String userInput;
            ContactsMethods.getContacts();
        do {
            System.out.println("\nContacts Menu Actions\nAdd | Remove | Search | Display |  Quit");
            System.out.println("Enter Menu Action: ");
            userInput = ContactsMethods.sc.nextLine();

            if (userInput.matches("(?i)Add")) {
                ContactsMethods.addContact();
            } else if (userInput.matches("(?i)Remove")) {
                ContactsMethods.removeContacts();
            } else if (userInput.matches("(?i)Search")) {
                ContactsMethods.searchContacts();
            } else if (userInput.matches("(?i)Display")){
                ContactsMethods.getContacts();
            } else if (userInput.matches("(?i)Quit")){
                System.out.println("Goodbye");
            } else {
                System.out.println("Could not find method, please check spelling.");
            }
        } while (!userInput.matches("(?i)Quit"));


    }
    }

