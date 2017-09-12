package dstr_linkedlist;

import java.util.Scanner;

public class ActionChooser {

    private final Scanner scanner;

    public ActionChooser(Scanner scanner) {
        this.scanner = scanner;
    }

    public String chooseAction() {
        System.out.print("Select function:\n"
                + "1. find parents\n"
                + "2. find children\n"
                + "3. determine if two individuals are siblings\n"
                + "4. find ancestors\n"
                + "5. edit family tree\n"
                + "6. show all members of the family tree\n"
                + "Enter number: ");
        return scanner.nextLine();
    }

}
