package com.example.alexpopa95.dodgelikeapro;

/**
 * Created by alexpopa95 on 17/02/15.
 */
public class GestoreCollisioni {

    public static boolean scontro(Nemico nemico,  Giocatore giocatore) {
        if(nemico.getBordi().intersect(giocatore.getBordi())) {
            return true;
        }
        return false;
    }

    public static boolean raccogli(Punto punto,  Giocatore giocatore) {
        if(punto.getBordi().intersect(giocatore.getBordi())) {
            return true;
        }
        return false;
    }
}

