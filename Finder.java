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

    public void areSiblings(String first, String second) {
        try {
            if (familyTree.getParents(first).equals(familyTree.getParents(second))) {
                if (familyTree.getParents(first).isEmpty()) {
                    System.out.println(first + " and " + second + " are not siblings.");
                    return;
                }
                System.out.println(first + " and " + second + " are siblings.");
            } else {
                System.out.println(first + " and " + second + " are not siblings.");
            }
        } catch (Exception e) {
            System.out.println("One of the names entered was not found from the family tree");
        }
    }

    public void findAncestors(String name) {
        try {
            ArrayList<Member> ancestors;
            ancestors = familyTree.getParents(name);
            if (!ancestors.isEmpty()) {
                if (familyTree.hasParents(ancestors.get(0).getName())) {
                    ancestors.addAll(familyTree.getParents(ancestors.get(0).getName()));
                }
                if (familyTree.hasParents(ancestors.get(1).getName())) {
                    ancestors.addAll(familyTree.getParents(ancestors.get(1).getName()));
                }
                if (ancestors.size() > 2) {
                    if (familyTree.hasParents(ancestors.get(2).getName())) {
                        ancestors.addAll(familyTree.getParents(ancestors.get(2).getName()));
                    }
                    if (ancestors.size() > 3) {
                        if (familyTree.hasParents(ancestors.get(3).getName())) {
                            ancestors.addAll(familyTree.getParents(ancestors.get(3).getName()));
                        }
                        if (ancestors.size() > 4) {
                            if (familyTree.hasParents(ancestors.get(4).getName())) {
                                ancestors.addAll(familyTree.getParents(ancestors.get(4).getName()));
                            }
                            if (ancestors.size() > 5) {
                                if (familyTree.hasParents(ancestors.get(5).getName())) {
                                    ancestors.addAll(familyTree.getParents(ancestors.get(5).getName()));
                                }
                                if (ancestors.size() > 6) {
                                    if (familyTree.hasParents(ancestors.get(6).getName())) {
                                        ancestors.addAll(familyTree.getParents(ancestors.get(6).getName()));
                                    }

                                }
                            }
                        }
                    }
                }
            }
            if (ancestors.isEmpty()) {
                System.out.println("No ancestors found for " + name);
            } else {
                System.out.println("Ancestors for " + name + " are: ");
                ancestors.stream().forEach(a -> System.out.println("-" + a.getName()));
            }
        } catch (Exception e) {
            System.out.println("Couldn't find: " + name);
        }
    }

    public void showAllMembers() {
        familyTree.getFamilyTree().stream().forEach(m -> System.out.println("-" + m.getName()));
    }

}
