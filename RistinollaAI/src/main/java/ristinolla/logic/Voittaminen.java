//
//package ristinolla.logic;
//
//import ristinolla.domain.Lauta;
//
//public class Voittaminen {    //luultavasti jää turhaksi luokaksi
//    private Lauta lauta;
//    private int voittopisteet;
//    private int koko;
//
//    public Voittaminen(Lauta lauta) {
//        this.lauta = lauta;
//        this.koko = lauta.getKoko();
//        if (koko > 5) {
//            this.voittopisteet = 5;
//        } else {
//            voittopisteet = koko;
//        }
//    }
//    
//    
//    public int onkoVoittanut() {
//        int pelaaja = 0;       
//        for (int i = 0; i < koko; i++) {
//            for (int j = 0; j < koko; j++) {
//                pelaaja = lauta.getPelaaja(i, j);
//                if (pelaaja != 0) {
//                    if (etsiSuoria(i, j, pelaaja)) {
//                        return pelaaja;
//                    }
//                }                
//            }
//        }
//        return pelaaja;
//    }
//    
//    public boolean etsiSuoria(int y, int x, int pelaaja) {
//        return tarkistaRivi(y, x, pelaaja) || tarkistaSarake(y, x, pelaaja) 
//                || tarkistaDiagonaalit(y, x, pelaaja);
//    }
//    
//    public boolean tarkistaDiagonaalit(int y, int x, int pelaaja) {
//       return tarkistaKaakkoLuodeDiagonaali(y, x, pelaaja) || tarkistaLounasKoillisDiagonaali(y, x, pelaaja);
//    }
//    
//    public boolean tarkistaRivi(int y, int x, int pelaaja) {
//        int pisteet = 1;
//        if (koko - x < voittopisteet) { //mahtuuko riville suoraa
//            return false;
//        }
//        for (int i = x + 1; i < koko; i++) {
//            if (lauta.getPelaaja(y, i) == pelaaja) {
//                pisteet++;
//            }
//        }
//        return pisteet == voittopisteet;
//    }
//    
//    public boolean tarkistaSarake(int y, int x, int pelaaja) { //aika copypaste-metodi, korjaan myöhemmin
//        int pisteet = 1;
//        if (koko - y < voittopisteet) { //mahtuuko sarakkeelle suoraa
//            return false;
//        }
//        for (int i = y + 1; i < koko; i++) {
//            if (lauta.getPelaaja(i, x) == pelaaja) {
//                pisteet++;
//            }
//        }
//        return pisteet == voittopisteet;     
//    }   
//    
//    public boolean tarkistaKaakkoLuodeDiagonaali(int y, int x, int pelaaja) {
//        int pisteet = 1;
//        if (koko - x < voittopisteet || koko - y < voittopisteet) { //mahtuuko diagonaalille suoraa
//            return false;
//        }
//        int j = x + 1;
//        for (int i = y + 1; i < koko && j < koko ; i++, j++) {
//            if (lauta.getPelaaja(i, j) == pelaaja) {
//                pisteet++;
//            }
//            
//        }
//        return pisteet == voittopisteet;
//    }
//    
//    public boolean tarkistaLounasKoillisDiagonaali(int y, int x, int pelaaja) {
//        int pisteet = 1;
//        if (x + 1 - voittopisteet < 0 || koko - y < voittopisteet) { //mahtuuko diagonaalille suoraa
//            return false;
//        }
//        int j = x - 1;
//        for (int i = y + 1; i < koko; i++, j--) {
//            if (lauta.getPelaaja(i, j) == pelaaja) {
//                pisteet++;
//            }      
//        }
//        return pisteet == voittopisteet;
//    }
//}
