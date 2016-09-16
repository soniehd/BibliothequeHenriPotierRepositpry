package com.hd.sonia.bibliothequehenripotier.Managers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.hd.sonia.bibliothequehenripotier.Callbacks.BooksCallBack;
import com.hd.sonia.bibliothequehenripotier.R;
import com.hd.sonia.bibliothequehenripotier.activities.MainActivity;
import com.hd.sonia.bibliothequehenripotier.activities.MainActivity_;
import com.hd.sonia.bibliothequehenripotier.activities.SplashActivity;
import com.hd.sonia.bibliothequehenripotier.models.Book;
import com.hd.sonia.bibliothequehenripotier.services.BookService;
import com.hd.sonia.bibliothequehenripotier.services.ServiceGenerator;
import com.hd.sonia.bibliothequehenripotier.utils.MyAlertDialog;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Sonia on 12/09/2016.
 */
public class BookManager implements Callback<List<Book>> {

    public BooksCallBack booksCallBack;

    public void  getBooks(){

        BookService books = ServiceGenerator.getClient().create(BookService.class);
        Call<List<Book>> callBook = books.loadBooks();
        callBook.enqueue(this);
    }

    @Override
    public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {

        ArrayList<Book> booksList = null;
        booksList = (ArrayList<Book>) response.body();
        booksCallBack.onResponse(booksList);

    }


    @Override
    public void onFailure(Call<List<Book>> call, Throwable t) {
        booksCallBack.onFailure(call,t);
    }
}
