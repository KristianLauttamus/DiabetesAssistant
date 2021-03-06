package com.lauttadev.diabetesassistant;

import com.lauttadev.diabetesassistant.gui.MainFrame;
import com.lauttadev.diabetesassistant.models.BloodSugar;
import com.lauttadev.diabetesassistant.models.Insulin;
import com.lauttadev.diabetesassistant.models.TimedInsulin;
import com.lauttadev.diabetesassistant.repositories.Database;
import com.lauttadev.diabetesassistant.repositories.DatabaseFile;

public class Main {
    public static void main(String[] args) {
        Database<BloodSugar> bloodsugarDatabase = new Database(DatabaseFile.BLOODSUGARS);
        Database<Insulin> insulinDatabase = new Database(DatabaseFile.INSULINS);
        Database<TimedInsulin> timedInsulinDatabase = new Database(DatabaseFile.TIMEDINSULINS);
        
        MainFrame mainFrame = new MainFrame(bloodsugarDatabase, insulinDatabase, timedInsulinDatabase);
        mainFrame.setVisible(true);
    }
}