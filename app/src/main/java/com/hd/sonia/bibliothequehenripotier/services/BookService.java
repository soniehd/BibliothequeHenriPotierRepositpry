package com.hd.sonia.bibliothequehenripotier.services;

import com.hd.sonia.bibliothequehenripotier.models.Book;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


/**
 * Created by Sonia on 09/09/2016.
 */

public interface BookService {
    @GET("/books")
    Call<List<Book>> loadQuestions();
}

