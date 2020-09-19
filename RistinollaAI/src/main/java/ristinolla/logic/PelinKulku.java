
package ristinolla.logic;

import ristinolla.domain.Lauta;

public class PelinKulku {
    Lauta lauta;
    int pelaaja_vuorossa;
    
    public PelinKulku() {
        this.pelaaja_vuorossa = 0; //pelaaja = 1, ai = 2
    }
    
    public void luoLauta(int n) {
        lauta = new Lauta(n);
    }
    
    public void luoAi() {
        
    }
    
    public void vuoronVaihto() {
        if (pelaaja_vuorossa == 2) {
            pelaaja_vuorossa = 1;
        } else {
            pelaaja_vuorossa = 2;
        }
    }
    
    public void teeSiirto(int pelaaja_vuorossa, int x, int y) {
        lauta.asetaLuku(pelaaja_vuorossa, x, y);
    }  
    
}
