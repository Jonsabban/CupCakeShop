/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Data.DataMapper;
import classes.User;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sanox
 */
public class DataMapperTest {

    DataMapper dm;

    @Before
    public void setUp() {
        dm = new DataMapper();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testgetUser() throws SQLException {

        User user = dm.getUser("Hawkdon", "12345");

        assertEquals(user.getUserID(), 1);
        assertEquals(user.getUsername(), "Hawkdon");
        assertEquals(user.getBalance(), 0);

    }

    @Test
    public void testRegisterUser() {

        dm.registerUser("test", "test123");
        User user = dm.getUser("test", "test123");

        assertEquals(user.getUsername(), "test");
        assertEquals(user.getPassword(), "test123");
        assertEquals(user.getBalance(), 0);

    }

}
