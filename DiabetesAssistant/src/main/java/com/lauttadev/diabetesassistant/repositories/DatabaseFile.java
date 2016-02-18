package com.lauttadev.diabetesassistant.repositories;

public enum DatabaseFile {
    BLOODSUGARS, INSULINS, TIMEDINSULINS;
    
    /**
     * Return Filename for the enum
     * @param db
     * @return String File name
     */
    public static String getFilename(DatabaseFile db){
        // BloodSugars
        if(db.equals(DatabaseFile.BLOODSUGARS)){
            return "bloodSugarsGSON.json";
        } else if(db.equals(DatabaseFile.INSULINS)){
            return "insulinsGSON.json";
        } else if(db.equals(DatabaseFile.TIMEDINSULINS)){
            return "timedInsulinsGSON.json";
        }
        
        return "";
    }
}
