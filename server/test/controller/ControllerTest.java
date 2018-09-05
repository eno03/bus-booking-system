/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import data.Request;
import data.Reservation;
import frames.Frame;
import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author wint4
 */
public class ControllerTest {

    public ControllerTest() {
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

    /**
     * Test of decodeRequest method, of class Controller.
     */
    @Test
    public void testCheckDiscountStudent() {
        System.out.println("Test checkDiscount method for student");
        String str = "Student";
        double request = 1800;
        double expResult = 1440;
        double result = Controller.checkDiscount(str, request);
        assertEquals(expResult, result, 0.0);

    }

    @Test
    public void testCheckDiscountRetiree() {
        System.out.println("Test checkDiscount method for retiree");
        String str = "Retiree";
        double request = 1800;
        double expResult = 1710;
        double result = Controller.checkDiscount(str, request);
        assertEquals(expResult, result, 0.0);

    }

}
