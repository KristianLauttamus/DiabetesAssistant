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
    private Insulin insulin;
    
    public BloodSugar(double value){
        this.value = value;
        this.measuredAt = new Date();
    }
    
    public BloodSugar(String text_value){
        this.textValue = text_value;
        this.measuredAt = new Date();
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
}
