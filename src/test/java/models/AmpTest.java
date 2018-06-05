package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AmpTest {

    @Before
    public void setUp() throws Exception {
    }

    public Amp setUpAmp(){
        Amp testAmp = new Amp();
        testAmp.setType("guitar amp");
        testAmp.setManufacturer("vox");
        testAmp.setModel("AC-10");
        testAmp.setYear(1976);
        testAmp.setPower("10W");
        testAmp.setImageUrl("www.google.com");
        testAmp.setFinish("Black Tolex");
        testAmp.setGrillCloth("missing");
        return testAmp;
    }
    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void ampInstatiatesCorrectly() throws Exception{
        Amp newAmp = setUpAmp();
        assertEquals(true, newAmp instanceof Amp);
    }

    @Test
    public void getType() {
        Amp newAmp = setUpAmp();
        assertEquals("guitar amp", newAmp.getType());
    }

    @Test
    public void setType() {
        Amp newAmp = setUpAmp();
        newAmp.setType("bass amp");
        assertEquals("bass amp", newAmp.getType());
    }

    @Test
    public void getManufacturer() {
        Amp newAmp = setUpAmp();
        assertEquals("vox", newAmp.getManufacturer());
    }

    @Test
    public void setManufacturer() {
        Amp newAmp = setUpAmp();
        newAmp.setManufacturer("fender");
        assertEquals("fender", newAmp.getManufacturer());
    }

    @Test
    public void getModel() {
        Amp newAmp = setUpAmp();
        assertEquals("AC-10", newAmp.getModel());
    }

    @Test
    public void setModel() {
        Amp newAmp = setUpAmp();
        newAmp.setModel("AC-30");
        assertEquals("AC-30", newAmp.getModel());
    }

    @Test
    public void getYear() {
        Amp newAmp = setUpAmp();
        assertEquals(1976, newAmp.getYear());
    }

    @Test
    public void setYear() {
        Amp newAmp = setUpAmp();
        newAmp.setYear(1967);
        assertEquals(1967, newAmp.getYear());
    }

    @Test
    public void getPower() {
    }

    @Test
    public void setPower() {
    }

    @Test
    public void getImageUrl() {
    }
}