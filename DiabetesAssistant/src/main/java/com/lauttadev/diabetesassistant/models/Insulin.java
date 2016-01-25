/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lauttadev.diabetesassistant.models;

import com.lauttadev.diabetesassistant.interfaces.JSONCreatable;
import java.util.Date;

public class Insulin implements JSONCreatable {
    private double perCarbohydrate;
    private int amount;
    private boolean taken = false;
    
    public Insulin(int amount){
        this.amount = amount;
    }

    @Override
    public JSONCreatable createFromJSON() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
