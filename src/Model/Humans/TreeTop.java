package Model.Humans;


import java.io.Serializable;
import java.time.LocalDate;
public interface TreeTop extends Serializable,Comparable<TreeTop> {
    TreeTop getMother();
    TreeTop getFather();
    int getAge();
    void setBirthDate(LocalDate birthDate);
    void setDeathDate(LocalDate deathDate);
    Gender getGender();
    String toString();
    String getName();
    String getInfo();
    String getChildrenlnfo();
    long getInnerID();

    @Override
    int compareTo(TreeTop o);
}
