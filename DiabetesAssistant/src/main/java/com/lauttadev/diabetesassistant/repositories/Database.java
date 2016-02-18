package com.lauttadev.diabetesassistant.repositories;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lauttadev.diabetesassistant.models.BloodSugar;
import com.lauttadev.diabetesassistant.models.Insulin;
import com.lauttadev.diabetesassistant.models.Model;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Database<Type> {
    private final String fileLocation = System.getProperty("user.home");
    private final String databaseFilename;
    private ArrayList<Type> data;
    
    public final Gson gson;
    
    public Database(DatabaseFile databaseFile){
        this.gson = new Gson();
        this.data = new ArrayList<>();
        this.databaseFilename = DatabaseFile.getFilename(databaseFile);
        this.data = new ArrayList<>();
        
        try {
            this.createFile();
        } catch (IOException ex) {
            System.out.println("File fail: " + ex.getMessage());
        }
    }
    
    /**
     * Check if file and file path exists
     * @param file_name
     * @return boolean
     */
    public boolean fileExists(){
        File saveDir = new File(this.fileLocation);
        File saveFileDir = new File(this.getSavePath(this.databaseFilename));
        
        return saveDir.exists() && saveFileDir.exists();
    }
    
    /**
     * Create files if files are not yet created
     * @throws java.io.IOException
     */
    public void createFile() throws IOException {
        if(!this.fileExists()) {
            File file = new File(this.getSavePath(this.databaseFilename));
            
            file.createNewFile();
        }
    }
    
    /**
     * Get file's save path
     * @param FILE_NAME
     * @return 
     */
    public String getSavePath(String FILE_NAME){
        return this.fileLocation + "/" + this.databaseFilename;
    }
    
    /**
     * Save Data to a file
     */
    public void save() {
        String json = this.gson.toJson(this.data);
        
        try (FileWriter writer = new FileWriter(this.databaseFilename)) {
            writer.write(json);
        } catch (IOException ex) {  
            System.out.println("File Saving failed: " + ex.getMessage());
        }
    }
            
    public void add(Type model){
        this.data.add(model);
        this.save();
    }
    
    public ArrayList<Type> allFromFile(){
        if(!this.fileExists()){
            return this.data;
        }
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(this.getSavePath(this.databaseFilename)));

            //convert the json string back to object  
            this.data = this.gson.fromJson(reader, new TypeToken<ArrayList<Type>>(){}.getType());
            
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
        try (FileWriter writer = new FileWriter(this.getSavePath(this.databaseFilename))) {
            writer.write("");  
            writer.close();
            
            this.data = new ArrayList<>();
        } catch (IOException ex) {  
            System.out.println("File data deletion failed: " + ex.getMessage());
        }
    }
}
