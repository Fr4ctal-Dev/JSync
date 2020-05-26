package com.company.u2;

public class Lieferant extends Thread {

    private Lager l;

    public Lieferant (Lager l){
        this.l = l;
    }
    public void anliefern(int anzahl){
        int bestand = l.getBestand() ;
        System. out.print (getName () + "Bestand alt: " + bestand ) ;
        System.out.println( "Liefermenge: " + anzahl) ;
        l.setBestand(bestand + anzahl ) ;
    }
    public void run(){
        anliefern (10) ;
    }
}
