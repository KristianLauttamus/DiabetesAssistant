/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lauttadev.diabetesassistant.models;

import java.util.Calendar;

public class TimedInsulin {
    private Calendar tookAt;
    private final Calendar shouldAt;
    private final Insulin insulin;
    private final double amount;
    
    public TimedInsulin(Calendar shouldAt, Insulin insulin, int amount){
        this.shouldAt = shouldAt;
        this.shouldAt.set(Calendar.DAY_OF_YEAR, Calendar.getInstance().get(Calendar.DAY_OF_YEAR));
        this.insulin = insulin;
        this.amount = amount;
    }
    
    /**
     * Take Insulin
     */
    public void take(){
        this.tookAt = Calendar.getInstance();
    }
    
    /**
     * Compare days of the year and return if the TimedInsulin is taken
     * @return boolean
     */
    public boolean isTaken(){
        if(this.tookAt == null)
            return false;
        
        return this.shouldAt.get(Calendar.DAY_OF_YEAR) == this.tookAt.get(Calendar.DAY_OF_YEAR);
    }
}