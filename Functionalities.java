package dstr_linkedlist;

import java.util.Scanner;

public class Functionalities {

    private final Scanner scanner;

    public Functionalities(Scanner scanner) {
        this.scanner = scanner;
    }

    public String selectFunction() {
        System.out.print("Select function:\n"
                + "1. find parents\n"
                + "2. find children\n"
                + "3. determine if two individuals are siblings\n"
                + "4. find ancestors\n"
                + "5. edit family tree\n"
                + "6. show all members of the family tree\n"
                + "7. Exit\n"
                + "Enter number: ");
        return scanner.nextLine();
    }

}
