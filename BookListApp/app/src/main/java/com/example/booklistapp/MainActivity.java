package com.example.booklistapp;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView connection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connection = (TextView) findViewById(R.id.connection);
        ConnectivityManager connectivityManager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            View progressBar = findViewById(R.id.loading);
            progressBar.setVisibility(View.GONE);
            connection.setText("Internet Connected ");
        } else {
            View progressBar = findViewById(R.id.loading);
            progressBar.setVisibility(View.GONE);
            connection.setText("No Internet access ");
        }
    }
    public void search(View v)
    {
        EditText Title=(EditText) findViewById(R.id.editText);
        connection = (TextView) findViewById(R.id.connection);
        ConnectivityManager connectivityManager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            String Title1= Title.getText().toString();
            Intent intent = new Intent(MainActivity.this,BookItem.class);
            intent.putExtra("title",Title1);
                startActivity(intent);
        } else {
            View progressBar = findViewById(R.id.loading);
            progressBar.setVisibility(View.GONE);
            connection.setText("No Internet access ");
        }
    }

}
