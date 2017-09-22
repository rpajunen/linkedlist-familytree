package dstr_linkedlist;

import java.util.ArrayList;

public class Finder {

    private final FamilyTree familyTree;

    public Finder(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    public void findParents(String name) {
        if (isMember(name)) {
            if (familyTree.getParents(name).isEmpty()) {
                System.out.println(name + " has no parents in the family tree");
            } else {
                System.out.println("Parents of " + name + " are:");
                familyTree.getParents(name).stream().forEach(parent -> System.out.println("-" + parent.getName()));
            }
        }
    }

    public void findChildren(String name) {
        try {
            if (familyTree.getMember(name).getChildren().isEmpty()) {
                System.out.println(name + " has no children in the family tree");
            } else {
                System.out.println("Children for " + name + " are: ");
                familyTree.getMember(name).getChildren().stream().forEach(child -> System.out.println("-" + child.getName()));
            }
        } catch (Exception e) {
            System.out.println(name + " is not a member of the family tree");
        }
    }

    public void areSiblings(String firstName, String secondName) {
        if (isMember(firstName) && isMember(secondName)) {
            if (familyTree.getParents(firstName).equals(familyTree.getParents(secondName))) {
                if (familyTree.getParents(firstName).isEmpty()) {
                    System.out.println(firstName + " and " + secondName + " are not siblings.");
                    return;
                }
                System.out.println(firstName + " and " + secondName + " are siblings.");
            } else {
                System.out.println(firstName + " and " + secondName + " are not siblings.");
            }
        }
    }

    public void findAncestors(String name) {
        if (isMember(name)) {
            ArrayList<Member> ancestors = familyTree.getParents(name);
            if (ancestors.isEmpty()) {
                System.out.println(name + " has no ancestors in the family tree");
                return;
            } else {
                for (int i = 0; i < ancestors.size(); i++) {
                    if (familyTree.hasParents(ancestors.get(i).getName())) {
                        ancestors.addAll(familyTree.getParents(ancestors.get(i).getName()));
                    }
                }
            }
            System.out.println("Ancestors for " + name + " are: ");
            ancestors.stream().forEach(ancestor -> System.out.println("-" + ancestor.getName()));
        }
    }

    public void showAllMembers() {
        familyTree.getFamilyTree().stream().forEach(member -> System.out.println("-" + member.getName()));
    }

    private boolean isMember(String name) {
        if (!familyTree.getFamilyTree().contains(familyTree.getMember(name))) {
            System.out.println(name + " is not a member of the family tree");
            return false;
        }
        return true;
    }

}
