package com.example.livre_database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BaseSQLite extends SQLiteOpenHelper {
    public static final String db_name = "Livres.db";

    public BaseSQLite(@Nullable Context context) {
        super(context, db_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String requete = "create table livre ( id integer primary key autoincrement, isbn integer, nom_livre text)";
        db.execSQL(requete);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS livre");
        onCreate(db);

    }
}
