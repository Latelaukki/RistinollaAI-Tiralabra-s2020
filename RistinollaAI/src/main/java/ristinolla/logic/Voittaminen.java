
package ristinolla.logic;

import ristinolla.domain.Lauta;

public class Voittaminen {
    private Lauta lauta;
    private int voittopisteet;
    private int koko;

    public Voittaminen(Lauta lauta) {
        this.lauta = lauta;
        this.koko = lauta.getKoko();
        if (koko > 5) {
            this.voittopisteet = 5;
        } else {
            voittopisteet = koko;
        }
    }
    
    
    public int onkoVoittanut() {
        int pelaaja = 0;       
        for (int i = 0; i < koko; i++) {
            for (int j = 0; j < koko; j++) {
                pelaaja = lauta.getLuku(i, j);
                if (pelaaja != 0) {
                    if (etsiSuoria(i, j, pelaaja)) {
                        return pelaaja;
                    }
                }                
            }
        }
        return pelaaja;
    }
    
    public boolean etsiSuoria(int y, int x, int pelaaja) {
        return tarkistaRivi(y, x, pelaaja) || tarkistaSarake(y, x, pelaaja) || tarkistaDiagonaali(y, x, pelaaja);
    }
    
    public boolean tarkistaRivi(int y, int x, int pelaaja) {
        int pisteet = 1;
        if (koko - x < voittopisteet) { //mahtuuko riville suoraa
            return false;
        }
        for (int i = x + 1; i < koko; i++) {
            if (lauta.getLuku(y, i) == pelaaja) {
                pisteet++;
            }
        }
        return pisteet == voittopisteet;
    }
    
    public boolean tarkistaSarake(int y, int x, int pelaaja) { //aika copypaste-metodi, korjaan myöhemmin
        int pisteet = 1;
        if (koko - y < voittopisteet) { //mahtuuko sarakkeelle suoraa
            return false;
        }
        for (int i = y + 1; i < koko; i++) {
            if (lauta.getLuku(i, x) == pelaaja) {
                pisteet++;
            }
        }
        return pisteet == voittopisteet;     
    }   
    
        public boolean tarkistaDiagonaali(int y, int x, int pelaaja) {
        int pisteet = 1;
        if (koko - x < voittopisteet || koko - y < voittopisteet) { //mahtuuko diagonaalille suoraa
            return false;
        }
        for (int i = y + 1; i < koko; i++) {
            for (int j = x + 1; j < koko; j++) {
                if (lauta.getLuku(i, j) == pelaaja) {
                    pisteet++;
                }
            }
        }
        return pisteet == voittopisteet;
    }
}
