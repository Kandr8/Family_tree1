package Family_tree1.View;

import java.util.Scanner;

import java.util.*;




public class HumanView extends View {

    //private ActionLevel level;
    private HumanManager manager;
    private Scanner scanner;

    public HumanView(){
        //this.level = ActionLevel.NoLevel;
        this.scanner = new Scanner(System.in);
        this.manager = new HumanManager( scanner, this);
    }

    public HumanManager getManager() {
        return this.manager;
    }

    public void setActionLevel (ActionLevel value){
        this.manager.setLevel(value);
    }

    public ActionLevel getActionLevel(){
        return this.manager.getLevel();
    }

    //________________________________________________________________________________________________

    private void intro() {
        System.out.println("На старте доступны команды:");
        System.out.println(manager.getInDependentList());
        System.out.println("После создания или выбора древа добавятся:");
        System.out.println(manager.getTreeDependentList());
        System.out.println("После создания или выбора человека добавятся:");
        System.out.println(manager.getelementDependentList());
        System.out.println("_________________________________________________________________________________");
    }

    public void start(){
        intro();
        selectAction();

    }

    public void selectAction(){
        if (getActionLevel() == ActionLevel.NoLevel){
            noLevelDo();
        } else if (getActionLevel() == ActionLevel.TreeLevel) {
            treeLevelDo();
        } else {
            humanLevelDo();
        }
    }

    private void noLevelDo() {
        System.out.println("Выбор действия:");
        System.out.println(manager.getInDependentList());
        getCommand();
    }

    private void treeLevelDo() {
        System.out.println("Выбор действия:");
        System.out.println(manager.getInDependentList());
        System.out.println(manager.getTreeDependentList());
        getCommand();
    }

    private void humanLevelDo() {
        System.out.println("Выбор действия:");
        System.out.println(manager.getInDependentList());
        System.out.println(manager.getTreeDependentList());
        System.out.println(manager.getelementDependentList());
        getCommand();
    }

    private void getCommand(){
        String commString = scanner.nextLine();
        Map<String, String> map;
        if (getActionLevel() == ActionLevel.NoLevel){
            map = manager.getIndependentActions();
        } else if (getActionLevel() == ActionLevel.TreeLevel) {
            map = manager.getIndependentActions();
            map.putAll(manager.getTreedependentActions());
        } else {
            map = manager.getIndependentActions();
            map.putAll(manager.getTreedependentActions());
            map.putAll(manager.getSubjectdependentActions());
        }
        try {
            manager.fireFunction(commString, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}