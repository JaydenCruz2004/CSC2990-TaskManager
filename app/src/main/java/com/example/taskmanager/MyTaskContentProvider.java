package com.example.taskmanager;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

import androidx.annotation.Nullable;

import java.net.URI;

public class MyTaskContentProvider extends ContentProvider {
    public static final String TABLE_NAME = "TaskTable";
    public static final String COLUMN_TASK = "TASK";
    public static final String COLUMN_OWNER = "OWNER";
    public static final String DB_NAME = "TASKDB";

    public static final Uri CONTENT_URI = Uri.parse("content://com.example.taskmanager.provider");
    SQLiteOpenHelper mHelper;


    public final class MainDatabaseHelper extends SQLiteOpenHelper{

        public MainDatabaseHelper(Context context) {
            super(context, DB_NAME, null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(SQL_CREATE);

        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        }
    }


    public final static String SQL_CREATE = "CREATE TABLE " +  TABLE_NAME +  "(" +
            "_ID INTEGER PRIMARY KEY, "+
            COLUMN_TASK + "TEXT," +
            COLUMN_OWNER + "TEXT )";



    public MyTaskContentProvider() {

    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        String owner = values.getAsString(COLUMN_OWNER);
        String task = values.getAsString(COLUMN_TASK);
        Long id = mHelper.getWritableDatabase().insert(TABLE_NAME, null, values);
        return Uri.withAppendedPath(CONTENT_URI, "" + id);
    }

    @Override
    public boolean onCreate() {
        mHelper = new MainDatabaseHelper(getContext());
        return true;

    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        // TODO: Implement this to handle query requests from clients.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}