package ristinolla.domain;

/**
 * Luokka, joka sis‰lt‰‰ pelilaudan, jolle kaikki siirrot tapahtuvat.
 *
 */
public class Lauta {
    private int [][] lauta;
   
    public Lauta(int n) {
        this.lauta = new int[n][n];
    }
   
    /**
    * Metodi siirtojen asettamista varten.
    *
    * @param    y   koordinaatit alkaen 0:sta
    * @param    x   
    * @param    pelaajan_id 1 tai 2, bottia vastaan botti 2
    */
    public void asetaLuku(int y, int x, int pelaajan_id) {
        lauta[y][x] = pelaajan_id; 
    }
   
    /**
    * Palauttaa laudan koon.
    * 
    * @return   
    */
    public int getKoko() {
        return lauta.length;
    }
   
    /**
    * Palauttaa laudan pisteen arvon annetuilla koordinaateilla.
    * 
    * @param    y
    * @param    x   
    * 
    * @return   1, 2 tai 0, jos tyhj‰ eli ei pelattu
    */
    public int getPelaaja(int y, int x) {
        return lauta[y][x];
    }
    
    /**
    * Kertoo, onko pelilauta pelattu t‰yteen.
    * 
    * @return   true, jos t‰ynn‰
    */
    public boolean onkoTaynna() {
        int n = 0;
        for (int i = 0; i < lauta.length; i++) {
            for (int j = 0; j < lauta.length; j++) {
                if (lauta[i][j] == 0) {
                    n++;
                }
            }
        }
        return n == 0;
    }
    
    /**
     * Tulostaa laudan tekstin‰.
     */
    public void tulostaLauta() {
        int luku;
        System.out.print(" ");
        char x = 'A';
        for (int k = 0; k < lauta.length; k++) {
            if (k > 8) {
                System.out.print(" " + x);
                x++;
            }
            else {
                System.out.print(" " + (k + 1));
            }          
        }
        System.out.println("");
        x = 'A';
        for (int i = 0; i < lauta.length; i++) {
            if (i > 8) {
                System.out.print(x + " ");
                x++;
            }
            else {
                System.out.print(i + 1 + " ");
            }          
            for (int j = 0; j < lauta.length; j++) {
                luku = lauta[i][j];
                System.out.print(merkkiTulostukseen(luku));
            }
            System.out.println("");
        }
    }
    
     /**
     * Tulostuksen apumetodi.
     * 
     * @return X = pelaaja 1, O = pelaaja 2/botti, * = tyhj‰
     */
    public String merkkiTulostukseen(int luku) {
        switch (luku) {
            case 1:
                return "X ";
            case 2:
                return "O ";
            default:
                return "* ";
        }       
    }
}
