package com.company;

import java.sql.SQLException;
import java.util.Random;

public class Testaus {
    public Testaus(){
    }
    static public void testaaKaikki(Toiminnot to) throws SQLException {
        testi1(to);
        testi2(to);
        testi3(to);
        testi4(to);
        testi5(to);
    }
    static public void testi1(Toiminnot to) throws SQLException {
        long alku = System.nanoTime();
        for(int i = 0; i < 1000; i++){
            String paikka = "P" + (i+1);
            to.teePaikka(paikka);
        }
        long kulunutAika = System.nanoTime() - alku;

        printKulunutAika(1, kulunutAika);
    }

    static public void testi2(Toiminnot to) throws SQLException {
        long alku = System.nanoTime();
        for(int i = 0; i < 1000; i++){
            String asiakas = "A" + (i+1);
            to.teeAsiakas(asiakas);
        }
        long kulunutAika = System.nanoTime() - alku;

        printKulunutAika(2, kulunutAika);
    }

    static public void testi3(Toiminnot to) throws SQLException {
        Random rng = new Random();
        long alku = System.nanoTime();
        for(int i = 0; i < 1000; i++){
            String koodi = "KOODI" + i;
            String asiakas = "A" + (rng.nextInt(1000) + 1);
            to.teePaketti(koodi, asiakas);
        }
        long kulunutAika = System.nanoTime() - alku;
        printKulunutAika(3, kulunutAika);
    }

    static public void testi4(Toiminnot to) throws SQLException {
        Random rng = new Random();
        long alku = System.nanoTime();
        for(int i = 0; i < 1000; i++){
            String koodi = "KOODI" + rng.nextInt(1000);
            String paikka = "P" + (rng.nextInt(1000) + 1);
            String kuvaus = "Kuvaus numero " + i+1;
            to.teeTapahtuma(koodi, paikka, kuvaus);
        }
        long kulunutAika = System.nanoTime() - alku;
        printKulunutAika(4, kulunutAika);

    }

    static public void testi5(Toiminnot to) throws SQLException {
        Random rng = new Random();
        long alku = System.nanoTime();
        for(int i = 0; i < 1000; i++){
            String asiakas = "A" + rng.nextInt(1000);
            to.printPakettiMaara(asiakas);
        }
        long kulunutAika = System.nanoTime() - alku;
        printKulunutAika(5, kulunutAika);
    }
    private static void printKulunutAika(int testi, long aika){
        System.out.println("Aikaa kului testiin " + testi + ": " + (aika/1000000000) + " sekuntia");
    }
}
