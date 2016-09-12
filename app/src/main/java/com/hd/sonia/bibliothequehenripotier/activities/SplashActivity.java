package com.hd.sonia.bibliothequehenripotier.activities;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.hd.sonia.bibliothequehenripotier.R;
import com.hd.sonia.bibliothequehenripotier.models.Book;
import com.hd.sonia.bibliothequehenripotier.services.BookService;
import com.hd.sonia.bibliothequehenripotier.services.ServiceGenerator;
import com.hd.sonia.bibliothequehenripotier.utils.MyAlertDialog;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Fullscreen;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


@Fullscreen
@EActivity(R.layout.activity_splash)
public class SplashActivity extends AppCompatActivity {

    @AfterViews
    void nextActivity() {
        BookService books = ServiceGenerator.getClient().create(BookService.class);
        Call<List<Book>> callBook = books.loadBooks();
        callBook.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                if (response.isSuccessful()) {
                    ArrayList<Book> booksList = new ArrayList<Book>();
                    booksList = (ArrayList<Book>) response.body();
                    Log.d("success", "Number of books received: " + booksList.get(0).getTitle());
                    Intent intent = new Intent(SplashActivity.this, MainActivity_.class);
                    intent.putParcelableArrayListExtra("myBooks", booksList);
                    startActivity(intent);
                    finish();

                } else {
                    MyAlertDialog.showLocationDialog(getString(R.string.title_error_server), getString(R.string.message_error_server), SplashActivity.this);
                }
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {

                MyAlertDialog.showLocationDialog(getString(R.string.title_error_server), getString(R.string.message_error_server), SplashActivity.this);

                Log.d("Error", t.getMessage());
            }
        });


    }

}

