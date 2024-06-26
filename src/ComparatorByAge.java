public class ComparatorByAge<T extends TreeTop> implements Comparator<T>{

    @Override
    public int compare(T o1, T o2) {
        return o1.getAge() - o2.getAge();
    }

}
