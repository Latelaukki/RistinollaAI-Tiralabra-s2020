package ristinolla.ui;

import ristinolla.logic.PelinKulku;
import java.util.Scanner;

public class Kayttoliittyma {
    public void start() {
        PelinKulku peli = new PelinKulku();
        Scanner reader = new Scanner(System.in);
        System.out.println("Tervetuloa pelaamaan laajaa ristinollaa, toiselta nimeltaan jatkanshakkia."
                + "\nPeli toimii talla hetkella vain 5x5 ruudukossa. Siirrot tehdaan antamalla halutun pisteen koordinaatit.");
        while (!peli.peliP‰‰ttynyt()) {
            peli.tulostaLauta();
            System.out.println("");
            if (peli.getPelaajaVuorossa() == 1) {
                int y, x;
                while(true) {
                    System.out.println("y-koordinaatti: ");
                    try {
                        y  = Integer.valueOf(reader.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Koordinaatin on oltava luku");
                        continue;
                    }
                    if (y < 1 || y > 5) {
                        System.out.println("Anna luku valilta 1-5");
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
                    if (x < 1 || x > 5) {
                        System.out.println("Anna luku valilta 1-5");
                        continue;
                    }
                    peli.teeSiirto(y, x);
                    break;                
                }         
            }
            if (peli.getPelaajaVuorossa() == 2) {
                peli.luoAi();
            }
            peli.vuoronVaihto();
        }
        if (peli.getVoittaja() == 2) {
            System.out.println("Onneksi olkoon, havisit pelin!");
        } else {
            System.out.println("Onneksi olkoon, voitit pelin!");
        }
    }
}
