package Viev;

import Model.Humans.TreeTop;
import Presenter.Presenter;
import Model.Humans.TreeTop;

public abstract class View<T extends TreeTop> {
    public abstract void start();
    public abstract Presenter<T> getPresenter();
    public boolean hasActiveTree(){
        if (getPresenter().getActiveTree() == null){
            return false;
        }
        return true;
    }
    public void exit(){
        System.out.println("Good bye");
        System.exit(0);
    }

    public abstract void printAnswer(String answer);
}