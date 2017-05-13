package dgounaris.dev.sch.People;

import android.graphics.Bitmap;

import java.io.Serializable;

import dgounaris.dev.sch.Utils.SerializableImage;

/**
 * Created by DimitrisLPC on 13/5/2017.
 */

public class Person implements Serializable {

    String name;
    String surname;
    SerializableImage mImage = new SerializableImage();
    int points;

    public Person(String name, String surname, Bitmap profileImg) {
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
