package dstr_linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;

public class FamilyTree {

    private final LinkedList<Member> familyTree;

    public FamilyTree() {
        this.familyTree = new LinkedList<>();
    }

    public void add(String name) {
        this.familyTree.add(new Member(name));
    }

    public LinkedList<Member> getFamilyTree() {
        return familyTree;
    }

    public boolean hasParents(String name) {
        return !getParents(name).isEmpty();
    }

    public Member getMember(String name) {
        return familyTree.stream()
                .filter(m -> m.getName().equals(name))
                .findFirst()
                .get();
    }

    public ArrayList<Member> getParents(String child) {            
        ArrayList<Member> parents = new ArrayList<>();
        this.familyTree.stream()
                .forEach(member -> {
                    member.getChildren().stream().forEach(children -> {
                        if (children.getName().equals(child)) {
                            parents.add(member);
                        }
                    });
                });
        return parents;
    }
    
    
}
