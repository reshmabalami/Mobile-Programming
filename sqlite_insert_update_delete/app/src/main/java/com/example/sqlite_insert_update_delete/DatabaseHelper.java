package com.example.sqlite_insert_update_delete;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



    public class DatabaseHelper extends SQLiteOpenHelper {

        private static final String DATABASE_NAME = "mydatabase.db";
        private static final int DATABASE_VERSION = 1;
        public static final String TABLE_NAME = "mytable";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_ADDRESS = "address";

        private static final String CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + "(" +
                        COLUMN_ID + " INTEGER PRIMARY KEY," +
                        COLUMN_NAME + " TEXT," +
                        COLUMN_ADDRESS + " TEXT" +
                        ")";

        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // Handle database upgrade if needed
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }

        public long insertData(String id, String name, String address) {
            SQLiteDatabase db = getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(COLUMN_ID, id);
            values.put(COLUMN_NAME, name);
            values.put(COLUMN_ADDRESS, address);
            return db.insert(TABLE_NAME, null, values);
        }

        public Cursor selectData() {
            SQLiteDatabase db = this.getReadableDatabase();
            String query = "SELECT id as _id, * FROM " + TABLE_NAME; // Add 'id as _id' alias
            return db.rawQuery(query, null);
        }

        public int updateData(String id, String name, String address) {
            SQLiteDatabase db = getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(COLUMN_NAME, name);
            values.put(COLUMN_ADDRESS, address);
            return db.update(TABLE_NAME, values, COLUMN_ID + " = ?", new String[]{id});
        }

        public int deleteData(String id) {
            SQLiteDatabase db = getWritableDatabase();
            return db.delete(TABLE_NAME, COLUMN_ID + " = ?", new String[]{id});
        }
    }