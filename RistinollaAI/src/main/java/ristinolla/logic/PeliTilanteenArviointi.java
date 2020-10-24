/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinolla.logic;
import ristinolla.domain.Lauta;

    /**
     * Luokka laudan pelitilanteen arvioimiseen.
     */

public class PeliTilanteenArviointi {
    int voittopisteet;
    Lauta lauta;
    
    public PeliTilanteenArviointi(Lauta lauta) {
        this.lauta = lauta;
        if (lauta.getKoko() >= 5) {
            this.voittopisteet = 16; //tarkasteltavaa ruutua ei lasketa mukaan
        } 
        else if (lauta.getKoko() == 4) {
            this.voittopisteet = 8;
        }
        else {
            this.voittopisteet = 4;
        }
    }
    
     /**
     * Tarkistaa laudalta, löytyykö voittajaa.
     * 
     * @return 9999, jos pelaaja 2/botti on voittanut. -9999, jos pelaaja 1/oikea pelaaja
     */
    public int etsiVoittajaa() {
        for (int i = 0; i < lauta.getKoko(); i++) {
            for (int j = 0; j < lauta.getKoko(); j++) {
                int pelaaja = lauta.getPelaaja(i, j);
                if (pelaaja == 0) {
                    continue;
                }
                if (laskeRivi(i, j, pelaaja) == voittopisteet || laskeSarake(i, j, pelaaja) == voittopisteet 
                    || laskeLuodeKaakkoDiagonaali(i, j, pelaaja) == voittopisteet || laskeKoillisLounasDiagonaali(i, j, pelaaja) == voittopisteet) {
                    return 9999;    
                }
                if (laskeRivi(i, j, pelaaja) == -voittopisteet || laskeSarake(i, j, pelaaja) == -voittopisteet 
                    || laskeLuodeKaakkoDiagonaali(i, j, pelaaja) == -voittopisteet || laskeKoillisLounasDiagonaali(i, j, pelaaja) == -voittopisteet) {
                    return -9999;    
                }    
            }
        }
        return 0;
    }
    
     /**
     * Laskee suorat ja vierekkäiset pisteet. Jokaisesta laudan kohdasta lasketaan siinä 
     *  olevan pelaajan mukaan pisteitä joko vierekkäisistä tai suorista. Skippaa tyhjät ruudut
     * 
     * @return Palauttaa laudan heurestisen arvion pelitilanteesta.
     */
    public int laskePisteet() { 
        int valipisteet = 0; 
        for (int i = 0; i < lauta.getKoko(); i++) {
            for (int j = 0; j < lauta.getKoko(); j++) {
                int pelaaja = lauta.getPelaaja(i, j);
                if (pelaaja == 0) {
                    continue;
                }
                valipisteet += this.laskeSuorat(i, j, pelaaja);
                valipisteet += this.laskeVierekkaiset(i, j, pelaaja);
            }
        }
        return valipisteet;
    }
    
