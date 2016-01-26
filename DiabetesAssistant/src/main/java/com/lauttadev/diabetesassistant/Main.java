/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lauttadev.diabetesassistant;

import com.lauttadev.diabetesassistant.models.BloodSugar;

public class Main {
    public static void main(String[] args) {
        BloodSugar bloodsugar = new BloodSugar("HI");
        Database db = new Database();
        
        db.addBloodSugar(bloodsugar);
        db.getBloodSugarsFromFile();
    }
}
