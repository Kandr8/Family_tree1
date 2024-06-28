package Presenter;


import Model.HumanService;
import Model.Humans.Gender;
import Model.Humans.Human;
import Model.Tree.Family_tree1;
import Viev.HumanView;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

public class HumanPresenter extends Presenter<Human> {
    private HumanService service;
    private Family_tree1<Human> activeTree;

    private HumanView view;

    public HumanPresenter(HumanView humanView) {

    }

    @Override
    public HumanView getView() {
        return this.view;
    }


    @Override
    public HumanService getService() {
        return this.service;
    }

    public boolean setMarriage(int male, int female) {
        return service.setMarriage(activeTree.getItem(female), activeTree.getItem(male));
    }

    @Override
    public String createActiveTree(String value) {
        try {
            service.addTree(value);
            this.activeTree = service.getCurrentTree();
            return String.format("Древо %s создано", this.activeTree.toString());
        } catch (Exception e) {
            this.activeTree = null;
            System.out.println(e);
            return "Ошибка создания";
        }

    }


    @Override
    public String showActiveTreeInfo() {
        if (this.activeTree == null) {
            return "Древа не существует";
        }
        return activeTree.getInfo();
    }


    @Override
    public void setActiveTree(Family_tree1<Human> tree) {
        this.service.setCurrentTree(tree);
        this.activeTree = tree;
    }

    @Override
    public String loadTree(String path) {

        Family_tree1<Human> tree;
        Path file = Paths.get(path);
        if (Files.exists(file)) {
            try {
                tree = service.loadTree(path);
                this.activeTree = tree;
                return String.format("Древо %s загружено", tree.toString());
            } catch (Exception e) {
                System.out.println(e);
                return "Ошибка чтения";
            }
        } else {
            return "Файл не найден";
        }
    }

    @Override
    public String saveTree(String path) {
        if (service.saveTree(path)) {
            return "Сохранено";
        } else {
            return "Ошибка сохранения";
        }
    }

    //_________________________________________________________________________Спихнуть в сервис
    @Override
    public String removeTree(int index) {
        if (index < 0 || index > this.service.getTreeList().size() - 1) {
            return "Индекс вне диапазона";
        }
        Family_tree1<Human> selected = this.service.getTreeList().get(index);
        if (selected.equals(activeTree)) {
            activeTree = null;
        }
        service.removeTree(index);
        return "Удалено";
    }

    //______________________________________________________________________________________________
    @Override
    public String selectTree(int index) {
        if (index < 0 || index > this.service.getTreeList().size() - 1) {
            return "Индекс вне диапазона";
        }
        Family_tree1<Human> selected = this.service.getTreeList().get(index);
        this.activeTree = selected;
        return String.format("Выбрано древо %d", index);
    }

    public Human newHuman(String nane, Gender gender, LocalDate birthDate) {
        return service.newHuman(nane, gender, birthDate);
    }

    public boolean newChild(String nane, Gender gender, LocalDate birthDate, int idfather, int idmother) {
        return service.newChild(nane, gender, birthDate, idfather, idmother);
    }
}