/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lauttadev.diabetesassistant.models;

import java.util.Date;

public class Insulin {
    private double perCarbohydrate;
    private int amount;
    private boolean taken = false;
    
    public Insulin(int amount){
        this.amount = amount;
    }
    
    public void take(){
        taken = true;
    }
    
    public boolean isTaken(){
        return taken;
    }
}
