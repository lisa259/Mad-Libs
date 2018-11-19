package com.example.mylenovo.lisabeek_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;

public class WordsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words);

        // OF DIT TOCH IN MAINACTIVITY?? KIJKEN WAT ER MEEGEGEVEN MOET WORDEN MET AANROEPEN STORY CLASS
        Intent intent = getIntent();
        String text = (String) intent.getSerializableExtra("story");

        Log.d("TESTTTTTTTTTT", text);

        try {
            InputStream inputText = getAssets().open(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
