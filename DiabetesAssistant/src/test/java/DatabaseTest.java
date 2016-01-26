import com.lauttadev.diabetesassistant.Database;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.fail;
import org.junit.Test;

public class DatabaseTest {
    private final Database db = new Database();

    @Test
    public void file_creation(){
        try {
            this.db.createFiles();
        } catch (IOException ex) {
            fail(ex.getMessage());
        }
    }
}
