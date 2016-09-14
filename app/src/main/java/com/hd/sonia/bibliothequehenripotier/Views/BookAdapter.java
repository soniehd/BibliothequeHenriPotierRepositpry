package com.hd.sonia.bibliothequehenripotier.Views;

import android.app.Activity;
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
import com.hd.sonia.bibliothequehenripotier.activities.MainActivity;
import com.hd.sonia.bibliothequehenripotier.fragments.DetailsLivreFragment;
import com.hd.sonia.bibliothequehenripotier.models.Book;

import java.util.List;

/**
 * Created by Sonia on 12/09/2016.
 */
public class BookAdapter extends  RecyclerView.Adapter<BookViewHolder> {

    List<Book> listBook;
    private Context context;

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_card,parent,false);
        return new BookViewHolder(view);
    }

    public BookAdapter(List<Book> list,Context context) {
        this.listBook = list;
        this.context = context;
    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, int position) {
        Book book = listBook.get(position);
        holder.bind(book);

        holder.setItemClickListner(new ItemClickListener(){
            @Override
            public void onItemClick(View v, int position) {
                Log.d("Click", "chui la"+listBook.get(position));
                DetailsLivreFragment dlFragment = new DetailsLivreFragment();
                Bundle bundle = new Bundle();
                bundle.putParcelable("bookSelected",listBook.get(position));
                dlFragment.setArguments(bundle);
                FragmentActivity activity = (FragmentActivity)context;
                FragmentTransaction t = activity.getSupportFragmentManager().beginTransaction();
                    t.replace(R.id.containerFragment, dlFragment);
                    t.addToBackStack(null);
                    t.commit();


            }
        });
    }

    @Override
    public int getItemCount() {
        return listBook.size();
    }
}
