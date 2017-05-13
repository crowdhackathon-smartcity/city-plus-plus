package dgounaris.dev.sch.People;

/**
 * Created by DimitrisLPC on 13/5/2017.
 */

public class Person {

    String name;
    String surname;
    int points;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public boolean addPoints(int extrapoints) {
        this.points += extrapoints;
        return true;
    }

    public boolean redeemPoints() {
        return true;
    }

}
