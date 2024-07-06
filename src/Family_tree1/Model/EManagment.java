package Family_tree1.Model;



import Family_tree1.Model.Humans.TreeTop;
import Family_tree1.Model.Tree.Family_tree1;

public interface EManagment<T extends TreeTop> {
    boolean ActiveTreeIsEmpty();
    boolean addToTree(String name, String gender, String bd);
    boolean addToTree(T subject); //для ActiveTree
    boolean addToTree(T subject, Family_tree1<T> tree);
    boolean setActiveSubject(int id);
    boolean setActiveSubject(long innerID);
    boolean setActiveSubject(T subject);
    String searchSubject(String pattern); //для ActiveTree
    String searchSubject(String pattern, Family_tree1<T> tree);
    String searchSubject(String pattern, long treeInnerID);
    String searchSubject(String pattern, int treeIndex);
    boolean setChild(T subject, T father, T mother); //для ActiveTree
    //boolean setChild(int subject, int father, int mother, Family_tree<T> tree); зарезервировано
    //boolean setChild(long subject, long father, long mother); зарезервировано
    int getActiveSubjectIndex();
    long getActiveSubjectInnerID();
    String getItemInfo(); //для ActiveSubject
    boolean setDeathDate(String date);
    String getDeathDate();
    boolean removeSubject(); //для ActiveSubject
}