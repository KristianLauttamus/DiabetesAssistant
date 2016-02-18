package com.lauttadev.diabetesassistant;

import com.lauttadev.diabetesassistant.repositories.Database;
import com.lauttadev.diabetesassistant.models.BloodSugar;
import com.lauttadev.diabetesassistant.models.Insulin;
import com.lauttadev.diabetesassistant.repositories.DatabaseFile;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class BloodSugarDatabaseTest {
    private final Database<BloodSugar> db = new Database(DatabaseFile.BLOODSUGARS_TEST);
    
    @After
    public void tearDown() {
        this.db.deleteFromFile();
    }
    
    @Test
    public void saving_bloodsugar_types(){
        BloodSugar bsHI = new BloodSugar("HI");
        BloodSugar bsLO = new BloodSugar("LO");
        BloodSugar bs = new BloodSugar(12.5);
        
        this.db.add(bs);
        this.db.add(bsLO);
        this.db.add(bsHI);
        
        ArrayList<BloodSugar> bloodsugars = this.db.all();
        
        assertEquals(bloodsugars.size(), 3);
    }
    
    @Test
    public void removing_one_bloodsugar(){
        BloodSugar bsHI = new BloodSugar("HI");
        BloodSugar bsLO = new BloodSugar("LO");
        BloodSugar bs = new BloodSugar(12.5);
        
        this.db.add(bs);
        this.db.add(bsLO);
        this.db.add(bsHI);
        
        ArrayList<BloodSugar> bloodsugars = this.db.all();
        
        this.db.delete(1);
        
        assertEquals(bloodsugars.size(), 2);
    }
    
    @Test
    public void removing_one_bloodsugar_check_index(){
        BloodSugar bsHI = new BloodSugar("HI");
        BloodSugar bsLO = new BloodSugar("LO");
        BloodSugar bs = new BloodSugar(12.5);
        
        this.db.add(bs);
        this.db.add(bsLO);
        this.db.add(bsHI);
        
        ArrayList<BloodSugar> bloodsugars = this.db.all();
        
        assertEquals(this.db.all().get(1).getBloodSugar(), "LO");
    }
    
    @Test
    public void bloodsugar_comes_with_insulin(){
        BloodSugar bsWithInsulin = new BloodSugar("HI", new Insulin("Novorapid"), 10, true);
        
        this.db.add(bsWithInsulin);
        
        assertEquals("Novorapid", this.db.all().get(0).getInsulinName());
    }
}
