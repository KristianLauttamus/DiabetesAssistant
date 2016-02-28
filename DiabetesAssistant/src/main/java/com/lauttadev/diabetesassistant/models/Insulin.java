package com.lauttadev.diabetesassistant.models;

public class Insulin {
    private double perCarbohydrate;
    private String name;
    
    public Insulin(String name, double perCarbohydrate){
        this.name = name;
        this.perCarbohydrate = perCarbohydrate;
    }
    
    /**
     * Calculate the amount of insulin that should be taken, only by carbs
     * @param carbohydrates
     * @return 
     */
    public int calculateAmount(int carbohydrates){
        return new Double(this.perCarbohydrate * carbohydrates).intValue();
    }
    
    /**
     * Calculate the amount of insulin that should be taken
     * @param carbohydrates
     * @param bloodSugar
     * @return int
     */
    public int calculateAmount(int carbohydrates, BloodSugar bloodSugar){        
        double bs = bloodSugar.getValue();
        
        if(bloodSugar.getTextValue() != null){
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
        
        if(r < 4*5){
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
