package com.example.marlieske.marlieske_pset2;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


public class FillInActivity extends AppCompatActivity {

    Story verhaaltje;
    EditText ETword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_in);
        readIn();
        insertWord();
    };

    public void readIn() {
        AssetManager am = this.getAssets();
        try {
            InputStream stream = am.open("madlib3_clothes.txt");
            verhaaltje = new Story(stream);
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("verhaaltje", "findasset failed" );
        }
    }

    public void insertWord() {
        // laat de juiste tekst zien
        TextView TVWordtype = (TextView) findViewById(R.id.TVWordType);
        TVWordtype.setText("Please enter a " + verhaaltje.getNextPlaceholder());
        TextView TVWordsleft = (TextView) findViewById(R.id.TVWordsLeft);
        TVWordsleft.setText("Only " + verhaaltje.getPlaceholderRemainingCount() + " left!");
        ETword = (EditText) findViewById(R.id.ETWord);
        ETword.setText("");
        ETword.setHint("Your word");
    }

    private boolean isEmpty(EditText et) {
        return et.getText().toString().trim().length() == 0;
    }

    public void toNext(View view) {
        // als het klaar is: naar verhaaltje
        if (verhaaltje.isFilledIn()) {
            String text = verhaaltje.toString();
            Intent goToStory = new Intent(this, finalActivity.class);
            goToStory.putExtra("tekst", text);
            startActivity(goToStory);
            finish();
            verhaaltje.clear();
        }
        // als er geen woord is ingevuld: error
        else if (isEmpty(ETword)) {
            Toast.makeText(this, "Please enter your word", Toast.LENGTH_SHORT).show();
        }
        // anders: laad insertword voor volgend woord, vul huidig woord in
        else {
            verhaaltje.fillInPlaceholder(ETword.getText().toString());
            insertWord();
        }
    }
}