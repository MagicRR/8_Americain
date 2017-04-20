package com.example.karec.a8_americain.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.karec.a8_americain.R;

/**
 * Created by Karec on 18/04/2017.
 */

public class Jouer extends Activity{
    private Button listeViewParties;
    private Button creerPartie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jouer);

        listeViewParties = (Button) findViewById(R.id.buttonRejoindrePartie);
        listeViewParties.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), ListeViewParties.class);
                startActivity(intent);
            }
        });

        creerPartie = (Button) findViewById(R.id.buttonCreePartie);
        creerPartie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), SalonPartie.class);
                startActivity(intent);
            }
        });
    }

}
