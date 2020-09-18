
package ristinolla.logic;

import ristinolla.domain.Lauta;

public class PelinKulku {
    Lauta lauta;
    int pelaaja_vuorossa;
    
    public PelinKulku() {
        this.pelaaja_vuorossa = 1;
    }
    
    public void luoLauta(int n) {
        lauta = new Lauta(n);
    }
    
    public void vuoronVaihto() {
        if (pelaaja_vuorossa == 1) {
            pelaaja_vuorossa = 2;
        } else {
            pelaaja_vuorossa = 1;
        }
    }
    
    public void teeSiirto(int pelaaja_vuorossa, int x, int y) {
        //lauta.muokkaaLautaa(pelaaja_vuorossa, x, y);
    }
    
    
}
