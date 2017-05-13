package dgounaris.dev.sch.People;

import android.graphics.Bitmap;

import java.io.Serializable;

import dgounaris.dev.sch.Utils.SerializableImage;

/**
 * Created by DimitrisLPC on 13/5/2017.
 */

public class Person implements Serializable {

    private int id;
    private String name;
    private String surname;
    private SerializableImage mImage = new SerializableImage();
    private int points;

    public Person(int id, String name, String surname, Bitmap profileImg) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        mImage.setImage(profileImg);
    }

    public boolean addPoints(int extrapoints) {
        this.points += extrapoints;
        return true;
    }

    public boolean redeemPoints(int pointsRequired) {
        points -= pointsRequired;
        return true;
    }

}
