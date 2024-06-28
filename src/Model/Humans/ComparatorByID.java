package Model.Humans;

import java.util.Comparator;

public class ComparatorByID<T extends TreeTop> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return (int) (o1.getInnerID() - o2.getInnerID());
    }

}
