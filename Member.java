package dstr_linkedlist;

import java.util.ArrayList;
import java.util.Objects;

public class Member {

    private final String name;
    private final ArrayList<Member> children;

    public Member(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public ArrayList<Member> getChildren() {
        return children;
    }

    public String getName() {
        return this.name;
    }

    public void addChildren(Member member) {
        this.children.add(member);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Member other = (Member) obj;
        return Objects.equals(this.name, other.name);
    }

    
    
}
