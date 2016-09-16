package com.hd.sonia.bibliothequehenripotier.utils;

import com.hd.sonia.bibliothequehenripotier.models.Book;
import com.hd.sonia.bibliothequehenripotier.models.Offer;
import com.hd.sonia.bibliothequehenripotier.models.Offers;

import java.util.List;

/**
 * Created by mac on 16/09/2016.
 */
public class CommandeMethods {

    public static double getBestPrice(Offers offers, double TotalCommande){
        double offerMinus = 0;
        double offerPercentage = 0;
        double offerSlice = 0;
        for (Offer offer:offers.getOffers()) {
            switch (offer.type){
                case "percenrage": offerPercentage = TotalCommande * offer.value;break;
                case "minus": offerMinus = TotalCommande - offer.value;break;
                case "slice" : offerSlice = (TotalCommande%offer.sliceValue)*offer.value;break;
            }

        }
        return HighValue(offerMinus, offerPercentage, offerSlice);
    }

    public static double HighValue(double offerMinus,double offerPercentage,double offerSlice){
        double highVal = offerMinus;
        if(offerMinus<offerPercentage)
            highVal = offerPercentage;
        else if(offerMinus<offerSlice)
            highVal=offerSlice;
        return highVal;
    }

    public static double getTotalBooks(List<Book> books){
        double total = 0;
        for (Book book:books) {
            total+=Double.parseDouble(book.getPrice());
        }
        return  total;
    }
    public static String getIsbns(List<Book> books)
    {   String isbns="";
        for (Book book:books) {
            isbns += "," + book.getIsbn();
            }
        return isbns;
    }
}
