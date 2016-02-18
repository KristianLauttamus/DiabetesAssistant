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

public final class Database<Type> {
    private final DatabaseFile databaseFile;
    private ArrayList<Type> data;
    
    public final Gson gson;
    
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
     * Save Data to a file
     */
    public void save() {
        try {
            String json = this.gson.toJson(this.data);
            
            this.databaseFile.write(json);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
            
    public void add(Type model){
        this.data.add(model);
        this.save();
    }
    
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
    public ArrayList<Type> all(){
        if(this.data.isEmpty())
            return this.allFromFile();
        
        return this.data;
    }
    
    public void delete(int index){
        this.data.remove(index);
        
        this.save();
    }
    
    public void deleteFromFile(){
        try {
            this.databaseFile.clear();
            this.data = new ArrayList<>();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
