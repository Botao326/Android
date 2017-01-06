package com.practice.android.muliwork;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Words> words = new ArrayList<Words>();

        words.add(new Words("red", "wetetti"));
        words.add(new Words("green", "chokokki"));
        words.add(new Words("brown", "takaakki"));
        words.add(new Words("gray", "topoppi"));
        words.add(new Words("black", "kululli"));
        words.add(new Words("white", "kelelli"));
        words.add(new Words("dusty yellow", "ṭopiisә"));
        words.add(new Words("mustard yellow", "chiwiitә"));

        WordsAdapter adapter = new WordsAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
