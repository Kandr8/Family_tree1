package Family_tree1.Model;

import Family_tree1.Model.Humans.Gender;
import Family_tree1.Model.Humans.TreeTop;
import Family_tree1.Model.Recorder.Recorder;
import Family_tree1.Model.Tree.Family_tree1;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public abstract class Service<T extends TreeTop>  {

    public abstract List<Family_tree1<T>> getTreeList();
    public Family_tree1<T> getTree(int index){
        return getTreeList().get(index);
    };
    public abstract void setCurrentTree(int index);
    public void addTree(String name){
        Family_tree1<T> newtree = new Family_tree1<T>(name);
        setCurrentTree(newtree);
        getTreeList().add(newtree);
    };
    public Family_tree1<T> getTree(String name){
        for (Family_tree1<T> element : getTreeList()) {
            if (element.getFamily().equals(name)){
                return element;
            }
        }
        return null;
    }
    public abstract void setCurrentTree(Family_tree1<T> tree);
    public abstract Family_tree1<T> getCurrentTree();
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
        Family_tree1<T> current = getTree(index);
        try {
            current.save(path);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    public Family_tree1<T> loadTree(String path){
        Recorder recorder = new Recorder();
        Object obj = recorder.read(path);
        @SuppressWarnings("unchecked")
        Family_tree1<T> newtree = (Family_tree1<T>) obj;
        boolean boo = true;
        for (Family_tree1<T> element : getTreeList()) {
            if (newtree.getFamily().equals(element.getFamily())){
                element = newtree;
                boo = false;
            }
        }
        if(boo){
            getTreeList().add(newtree);
        }
        setCurrentTree(newtree);
        return newtree;
    }
    public boolean saveTree(String path){
        try{
            getCurrentTree().save(path);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    public String searchByPattern(String pattern){
        String str1 = pattern.toLowerCase();
        Map<Integer,T> result = new HashMap<Integer, T>();
        for (int i = 0; i < getCurrentTree().getMemberList().size(); i++){
            if (getCurrentTree().getMemberList().get(i).toString().toLowerCase().contains(str1)){
                result.put(i, getCurrentTree().getMemberList().get(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Результат поиска:\n");
        if (result.isEmpty()){
            sb.append("Ничего не найдено");
            return sb.toString();
        }
        for(Map.Entry<Integer, T> set : result.entrySet()){
            sb.append(set.getKey());
            sb.append(" ");
            sb.append(set.getValue().toString());
            sb.append("\n");
        }
        return sb.toString();
    }
    public abstract String addToTree(String name, Gender gender, LocalDate birthDate);
}