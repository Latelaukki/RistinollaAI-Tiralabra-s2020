/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinolla.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ristinolla.domain.Lauta;

/**
 *
 * @author laukk
 */
public class PelinKulkuTest {
    
    Lauta lauta;
    PelinKulku peli;
   
    @Before
    public void setUp() {
        this.lauta = new Lauta(5);
        this.peli = new PelinKulku(5);
    }
    

}
