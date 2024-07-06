package Family_tree1.Model;

import Family_tree1.Model.Humans.TreeTop;
import Family_tree1.Model.Tree.Family_tree1;

public interface TreeManagment<T extends TreeTop> {
    boolean newTree(String family);
    boolean addTree(Family_tree1<T> tree);
    boolean setActiveTree(int ID);
    boolean setActiveTree(long innerID);
    boolean setActiveTree(Family_tree1<T> tree);
    boolean deleteTree(int ID);
    boolean deleteTree(long innerID);
    boolean deleteTree(Family_tree1<T> tree);
    boolean loadTree(String path);
    boolean saveTree(String path);
    int getActiveTreeIndex();
    long getActiveTreeInnerID();
    boolean haveActiveTree();
    boolean join(Family_tree1<T> tree1, Family_tree1<T> tree2);

    String getInfo();
    String searchByPattern(String pattern);
    String showList();
}