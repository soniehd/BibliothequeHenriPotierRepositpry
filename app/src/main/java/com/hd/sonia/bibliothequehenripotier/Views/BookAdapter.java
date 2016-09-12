package com.hd.sonia.bibliothequehenripotier.Views;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hd.sonia.bibliothequehenripotier.R;
import com.hd.sonia.bibliothequehenripotier.models.Book;

import java.util.List;

/**
 * Created by Sonia on 12/09/2016.
 */
public class BookAdapter extends  RecyclerView.Adapter<BookViewHolder> {

    List<Book> listBook;

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_card,parent,false);
        return new BookViewHolder(view);
    }

    public BookAdapter(List<Book> list) {
        this.listBook = list;
    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, int position) {
        Book book = listBook.get(position);
        holder.bind(book);
    }

    @Override
    public int getItemCount() {
        return listBook.size();
    }
}
