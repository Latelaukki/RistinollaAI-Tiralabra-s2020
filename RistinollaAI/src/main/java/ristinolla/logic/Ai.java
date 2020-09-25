package ristinolla.logic;

import ristinolla.domain.Lauta;

public class Ai {
    private Lauta lauta;
    private int koko;
    private Voittaminen voittaminen;
    
    public Ai(Lauta lauta, int id) {
        this.lauta = lauta;
        this.koko = lauta.getKoko();
        this.voittaminen = new Voittaminen(lauta);
    }
    
    public void minimax(boolean maksimoiva_pelaaja, int syvyys) {     
        if (maksimoiva_pelaaja) {       
            int korkein = -99;
            for (int i = 0; i < koko; i++) {
                for (int j = 0; j < koko; j++) {
                    if (lauta.getLuku(i, j) != 0) {
                        continue;

                    }
                    lauta.asetaLuku(i, j, 2);
                    if (asemanLaskeminen() > korkein) {
                        continue;
                    }
                    lauta.asetaLuku(i, j, 0);
                }
            }
        }
    }
    
    public int asemanLaskeminen() {
        int pisteet = 0;
        return 1;
    }
    
        
    
}
