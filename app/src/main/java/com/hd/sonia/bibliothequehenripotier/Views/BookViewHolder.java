package com.hd.sonia.bibliothequehenripotier.Views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hd.sonia.bibliothequehenripotier.R;
import com.hd.sonia.bibliothequehenripotier.models.Book;
import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.ViewById;

/**
 * Created by Sonia on 12/09/2016.
 */
public class BookViewHolder extends RecyclerView.ViewHolder {

    private TextView titreViewView;
    private TextView priceViewView;
    private ImageView imageView;


    public BookViewHolder(View itemView) {
        super(itemView);

        titreViewView = (TextView) itemView.findViewById(R.id.titre);
        priceViewView = (TextView) itemView.findViewById(R.id.price);
        imageView = (ImageView) itemView.findViewById(R.id.image);
    }

    public void bind(Book myBook){
        titreViewView.setText(myBook.getTitle());

        priceViewView.setText(myBook.getPrice()+"");
        Picasso.with(imageView.getContext()).load(myBook.getCover()).centerCrop().fit().into(imageView);
    }
}
