package com.example.alexpopa95.dodgelikeapro;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by alexpopa95 on 17/02/15.
 */
public class Fronte {
    private double y = -70;
    public static final int grandezzaEntita = 40;
    public static final int altezzaEntita = 70;
    public static int corsia1, corsia2, corsia3;
    public static ArrayList<Nemico> nemici;
    public static ArrayList<Punto> punti;

    public Fronte() {
        nemici = new ArrayList<Nemico>();
        punti = new ArrayList<Punto>();
        calcolaCorsie();
    }

    public void calcolaCorsie() {
        corsia1 = Ambiente.larghezzaBordi+(Ambiente.larghezzaCorsia/2)-(grandezzaEntita/2);
        corsia2 = corsia1+Ambiente.larghezzaCorsia;
        corsia3 = corsia2+Ambiente.larghezzaCorsia;
    }

    public void generaLinea() {
        Random rand = new Random();
        int index = new Random().nextInt(3);
        switch(index) {
            case 0:
                System.out.println("CORSIA 1");
                if(rand.nextBoolean())punti.add(new Punto(corsia1, (int)y, grandezzaEntita));
                if(rand.nextBoolean())nemici.add(new Nemico(corsia2, (int)y, grandezzaEntita, altezzaEntita, rand.nextInt(3)));
                if(rand.nextBoolean())nemici.add(new Nemico(corsia3, (int)y, grandezzaEntita, altezzaEntita, rand.nextInt(3)));
                break;
            case 1:
                System.out.println("CORSIA 2");
                if(rand.nextBoolean())punti.add(new Punto(corsia2, (int)y, grandezzaEntita));
                if(rand.nextBoolean())nemici.add(new Nemico(corsia1, (int)y, grandezzaEntita, altezzaEntita, rand.nextInt(3)));
                if(rand.nextBoolean())nemici.add(new Nemico(corsia3, (int)y, grandezzaEntita, altezzaEntita, rand.nextInt(3)));
                break;
            case 2:
                System.out.println("CORSIA 3");
                if(rand.nextBoolean())punti.add(new Punto(corsia3, (int)y, grandezzaEntita));
                if(rand.nextBoolean())nemici.add(new Nemico(corsia2, (int)y, grandezzaEntita, altezzaEntita, rand.nextInt(3)));
                if(rand.nextBoolean())nemici.add(new Nemico(corsia1, (int)y, grandezzaEntita, altezzaEntita, rand.nextInt(3)));
        }
    }
}
