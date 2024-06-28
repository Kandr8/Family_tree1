package Model.Tree;

import Model.Humans.ComparatorByAge;
import Model.Humans.ComparatorByID;
import Model.Humans.ComparatorByName;
import Model.Humans.TreeTop;
import Model.Recorder.Recorder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Family_tree1<T extends TreeTop> implements  Iterable<T>, Serializable{
    private List<T> list;
    private String family;


    public Family_tree1(String family){
        list = new ArrayList<>();
        this.family = family;
    }

    public Family_tree1() {

    }

    public String getFamily(){ return this.family; }

    @Override
    public String toString(){
        return this.family;
    }

    public void add(T value){
        if (value != null && !this.list.contains(value)){
            list.add(value);
        }
    }

    public List<T> searchByName(String name){
        List<T> result = new ArrayList<>();
        for (T element : list) {
            if (element.getName().equalsIgnoreCase(name)){
                result.add(element);
            }
        }
        return result;
    }

    public List<T> searchByPattern(String pattern){
        String str1 = pattern.toLowerCase();
        List<T> result = new ArrayList<>();
        for (T element : this.list) {
            if (element.toString().toLowerCase().contains(str1)){
                result.add(element);
            }
        }
        return result;
    }
    public T getItem(int id){
        return this.list.get(id);
    }
    public T getItemByInnerID(long id){
        for (T t : list) {
            if(t.getInnerID() == id){
                return t;
            }
        }
        return null;
    }

    public void remove(T value){
        list.remove(value);
    }
    public void remove(int id){
        list.remove(id);
    }
    public void remove(long innerId){
        T aim = getItemByInnerID(innerId);
        list.remove(aim);
    }

    public List<T> getMemberList(){
        return this.list;
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("B дереве объектов: ");
        sb.append(list.size());
        sb.append("\n");
        for (int i = 0; i < list.size(); i++){
            sb.append(i);
            sb.append(" ");
            sb.append(list.get(i));
            sb.append("\n");
        }
        return sb.toString();
    }


    public long getCount(){
        return list.size();
    }
    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    public void sortByName(){
        this.list.sort(new ComparatorByName<T>());

    }
    public void sortByAge(){
        this.list.sort(new ComparatorByAge<T>());
    }
    public void sortByInnerId(){
        this.list.sort(new ComparatorByID<T>());
    }

    public void save(String path){
        Recorder recorder = new Recorder();
        System.out.println(recorder.save(this, path));
    }





}