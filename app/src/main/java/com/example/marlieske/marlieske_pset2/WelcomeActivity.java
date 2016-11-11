package com.example.marlieske.marlieske_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }


    public void toWords(View view) {
        // naar wordactivity, sluit dit scherm
        Intent toFillIn = new Intent(this, FillInActivity.class);
        startActivity(toFillIn);
        finish();
    }
}
