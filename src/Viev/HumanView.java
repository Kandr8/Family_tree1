package Viev;

import Model.Humans.Gender;
import Model.Humans.Human;
import Presenter.HumanPresenter;
import Presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class HumanView extends View<Human> {
    private HumanPresenter presenter;
    static String optionString = """
            Выбор действия:
            \t 1. Создать дерево;
            \t 2. Загрузить дерево;
            \t 3. Сохранить дерево;
            \t 4. Выбрать дерево;
            \t 5. удалить дерево;
            \t 6. Добавить родственика;
            \t 7. Удалить родственика;
            \t 8. Зарегистрировать ребёнка;
            \t 9. Найти родственика;
           
            """;
    private Scanner scanner ;
    public HumanView(){
        presenter = new HumanPresenter(this);
        scanner = new Scanner(System.in)  ;
    }



    @Override
    public void start() {
        System.out.println(optionString);
        boolean flag = true;
        while (flag) {
            String action = scanner.nextLine();
            switch (action) {
                case "1":
                    System.out.println("Укажите фамилию");
                    String family = scanner.nextLine();
                    String result = presenter.createActiveTree(family);
                    System.out.println(result);
                    break;
                case "2":
                    System.out.println("Укажите путь");
                    String filePath = scanner.nextLine();
                    System.out.println(presenter.loadTree(filePath));
                    break;
                case "3":
                    if (this.hasActiveTree() == false){
                        System.out.println("Невыбрано активное древо");
                        break;
                    }
                    System.out.println("Укажите путь");
                    String savePath = scanner.nextLine();
                    System.out.println(presenter.saveTree(savePath));
                    break;
                case "4":
                    System.out.println("Выбор древа");
                    if (presenter.getTreeList().isEmpty()){
                        System.out.println("Список пуст");
                        break;
                    }
                    System.out.println("Укажите номер");
                    System.out.println(presenter.showListTree());
                    int selected = Integer.parseInt(scanner.nextLine());
                    System.out.println(presenter.selectTree(selected));
                    break;
                case "5":
                    System.out.println("Укажите номер");
                    System.out.println(presenter.showListTree());
                    int deleted = Integer.parseInt(scanner.nextLine());
                    System.out.println(presenter.removeTree(deleted));
                    break;

                case "6":
                    if (this.hasActiveTree() == false){
                        System.out.println("Невыбрано активное древо");
                        break;
                    }
                    System.out.println("ФИО");
                    String FIO = scanner.nextLine();
                    System.out.println("пол (м/ж)");
                    Gender gender = sexFromString(scanner.nextLine());
                    System.out.println("Дата рождения (гггг-ММ-ДД)");
                    LocalDate day = LocalDate.parse(scanner.nextLine());

                    System.out.println(presenter.addToTree(FIO, gender, day));

                    break;
                case "7":
                    System.out.println("Укажите индекс");
                    System.out.println(presenter.getActiveTree().getInfo());
                    int index = Integer.parseInt(scanner.nextLine());
                    System.out.println(presenter.removeMember(index));
                    break;
                case "8":
                    System.out.println("Укажите id жениха");
                    int id1 = Integer.parseInt(scanner.nextLine());
                    System.out.println("Укажите id невесты");
                    int id2 = Integer.parseInt(scanner.nextLine());
                    if (presenter.setMarriage(id1, id2)){
                        System.out.println("Зарегистрировано");
                    }else{
                        System.out.println("Ошибка регистрации");
                    }
                    break;
                case "9":
                    System.out.println("ФИО");
                    FIO = scanner.nextLine();
                    System.out.println("пол (м/ж)");
                    gender = sexFromString(scanner.nextLine());
                    System.out.println("Дата рождения (гггг-ММ-ДД)");
                    day = LocalDate.parse(scanner.nextLine());
                    System.out.println("Укажите id отца");
                    id1 = Integer.parseInt(scanner.nextLine());
                    System.out.println("Укажите id матери");
                    id2 = Integer.parseInt(scanner.nextLine());
                    if (presenter.newChild(FIO, gender, day, id1, id2)){
                        System.out.println("Ребёнок добавлен");
                    } else {
                        System.out.println("Ошибка регистрации");
                    }
                    break;
                case "s":
                    System.out.println("Шаблон для поиска");
                    String pattern = "*" + scanner.nextLine().toLowerCase() + "*";
                    System.out.println(presenter.searchByPattern(pattern));
                    break;
                case "i":
                    System.out.println("Укажите индекс");
                    index = Integer.parseInt(scanner.nextLine());
                    System.out.println(presenter.getMember(index).getInfo());
                    break;
                case "v":
                    System.out.println(presenter.getActiveTree().getInfo());
                    break;
                case "q":
                    flag = false;
                    break;
                case "h":
                    System.out.println(optionString);
                    break;
                case "l":
                    System.out.println(presenter.showListTree());
                    break;
                default:
                    break;
            }
        }
    }

    private Gender sexFromString(String value){
        if (value.equalsIgnoreCase("м")){
            return Gender.Male;
        } else if (value.equalsIgnoreCase("ж")){
            return Gender.Female;
        } else {
            return null;
        }
    }


    @Override
    public Presenter<Human> getPresenter() {
        return this.presenter;
    }

    @Override
    public void printAnswer(String answer) {

    }


}