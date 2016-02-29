package com.lauttadev.diabetesassistant.models;

import java.util.Calendar;

/**
 * Timed Insulin. Scheduled "notification" of sorts
 * @author kristian
 */
public class TimedInsulin {
    private Calendar tookAt;
    private final Calendar shouldAt;
    private final String insulinName;
    private final double amount;
    
    public TimedInsulin(Calendar shouldAt, Insulin insulin, double amount) {
        this.shouldAt = shouldAt;
        this.shouldAt.set(Calendar.DAY_OF_YEAR, Calendar.getInstance().get(Calendar.DAY_OF_YEAR));
        this.insulinName = insulin.getName();
        this.amount = amount;
    }
    
    /**
     * Take Insulin.
     */
    public void take(){
        this.tookAt = Calendar.getInstance();
    }
    
    /**
     * Compare days of the year and return if the TimedInsulin is taken.
     * @return boolean
     */
    public boolean isTaken() {
        if(this.tookAt == null) { 
            return false;
        }
        
        return this.shouldAt.get(Calendar.DAY_OF_YEAR) == this.tookAt.get(Calendar.DAY_OF_YEAR);
    }

    public Calendar getShouldAt() {
        return shouldAt;
    }

    public String getInsulinName() {
        return insulinName;
    }

    public double getAmount() {
        return amount;
    }
}