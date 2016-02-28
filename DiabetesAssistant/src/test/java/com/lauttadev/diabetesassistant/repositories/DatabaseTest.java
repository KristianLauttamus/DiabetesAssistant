/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lauttadev.diabetesassistant.repositories;

import com.lauttadev.diabetesassistant.models.BloodSugar;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kristian
 */
public class DatabaseTest {
    private Database<BloodSugar> db = new Database(DatabaseFile.BLOODSUGARS_TEST);
    
    @After
    public void tearDown() {
        this.db.deleteFromFile();
    }
    
    @Test
    public void test_file_found(){
        DatabaseFile dbf = DatabaseFile.BLOODSUGARS_TEST;
         
        assertEquals(true, dbf.fileExists());
        
        this.db.save();
        
        assertEquals(true, dbf.fileExists());
    }
    
    @Test
    public void test_emptying_file() throws IOException {
        DatabaseFile dbf = DatabaseFile.BLOODSUGARS_TEST;
        
        db = new Database(DatabaseFile.BLOODSUGARS_TEST);
        
        BloodSugar bsHI = new BloodSugar("HI");
        BloodSugar bsLO = new BloodSugar("LO");
        BloodSugar bs = new BloodSugar(12.5);
        
        db.add(bs);
        db.add(bsLO);
        db.add(bsHI);
        
        dbf.clear();
        
        assertEquals(false, this.db.all().isEmpty());
        
        db.empty();
        assertEquals(true, this.db.all().isEmpty());
    }
    
    @Test
    public void test_emptying(){
        BloodSugar bsHI = new BloodSugar("HI");
        BloodSugar bsLO = new BloodSugar("LO");
        BloodSugar bs = new BloodSugar(12.5);
        
        this.db.add(bs);
        this.db.add(bsLO);
        this.db.add(bsHI);
        
        this.db.empty();
        
        assertEquals(false, this.db.all().isEmpty());
    }
    
    @Test
    public void test_emptying_and_directly_from_file(){
        BloodSugar bsHI = new BloodSugar("HI");
        BloodSugar bsLO = new BloodSugar("LO");
        BloodSugar bs = new BloodSugar(12.5);
        
        this.db.add(bs);
        this.db.add(bsLO);
        this.db.add(bsHI);
        
        this.db.empty();
        
        assertEquals(false, this.db.allFromFile().isEmpty());
    }
}
