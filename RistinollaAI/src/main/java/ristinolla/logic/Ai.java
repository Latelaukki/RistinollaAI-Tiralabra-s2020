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
    }
    
    public void bottiSiirto() { 
        lauta.asetaLuku(this.y, this.x, 2);
    }
    
    public int minimax(int y, int x, int  maxsyvyys, int syvyys, boolean maksimoiva_pelaaja) {
        if (syvyys == maxsyvyys) {
            return tilanteenArviointi();
        }
        if (maksimoiva_pelaaja) {       
            int korkein = -999999;
            for (int i = 0; i < koko; i++) {
                for (int j = 0; j < koko; j++) {
                    if (lauta.getPelaaja(i, j) != 0) {
                        continue;
                    }
                    lauta.asetaLuku(i, j, 2);                   
                    int arvio = minimax(i, j, maxsyvyys, syvyys + 1, false);
                    lauta.asetaLuku(i, j, 0);
                    if (arvio > korkein) {
                        korkein = arvio;    
                        if (syvyys == 0) {
                            this.y = i;
                            this.x = j;
                        }
                    }
                    
                }
            }
            return korkein;
        }
        else {
            int matalin = 999999;
            for (int i = 0; i < koko; i++) {
                for (int j = 0; j < koko; j++)  {
                    if (lauta.getPelaaja(i, j) != 0) {
                        continue;
                    }
                    lauta.asetaLuku(i, j, 1);
                    int arvio = minimax(i, j, maxsyvyys, syvyys + 1, true);
                    lauta.asetaLuku(i, j, 0);
                    matalin = matalin < arvio ? matalin : arvio;
                }
            }
            return matalin;
        }
    }
    
    public int tilanteenArviointi() { 
        PeliTilanteenArviointi arvio = new PeliTilanteenArviointi(lauta);
        int pisteet = arvio.laskePisteet();
        return pisteet;
    }
    
}
