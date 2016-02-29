package com.lauttadev.diabetesassistant.models;

import java.util.Date;
import java.util.Objects;

/**
 * Class for the BloodSugar values and timings
 * @author kristian
 */
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
        if(!text_value.equals("HI") && !text_value.equals("LO")){
            try {
                this.value = Double.valueOf(text_value);
            } catch(Exception e) {
                System.out.println(e.getMessage());
                this.value = 4;
            }
        } else {
            this.textValue = text_value;
        }
        
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
        
        if(!text_value.equals("HI") && !text_value.equals("LO")){
            try {
                this.value = Double.valueOf(text_value);
            } catch(Exception e) {
                System.out.println(e.getMessage());
                this.value = 4;
            }
        } else {
            this.textValue = text_value;
        }
        
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + (int) (Double.doubleToLongBits(this.value) ^ (Double.doubleToLongBits(this.value) >>> 32));
        hash = 11 * hash + Objects.hashCode(this.textValue);
        hash = 11 * hash + Objects.hashCode(this.measuredAt);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BloodSugar other = (BloodSugar) obj;
        if (Double.doubleToLongBits(this.value) != Double.doubleToLongBits(other.value)) {
            return false;
        }
        if (!Objects.equals(this.textValue, other.textValue)) {
            return false;
        }
        if (!Objects.equals(this.measuredAt, other.measuredAt)) {
            return false;
        }
        return true;
    }
    
    
}
