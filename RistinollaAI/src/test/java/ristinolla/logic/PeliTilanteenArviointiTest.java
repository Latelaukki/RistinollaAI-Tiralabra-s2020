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
        lauta = new Lauta();
        arvio = new PeliTilanteenArviointi(lauta);
        lauta.asetaLuku(0, 4, 1);
        lauta.asetaLuku(1, 3, 1);
        lauta.asetaLuku(2, 2, 1);
        lauta.asetaLuku(2, 3, 1);
        lauta.asetaLuku(2, 4, 1);
        lauta.asetaLuku(3, 3, 1);
        lauta.asetaLuku(0, 1, 2);
        lauta.asetaLuku(1, 1, 2);
        lauta.asetaLuku(2, 1, 2);
        lauta.asetaLuku(3, 1, 2);
        lauta.asetaLuku(4, 1, 2);
        lauta.asetaLuku(3, 2, 2);
        lauta.asetaLuku(4, 3, 2);
    }

    @Test
    public void laskeRiviPisteetOikein() {
        assertEquals(-2, arvio.laskeRivi(2, 2, 1));
        assertEquals(-1, arvio.laskeRivi(2, 3, 1));
        assertEquals(0, arvio.laskeRivi(4, 4, 1));
        assertEquals(1, arvio.laskeRivi(3, 1, 2));
        assertEquals(0, arvio.laskeRivi(4, 1, 2));
    }
    
    @Test
    public void laskeSarakePisteetOikein() {
        assertEquals(-2, arvio.laskeSarake(1, 3, 1));
        assertEquals(-1, arvio.laskeSarake(2, 3, 1));
        assertEquals(0, arvio.laskeSarake(0, 4, 1));
        assertEquals(3, arvio.laskeSarake(1, 1, 2));
        assertEquals(0, arvio.laskeSarake(4, 1, 2));
    }
    
    @Test
    public void laskeKLDiagonaaliPisteetOikein() {
        assertEquals(-2, arvio.laskeKoillisLounasDiagonaali(0, 4, 1));
        assertEquals(-1, arvio.laskeKoillisLounasDiagonaali(2, 4, 1));
        assertEquals(0, arvio.laskeKoillisLounasDiagonaali(2, 3, 1));
        assertEquals(0, arvio.laskeKoillisLounasDiagonaali(1, 1, 2));
        assertEquals(1, arvio.laskeKoillisLounasDiagonaali(3, 2, 2));
    }
    
    @Test
    public void laskeLKDiagonaaliPisteetOikein() {
        assertEquals(-1, arvio.laskeLuodeKaakkoDiagonaali(2, 2, 1));
        assertEquals(-1, arvio.laskeLuodeKaakkoDiagonaali(1, 3, 1));
        assertEquals(0, arvio.laskeLuodeKaakkoDiagonaali(2, 4, 1));
        assertEquals(2, arvio.laskeLuodeKaakkoDiagonaali(2, 1, 2));
    }
    
    @Test
    public void laskeVierekkaisetOikein() {
        assertEquals(-1, arvio.laskeVierekkaiset(0, 4, 1));
        assertEquals(-4, arvio.laskeVierekkaiset(2, 3, 1));
        assertEquals(4, arvio.laskeVierekkaiset(3, 2, 2));
        assertEquals(1, arvio.laskeVierekkaiset(4, 3, 2));
    }
    
    @Test
    public void laskeHaarukatOikein() {
        assertEquals(-50, arvio.laskeHaarukat(1, 2, 0, 2, 1));
        assertEquals(150, arvio.laskeHaarukat(2, 0, 2, 2, 2));
    }
    
    @Test
    public void loydaPelaajaKaksiVoittoRivi() {
        assertEquals(99999, arvio.laskeSuorat(0, 1, 2));
    }
    
    @Test
    public void laskeSuoraPisteetOikein() {
        assertEquals(-3, arvio.laskeSuorat(2, 2, 1));
        assertEquals(-4, arvio.laskeSuorat(1, 3, 1));
        assertEquals(54, arvio.laskeSuorat(2, 1, 2));
        assertEquals(2, arvio.laskeSuorat(3, 2, 2));
    }
    
    @Test
    public void laskeLaudanPisteetOikeinBottiVoittaa() {
        assertEquals(99999, arvio.laskePisteet());
    }
    
    @Test
    public void laskeLaudanPisteetOikeinPelaajaVoittaa() {
        lauta.asetaLuku(0, 0, 1);
        lauta.asetaLuku(0, 1, 1);
        lauta.asetaLuku(0, 2, 1);
        lauta.asetaLuku(0, 3, 1);
        assertEquals(-99999, arvio.laskePisteet());
    }
    
    @Test
    public void laskeLaudanPisteetOikeinEiVoittajaa() {
        lauta.asetaLuku(0, 1, 0); //poistetaan voittava piste
        assertEquals(45, arvio.laskePisteet());
    }
    
    @Test
    public void laskeLaudanPisteetOikeinEiVoittajaa2() {
        Lauta lauta2 = new Lauta();
        PeliTilanteenArviointi arvio2 = new PeliTilanteenArviointi(lauta2);
        lauta2.asetaLuku(0, 0, 1);
        lauta2.asetaLuku(0, 1, 1);
        lauta2.asetaLuku(0, 2, 1);
        lauta2.asetaLuku(0, 4, 1);
        lauta2.asetaLuku(1, 4, 1);
        lauta2.asetaLuku(2, 4, 1);
        lauta2.asetaLuku(3, 4, 1);
        lauta2.asetaLuku(4, 4, 1);
        lauta2.asetaLuku(2, 1, 1);
        lauta2.asetaLuku(3, 1, 1);
        lauta2.asetaLuku(4, 1, 1);
        lauta2.asetaLuku(4, 2, 1);
        lauta2.asetaLuku(0, 3, 2);     
        assertEquals(-99999, arvio2.laskePisteet());
    }
}
