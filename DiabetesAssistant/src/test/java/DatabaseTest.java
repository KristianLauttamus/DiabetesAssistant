/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.lauttadev.diabetesassistant.Database;
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
public class DatabaseTest {
    private final Database db = new Database();

    @Test
    public void file_creation(){
        this.db.createFiles();
    }
}
