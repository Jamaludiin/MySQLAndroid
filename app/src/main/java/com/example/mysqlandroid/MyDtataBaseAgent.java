package com.example.mysqlandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDtataBaseAgent extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "Products.db";
    private static final int DATABASE_VERSION =1;
    private static final String TABLE_NAME = "myproduct";
    private static final String COLUMN_ID = "prd_id";
    private static final String COLUMN_NAME = "prd_name";
    private static final String COLUMN_DESCRIPTION = "prd_description";
    private static final String COLUMN_CATEGORY = "prd_category";

    public MyDtataBaseAgent(@Nullable Context context ) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context; // Initialize the context field
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query =
                "CREATE TABLE " + TABLE_NAME +
                        " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_NAME + " TEXT, " +
                        COLUMN_DESCRIPTION + " TEXT, " +
                        COLUMN_CATEGORY + " TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addProduct(String prname, String prdescription, String prcategory){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME, prname);
        cv.put(COLUMN_DESCRIPTION, prdescription);
        cv.put(COLUMN_CATEGORY, prcategory);

        long result = db.insert(TABLE_NAME, null, cv);

        if(result == -1){
            Toast.makeText(context, "Failed to Insert", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Successfully Inserted new row", Toast.LENGTH_SHORT).show();

        }
    }

    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;
    }
}
