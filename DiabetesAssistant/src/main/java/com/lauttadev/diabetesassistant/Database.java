/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lauttadev.diabetesassistant;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lauttadev.diabetesassistant.models.BloodSugar;
import com.lauttadev.diabetesassistant.models.Insulin;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    private final String FILE_LOCATION = System.getProperty("user.home");
    private final String BLOODSUGARS_FILE_NAME = "bloodsugarsGSON.json";
    private final String INSULINS_FILE_NAME = "insulinsGSON.json";
    
    private ArrayList<BloodSugar> bloodsugars = new ArrayList<>();
    private ArrayList<Insulin> insulins = new ArrayList<>();
    private final Gson gson;
    
    public Database(){
        this.gson = new Gson();
    }
    
    /**
     * Check if file and file path exists
     * @param file_name
     * @return boolean
     */
    private boolean fileExists(String file_name){
        File saveDir = new File(this.FILE_LOCATION);
        File saveFileDir = new File(this.getSavePath(file_name));
        
        return saveDir.exists() && saveFileDir.exists();
    }
    
    /**
     * Create files if files are not yet created
     */
    public void createFiles(){
        // BloodSugars
        if(this.fileExists(this.BLOODSUGARS_FILE_NAME)) {
            File bloodSugarsFile = new File(this.getSavePath(this.BLOODSUGARS_FILE_NAME));
            
            try {
                bloodSugarsFile.createNewFile();
            } catch (IOException e) {
                System.out.println(e.getStackTrace());
            }
        }
        
        // Insulins
        if(this.fileExists(this.INSULINS_FILE_NAME)) {
            File insulinsFile = new File(this.getSavePath(this.INSULINS_FILE_NAME));
            
            try {
                insulinsFile.createNewFile();
            } catch (IOException e) {
                System.out.println(e.getStackTrace());
            }
        } 
    }
    
    private String getSavePath(String fileName){
        return this.FILE_LOCATION + "/" + this.BLOODSUGARS_FILE_NAME;
    }
    
    /**
     * BloodSugars
     */
    
    /**
     * Get BloodSugars from the file and save to bloodsugars variable
     * @return ArrayList
     */
    public ArrayList<BloodSugar> getBloodSugarsFromFile(){
        if(!this.fileExists(this.BLOODSUGARS_FILE_NAME)){
            return this.bloodsugars;
        }
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(this.getSavePath(this.BLOODSUGARS_FILE_NAME)));

            //convert the json string back to object  
            this.bloodsugars = gson.fromJson(reader, new TypeToken<ArrayList<BloodSugar>>(){}.getType());  
            
            if(this.bloodsugars == null){
                this.bloodsugars = new ArrayList<BloodSugar>();
            }
        } catch (IOException e) {  
            e.printStackTrace();  
        }
        
        return this.bloodsugars;
    }
    
    /**
     * Check if bloodsugars are available and return them, if not then just get them from file and return
     * @return 
     */
    public ArrayList<BloodSugar> getBloodSugars(){
        if(this.bloodsugars.size() == 0)
            return this.getBloodSugarsFromFile();
        
        return this.bloodsugars;
    }
    
    /**
     * Add new BloodSugar
     * @param bloodsugar 
     */
    public void addBloodSugar(BloodSugar bloodsugar){        
        this.bloodsugars.add(bloodsugar);
        this.saveBloodSugars();
    }
    
    /**
     * Save BloodSugars to file
     */
    public void saveBloodSugars(){
        String bloodSugarsJSON = gson.toJson(this.bloodsugars);
        
        try {    
            FileWriter writer = new FileWriter(this.getSavePath(this.BLOODSUGARS_FILE_NAME));  
            writer.write(bloodSugarsJSON);  
            writer.close();
        } catch (IOException e) {  
            e.printStackTrace();  
        }
    }
    
    /**
     * Delete single BloodSugar
     */
    public void deleteBloodSugar(int index){
        this.bloodsugars.remove(index);
        
        this.saveBloodSugars();
    }
    
    /**
     * Delete all BloodSugars
     */
    public void deleteBloodSugars(){        
        try {    
            FileWriter writer = new FileWriter(this.getSavePath(this.BLOODSUGARS_FILE_NAME));  
            writer.write("");  
            writer.close();
            
            this.bloodsugars = new ArrayList<BloodSugar>();
        } catch (IOException e) {  
            e.printStackTrace();  
        }
    }
    
    /**
     * Insulins
     */
    
    /**
     * Get Insulins from the file and save to insulins variable
     * @return ArrayList
     */
    public ArrayList<Insulin> getInsulinsFromFile(){
        if(!this.fileExists(this.INSULINS_FILE_NAME)){
            return this.insulins;
        }
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(this.getSavePath(this.INSULINS_FILE_NAME)));

            //convert the json string back to object  
            this.insulins = gson.fromJson(reader, new TypeToken<ArrayList<Insulin>>(){}.getType());  
            
            if(this.insulins == null){
                this.insulins = new ArrayList<Insulin>();
            }
        } catch (IOException e) {  
            e.printStackTrace();  
        }
        
        return this.insulins;
    }
    
    /**
     * Check if insulins are available and return them, if not then just get them from file and return
     * @return 
     */
    public ArrayList<Insulin> getInsulins(){
        if(this.insulins.size() == 0)
            return this.getInsulinsFromFile();
        
        return this.insulins;
    }
    
    /**
     * Add new Insulin
     * @param insulin 
     */
    public void addInsulin(Insulin insulin){        
        this.insulins.add(insulin);
        this.saveInsulins();
    }
    
    /**
     * Save Insulins to file
     */
    public void saveInsulins(){
        String insulinsJSON = gson.toJson(this.insulins);
        
        try {    
            FileWriter writer = new FileWriter(this.getSavePath(this.INSULINS_FILE_NAME));  
            writer.write(insulinsJSON);  
            writer.close();
        } catch (IOException e) {  
            e.printStackTrace();  
        }
    }
    
    /**
     * Delete single Insulin
     */
    public void deleteInsulin(int index){
        this.insulins.remove(index);
        
        this.saveInsulins();
    }
    
    /**
     * Delete all Insulins
     */
    public void deleteInsulins(){        
        try {    
            FileWriter writer = new FileWriter(this.getSavePath(this.INSULINS_FILE_NAME));  
            writer.write("");  
            writer.close();
            
            this.insulins = new ArrayList<Insulin>();
        } catch (IOException e) {  
            e.printStackTrace();  
        }
    }
}
