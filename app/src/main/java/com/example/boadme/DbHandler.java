package com.example.boadme;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DbHandler extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DB_NAME = "hostal.db";
    private static final String TABLE_NAME = "hostal_db";


    private static final String ID = "id";
    private static final String OWNER_NAME = "owner_name";
    private static final String HOSTAL_LOCATION = "hostal_location";
    private static final String PHONE_NUM = "phone_num";
    private static final String EMAIL = "email";
    private static final String ADDRESS = "address";
    private static final String NUM_OF_RM = "num_of_rm";
    private static final String PRICE = "price";
    private static final String STARTED = "started";
    private static final String FINISHED = "finished";

    ///////////////////////////////FEEDBACK///////////////////////////////////
    private static final String TABLE_NAME_fd = "feedback_db";

    private static final String ID_FEEDBACK = "id";
    private static final String CUSTOMER_NAME = "customer_name";
    private static final String CUSTOMER_EMAIL = "customer_email";
    private static final String CUSTOMER_COMMENT = "customer_comment";
    private static final String STARTED_FEEDBACK = "started";
    private static final String FINISHED_FEEDBACK = "finished";



    ///////////////////////////////BOARDING////////////////////////////////////////
    private static final String table_name = "boarding";

    private static final String id = "id";
    private static final String ownerName = "ownerName";
    private static final String phone = "phone";
    private static final String email = "email";
    private static final String location = "location";
    private static final String address = "address";
    private static final String details = "details2";
    private static final String price = "price";


    public DbHandler(@Nullable Context context) {
        super (context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String TABLE_CREATE_QUERY = "CREATE TABLE " + TABLE_NAME + " " +
                "("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + OWNER_NAME + " TEXT,"
                + HOSTAL_LOCATION + " TEXT,"
                + PHONE_NUM + " TEXT,"
                + EMAIL + " TEXT,"
                + ADDRESS + " TEXT,"
                + NUM_OF_RM + " INT,"
                + PRICE + " INT,"
                + STARTED + " TEXT,"
                + FINISHED + " TEXT" +
                ");";

        sqLiteDatabase.execSQL (TABLE_CREATE_QUERY);

        String CREATE_TABLE_BOARDING = "CREATE TABLE " + table_name + "" +
                "("
                + id + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ownerName + " TEXT,"
                + phone + " INTEGER,"
                + price + " INTEGER, "
                + location + " TEXT,"
                + details + " TEXT,"
                + address + " TEXT,"
                + email + " TEXT" +
                ");";

        sqLiteDatabase.execSQL (CREATE_TABLE_BOARDING);


        ////////////////////////////FEEDBACK////////////////////////////////////
        String TABLE_CREATE_FEEDBACK = "CREATE TABLE " + TABLE_NAME_fd + " " +
                "("
                + ID_FEEDBACK + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + CUSTOMER_NAME + " TEXT,"
                + CUSTOMER_EMAIL + " TEXT,"
                + CUSTOMER_COMMENT + " TEXT,"
                + STARTED_FEEDBACK + " TEXT,"
                + FINISHED_FEEDBACK + " TEXT" +
                ");";

        sqLiteDatabase.execSQL (TABLE_CREATE_FEEDBACK);



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS " + TABLE_NAME;

        sqLiteDatabase.execSQL (DROP_TABLE_QUERY);

        String DROP_TABLE_BOARDING = "DROP TABLE IF EXISTS " + table_name;

        sqLiteDatabase.execSQL (DROP_TABLE_BOARDING);

        onCreate (sqLiteDatabase);
        /////////////////////////////FEEDBACK///////////////////////////////
        String DROP_TABLE_FEEDBACK = "DROP TABLE IF EXISTS " + TABLE_NAME_fd;

        sqLiteDatabase.execSQL (DROP_TABLE_FEEDBACK);
        onCreate (sqLiteDatabase);


    }

    public void add_Hostal(Hostal hostal) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase ();

        ContentValues contentValues = new ContentValues ();

        contentValues.put (OWNER_NAME, hostal.getOwner_name ());
        contentValues.put (HOSTAL_LOCATION, hostal.getHostal_location ());
        contentValues.put (PHONE_NUM, hostal.getPhone_num ());
        contentValues.put (EMAIL, hostal.getEmail ());
        contentValues.put (ADDRESS, hostal.getAddress ());
        contentValues.put (NUM_OF_RM, hostal.getNum_of_rm ());
        contentValues.put (PRICE, hostal.getPrice ());
        contentValues.put (STARTED, hostal.getStarted ());
        contentValues.put (FINISHED, hostal.getFinished ());

        sqLiteDatabase.insert (TABLE_NAME, null, contentValues);
        sqLiteDatabase.close ();

    }

    public int countHostal() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase ();
        String query = "SELECT * FROM " + TABLE_NAME;

        Cursor cursor = sqLiteDatabase.rawQuery (query, null);
        return cursor.getCount ();
    }

    public List<Hostal> getAllHostal() {

        List<Hostal> hostals = new ArrayList<> ();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase ();
        String query = "SELECT * FROM " + TABLE_NAME;

        Cursor cursor = sqLiteDatabase.rawQuery (query, null);

        if (cursor.moveToFirst ()) {
            do {

                Hostal hostal = new Hostal ();

                hostal.setId (cursor.getInt (0));
                hostal.setOwner_name (cursor.getString (1));
                hostal.setHostal_location (cursor.getString (2));
                hostal.setPhone_num (cursor.getString (3));
                hostal.setEmail (cursor.getString (4));
                hostal.setAddress (cursor.getString (5));
                hostal.setNum_of_rm (cursor.getString (6));
                hostal.setPrice (cursor.getString (7));
                hostal.setStarted (cursor.getLong (8));
                hostal.setFinished (cursor.getLong (9));

                hostals.add (hostal);

            } while (cursor.moveToNext ());
        }
        return hostals;
    }

    public void deleteHostal(int id) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase ();

        sqLiteDatabase.delete (TABLE_NAME, "id =?", new String[]{String.valueOf (id)});
        sqLiteDatabase.close ();
    }


    ///////////////////////////////////////////////////////////////////////////////////
    //////////////////Boarding//////////////////

    public void getDetailsBoarding(Boarding boarding) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase ();

        ContentValues contentValues = new ContentValues ();

        contentValues.put (ownerName, boarding.getOwnerName ());
        contentValues.put (phone, boarding.getPhone ());
        contentValues.put (price, boarding.getPrice ());
        contentValues.put (location, boarding.getLocation ());
        contentValues.put (address, boarding.getAddress ());
        contentValues.put (email, boarding.getEmail ());
        contentValues.put (details, boarding.getDetails2 ());

        //save to table
        sqLiteDatabase.insert (table_name, null, contentValues);
        sqLiteDatabase.close ();
    }


    public Hostal getSingaleHostal(int id) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase ();

        Cursor cursor = sqLiteDatabase.query (TABLE_NAME, new String[]{ID, OWNER_NAME, HOSTAL_LOCATION, PHONE_NUM,
                        EMAIL, ADDRESS, NUM_OF_RM, PRICE, STARTED, FINISHED},
                ID + "= ?", new String[]{String.valueOf (id)}, null, null, null);

        Hostal hostal;

        if (cursor != null) {
            cursor.moveToFirst ();
            hostal = new Hostal (
                    cursor.getInt (0),
                    cursor.getString (1),
                    cursor.getString (2),
                    cursor.getString (3),
                    cursor.getString (4),
                    cursor.getString (5),
                    cursor.getString (6),
                    cursor.getString (7),
                    cursor.getLong (8),
                    cursor.getLong (9)
            );
            return hostal;

        }
        return null;

    }

    public int updateHostal(Hostal hostal) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase ();

        ContentValues contentValues = new ContentValues ();

        contentValues.put (OWNER_NAME, hostal.getOwner_name ());
        contentValues.put (HOSTAL_LOCATION, hostal.getHostal_location ());
        contentValues.put (PHONE_NUM, hostal.getPhone_num ());
        contentValues.put (EMAIL, hostal.getEmail ());
        contentValues.put (ADDRESS, hostal.getAddress ());
        contentValues.put (NUM_OF_RM, hostal.getNum_of_rm ());
        contentValues.put (PRICE, hostal.getPrice ());
        contentValues.put (STARTED, hostal.getStarted ());
        contentValues.put (FINISHED, hostal.getFinished ());

        int status = sqLiteDatabase.update (TABLE_NAME, contentValues,
                ID + " =?",
                new String[]{String.valueOf (hostal.getId ())});

        sqLiteDatabase.close ();

        return status;
    }


    //FEEDBACK

    public void add_Feedback(Feedback feedback) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase ();

        ContentValues contentValues = new ContentValues ();

        contentValues.put (CUSTOMER_NAME, feedback.getCustomer_name ());
        contentValues.put (CUSTOMER_EMAIL, feedback.getCustomer_email ());
        contentValues.put (CUSTOMER_COMMENT, feedback.getCustomer_comment ());
        contentValues.put (STARTED_FEEDBACK, feedback.getStarted ());
        contentValues.put (FINISHED_FEEDBACK, feedback.getFinished ());

        sqLiteDatabase.insert (TABLE_NAME_fd, null, contentValues);
        sqLiteDatabase.close ();

    }

    //FEEDBACK
    public int countFeedback() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase ();
        String query = "SELECT * FROM " + TABLE_NAME_fd;

        Cursor cursor = sqLiteDatabase.rawQuery (query, null);
        return cursor.getCount ();
    }

    //FEEDBACK
    public List<Feedback> getAllFeedback() {

        List<Feedback> feedbacks = new ArrayList<> ();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase ();
        String query = "SELECT * FROM " + TABLE_NAME_fd;

        Cursor cursor = sqLiteDatabase.rawQuery (query, null);

        if (cursor.moveToFirst ()) {
            do {

                Feedback feedback = new Feedback ();

                feedback.setId (cursor.getInt (0));
                feedback.setCustomer_name (cursor.getString (1));
                feedback.setCustomer_email (cursor.getString (2));
                feedback.setCustomer_comment (cursor.getString (3));
                feedback.setStarted (cursor.getLong (4));
                feedback.setFinished (cursor.getLong (5));

                feedbacks.add (feedback);

            } while (cursor.moveToNext ());
        }
        return feedbacks;
    }

    //FEEDBACK
    public void deleteFeedback(int id) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase ();
        sqLiteDatabase.delete (TABLE_NAME_fd, "id =?", new String[]{String.valueOf (id)});
        sqLiteDatabase.close ();
    }

    //FEEDBACK
    public Feedback getfeedbacklayout(int id) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase ();

        Cursor cursor = sqLiteDatabase.query (TABLE_NAME_fd, new String[]{ID_FEEDBACK, CUSTOMER_NAME, CUSTOMER_EMAIL, CUSTOMER_COMMENT,
                        STARTED_FEEDBACK, FINISHED_FEEDBACK},
                ID_FEEDBACK + "= ?", new String[]{String.valueOf (id)}, null, null, null);

        Feedback feedback;
        if (cursor != null) {
            cursor.moveToFirst ();
            feedback = new Feedback (
                    cursor.getInt (0),
                    cursor.getString (1),
                    cursor.getString (2),
                    cursor.getString (3),
                    cursor.getLong (4),
                    cursor.getLong (5)
            );
            return feedback;

        }
        return null;

    }
    //FEEDBACK

    public int updateFeedback(Feedback feedback) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase ();

        ContentValues contentValues = new ContentValues ();

        contentValues.put (CUSTOMER_NAME, feedback.getCustomer_name ());
        contentValues.put (CUSTOMER_EMAIL, feedback.getCustomer_email ());
        contentValues.put (CUSTOMER_COMMENT, feedback.getCustomer_comment ());
        contentValues.put (STARTED_FEEDBACK, feedback.getStarted ());
        contentValues.put (FINISHED_FEEDBACK, feedback.getFinished ());

        int status = sqLiteDatabase.update (TABLE_NAME_fd, contentValues,
                ID_FEEDBACK + " =?",
                new String[]{String.valueOf (feedback.getId ())});

        sqLiteDatabase.close ();

        return status;
    }
}