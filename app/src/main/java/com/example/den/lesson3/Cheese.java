package com.example.den.lesson3;

import android.graphics.drawable.Drawable;

/**
 * Created by den on 3/25/18.
 */

class Cheese {
    String name;
    Drawable imageResourceId;


    public Cheese(Drawable imageResourceId, String name) {
        this.name = name;
        this.imageResourceId = imageResourceId;
    }
}
