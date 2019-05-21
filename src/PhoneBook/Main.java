package PhoneBook;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static Scanner inp = new Scanner(System.in);

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        String file = "phonebook.bin";

        PhoneBook addressBook = new PhoneBook(file);

        System.out.println("Welcome to the Address Book");
        System.out.println("Press 1 to add new contact");
        System.out.println("Press 2 to update a contact");
        System.out.println("Press 3 to delete a contact");
        System.out.println("Press 4 to view all the contacts");
        System.out.println("Press 5 to search contacts by first name");
        System.out.println("Press 6 to exit a contact");
        int choice = Integer.parseInt(inp.nextLine());

        while (choice != 6) {
            switch (choice) {
                case 1:
                    Contact c = new Contact();
                    System.out.println("Enter First Name");
                    String firsName = inp.nextLine();
                    c.setFirstName(firsName);
                    System.out.println("Enter Last Name");
                    String lastName = inp.nextLine();
                    c.setLastName(lastName);
                    System.out.println("Enter Phone type(home, work, cellphone)");
                    String type = inp.nextLine();
                    System.out.println("Enter Phone Number");
                    String number = inp.nextLine();
                    c.setNumber(type, number);

                    addressBook.addContact(c);
                    break;
                case 2:
                    System.out.println("Enter Id of the contact to update");
                    int id = Integer.parseInt(inp.nextLine());
                    Contact u = new Contact();
                    System.out.println("Enter First Name");
                    String updateFirstName = inp.nextLine();
                    u.setFirstName(updateFirstName);
                    System.out.println("Enter Last Name");
                    String updateLastName = inp.nextLine();
                    u.setLastName(updateLastName);
                    System.out.println("Enter Phone type(home, work, cellphone)");
                    type = inp.nextLine();
                    System.out.println("Enter Phone Number");
                    number = inp.nextLine();
                    u.setNumber(type, number);
                    addressBook.updateContact(id, u);
                    break;
                case 3:
                    System.out.println("Enter Id of the contact to update");
                    id = Integer.parseInt(inp.nextLine());
                    addressBook.deleteContact(id);
                    break;
                case 4:
                    addressBook.display();
                    break;
                case 5:
                    System.out.println("Enter First name");
                    String fname = inp.nextLine();
                    addressBook.Search(fname);
                    break;
            }
            System.out.println("Welcome to the Address Book");
            System.out.println("Press 1 to add new contact");
            System.out.println("Press 2 to update a contact");
            System.out.println("Press 3 to delete a contact");
            System.out.println("Press 4 to view all the contacts");
            System.out.println("Press 5 to search contacts by first name");
            System.out.println("Press 6 to exit a contact");
            choice = Integer.parseInt(inp.nextLine());
        }

    }
}
