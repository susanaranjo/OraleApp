package com.example.susananaranjovillamil.orale;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by susana.naranjo.villamil on 6/22/17.
 */

public class SharedPreference {
    public static final String PREFS_NAME = "ORALE_APP";
    public static final String FAVORITES =  "Favorite";
    public SharedPreference(){
        super();
    }

        public void storeFavorites(Context context, List<Report> favorites) {
            SharedPreferences settings;
            SharedPreferences.Editor editor;
            settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
            editor = settings.edit();
            Gson gson = new Gson();
            String jsonFavorites = gson.toJson(favorites);
            editor.putString(FAVORITES, jsonFavorites);
            editor.commit();
        }

        public ArrayList<Report> loadFavorites(Context context) {
            SharedPreferences settings;
            List<Report> favorites;
            settings = context.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE);
            if (settings.contains(FAVORITES)) {
                String jsonFavorites = settings.getString(FAVORITES, null);
                Gson gson = new Gson();
                Report[] favoriteItems = gson.fromJson(jsonFavorites, Report[].class);
                favorites = Arrays.asList(favoriteItems);
                favorites = new ArrayList(favorites);
            } else
                return null;

            return (ArrayList<Report>) favorites;
        }



        public void addFavorite(Context context, Report report) {
            List <Report> favorites = loadFavorites(context);
            if (favorites == null)
                favorites = new ArrayList<Report>();
            favorites.add(report);
            storeFavorites(context, favorites);
        }





}




