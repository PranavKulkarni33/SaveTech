package com.example.error404;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    public final String fullname;
    public final String Username;
    public final String password;

    public User(String fullname, String Username, String password){
        this.fullname = fullname;
        this.password = password;
        this.Username = Username;
    }

    public User(User u){
        this.fullname = u.fullname;
        this.password = u.password;
        this.Username = u.Username;
    }

    protected User(Parcel in) {
        fullname = in.readString();
        Username = in.readString();
        password = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(fullname);
        parcel.writeString(Username);
        parcel.writeString(password);
    }
}
