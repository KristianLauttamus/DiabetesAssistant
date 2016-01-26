/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lauttadev.diabetesassistant.models;

import java.util.Date;

public class Insulin {
    private double perCarbohydrate;
    private String name;
    
    public Insulin(String name){
        this.name = name;
    }

    public double getPerCarbohydrate() {
        return perCarbohydrate;
    }
    public void setPerCarbohydrate(double perCarbohydrate) {
        this.perCarbohydrate = perCarbohydrate;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
