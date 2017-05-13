package dgounaris.dev.sch.adapter;

/**
 * Created by antonis on 13-May-17.
 */

public class Trophy {
    private String title;

    private int image_id;

    public Trophy(String t, int img_id) {
        title = t;
        image_id = img_id;
    }

    public String getTitle() {
        return title;
    }

    public int getImageId() {
        return image_id;
    }
}
