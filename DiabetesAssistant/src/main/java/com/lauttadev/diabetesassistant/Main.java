package com.lauttadev.diabetesassistant;

import com.lauttadev.diabetesassistant.gui.MainFrame;
import com.lauttadev.diabetesassistant.models.BloodSugar;
import com.lauttadev.diabetesassistant.repositories.Database;
import com.lauttadev.diabetesassistant.repositories.DatabaseFile;

public class Main {
    public static void main(String[] args) {
        Database<BloodSugar> bloodsugarDatabase = new Database(DatabaseFile.BLOODSUGARS);
        
        MainFrame mainFrame = new MainFrame(bloodsugarDatabase);
        mainFrame.setVisible(true);
    }
}
