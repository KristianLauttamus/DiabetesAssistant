/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lauttadev.diabetesassistant.models;

import com.lauttadev.diabetesassistant.interfaces.JSONCreatable;
import java.util.Calendar;

public class TimedInsulin implements JSONCreatable {
    private Calendar tookAt;
    private Calendar shouldAt;
    private Insulin insulin;
    
    public TimedInsulin(Calendar shouldAt, Insulin insulin){
        this.shouldAt = shouldAt;
        this.insulin = insulin;
    }
    
    /**
     * Take Insulin
     */
    public void take(){
        this.shouldAt = Calendar.getInstance();
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

    @Override
    public JSONCreatable createFromJSON() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}