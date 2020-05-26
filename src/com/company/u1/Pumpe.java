package com.company.u1;

public class Pumpe extends Thread {

    private Tank t;
    private int leistung ;
    private int sum;

    public Pumpe ( String name , Tank t , int leistung){
        this.t = t;
        this.leistung = leistung;
        this.setName(name );
    }

    public void run() {
        while( true ) {
            int tmp = t.betanken(leistung) ;
            sum += tmp;
            if (tmp< leistung)
                break ;
        }
        System.out.println(getName() + ": " + sum );
    }

    public int getSum() {
        return sum;
    }
}
