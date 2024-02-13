package com.mavie.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class JeuActivity extends AppCompatActivity {
    TextView tvTitre;
    ImageView imgv1;
    ImageView imgv2;
    ImageView imgv3;
    ImageView imgv4;
    int positionBonJoueur=0;
    int indexImgInImgv1, indexImgInImgv2, indexImgInImgv3, indexImgInImgv4;

    int imgJoueurIdList[] = {
            R.drawable.eden,
            R.drawable.etoo,
            R.drawable.gavi,
            R.drawable.mane,
            R.drawable.messi,
            R.drawable.osimhen,
            R.drawable.sessegnon,
            R.drawable.yamal,
            R.drawable.zidane,
            R.drawable.zlatan

    };
    List<String> nomJoueurList = Arrays.asList(
            "Eden Hazard",
            "Samuel Eto'o",
            "Gavi Pablo",
            "Sadio Mané",
            "Lionel Messi",
            "Victor Osimhen",
            "Stéphane Sessegnon",
            "Lamine Yamal",
            "Zinédine Zidane",
            "Zlatan Ibrahimovic"
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu);
        tvTitre = findViewById(R.id.tv_titre);
        imgv1 = findViewById(R.id.imgv_1);
        imgv2 = findViewById(R.id.imgv_2);
        imgv3 = findViewById(R.id.imgv_3);
        imgv4 = findViewById(R.id.imgv_4);


        imgv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(positionBonJoueur==0){
                    Toast.makeText(JeuActivity.this, "Gagné", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(JeuActivity.this, "Perdu", Toast.LENGTH_SHORT).show();

                }
                genererTousJoueur();

            }
        });

        imgv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(positionBonJoueur==1){
                    Toast.makeText(JeuActivity.this, "Gagné", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(JeuActivity.this, "Perdu", Toast.LENGTH_SHORT).show();

                }
                genererTousJoueur();

            }
        });
        imgv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(positionBonJoueur==2){
                    Toast.makeText(JeuActivity.this, "Gagné", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(JeuActivity.this, "Perdu", Toast.LENGTH_SHORT).show();

                }
                genererTousJoueur();
            }
        });
        imgv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(positionBonJoueur==3){
                    Toast.makeText(JeuActivity.this, "Gagné", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(JeuActivity.this, "Perdu", Toast.LENGTH_SHORT).show();

                }
                genererTousJoueur();
            }
        });


    }

    void genererJoueur(ImageView imgv) {
        Random random = new Random();
        int nbrTire = random.nextInt(imgJoueurIdList.length - 1);
        imgv.setImageResource(imgJoueurIdList[nbrTire]);
    }

    void genererBonJoueur() {
        Random random = new Random();
        int indexBonJoueur = random.nextInt(imgJoueurIdList.length - 1);
         positionBonJoueur = random.nextInt(3);
        tvTitre.setText("Trouves "+ positionBonJoueur+ " - " + nomJoueurList.get(indexBonJoueur));
        switch (positionBonJoueur) {
            case 0:
                imgv1.setImageResource(imgJoueurIdList[indexBonJoueur]);
                genererJoueur(imgv2);
                genererJoueur(imgv3);
                genererJoueur(imgv4);
                break;
            case 1:
                imgv2.setImageResource(imgJoueurIdList[indexBonJoueur]);
                genererJoueur(imgv1);
                genererJoueur(imgv3);
                genererJoueur(imgv4);
                break;
            case 2:
                imgv3.setImageResource(imgJoueurIdList[indexBonJoueur]);
                genererJoueur(imgv1);
                genererJoueur(imgv2);
                genererJoueur(imgv4);
                break;
            case 3:
                imgv4.setImageResource(imgJoueurIdList[indexBonJoueur]);
                genererJoueur(imgv1);
                genererJoueur(imgv2);
                genererJoueur(imgv3);
                break;


        }


    }

    void genererTousJoueur() {
        genererBonJoueur();
        //genererJoueur(imgv1);
       /* genererJoueur(imgv2);
        genererJoueur(imgv3);
        genererJoueur(imgv4);*/
    }


}