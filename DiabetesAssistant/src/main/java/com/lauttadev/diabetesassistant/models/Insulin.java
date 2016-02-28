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
        if(carbohydrates == 0){
            carbohydrates = 1;
        }
        
        if(bloodSugar.getTextValue() == null || bloodSugar.getTextValue().isEmpty()){
            return new Double(bloodSugar.getValue()/10).intValue() +
                    new Double(this.perCarbohydrate * carbohydrates).intValue();
        } else if (bloodSugar.getBloodSugar().equals("HI")){
            return 20 + new Double(this.perCarbohydrate * carbohydrates).intValue();
        } else if (bloodSugar.getBloodSugar().equals("LO")){
            return 0;
        } else {
            return new Double(this.perCarbohydrate * carbohydrates).intValue();
        }
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
