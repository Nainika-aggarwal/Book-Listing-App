package com.example.booklistapp;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BookItem extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Book>> {
    private TextView found;
    String getLink = "";
    private String URL = "";
    private String titles;
    private String authors;
    private int i=0;
    private BookAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_item);
        Intent intent = getIntent();
        titles= intent.getStringExtra("title");
        getLink = titles.toString();
        URL ="https://www.googleapis.com/books/v1/volumes?q="+getLink;
        ListView listing = (ListView) findViewById(R.id.listView);
        found = (TextView) findViewById(R.id.found);
        listing.setEmptyView(found);
        adapter = new BookAdapter(this , new ArrayList<Book>());
        listing.setAdapter(adapter);
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            LoaderManager loaderManager = getLoaderManager();
            loaderManager.initLoader(1, null, this);
        } else {
            View loadingIndicator = findViewById(R.id.loading1);
            loadingIndicator.setVisibility(View.GONE);
            found.setText("No Internet");
        }
    }
    @Override
    public Loader<List<Book>> onCreateLoader(int id, Bundle args) {
        return new BookLoader(this, URL);
    }

    @Override
    public void onLoadFinished(Loader<List<Book>> loader, List<Book> data) {
        View loaderss = findViewById(R.id.loading1);
        loaderss.setVisibility(View.GONE);
        found.setText("Books Unavailable");
        adapter.clear();

        if ( data!= null && !data.isEmpty()) {
            adapter.addAll(data);
        }

    }

    @Override
    public void onLoaderReset(Loader<List<Book>> loader) {
        adapter.clear();
    }

}
