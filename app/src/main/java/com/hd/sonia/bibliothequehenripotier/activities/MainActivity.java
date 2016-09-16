package com.hd.sonia.bibliothequehenripotier.activities;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.hd.sonia.bibliothequehenripotier.R;
import com.hd.sonia.bibliothequehenripotier.fragments.DetailsCommandeFragment;
import com.hd.sonia.bibliothequehenripotier.fragments.HomeFragment;
import com.hd.sonia.bibliothequehenripotier.models.Book;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewById
    Toolbar toolbar;
    @ViewById
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    @ViewById
    NavigationView navigationView;
    @ViewById
    RecyclerView recyclerView;

    public List<Book> bookListAdded = new ArrayList<Book>();

    @AfterViews
    void nextActivity() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerToggle = new ActionBarDrawerToggle(this,this.drawerLayout,0,0);

        drawerLayout.setDrawerListener(this.drawerToggle);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);

            }
        });

       navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                item.setChecked(true);
                drawerLayout.closeDrawers();
                if(item.getTitle().equals("Panier")){
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.containerFragment, new DetailsCommandeFragment());
                    fragmentTransaction.commit();
                }
                if(item.getTitle().equals("Home")){
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.containerFragment, new HomeFragment());
                    fragmentTransaction.commit();
                }

                Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_LONG).show();
                return true;
            }
        });
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.containerFragment, new HomeFragment());
        fragmentTransaction.commit();
    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        drawerToggle.syncState();
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public List<Book> getBookListAdded() {
        return bookListAdded;
    }

    public void setBookListAdded(List<Book> bookListAdded) {
        this.bookListAdded = bookListAdded;
    }
}
