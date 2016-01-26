/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.lauttadev.diabetesassistant.models.Insulin;
import com.lauttadev.diabetesassistant.models.TimedInsulin;
import java.util.Calendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author krislaut
 */
public class TimedInsulinTest {
    
    public TimedInsulinTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void test_taking_timed_insulin(){
        Insulin insulin = new Insulin("Novorapid");
        TimedInsulin timed = new TimedInsulin(Calendar.getInstance(), insulin);
        
        timed.take();
        
        assertTrue(timed.isTaken());
    }
}
