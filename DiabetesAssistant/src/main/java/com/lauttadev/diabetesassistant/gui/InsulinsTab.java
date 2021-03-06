/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lauttadev.diabetesassistant.gui;

import com.lauttadev.diabetesassistant.models.Insulin;
import com.lauttadev.diabetesassistant.models.TimedInsulin;
import com.lauttadev.diabetesassistant.repositories.Database;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

/**
 *
 * @author Kristian
 */
public class InsulinsTab extends javax.swing.JPanel {
    private final Database<Insulin> insulinDatabase;
    private final Database<TimedInsulin> timedInsulinDatabase;
    
    /**
     * Creates new form InsulinsTab
     * @param insulinDatabase
     * @param timedInsulinDatabase
     */
    public InsulinsTab(Database<Insulin> insulinDatabase, Database<TimedInsulin> timedInsulinDatabase) {
        this.insulinDatabase = insulinDatabase;
        this.timedInsulinDatabase = timedInsulinDatabase;
        
        initComponents();
        
        this.add_insulin_button.setEnabled(false);
        this.add_timedinsulin_button.setEnabled(false);
        
        this.insulins_list.setLayout(new GridBagLayout());
        this.timedinsulins_list.setLayout(new GridBagLayout());
        
        // Make insulin combobox empty if no insulins found
        if(this.insulinDatabase.all().isEmpty())
            this.insulins_combo_box.setModel(new DefaultComboBoxModel(){});
        
        this.updateInsulinsList();
        this.updateTimedInsulinsList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        insulins_scroll_pane = new javax.swing.JScrollPane();
        insulins_list = new javax.swing.JPanel();
        timedinsulins_scroll_pane = new javax.swing.JScrollPane();
        timedinsulins_list = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        add_insulin_text_field = new javax.swing.JTextField();
        add_insulin_button = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        per_carb_textfield = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        add_timedinsulin_button = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        add_timedinsulin_amount = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        add_timedinsulin_hour = new javax.swing.JTextField();
        insulins_combo_box = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(720, 580));

        jSplitPane1.setDividerLocation(300);

