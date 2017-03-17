package com.example.adanur.login1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Adanur on 3/12/2016.
 */
public class Databasehelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="contacts.db";
    private static final String TABLE_NAME="contacts";
    private static final String COLUMN_ID="id";
    private static final String COLUMN_NAME="name";
    private static final String COLUMN_PASS="password";
    private static final String COLUMN_EMAIL="email";
    SQLiteDatabase db;
    private static final String TABLE_CREATE="create table contacts(id integer primary key not null," +
            "name text not null,email text not null,password text not null)";

    public Databasehelper(Context context)
    {
      super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db=db;
    }
    public void insertcontact(contact c)
    {
        db= this.getWritableDatabase();
        ContentValues values=new ContentValues();

        String query="select * from contacts";
        Cursor cursor=db.rawQuery(query,null);
        int count=cursor.getCount();

        values.put(COLUMN_ID,count);
        values.put(COLUMN_NAME,c.get_name());
        values.put(COLUMN_EMAIL,c.get_email());
        values.put(COLUMN_PASS, c.get_pass());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }
    public String srcpass(String uname)
    {
      db=this.getReadableDatabase();
        String query1="select name, password from "+TABLE_NAME;
        Cursor cursor1=db.rawQuery(query1,null);
        String a,b;
                b="not found";
        if(cursor1.moveToFirst())
        {
            do{
                a=cursor1.getString(0);
                if(a.equals(uname))//check the username
                {
                   b=cursor1.getString(1);//if ryt check the password
                    break;
                }

            }
            while(cursor1.moveToNext());
        }
        return b;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query="DROP_TABLE IF EXISTS"+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);

    }
}
