import com.lauttadev.diabetesassistant.models.Insulin;
import com.lauttadev.diabetesassistant.models.TimedInsulin;
import java.util.Calendar;
import org.junit.Test;
import static org.junit.Assert.*;

public class TimedInsulinTest { 
    @Test
    public void test_taking_timed_insulin(){
        Insulin insulin = new Insulin("Novorapid");
        TimedInsulin timed = new TimedInsulin(Calendar.getInstance(), insulin);
        
        timed.take();
        
        assertTrue(timed.isTaken());
    }
}
