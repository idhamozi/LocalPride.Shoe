package com.example.localprideshoe;

import android.os.Parcel;
import android.os.Parcelable;

public class Shoes implements Parcelable {
    private String Name;
    private String Detail;
    private int Photo, ShoesPhoto;

    public Shoes() {

    }

    public String getName() {
        return Name;
    }

    public void setName (String name) {
        Name = name;
    }

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String detail) {
        Detail = detail;
    }

    public int getPhoto() {
        return Photo;
    }

    public void setPhoto(int photo) {
        Photo = photo;
    }

    public int getShoesPhoto() {
        return ShoesPhoto;
    }

    public void setShoesPhoto(int shoesPhoto) {
        ShoesPhoto = shoesPhoto;
    }

    protected Shoes(Parcel in) {
        Name = in.readString();
        Detail = in.readString();
        Photo = in.readInt();
        ShoesPhoto = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(Name);
        parcel.writeString(Detail);
        parcel.writeInt(Photo);
        parcel.writeInt(ShoesPhoto);
    }

    public static final Creator<Shoes> CREATOR = new Creator<Shoes>() {
        @Override
        public Shoes createFromParcel(Parcel in) {
            return new Shoes(in);
        }

        @Override
        public Shoes[] newArray(int size) {
            return new Shoes[size];
        }
    };
}
