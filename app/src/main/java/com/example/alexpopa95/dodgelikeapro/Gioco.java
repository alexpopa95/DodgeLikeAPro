package com.example.alexpopa95.dodgelikeapro;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;


public class Gioco extends Activity implements Runnable, View.OnClickListener {

    static FinestraGioco finestraGioco;
    private Ambiente ambiente;
    private static Thread threadGioco;
    Gioco gioco;

    @Override
    public void onClick(View v) {
        // do something when the button is clicked
    }

    public static enum STATO {
        MENU,
        GIOCO,
        FINITO,
        PAUSA
    };

    public static STATO statoGioco;
    public static boolean giocoAttivo;
    private Livello livello;
    public static Giocatore giocatore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        finestraGioco = new FinestraGioco(this, "DodgeLikeAPro");
        finestraGioco.setBackgroundColor(Color.WHITE);

        gioco = new Gioco();
        caricaRisorse();
        threadGioco = new Thread(gioco);
        threadGioco.start();

        setContentView(finestraGioco);
    }

    private void caricaRisorse() {
        ambiente = new Ambiente();
        creaFinestra();
    }
    private void avviaGioco() {
        statoGioco = STATO.MENU;
        statoGioco = STATO.GIOCO;
        livello = new Livello(2);
        livello.start();
    }
    private void creaFinestra() {
        aggiungiListener();
    }
    private void aggiungiListener() {

        //Pressione tastiera
        /*finestraGioco.addKeyAdapter(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keycode = e.getKeyCode();
                switch(keycode) {
                    case KeyEvent.VK_ENTER:
                        if(statoGioco == STATO.MENU) {
                            statoGioco = STATO.GIOCO;
                            livello = new Livello(2);
                            livello.start();
                        }
                        if(statoGioco == STATO.PAUSA) {
                            statoGioco = STATO.GIOCO;
                        }
                        break;
                    case KeyEvent.VK_ESCAPE:
                        if(statoGioco == STATO.GIOCO) {
                            statoGioco = STATO.PAUSA;
                        }
                        else if(statoGioco == STATO.PAUSA) {
                            statoGioco = STATO.MENU;
                        }
                        else if(statoGioco == STATO.FINITO) {
                            statoGioco = STATO.MENU;
                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                        if(giocatore!=null) giocatore.spostaDestra();
                        break;
                    case KeyEvent.VK_LEFT:
                        if(giocatore!=null) giocatore.spostaSinistra();
                        break;

                }
            }
        });*/
    }

    @Override
    public void run() {
        giocoAttivo = true;
        while(giocoAttivo) {
            finestraGioco.setResources(ambiente, livello);
            finestraGioco.aggiorna();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}