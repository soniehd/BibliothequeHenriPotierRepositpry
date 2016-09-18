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
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hd.sonia.bibliothequehenripotier.R;
import com.hd.sonia.bibliothequehenripotier.Views.BookView.ItemClickListener;
import com.hd.sonia.bibliothequehenripotier.fragments.DetailsLivreFragment;
import com.hd.sonia.bibliothequehenripotier.models.Book;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Sonia on 12/09/2016.
 */
public class PanierAdapter extends ArrayAdapter<Book> {

    List<Book> listBook;
    private final int newsItemLayoutResource;


    public PanierAdapter(final Context context, final int newsItemLayoutResource) {
        super(context, 0);
        this.newsItemLayoutResource = newsItemLayoutResource;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final View view = getWorkingView(convertView);
        final PanierViewHolder viewHolder = getViewHolder(view);
        final Book book = getItem(position);

        viewHolder.titleView.setText(book.getTitle());
        viewHolder.subTitleView.setText(book.getPrice());
        Picasso.with(viewHolder.imageView.getContext()).load(book.getCover()).centerCrop().fit().into(viewHolder.imageView);

        return view;
    }

    private PanierViewHolder getViewHolder(final View workingView) {
        // The viewHolder allows us to avoid re-looking up view references
        // Since views are recycled, these references will never change
        final Object tag = workingView.getTag();
        PanierViewHolder viewHolder = null;


        if(null == tag || !(tag instanceof PanierViewHolder)) {
            viewHolder = new PanierViewHolder();

            viewHolder.titleView = (TextView) workingView.findViewById(R.id.news_entry_title);
            viewHolder.subTitleView = (TextView) workingView.findViewById(R.id.news_entry_subtitle);
            viewHolder.imageView = (ImageView) workingView.findViewById(R.id.news_entry_icon);

            workingView.setTag(viewHolder);

        } else {
            viewHolder = (PanierViewHolder) tag;
        }
        return viewHolder;
    }

    private View getWorkingView(final View convertView) {
        View workingView = null;
        if(null == convertView) {
            final Context context = getContext();
            final LayoutInflater inflater = (LayoutInflater)context.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);

            workingView = inflater.inflate(newsItemLayoutResource, null);
        } else {
            workingView = convertView;
        }

        return workingView;
    }
}
