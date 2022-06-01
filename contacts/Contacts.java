package contacts;

public class Contacts {

    private String name;   // firstName is a data member.
    private String number; // phoneNumber is a data member

    public Contacts(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String toString() {
        return this.name + " | " + this.number;
    }

}
