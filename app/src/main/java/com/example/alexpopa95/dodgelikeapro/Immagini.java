package com.example.alexpopa95.dodgelikeapro;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Html;

/**
 * Created by alexpopa95 on 17/02/15.
 */
public class Immagini {
    public static final String percorsoImmagini = "/immagini/";
    public static Bitmap stella = null;
    public static Bitmap auto = null;
    public static Bitmap c1 = null;
    public static Bitmap c2 = null;
    public static Bitmap c3 = null;

    public static void caricaImmagini(Gioco gioco) {
        Drawable d;
        d = gioco.getResources().getDrawable(R.drawable.stella);
        stella = ((BitmapDrawable)d).getBitmap();
        d = gioco.getResources().getDrawable(R.drawable.auto);
        auto = ((BitmapDrawable)d).getBitmap();
        d = gioco.getResources().getDrawable(R.drawable.c1);
        c1 = ((BitmapDrawable)d).getBitmap();
        d = gioco.getResources().getDrawable(R.drawable.c2);
        c2 = ((BitmapDrawable)d).getBitmap();
        d = gioco.getResources().getDrawable(R.drawable.c3);
        c3 = ((BitmapDrawable)d).getBitmap();
    }
}

