package com.example.alexpopa95.dodgelikeapro;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by alexpopa95 on 17/02/15.
 */
public class Livello extends Thread {

    private double vel = 0.75;
    private double accelerazione = 0.02;
    private int distanza = 300;
    private final int puntiBonus = 100;
    private Fronte linea;
    private int difficolta;

    public Livello(int diff) {
        linea = new Fronte();
        this.difficolta = diff;
    }

    public void run() {
        double pti = 0;
        Gioco.giocatore = new Giocatore(Fronte.corsia2, Gioco.finestraGioco.getAltezza()-100, Fronte.grandezzaEntita, Fronte.altezzaEntita);
        while(Gioco.statoGioco != Gioco.STATO.MENU) {
            if(Gioco.statoGioco == Gioco.STATO.GIOCO) {
                synchronized (linea) {
                    aggiorna();
                }
                synchronized (linea) {
                    rimuovi();
                }
                synchronized (linea) {
                    controllaCollisioni();
                }
                pti += 0.1;
                if((int)pti == 1) {
                    pti = 0;
                    Gioco.giocatore.aggiungiPunti(1);
                }
            }
            try {
                Thread.sleep(difficolta);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void aumentaVel(double velox) {
        vel += velox;
        System.out.println(vel);
        if(vel > 6.5) {
            distanza += 75;
        }
        else if(vel > 6) {
            distanza += 75;
        }
        else if(vel > 5.5) {
            distanza += 50;
        }
        else if(vel > 4.5) {
            distanza += 50;
        }
        else if(vel > 3.75) {
            distanza += 30;
        }
        else if(vel > 3) {
            distanza += 40;
        }
        else if(vel > 2.5) {
            distanza += 30;
        }
        else if(vel > 1.75) {
            distanza += 20;
        }
        else if(vel > 1.5) {
            distanza += 20;
        }
        else if(vel > 1.35) {
            distanza += 20;
        }
        else if(vel > 1) {
            distanza += 20;
        }
    }

    private void aggiorna() {
        boolean yes = true;

        synchronized (linea) {
            for (Nemico nemico : Fronte.nemici) {
                if (nemico.getY() < distanza) {
                    yes = false;
                }
                nemico.avanza(vel);
            }
        }
        synchronized (linea) {
            for(Punto punto : Fronte.punti) {
                punto.avanza(vel);
            }
        }
        if(yes) {
            synchronized (linea) {
                linea.generaLinea();
            }
        }
    }

    private void rimuovi() {
        synchronized (linea) {
            for (Nemico nemico : Fronte.nemici) {
                if(nemico.getY() > Gioco.finestraGioco.getAltezza()) {
                    Fronte.nemici.remove(nemico);
                    //System.out.println("REMOVED");
                    break;
                }
            }
        }
        synchronized (linea) {
            for(Punto punto : Fronte.punti) {
                if(punto.getY() > Gioco.finestraGioco.getAltezza()) {
                    Fronte.punti.remove(punto);
                    //System.out.println("REMOVED");
                    break;
                }
            }
        }
    }

    private void controllaCollisioni() {
        synchronized (linea) {
            for (Nemico nemico : Fronte.nemici) {
                if(GestoreCollisioni.scontro(nemico, Gioco.giocatore)) {
                    Gioco.statoGioco = Gioco.STATO.FINITO;
                }
            }
        }
        synchronized (linea) {
            for (Punto punto : Fronte.punti) {
                if(GestoreCollisioni.raccogli(punto, Gioco.giocatore)) {
                    aumentaVel(accelerazione);
                    Gioco.giocatore.aggiungiPunti(puntiBonus);
                    Fronte.punti.remove(punto);
                    //System.out.println("REMOVED");
                    break;
                }
            }
        }
    }

    public double getVel() {
        return vel;
    }

    public void disegna(Paint g, Canvas c) {
        synchronized (linea) {
            for (Nemico nemico : Fronte.nemici) {
                nemico.disegna(g, c);
            }
        }
        synchronized (linea) {
            for (Punto punto : Fronte.punti) {
                punto.disegna(g, c);
            }
        }
    }
}
