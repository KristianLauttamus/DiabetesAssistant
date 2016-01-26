/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lauttadev.diabetesassistant;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lauttadev.diabetesassistant.models.BloodSugar;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Database {
    private final String FILE_LOCATION = System.getProperty("user.home");
    private final String BLOODSUGARS_FILE_NAME = "bloodsugarsGSON.json";
    
    private ArrayList<BloodSugar> bloodsugars = null;
    private Gson gson;
    
    public Database(){
        this.gson = new Gson();
    }
    
    private boolean fileExists(String file_name){
        File saveDir = new File(this.FILE_LOCATION);
        File saveFileDir = new File(this.getSavePath(file_name));
        
        return saveDir.exists() && saveFileDir.exists();
    }
    
    private String getSavePath(String fileName){
        return this.FILE_LOCATION + "/" + this.BLOODSUGARS_FILE_NAME;
    }
    
    /**
     * Get BloodSugars from the file and save to bloodsugars variable
     * @return ArrayList
     */
    public ArrayList<BloodSugar> getBloodSugarsFromFile(){
        if(!this.fileExists(this.BLOODSUGARS_FILE_NAME)){
            if(this.bloodsugars == null){
                this.bloodsugars = new ArrayList<BloodSugar>();
            }
            
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
        if(this.bloodsugars == null)
            return this.getBloodSugarsFromFile();
        
        return this.bloodsugars;
    }
    
    public void addBloodSugar(BloodSugar bloodsugar){
        if(this.bloodsugars == null)
            this.getBloodSugarsFromFile();
        
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
}
