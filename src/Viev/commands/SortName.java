package Viev.commands;

import Viev.ConsoleUI;

public class SortName extends Command {


    public SortName(ConsoleUI consoleUI) {
        super( "Отсортировать по имени", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().sortName();
    }

}