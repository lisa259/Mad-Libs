package com.example.mylenovo.lisabeek_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import android.widget.AdapterView.OnItemSelectedListener;

public class MainActivity extends AppCompatActivity {

//    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void buttonClicked(View view) {
        Spinner spinner = (Spinner)findViewById(R.id.text_spinner);
        String story = spinner.getSelectedItem().toString();
        String text = "";
        switch (story){
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

        Intent intent = new Intent(MainActivity.this, WordsActivity.class);
        intent.putExtra("story", text);
        startActivity(intent);





    }

}

