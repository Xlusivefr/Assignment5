/*
 * Class: CMSC203
 * Instructor: Dr. Grinberg
 * Description: This class calculates holiday bonuses for stores based on their sales data, awarding the highest and lowest sales stores different bonuses.
 * Due: 11/11/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: Jedidiah Dawit
 */

package Assignment5;

public class HolidayBonus {
    // Constant values for bonus amounts
    private static final double HIGHEST_SALES_BONUS = 500.0;  // Bonus for store with highest sales
    private static final double LOWEST_SALES_BONUS = 200.0;   // Bonus for store with lowest sales
    private static final double OTHER_STORES_BONUS = 300.0;   // Bonus for all other stores

    /**
     * Calculates the holiday bonuses for each store in the district.
     *
     * @param salesData A ragged 2D array where each row represents sales data for a store in various categories.
     * @return An array of holiday bonuses corresponding to each store.
     */
    public static double[] calculateHolidayBonus(double[][] salesData) {
        double[] bonuses = new double[salesData.length];

        // Iterate through each store and calculate the bonus
        for (int storeIndex = 0; storeIndex < salesData.length; storeIndex++) {
            // Get the sales data for this store
            double[] storeSales = salesData[storeIndex];

            // Find the highest and lowest sales for this store
            double highestSale = findHighestInRow(storeSales);
            double lowestSale = findLowestInRow(storeSales);

            // Determine the bonus for the store based on its highest and lowest sales
            if (highestSale == findHighestInArray(salesData)) {
                // If this store has the highest sales in any category
                bonuses[storeIndex] = HIGHEST_SALES_BONUS;
            } else if (lowestSale == findLowestInArray(salesData)) {
                // If this store has the lowest sales in any category
                bonuses[storeIndex] = LOWEST_SALES_BONUS;
            } else {
                // For all other stores
                bonuses[storeIndex] = OTHER_STORES_BONUS;
            }
        }

        return bonuses;
    }

    /**
     * Calculates the total holiday bonus for the district.
     *
     * @param salesData A ragged 2D array where each row represents sales data for a store in various categories.
     * @return The total holiday bonus for all stores in the district.
     */
    public static double calculateTotalHolidayBonus(double[][] salesData) {
        double totalBonus = 0.0;

        // Calculate the bonus for each store and accumulate the total
        double[] bonuses = calculateHolidayBonus(salesData);
        for (double bonus : bonuses) {
            totalBonus += bonus;
        }

        return totalBonus;
    }

    // Helper methods for calculating highest and lowest values
    private static double findHighestInRow(double[] row) {
        double highest = Double.NEGATIVE_INFINITY;
        for (double sale : row) {
            if (sale > highest) {
                highest = sale;
            }
        }
        return highest;
    }

    private static double findLowestInRow(double[] row) {
        double lowest = Double.POSITIVE_INFINITY;
        for (double sale : row) {
            if (sale < lowest) {
                lowest = sale;
            }
        }
        return lowest;
    }

    private static double findHighestInArray(double[][] array) {
        double highest = Double.NEGATIVE_INFINITY;
        for (double[] row : array) {
            for (double sale : row) {
                if (sale > highest) {
                    highest = sale;
                }
            }
        }
        return highest;
    }

    private static double findLowestInArray(double[][] array) {
        double lowest = Double.POSITIVE_INFINITY;
        for (double[] row : array) {
            for (double sale : row) {
                if (sale < lowest) {
                    lowest = sale;
                }
            }
        }
        return lowest;
    }
}
