package contacts;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class MobilePhone {
    public static List<Contacts> ContactList = new ArrayList<>();

    public static void addContact() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new contact name: ");
        String name = scanner.nextLine();
        System.out.println("Enter contact's phone Number: ");
        String phone = scanner.nextLine();

        String number = phone.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
        Files.write(
                Paths.get("data", "contacts.txt"),
                Arrays.asList(name + " " + " | " + number),
                StandardOpenOption.APPEND
        );
        ContactList.add(new Contacts(name, number));
        System.out.println(name + " " + " has been added to the contact list ");
    }

    public static void viewContacts() {
        System.out.println("     Name    |    Phone number ");
        Path ContactsPath = Paths.get("data", "contacts.txt");
        List<String> Personlist = null;
        try {
            Personlist = Files.readAllLines(ContactsPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < Personlist.size(); i += 1) {
            System.out.println((i + 1) + ". " + Personlist.get(i));

        }
    }

    public static void searchContact() {
        System.out.println("3. Enter contact Name: ");
        Scanner myScanner = new Scanner(System.in);
        String searchName = myScanner.nextLine();
        Path ContactsPath = Paths.get("data", "contacts.txt");
        List<String> Personlist;
        try {
            Personlist = Files.readAllLines(ContactsPath);
            for (String person : Personlist) {
                if (person.toLowerCase().contains(searchName.toLowerCase())) {
                    System.out.println("Contact:\n" + person);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void deleteContact() {
        System.out.print(" Enter the contact name: ");
        Scanner myScanner = new Scanner(System.in);
        String searchName = myScanner.nextLine();
        Path ContactsPath = Paths.get("data", "contacts.txt");
        List<String> Personlist;
        try {
            Personlist = Files.readAllLines(ContactsPath);
            List<String> newList = new ArrayList<>();
            for (String person : Personlist) {
                if (person.toLowerCase().contains(searchName)) {
                    continue;
                }
                newList.add(person);
            }
            for (String name : newList) {
                System.out.println(name);
            }
            Files.write(Paths.get("data", "contacts.txt"), newList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void exit() {
        System.exit(0);
    }
    public static int mainMenu() {
        System.out.println("  1. View contacts");
        System.out.println("  2. Add a new contact");
        System.out.println("  3. Search a contact by name and/or phone number.");
        System.out.println("  4. Delete an existing contact.");
        System.out.println("  5. Exit");
        System.out.print("\nEnter an option (1, 2, 3, 4 or 5) ");

        Scanner myScanner = new Scanner(System.in);
        int userChoice = myScanner.nextInt();
        return userChoice;
    }
}
