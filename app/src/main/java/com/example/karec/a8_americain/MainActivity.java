package com.example.karec.a8_americain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.karec.a8_americain.Activity.Jouer;

public class MainActivity extends AppCompatActivity {

    private Button jouerAct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jouerAct = (Button) findViewById(R.id.buttonJouer);
        jouerAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), Jouer.class);
                startActivity(intent);
            }
        });
    }
}
