package com.example.susananaranjovillamil.orale;

/**
 * Created by susana.naranjo.villamil on 6/18/17.
 */

import android.os.Parcel;
import android.os.Parcelable;


public class Pictogram implements Parcelable{


    private String  name, bodyPart, bodySubpart, description, cause;
    private Integer imgid;
    private int day, month, year;





    public Pictogram (String bodyPart, String bodySubpart, String name, Integer imgid, int year, int month, int day, String description, String cause){

        this.bodyPart=bodyPart;
        this.bodySubpart=bodySubpart;
        this.name=name;
        this.imgid=imgid;
        this.day=day;
        this.month=month;
        this.year=year;
        this.description=description;
        this.cause=cause;

    }


    public String getName() {
        return name;
    }

    public Integer getImgid() {
        return imgid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImgid(Integer imgid) {
        this.imgid = imgid;
    }

    public String getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(String bodyPart) {
        this.bodyPart = bodyPart;
    }

    public String getBodySubpart() {
        return bodySubpart;
    }

    public void setBodySubpart(String bodySubpart) {
        this.bodySubpart = bodySubpart;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public Pictogram (Parcel in){
        super();
        readFromParcel(in);
    }

    public static final Parcelable.Creator<Pictogram> CREATOR = new Parcelable.Creator<Pictogram>() {
        public Pictogram createFromParcel (Parcel in) {
            return new Pictogram(in);
        }

        public Pictogram[] newArray(int size) {
            return new Pictogram[size];
        }
    };

    public void readFromParcel(Parcel in){
        bodyPart=in.readString();
        bodySubpart=in.readString();
        name=in.readString();
        imgid=in.readInt();
        day=in.readInt();
        month=in.readInt();
        year=in.readInt();
        description=in.readString();
        cause=in.readString();

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(bodyPart);
        dest.writeString(bodySubpart);
        dest.writeString(name);
        dest.writeInt(imgid);
        dest.writeInt(day);
        dest.writeInt(month);
        dest.writeInt(year);
        dest.writeString(description);
        dest.writeString(cause);

    }
}
