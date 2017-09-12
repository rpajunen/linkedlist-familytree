package dstr_linkedlist;

import java.util.Scanner;

/**
 *
 * @author Roope
 */
public class DSTR_LINKEDLIST {

    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        Scanner scanner = new Scanner(System.in);
        ActionChooser actionChooser = new ActionChooser(scanner);
        
        FamilyTreeBuilder familyTreeBuilder = new FamilyTreeBuilder(scanner, familyTree);
        familyTreeBuilder.buildDefaultFamilyTree();
        
        Finder finder = new Finder(familyTree);

        while (true) {
            switch (actionChooser.chooseAction()) {
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
                default:
                    System.out.println("Invalid input");

            }

        }
    }

}
