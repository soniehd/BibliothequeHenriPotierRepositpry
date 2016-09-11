package com.hd.sonia.bibliothequehenripotier.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Sonia on 10/09/2016.
 */
public final class Offer {

        @SerializedName("type")
        public final String type;
        @SerializedName("value")
        public final long value;
        @SerializedName("sliceValue")
        public final Long sliceValue;


        public Offer(String type, long value, Long sliceValue){
            this.type = type;
            this.value = value;
            this.sliceValue = sliceValue;
        }

}