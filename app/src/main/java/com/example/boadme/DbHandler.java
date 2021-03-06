package com.example.boadme;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.strictmode.SqliteObjectLeakedViolation;

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
    private static final String CUSTOMER_EMAIL  = "customer_email";
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

    ///////////////////////////////BOOKING////////////////////////////////////////

    private static final String TABLE_Booking = "booking_db";

    private static final String BOOKING_ID = "booking_id";
    private static final String BOOKING_NAME = "booking_name";
    private static final String BOOKING_CONTACT = "booking_contact";
    private static final String BOOKING_AGE = "booking_age";
    private static final String BOOKING_GENDER = "booking_gender";
    private static final String BOOKING_STARTED = "booking_started";
    private static final String BOOKING_FINISHED = "booking_finished";


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

///////////////////////////////BOARDING////////////////////////////////////////

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


       ////////////////////////////FEEDBACK////////////////////////////////////
        String TABLE_CREATE_FEEDBACK = "CREATE TABLE "+TABLE_NAME_fd+" " +
                "("
                +ID_FEEDBACK+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +CUSTOMER_NAME + " TEXT,"
                +CUSTOMER_EMAIL+ " TEXT,"
                +CUSTOMER_COMMENT + " TEXT,"
                +STARTED_FEEDBACK+ " TEXT,"
                +FINISHED_FEEDBACK+ " TEXT" +
                ");";

        sqLiteDatabase.execSQL(TABLE_CREATE_FEEDBACK);

