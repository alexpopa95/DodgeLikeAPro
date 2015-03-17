package com.example.alexpopa95.dodgelikeapro;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by alexpopa95 on 17/02/15.
 */
public class Giocatore {
    private double x, y;
    private int larghezza;
    private int altezza;
    private int punteggio = 0;
    private int punteggioMigliore = 0;

    public Giocatore(int x, int y, int larghezza, int altezza) {
        this.x = x;
        this.y = y;
        this.larghezza = larghezza;
        this.altezza = altezza;
        leggiMigliore();
    }

    public void disegna(Paint g, Canvas c) {
        //g.setColor(Color.yellow);
        //g.fillOval((int) x, (int) y, larghezza, larghezza);
        c.drawBitmap(Immagini.auto, (int)x, (int)y, g);
    }

    public void leggiMigliore() {
        String best;
        try {
            BufferedReader bf = new BufferedReader(new FileReader("best.txt"));
            best = bf.readLine();
            punteggioMigliore = Integer.parseInt(best);
            bf.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void impostaMigliore() {
        FileOutputStream prova = null;
        try {
            prova = new FileOutputStream("best.txt");
            PrintStream scrivi = new PrintStream(prova);
            scrivi.print(punteggio);
            prova.close();
            scrivi.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Rect getBordi() {
        return new Rect((int)x, (int)y, larghezza, altezza);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void spostaDestra() {
        if(x == Fronte.corsia1) {
            x = Fronte.corsia2;
        }
        else if(x == Fronte.corsia2) {
            x = Fronte.corsia3;
        }
    }

    public void aggiungiPunti(int pt) {
        punteggio += pt;
    }

    public void setPunti(int pt) {
        punteggio = pt;
    }

    public int getPunti() {
        return punteggio;
    }

    public int getPuntiMigliore() {
        return punteggioMigliore;
    }

    public void spostaSinistra() {
        if(x == Fronte.corsia2) {
            x = Fronte.corsia1;
        }
        else if(x == Fronte.corsia3) {
            x = Fronte.corsia2;
        }
    }
}