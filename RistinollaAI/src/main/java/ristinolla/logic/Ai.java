package ristinolla.logic;

import ristinolla.domain.Lauta;

    /**
     * Luokka tekoälyn siirron laskemiseen.
     * 
     */

public class Ai {
    private Lauta lauta;
    private int koko;
    private int y, x;
    PeliTilanteenArviointi arviointi;
    private int lkm;
    
    public Ai(Lauta lauta) {
        this.lauta = lauta;
        this.koko = lauta.getKoko();
        this.arviointi = new PeliTilanteenArviointi(lauta);
        this.y = 0;
        this.x = 0; 
        this.lkm = 0;
    }
    
     /**
     * Suorittaa botin siirron, kun tiedetään sen koordinaatit.
     * 
     * @param id    pelaajan tunnus: 1 tai 2, oikean pelaajan kanssa botti aina 2
     */
    public void bottiSiirto(int id) { 
        lauta.asetaLuku(this.y, this.x, id);
    }
    
     /**
     * Palauttaa laskettujen siirtojen lkm:n tehokkuustarkastelua varten.
     * 
     * @return int lkm
     */
    public int getLkm() {
        return this.lkm;
    }
    
     /**
     * Minimax-algoritmi, joka laskee kaikki mahdolliset siirrot läpi ja valitsee parhaan. Alfa-beeta -karsinta toteutettu tehostamaan
     * 
     * @param y, tarkasteltavan pisteen koordinaatit
     * @param x, tarkasteltavan pisteen koordinaatit
     * @param maxsyvyys pisin syvyys, jolle botti laskee. Nyt asetettu 5
     * @param syvyys    syvyys, jolla tällä hetkellä ollaan
     * @param alpha botin tähän asti paras pelitilanne
     * @param   beta    pelaajan tähän asti paras pelitilanne
     * @param   maksimoiva_pelaaja  vaihtelee true-false sen mukaan etsitäänkö botille vai pelaajalle parasta tulosta
     * 
     * @return laudan pelitilanteen arvio, 
     */
    public int minimax(int y, int x, int  maxsyvyys, int syvyys, int alpha, int beta, boolean maksimoiva_pelaaja) {
        if (syvyys == maxsyvyys) {
            return arviointi.laskePisteet();
        }
        if (maksimoiva_pelaaja) {       
            int korkein = -99999;
            for (int i = 0; i < koko; i++) {
                for (int j = 0; j < koko; j++) {
                    lkm++;
                    int voittaja = arviointi.etsiVoittajaa();
                    if (voittaja != 0) {
                       return voittaja;
                    }
                    if (lauta.getPelaaja(i, j) != 0) {
                        continue;
                    }
                    lauta.asetaLuku(i, j, 2);                   
                    int arvio = minimax(i, j, maxsyvyys, syvyys + 1, alpha, beta, false);
                    lauta.asetaLuku(i, j, 0);
                    if (arvio > korkein) {
                        korkein = arvio;    
                        if (syvyys == 0) {
                            this.y = i;
                            this.x = j;
                        }
                    }   
                    alpha = alpha > arvio ? alpha : arvio;
                    if (beta <= alpha) {
                        break;
                    }
                }
            }
            return korkein;
        }
        else {
            int matalin = 99999;
            for (int i = 0; i < koko; i++) {
                for (int j = 0; j < koko; j++)  {
                    int voittaja = arviointi.etsiVoittajaa();
                    if (voittaja != 0) {
                       return voittaja;
                    }
                    if (lauta.getPelaaja(i, j) != 0) {
                        continue;
                    }
                    lauta.asetaLuku(i, j, 1);
                    int arvio = minimax(i, j, maxsyvyys, syvyys + 1, alpha, beta, true);
                    lauta.asetaLuku(i, j, 0);
                    matalin = matalin < arvio ? matalin : arvio;
                    beta = beta < arvio ? beta : arvio;
                    if (beta <= alpha) {
                        break;
                    }
                }
            }
            return matalin;
        }
    }
}