///////////////////////////////BOOKING////////////////////////////////////////

        String TABLE_CREATE_QUERY_Booking= "CREATE TABLE "+TABLE_Booking+" " +
                "("
                +BOOKING_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +BOOKING_NAME + " TEXT,"
                +BOOKING_CONTACT + " TEXT,"
                +BOOKING_AGE + " TEXT,"
                +BOOKING_GENDER + " TEXT,"
                +BOOKING_STARTED+ " TEXT,"
                +BOOKING_FINISHED+ " TEXT" +
                ");";

        sqLiteDatabase.execSQL(TABLE_CREATE_QUERY_Booking);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS " + TABLE_NAME;

        sqLiteDatabase.execSQL(DROP_TABLE_QUERY);

        ///////////////////////////////BOARDING////////////////////////////////////////
        String DROP_TABLE_BOARDING = "DROP TABLE IF EXISTS " + table_name;

        sqLiteDatabase.execSQL(DROP_TABLE_BOARDING);

        onCreate(sqLiteDatabase);

        /////////////////////////////FEEDBACK///////////////////////////////
        String DROP_TABLE_FEEDBACK= "DROP TABLE IF EXISTS "+ TABLE_NAME_fd;

        sqLiteDatabase.execSQL(DROP_TABLE_FEEDBACK);
        onCreate(sqLiteDatabase);

        ///////////////////////////////BOOKING////////////////////////////////////////
        String DROP_TABLE_QUERY_Booking = "DROP TABLE IF EXISTS "+ TABLE_Booking;

        sqLiteDatabase.execSQL(DROP_TABLE_QUERY_Booking);

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

    public Hostal getSingaleHostal(int id){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        Cursor cursor = sqLiteDatabase.query(TABLE_NAME, new String[]{ID,OWNER_NAME,HOSTAL_LOCATION,PHONE_NUM,
                        EMAIL,ADDRESS,NUM_OF_RM,PRICE,STARTED,FINISHED},
                ID + "= ?",new String[]{String.valueOf(id)},null,null,null);

        Hostal hostal;

        if (cursor != null){
            cursor.moveToFirst();
            hostal = new Hostal(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7),
                    cursor.getLong(8),
                    cursor.getLong(9)
            );
            return hostal;

        }
        return null;

    }


    public int updateHostal(Hostal hostal){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(OWNER_NAME,hostal.getOwner_name());
        contentValues.put(HOSTAL_LOCATION,hostal.getHostal_location());
        contentValues.put(PHONE_NUM,hostal.getPhone_num());
        contentValues.put(EMAIL,hostal.getEmail());
        contentValues.put(ADDRESS,hostal.getAddress());
        contentValues.put(NUM_OF_RM,hostal.getNum_of_rm());
        contentValues.put(PRICE,hostal.getPrice());
        contentValues.put(STARTED,hostal.getStarted());
        contentValues.put(FINISHED,hostal.getFinished());

        int status = sqLiteDatabase.update(TABLE_NAME,contentValues,
                ID +" =?",
                new String[]{String.valueOf(hostal.getId())});

        sqLiteDatabase.close();

        return status;
    }





    ///////////////////////////////////////////////////////////////////////////////////
    //////////////////Boarding//////////////////

    ///Insert Details - Boarding///
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

    ///Display details - read///
    public List<Boarding> displayDetailsB() {
        List<Boarding> boardings = new ArrayList();
        SQLiteDatabase database = getReadableDatabase();
        String query = "SELECT * FROM " + table_name;

        Cursor cursor = database.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                Boarding boarding = new Boarding();
                boarding.setId(cursor.getInt(0));
                boarding.setOwnerName(cursor.getString(1));
                boarding.setPhone(cursor.getString(2));
                boarding.setPrice(cursor.getString(3));
                boarding.setLocation(cursor.getString(4));
                boarding.setDetails2(cursor.getString(5));
                boarding.setAddress(cursor.getString(6));
                boarding.setEmail(cursor.getString(7));

                boardings.add(boarding);
            } while (cursor.moveToNext());
        }
        return boardings;
    }

    ///Delete details///
    public void deleteBoarding(int key) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        sqLiteDatabase.delete(table_name, "id =?",
                new String[]{String.valueOf(key)});
        sqLiteDatabase.close();
    }



    public Boarding getSingleBoarding(int Id){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        Cursor cursor = sqLiteDatabase.query(table_name,
                new String[]{id,ownerName,phone,price,location,details,address,email},
                id + "= ?",
                new String[]{String.valueOf(Id)},null,null,null);

        Boarding boarding;

        if(cursor!=null){
            cursor.moveToFirst();

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

    ///update details///
    public int updateBoarding(Boarding boarding){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(ownerName, boarding.getOwnerName());
        contentValues.put(phone, boarding.getPhone());
        contentValues.put(price, boarding.getPrice());
        contentValues.put(location, boarding.getLocation());
        contentValues.put(address, boarding.getAddress());
        contentValues.put(email, boarding.getEmail());
        contentValues.put(details, boarding.getDetails2());
        int status = sqLiteDatabase.update(table_name,contentValues,
                id +" =?",
                new String[]{String.valueOf(boarding.getId())});
        sqLiteDatabase.close();
        return status;
    }




    //FEEDBACK

    public void add_Feedback(Feedback feedback){

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(CUSTOMER_NAME,feedback.getCustomer_name ());
        contentValues.put(CUSTOMER_EMAIL,feedback.getCustomer_email ());
        contentValues.put(CUSTOMER_COMMENT ,feedback.getCustomer_comment ());
        contentValues.put(STARTED_FEEDBACK,feedback.getStarted());
        contentValues.put(FINISHED_FEEDBACK,feedback.getFinished());

        sqLiteDatabase.insert(TABLE_NAME_fd, null,contentValues);
        sqLiteDatabase.close();

    }
    //FEEDBACK
    public  int countFeedback(){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String query = "SELECT * FROM "+ TABLE_NAME_fd;

        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        return cursor.getCount();
    }
    //FEEDBACK
    public List<Feedback> getAllFeedback(){

        List<Feedback> feedbacks = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME_fd;

        Cursor cursor = sqLiteDatabase.rawQuery(query,null);

        if (cursor.moveToFirst()){
            do {

                Feedback feedback = new Feedback ();

                feedback.setId(cursor.getInt(0));
                feedback.setCustomer_name (cursor.getString(1));
                feedback.setCustomer_email (cursor.getString(2));
                feedback.setCustomer_comment (cursor.getString(3));
                feedback.setStarted(cursor.getLong(4));
                feedback.setFinished(cursor.getLong(5));

                feedbacks.add(feedback);

            }while (cursor.moveToNext());
        }
        return feedbacks;
    }
    //FEEDBACK
    public void deleteFeedback(int id){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME_fd,"id =?",new String[]{String.valueOf(id)});
        sqLiteDatabase.close();
    }
    //FEEDBACK
    public Feedback getfeedbacklayout(int id){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        Cursor cursor = sqLiteDatabase.query(TABLE_NAME_fd, new String[]{ID_FEEDBACK,CUSTOMER_NAME,CUSTOMER_EMAIL,CUSTOMER_COMMENT,
                        STARTED_FEEDBACK,FINISHED_FEEDBACK},
                ID_FEEDBACK + "= ?",new String[]{String.valueOf(id)},null,null,null);

        Feedback feedback;
        if (cursor != null){
            cursor.moveToFirst();
            feedback = new Feedback (

                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getLong(4),
                    cursor.getLong(5)

            );
            return feedback;
        }

    return null;
}

    //FEEDBACK

    public int updateFeedback(Feedback feedback){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(CUSTOMER_NAME,feedback.getCustomer_name ());
        contentValues.put(CUSTOMER_EMAIL,feedback.getCustomer_email ());
        contentValues.put(CUSTOMER_COMMENT,feedback.getCustomer_comment ());
        contentValues.put(STARTED_FEEDBACK,feedback.getStarted());
        contentValues.put(FINISHED_FEEDBACK,feedback.getFinished());

        int status = sqLiteDatabase.update(TABLE_NAME_fd,contentValues,
                ID_FEEDBACK +" =?",
                new String[]{String.valueOf(feedback.getId())});

        sqLiteDatabase.close();

        return status;
    }

    public void add_Booking(Booking booking){

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(BOOKING_NAME,booking.getName());
        contentValues.put(BOOKING_CONTACT,booking.getContact());
        contentValues.put(BOOKING_AGE,booking.getAge());
        contentValues.put(BOOKING_GENDER,booking.getGender());
        contentValues.put(BOOKING_STARTED,booking.getStarted());
        contentValues.put(BOOKING_FINISHED,booking.getFinished());

        sqLiteDatabase.insert(TABLE_Booking, null,contentValues);
        sqLiteDatabase.close();

    }


    //////////////////Booking////////////////////////////////
    public List<Booking> getAllBooking(){

        List<Booking> bookings = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String query = "SELECT * FROM "+TABLE_Booking;

        Cursor cursor1 = sqLiteDatabase.rawQuery(query, null);

        if (cursor1.moveToFirst()){
            do {

                Booking booking = new Booking();

                booking.setId(cursor1.getInt(0));
                booking.setName(cursor1.getString(1));
                booking.setContact(cursor1.getString(2));
                booking.setAge(cursor1.getString(3));
                booking.setGender(cursor1.getString(4));
                booking.setStarted(cursor1.getLong(5));
                booking.setFinished(cursor1.getLong(6));

                bookings.add(booking);

            }while (cursor1.moveToNext());
        }
        return bookings;
    }

    //////////////////Booking////////////////////////////////
    public void delete_Booking(int id){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        sqLiteDatabase.delete(TABLE_Booking,"booking_id =?",new String[]{String.valueOf(id)});
        sqLiteDatabase.close();
    }
    //////////////////Booking////////////////////////////////
    public Booking getSingleBooking(int id){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        Cursor cursor = sqLiteDatabase.query(TABLE_Booking, new String[]{BOOKING_ID,BOOKING_NAME,BOOKING_CONTACT,BOOKING_AGE,
                        BOOKING_GENDER,BOOKING_STARTED,BOOKING_FINISHED},
                BOOKING_ID + "= ?",new String[]{String.valueOf(id)},null,null,null);

        Booking booking;

        if (cursor != null){
            cursor.moveToFirst();
            booking = new Booking(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getLong(5),
                    cursor.getLong(6)
            );
            return booking;

        }
        return null;

    }

    //////////////////Booking////////////////////////////////
    public int update_Booking(Booking booking){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(BOOKING_NAME,booking.getName());
        contentValues.put(BOOKING_CONTACT,booking.getContact());
        contentValues.put(BOOKING_AGE,booking.getAge());
        contentValues.put(BOOKING_GENDER,booking.getGender());
        contentValues.put(BOOKING_STARTED,booking.getStarted());
        contentValues.put(BOOKING_FINISHED,booking.getFinished());

        int status = sqLiteDatabase.update(TABLE_Booking,contentValues,
                BOOKING_ID +" =?",
                new String[]{String.valueOf(booking.getId())});

        sqLiteDatabase.close();

        return status;
    }

}

