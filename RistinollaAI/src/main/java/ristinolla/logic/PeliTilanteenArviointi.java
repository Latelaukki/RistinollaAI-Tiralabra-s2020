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
    int pelaaja;
    
    public PeliTilanteenArviointi(Lauta lauta, int pelaaja) {
        this.lauta = lauta;
        this.pisteet = 0;
        this.pelaaja = pelaaja;
        if (lauta.getKoko() > 5) {
            this.voittopisteet = 5;
        } else {
            voittopisteet = lauta.getKoko();
        }
    }
    
    public int laskePisteet() {
        for (int i = 0; i < lauta.getKoko(); i++) {
            for (int j = 0; j < lauta.getKoko(); j++) {
                if (this.laskeSuorat(i, j) == 0) {
                    this.vierekkaiset(i, j);
                }
            }
        }
        return pisteet;
    }
    
    public void vierekkaiset(int y, int x) {
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
    
    public int laskeSuorat(int y, int x) {
        int r, s, k, l; //välipisteet, joilla tunnistetaan syntyneitä haarukoita, joista saa lisäpisteitä
        r = this.laskeRivi(y, x);
        s = this.laskeSarake(y, x);
        k = this.laskeKaakkoLuodeDiagonaali(y, x);
        l = this.laskeLounasKoillisDiagonaali(y, x);
        if (r == voittopisteet || s == voittopisteet || k == voittopisteet || l == voittopisteet ) {
            pisteet = 99999;
        }
        else {
            this.laskeHaarukat(r, s, k, l);
            pisteet += r + s + k + l;
        }
        return pisteet;
    }
    
    
    public int laskeRivi(int y, int x) {
        int valiPisteet = 0;
        for (int i = x + 1; i < lauta.getKoko(); i++) {
            if (lauta.getPelaaja(y, i) == this.pelaaja) {
                valiPisteet++;
            }
        }
        return valiPisteet;
    }
    
    public int laskeSarake(int y, int x) { //aika copypaste-metodi, korjaan myöhemmin
        int valiPisteet = 0;
        for (int i = y + 1; i < lauta.getKoko(); i++) {
            if (lauta.getPelaaja(i, x) == this.pelaaja) {
                valiPisteet++;
            }
        }
        return valiPisteet;
    }   
    
    public int laskeKaakkoLuodeDiagonaali(int y, int x) {
        int valiPisteet = 0;
        int j = x + 1;
        for (int i = y + 1; i < lauta.getKoko() && j < lauta.getKoko(); i++, j++) {
            if (lauta.getPelaaja(i, j) == pelaaja) {
                valiPisteet++;
            }           
        }
        return valiPisteet;
    }
    
    public int laskeLounasKoillisDiagonaali(int y, int x) {
        int valiPisteet = 0;
        int j = x - 1;
        for (int i = y + 1; i < lauta.getKoko(); i++, j--) {
            if (lauta.getPelaaja(i, j) == pelaaja) {
                valiPisteet++;
            }      
        }
        return valiPisteet;
    }
    
    public void laskeHaarukat(int r, int s, int k, int l) {
        if (r > 2 && s > 2) { //haarukat, jotka ovat 3+ pitkiä, tuottavat lisäpisteitä 
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
