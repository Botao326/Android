package com.practice.android.muliwork;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Words> words = new ArrayList<Words>();

        words.add(new Words("father", "әpә"));
        words.add(new Words("mother", "әṭa"));
        words.add(new Words("son", "angsi"));
        words.add(new Words("daughter", "tune"));
        words.add(new Words("older brother", "taachi"));
        words.add(new Words("younger brother", "chalitti"));
        words.add(new Words("older sister", "teṭe"));
        words.add(new Words("younger sister", "kolliti"));
        words.add(new Words("grandmother", "ama"));
        words.add(new Words("grandfather", "paapa"));

        WordsAdapter adapter = new WordsAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
