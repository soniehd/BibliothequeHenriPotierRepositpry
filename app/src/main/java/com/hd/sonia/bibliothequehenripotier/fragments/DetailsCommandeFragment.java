package com.hd.sonia.bibliothequehenripotier.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hd.sonia.bibliothequehenripotier.Managers.PanierManager;
import com.hd.sonia.bibliothequehenripotier.R;
import com.hd.sonia.bibliothequehenripotier.Views.BookView.BookAdapter;
import com.hd.sonia.bibliothequehenripotier.Views.PanierView.PanierAdapter;
import com.hd.sonia.bibliothequehenripotier.activities.MainActivity;
import com.hd.sonia.bibliothequehenripotier.models.Book;


public class DetailsCommandeFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    public DetailsCommandeFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details_commande, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new PanierAdapter(((MainActivity)getActivity()).bookListAdded,getActivity()));
        //PanierManager.getBestOffer(((MainActivity)getActivity()).bookListAdded);
        return view;
    }







}
