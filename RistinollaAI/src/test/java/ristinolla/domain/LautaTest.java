package ristinolla.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LautaTest {
    
    Lauta lauta;
       
    @Before
    public void setUp() {
        lauta = new Lauta();
    }
    
    @Test
    public void asetaArvoOikein() {
        lauta.asetaLuku(2, 3, 1);
        assertEquals(1, lauta.getLauta()[2][3]);
    }
    
    @Test
    public void palautaOikeaArvoLaudalta() {
        lauta.asetaLuku(4, 2, 2);
        assertEquals(2, lauta.getPelaaja(4, 2));
    }
    
    @Test
    public void palautaLaudanSivunPituusOikein() {
        assertEquals(5, lauta.getKoko());
    }

}
