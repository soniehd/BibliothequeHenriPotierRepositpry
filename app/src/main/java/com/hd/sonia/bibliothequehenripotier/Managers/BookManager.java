package com.hd.sonia.bibliothequehenripotier.Managers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

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
public  class BookManager {

   static ArrayList<Book>  booksList;

    public static List<Book> getBooks(final Context context){

        BookService books = ServiceGenerator.getClient().create(BookService.class);
        Call<List<Book>> callBook = books.loadBooks();
        callBook.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                if (response.isSuccessful()) {
                    booksList = new ArrayList<Book>();
                    booksList = (ArrayList<Book>) response.body();
                    Log.d("success", "Number of books received: " + booksList.get(0).getTitle());
                    Intent intent = new Intent(context, MainActivity_.class);
                    intent.putParcelableArrayListExtra("myBooks", booksList);
                    context.startActivity(intent);


                } else {
                    MyAlertDialog.showLocationDialog(context.getString(R.string.title_error_server),context.getString(R.string.message_error_server),context);
                }
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {

                MyAlertDialog.showLocationDialog(context.getString(R.string.title_error_server), context.getString(R.string.message_error_server), context);

                Log.d("Error", t.getMessage());
            }
        });

        return booksList;

    }
}
