package com.hd.sonia.bibliothequehenripotier.Managers;

import android.util.Log;

import com.hd.sonia.bibliothequehenripotier.Callbacks.BooksCallBack;
import com.hd.sonia.bibliothequehenripotier.Callbacks.OffersCallBack;
import com.hd.sonia.bibliothequehenripotier.models.Book;

import com.hd.sonia.bibliothequehenripotier.models.Offer;
import com.hd.sonia.bibliothequehenripotier.models.Offers;
import com.hd.sonia.bibliothequehenripotier.services.BookService;
import com.hd.sonia.bibliothequehenripotier.services.OffersService;
import com.hd.sonia.bibliothequehenripotier.services.ServiceGenerator;
import com.hd.sonia.bibliothequehenripotier.utils.CommandeMethods;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mac on 16/09/2016.
 */
public class PanierManager implements Callback<Offers> {

    public OffersCallBack offersCallBack;
    List<Book> bookList;

    public  void getPromotion(List<Book> books){
        OffersService offers = ServiceGenerator.getClient().create(OffersService.class);
        bookList = books;
        Call<Offers> callOffers= offers.getOffers(CommandeMethods.getIsbns(books));
        callOffers.enqueue(this);


    }


    @Override
    public void onResponse(Call<Offers> call, Response<Offers> response) {
        Offers offers = response.body();
        double TotalCommande = CommandeMethods.getTotalBooks(bookList);
        double remise = CommandeMethods.getBestPrice(offers,CommandeMethods.getTotalBooks(bookList));
        offersCallBack.onResponse(TotalCommande - remise);
    }

    @Override
    public void onFailure(Call<Offers> call, Throwable t) {

    }
}
