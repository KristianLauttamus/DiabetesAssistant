package com.lauttadev.diabetesassistant.models;

/**
 * Class for the Insulin, includes name and per carbohydrates -value
 * @author kristian
 */
public class Insulin {
    private double perCarbohydrate;
    private String name;
    
    public Insulin(String name, double perCarbohydrate) {
        this.name = name;
        this.perCarbohydrate = perCarbohydrate;
    }
    
    /**
     * Calculate the amount of insulin that should be taken, only by carbohydrates.
     * @param carbohydrates
     * @return 
     */
    public int calculateAmount(int carbohydrates) {
        return new Double(this.perCarbohydrate * carbohydrates).intValue();
    }
    
    /**
     * Calculate the amount of insulin that should be taken.
     * @param carbohydrates
     * @param bloodSugar
     * @return calculated amount of insulin to be taken for this record
     */
    public int calculateAmount(int carbohydrates, BloodSugar bloodSugar) {        
        double bs = bloodSugar.getValue();
        
        if(bloodSugar.getTextValue() != null) { 
            switch (bloodSugar.getTextValue()) { 
                case "HI":
                    bs = 44;
                    break;
                case "LO":
                    return 0;
            }
        }
        
        double insulin = (bs*5)+carbohydrates;
        
        int r = (int)insulin - (4*5);
        
        if(r < 4*5) { 
            return 0;
        }
        
        return new Double(r * this.perCarbohydrate).intValue();
    }
    
    /**
     * Getters and Setters
     */
    
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

    @Override
    public String toString() {
        return name + " perCarbohydrate=" + perCarbohydrate;
    }
}
