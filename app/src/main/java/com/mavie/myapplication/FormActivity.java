package com.mavie.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class FormActivity extends AppCompatActivity {
    EditText edtMail, edtPrenom;
    Button btComencer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        edtMail = findViewById(R.id.edt_mail);
        edtPrenom = findViewById(R.id.edt_prenoms);
        btComencer = findViewById(R.id.bt_commencer);


        btComencer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FormActivity.this, JeuActivity.class);
                String nom = edtPrenom.getText().toString();
                intent.putExtra("user_name", nom);
                intent.putExtra("user_mail", edtMail.getText().toString());
                startActivity(intent);
            }
        });
    }
}