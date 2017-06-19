package com.example.susananaranjovillamil.orale;

/**
 * Created by susana.naranjo.villamil on 6/18/17.
 */

import java.text.SimpleDateFormat;
import java.util.UUID;

public class Pictogram {


    private String id, name, bodyPart, bodySubpart;
    private Integer imgid;
    private int day, month, year;





    public Pictogram (String bodyPart, String bodySubpart, String name, Integer imgid, int day, int month, int year){
        this.id= UUID.randomUUID().toString();
        this.bodyPart=bodyPart;
        this.bodySubpart=bodySubpart;
        this.name=name;
        this.imgid=imgid;
        this.day=day;
        this.month=month;
        this.year=year;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
