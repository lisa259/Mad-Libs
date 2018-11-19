package com.example.mylenovo.lisabeek_pset2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            InputStream is = getAssets().open("madlib0_simple.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
