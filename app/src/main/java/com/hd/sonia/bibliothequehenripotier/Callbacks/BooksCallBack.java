package com.hd.sonia.bibliothequehenripotier.Callbacks;

import com.hd.sonia.bibliothequehenripotier.models.Book;
import com.hd.sonia.bibliothequehenripotier.models.Offers;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by mac on 16/09/2016.
 */
public interface BooksCallBack {

    public void onResponse(ArrayList<Book> booksList);
    public void onFailure(Call<List<Book>> call, Throwable t);
}
