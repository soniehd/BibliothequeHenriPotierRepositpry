package com.hd.sonia.bibliothequehenripotier.Managers;

import android.util.Log;

import com.hd.sonia.bibliothequehenripotier.models.Book;

import com.hd.sonia.bibliothequehenripotier.models.Offers;
import com.hd.sonia.bibliothequehenripotier.services.BookService;
import com.hd.sonia.bibliothequehenripotier.services.OffersService;
import com.hd.sonia.bibliothequehenripotier.services.ServiceGenerator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mac on 16/09/2016.
 */
public class PanierManager implements Callback<BookService> {



    public static void getPromotion(List<Book> books, final Callback<Book> bookCallback){
        OffersService offers = ServiceGenerator.getClient().create(OffersService.class);
        String isbns = "";

    }


    @Override
    public void onResponse(Call<BookService> call, Response<BookService> response) {
        if(response.isSuccessful()){
            Offers offers = (Offers) response.body();
            Log.d("success", "Offers " + offers.getOffers().size());
        }
    }

    @Override
    public void onFailure(Call<BookService> call, Throwable t) {

    }
}
