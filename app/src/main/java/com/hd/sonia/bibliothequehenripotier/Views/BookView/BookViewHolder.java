package com.hd.sonia.bibliothequehenripotier.Views.BookView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hd.sonia.bibliothequehenripotier.R;
import com.hd.sonia.bibliothequehenripotier.models.Book;
import com.squareup.picasso.Picasso;

/**
 * Created by Sonia on 12/09/2016.
 */
public class BookViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView titreViewView;
    private TextView priceViewView;
    private ImageView imageView;
    private Context context;
    ItemClickListener itemClickListner;


    public BookViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        titreViewView = (TextView) itemView.findViewById(R.id.titre);
        priceViewView = (TextView) itemView.findViewById(R.id.price);
        imageView = (ImageView) itemView.findViewById(R.id.image);
        this.context = context;
        itemView.setOnClickListener(this);

    }

    public void bind(Book myBook){
        titreViewView.setText(myBook.getTitle());
        priceViewView.setText(myBook.getPrice()+"€");
        Picasso.with(imageView.getContext()).load(myBook.getCover()).centerCrop().fit().into(imageView);
    }

    @Override
    public void onClick(View v) {
            this.itemClickListner.onItemClick(v, getAdapterPosition());
    }

    void setItemClickListner(ItemClickListener ic){
        this.itemClickListner = ic;

    }


}
