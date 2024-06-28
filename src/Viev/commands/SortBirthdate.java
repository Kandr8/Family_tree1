package Viev.commands;

public class SortBirthdate extends Command {


    public <ConsoleUI> SortBirthdate(ConsoleUI consoleUI) {
        super( "Отсортировать по дате рождения", (Viev.ConsoleUI) consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().sortBirthdate();
    }

}