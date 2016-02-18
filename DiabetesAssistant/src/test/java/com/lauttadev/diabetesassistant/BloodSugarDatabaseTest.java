package com.lauttadev.diabetesassistant;

import com.lauttadev.diabetesassistant.repositories.MainDatabase;
import com.lauttadev.diabetesassistant.models.BloodSugar;
import com.lauttadev.diabetesassistant.models.Insulin;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class BloodSugarDatabaseTest {
    private final MainDatabase db = new MainDatabase();
    
    @After
    public void tearDown() {
        this.db.deleteBloodSugars();
    }
    
    @Test
    public void saving_bloodsugar_types(){
        BloodSugar bsHI = new BloodSugar("HI");
        BloodSugar bsLO = new BloodSugar("LO");
        BloodSugar bs = new BloodSugar(12.5);
        
        this.db.addBloodSugar(bs);
        this.db.addBloodSugar(bsLO);
        this.db.addBloodSugar(bsHI);
        
        ArrayList<BloodSugar> bloodsugars = this.db.getBloodSugars();
        
        assertEquals(bloodsugars.size(), 3);
    }
    
    @Test
    public void removing_one_bloodsugar(){
        BloodSugar bsHI = new BloodSugar("HI");
        BloodSugar bsLO = new BloodSugar("LO");
        BloodSugar bs = new BloodSugar(12.5);
        
        this.db.addBloodSugar(bs);
        this.db.addBloodSugar(bsLO);
        this.db.addBloodSugar(bsHI);
        
        ArrayList<BloodSugar> bloodsugars = this.db.getBloodSugars();
        
        this.db.deleteBloodSugar(1);
        
        assertEquals(bloodsugars.size(), 2);
    }
    
    @Test
    public void removing_one_bloodsugar_check_index(){
        BloodSugar bsHI = new BloodSugar("HI");
        BloodSugar bsLO = new BloodSugar("LO");
        BloodSugar bs = new BloodSugar(12.5);
        
        this.db.addBloodSugar(bs);
        this.db.addBloodSugar(bsLO);
        this.db.addBloodSugar(bsHI);
        
        ArrayList<BloodSugar> bloodsugars = this.db.getBloodSugars();
        
        assertEquals(this.db.getBloodSugars().get(1).getBloodSugar(), "LO");
    }
    
    @Test
    public void bloodsugar_comes_with_insulin(){
        BloodSugar bsWithInsulin = new BloodSugar("HI", new Insulin("Novorapid"), 10, true);
        
        this.db.addBloodSugar(bsWithInsulin);
        
        assertEquals("Novorapid", this.db.getBloodSugarsFromFile().get(0).getInsulinName());
    }
}
