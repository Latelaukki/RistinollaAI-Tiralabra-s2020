/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinolla.logic;
import ristinolla.domain.Lauta;

public class PeliTilanteenArviointi {
    int voittopisteet;
    Lauta lauta;
    
    public PeliTilanteenArviointi(Lauta lauta) {
        this.lauta = lauta;
        if (lauta.getKoko() >= 5) {
            this.voittopisteet = 4; //tarkasteltavaa ruutua ei lasketa mukaan
        } else {
            voittopisteet = lauta.getKoko() - 1;
        }
    }
    
    public int laskePisteet() { //pisteiden laskussa toistaiseksi viel‰ useampi ongelma, esim samoja pisteit‰...
        int valipisteet = 0; //...lasketaan useaan kertaan. Lis‰ksi molempien pelaajien suorat lis‰‰v‰t pisteit‰
        for (int i = 0; i < lauta.getKoko(); i++) {
            for (int j = 0; j < lauta.getKoko(); j++) {
                int pelaaja = lauta.getPelaaja(i, j);
                if (pelaaja == 0) {
                    continue;
                }
                valipisteet += this.laskeSuorat(i, j, pelaaja);
                if (valipisteet == 999999 || valipisteet == -999999) {
                    return valipisteet;
                }
                valipisteet += this.laskeVierekkaiset(i, j, pelaaja);
            }
        }
        return valipisteet;
    }
    
    public int laskeVierekkaiset(int y, int x, int pelaaja) {
        int valipisteet = 0;
        for (int i = y - 1; i < y + 2; i++) {
            for (int j = x - 1; j < x + 2; j++) {
                if (i > -1 && j > -1 && (i != y || j != x) && i < lauta.getKoko() && j < lauta.getKoko() ) {
                    if (lauta.getPelaaja(i, j) == pelaaja) { 
                        if (pelaaja == 1) { //pelaajan pisteet laskee tulosta, botin nostaa
                            valipisteet--;
                        } 
                        else {
                            valipisteet++;
                        }
                    }
                }
            }
        }
        return valipisteet;
    }
    
    public int laskeSuorat(int y, int x, int pelaaja) {
        int valipisteet = 0;
        int r, s, k, l; //v‰lipisteet, joilla tunnistetaan syntyneit‰ haarukoita, joista saa lis‰pisteit‰
        r = this.laskeRivi(y, x, pelaaja);
        s = this.laskeSarake(y, x, pelaaja);
        k = this.laskeLuodeKaakkoDiagonaali(y, x, pelaaja);
        l = this.laskeKoillisLounasDiagonaali(y, x, pelaaja);
        if (r == voittopisteet || s == voittopisteet || k == voittopisteet || l == voittopisteet 
                || r == -voittopisteet || s == -voittopisteet || k == -voittopisteet || l == -voittopisteet) {
            valipisteet = (pelaaja == 1) ? -999999 : 999999;
        }
        else {
            valipisteet += this.laskeHaarukat(r, s, k, l, pelaaja);
            valipisteet += r + s + k + l;
        }
        return valipisteet;
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
            } else {
                break; //pisteit‰ ei tule yksitt‰isist‰
            }
        }
        return valiPisteet;
    }
    
    public int laskeSarake(int y, int x, int pelaaja) {
        int valiPisteet = 0;
        for (int i = y + 1; i < lauta.getKoko(); i++) {
            if (lauta.getPelaaja(i, x) == pelaaja) {
                if (pelaaja == 1) { 
                    valiPisteet--;
                } 
                if (pelaaja == 2) {
                    valiPisteet++;
                }
            } else {
                break;
            }
        }
        return valiPisteet;
    }   
    
    public int laskeLuodeKaakkoDiagonaali(int y, int x, int pelaaja) {
        int valiPisteet = 0;
        for (int i = y + 1,  j = x + 1; i < lauta.getKoko() && j < lauta.getKoko(); i++, j++) {
            if (lauta.getPelaaja(i, j) == pelaaja) {
                if (pelaaja == 1) { 
                    valiPisteet--;
                } 
                if (pelaaja == 2) {
                    valiPisteet++;
                }
            } else {
                break;
            }           
        }
        return valiPisteet;
    }
    
    public int laskeKoillisLounasDiagonaali(int y, int x, int pelaaja) {
        int valiPisteet = 0;
        for (int i = y + 1, j = x - 1; i < lauta.getKoko() && j > 0; i++, j--) {
           // System.out.println("i: " + i + "j: " + j);
            if (lauta.getPelaaja(i, j) == pelaaja) {
                if (pelaaja == 1) { 
                    valiPisteet--;
                } 
                if (pelaaja == 2) {
                    valiPisteet++;
                }
            } else {
                break;
            }      
        }
        return valiPisteet;
    }
    
    public int laskeHaarukat(int r, int s, int k, int l, int pelaaja) {
        int valipisteet = 0;
        if (r > 1 && s > 1) { //haarukat, jotka ovat yli 3 pitki‰, tuottavat lis‰pisteit‰ eli suorapisteit‰ on 2+
            valipisteet += 50; 
        }
        if (r > 1 && k > 1) { 
            valipisteet += 50;
        }
        if (r > 1 && l > 1) {
            valipisteet += 50;
        }
        if (s > 1 && k > 1) {
            valipisteet += 50;
        }
        if (s > 1 && l > 1) {
            valipisteet += 50;
        }
        if (k > 1 && l > 1) {
            valipisteet += 50;
        }
        valipisteet = (pelaaja == 1) ? -1 * valipisteet : valipisteet;
        return valipisteet;
    }
}
