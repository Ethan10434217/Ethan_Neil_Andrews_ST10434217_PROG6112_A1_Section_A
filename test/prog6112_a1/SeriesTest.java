package prog6112_a1;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SeriesTest {
       
    @Before
    public void setUp() {
        Series.clearSeriesList();
        Series.addSeries(new SeriesModel("101", "Extreme Sports", "12", "10"));
    }
            
    @Test
    public void testSearchSeries() {
       String result = Series.searchSeriesById("101");
       assertTrue(result.contains("Extreme Sports"));
    }
    
     @Test
    public void testSearchSeriesNotFound() {
       String result = Series.searchSeriesById("300");
       assertEquals("Series with series ID: 300 was not found", result);
    }
    
    @Test
    public void testUpdateSeries() {
        //updating the series with preset values
       boolean updated = Series.updateSeriesById("101", "Updated Series", "15", "20");
       assertTrue(updated);
       
       String result = Series.searchSeriesById("101");
       assertTrue(result.contains("Updated Series"));
       assertTrue(result.contains("15"));
       assertTrue(result.contains("20"));
    }    

    public void testSeriesDelete() {
        //value can be found the test will pass
     boolean deleted = Series.deleteSeriesById("101");
     assertTrue(deleted);
     
     String result = Series.searchSeriesById("101");
     assertEquals("Series with series ID: 101 was not found", result);
    }

     @Test
    public void testSeriesDelete_SeriesNotFound() {
        //value can not be found test will fail
     boolean deleted = Series.deleteSeriesById("999");
     assertFalse(deleted);    
    }

    @Test
    public void testSeriesAgeRestriction_AgeValid(){
        //correct values the test will pass
        assertTrue(Series.isValidAgeRestriction("10"));
        assertTrue(Series.isValidAgeRestriction("2"));
        assertTrue(Series.isValidAgeRestriction("18"));
    }
  
     @Test
    public void testSeriesAgeRestriction_AgeInValid(){
        //values are invalid as they are too low, too high and not integers the test will fail
        assertFalse(Series.isValidAgeRestriction("1"));
        assertFalse(Series.isValidAgeRestriction("19"));
        assertFalse(Series.isValidAgeRestriction("sixteen"));
    }
}
