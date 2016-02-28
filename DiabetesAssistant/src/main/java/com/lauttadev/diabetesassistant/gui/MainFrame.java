package com.lauttadev.diabetesassistant.gui;

import com.lauttadev.diabetesassistant.repositories.Database;
import com.lauttadev.diabetesassistant.models.BloodSugar;
import com.lauttadev.diabetesassistant.models.Insulin;
import com.lauttadev.diabetesassistant.models.TimedInsulin;
import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MainFrame extends javax.swing.JFrame {
    private final Database<BloodSugar> bloodSugarDatabase;
    private final Database<Insulin> insulinDatabase;
    private final Database<TimedInsulin> timedInsulinDatabase;
    
    /**
     * Creates new form MainFrame
     * @param bloodSugarDatabase
     * @param insulinDatabase
     */
    public MainFrame(Database<BloodSugar> bloodSugarDatabase, Database<Insulin> insulinDatabase, Database<TimedInsulin> timedInsulinDatabase) {
        this.bloodSugarDatabase = bloodSugarDatabase;
        this.insulinDatabase = insulinDatabase;
        this.timedInsulinDatabase = timedInsulinDatabase;
        
        initComponents();
        
        this.tabs.add("Verensokerit ja muistutukset", new BloodSugarsTab(bloodSugarDatabase, insulinDatabase, timedInsulinDatabase));
        this.tabs.add("Insuliinit", new InsulinsTab(insulinDatabase, timedInsulinDatabase));
        
        // Add listener to tabs
        final MainFrame frame = this;
        frame.updateSizeByTab();
        this.tabs.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e) {
                frame.updateSizeByTab();
            }
        });
        
        
    }
    
    public void updateSizeByTab(){
        this.getContentPane().setSize(tabs.getSelectedComponent().getPreferredSize());
        this.getContentPane().doLayout();
        this.getContentPane().revalidate();
        this.getContentPane().repaint();
        this.setSize(tabs.getSelectedComponent().getPreferredSize());
        this.revalidate();
        this.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Diabetes Assistant");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(505, 350));
        setPreferredSize(new java.awt.Dimension(500, 350));

        tabs.setMinimumSize(null);
        tabs.setPreferredSize(null);
        getContentPane().add(tabs, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private final javax.swing.JTabbedPane tabs = new javax.swing.JTabbedPane();
    // End of variables declaration//GEN-END:variables
}
