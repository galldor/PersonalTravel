package br.com.forukode.matheusmartins.personaltravel.tb;

/**
 * Created by matheusmartins on 12/30/14.
 */
public class UserTB {

    public static final String TABLE_NAME = "user";
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + UserTB.TABLE_NAME;
    public static final String ID = "id";
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String BIRTH_DATE = "birth_date";
    public static final String PHONE_NUMBER = "phone_number";
    public static final String NICKNAME = "nickname";
    public static final String EMAIL = "email";
    public static final String DESCRIPTION = "description";
    public static final String CITY = "city";
    public static final String STATE = "state";
    public static final String PROFILE_IMAGE_URL = "profile_image";
    public static final String PASSWORD = "password";
    public static final String IS_CONSULTANT = "is_consultant";
    public static final String COUNTRY_THAT_IS_CONSULTANT = "country_that_is_consultant";
    public static final String CREATED_DATE = "created_date";
    public static final String LAST_MODIFIED_DATE = "last_modified_date";
    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME
            + "("
            + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + FIRST_NAME + " TEXT NOT NULL, "
            + LAST_NAME + " TEXT NOT NULL, "
            + PHONE_NUMBER + " TEXT, "
            + BIRTH_DATE + " INTEGER, "
            + NICKNAME + " TEXT, "
            + EMAIL + " TEXT, "
            + DESCRIPTION + " TEXT, "
            + CITY + " TEXT, "
            + STATE + " TEXT, "
            + PROFILE_IMAGE_URL + " TEXT, "
            + PASSWORD + " TEXT, "
            + IS_CONSULTANT + " INTEGER, "
            + COUNTRY_THAT_IS_CONSULTANT + " TEXT, "
            + CREATED_DATE + " INTEGER, "
            + LAST_MODIFIED_DATE + " INTEGER );";
    public static final String PICTURE = "picture";
    public static final String[] columns = {
            ID,
            FIRST_NAME,
            LAST_NAME,
            BIRTH_DATE,
            PHONE_NUMBER,
            NICKNAME,
            EMAIL,
            DESCRIPTION,
            CITY,
            STATE,
            PROFILE_IMAGE_URL,
            PASSWORD,
            IS_CONSULTANT,
            COUNTRY_THAT_IS_CONSULTANT,
            CREATED_DATE,
            LAST_MODIFIED_DATE,
            PICTURE};

}
