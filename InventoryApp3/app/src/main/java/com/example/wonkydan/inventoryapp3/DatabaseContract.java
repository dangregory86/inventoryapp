package com.example.wonkydan.inventoryapp3;

import android.provider.BaseColumns;

/**
 * Created by Dan Gregory on 25/07/2016.
 */
public final class DatabaseContract {

    public static final  int    DATABASE_VERSION   = 2;
    private static final String TEXT_TYPE          = " TEXT";
    private static final String COMMA_SEP          = ", ";
    public static final String DATABASE_NAME = "Inventory_Database";

    private DatabaseContract() {}

    public static abstract class Table1 implements BaseColumns {
        public static final String TABLE_TITLE = "Inventory";
        public static final String ID = "ID INTEGER PRIMARY KEY";
        public static final String NAME = "NAME";
        public static final String SIZE = "SIZE";
        public static final String PRICE = "PRICE";
        public static final String QUANTITY = "QUANTITY";


        public static final String CREATE_TABLE = "CREATE TABLE " +
                TABLE_TITLE + " (" +
                ID + COMMA_SEP +
                NAME + TEXT_TYPE + COMMA_SEP +
                SIZE + TEXT_TYPE + COMMA_SEP +
                PRICE + TEXT_TYPE + COMMA_SEP +
                QUANTITY + TEXT_TYPE +  ")";
        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_TITLE;
    }
}
