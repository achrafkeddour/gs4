package com.example.livre_database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    BaseSQLite db = new BaseSQLite(this);
    LivreOperations lvo = new LivreOperations(db);

    EditText isbn, nom_livre, id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isbn = (EditText) findViewById(R.id.et1);
        nom_livre = (EditText) findViewById(R.id.et2);
        id = (EditText) findViewById(R.id.et3);

    }

    //ajouter un livre
    public void btn_ajouter(View view) {
        if((isbn.getText().toString()).isEmpty() && (nom_livre.getText().toString()).isEmpty())
        { Toast.makeText(this, "Veuillez remplir l'ISBN et le nom du livre !", Toast.LENGTH_SHORT).show(); }
        else {
            int Isbn = Integer.parseInt(isbn.getText().toString());
            String Nom_livre = nom_livre.getText().toString();
            Livre lv = new Livre(Isbn, Nom_livre);
            Boolean result = lvo.insert(lv);
            if (result == true) {
                Toast.makeText(this, "Livre ajouté !", Toast.LENGTH_SHORT).show();
                isbn.setText("");
                nom_livre.setText("");
            } else {
                Toast.makeText(this, "Erreur !", Toast.LENGTH_SHORT).show();
            }
        }
    }


    //renouvler un livre
    public void btn_renouveler(View view) {
        if((isbn.getText().toString()).isEmpty() && (nom_livre.getText().toString()).isEmpty() && id.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Veuillez indiquer l'ID du livre pour changer l'ISBN et le nom !", Toast.LENGTH_SHORT).show();
        }
        else {
            int Isbn = Integer.parseInt(isbn.getText().toString());
            String Nom_livre = nom_livre.getText().toString();
            String ID = id.getText().toString();
            Livre lv = new Livre(Isbn, Nom_livre);

            boolean result = lvo.update(ID, lv);
            if (result == true) {
                Toast.makeText(this, "Informations modifiées !", Toast.LENGTH_SHORT).show();
                isbn.setText("");
                nom_livre.setText("");
                id.setText("");
            } else {
                Toast.makeText(this, "Erreur !", Toast.LENGTH_SHORT).show();
            }
        }
    }

    //Supprimer un livre
    public void btn_supprimer(View view) {
        if((id.getText().toString()).isEmpty())
        {
            Toast.makeText(this, "Veuillez indiquez l'ID pour supprimer le livre", Toast.LENGTH_SHORT).show();
        }
        else {
        String ID = id.getText().toString();
        Integer result = lvo.delete(ID);
        if(result > 0)
        {
            Toast.makeText(this, "Livre supprimé !", Toast.LENGTH_SHORT).show();
            //showData();
            id.setText("");
        }
        else{
            Toast.makeText(this, "Erreur !", Toast.LENGTH_SHORT).show();
        }
    }}

    //afficher tous les livres
    public void btn_afficher(View view) {
        Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
        startActivity(intent);
    }

}
