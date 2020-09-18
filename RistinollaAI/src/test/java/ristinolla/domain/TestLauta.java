package ristinolla.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestLauta {
    
    Lauta lauta;
       
    @Before
    public void setUp() {
        lauta = new Lauta(5);
    }
    
    @Test
    public void asetaLukuOikein() {
        lauta.asetaLuku(1, 3, 4);
        assertEquals(1, lauta.getLauta()[2][3]);
    }
}
