package com.mavie.myapplication;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class JeuActivity extends AppCompatActivity {
    TextView tvTitre;
    TextView tvScore;
    TextView tvNomJoueur;
    ImageView imgv1;
    ImageView imgv2;
    ImageView imgv3;
    ImageView imgv4;
    int positionBonJoueur = 0;
    int indexImgInImgv1, indexImgInImgv2, indexImgInImgv3, indexImgInImgv4;
    int score = 0;
    MediaPlayer backPlayer;
    int[] imgJoueurIdList = {
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
        tvNomJoueur = findViewById(R.id.tv_nom_joueur);
        tvScore = findViewById(R.id.tv_score);

        imgv1 = findViewById(R.id.imgv_1);
        imgv2 = findViewById(R.id.imgv_2);
        imgv3 = findViewById(R.id.imgv_3);
        imgv4 = findViewById(R.id.imgv_4);

        String prenom = getIntent().getStringExtra("user_name");
        String mail = getIntent().getStringExtra("user_mail");

        tvTitre.setText(prenom);

        genererTousJoueur();
        backPlayer = MediaPlayer.create(this, R.raw.back_sound);
        backPlayer.setLooping(true);
        backPlayer.setVolume(0.3f, 0.3f);
        backPlayer.start();
        imgv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (positionBonJoueur == 0) {
                    notifyGagner();
                } else {
                    notifyPerdu();
                }
                genererTousJoueur();

            }
        });

        imgv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (positionBonJoueur == 1) {
                    notifyGagner();
                } else {
                    notifyPerdu();
                }
                genererTousJoueur();

            }
        });
        imgv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (positionBonJoueur == 2) {
                    notifyGagner();
                } else {
                    notifyPerdu();
                }
                genererTousJoueur();
            }
        });
        imgv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (positionBonJoueur == 3) {
                    notifyGagner();
                } else {
                    notifyPerdu();
                }
                genererTousJoueur();
            }
        });


    }

    int genererJoueur(ImageView imgv) {
        Random random = new Random();
        int nbrTire = -1;
        do {
            nbrTire = random.nextInt(imgJoueurIdList.length - 1);

        } while (nbrTire == indexImgInImgv1 || nbrTire == indexImgInImgv2 || nbrTire == indexImgInImgv3 || nbrTire == indexImgInImgv4);

        imgv.setImageResource(imgJoueurIdList[nbrTire]);
        return nbrTire;
    }

    void genererBonJoueur() {
        Random random = new Random();
        int indexBonJoueur = random.nextInt(imgJoueurIdList.length - 1);
        positionBonJoueur = random.nextInt(3);
        tvNomJoueur.setText(" " + nomJoueurList.get(indexBonJoueur));

        switch (positionBonJoueur) {
            case 0:
                imgv1.setImageResource(imgJoueurIdList[indexBonJoueur]);
                indexImgInImgv1 = indexBonJoueur;
                indexImgInImgv2 = genererJoueur(imgv2);
                indexImgInImgv3 = genererJoueur(imgv3);
                indexImgInImgv4 = genererJoueur(imgv4);
                break;
            case 1:
                imgv2.setImageResource(imgJoueurIdList[indexBonJoueur]);
                indexImgInImgv2 = indexBonJoueur;
                indexImgInImgv1 = genererJoueur(imgv1);
                indexImgInImgv3 = genererJoueur(imgv3);
                indexImgInImgv4 = genererJoueur(imgv4);
                break;
            case 2:
                imgv3.setImageResource(imgJoueurIdList[indexBonJoueur]);
                indexImgInImgv3 = indexBonJoueur;

                indexImgInImgv1 = genererJoueur(imgv1);
                indexImgInImgv2 = genererJoueur(imgv2);
                indexImgInImgv4 = genererJoueur(imgv4);
                break;
            case 3:
                imgv4.setImageResource(imgJoueurIdList[indexBonJoueur]);
                indexImgInImgv4 = indexBonJoueur;

                indexImgInImgv1 = genererJoueur(imgv1);
                indexImgInImgv2 = genererJoueur(imgv2);
                indexImgInImgv3 = genererJoueur(imgv3);
                break;
        }


    }

    void genererTousJoueur() {
        genererBonJoueur();
        MediaPlayer player = new MediaPlayer();
        //genererJoueur(imgv1);
       /* genererJoueur(imgv2);
        genererJoueur(imgv3);
        genererJoueur(imgv4);*/
    }

    void notifyGagner() {
        score += 5;
        tvScore.setText("Score : " + score);

        MediaPlayer winPlayer = MediaPlayer.create(this, R.raw.win);
        winPlayer.start();
    }

    void notifyPerdu() {
        MediaPlayer lostPlayer = MediaPlayer.create(this, R.raw.loose);
        lostPlayer.start();

    }
}