/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lauttadev.diabetesassistant.models;

import java.util.Date;

public class BloodSugar {
    private double value;
    private String textValue = null;
    private Date measuredAt;
    private String insulinName;
    private int insulinAmount;
    private boolean insulinTaken = false;
    
    // Constructors without Insulin
    public BloodSugar(double value){
        this.value = value;
        this.measuredAt = new Date();
    }
    public BloodSugar(String text_value){
        this.textValue = text_value;
        this.measuredAt = new Date();
    }
    
    // Constructors with Insulin
    public BloodSugar(double value, Insulin insulin, int amount, boolean taken){
        this.insulinTaken = false;
        this.value = value;
        this.measuredAt = new Date();
        this.insulinName = insulin.getName();
        this.insulinAmount = amount;
    }
    public BloodSugar(String text_value, Insulin insulin, int amount, boolean taken){
        this.insulinTaken = false;
        this.textValue = text_value;
        this.measuredAt = new Date();
        this.insulinName = insulin.getName();
        this.insulinAmount = amount;
    }
    
    /**
     * Returns BloodSugar's value as a string
     * 
     * @return String blood sugar value
     */
    public String getBloodSugar(){
        if(this.textValue != null)
            return this.textValue;
        
        return "" + this.value;
    }
    
    /**
     * Take insulin
     */
    public void takeInsulin(){
        this.insulinTaken = true;
    }
    
    /**
     * See if insulin is taken
     * @return boolean
     */
    public boolean isInsulinTaken(){
        return this.insulinTaken;
    }

    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }

    public String getTextValue() {
        return textValue;
    }
    public void setTextValue(String text_value) {
        this.textValue = text_value;
    }

    public Date getMeasuredAt() {
        return measuredAt;
    }
    public void setMeasuredAt(Date measuredAt) {
        this.measuredAt = measuredAt;
    }

    public String getInsulinName() {
        return insulinName;
    }
    public void setInsulinName(Insulin insulin) {
        this.insulinName = insulin.getName();
    }

    public int getInsulinAmount() {
        return insulinAmount;
    }
    public void setInsulinAmount(int insulinAmount) {
        this.insulinAmount = insulinAmount;
    }

    
}
