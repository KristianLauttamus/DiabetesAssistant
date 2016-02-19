/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lauttadev.diabetesassistant.gui;

import com.lauttadev.diabetesassistant.models.BloodSugar;
import com.lauttadev.diabetesassistant.models.Insulin;
import com.lauttadev.diabetesassistant.repositories.Database;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.MatteBorder;

/**
 *
 * @author Kristian
 */
public class BloodSugarsTab extends javax.swing.JPanel {
    private final Database<BloodSugar> bloodSugarDatabase;
    private final Database<Insulin> insulinDatabase;
    
    /**
     * Creates new form BloodSugarsTab
     * @param bloodSugarDatabase
     * @param insulinDatabase
     */
    public BloodSugarsTab(Database<BloodSugar> bloodSugarDatabase, Database<Insulin> insulinDatabase) {
        this.bloodSugarDatabase = bloodSugarDatabase;
        this.insulinDatabase = insulinDatabase;
        
        initComponents();
        
        this.mainlist.setLayout(new GridBagLayout());
        this.updateRecentBloodSugars();
        
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        Date today = Calendar.getInstance().getTime();
        timestamp.setText(df.format(today));
        Timer t = new Timer(1000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm");
                
                Date today = Calendar.getInstance().getTime();
                
                timestamp.setText(df.format(today));
            }
        });
        t.start();
        
        bloodsugar_warning_label.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        add_bloodsugar = new javax.swing.JButton();
        bloodsugar = new javax.swing.JTextField();
        timestamp = new javax.swing.JLabel();
        insulin_notify_label = new javax.swing.JLabel();
        insulin_notify_label1 = new javax.swing.JLabel();
        bloodsugar_warning_label = new javax.swing.JLabel();
        jSplitPane2 = new javax.swing.JSplitPane();
        remember_insulins = new javax.swing.JScrollPane();
        recent_bloodsugars = new javax.swing.JScrollPane();
        mainlist = new javax.swing.JPanel();

        add_bloodsugar.setBackground(new java.awt.Color(240, 240, 220));
        add_bloodsugar.setText("Lisää verensokeri");
        add_bloodsugar.setBorder(new javax.swing.border.MatteBorder(null));
        add_bloodsugar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_bloodsugarMouseClicked(evt);
            }
        });

        bloodsugar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bloodsugar.setText("Verensokeri");
        bloodsugar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bloodsugar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                bloodsugarKeyTyped(evt);
            }
        });

        timestamp.setText("Timestamp");
        timestamp.setName("timestamp"); // NOI18N

        insulin_notify_label.setText("Muistettavat insuliinit");

        insulin_notify_label1.setText("Viimeisimmät verensokerimittaukset");

        bloodsugar_warning_label.setForeground(new java.awt.Color(255, 0, 0));
        bloodsugar_warning_label.setText("Sallitut syötteet ovat HI, LO, XX.XX");

        jSplitPane2.setDividerLocation(220);
        jSplitPane2.setDividerSize(4);

        remember_insulins.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        remember_insulins.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jSplitPane2.setLeftComponent(remember_insulins);

        javax.swing.GroupLayout mainlistLayout = new javax.swing.GroupLayout(mainlist);
        mainlist.setLayout(mainlistLayout);
        mainlistLayout.setHorizontalGroup(
            mainlistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 258, Short.MAX_VALUE)
        );
        mainlistLayout.setVerticalGroup(
            mainlistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 196, Short.MAX_VALUE)
        );

        recent_bloodsugars.setViewportView(mainlist);

        jSplitPane2.setRightComponent(recent_bloodsugars);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSplitPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(insulin_notify_label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(insulin_notify_label1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(timestamp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bloodsugar, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(add_bloodsugar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bloodsugar_warning_label)))
                .addGap(5, 5, 5))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insulin_notify_label)
                    .addComponent(insulin_notify_label1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jSplitPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bloodsugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add_bloodsugar)
                    .addComponent(timestamp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bloodsugar_warning_label)
                .addContainerGap(25, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void add_bloodsugarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_bloodsugarMouseClicked
        if("HI".contains(bloodsugar.getText()) || "LO".contains(bloodsugar.getText()) || bloodsugar.getText().matches("^[0-9]+\\.?([0-9]+)?$")){
            addBloodSugar();
        }
    }//GEN-LAST:event_add_bloodsugarMouseClicked

    private void bloodsugarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bloodsugarKeyTyped
        if("HI".contains(bloodsugar.getText()) || "LO".contains(bloodsugar.getText()) || bloodsugar.getText().matches("^[0-9]+\\.?([0-9]+)?$")){
            bloodsugar_warning_label.setVisible(false);
            //this.setSize(this.getSize().width, this.getSize().height - 50);
        } else if(!bloodsugar_warning_label.isVisible()) {
            bloodsugar_warning_label.setVisible(true);
            //this.setSize(this.getSize().width, this.getSize().height + 50);
        }
    }//GEN-LAST:event_bloodsugarKeyTyped
    
    /**
     * Add BloodSugar to database and to the list
     */
    private void addBloodSugar(){
        BloodSugar bloodSugar = new BloodSugar(this.bloodsugar.getText());
        
        ArrayList<Insulin> insulins = this.insulinDatabase.all();
        Object[] choices = new Object[insulins.size()+1];
        insulins.toArray(choices);
        choices[insulins.size()] = "Ei mikään";
        
        int carbs = Integer.parseInt( JOptionPane.showInputDialog(this,"Kuinka paljon hiilihydraatteja meinaat syödä?","Hiilihydraatit",JOptionPane.INFORMATION_MESSAGE));
        Object input = JOptionPane.showInputDialog(null, "Valitse insuliini",
            "Valitse pistettävä insuliini", JOptionPane.QUESTION_MESSAGE, null,
            choices, // Array of choices
            choices[insulins.size()]); // Initial choice
        
        if(input.getClass().equals(Insulin.class)){
            Insulin insulin = (Insulin) input;
            bloodSugar.setInsulinAmount(insulin.calculateAmount(carbs, bloodSugar));
            bloodSugar.setInsulinName(insulin);
        }
        
        
        bloodSugarDatabase.add(bloodSugar);
        this.bloodsugar.setText("");
        addBloodSugarToList(bloodSugar, true);
        bloodSugarDatabase.save();
    }
    
    /**
     * Add given BloodSugar into the list of recent BloodSugars
     * @param bloodsugar 
     */
    private void addBloodSugarToList(final BloodSugar bloodsugar, boolean refresh){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm", Locale.ENGLISH);
        JPanel paneeli = new JPanel();
        paneeli.add(new JLabel(formatter.format(bloodsugar.getMeasuredAt()) + " - " + bloodsugar.getBloodSugar()));
        
        if(bloodsugar.getInsulinName() != null){
            // Take Insulin -button
            final JButton btn = new JButton(bloodsugar.getInsulinName() + " - " + bloodsugar.getInsulinAmount());
            paneeli.add(btn);
            btn.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    bloodsugar.takeInsulin();
                    btn.setEnabled(false);
                    bloodSugarDatabase.save();
                }
            });
            if(bloodsugar.isInsulinTaken()){
                btn.setEnabled(false);
            }
        }

        // Remove -button
        final JButton btnRemove = new JButton("Poista");
        paneeli.add(btnRemove);
        btnRemove.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                bloodSugarDatabase.delete(bloodsugar);
                mainlist.remove(btnRemove.getParent());
                mainlist.revalidate();
                mainlist.repaint();
            }
        });
        
        paneeli.setBorder(new MatteBorder(0, 0, 1, 0, Color.GRAY));
        this.mainlist.add(paneeli, gbc, 0);
        
        // Refresh only if boolean true
        if(refresh){
            mainlist.revalidate();
            mainlist.repaint();
        }
    }
    
    /**
     * Update list of recent BloodSugars
     */
    private void updateRecentBloodSugars(){
        ArrayList<BloodSugar> bsl = bloodSugarDatabase.all();
        
        this.mainlist.removeAll();
        
        GridBagConstraints gbcTemp = new GridBagConstraints();
        gbcTemp.gridwidth = GridBagConstraints.REMAINDER;
        gbcTemp.weightx = 1;
        gbcTemp.weighty = 1;
        this.mainlist.add(new JPanel(), gbcTemp);

        for (final BloodSugar bs : bsl) {
            this.addBloodSugarToList(bs, false);
        }
        
        this.mainlist.revalidate();
        this.mainlist.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_bloodsugar;
    private javax.swing.JTextField bloodsugar;
    private javax.swing.JLabel bloodsugar_warning_label;
    private javax.swing.JLabel insulin_notify_label;
    private javax.swing.JLabel insulin_notify_label1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JPanel mainlist;
    private javax.swing.JScrollPane recent_bloodsugars;
    private javax.swing.JScrollPane remember_insulins;
    private javax.swing.JLabel timestamp;
    // End of variables declaration//GEN-END:variables
}
