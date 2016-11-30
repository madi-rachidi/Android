package com.example.madi.coach.vue;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.madi.coach.R;
import com.example.madi.coach.controleur.Controle;
import com.example.madi.coach.modele.Profil;

public class MainActivity extends AppCompatActivity {
    private EditText txtPoids;
    private TextView txtTaille;
    private TextView txtAge;
    private RadioButton rdHomme;
    private TextView lblIMG;
    private ImageView imgSmiley;
    private Controle controle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);// R représente le dossier res
        init();
    }

    public void init() {
        txtPoids = (EditText) findViewById(R.id.txtPoids); //récupérer le poids à partir de son id
        txtTaille = (TextView) findViewById(R.id.txtTaille);//récupérer la taille à partir de son id
        txtAge = (TextView) findViewById(R.id.txtAge);//récupérer l'age à partir de son id
        rdHomme = (RadioButton) findViewById(R.id.rdHomme);//récupérer le rdhomme à partir de son id
        lblIMG = (TextView) findViewById(R.id.lblIMG);
        imgSmiley = (ImageView) findViewById(R.id.imgSmiley);//récupérer l'image à partir de son id
        controle = controle.getInstance();
        ecouteCalcul();
    }

    public void ecouteCalcul() {
        ((Button) findViewById(R.id.btnCalc)).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {

                // Toast.makeText(MainActivity.this, "test", Toast.LENGTH_SHORT).show(); ligne de test
                Integer poids = 0;
                Integer taille = 0;
                Integer age = 0;
                Integer sexe =0;

                try {
                    poids = Integer.parseInt(txtPoids.getText().toString());
                    taille = Integer.parseInt(txtTaille.getText().toString());
                    age = Integer.parseInt(txtAge.getText().toString());
                } catch (Exception  e) {

                }
                if (rdHomme.isChecked() == true) {
                    sexe = 1;
                }
                if (poids == 0 || age == 0 || taille == 0) {

                    Toast.makeText(MainActivity.this, "Veuillez saisir tous les champs", Toast.LENGTH_SHORT).show();

                } else {
                    affichResult(poids, taille, age, sexe);
                }
            }
        });

    }

    public void affichResult(Integer poids, Integer taille, Integer age, Integer sexe) {
        controle.creerProfil(poids, taille, age, sexe);
        String message = controle.getMessage();
        float img = controle.getImg();

        if (message == "trop faible") {

            imgSmiley.setImageResource(R.drawable.maigre);
            lblIMG.setText( "IMG trop faible");
            Toast.makeText(MainActivity.this, String.format("%.01f", img) + " : IMG trop faible", Toast.LENGTH_SHORT).show();//affiche la valeur de l'img suivant le cas

            lblIMG.setTextColor(Color.RED);
        }
        if (message == "trop élevé") {

            imgSmiley.setImageResource(R.drawable.graisse);
            lblIMG.setText( "IMG trop élevé");
            Toast.makeText(MainActivity.this, String.format("%.01f", img) + " : IMG trop élevé", Toast.LENGTH_SHORT).show();

            lblIMG.setTextColor(Color.RED);
        }
        if (message == "super ! c'est normal"){

            imgSmiley.setImageResource(R.drawable.normal);
            lblIMG.setText( "IMG normal");
            Toast.makeText(MainActivity.this, String.format("%.01f", img) + "IMG normale", Toast.LENGTH_SHORT).show();

            lblIMG.setTextColor(Color.GREEN);

        }
        lblIMG.setText("IMG "+message);

    }
}