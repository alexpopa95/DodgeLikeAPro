package com.example.alexpopa95.dodgelikeapro;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by alexpopa95 on 17/02/15.
 */
public class Ambiente {
    public static int larghezzaBordi = 35;
    public static int larghezzaDivisoreCorsia = 10;
    public static int larghezzaCorsia;

    public Ambiente() {}

    public void disegna(Paint g, Canvas c) {
        //Sfondo
        g.setColor(Color.GRAY);
        g.setStrokeWidth(0);
        c.drawRect(0, 0, Gioco.finestraGioco.getLarghezza(), Gioco.finestraGioco.getAltezza(), g);

        //Margini
        g.setColor(Color.CYAN);
        c.drawRect(0, 0, larghezzaBordi, Gioco.finestraGioco.getAltezza(), g);
        c.drawRect(Gioco.finestraGioco.getLarghezza()-larghezzaBordi, 0, Gioco.finestraGioco.getLarghezza(), Gioco.finestraGioco.getAltezza(), g);

        //Corsie
        larghezzaCorsia = (Gioco.finestraGioco.getLarghezza()-(larghezzaBordi*2))/3;
        if(Gioco.statoGioco == Gioco.STATO.GIOCO || Gioco.statoGioco == Gioco.STATO.PAUSA) {
            g.setColor(Color.DKGRAY);
            c.drawRect(larghezzaBordi+larghezzaCorsia-(larghezzaDivisoreCorsia/2), 0, larghezzaDivisoreCorsia, Gioco.finestraGioco.getAltezza(), g);
            c.drawRect(larghezzaBordi+(larghezzaCorsia*2)-(larghezzaDivisoreCorsia/2), 0, larghezzaDivisoreCorsia, Gioco.finestraGioco.getAltezza(), g);
        }
        if(Gioco.statoGioco == Gioco.STATO.FINITO) {
            g.setColor(Color.CYAN);
            //g.fillRect(0, 100, Gioco.finestraGioco.getLarghezza(), Gioco.finestraGioco.getAltezza());
        }
    }
}
