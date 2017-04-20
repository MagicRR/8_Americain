package com.example.rrich.a8_americain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button buttonRandomiser;


    //private Button buttonRandomiser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonRandomiser = (Button) findViewById(R.id.buttonRandomiser);
        buttonRandomiser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Randomiser.class);
                startActivity(intent);
            }
        });
    }


}
