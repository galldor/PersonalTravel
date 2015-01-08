package br.com.forukode.matheusmartins.personaltravel.dao;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.com.forukode.matheusmartins.personaltravel.entity.User;
import br.com.forukode.matheusmartins.personaltravel.tb.UserTB;

/**
 * Created by matheusmartins on 12/30/14.
 */
public class UserDAO extends BaseDAO {
    public UserDAO(Context context) {
        super(context, UserTB.columns, UserTB.TABLE_NAME);
    }


    public User getRecordById(int id) {
        Cursor cursor = super.geCursorById(id);
        cursor.moveToFirst();

        User userInstance = new User(cursor);

        return userInstance;
    }

    public List<User> getAll() {
        Cursor cursor = super.getCursorAll();
        cursor.moveToFirst();

        List<User> userList = new ArrayList<User>();

        while (!cursor.isAfterLast()) {
            userList.add(new User(cursor));
            cursor.moveToNext();
        }
        return userList;
    }

    public long insert(User user) {
        return insert(user.toContentValeus());
    }

}
