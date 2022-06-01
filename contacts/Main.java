
package contacts;

import java.io.IOException;

public interface Main {
    static void main(String args[]) throws IOException {

        while (true) {
            int userChoice = MobilePhone.mainMenu();
            if (userChoice == 1)
                MobilePhone.viewContacts();
            else if (userChoice == 2)
                MobilePhone.addContact();
            else if (userChoice == 3)
                MobilePhone.searchContact();
            else if (userChoice == 4) {
                MobilePhone.deleteContact();
            } else if (userChoice == 5) {
                MobilePhone.exit();
            } else
                System.out.println("Try again");
        }
    }
}
