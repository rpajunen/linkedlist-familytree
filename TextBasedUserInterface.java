package dstr_linkedlist;

import java.util.Scanner;

public class TextBasedUserInterface {

    private final Scanner scanner;
    private final Functionalities functionalities;
    private final FamilyTreeBuilder familyTreeBuilder;
    private final Finder finder;

    public TextBasedUserInterface(Scanner scanner, Functionalities functionalities, FamilyTreeBuilder familyTreeBuilder, Finder finder) {
        this.scanner = scanner;
        this.functionalities = functionalities;
        this.familyTreeBuilder = familyTreeBuilder;
        this.finder = finder;
    }

    public void start() {
        while (true) {
            switch (functionalities.selectFunction()) {
                case "1": // parents
                    System.out.print("Enter name: ");
                    finder.findParents(scanner.nextLine());
                    break;
                case "2": // children
                    System.out.print("Enter name: ");
                    finder.findChildren(scanner.nextLine());
                    break;
                case "3": // siblings
                    System.out.println("Enter two names: ");
                    finder.areSiblings(scanner.nextLine(), scanner.nextLine());
                    break;
                case "4": // ancestors
                    System.out.print("Enter name: ");
                    finder.findAncestors(scanner.nextLine());
                    break;
                case "5": // new member
                    familyTreeBuilder.newMember();
                    break;
                case "6": // show all members
                    finder.showAllMembers();
                    break;
                case "7": // exit
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }
}
