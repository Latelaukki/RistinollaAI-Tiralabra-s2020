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

/**
 *
 * @author laukk
 */
public class PeliTilanteenArviointiTest {
    
    Lauta lauta;
    PeliTilanteenArviointi arvio;
    
    
    @Before
    public void setUp() {
        lauta = new Lauta(5);
        arvio = new PeliTilanteenArviointi(lauta);
        lauta.asetaLuku(0, 4, 1);
        lauta.asetaLuku(1, 3, 1);
        lauta.asetaLuku(2, 2, 1);
        lauta.asetaLuku(0, 1, 2);
        lauta.asetaLuku(1, 1, 2);
        lauta.asetaLuku(2, 1, 2);
        lauta.asetaLuku(1, 2, 2);
    }

    @Test
    public void laskeRiviPisteetOikein() {
        assertEquals(-1, arvio.laskeRivi(0, 4, 1));
        assertEquals(2, arvio.laskeRivi(1, 1, 2));
        assertEquals(1, arvio.laskeRivi(0, 1, 2));
    }
    
    @Test
    public void laskeSarakePisteetOikein() {
        assertEquals(-1, arvio.laskeSarake(0, 4, 1));
        assertEquals(4, arvio.laskeSarake(0, 1, 2));
        assertEquals(2, arvio.laskeSarake(1, 1, 2));
    }
    
    @Test
    public void laskeKLDiagonaaliPisteetOikein() {
        assertEquals(-4, arvio.laskeKoillisLounasDiagonaali(0, 4, 1));
        assertEquals(-2, arvio.laskeKoillisLounasDiagonaali(1, 3, 1));
        assertEquals(1, arvio.laskeKoillisLounasDiagonaali(2, 1, 2));
    }
    
    @Test
    public void laskeLKDiagonaaliPisteetOikein() {
        assertEquals(2, arvio.laskeLuodeKaakkoDiagonaali(0, 1, 2));
        assertEquals(-1, arvio.laskeLuodeKaakkoDiagonaali(0, 4, 1));
    }
    
    @Test
    public void laskeVierekkaisetOikein() {
        assertEquals(-1, arvio.laskeVierekkaiset(0, 4, 1));
        assertEquals(-2, arvio.laskeVierekkaiset(1, 3, 1));
        assertEquals(2, arvio.laskeVierekkaiset(0, 1, 2));
        assertEquals(3, arvio.laskeVierekkaiset(1, 1, 2));
    }
    
    @Test
    public void laskeSuoraPisteetOikein() {
        assertEquals(6, arvio.laskeSuorat(1, 1, 2));
        assertEquals(8, arvio.laskeSuorat(0, 1, 2));
        assertEquals(-5, arvio.laskeSuorat(1, 3, 1));
    }
    
    
    @Test
    public void laskeLaudanPisteetOikein() {
        assertEquals(13, arvio.laskePisteet());
    }
    
}
