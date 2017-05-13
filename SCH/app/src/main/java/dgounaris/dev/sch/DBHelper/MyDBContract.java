package dgounaris.dev.sch.DBHelper;

import android.provider.BaseColumns;

/**
 * Created by DimitrisLPC on 13/5/2017.
 */

final public class MyDBContract {

        //make it private so that nobody can initialize this
        private MyDBContract() {}

        public static class People implements BaseColumns {
            public static final String TABLE_NAME = "People";
            public static final String COLUMN_NAME_ID = "Id";
            public static final String COLUMN_NAME_NAME = "Name";
            public static final String COLUMN_NAME_SURNAME = "Surname";
            public static final String COLUMN_NAME_IMAGE = "Image";
        }

}
