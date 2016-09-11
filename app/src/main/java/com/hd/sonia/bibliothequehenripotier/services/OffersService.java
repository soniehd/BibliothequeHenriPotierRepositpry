package com.hd.sonia.bibliothequehenripotier.services;

import com.hd.sonia.bibliothequehenripotier.models.Offer;
import com.hd.sonia.bibliothequehenripotier.models.Offers;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Sonia on 10/09/2016.
 */
public interface OffersService {
    @GET("books/{isbn}/commercialOffers")
    Call<Offers> getOffers(@Path("isbn") String isbn);
}
