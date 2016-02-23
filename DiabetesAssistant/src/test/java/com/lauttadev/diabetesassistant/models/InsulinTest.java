package com.lauttadev.diabetesassistant.models;

import static org.junit.Assert.*;
import org.junit.Test;

public class InsulinTest {
    @Test
    public void calculate_how_much_insulin(){
        Insulin insulin = new Insulin("Novorapid", 10);
        insulin.setPerCarbohydrate(0.1);
        
        int carbhyd = 100;
        
        assertEquals(10, insulin.calculateAmount(carbhyd));
    }
    
    @Test
    public void calculate_how_much_insulin_with_bloodsugar(){
        Insulin insulin = new Insulin("Novorapid", 0.01);
        
        BloodSugar bs = new BloodSugar(20.0);
        
        int carbhyd = 100;
        
        assertEquals(12, insulin.calculateAmount(carbhyd, bs));
    }
    
    @Test
    public void calculate_how_much_insulin_with_hi_bloodsugar(){
        Insulin insulin = new Insulin("Novorapid", 0.1);
        
        BloodSugar bs = new BloodSugar("HI");
        
        int carbhyd = 100;
        
        assertEquals(30, insulin.calculateAmount(carbhyd, bs));
    }
    
    @Test
    public void calculate_how_much_insulin_with_lo_bloodsugar(){
        Insulin insulin = new Insulin("Novorapid", 0.1);
        
        BloodSugar bs = new BloodSugar("LO");
        
        int carbhyd = 100;
        
        assertEquals(0, insulin.calculateAmount(carbhyd, bs));
    }
}
