package com.hd.sonia.bibliothequehenripotier;

import android.content.Intent;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;


import com.hd.sonia.bibliothequehenripotier.activities.MainActivity;
import com.hd.sonia.bibliothequehenripotier.activities.MainActivity_;
import com.hd.sonia.bibliothequehenripotier.activities.SplashActivity;
import com.hd.sonia.bibliothequehenripotier.activities.SplashActivity_;
import com.hd.sonia.bibliothequehenripotier.models.Book;
import com.hd.sonia.bibliothequehenripotier.models.Offer;
import com.hd.sonia.bibliothequehenripotier.models.Offers;
import com.hd.sonia.bibliothequehenripotier.utils.CommandeMethods;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertEquals;


/**
 * Created by Sonia on 17/09/2016.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class BookListTest  {



    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(
            MainActivity_.class,true,    // initialTouchMode
            false);




    @Test
    public void testLisBook() {
        ArrayList<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book("c8fabf68-8374-48fe-a7ea-a00ccd07afff","Henri Potier à l'école des sorciers","35","http://henri-potier.xebia.fr/hp0.jpg"));
        bookList.add(new Book("a460afed-e5e7-4e39-a39d-c885c05db861","Henri Potier et la Chambre des secrets","30","http://henri-potier.xebia.fr/hp0.jpg"));
        Intent intent = new Intent();
        intent.putParcelableArrayListExtra("myBooks", bookList);
        mActivityRule.launchActivity(intent);
        onView(withId(R.id.recyclerView)).check(matches(isDisplayed()));
    }

    @Test
    public void testOffrePrix() {
        List<Book> bookList = new ArrayList<Book>();
        List<Offer> offerList = new ArrayList<Offer>();
        bookList.add(new Book("c8fabf68-8374-48fe-a7ea-a00ccd07afff","Henri Potier à l'école des sorciers","35","http://henri-potier.xebia.fr/hp0.jpg"));
        bookList.add(new Book("a460afed-e5e7-4e39-a39d-c885c05db861","Henri Potier et la Chambre des secrets","30","http://henri-potier.xebia.fr/hp0.jpg"));
        offerList.add(new Offer("percentage",5,0));
        offerList.add(new Offer("minus",15,0));
        offerList.add(new Offer("slice",12,100));
        Offers offers =  new Offers();
        offers.setOffers(offerList);
        assertEquals(CommandeMethods.getBestPrice(offers,65),50.0);

    }



    @Test
    public void testitemLisBook() {
        ArrayList<Book> bookList = new ArrayList<Book>();
        bookList.add(new Book("c8fabf68-8374-48fe-a7ea-a00ccd07afff","Henri Potier à l'école des sorciers","35","http://henri-potier.xebia.fr/hp0.jpg"));
        bookList.add(new Book("a460afed-e5e7-4e39-a39d-c885c05db861","Henri Potier et la Chambre des secrets","30","http://henri-potier.xebia.fr/hp0.jpg"));
        Intent intent = new Intent();
        intent.putParcelableArrayListExtra("myBooks", bookList);
        mActivityRule.launchActivity(intent);
        onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.actionOnItemAtPosition(1, click()));
    }

    public void testAddBookButton(){

    }

}
