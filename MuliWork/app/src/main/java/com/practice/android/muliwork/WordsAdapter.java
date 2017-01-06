package com.practice.android.muliwork;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by tao on 6/1/2017.
 */

public class WordsAdapter extends ArrayAdapter<Words> {

    public WordsAdapter(Activity context, ArrayList<Words> words){
        super(context, 0, words);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Words currentWords = getItem(position);

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentWords.getDefaultTranslation());

        TextView multiTextView = (TextView) listItemView.findViewById(R.id.multiwork_text_view);
        multiTextView.setText(currentWords.getMultiWorkTranslation());

        return listItemView;

    }
}
