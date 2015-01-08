package br.com.forukode.matheusmartins.personaltravel.entity;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;

import br.com.forukode.matheusmartins.personaltravel.tb.UserTB;

/**
 * Created by matheusmartins on 12/30/14.
 */
public class User implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };
    public int id;
    public String firstName;
    public String lastName;
    public Integer birthDate;
    public String phoneNumber;
    public String nickname;
    public String email;
    public String description;
    public String city;
    public String state;
    public String profileImageUrl;
    public String password;
    public Integer isConsultant;
    public String countryThatIsConsultant;
    public Integer createdDate;
    public Integer lastModifiedDate;


    public User(Cursor cursor) {
        this.id = cursor.getInt(cursor.getColumnIndex(UserTB.ID));
        this.firstName = cursor.getString(cursor.getColumnIndex(UserTB.FIRST_NAME));
        this.lastName = cursor.getString(cursor.getColumnIndex(UserTB.LAST_NAME));
        this.birthDate = cursor.getInt(cursor.getColumnIndex(UserTB.BIRTH_DATE));
        this.phoneNumber = cursor.getString(cursor.getColumnIndex(UserTB.PHONE_NUMBER));
        this.nickname = cursor.getString(cursor.getColumnIndex(UserTB.NICKNAME));
        this.email = cursor.getString(cursor.getColumnIndex(UserTB.EMAIL));
        this.description = cursor.getString(cursor.getColumnIndex(UserTB.DESCRIPTION));
        this.city = cursor.getString(cursor.getColumnIndex(UserTB.CITY));
        this.state = cursor.getString(cursor.getColumnIndex(UserTB.STATE));
        this.profileImageUrl = cursor.getString(cursor.getColumnIndex(UserTB.PROFILE_IMAGE_URL));
        this.password = cursor.getString(cursor.getColumnIndex(UserTB.PASSWORD));
        this.isConsultant = cursor.getInt(cursor.getColumnIndex(UserTB.IS_CONSULTANT));
        this.countryThatIsConsultant = cursor.getString(cursor.getColumnIndex(UserTB.COUNTRY_THAT_IS_CONSULTANT));
        this.createdDate = cursor.getInt(cursor.getColumnIndex(UserTB.CREATED_DATE));
        this.lastModifiedDate = cursor.getInt(cursor.getColumnIndex(UserTB.LAST_MODIFIED_DATE));
    }

    public User() {
    }


    private User(Parcel in) {
        id = in.readInt();
        firstName = in.readString();
        lastName = in.readString();
        birthDate = in.readInt();
        phoneNumber = in.readString();
        nickname = in.readString();
        email = in.readString();
        description = in.readString();
        city = in.readString();
        state = in.readString();
        profileImageUrl = in.readString();
        password = in.readString();
        isConsultant = in.readInt();
        countryThatIsConsultant = in.readString();
        createdDate = in.readInt();
        lastModifiedDate = in.readInt();
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    public ContentValues toContentValeus() {
        ContentValues values = new ContentValues();
        values.put(UserTB.FIRST_NAME, this.firstName);
        values.put(UserTB.LAST_NAME, this.lastName);
        values.put(UserTB.BIRTH_DATE, this.birthDate);
        values.put(UserTB.PHONE_NUMBER, this.phoneNumber);
        values.put(UserTB.NICKNAME, this.nickname);
        values.put(UserTB.EMAIL, this.email);
        values.put(UserTB.DESCRIPTION, this.description);
        values.put(UserTB.CITY, this.city);
        values.put(UserTB.STATE, this.state);
        values.put(UserTB.PROFILE_IMAGE_URL, this.profileImageUrl);
        values.put(UserTB.PASSWORD, this.password);
        values.put(UserTB.IS_CONSULTANT, this.isConsultant);
        values.put(UserTB.COUNTRY_THAT_IS_CONSULTANT, this.countryThatIsConsultant);
        values.put(UserTB.CREATED_DATE, this.createdDate);
        values.put(UserTB.LAST_MODIFIED_DATE, this.lastModifiedDate);
        return values;
    }

    @Override
    public int describeContents() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        // TODO Auto-generated method stub
        dest.writeInt(id);
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeInt(birthDate);
        dest.writeString(phoneNumber);
        dest.writeString(nickname);
        dest.writeString(email);
        dest.writeString(description);
        dest.writeString(city);
        dest.writeString(state);
        dest.writeString(profileImageUrl);
        dest.writeString(password);
        dest.writeInt(isConsultant);
        dest.writeString(countryThatIsConsultant);
        dest.writeInt(createdDate);
        dest.writeInt(lastModifiedDate);
    }
}
