package com.hd.sonia.bibliothequehenripotier.activities;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.hd.sonia.bibliothequehenripotier.Callbacks.BooksCallBack;
import com.hd.sonia.bibliothequehenripotier.Managers.BookManager;
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

        final BookManager bookManager = new BookManager();
        bookManager.getBooks();

        final Context context = this;

        bookManager.booksCallBack = new BooksCallBack() {

            @Override
            public void onResponse(ArrayList<Book> booksList) {

                if(booksList != null)
                {
                    Intent intent = new Intent(context, MainActivity_.class);
                    intent.putParcelableArrayListExtra("myBooks", booksList);
                    startActivity(intent);

                }
                else {
                    MyAlertDialog.showLocationDialog(getString(R.string.title_error_server), getString(R.string.message_error_server), context);

                }
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                MyAlertDialog.showLocationDialog(getString(R.string.title_error_server), getString(R.string.message_error_server), context);

                Log.d("Error", t.getMessage());
            }
        };
    }
}

