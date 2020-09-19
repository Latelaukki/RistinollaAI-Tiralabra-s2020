package ristinolla.logic;

import ristinolla.domain.Lauta;

public class Ai {
    Lauta lauta;
    int koko;
    
    public Ai(Lauta lauta, int id) {
        this.lauta = lauta;
        this.koko = lauta.getKoko();
    }
    
    public void minimax(boolean maksimoiva_pelaaja) {
        
        if (maksimoiva_pelaaja) {       
            int korkein = -99;
            for (int i = 0; i < koko; i++) {
                for (int j = 0; j < koko; j++) {
                    if (lauta.getArvo(i, j) != 0) {
                        continue;

                    }
                    lauta.asetaLuku(i, j, 2);
                    if (minimax() > korkein) {
                        continue;
                    }
                    lauta.asetaLuku(i, j, 0);
                }
            }
        }
    }
    
    public int asemanLaskeminen() {
        int pisteet = 0;
        if ()
    }
    
        
    
}
