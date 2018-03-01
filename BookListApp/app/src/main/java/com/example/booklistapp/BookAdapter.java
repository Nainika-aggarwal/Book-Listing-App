package com.example.booklistapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Nainika on 8/26/2017.
 */

public class BookAdapter extends ArrayAdapter<Book> {
    public BookAdapter(Context context, List<Book> books) {
        super(context, 0, books);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listitem = convertView;
        if (listitem == null) {
            listitem = LayoutInflater.from(getContext()).inflate(
                    R.layout.list, parent, false);
        }
        Book current = getItem(position);
        TextView title = (TextView) listitem.findViewById(R.id.titles);
        title.setText(current.getTitle());
        TextView author = (TextView) listitem.findViewById(R.id.author);
        author.setText(current.getAuthor());
        TextView publisher = (TextView) listitem.findViewById(R.id.publisher);
        publisher.setText(current.getPublisher());
        TextView description = (TextView) listitem.findViewById(R.id.desc);
        description.setText(current.getDescription());
        return listitem;
    }
}
