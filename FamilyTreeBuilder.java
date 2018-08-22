package dstr_linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class FamilyTreeBuilder {

    private final Scanner scanner;
    private final LinkedList<Member> familyTree;
    private final FamilyTree familyTreeObject;

    public FamilyTreeBuilder(Scanner scanner, FamilyTree familyTree) {
        this.scanner = scanner;
        this.familyTree = familyTree.getFamilyTree();
        this.familyTreeObject = familyTree;
    }

    public void buildDefaultFamilyTree() {
        
        familyTreeObject.add("Sam");
        familyTreeObject.add("Mary");
        familyTreeObject.add("Alex");
        familyTreeObject.add("Joanna");
        familyTreeObject.add("Sandra");
        familyTreeObject.add("John");
        familyTreeObject.add("Julie");
        familyTreeObject.add("Susan");
        familyTreeObject.add("Tim");
        familyTreeObject.add("Nick");
        familyTreeObject.add("Roope");
        familyTreeObject.add("Keijo");


        familyTreeObject.getMember("Sam").addChildren(familyTreeObject.getMember("Alex"));
        familyTreeObject.getMember("Mary").addChildren(familyTreeObject.getMember("Alex"));
        familyTreeObject.getMember("John").addChildren(familyTreeObject.getMember("Susan"));
        familyTreeObject.getMember("John").addChildren(familyTreeObject.getMember("Tim"));
        familyTreeObject.getMember("Julie").addChildren(familyTreeObject.getMember("Susan"));
        familyTreeObject.getMember("Julie").addChildren(familyTreeObject.getMember("Tim"));
        familyTreeObject.getMember("Alex").addChildren(familyTreeObject.getMember("Joanna"));
        familyTreeObject.getMember("Susan").addChildren(familyTreeObject.getMember("Joanna"));
        familyTreeObject.getMember("Joanna").addChildren(familyTreeObject.getMember("Sandra"));
        familyTreeObject.getMember("Nick").addChildren(familyTreeObject.getMember("Sandra"));
    }

    public void newMember() {
        ArrayList<Member> children = new ArrayList<>();
        System.out.print("Enter name of new member or person to be edited. (enter c to cancel)\nName: ");
        Member member = new Member(scanner.nextLine());

        if (member.getName().equals("c")) {
            return;
        }

        if (familyTree.contains(member)) {
            System.out.println(member.getName() + " is already a member of the family tree");
        } else {
            System.out.println("New people created: " + member.getName());
        }

        while (true) {
            System.out.println("Add children to " + member.getName() + " ? (y/n)");
            if (scanner.nextLine().equals("y")) {
                System.out.println("What is the name of the child?");
                Member child = new Member(scanner.nextLine());
                children.add(child);
            } else {
                break;
            }
        }
        
        if (familyTree.contains(member)) {
            Member correctMember = familyTreeObject.getMember(member.getName());
            updateFamilyTree(children, correctMember);
        } else {
            this.familyTree.add(member);
            System.out.println(member.getName() + " added to the family tree.");
            updateFamilyTree(children, member);
        }

    }

    public void updateFamilyTree(ArrayList<Member> children, Member correctMember) {
        children.stream().forEach(child -> {
            correctMember.addChildren(child);
            System.out.println(child.getName() + " is the child of " + correctMember.getName());
            this.familyTree.add(child);
        });
    }

}
