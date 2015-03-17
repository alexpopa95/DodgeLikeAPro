package com.example.alexpopa95.dodgelikeapro;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by alexpopa95 on 17/02/15.
 */
public interface Entita {
    public void disegna(Paint g, Canvas c);
    public Rect getBordi();

    public double getX();
    public double getY();
    public void setX(double x);
    public void setY(double y);
}