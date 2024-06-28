package Viev.commands;

import Viev.ConsoleUI;

public class AddHuman extends Command {


    public AddHuman(ConsoleUI consoleUI) {
        super( "Добавить человека", consoleUI);
    }



    @Override
    public void execute(){
        getConsoleUI().add();
    }

}