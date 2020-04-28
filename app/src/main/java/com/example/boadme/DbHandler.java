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
        super(context, DB_NAME, null, VERSION);
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

        sqLiteDatabase.execSQL(TABLE_CREATE_QUERY);

        String CREATE_TABLE_BOARDING = "CREATE TABLE " + table_name + " " +
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

        sqLiteDatabase.execSQL(CREATE_TABLE_BOARDING);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS " + TABLE_NAME;

        sqLiteDatabase.execSQL(DROP_TABLE_QUERY);

        String DROP_TABLE_BOARDING = "DROP TABLE IF EXISTS " + table_name;

        sqLiteDatabase.execSQL(DROP_TABLE_BOARDING);

        onCreate(sqLiteDatabase);

    }

    public void add_Hostal(Hostal hostal) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(OWNER_NAME, hostal.getOwner_name());
        contentValues.put(HOSTAL_LOCATION, hostal.getHostal_location());
        contentValues.put(PHONE_NUM, hostal.getPhone_num());
        contentValues.put(EMAIL, hostal.getEmail());
        contentValues.put(ADDRESS, hostal.getAddress());
        contentValues.put(NUM_OF_RM, hostal.getNum_of_rm());
        contentValues.put(PRICE, hostal.getPrice());
        contentValues.put(STARTED, hostal.getStarted());
        contentValues.put(FINISHED, hostal.getFinished());

        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        sqLiteDatabase.close();

    }

    public int countHostal() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;

        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        return cursor.getCount();
    }

    public List<Hostal> getAllHostal() {

        List<Hostal> hostals = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;

        Cursor cursor = sqLiteDatabase.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {

                Hostal hostal = new Hostal();

                hostal.setId(cursor.getInt(0));
                hostal.setOwner_name(cursor.getString(1));
                hostal.setHostal_location(cursor.getString(2));
                hostal.setPhone_num(cursor.getString(3));
                hostal.setEmail(cursor.getString(4));
                hostal.setAddress(cursor.getString(5));
                hostal.setNum_of_rm(cursor.getString(6));
                hostal.setPrice(cursor.getString(7));
                hostal.setStarted(cursor.getLong(8));
                hostal.setFinished(cursor.getLong(9));

                hostals.add(hostal);

            } while (cursor.moveToNext());
        }
        return hostals;
    }

    public void deleteHostal(int id) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        sqLiteDatabase.delete(TABLE_NAME, "id =?", new String[]{String.valueOf(id)});
        sqLiteDatabase.close();
    }


    ///////////////////////////////////////////////////////////////////////////////////
    //////////////////Boarding//////////////////

    public void getDetailsBoarding(Boarding boarding) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(ownerName, boarding.getOwnerName());
        contentValues.put(phone, boarding.getPhone());
        contentValues.put(price, boarding.getPrice());
        contentValues.put(location, boarding.getLocation());
        contentValues.put(address, boarding.getAddress());
        contentValues.put(email, boarding.getEmail());
        contentValues.put(details, boarding.getDetails2());

        //save to table
        sqLiteDatabase.insert(table_name, null, contentValues);
        sqLiteDatabase.close();
    }

    public List<Boarding> displayDetailsB() {
        List<Boarding> boardings = new ArrayList();
        SQLiteDatabase database = getReadableDatabase();
        String query = "SELECT * FROM " + table_name;

        Cursor cursor = database.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                Boarding boarding = new Boarding();
                boarding.setLocation(cursor.getString(4));
                boarding.setPrice(cursor.getString(3));
                boarding.setDetails2(cursor.getString(5));
                boarding.setOwnerName(cursor.getString(1));
                boarding.setAddress(cursor.getString(6));
                boarding.setEmail(cursor.getString(7));
                boarding.setPhone(cursor.getString(2));

                boardings.add(boarding);
            } while (cursor.moveToNext());
        }
        return boardings;
    }

    public void deleteBoarding(int i) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();


        sqLiteDatabase.delete(table_name, id + "=?", new String[]{String.valueOf(i)});
        sqLiteDatabase.close();
    }

    public Boarding getSingleBoarding(int i) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        Cursor cursor = sqLiteDatabase.query(table_name, new String[]{id, ownerName, phone, price, location, details, address, email},
                "id =?",
                new String[]{String.valueOf(i)},
                null,
                null,
                null);

        Boarding boarding;
        if (cursor != null) {
            boarding = new Boarding(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7)


            );
            return boarding;
        }

        return null;
    }

}

