package com.example.msise.actorlistapp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Actor implements Parcelable {
    private String name;
    private String film;

    public Actor(String name, String film) {
        this.name = name;
        this.film = film;
    }

    public Actor(Parcel source) {
        this.name = source.readString();
        this.film = source.readString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public static final Parcelable.Creator<Actor> CREATOR = new Parcelable.Creator<Actor>() {
        public Actor createFromParcel(Parcel source) {
            return new Actor(source);
        }
        @Override
        public Actor[] newArray(int size) {
            return new Actor[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(film);
    }
}
