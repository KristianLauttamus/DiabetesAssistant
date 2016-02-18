package com.lauttadev.diabetesassistant.repositories;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public enum DatabaseFile {
    // Actual files
    BLOODSUGARS, INSULINS, TIMEDINSULINS,
    // Test files
    BLOODSUGARS_TEST, INSULINS_TEST, TIMEDINSULINS_TEST;
    
    private final String FILE_LOCATION = System.getProperty("user.home");
    private File file = null;
    
    /**
     * Return Filepath for the enum
     * @return String Filepath
     */
    private String getFilePath(){
        if(this.fileExists()){
            return file.getAbsolutePath();
        }
        
        String filePath = "";
        
        if(!this.isTestFile()){
            filePath += this.FILE_LOCATION;
        }
        
        if(this.equals(DatabaseFile.BLOODSUGARS) || this.equals(DatabaseFile.BLOODSUGARS_TEST)){
            filePath += "\\bloodSugarsGSON.json";
        } else if(this.equals(DatabaseFile.INSULINS) || this.equals(DatabaseFile.INSULINS_TEST)){
            filePath += "\\insulinsGSON.json";
        } else if(this.equals(DatabaseFile.TIMEDINSULINS) || this.equals(DatabaseFile.TIMEDINSULINS_TEST)){
            filePath += "\\timedInsulinsGSON.json";
        }
        
        return filePath;
    }
    
    /**
     * Create files if files are not yet created
     * @throws java.io.IOException
     */
    public void createFile() throws IOException {
        if(!this.fileExists()){
            if(this.isTestFile()){
                this.file = File.createTempFile(this.getFilePath(), ".tmp");
            } else {
                this.file = new File(this.getFilePath());
                this.file.createNewFile();
            }
        }
    }
    
    /**
     * Check if the current enum is a Test file
     * @return 
     */
    private boolean isTestFile(){
        return !(this.equals(DatabaseFile.BLOODSUGARS) || this.equals(DatabaseFile.INSULINS) || this.equals(DatabaseFile.TIMEDINSULINS));
    }
    
    /**
     * Check if File exists
     * @return boolean
     */
    private boolean fileExists(){
        if(file == null){
            return false;
        }
        
        return file.exists();
    }
    
    /**
     * Write json String to file
     * @param json String
     * @throws IOException 
     */
    public void write(String json) throws IOException {
        FileWriter writer = new FileWriter(this.getFilePath());
        writer.write(json);
    }
    
    /**
     * Read the file and return the reader itself
     * @return BufferedReader
     * @throws FileNotFoundException 
     */
    public BufferedReader read() throws FileNotFoundException {
        return new BufferedReader(new FileReader(this.getFilePath()));
    }
    
    /**
     * Clear the file and write an empty string
     * @throws IOException 
     */
    public void clear() throws IOException {
        FileWriter writer = new FileWriter(this.getFilePath());
        writer.write("");  
        writer.close();
    }
}
