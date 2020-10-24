package ristinolla.ui;

import ristinolla.logic.PelinKulku;
import java.util.Scanner;

public class Kayttoliittyma {
    public void start() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Tervetuloa pelaamaan laajaa ristinollaa, toiselta nimeltaan jatkanshakkia."
                + "\nSiirrot tehdaan antamalla halutun pisteen koordinaatit.");
        int n;
        while(true) {
            System.out.println("Syota ruudukon koko (3-15): ");
            try {
                n  = Integer.valueOf(reader.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Koon on oltava luku");
                continue;
            }
            if (n < 3 || n > 15) {
                System.out.println("Anna luku valilta 3-15");
                continue;
            }
            break;          
        }
        PelinKulku peli = new PelinKulku(n);
        System.out.println("Valitse pelaajien lkm 0-2.");
        System.out.println("0 pelaajaa: Tietokone pelaa itseaan vastaan");
        System.out.println("1 pelaaja: Pelaa tietokonetta vastaan");
        System.out.println("2 pelaajaa: Pelaa toista pelaajaa vastaan");
        int lkm;
        while(true) {
            System.out.println("Pelaajien lkm: ");
            try {
                lkm  = Integer.valueOf(reader.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lkm on oltava luku");
                continue;
            }
            if (lkm < 0 || lkm > 2) {
                System.out.println("Anna luku valilta 0-2");
                continue;
            }
            break;                
        }
        while (!peli.peliPäättynyt()) {
            peli.tulostaLauta();
            System.out.println("");
            if ((peli.getPelaajaVuorossa() == 1 && lkm > 0) || (peli.getPelaajaVuorossa() == 2 && lkm == 2)) {
                System.out.println("Pelaaja " + peli.getPelaajaVuorossa() + " vuoro");
                while(true) {
                    int y, x;
                    while(true) {
                        System.out.println("y-koordinaatti: ");
                        try {
                            y  = Integer.valueOf(reader.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Koordinaatin on oltava luku");
                            continue;
                        }
                        if (y < 1 || y > n) {
                            System.out.println("Anna luku valilta 1-" + n);
                            continue;
                        }
                        break;                
                    }
                    while(true) {
                        System.out.println("x-koordinaatti: ");
                        try {
                            x  = Integer.valueOf(reader.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Koordinaatin on oltava luku");
                            continue;
                        }
                        if (x < 1 || x > n) {
                            System.out.println("Anna luku valilta 1-" + n);
                            continue;
                        }
                        break;
                    }   
                    if (peli.onkoRuutuTyhja(y, x)) {
                        peli.teeSiirto(y, x);
                        break;
                    }
                    else {
                        System.out.println("Ruutu ei ole tyhja, anna uudet koordinaatit");    
                    }
                }
            }
            if ((peli.getPelaajaVuorossa() == 2 && lkm == 1) || lkm == 0) {
                peli.luoAi();
                System.out.println("Lasketut siirrot: " + peli.lasketutSiirrot());
            }         
            peli.vuoronVaihto();
        }
        peli.tulostaLauta();
        System.out.println("");
        if (lkm == 1) {
            if (peli.getVoittaja() == 2) {
                System.out.println("Pahoittelut, havisit pelin!");
            } 
            if (peli.getVoittaja() == 1) {
                System.out.println("Onneksi olkoon, voitit pelin!");
            }
            else {
                System.out.println("Peli paattyi tasapeliin.");
            }
        }
        else if (lkm == 2) {
            if (peli.getVoittaja() == 1) {
                System.out.println("Pelaaja 1 voitti.");
            } 
            if (peli.getVoittaja() == 2) {
                System.out.println("Pelaaja 2 voitti");
            }
            else {
                System.out.println("Peli paattyi tasapeliin.");
            }
        }
    }
}
