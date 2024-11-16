/*
 * Class: CMSC203
 * Instructor: Dr. Grinberg
 * Description: This class contains unit tests for the HolidayBonus class, which calculates holiday bonuses based on store sales data.
 * Due: 11/11/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: Jedidiah Dawit
 */

package Assignment5;

import static org.junit.Assert.*;
import org.junit.Test;

public class HolidayBonusTestStudent {

    @Test
    public void testCalculateHolidayBonus() {
        // Test data: sales for 3 stores, 3 categories each
        double[][] salesData = {
            {1000, 2000, 1500},  // Store 0
            {500, 400, 800},     // Store 1
            {3000, 2500, 2200}   // Store 2
        };

        HolidayBonus holidayBonus = new HolidayBonus();
        
        // Expected bonus array for each store
        double[] expectedBonuses = {300.0, 200.0, 500.0};
        
        // Calculate bonuses
        double[] bonuses = holidayBonus.calculateHolidayBonus(salesData);
        
        // Assert that the calculated bonuses match the expected ones
        assertArrayEquals(expectedBonuses, bonuses, 0.01);
    }

    @Test
    public void testCalculateTotalHolidayBonus() {
        // Test data: sales for 3 stores, 3 categories each
        double[][] salesData = {
            {1000, 2000, 1500},  // Store 0
            {500, 400, 800},     // Store 1
            {3000, 2500, 2200}   // Store 2
        };

        HolidayBonus holidayBonus = new HolidayBonus();
        
        // Expected total bonus
        double expectedTotalBonus = 300.0 + 200.0 + 500.0;  // 1000.0
        
        // Calculate the total bonus
        double totalBonus = holidayBonus.calculateTotalHolidayBonus(salesData);
        
        // Assert that the total calculated bonus matches the expected one
        assertEquals(expectedTotalBonus, totalBonus, 0.01);
    }
}
