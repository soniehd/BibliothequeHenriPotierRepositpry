package com.hd.sonia.bibliothequehenripotier.activities;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

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
        BookManager.getBooks(this);
    }

}

