package dgounaris.dev.sch.DBHelper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import dgounaris.dev.sch.People.Person;

/**
 * Created by DimitrisLPC on 13/5/2017.
 */

public class MyDBHelper extends SQLiteOpenHelper {

    private Context mContext;

    private static final String DATABASE_NAME = "schdb.db";
    private static String DATABASE_PATH = "";
    private static final int DATABASE_VERSION = 1;

    public SQLiteDatabase myDatabase;

    public MyDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.mContext = context;
        DATABASE_PATH = mContext.getApplicationInfo().dataDir + "/databases/";
        boolean dbexist = checkDatabase();
        if (dbexist) {
            openDatabase();
        } else {
            createDatabase();
        }
    }

    private void createDatabase() {
        boolean dbexist = checkDatabase();
        if (dbexist) {
        } else {
            this.getReadableDatabase();
            try {
                copyDatabase();
            } catch (IOException e) {
                throw new Error("Error copying database");
            }
        }
    }

    private boolean checkDatabase() {
        boolean checkdb = false;
        try {
            String myPath = DATABASE_PATH + DATABASE_NAME;
            File dbFile = new File(myPath);
            checkdb = dbFile.exists();
        } catch (SQLiteException e) {
            System.out.println("Database doesn't exist");
        }
        return checkdb;
    }

    private void copyDatabase() throws IOException {
        InputStream myinput = mContext.getAssets().open(DATABASE_NAME);
        String outfilename = DATABASE_PATH + DATABASE_NAME;
        OutputStream myoutput = new FileOutputStream(outfilename);

        byte[] buffer = new byte[1024];
        int length;
        while ((length = myinput.read(buffer)) > 0) {
            myoutput.write(buffer, 0, length);
        }

        myoutput.flush();
        myoutput.close();
        myinput.close();
    }

    private void openDatabase() {
        String mypath = DATABASE_PATH + DATABASE_NAME;
        myDatabase = SQLiteDatabase.openDatabase(mypath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public synchronized void close() {
        if (myDatabase != null) {
            myDatabase.close();
        }
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Person getPerson(int id) {

        Person mPerson = null;
        String myQuery = "select * from " + MyDBContract.People.TABLE_NAME + " p where p." + MyDBContract.People.COLUMN_NAME_ID + " = " + id;
        this.openDatabase();
        Cursor cursor = this.myDatabase.rawQuery(myQuery, null);
        if (cursor.moveToFirst()) {
            byte[] myImgByte = cursor.getBlob(cursor.getColumnIndex(MyDBContract.People.COLUMN_NAME_IMAGE)); //image
            if (myImgByte != null) {
                mPerson = new Person(
                        cursor.getInt(cursor.getColumnIndex(MyDBContract.People.COLUMN_NAME_ID)), //id
                        cursor.getString(cursor.getColumnIndex(MyDBContract.People.COLUMN_NAME_NAME)), //name
                        cursor.getString(cursor.getColumnIndex(MyDBContract.People.COLUMN_NAME_NAME)), //surname
                        BitmapFactory.decodeByteArray(myImgByte, 0, myImgByte.length)
                );
            }
        }
        cursor.close();
        this.close();
        return mPerson;
    }

}
