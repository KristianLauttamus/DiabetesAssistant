package com.lauttadev.diabetesassistant.repositories;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Database class for all the Models and their JSON files
 * @param <Type> Model
 */
public final class Database<Type> {
    private final DatabaseFile databaseFile;
    private ArrayList<Type> data;
    
    public final Gson gson;
    
    /**
     * @param databaseFile 
     */
    public Database(DatabaseFile databaseFile){
        this.gson = new Gson();
        this.databaseFile = databaseFile;
        this.data = new ArrayList<>();
        
        try {
            this.databaseFile.createFile();
        } catch (IOException ex) {
            System.out.println("File fail: " + ex.getMessage());
        }
    }
    
    /**
     * Save Data to the file
     */
    public void save() {
        try {
            String json = this.gson.toJson(this.data);
            
            this.databaseFile.write(json);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     * Add model and then save all to file
     * @param model 
     */
    public void add(Type model){
        this.data.add(model);
        this.save();
    }
    
    /**
     * Return all data from the file itself
     * @return ArrayList
     */
    public ArrayList<Type> allFromFile(){
        try {
            //convert the json string back to object  
            this.data = this.gson.fromJson(this.databaseFile.read(), new TypeToken<ArrayList<Type>>(){}.getType());
            
            if(this.data == null){
                this.data = new ArrayList<>();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        return this.data;
    }
    
    /**
     * Check if data is empty and then either return from file itself or data
     * @return ArrayList
     */
    public ArrayList<Type> all(){
        if(this.data.isEmpty())
            return this.allFromFile();
        
        return this.data;
    }
    
    /**
     * Delete index from data
     * @param index 
     */
    public void delete(int index){
        this.data.remove(index);
        
        this.save();
    }
    
    /**
     * Delete from the file itself and make data empty
     */
    public void deleteFromFile(){
        try {
            this.databaseFile.clear();
            this.data = new ArrayList<>();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
