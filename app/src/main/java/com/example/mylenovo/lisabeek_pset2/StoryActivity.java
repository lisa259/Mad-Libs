package com.example.mylenovo.lisabeek_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import java.io.InputStream;

public class StoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        // Retrieve Story text made in  WordsActivity
        Intent intent = getIntent();
        String text = (String) intent.getSerializableExtra("text");

        // Set text to textview, using html to make sure users input shows up bold
        TextView tv_text = (TextView) findViewById(R.id.story_text);
        tv_text.setText(Html.fromHtml(text, Html.FROM_HTML_MODE_LEGACY));
    }

    // When clicked on "create another story"
    public void backClicked(View view){
        // Back to startscreen(MainActivity)
        Intent intent = new Intent(StoryActivity.this, MainActivity.class);
        startActivity(intent);
    }

    // When clicked on phones back-button
    public void onBackPressed() {
        // Back to startscreen(MainActivity) instead of WordsActivity
        Intent intent = new Intent(StoryActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
