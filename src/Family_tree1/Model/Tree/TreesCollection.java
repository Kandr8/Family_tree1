package Family_tree1.Model.Tree;

import Family_tree1.Model.Humans.TreeTop;

import java.util.ArrayList;
import java.util.List;

public class TreesCollection<T extends TreeTop> {

    private List<Family_tree1<T>> list;
    private Family_tree1<T> activeTree;

    public TreesCollection(){
        list = new ArrayList<>();
    }

    public boolean newTree(String family){
        try{
            Family_tree1<T> tree = new Family_tree1<>(family);
            this.activeTree = tree;
            list.add(tree);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public List<Family_tree1<T>> getList(){
        return this.list;
    }

    public int size(){
        return list.size();
    }

    public boolean setActiveTree(int index){
        try {
            this.activeTree = this.list.get(index);
            return true;
        } catch(Exception e) {
            System.out.println(e);
            return false;
        }
    }

    private Family_tree1<T> treeByInnerID(long ID){
        for (Family_tree1<T> tree : this.list) {
            if (tree.getInnerID() == ID) {
                return tree;
            }
        }
        return null;
    }

    public boolean setActiveTree(long ID){
        try {
            Family_tree1<T> tree = treeByInnerID(ID);
            this.activeTree = tree;
            return true;
        } catch(Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public Family_tree1<T> getActiveTree(){
        return this.activeTree;
    }

    public int getIndex(Family_tree1<T> value){
        try{
            for (int i = 0; i < this.list.size(); i++){
                if (value.equals(this.list.get(i))){
                    return i;
                }
            }
            return -1;
        } catch (Exception e) {
            System.out.println(e);
            return -1;
        }
    }

    public int getActiveTreeIndex(){
        if (this.activeTree == null){
            return -1;
        }
        return getIndex(activeTree);
    }

    public long getActiveTreeID(){
        try{
            return this.activeTree.getInnerID();
        } catch (Exception e) {
            System.out.println(e);
            return -1;
        }
    }

    public Family_tree1<T> selectTree(int index){
        return this.list.get(index);
    }

    public Family_tree1<T> selectTree(long ID){
        return treeByInnerID(ID);
    }

    public boolean setActiveTree(Family_tree1<T> item){
        try{
            if (!this.list.contains(item)){
                this.list.add(item);
            }
            this.activeTree = item;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }


}
