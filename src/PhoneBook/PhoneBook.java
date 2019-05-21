package PhoneBook;

import java.io.IOException;
import java.util.ArrayList;

public class PhoneBook {
    private ArrayList<Contact> contacts;
    public static int id;
    private Database db;

    public PhoneBook(String filePath) throws IOException, ClassNotFoundException {
        this.db = new Database(filePath);
        this.contacts = this.db.load();
        id = 0;
    }

    public void addContact(Contact c) throws IOException {
        id += 1;
        c.setId(id);
        contacts.add(c);
        db.addToDB(contacts);
    }

    public boolean deleteContact(int id) throws IOException {
        for (Contact contact : contacts) {
            if(contact.getId() == id) {
                contacts.remove(contact);
                db.addToDB(contacts);
                return true;
            }
        }
        return false;
    }

    public boolean updateContact(int id, Contact c) throws IOException {
        for (int i = 0; i < contacts.size(); i++) {
            Contact temp = contacts.get(i);
            if(temp.getId() == id) {
                c.setId(id);
                contacts.set(i, c);
                db.addToDB(contacts);
                return true;
            }
        }
        return false;
    }

    public void display() {
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println("***************************");
            Contact temp = contacts.get(i);
            System.out.println("ID : " + temp.getId());
            System.out.println("First Name : " + temp.getFirstName());
            System.out.println("Last Name : " + temp.getLastName());
            System.out.println("Work Number : " + temp.getWorkNumber());
            System.out.println("Cell Number : " + temp.getCellNumber());
            System.out.println("Home Number : " + temp.getHomeNumber());
            System.out.println("***************************");
        }
    }

    public void Search(String firstname) {
        for (int i = 0; i < contacts.size(); i++) {
            Contact temp = contacts.get(i);
            if (temp.getFirstName().equalsIgnoreCase(firstname)) {
                System.out.println("***************************");
                System.out.println("ID : " + temp.getId());
                System.out.println("First Name : " + temp.getFirstName());
                System.out.println("Last Name : " + temp.getLastName());
                System.out.println("Work Number : " + temp.getWorkNumber());
                System.out.println("Cell Number : " + temp.getCellNumber());
                System.out.println("Home Number : " + temp.getHomeNumber());
                System.out.println("***************************");
            }
        }
    }

}
