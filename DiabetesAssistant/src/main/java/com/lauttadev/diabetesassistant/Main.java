/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lauttadev.diabetesassistant;

import com.lauttadev.diabetesassistant.models.BloodSugar;
import com.lauttadev.diabetesassistant.models.Insulin;

public class Main {
    public static void main(String[] args) {
        Database db = new Database();
        db.getBloodSugarsFromFile();
    }
}
