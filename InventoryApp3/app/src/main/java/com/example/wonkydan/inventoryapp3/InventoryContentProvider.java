package com.example.wonkydan.inventoryapp3;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by dan gregory on 26/07/2016.
 */
public class InventoryContentProvider extends ContentProvider {

    private static final String AUTH = "com.example.wonkydan.inventoryapp.InventoryContentProvider";
    public static final Uri INVENTORY_URI = Uri.parse("content://" + AUTH + "/" + DatabaseContract.Table1.TABLE_TITLE);

    Context context = getContext();
    SQLiteDatabase database;
    InventoryDatabase inventoryDatabase;


    @Override
    public boolean onCreate() {
        inventoryDatabase = new InventoryDatabase(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] columns, String selection, String[] selectionArgs, String sortOrder) {

        Cursor cursor;
        inventoryDatabase.getReadableDatabase();
        cursor = database.query(DatabaseContract.Table1.TABLE_TITLE, columns, selection, selectionArgs, null, null, sortOrder);

        cursor.setNotificationUri(context.getContentResolver(), uri);

        return cursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {

        //open writable database
        database = inventoryDatabase.getWritableDatabase();

        //inserting values into the table

        database.insert(DatabaseContract.Table1.TABLE_TITLE, null, contentValues);
        context.getContentResolver().notifyChange(uri, null);
        database.close();

        return null;
    }

    @Override
    public int delete(Uri uri, String whereClause, String[] whereArgs) {

        //open writable database
        database = inventoryDatabase.getWritableDatabase();

        //delete
        //to delete all whereClause and whereArgs need to be null
        database.delete(DatabaseContract.Table1.TABLE_TITLE, whereClause, whereArgs);
        context.getContentResolver().notifyChange(uri, null);
        database.close();

        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String whereClause, String[] whereArgs) {

        //open writable database
        database = inventoryDatabase.getWritableDatabase();

        //update database
        database.update(DatabaseContract.Table1.TABLE_TITLE, contentValues, whereClause, whereArgs );
        context.getContentResolver().notifyChange(uri, null);
        database.close();

        return 0;
    }
}