     /**
     * Laskee kentän pisteeseen pelatun kohdan vierekkäiset pisteet. Antaa tai vähentää pisteen jokaisesta vierekkäisestä
     * saman pelaajatunnuksen pisteestä. Pelaaja 1 vierekkäiset pelaaja 1:n pisteet vähentävät tulosta. 
     * Pelaaja 2:n kasvattaa
     * 
     * @param   y pisteen koordinaatit
     * @param   x
     * @param   pelaaja pelaajan tunnus 1 tai 2
     * 
     * @return Palauttaa pisteet, 0 jos ei vierekkäisiä
     */
    public int laskeVierekkaiset(int y, int x, int pelaaja) {
        int valipisteet = 0;
        for (int i = y - 1; i < y + 2; i++) {
            for (int j = x - 1; j < x + 2; j++) {
                if (i > -1 && j > -1 && (i != y || j != x) && i < lauta.getKoko() && j < lauta.getKoko() ) {
                    if (lauta.getPelaaja(i, j) == pelaaja) { 
                        if (pelaaja == 1) { 
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
    
    /**
     * Laskee yhdistetysti annetusta pisteestä lähtevät saman pelaajan suorat.
     * Ei laske taaksepäin, vaan aina y-suunnassa kasvavana tai samana
     * 
     * @param   y
     * @param   x
     * @param   pelaaja pelaajan tunnus 1 tai 2
     * 
     * @return  Kaikkien eri suuntiin lähtevien suorien antamien pisteiden summa
     */
    public int laskeSuorat(int y, int x, int pelaaja) {
        int valipisteet = 0;
        int r, s, k, l; //välipisteet, joilla tunnistetaan syntyneitä haarukoita, joista saa lisäpisteitä
        r = this.laskeRivi(y, x, pelaaja);
        s = this.laskeSarake(y, x, pelaaja);
        k = this.laskeLuodeKaakkoDiagonaali(y, x, pelaaja);
        l = this.laskeKoillisLounasDiagonaali(y, x, pelaaja);
        valipisteet += r + s + k + l;
        return valipisteet;
    }
    
    /**
     * Laskee annetusta pisteestä annetun pelaajan yhtenäisen rivin pituuden. Kasvaa eksponentiaalisesti x*2
     * 
     * @param   y
     * @param   x
     * @param   pelaaja pelaajan tunnus 1 tai 2
     * 
     * @return  Yhden suora 1 piste, kahden 2, kolmen 4, neljän 8...
     */
    public int laskeRivi(int y, int x, int pelaaja) {
        int valipisteet;
        if (pelaaja == 1) {
            valipisteet = -1;
        }
        else {
            valipisteet = 1;
        }
        for (int i = x + 1; i < lauta.getKoko(); i++) {
            if (lauta.getPelaaja(y, i) == pelaaja) {
                valipisteet *= 2;
            }
            else {
                break;
            }
        }
        return valipisteet;
    }
    
    /**
     * Laskee annetusta pisteestä annetun pelaajan yhtenäisen sarakkeen pituuden. 
     * 
     * @param   y
     * @param   x
     * @param   pelaaja pelaajan tunnus 1 tai 2
     * 
     * @return  Yhden suora 1 piste, kahden 2, kolmen 4, neljän 8...
     */
    public int laskeSarake(int y, int x, int pelaaja) {
        int valipisteet;
        if (pelaaja == 1) {
            valipisteet = -1;
        }
        else {
            valipisteet = 1;
        }
        for (int i = y + 1; i < lauta.getKoko(); i++) {
            if (lauta.getPelaaja(i, x) == pelaaja) {
                valipisteet *= 2;
            } 
            else {
                break;
            }
        }
        return valipisteet;
    }   
    
    /**
     * Laskee annetusta pisteestä annetun pelaajan yhtenäisen diagonaalin vasemmasta yläkulmasta oikeaan alakulmaan 
     * 
     * @param   y
     * @param   x
     * @param   pelaaja pelaajan tunnus 1 tai 2
     * 
     * @return  Yhden suora 1 piste, kahden 2, kolmen 4, neljän 8...
     */
    public int laskeLuodeKaakkoDiagonaali(int y, int x, int pelaaja) {
        int valipisteet;
        if (pelaaja == 1) {
            valipisteet = -1;
        }
        else {
            valipisteet = 1;
        }
        for (int i = y + 1,  j = x + 1; i < lauta.getKoko() && j < lauta.getKoko(); i++, j++) {
            if (lauta.getPelaaja(i, j) == pelaaja) {
                valipisteet *= 2;
            }       
            else {
                break;
            }
        }
        return valipisteet;
    }
    
    /**
     * Laskee annetusta pisteestä annetun pelaajan yhtenäisen diagonaalin oikeasta yläkulmasta vasempaan alakulmaan 
     * 
     * @param   y
     * @param   x
     * @param   pelaaja pelaajan tunnus 1 tai 2
     * 
     * @return  Yhden suora 1 piste, kahden 2, kolmen 4, neljän 8...
     */
    public int laskeKoillisLounasDiagonaali(int y, int x, int pelaaja) {
        int valipisteet;
        if (pelaaja == 1) {
            valipisteet = -1;
        }
        else {
            valipisteet = 1;
        }
        for (int i = y + 1, j = x - 1; i < lauta.getKoko() && j > -1; i++, j--) {
            if (lauta.getPelaaja(i, j) == pelaaja) {
                valipisteet *= 2;
            }  
            else {
                break;
            }
        }
        return valipisteet;
    }
    
}
