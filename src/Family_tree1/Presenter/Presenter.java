package Family_tree1.Presenter;


import Family_tree1.Model.HumanService;
import Family_tree1.Model.Humans.Gender;
import Family_tree1.Model.Humans.Human;
import Family_tree1.Model.Tree.Family_tree1;
import Family_tree1.View.HumanView;

import java.time.LocalDate;

public abstract class Presenter {

    //_________________________________________________________________________Спихнуть в сервис
    public abstract String removeTree(int index);

    public abstract String selectTree(int index);
    public abstract String setDeathDate(String text);
    public abstract String saveTree(String text);
    public abstract String addToTree(String name, Gender gender, LocalDate birhday);
    public abstract String newChild(String name, String gender, String birhday, int IDFather, int IDMother);
    public abstract String searchByPattern(String text);

    public abstract HumanView getView();

    public abstract HumanService getService();

    public abstract String createActiveTree(String text);

    public abstract String showActiveTreeInfo();

    public abstract void setActiveTree(Family_tree1<Human> tree);

    public abstract String loadTree(String text);
    public abstract String showActiveSubjectInfo();
    public abstract String removeMember();
    public abstract String removeTree();
    public abstract String showSubjectList();
    public abstract String getTreeList();


    public abstract String addToTree(String name, String s, String s1);
}