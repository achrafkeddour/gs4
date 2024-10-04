package com.example.livre_database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class LivreOperations {
    private BaseSQLite helper;
    private SQLiteDatabase db;
    private static final String table_name = "livre";
    public LivreOperations(BaseSQLite helper) {
        this.helper = helper;
    }
    public boolean insert(Livre lv) {
        db = helper.getWritableDatabase();
        ContentValues valeurs = new ContentValues();
        valeurs.put("isbn",lv.getIsbn());
        valeurs.put("nom_livre",lv.getNom_livre());
        db = helper.getWritableDatabase();
        long id = db.insert(table_name,null, valeurs);
        if(id == -1)
            return false;
        else
            return true; }
    //Selection de toutes les informations
    public ArrayList getAllInformations()
    {
        ArrayList arraylist = new ArrayList();
        db = helper.getReadableDatabase();
        Cursor res = db.rawQuery("select * from livre", null);
        res.moveToFirst();
        while(res.isAfterLast() == false)
        {
            String t1 = res.getString(0);
            String t2 = res.getString(1);
            String t3 = res.getString(2);
            arraylist.add(t1+ "-------------"+t2+ "-------------"+t3);
            res.moveToNext();
        }
        return arraylist;
    }

    //Mise à jour des données
    public boolean update(String id, Livre lv)
    {
        db = helper.getWritableDatabase();
        ContentValues valeurs = new ContentValues();
        valeurs.put("isbn",lv.getIsbn());
        valeurs.put("nom_livre",lv.getNom_livre());
        db.update(table_name, valeurs,"id=?",new String[]{id});

        return true;
    }

    //suppression des livres
    public Integer delete(String id)
    {
        db = helper.getWritableDatabase();
        return db.delete(table_name,"id=?", new String[]{id});

    }
}
