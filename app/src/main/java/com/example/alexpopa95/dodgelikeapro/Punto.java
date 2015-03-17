package com.example.alexpopa95.dodgelikeapro;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by alexpopa95 on 17/02/15.
 */
public class Punto implements Entita {
    private double x, y;
    private int larghezza;

    public Punto(int x, int y, int larghezza) {
        this.x = x;
        this.y = y;
        this.larghezza = larghezza;
    }

    public void disegna(Paint g, Canvas c) {
        //g.setColor(Color.white);
        //g.fillOval((int) x, (int) y, larghezza, larghezza);
        c.drawBitmap(Immagini.stella, (int) x, (int) y, g);
    }

    @Override
    public Rect getBordi() {
        return new Rect((int)x, (int)y, larghezza, larghezza);
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public void setX(double x) {
        this.x = x;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }

    public void avanza(double vel) {
        y += vel;
    }
}