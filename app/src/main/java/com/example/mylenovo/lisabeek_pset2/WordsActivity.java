package com.example.mylenovo.lisabeek_pset2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class WordsActivity extends AppCompatActivity {

    public TextView tv_count;
    public TextView tv_word;
    public EditText et_input;
    public Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words);

        // Retrieve Story object created in MainActivity
        Intent intent = getIntent();
        story = (Story) intent.getSerializableExtra("story");

        // Set textview to show how much words are left
        tv_count = (TextView) findViewById(R.id.x_words);
        tv_count.setText(story.getPlaceholderRemainingCount() + " word(s) left");

        // Set textview to tell user what kind of word must be provided
        tv_word = (TextView) findViewById(R.id.word_kind);
        tv_word.setText("Please type a/an " + story.getNextPlaceholder());

        // Set example text in textbox to tell user what kind of word must be provided
        et_input = (EditText) findViewById(R.id.word_input);
        et_input.setHint(story.getNextPlaceholder());
    }

    // When clicked on "ok"
    public void okClicked(View view){
        // Get users input
        String input = et_input.getText().toString();

        // Set information for Toast(little message) pop-up
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        CharSequence text = "Must provide a word.";

        // Check if input isn't empty
        if (!input.equals("")) {
            text = "Great! Keep going!";
            // Put word(input) in text
            story.fillInPlaceholder(input);
        }

        // If all words are provided
        if (story.getPlaceholderRemainingCount() == 0) {
            // Change to StoryActiviry class, providing Story text
            Intent intent = new Intent(WordsActivity.this, StoryActivity.class);
            intent.putExtra("text", story.toString());
            startActivity(intent);
        } else {
            // Update textviews and example text
            et_input.setText("");
            et_input.setHint(story.getNextPlaceholder());
            tv_count.setText(story.getPlaceholderRemainingCount() + " word(s) left");
            tv_word.setText("Please type a/an " + story.getNextPlaceholder());

            // Make toast pop up on the screen
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

    }
}
