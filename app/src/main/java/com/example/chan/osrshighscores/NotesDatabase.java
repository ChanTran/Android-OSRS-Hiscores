package com.example.chan.osrshighscores;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Chan on 11/30/2017.
 */

public class NotesDatabase extends SQLiteOpenHelper {

    private static final int DATABASE_V = 1;
    private static final String DATABASE_NAME = "notesDB.db";
    private static final String DATABASE_TABLE = "notes";


    private static final String ID = "id";
    private static final String SUBJECT = "subject";
    private static final String BODY = "body";
    private static final String FLAG = "flag";


    public NotesDatabase(Context context, String dbName, SQLiteDatabase.CursorFactory f, int v)
    {
        super(context, DATABASE_NAME, f, DATABASE_V);
    }

    public void onCreate(SQLiteDatabase db)
    {
        String CREATE_TABLE = "CREATE TABLE " + DATABASE_TABLE + "( " + ID + " integer primary key autoincrement, " +
            SUBJECT + " TEXT," + BODY + " TEXT," + FLAG + " INTEGER)";
        db.execSQL(CREATE_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldV, int newV)
    {

    }

    /*
     * Add a note to the database, consisting of a flag, subject, body
     */
    public void addNote(Notes note)
    {
        ContentValues values = new ContentValues();
        values.put(SUBJECT, note.getSubject());
        values.put(BODY, note.getBody());
        if(note.getMarked())
        {
            values.put(FLAG, 1);
        }
        else
        {
            values.put(FLAG, 0);
        }
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(DATABASE_TABLE, null, values);

        db.close();

    }

    //Deletes the note based off of the id
    public void deleteNote(int id)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        String sql = "delete from " + DATABASE_TABLE + " where " + ID + " = " + id;
        db.execSQL(sql);
        db.close();
    }

    //Updates the note based off of the id, requires a subject , body, and flag parameter
    public void updateNote(int id, String subject, String body, int flag)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "update " + DATABASE_TABLE + " set " + SUBJECT + " = '" + subject + "', " + BODY + " = '" + body + "', " + FLAG + " = '" + flag + "'" + " where " + ID + " = " + id;
        db.execSQL(query);
        db.close();
    }

    //Overloaded method where we only require the id and flag
    public void updateNote(int id, int flag)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "update " + DATABASE_TABLE + " set " + FLAG + " = '" + flag + "'" + " where " + ID + " = " + id;
        db.execSQL(query);
        db.close();
    }

    //Returns an ArrayList of all the notes in the database
    public ArrayList<Notes> getAll()
    {
        String query = "select * from " + DATABASE_TABLE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor curs = db.rawQuery(query, null);
        ArrayList<Notes> notes = new ArrayList<>();
        while(curs.moveToNext())
        {
            notes.add(new Notes(curs.getString(1), curs.getString(2), Integer.parseInt(curs.getString(0)), Integer.parseInt(curs.getString(3))));
        }
        db.close();
        return notes;
    }

    //Gets one note from the database based off of the id
    public Notes getOne(int id)
    {
        String sql = "SELECT * FROM " + DATABASE_TABLE + " WHERE " + ID + " = \"" + id + "\"";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        Notes note = new Notes();
        if(cursor.moveToFirst())
        {
            note.setID(Integer.parseInt(cursor.getString(0)));
            note.setSubject(cursor.getString(1));
            note.setBody(cursor.getString(2));
            note.setMarked(Integer.parseInt(cursor.getString(3)));
            cursor.close();
        }
        else
        {
            note = null;
        }
        db.close();
        return note;

    }
}
