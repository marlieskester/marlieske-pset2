package com.example.marlieske.marlieske_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class finalActivity extends AppCompatActivity {

    String tekst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        // laad de tekst van het verhaaltje
        Intent goToStory = getIntent();
        tekst = goToStory.getStringExtra("tekst");
        TextView TVStory = (TextView) findViewById(R.id.TVSTory);
        TVStory.setText(tekst);
    }

    public void backToBegin(View view) {
        // naar wordactivity, nieuw verhaaltje
        Intent toBegin = new Intent(this, WelcomeActivity.class);
        startActivity(toBegin);
        finish();
    }
}
