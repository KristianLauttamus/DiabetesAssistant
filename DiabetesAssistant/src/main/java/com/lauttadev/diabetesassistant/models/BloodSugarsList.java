/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lauttadev.diabetesassistant.models;

import java.util.ArrayList;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class BloodSugarsList implements ListModel {
    private ArrayList<BloodSugar> list;
    
    public BloodSugarsList(ArrayList<BloodSugar> list){
        this.list = list;
    }
    
    @Override
    public int getSize() {
        return this.list.size();
    }

    @Override
    public BloodSugar getElementAt(int index) {
        return this.list.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        //
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
