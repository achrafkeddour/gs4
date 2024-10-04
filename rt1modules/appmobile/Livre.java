package com.example.livre_database;

public class Livre {
    private int id;
    private int isbn;
    private String nom_livre;
    public Livre(int isbn, String nom_livre) {
        this.isbn = isbn;
        this.nom_livre = nom_livre;}
    public int getId() {
        return id;
    }
    public int getIsbn() {
        return isbn;
    }
    public String getNom_livre() {
        return nom_livre;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }
    public void setNom_livre(String nom_livre) {
        this.nom_livre = nom_livre;
    }
    }
