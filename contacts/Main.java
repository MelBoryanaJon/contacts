package contacts;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    // Creating an instant with a default Number
    private static MobilePhone mobilePhone = new MobilePhone("000 443 876");

    public static void main(String[] args) {

        boolean quite = false;
        startPhone();
        printAction();
        while (!quite) {
            System.out.println("Enter an option (1, 2, 3, 4 or 5)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:

                    System.out.println("\n Exit");
                    quite = true;
                    break;

                case 1:
                    mobilePhone.printContacts();
                    break;

                case 2:
                    addNewContact();
                    break;

                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printAction();
                    break;


            }
        }
    }

    private static void addNewContact() {
        System.out.println("Enter new Contact Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter phone Number: ");
        String phone = scanner.nextLine();
        Contacts newContact = Contacts.createContact(name, phone);
        if(mobilePhone.addNewContact(newContact)) {
            System.out.println("New Contact Added: name = "+ name + " , phone" + phone );
        }else {
            System.out.println("Can't add, " + name +" already on file");
        }
    }
    private static void updateContact() {
        System.out.println("Enter existing contact name : ");
        String name = scanner.nextLine();
        Contacts extContact = mobilePhone.queryContact(name);
        if(extContact == null)
        {
            System.out.println("Cannot found contact");
            return;
        }

        System.out.println("Enter new Conatct Name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter new Phone Number: ");
        String newNumber = scanner.nextLine();

        Contacts newContact = Contacts.createContact(newName, newNumber);
        if(mobilePhone.updateContact(extContact, newContact))
        {
            System.out.println("Successfully updated");
        }else {
            System.out.println("Error Updating Contact");
        }
    }
    private static void removeContact() {
        System.out.println("Enter existing contact name : ");
        String name = scanner.nextLine();
        Contacts extContact = mobilePhone.queryContact(name);
        if(extContact == null)
        {
            System.out.println("Cannot found contact");
            return;
        }

        if(mobilePhone.removeContact(extContact)) {
            System.out.println("Successfully deleted");
        }else {
            System.out.println("Error Deleting Contact");
        }
    }
    private static void queryContact() {
        System.out.println("Enter existing contact name : ");
        String name = scanner.nextLine();
        Contacts extContact = mobilePhone.queryContact(name);
        if(extContact == null)
        {
            System.out.println("Cannot found contact");
            return;
        }

        System.out.println("Name : " + extContact.getName() +
                " Phone Number is: " + extContact.getPhoneNumber());
    }


    private static void startPhone() {
        System.out.println("Starting Phone . . .");
    }
    private static void printAction() {
        System.out.println("\nAvailable actions:\npress");
        System.out.println(
                "1. View Contacts\n"+
                "2. Add a new contact\n"+
                "3. Search a contact by name\n"+
                "4. Delete an existing contact.\n"+
                "5. Exit\n");
        System.out.println("Choose Your Action: ");
    }

}