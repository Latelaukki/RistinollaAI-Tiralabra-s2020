
package ristinolla.logic;

import ristinolla.domain.Lauta;

    /**
     * Luokka, joka toimii k�ytt�liittym�n ja muiden luokkien v�lisen� operoijana.
     */

public class PelinKulku {
    private Lauta lauta;
    private int pelaajaVuorossa;
    private int voittaja;
    private int lkm;
    
    public PelinKulku(int n) {
        this.lauta = new Lauta(n);
        this.pelaajaVuorossa = 1; //pelaaja = 1, ai = 2 AINA, riippumatta kumpi aloittaa. Toistaiseksi pelaaja aloittaa
        this.voittaja = 0;
        this.lkm = 0;
    }
    
    
    /**
     * Luo uuden ai-olion, joka vuorolla. Suorittaa siirron laskennan, siirron ja ker�� laskettujen 
     * siirtojen lukum��r�n oliolta
     */
    public void luoAi() {
        Ai ai = new Ai(this.lauta);
        int arvio = ai.minimax(0, 0, 4, 0, -99999, 99999, true);
        ai.bottiSiirto(pelaajaVuorossa);
        if (arvio == 9999) {
            voittaja = 2;
        }
        if (arvio == -9999) {
            voittaja = 1;
        }
        lkm = ai.getLkm();
    }
    
    /**
     * Palauttaa laskettujen siirtojen lkm tehokkuustarkastelua varten.
     * 
     * @return lkm
     */
    public int lasketutSiirrot() {
        return this.lkm;
    }
    
    /**
     * Tarkistaa, onko lauta pelattu t�yteen tasapelin varalta.
     * 
     * @return true = t�ynn�
     */
    public boolean onkoTaynna() {
        return lauta.onkoTaynna();
    }
    
    /**
     * Palauttaa vuorossa olevan pelaajan.
     * 
     * @return 1 tai 2, botti 2, jos peliss�
     */
    public int getPelaajaVuorossa() {
        return pelaajaVuorossa;
    }
    
    /**
     * Vaihtaa vuorossa olevaa pelaaja. Jos edellinen 1, niin vaihtaa 2 ja toisin p�in
     */
    public void vuoronVaihto() {
        if (pelaajaVuorossa == 2) {
            pelaajaVuorossa = 1;
        } else {
            pelaajaVuorossa = 2;
        }
    }
    
    /**
     * Tarkistaa voiko ruutuun pelata. Tarkistetaan pelaajan siirron aikana
     * 
     * @param   y, pelaajalta pyydetyt koordinaatit
     * @param   x, pelaajalta pyydetyt koordinaatit
     * 
     * @return true, jos tyhj�
     */
    public boolean onkoRuutuTyhja(int y, int x) {
        return lauta.getPelaaja(y - 1, x - 1) == 0;
    } 
    
    /**
     * Suorittaa pelaajan siirron.
     * 
     * @param   y, pelaajalta pyydetyt koordinaatit
     * @param   x, pelaajalta pyydetyt koordinaatit
     */
    public void teeSiirto(int y, int x) {
        lauta.asetaLuku(y - 1, x - 1, pelaajaVuorossa);
    }
    
    /**
     * Palauttaa voittajan tunnuksen, jos sellainen on l�ytynyt.
     * 
     * @return 0, 1, 2, 3. 0 jos ei voittajaa l�ytynyt, 3 apulukuna kertomaan tasapelist�
     */
    public int getVoittaja() {
        return voittaja;
    }
    
    /**
     * Pelin p��tt�misen tarkistava metodi. Etsii voittajaa tai tasapeli�
     * 
     * @return true, jos voittaja l�ytynyt tai tasapeli, muuten false
     */
    public boolean peliP��ttynyt() {
        PeliTilanteenArviointi arviointi = new PeliTilanteenArviointi(lauta);
        switch (arviointi.etsiVoittajaa()) {
            case 9999:
                voittaja = 2;
            case -9999:
                voittaja = 1;
        }
        if (onkoTaynna()) {
            voittaja = 3;
        }
        return voittaja != 0;
    }
    
    /**
     * K�ytt�liittym�n ja Lauta-luokan v�linen apumetodi laudan tekstitulostukseen.
     */
    public void tulostaLauta() {
        lauta.tulostaLauta();
    }
}
