package com.example.mylenovo.lisabeek_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    public Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    // When button "get started" clicked
    public void buttonClicked(View view) {
        // Get selected item from spinner
        Spinner spinner = (Spinner)findViewById(R.id.text_spinner);
        String story_name = spinner.getSelectedItem().toString();
        String text = "";

        // Check with story was chosen and safe the name of corresponding text file as string
        switch (story_name){
            case "Simple":      text = "madlib0_simple.txt";
                                break;
            case "Tarzan":      text = "madlib1_tarzan.txt";
                                break;
            case "University":  text = "madlib2_university.txt";
                                break;
            case "Clothes":     text = "madlib3_clothes.txt";
                                break;
            case "Dance":       text = "madlib4_dance.txt";
                                break;

        }

        try {
            // Open text file and create new Story object
            InputStream inputText = getAssets().open(text);
            story = new Story(inputText);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Change to WordsActivity class, and pass the created Story object
        Intent intent = new Intent(MainActivity.this, WordsActivity.class);
        intent.putExtra("story", story);
        startActivity(intent);
    }
}