        insulins_scroll_pane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        javax.swing.GroupLayout insulins_listLayout = new javax.swing.GroupLayout(insulins_list);
        insulins_list.setLayout(insulins_listLayout);
        insulins_listLayout.setHorizontalGroup(
            insulins_listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 548, Short.MAX_VALUE)
        );
        insulins_listLayout.setVerticalGroup(
            insulins_listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 365, Short.MAX_VALUE)
        );

        insulins_scroll_pane.setViewportView(insulins_list);

        jSplitPane1.setRightComponent(insulins_scroll_pane);

        timedinsulins_scroll_pane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        javax.swing.GroupLayout timedinsulins_listLayout = new javax.swing.GroupLayout(timedinsulins_list);
        timedinsulins_list.setLayout(timedinsulins_listLayout);
        timedinsulins_listLayout.setHorizontalGroup(
            timedinsulins_listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 397, Short.MAX_VALUE)
        );
        timedinsulins_listLayout.setVerticalGroup(
            timedinsulins_listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 334, Short.MAX_VALUE)
        );

        timedinsulins_scroll_pane.setViewportView(timedinsulins_list);

        jSplitPane1.setLeftComponent(timedinsulins_scroll_pane);

        jLabel1.setText("Ajastetut insuliinimuistutukset");

        jLabel2.setText("Insuliinit");

        add_insulin_text_field.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                add_insulin_text_fieldKeyTyped(evt);
            }
        });

        add_insulin_button.setText("Lisää insuliini");
        add_insulin_button.setActionCommand("");
        add_insulin_button.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 0, 0)));
        add_insulin_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_insulin_buttonMouseClicked(evt);
            }
        });

        jLabel3.setText("Per hiilihydraatit");

        per_carb_textfield.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        per_carb_textfield.setText("XX.XX");
        per_carb_textfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                per_carb_textfieldKeyTyped(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Lisää insuliini");

        add_timedinsulin_button.setText("Lisää muistutus");
        add_timedinsulin_button.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add_timedinsulin_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_timedinsulin_buttonMouseClicked(evt);
            }
        });

        jLabel5.setText("Määrä");
        jLabel5.setFocusable(false);
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        add_timedinsulin_amount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        add_timedinsulin_amount.setText("XX.XX");
        add_timedinsulin_amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                add_timedinsulin_amountKeyTyped(evt);
            }
        });

        jLabel6.setText("Muistutusajankohta");

        add_timedinsulin_hour.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        add_timedinsulin_hour.setText("HH:MM");
        add_timedinsulin_hour.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                add_timedinsulin_hourKeyTyped(evt);
            }
        });

        insulins_combo_box.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        insulins_combo_box.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                insulins_combo_boxPropertyChange(evt);
            }
        });

        jLabel7.setText("Valitse insuliini");

        jLabel8.setText("Nimi");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Lisää insuliinimuistutus");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(per_carb_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(add_insulin_text_field, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(add_insulin_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(add_timedinsulin_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(add_timedinsulin_hour, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(insulins_combo_box, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(add_timedinsulin_button, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2)))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(388, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_timedinsulin_button)
                    .addComponent(jLabel5)
                    .addComponent(add_timedinsulin_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(add_timedinsulin_hour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(insulins_combo_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(per_carb_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add_insulin_text_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add_insulin_button)
                    .addComponent(jLabel8))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(136, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void add_insulin_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_insulin_buttonMouseClicked
        addInsulin();
    }//GEN-LAST:event_add_insulin_buttonMouseClicked

    private void add_insulin_text_fieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_add_insulin_text_fieldKeyTyped
        if(this.checkValidInsulin()){
            this.add_insulin_button.setEnabled(true);
        } else {
            this.add_insulin_button.setEnabled(false);
        }
    }//GEN-LAST:event_add_insulin_text_fieldKeyTyped

    private void per_carb_textfieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_per_carb_textfieldKeyTyped
        if(this.checkValidInsulin()){
            this.add_insulin_button.setEnabled(true);
        } else {
            this.add_insulin_button.setEnabled(false);
        }
    }//GEN-LAST:event_per_carb_textfieldKeyTyped

    private void add_timedinsulin_amountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_add_timedinsulin_amountKeyTyped
        if(this.checkValidTimedInsulin()){
            this.add_timedinsulin_button.setEnabled(true);
        } else {
            this.add_timedinsulin_button.setEnabled(false);
        }
    }//GEN-LAST:event_add_timedinsulin_amountKeyTyped

    private void add_timedinsulin_hourKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_add_timedinsulin_hourKeyTyped
        if(this.checkValidTimedInsulin()){
            this.add_timedinsulin_button.setEnabled(true);
        } else {
            this.add_timedinsulin_button.setEnabled(false);
        }
    }//GEN-LAST:event_add_timedinsulin_hourKeyTyped

    private void insulins_combo_boxPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_insulins_combo_boxPropertyChange
        if(this.checkValidTimedInsulin()){
            this.add_timedinsulin_button.setEnabled(true);
        } else {
            this.add_timedinsulin_button.setEnabled(false);
        }
    }//GEN-LAST:event_insulins_combo_boxPropertyChange

    private void add_timedinsulin_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_timedinsulin_buttonMouseClicked
        addTimedInsulin();
    }//GEN-LAST:event_add_timedinsulin_buttonMouseClicked

    private boolean checkValidInsulin(){
        return this.per_carb_textfield.getText().matches("^[0-9]+\\.?([0-9]+)?$") && !this.add_insulin_text_field.getText().equals("");
    }
    
    /**
     * Add Insulin to database and list
     */
    private void addInsulin(){
        if(this.checkValidInsulin()){
            Insulin insulin = new Insulin(this.add_insulin_text_field.getText(), Double.valueOf(this.per_carb_textfield.getText()));
            insulinDatabase.add(insulin);

            addInsulinToList(insulin, true);
        } else {
            this.add_insulin_button.setEnabled(false);
        }
    }
    
    /**
     * Add Insulin to list
     * @param insulin
     * @param refresh 
     */
    private void addInsulinToList(final Insulin insulin, boolean refresh){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm", Locale.ENGLISH);
        JPanel paneeli = new JPanel();
        paneeli.add(new JLabel(insulin.getName() + " " + insulin.getPerCarbohydrate()));
        
        // Remove -Button
        final JButton btnRemove = new JButton("Poista");
        final InsulinsTab panel = this;
        btnRemove.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                insulinDatabase.delete(insulin);
                insulins_list.remove(btnRemove.getParent());
                insulins_list.revalidate();
                insulins_list.repaint();
                panel.updateInsulinsComboBox();
            }
        });
        paneeli.add(btnRemove);
        
        paneeli.setBorder(new MatteBorder(0, 0, 1, 0, Color.GRAY));
        this.insulins_list.add(paneeli, gbc, 0);
        
        if(refresh){
            this.insulins_list.revalidate();
            this.insulins_list.repaint();
        }
        
        // Update combobox
        this.updateInsulinsComboBox();
    }
    
    private void updateInsulinsComboBox(){
        this.insulins_combo_box.setModel(new DefaultComboBoxModel(insulinDatabase.all().toArray()));
        this.insulins_combo_box.revalidate();
        this.insulins_combo_box.repaint();
    }
    
    /**
     * Update all Insulins to list
     */
    private void updateInsulinsList(){
        ArrayList<Insulin> il = this.insulinDatabase.all();
        
        this.insulins_list.removeAll();
        
        GridBagConstraints gbcTemp = new GridBagConstraints();
        gbcTemp.gridwidth = GridBagConstraints.REMAINDER;
        gbcTemp.weightx = 1;
        gbcTemp.weighty = 1;
        this.insulins_list.add(new JPanel(), gbcTemp);
        
        for (final Insulin i : il) {
            addInsulinToList(i, false);
        }
        
        this.insulins_list.revalidate();
        this.insulins_list.repaint();
    }
    
    private boolean checkValidTimedInsulin(){
        return !this.insulinDatabase.all().isEmpty() && this.add_timedinsulin_amount.getText().matches("^[0-9]+\\.?([0-9]+)?$") && this.add_timedinsulin_hour.getText().matches("^([01]\\d|2[0-3]):([0-5]\\d)$");
    }
    
    /**
     * Add Insulin to database and list
     */
    private void addTimedInsulin(){
        if(this.checkValidTimedInsulin()){
            System.out.println("1");
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.HOUR, Integer.valueOf(this.add_timedinsulin_hour.getText().split(":")[0]));
            cal.set(Calendar.MINUTE, Integer.valueOf(this.add_timedinsulin_hour.getText().split(":")[1]));
            System.out.println("2");
            TimedInsulin timedInsulin = new TimedInsulin(cal, this.insulinDatabase.all().get(this.insulins_combo_box.getSelectedIndex()), Double.valueOf(this.add_timedinsulin_amount.getText()));
            this.timedInsulinDatabase.add(timedInsulin);
            System.out.println("3");
            addTimedInsulinToList(timedInsulin, true);
        } else {
            this.add_timedinsulin_button.setEnabled(false);
        }
    }
    
    /**
     * Add Insulin to list
     * @param insulin
     * @param refresh 
     */
    private void addTimedInsulinToList(final TimedInsulin timedInsulin, boolean refresh){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm", Locale.ENGLISH);
        JPanel paneeli = new JPanel();
        paneeli.add(new JLabel(timedInsulin.getInsulinName() + " " + timedInsulin.getAmount() + " - " + (timedInsulin.getShouldAt().get(Calendar.HOUR))));
        
        // Remove -Buttond
        final JButton btnRemove = new JButton("Poista");
        btnRemove.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                timedInsulinDatabase.delete(timedInsulin);
                timedinsulins_list.remove(btnRemove.getParent());
                timedinsulins_list.revalidate();
                timedinsulins_list.repaint();
            }
        });
        paneeli.add(btnRemove);
        
        paneeli.setBorder(new MatteBorder(0, 0, 1, 0, Color.GRAY));
        this.timedinsulins_list.add(paneeli, gbc, 0);
        
        if(refresh){
            this.timedinsulins_list.revalidate();
            this.timedinsulins_list.repaint();
        }
    }
    
    /**
     * Update all TimedInsulins to list
     */
    private void updateTimedInsulinsList(){
        ArrayList<TimedInsulin> til = this.timedInsulinDatabase.all();
        
        this.timedinsulins_list.removeAll();
        
        GridBagConstraints gbcTemp = new GridBagConstraints();
        gbcTemp.gridwidth = GridBagConstraints.REMAINDER;
        gbcTemp.weightx = 1;
        gbcTemp.weighty = 1;
        this.timedinsulins_list.add(new JPanel(), gbcTemp);
        
        for (final TimedInsulin ti : til) {
            addTimedInsulinToList(ti, false);
        }
        
        this.timedinsulins_list.revalidate();
        this.timedinsulins_list.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_insulin_button;
    private javax.swing.JTextField add_insulin_text_field;
    private javax.swing.JTextField add_timedinsulin_amount;
    private javax.swing.JButton add_timedinsulin_button;
    private javax.swing.JTextField add_timedinsulin_hour;
    private javax.swing.JComboBox insulins_combo_box;
    private javax.swing.JPanel insulins_list;
    private javax.swing.JScrollPane insulins_scroll_pane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextField per_carb_textfield;
    private javax.swing.JPanel timedinsulins_list;
    private javax.swing.JScrollPane timedinsulins_scroll_pane;
    // End of variables declaration//GEN-END:variables
}
