package PhoneBook;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Database {
    private String file;

    public Database(String file) {
        this.file = file;
    }

    public void addToDB(ArrayList<Contact> contacts) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(contacts);
        objectOutputStream.close();
    }

    public ArrayList<Contact> load() throws IOException, ClassNotFoundException {

        ArrayList<Contact> contacts = new ArrayList<Contact>();

        File tmpFile = new File(file);
        if(!tmpFile.exists()) {
            return contacts;
        }else {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            contacts = (ArrayList<Contact>) objectInputStream.readObject();
            return contacts;
        }

       /* File tmpFile = new File(file);
        if (!tmpFile.exists())
            return new ArrayList<Contact>();

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Contact> contacts = (ArrayList<Contact>) ois.readObject();
        ois.close();
        return contacts;*/


    }

}
