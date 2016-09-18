package com.hd.sonia.bibliothequehenripotier.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.hd.sonia.bibliothequehenripotier.Callbacks.OffersCallBack;
import com.hd.sonia.bibliothequehenripotier.Managers.BookManager;
import com.hd.sonia.bibliothequehenripotier.Managers.PanierManager;
import com.hd.sonia.bibliothequehenripotier.R;
import com.hd.sonia.bibliothequehenripotier.Views.BookView.BookAdapter;
import com.hd.sonia.bibliothequehenripotier.Views.PanierView.PanierAdapter;
import com.hd.sonia.bibliothequehenripotier.activities.MainActivity;
import com.hd.sonia.bibliothequehenripotier.models.Book;
import com.hd.sonia.bibliothequehenripotier.models.Offer;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;


public class DetailsCommandeFragment extends Fragment {

    private ListView maListViewPerso;
    private  TextView totalTextView;

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
        getActivity().setTitle("Panier");
        maListViewPerso = (ListView) view.findViewById(R.id.listviewcmd);
        totalTextView = (TextView) view.findViewById(R.id.totalcmd);

        final ListView bookListView = (ListView) view.findViewById(R.id.listviewcmd);
        final PanierAdapter panierAdapter = new PanierAdapter(getActivity(), R.layout.cell_card_details);
        panierAdapter.addAll(((MainActivity)getActivity()).bookListAdded);
        bookListView.setAdapter(panierAdapter);

        final PanierManager panierManager = new PanierManager();
        panierManager.getPromotion(((MainActivity)getActivity()).bookListAdded);
        panierManager.offersCallBack = new OffersCallBack() {
            @Override
            public void onResponse(double remise) {
                totalTextView.setText("Total de votre Commande avec remise : "+remise+"€");
                Log.d("remise", "chui la"+remise);

            }

            @Override
            public void onFailure(Call<Offer> call, Throwable t) {

            }
        };
        return view;
    }







}
