/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lauttadev.diabetesassistant.models;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kristian
 */
public class BloodSugarTest {
    @Test
    public void test_constructors(){
        BloodSugar bsText = new BloodSugar("HI");
        BloodSugar bsNothing = new BloodSugar("asd");
        BloodSugar bsValue = new BloodSugar(0.1);
        
        assertEquals(bsText.getTextValue(), "HI");
        assertEquals(bsNothing.getTextValue(), null);
        assertEquals(bsValue.getBloodSugar(), "0.1");
        
        BloodSugar bswInsulinText = new BloodSugar("HI", new Insulin("Novorapid", 10), 10, false);
        BloodSugar bswInsulinValue = new BloodSugar(0.1, new Insulin("NovorapidDouble", 10), 10, false);
        BloodSugar bswInsulinNothing = new BloodSugar("asd", new Insulin("NovorapidNothing", 10), 10, false);
        
        assertEquals(bswInsulinText.getTextValue(), "HI");
        assertEquals(bswInsulinText.getInsulinName(), "Novorapid");
        assertEquals(bswInsulinValue.getBloodSugar(), "0.1");
        assertEquals(bswInsulinValue.getInsulinName(), "NovorapidDouble");
        assertEquals(bswInsulinNothing.getTextValue(), null);
        assertEquals(bswInsulinNothing.getInsulinName(), "NovorapidNothing");
    }
    
    @Test
    public void test_setters_and_getters(){
        BloodSugar bs = new BloodSugar("HI");
        
        bs.setInsulinAmount(20);
        assertEquals(bs.getInsulinAmount(), 20);
        
        bs.setInsulinName(new Insulin("Testi", 10));
        assertEquals(bs.getInsulinName(), "Testi");
    }
}
