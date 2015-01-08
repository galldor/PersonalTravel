package br.com.forukode.matheusmartins.personaltravel.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import br.com.forukode.matheusmartins.personaltravel.util.DatabaseUtil;

/**
 * Created by matheusmartins on 12/30/14.
 */
public abstract class BaseDAO {

    public static String EQUAL_SQL = " =? ";
    public static String NOT_EQUAL_SQL = " !=? ";
    public DatabaseUtil dbHelper;
    private String[] columns;
    private String table;

    public BaseDAO(Context context, String[] columns, String table) {
        dbHelper = new DatabaseUtil(context);
        this.columns = columns;
        this.table = table;
    }

    public Cursor geCursorById(int id) {
        return getCursorByCriteriaWithSort(new String[]{String.valueOf(id)}, columns[0] + EQUAL_SQL, null);
    }

    public Cursor getCursorByCriteriaWithSort(String[] values, String columnAndCriteria, String order) {
        return dbHelper.getReadableDatabase().query(table, columns, columnAndCriteria, values, null, null, null, order);
    }

    public Cursor getCursorAll() {
        return dbHelper.getReadableDatabase().query(table, columns, null, null, null, null, null, null);
    }

    public long insert(ContentValues values) {
        return dbHelper.getWritableDatabase().insert(table, null, values);
    }

}
