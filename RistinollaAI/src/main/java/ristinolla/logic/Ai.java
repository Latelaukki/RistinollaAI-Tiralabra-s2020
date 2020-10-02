package ristinolla.logic;

import ristinolla.domain.Lauta;

public class Ai {
    private Lauta lauta;
    private int koko;
    private int y, x;
    // private Voittaminen voittaminen;
    
    public Ai(Lauta lauta) {
        this.lauta = lauta;
        this.koko = lauta.getKoko();
        this.y = 0;
        this.x = 0;
        //this.voittaminen = new Voittaminen(lauta);
    }
    
    public void bottiSiirto() {
        lauta.asetaLuku(this.y, this.x, 2);
    }
    
    public int minimax(int y, int x, int syvyys, boolean maksimoiva_pelaaja) {
        if (syvyys == 0) {
            this.y = y;
            this.x = x;
            return tilanteenArviointi();
        }
        if (maksimoiva_pelaaja) {       
            int korkein = -999;
            for (int i = 0; i < koko; i++) {
                for (int j = 0; j < koko; j++) {
                    int arvio = minimax(i, j, syvyys - 1, false);
                    korkein = korkein > arvio ? korkein : arvio;
                }
            }
            return korkein;
        }
        else {
            int matalin = 999;
            for (int i = 0; i < koko; i++) {
                for (int j = 0; j < koko; j++) {
                    int arvio = minimax(i, j, syvyys - 1, false);
                    matalin = matalin < arvio ? matalin : arvio;
                }
            }
            return matalin;
        }
    }
    
    public int tilanteenArviointi() {
        PeliTilanteenArviointi arvio = new PeliTilanteenArviointi(lauta);
        int pisteet = 0;
        return 1;
    }
    
   
}
