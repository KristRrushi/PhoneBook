package PhoneBook;


import java.io.Serializable;

public class Contact implements Serializable {

    private String firstName;
    private String lastName;
    private String homeNumber;
    private String  workNumber;
    private String cellNumber;
    private int id;

    public Contact() {
        this.firstName = "";
        this.lastName = "";
        this.homeNumber = "None";
        this.workNumber = "None";
        this.cellNumber = "None";
    }

    public void setNumber(String type, String number) {
        switch (type) {
            case "home":
                this.homeNumber = number;
                break;
            case "work":
                this.workNumber = number;
                break;
            case "cellphone":
                this.cellNumber = number;
                break;
        }
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHomeNumber() {
        return homeNumber;
    }



    public String getWorkNumber() {
        return workNumber;
    }


    public String getCellNumber() {
        return cellNumber;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

