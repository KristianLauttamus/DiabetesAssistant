package com.lauttadev.diabetesassistant.models;

import java.util.Calendar;
import org.junit.Test;
import static org.junit.Assert.*;

public class TimedInsulinTest { 
    @Test
    public void test_taking_timed_insulin(){
        Insulin insulin = new Insulin("Novorapid", 10.0);
        TimedInsulin timed = new TimedInsulin(Calendar.getInstance(), insulin, 10);
        
        timed.take();
        
        assertTrue(timed.isTaken());
    }
}
