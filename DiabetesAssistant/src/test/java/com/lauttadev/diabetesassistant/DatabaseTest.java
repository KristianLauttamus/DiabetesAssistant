package com.lauttadev.diabetesassistant;

import com.lauttadev.diabetesassistant.repositories.MainDatabase;
import java.io.IOException;
import static org.junit.Assert.fail;
import org.junit.Test;

public class DatabaseTest {
    private final MainDatabase db = new MainDatabase();

    @Test
    public void file_creation(){
        try {
            this.db.createFiles();
        } catch (IOException ex) {
            fail(ex.getMessage());
        }
    }
    
    @Test
    public void test_file_path(){
    }
}
