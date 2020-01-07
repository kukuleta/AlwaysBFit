package com.example.alwaysbfit;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.Map;

public class Exercise implements Parcelable, Serializable {

    private String name;
    private String description;

    public Exercise(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescritipn(String descritipn) {
        this.description = description;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.description);
    }

    protected Exercise(Parcel in) {
        this.name = in.readString();
        this.description = in.readString();
    }

    public static final Parcelable.Creator<Exercise> CREATOR = new Parcelable.Creator<Exercise>()
    {
        @Override
        public Exercise createFromParcel(Parcel source) {
            return new Exercise(source);
        }
        @Override
        public Exercise[] newArray(int size) {
            return new Exercise[size];
        }
    };
}
