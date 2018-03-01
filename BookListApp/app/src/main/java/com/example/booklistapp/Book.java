package com.example.booklistapp;

/**
 * Created by Nainika on 8/26/2017.
 */

public class Book {
    public String mTitle;
    public String mAuthor;
    public  String mDescription;
    public  String mPublisher;

    public Book(String Title, String Author, String publisher, String  description) {
        mTitle = Title;
        mAuthor = Author;
        mPublisher = publisher;
        mDescription = description;

    }
    public String getTitle() {
        return mTitle;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public String getPublisher() {
        return mPublisher;
    }

    public String getDescription() {
        return mDescription;
    }

}