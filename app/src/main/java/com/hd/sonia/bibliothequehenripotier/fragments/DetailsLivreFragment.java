package com.hd.sonia.bibliothequehenripotier.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.hd.sonia.bibliothequehenripotier.R;
import com.hd.sonia.bibliothequehenripotier.activities.MainActivity;
import com.hd.sonia.bibliothequehenripotier.models.Book;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class DetailsLivreFragment extends Fragment implements View.OnClickListener  {

        private TextView description;
        private TextView price;
        private ImageView imageView;
        private Button addPanier;
        private Book book;

    public DetailsLivreFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_details_livre, container, false);
        getActivity().setTitle("Book");
        description =  (TextView) view.findViewById(R.id.titre);
        price = (TextView)view.findViewById(R.id.price);
        imageView = (ImageView) view.findViewById(R.id.imageLivre);
        addPanier = (Button) view.findViewById(R.id.buybtn);
        addPanier.setOnClickListener(this);
        book = getArguments().getParcelable("bookSelected");
        description.setText(book.getTitle());
        price.setText(book.getPrice()+"€");

        Picasso.with(imageView.getContext()).load(book.getCover()).centerCrop().fit().into(imageView);
        return view;

    }

    @Override
    public void onClick(View v) {
        ((MainActivity)getActivity()).bookListAdded.add(book);

        Log.d("Click", "Add panier"+ ((MainActivity)getActivity()).bookListAdded.size());
    }
}
