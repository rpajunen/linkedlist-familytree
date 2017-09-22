package dstr_linkedlist;

import java.util.ArrayList;

public class Finder {

    private final FamilyTree familyTree;

    public Finder(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    public void findParents(String name) {
        try {
            if (familyTree.getParents(name).isEmpty()) {
                System.out.println("No parents found for " + name);
            } else {
                System.out.println("Parents of " + name + " are:");
                familyTree.getParents(name).stream().forEach(p -> System.out.println("-" + p.getName()));
            }
        } catch (Exception e) {
            System.out.println("Couldn't find: " + name);

        }
    }

    public void findChildren(String name) {
        try {
            if (familyTree.getMember(name).getChildren().isEmpty()) {
                System.out.println("No children found for " + name);
            } else {
                System.out.println("Children for " + name + " are: ");
                familyTree.getMember(name).getChildren().stream().forEach(c -> System.out.println("-" + c.getName()));
            }
        } catch (Exception e) {
            System.out.println("Couldn't find: " + name);
        }
    }

    public void areSiblings(String firstName, String secondName) {
        try {
            if (familyTree.getParents(firstName).equals(familyTree.getParents(secondName))) {
                if (familyTree.getParents(firstName).isEmpty()) {
                    System.out.println(firstName + " and " + secondName + " are not siblings.");
                    return;
                }
                System.out.println(firstName + " and " + secondName + " are siblings.");
            } else {
                System.out.println(firstName + " and " + secondName + " are not siblings.");
            }
        } catch (Exception e) {
            System.out.println("One of the names entered was not found from the family tree");
        }
    }

    public void findAncestors(String name) { // refactor
        try {
            ArrayList<Member> ancestors = familyTree.getParents(name);
            if (ancestors.isEmpty()) {
                System.out.println("No ancestors found for " + name);
                return;
            } else {
                for (int i = 0; i < ancestors.size(); i++) {
                    if (familyTree.hasParents(ancestors.get(i).getName())) {
                        ancestors.addAll(familyTree.getParents(ancestors.get(i).getName()));
                    }
                }
            }
            System.out.println("Ancestors for " + name + " are: ");
            ancestors.stream().forEach(a -> System.out.println("-" + a.getName()));
        } catch (Exception e) {
            System.out.println("Couldn't find: " + name);
        }
    }

    public void showAllMembers() {
        familyTree.getFamilyTree().stream().forEach(m -> System.out.println("-" + m.getName()));
    }

}
