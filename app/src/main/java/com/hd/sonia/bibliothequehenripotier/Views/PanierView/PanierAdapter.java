package com.hd.sonia.bibliothequehenripotier.Views.PanierView;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hd.sonia.bibliothequehenripotier.R;
import com.hd.sonia.bibliothequehenripotier.Views.BookView.ItemClickListener;
import com.hd.sonia.bibliothequehenripotier.fragments.DetailsLivreFragment;
import com.hd.sonia.bibliothequehenripotier.models.Book;

import java.util.List;

/**
 * Created by Sonia on 12/09/2016.
 */
public class PanierAdapter extends  RecyclerView.Adapter<PanierViewHolder> {

    List<Book> listBook;


    @Override
    public PanierViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_card_details,parent,false);
        return new PanierViewHolder(view);
    }

    public PanierAdapter(List<Book> list, Context context) {
        this.listBook = list;

    }

    @Override
    public void onBindViewHolder(PanierViewHolder holder, int position) {
        Book book = listBook.get(position);
        holder.bind(book);
          }

    @Override
    public int getItemCount() {
        return listBook.size();
    }
}
