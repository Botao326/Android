package com.practice.android.muliwork;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Words> words = new ArrayList<Words>();

        words.add(new Words("One", "lotti"));
        words.add(new Words("Two", "ottiko"));
        words.add(new Words("Three", "tolookosu"));
        words.add(new Words("Four", "oyyisa"));
        words.add(new Words("Five", "massakka"));
        words.add(new Words("Six", "temmokka"));
        words.add(new Words("Seven", "kenekaku"));
        words.add(new Words("Eight", "kawinta"));
        words.add(new Words("Nine", "wo'e"));
        words.add(new Words("Ten", "na'aacha"));

        WordsAdapter adapter = new WordsAdapter(this, words);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
