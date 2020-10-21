
package ristinolla.logic;

import ristinolla.domain.Lauta;

public class PelinKulku {
    private Lauta lauta;
    //private Voittaminen voittaminen;
    private int pelaajaVuorossa;
    private int voittaja;
    
    public PelinKulku() {
        this.lauta = new Lauta();
        //this.voittaminen = new Voittaminen(lauta);
        this.pelaajaVuorossa = 1; //pelaaja = 1, ai = 2 AINA, riippumatta kumpi aloittaa. Toistaiseksi pelaaja aloittaa
        this.voittaja = 0;
    }
    
    public void luoAi() {
        Ai ai = new Ai(this.lauta);
        int arvio = ai.minimax(0, 0, 5, 0, true);
        System.out.println("arvio: " + arvio);
        ai.bottiSiirto();
        if (arvio == 999999) {
            voittaja = 2;
        }
        if (arvio == -999999) {
            voittaja = 1;
        }
    }
    
    public int getPelaajaVuorossa() {
        return pelaajaVuorossa;
    }
    
    public void vuoronVaihto() {
        if (pelaajaVuorossa == 2) {
            pelaajaVuorossa = 1;
        } else {
            pelaajaVuorossa = 2;
        }
    }
    
    public boolean onkoTyhja(int y, int x) {
        return lauta.getPelaaja(y - 1, x - 1) == 0;
    } 
    
    public void teeSiirto(int y, int x) {
        lauta.asetaLuku(y - 1, x - 1, pelaajaVuorossa);
    }
    
    public int getVoittaja() {
        return voittaja;
    }
    
    public boolean peliP‰‰ttynyt() {
        return voittaja != 0;
    }
    
    public void tulostaLauta() {
        lauta.tulostaLauta();
    }
}
