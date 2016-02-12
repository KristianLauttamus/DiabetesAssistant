/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lauttadev.diabetesassistant;

import com.lauttadev.diabetesassistant.gui.MainFrame;

public class Main {
    public static void main(String[] args) {
        Database db = new Database();
        
        MainFrame mainFrame = new MainFrame(db);
        mainFrame.setVisible(true);
    }
}
