package blanks.liqui;

import java.util.*;

public class SortSet {
    public static void main(String[] args) {
        Set<Elem> db = new HashSet<>();
        Set<Elem> newEls = new HashSet<>();

        db.add(new Elem(1L, "a"));
        db.add(new Elem(2L, "b"));
        db.add(new Elem(3L, "c"));

        newEls.add(new Elem(2L, "f"));
        newEls.add(new Elem(3L, "c"));
        newEls.add(new Elem(4L, "d"));

        System.out.println("Old: " + db);
        System.out.println("New: " + newEls);

        Set<Elem> tempDB = new HashSet<>(db);
        Set<Elem> tempNew = new HashSet<>(newEls);

        Set<Elem> toAdd = new HashSet<>();
        Set<Elem> toDel = new HashSet<>();
        Set<Elem> toUpd = new HashSet<>();

        newEls.removeAll(db);
        db.removeAll(tempNew);
        tempNew.removeAll(tempDB);

        for(Elem elem: db) {
            boolean isInNew = false;
            for(Elem newElem : newEls) {
                if(elem.getId().equals(newElem.getId())) {
                    isInNew = true;
                    tempNew.remove(newElem);
                    toUpd.add(newElem);
                    break;
                }
            }
            if(!isInNew) {
                toDel.add(elem);
            }
        }

        toAdd = tempNew;

        System.out.println();
        System.out.println("Add: " + toAdd);
        System.out.println("Update: " + toUpd);
        System.out.println("Delete: " + toDel);

    }
}

class Elem {
    private Long id;
    private String name;

    public Elem() {
    }

    public Elem(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Elem elem = (Elem) o;
        return Objects.equals(id, elem.id) && Objects.equals(name, elem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }
}
