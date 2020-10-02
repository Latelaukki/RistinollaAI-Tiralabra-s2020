/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinolla.logic;
import ristinolla.domain.Lauta;

public class PeliTilanteenArviointi {
    int voittopisteet;
    int pisteet;
    Lauta lauta;
    
    public PeliTilanteenArviointi(Lauta lauta) {
        this.lauta = lauta;
        this.pisteet = 0;
        if (lauta.getKoko() > 5) {
            this.voittopisteet = 5;
        } else {
            voittopisteet = lauta.getKoko();
        }
    }
    
    public int laskePisteet() { //pisteiden laskussa toistaiseksi viel‰ useampi ongelma, esim samoja pisteit‰...
        int pelaaja = 0;        //...lasketaan useaan kertaan. Lis‰ksi molempien pelaajien suorat lis‰‰v‰t pisteit‰
        for (int i = 0; i < lauta.getKoko(); i++) {
            for (int j = 0; j < lauta.getKoko(); j++) {
                pelaaja = lauta.getPelaaja(i, j);
                if (pelaaja == 0) {
                    continue;
                }
                if (this.laskeSuorat(i, j, pelaaja) == 0) {
                    this.vierekkaiset(i, j, pelaaja);
                }
            }
        }
        return pisteet;
    }
    
    public void vierekkaiset(int y, int x, int pelaaja) {
        for (int i = y - 1; i < 2; i++) {
            for (int j = x - 1; j < 2; j++) {
                if (i > -1 && j > -1 && i != y && j != x && i < lauta.getKoko() && j < lauta.getKoko() ) {
                    if (lauta.getPelaaja(i, j) == pelaaja) {
                        pisteet++;
                    }
                }
            }
        }
    }
    
    public int laskeSuorat(int y, int x, int pelaaja) {
        int r, s, k, l; //v‰lipisteet, joilla tunnistetaan syntyneit‰ haarukoita, joista saa lis‰pisteit‰
        r = this.laskeRivi(y, x, pelaaja);
        s = this.laskeSarake(y, x, pelaaja);
        k = this.laskeKaakkoLuodeDiagonaali(y, x, pelaaja);
        l = this.laskeLounasKoillisDiagonaali(y, x, pelaaja);
        if (r == voittopisteet || s == voittopisteet || k == voittopisteet || l == voittopisteet ) {
            pisteet = 99999;
        }
        else {
            this.laskeHaarukat(r, s, k, l);
            pisteet += r + s + k + l;
        }
        return pisteet;
    }
    
    
    public int laskeRivi(int y, int x, int pelaaja) {
        int valiPisteet = 0;
        for (int i = x + 1; i < lauta.getKoko(); i++) {
            if (lauta.getPelaaja(y, i) == pelaaja) {
                if (pelaaja == 1) { 
                    valiPisteet--;
                } 
                if (pelaaja == 2) {
                    valiPisteet++;
                }
            }
        }
        return valiPisteet;
    }
    
    public int laskeSarake(int y, int x, int pelaaja) { //aika copypaste-metodi, korjaan myˆhemmin
        int valiPisteet = 0;
        for (int i = y + 1; i < lauta.getKoko(); i++) {
            if (lauta.getPelaaja(i, x) == pelaaja) {
                if (pelaaja == 1) { 
                    valiPisteet--;
                } 
                if (pelaaja == 2) {
                    valiPisteet++;
                }
            }
        }
        return valiPisteet;
    }   
    
    public int laskeKaakkoLuodeDiagonaali(int y, int x, int pelaaja) {
        int valiPisteet = 0;
        int j = x + 1;
        for (int i = y + 1; i < lauta.getKoko() && j < lauta.getKoko(); i++, j++) {
            if (lauta.getPelaaja(i, j) == pelaaja) {
                if (pelaaja == 1) { 
                    valiPisteet--;
                } 
                if (pelaaja == 2) {
                    valiPisteet++;
                }
            }           
        }
        return valiPisteet;
    }
    
    public int laskeLounasKoillisDiagonaali(int y, int x, int pelaaja) {
        int valiPisteet = 0;
        int j = x - 1;
        for (int i = y + 1; i < lauta.getKoko(); i++, j--) {
            if (lauta.getPelaaja(i, j) == pelaaja) {
                if (pelaaja == 1) { 
                    valiPisteet--;
                } 
                if (pelaaja == 2) {
                    valiPisteet++;
                }
            }      
        }
        return valiPisteet;
    }
    
    public void laskeHaarukat(int r, int s, int k, int l) {
        if (r > 2 && s > 2) { //haarukat, jotka ovat 3+ pitki‰, tuottavat lis‰pisteit‰ 
            pisteet += 50; 
        }
        if (r > 2 && k > 2) { 
            pisteet += 50;
        }
        if (r > 2 && l > 2) {
            pisteet += 50;
        }
        if (s > 2&& k > 2) {
            pisteet += 50;
        }
        if (s > 2 && l > 2) {
            pisteet += 50;
        }
        if (k > 2 && l > 2) {
            pisteet += 50;
        }
    }
}
