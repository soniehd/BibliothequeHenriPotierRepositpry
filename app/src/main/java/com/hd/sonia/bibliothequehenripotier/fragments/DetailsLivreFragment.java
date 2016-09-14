package com.hd.sonia.bibliothequehenripotier.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hd.sonia.bibliothequehenripotier.R;
import com.hd.sonia.bibliothequehenripotier.models.Book;


public class DetailsLivreFragment extends Fragment {

        private TextView description;

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
        description =  (TextView) view.findViewById(R.id.description);
        Book book = getArguments().getParcelable("bookSelected");
        description.setText(book.getTitle());
        return view;

    }
}
