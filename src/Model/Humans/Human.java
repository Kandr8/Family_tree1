package Model.Humans;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;



public class Human implements TreeTop {
    private long innerID;
    private String  name;
    private Human mother, father;
    private List<Human> children;
    private LocalDate birthDate, deathDate;
    private Gender gender;
    private Human spouse;


    public Human (String name, Gender gender, LocalDate birthDate, Human father, Human mother){
        this(name, gender, birthDate);
        this.mother = mother;
        this.father = father;
    }

    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Human father, Human mother) {
        this(name, gender, birthDate,  father, mother);
        this.deathDate = deathDate;
    }

    public Human(String name, Gender gender, LocalDate birthDate) {
        long nameValue;
        Instant instant = Instant.now();
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        nameValue = 0;
        char[] chars = name.toCharArray();
        for (char iterable_element : chars) {
            nameValue = nameValue + (long) iterable_element;
        }
        this.innerID = instant.toEpochMilli() + nameValue;
        this.children = new ArrayList<>() ;
    }
    public Human getMother(){
        return this.mother;
    }
    public void setMother(Human value){
        if (value.gender == Gender.Female){
            this.mother = value;
        }
    }
    public Human getFather(){
        return this.father;
    }
    public void setFather(Human value){
        if (value.gender == Gender.Male){
            this.father = value;
        }
    }

    public int getAge(){
        if (birthDate == null){
            return -1;
        }
        if (deathDate == null){
            return getPeriod(birthDate, LocalDate.now());
        } else {
            return getPeriod(birthDate, deathDate);
        }
    }
    private int getPeriod(LocalDate birthDate, LocalDate deathDate){
        Period diff = Period.between(birthDate, deathDate);
        return diff.getYears();
    }
    public boolean setSpouse(Human spouse) {
        if (this.gender == spouse.gender){
            this.spouse = null;
            return false;
        } else {
            this.spouse = spouse;
            return true;
        }

    }

    public Human getSpouse(){ return this.spouse; }

    public List<Human> getChildren() { return children; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }
    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }
    public Gender getGender(){ return gender; }

    @Override
    public String toString(){
        return name ;
    }
    public String getName(){return this.name;}

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("имя: ");
        sb.append(name);
        sb.append(", non: ");
        sb.append(getGender());
        sb.append(", возраст: ");
        sb.append(getAge());
        sb.append("\n");
        sb.append(getSpouselnfo());
        sb.append(", ");
        sb.append(getMotherlnfo());
        sb.append(", ");
        sb.append(getFatherlnfo());
        sb.append(", ");
        sb. append(getChildrenlnfo());
        return sb.toString();
    }

    public String getSpouselnfo(){
        String res = "cynpyr(a): ";
        if (spouse == null){
            res += "нет";
        } else {
            res += spouse.getName();
        }
        return res;
    }
    public String getMotherlnfo(){
        String res = "мать: ";
        Human human = getMother();
        if (human != null){
            res += human.getName() ;
        } else {
            res += "неизвестна";
        }
        return res;
    }
    public String getFatherlnfo(){
        String res = "отец: ";
        Human human = getFather();
        if (human != null){
            res += human.getName() ;
        } else {
            res += "неизвестен";
        }
        return res;
    }

    public String getChildrenlnfo(){
        StringBuilder sb = new StringBuilder();
        for (Human human : children) {
            sb.append(human);
            if (human.getMother() != null){
                sb.append(", мать: ");
                sb.append(human.getMother().getName());
            }
            if (human.getFather() != null){
                sb.append(", отец: ");
                sb.append(human.getFather().getName());
            }
            sb.append("\n");
        }
        return sb.toString();
    }




    public long getInnerID(){return this.innerID;}
    public void setInnerID(long id){this.innerID = id;}

    public boolean addChild(Human child) {
        for (Human human : children) {
            if(human.innerID == child.innerID){
                return false;
            }
        }
        children.add(child);
        return true;
    }


    @Override
    public int compareTo(TreeTop o) {
        return Long.compare(this.innerID, o.getInnerID());

    }



}
