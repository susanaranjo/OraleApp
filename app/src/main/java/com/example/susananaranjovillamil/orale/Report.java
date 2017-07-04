package com.example.susananaranjovillamil.orale;


import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by susana.naranjo.villamil on 6/22/17.
 */

public class Report {
    private String id;
    private int day, month, year;
    private ArrayList<Pictogram> symptoms;

    public Report (int day, int month, int year, ArrayList<Pictogram> symptoms){
        this.id= UUID.randomUUID().toString();
        this.day=day;
        this.month=month;
        this.year=year;
        this.symptoms=symptoms;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public ArrayList<Pictogram> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(ArrayList<Pictogram> symptoms) {
        this.symptoms = symptoms;
    }
}
