package com.example.alexpopa95.dodgelikeapro;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by alexpopa95 on 17/02/15.
 */
public class FinestraGioco extends View {

    private String nome;
    Ambiente ambiente;
    Livello livello;

    public static Paint paint = new Paint();

    public FinestraGioco(Context context) {
        super(context);
    }

    @Override
    public void onDraw(Canvas canvas) {

        disegna(paint, canvas);

    }

    public FinestraGioco(Context context, String nome) {
        super(context);
        this.nome = nome;
    }

    public void setResources(Ambiente ambiente, Livello livello) {
        this.ambiente = ambiente;
        this.livello = livello;
    }

    public void disegna(Paint g, Canvas c) {

        switch(Gioco.statoGioco) {
            case GIOCO:
                if(ambiente!=null) ambiente.disegna(g, c);
                g.setColor(Color.RED);
                if(livello!=null) livello.disegna(g, c);
                if(Gioco.giocatore!=null) Gioco.giocatore.disegna(g, c);
                //g.drawString("RUNNING", larghezza / 2 - 25, altezza - 50);
                g.setColor(Color.YELLOW);
                if(Gioco.giocatore != null) {
                    if(Gioco.giocatore.getPunti()>2500) g.setColor(Color.MAGENTA);
                    if(Gioco.giocatore.getPunti()>5000) g.setColor(Color.GREEN);
                }
                if(Gioco.giocatore!=null)c.drawText("Punti: " + Gioco.giocatore.getPunti(), 50, 75, g);
                break;
            case PAUSA:
                if(ambiente!=null) ambiente.disegna(g, c);
                g.setColor(Color.BLUE);
                if(livello!=null) livello.disegna(g, c);
                if(Gioco.giocatore!=null) Gioco.giocatore.disegna(g, c);
                c.drawText("PAUSA", getLarghezza() / 2 - 20, getAltezza() - 85, g);
                c.drawText("Premi INVIO per riprendere", getLarghezza() / 2 - 75, getAltezza() - 55, g);
                break;
            case MENU:
                if(ambiente!=null) ambiente.disegna(g, c);
                g.setColor(Color.MAGENTA);
                c.drawText("Dodge Like a Pro", getLarghezza() / 2 - 110, 150, g);
                g.setColor(Color.LTGRAY);
                c.drawText("Popa Alexandru", getLarghezza() / 2, 163, g);
                g.setColor(Color.RED);
                c.drawText("Premi invio per cominciare", getLarghezza() / 2 - 135, 250, g);
                break;
            case FINITO:
                if(ambiente!=null) ambiente.disegna(g, c);
                g.setColor(Color.BLACK);
                if(Gioco.giocatore!=null)c.drawText("Punti: " + Gioco.giocatore.getPunti(), 50, 55, g);
                boolean record = false;
                if(Gioco.giocatore != null) {
                    if(Gioco.giocatore.getPunti()>=Gioco.giocatore.getPuntiMigliore()) {
                        record = true;
                        g.setColor(Color.GREEN);
                        c.drawText("Migliore: " + Gioco.giocatore.getPuntiMigliore() + " record ", 50, 85, g);
                    }
                    else {
                        g.setColor(Color.MAGENTA);
                        c.drawText("Migliore: " + Gioco.giocatore.getPuntiMigliore(), 50, 85, g);
                    }
                }
                if(record) {
                    Gioco.giocatore.impostaMigliore();
                    Gioco.giocatore.leggiMigliore();
                }
                g.setColor(Color.RED);
                c.drawText("Premi ESC per andare al menu", getLarghezza()/2 - 138, 250, g);
                break;
        }
    }
    public void aggiorna() {
        //System.err.println("Altezza: "+getAltezza()+" - Larghezza: "+getLarghezza());
    }

    public int getLarghezza() {
        WindowManager wm = (WindowManager) this.getContext().getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        return width;
    }

    public int getAltezza() {
        WindowManager wm = (WindowManager) this.getContext().getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        return height;
    }

    //GET
    public String getNome() {
        return nome;
    }
}
