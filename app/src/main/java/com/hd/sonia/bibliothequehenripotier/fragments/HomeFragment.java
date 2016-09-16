package com.hd.sonia.bibliothequehenripotier.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hd.sonia.bibliothequehenripotier.R;
import com.hd.sonia.bibliothequehenripotier.Views.BookView.BookAdapter;
import com.hd.sonia.bibliothequehenripotier.models.Book;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * A simple {@link Fragment} subclass.
 */
@EFragment(R.layout.fragment_home)
public class HomeFragment extends Fragment {
    @ViewById
    RecyclerView recyclerView;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        recyclerView.setAdapter(new BookAdapter(getActivity().getIntent().<Book>getParcelableArrayListExtra("myBooks"),getActivity()));

        return view;
    }



}
