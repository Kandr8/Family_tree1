import java.time.LocalDate;
import java.util.*;
import Family_tree.Model.Tree.*;
import Family_tree.Model.Humans.Endothermal;
import Family_tree.Model.Humans.Gender;
import Family_tree.Model.Recorder.Recorder;


public abstract class Service<T extends Endothermal>  {

    public abstract List<Family_tree<T>> getTreeList();
    public Family_tree<T> getTree(int index){
        return getTreeList().get(index);
    };
    public abstract void setCurrentTree(int index);
    public void addTree(String name){
        Family_tree<T> newtree = new Family_tree<T>(name);
        setCurrentTree(newtree);
        getTreeList().add(newtree);
    };
    public Family_tree<T> getTree(String name){
        for (Family_tree<T> element : getTreeList()) {
        if (element.getFamily().equals(name)){
            return element;
        }
    }
        return null;
    }
    public abstract void setCurrentTree(Family_tree<T> tree);
    public abstract Family_tree<T> getCurrentTree();
    public boolean removeTree(int index){
        try{
            getTreeList().remove(index);
            return true;
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
    };
    public abstract boolean newChild(T child, T father, T mother);
    public boolean saveTree(String path, int index){
        Family_tree<T> current = getTree(index);
        try{
            current.save(path);