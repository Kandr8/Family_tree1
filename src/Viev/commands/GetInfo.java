package Viev.commands;

import Viev.ConsoleUI;

public class GetInfo extends Command {


    public GetInfo(ConsoleUI consoleUI) {
        super( "Получить текущую информацию о древе", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().getInfo();
    }

}