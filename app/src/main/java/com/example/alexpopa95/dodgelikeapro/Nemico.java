package com.example.alexpopa95.dodgelikeapro;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by alexpopa95 on 17/02/15.
 */
public class Nemico implements Entita {
    private double x, y;
    private int larghezza;
    private int altezza;
    private int indexImmagine;

    public Nemico(int x, int y, int larghezza, int altezza, int indexImmagine) {
        this.x = x;
        this.y = y;
        this.larghezza = larghezza;
        this.altezza = altezza;
        this.indexImmagine = indexImmagine;
    }

    public void disegna(Paint g, Canvas c) {
        //g.setColor(Color.black);
        //g.fillRect((int)x, (int)y, larghezza, larghezza);
        switch(indexImmagine) {
            case 0:
                c.drawBitmap(Immagini.c1, (int)x, (int)y, g);
                break;
            case 1:
                c.drawBitmap(Immagini.c2, (int)x, (int)y, g);
                break;
            case 2:
                c.drawBitmap(Immagini.c3, (int)x, (int)y, g);
                break;
        }
    }

    @Override
    public Rect getBordi() {
        return new Rect((int)x, (int)y, larghezza, altezza);
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