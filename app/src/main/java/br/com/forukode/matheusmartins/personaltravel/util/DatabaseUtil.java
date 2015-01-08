package br.com.forukode.matheusmartins.personaltravel.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.com.forukode.matheusmartins.personaltravel.tb.UserTB;

/**
 * Created by matheusmartins on 12/30/14.
 */
public class DatabaseUtil extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "PersonalTravel.db";

    public DatabaseUtil(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UserTB.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(UserTB.DROP_TABLE);
        onCreate(db);
    }
}
