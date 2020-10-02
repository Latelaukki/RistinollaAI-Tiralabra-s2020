/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinolla.logic;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import ristinolla.domain.Lauta;


public class VoittaminenTest {
    
    Lauta lauta;
    Voittaminen voittaminen;
    
    @Before
    public void setUp() {
        lauta = new Lauta();
        voittaminen = new Voittaminen(lauta);
        for (int i = 0; i < lauta.getKoko(); i++) {
            lauta.asetaLuku(1, i, 1);
            lauta.asetaLuku(i, 2, 1);
            lauta.asetaLuku(i, i, 1);
            lauta.asetaLuku(i, 4 - i, 1);
        }        
    }
    
    @Test
    public void pelaajaYksiSuoraLoytyyRivilta() {
        assertEquals(true, voittaminen.tarkistaRivi(1, 0, 1));
    }
    
    @Test
    public void pelaajaKaksiSuoraaEiloydyRivilta() {
        assertEquals(false, voittaminen.tarkistaRivi(1, 0, 2));
    }
    
    @Test
    public void pelaajaYksiSuoraLoytyySarakkeelta() {
        assertEquals(true, voittaminen.tarkistaSarake(0, 2, 1));
    }
    
    @Test
    public void pelaajaKaksiSuoraEiLoydySarakkeelta() {
        assertEquals(false, voittaminen.tarkistaSarake(0, 3, 2));
    }
    
    @Test
    public void pelaajaYksiSuoraLoytyyKaakkoDiagonaalista() {
        assertEquals(true, voittaminen.tarkistaKaakkoLuodeDiagonaali(0, 0, 1));
    }
    
    @Test
    public void pelaajaKaksiSuoraEiLoydyKaakkoDiagonaalista() {
        assertEquals(false, voittaminen.tarkistaKaakkoLuodeDiagonaali(0, 0, 2));
    }
    
    @Test
    public void pelaajaYksiSuoraLoytyyLounasKoillisDiagonaalista() {
        assertEquals(true, voittaminen.tarkistaLounasKoillisDiagonaali(0, 4, 1));
    }
    
    @Test
    public void pelaajaYksiSuoraEiLoydyLounasKoillisDiagonaalista() {
        assertEquals(false, voittaminen.tarkistaLounasKoillisDiagonaali(1, 3, 1));
    }
    
    @Test
    public void pelaajaYksiSuoraLoytyyLahtienLuodeNurkasta() {
        assertEquals(true, voittaminen.tarkistaDiagonaalit(0, 0, 1));
    }
    
    @Test
    public void pelaajYksiSuoraLoytyyLahtienKoillisNurkasta() {
        assertEquals(true, voittaminen.tarkistaDiagonaalit(0, 4, 1));
    } 
    
    @Test
    public void pelaajaKaksiSuoraEiLoydyKoillisNurkasta() {
        assertEquals(false, voittaminen.tarkistaDiagonaalit(0, 4, 2));
    }
}
