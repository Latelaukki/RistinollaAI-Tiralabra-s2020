package ristinolla.logic;

import ristinolla.domain.Lauta;

public class Ai {
    private Lauta lauta;
    private int koko;
    // private Voittaminen voittaminen;
    
    public Ai(Lauta lauta, int id) {
        this.lauta = lauta;
        this.koko = lauta.getKoko();
        //this.voittaminen = new Voittaminen(lauta);
    }
    
    public int minimax(int arvio, boolean maksimoiva_pelaaja, int syvyys) {
        if (syvyys == 0) {
            return tilanteenArviointi();
        }
        if (maksimoiva_pelaaja) {       
            int korkein = -99999;
            for (int i = 0; i < koko; i++) {
                for (int j = 0; j < koko; j++) {
                    if (lauta.getPelaaja(i, j) != 0) {
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
    
    public int tilanteenArviointi() {
        PeliTilanteenArviointi arvio = new PeliTilanteenArviointi(lauta, pelaaja);
        int pisteet = 0;
        return 1;
    }
    
   
}
