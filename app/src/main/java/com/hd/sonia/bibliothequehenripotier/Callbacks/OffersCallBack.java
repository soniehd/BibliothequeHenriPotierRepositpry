package com.hd.sonia.bibliothequehenripotier.Callbacks;

import com.hd.sonia.bibliothequehenripotier.models.Book;
import com.hd.sonia.bibliothequehenripotier.models.Offer;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

/**
 * Created by mac on 16/09/2016.
 */
public interface OffersCallBack {
    public void onResponse(double remise);
    public void onFailure(Call<Offer> call, Throwable t);
}
