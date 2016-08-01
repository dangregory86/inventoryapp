package com.example.wonkydan.inventoryapp3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Dan Gregory on 25/07/2016.
 */
public class InventoryDatabase extends SQLiteOpenHelper {
    public InventoryDatabase(Context context) {
        super(context, DatabaseContract.DATABASE_NAME, null, DatabaseContract.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(DatabaseContract.Table1.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int previousTable, int newDatabase) {

        sqLiteDatabase.execSQL(DatabaseContract.Table1.DELETE_TABLE);
        onCreate(sqLiteDatabase);
    }

    public Cursor getAllInfo(){
        SQLiteDatabase database = this.getReadableDatabase();
        return database.query(DatabaseContract.Table1.TABLE_TITLE, null, null, null, null, null, null);
    }

    public Cursor getItem(){
        SQLiteDatabase database = this.getReadableDatabase();
        return database.query(DatabaseContract.Table1.TABLE_TITLE, null, "ID = ?", null, null, null, null);
    }

    public boolean updateData(String id, String name, String size, double price, int quantity){

        //open the writable database
        SQLiteDatabase database = this.getWritableDatabase();

        //values to be updated
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseContract.Table1.ID, id);
        contentValues.put(DatabaseContract.Table1.NAME, name);
        contentValues.put(DatabaseContract.Table1.SIZE, size );
        contentValues.put(DatabaseContract.Table1.PRICE, price);
        contentValues.put(DatabaseContract.Table1.QUANTITY, quantity);

        //updating the database
        database.update(DatabaseContract.Table1.TABLE_TITLE, contentValues, "ID = ?", new String[] { id } );

        return true;
    }

}
