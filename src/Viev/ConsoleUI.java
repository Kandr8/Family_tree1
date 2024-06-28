package Viev;

import Model.HumanService;
import Model.Humans.Gender;
import Model.Tree.Family_tree1;
import Presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI extends View {
    private Scanner scanner;
    private Presenter presenter = new Presenter() {
        @Override
        public HumanService getService() {
            return null;
        }

        @Override
        public HumanView getView() {
            return null;
        }

        @Override
        public String createActiveTree(String value) {
            return null;
        }

        @Override
        public String removeTree(int indrx) {
            return null;
        }

        @Override
        public String showActiveTreeInfo() {
            return null;
        }

        @Override
        public String loadTree(String path) {
            return null;
        }

        @Override
        public String saveTree(String path) {
            return null;
        }

        @Override
        public String selectTree(int index) {
            return null;
        }

        @Override
        public void setActiveTree(Family_tree1 tree) {

        }

        @Override
        public boolean newChild(String nane, Gender gender, LocalDate birthDate, int idfather, int idmother) {
            return false;
        }
    };
    private boolean work;
    private MainMenu mainMenu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        work = true;
        mainMenu = new MainMenu(this);
    }

    @Override
    public void start() {
        System.out.println("Доброго времени суток!");

        while (work) {
            System.out.println(mainMenu.menu());
            String choiceStr = scanner.nextLine();
            int choice = Integer.parseInt(choiceStr);
            mainMenu.execute(choice);
        }

    }

    @Override
    public Presenter getPresenter() {
        return null;
    }

    public void add(){
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите пол:  ");
        String gender = scanner.nextLine();
        System.out.println("Введите дату рождения: ");
        String birthDate = scanner.nextLine();

        presenter.add(name, gender, birthDate);
    }

    public void getInfo(){
        presenter.getInfo();
    }

    public void sortName(){
        presenter.sortName();
    }

    private void sortBirthDate(){
        presenter.sortBirthDate();
    }

    public void finish(){
        work = false;
        System.out.println("Всего доброго");
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }

    public void sortBirthdate() {
    }
}