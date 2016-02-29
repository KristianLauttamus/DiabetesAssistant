package com.lauttadev.diabetesassistant.models;

import java.util.Calendar;
import org.junit.Test;
import static org.junit.Assert.*;

public class TimedInsulinTest {
    @Test
    public void test_setters_and_getters(){
        Calendar c = Calendar.getInstance();
        
        TimedInsulin timedInsulin = new TimedInsulin(c, new Insulin("Novorapid", 0.01), 10);
        
        timedInsulin.take();
        
        assertEquals("Novorapid", timedInsulin.getInsulinName());
        assertEquals((double)10, timedInsulin.getAmount(), 0);
        
        assertEquals(c.getTime().getTime(), timedInsulin.getShouldAt().getTime().getTime());
    }
    
    @Test
    public void test_taking_timed_insulin(){
        Insulin insulin = new Insulin("Novorapid", 10.0);
        TimedInsulin timed = new TimedInsulin(Calendar.getInstance(), insulin, 10);
        
        timed.take();
        
        assertTrue(timed.isTaken());
    }
}
