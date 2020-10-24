package ristinolla.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LautaTest {
    
    Lauta lauta;
       
    @Before
    public void setUp() {
        lauta = new Lauta(5);
    }
    
    
    @Test
    public void asetaJaPalautaOikeaArvoLaudalta() {
        lauta.asetaLuku(4, 2, 2);
        assertEquals(2, lauta.getPelaaja(4, 2));
    }
    
    @Test
    public void palautaLaudanSivunPituusOikein() {
        assertEquals(5, lauta.getKoko());
    }

        @Test
    public void lautaEiTaynnaPalauttaaFalse() {
        assertEquals(false, lauta.onkoTaynna());
    }
    
    @Test
    public void lautaTaynnaPalauttaaTrue() {
        for (int i = 0; i < lauta.getKoko(); i++) {
            for (int j = 0; j < lauta.getKoko(); j++) {
                lauta.asetaLuku(i, j, 1);
            }
        }
        assertEquals(true, lauta.onkoTaynna());
    }
}
