package Presenter;

import Model.HumanService;
import Model.Humans.Gender;
import Model.Humans.Human;
import Model.Humans.TreeTop;
import Model.Tree.Family_tree1;
import Viev.HumanView;

import java.time.LocalDate;
import java.util.List;

public abstract class Presenter<T extends TreeTop> {
    public abstract HumanService getService();
    public abstract HumanView getView();
    public List<Family_tree1<Human>> getTreeList(){
        return getService().getTreeList();
    }
    public Family_tree1<T> getActiveTree(){
        return (Family_tree1<T>) getService().getCurrentTree();
    }
    public T getMember(int index){
        return getActiveTree().getItem(index); //надо менять на String
    }
    public T getMember(int tree, int index){
        return (T) getTreeList().get(tree).getItem(index); //надо менять на String
    }
    public String removeMember(int index){
        String s = "";
        try{
            getActiveTree().remove(index);
            s ="Родич удалён";
        } catch (Exception e) {
            System.out.println(e);
            s = "Ошибка удаления";
        }
        return s;
    }
    public abstract String createActiveTree(String value);
    public abstract String removeTree(int indrx);
    public abstract String showActiveTreeInfo();



    public abstract String loadTree(String path);
    public abstract String saveTree(String path);
    //_________________________________________________________________________________________
    public String showListTree(){ // Это надо перевести в Service
        if (getTreeList().size() == 0){
            return "Древо пусто";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getTreeList().size(); i++){
            sb.append(i);
            sb.append(". ");
            sb.append(getTreeList().get(i).toString());
            sb.append("\n");
        }
        return sb.toString();
    }
    //__________________________________________________________________________________________
    public abstract String selectTree(int index);
    public abstract void setActiveTree(Family_tree1<T> tree);
    public boolean hasActiveTree(){
        if (getActiveTree() == null){
            return false;
        }else{
            return true;
        }
    }
    public abstract boolean newChild(String nane, Gender gender, LocalDate birthDate, int idfather, int idmother);
    public String searchByPattern(String pattern){
        return getService().searchByPattern(pattern);
    }
    public String addToTree(String name, Gender gender, LocalDate birthDate){
        return getService().addToTree(name, gender, birthDate);
    }


    public void add(String name, String gender, String birthDate) {
    }

    public void getInfo() {

    }

    public void sortName() {
    }

    public void sortBirthDate() {
    }
}