/*
 * Class: CMSC203
 * Instructor: Dr. Grinberg
 * Description: This class contains utility methods for handling and manipulating two-dimensional ragged arrays.
 * Due: 11/11/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: Jedidiah Dawit
 */

package Assignment5;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public final class TwoDimRaggedArrayUtility {

    public static double getAverage(double[][] data) {
        double sum = 0;
        int count = 0;
        for (double[] row : data)
            for (double value : row) {
                sum += value;
                count++;
            }
        return sum / count;
    }

    public static double getColumnTotal(double[][] data, int col) {
        double sum = 0;
        for (double[] row : data) 
            if (col < row.length) sum += row[col];
        return sum;
    }

    public static double getHighestInArray(double[][] data) {
        double highest = data[0][0];
        for (double[] row : data)
            for (double value : row)
                highest = Math.max(highest, value);
        return highest;
    }

    public static double getHighestInColumn(double[][] data, int col) {
        double highest = Double.MIN_VALUE;
        for (double[] row : data) 
            if (col < row.length) highest = Math.max(highest, row[col]);
        return highest;
    }

    public static int getHighestInColumnIndex(double[][] data, int col) {
        double highest = data[0][col];
        int index = 0;
        for (int i = 0; i < data.length; i++) 
            if (col < data[i].length && data[i][col] > highest) {
                highest = data[i][col];
                index = i;
            }
        return index;
    }

    public static double getHighestInRow(double[][] data, int row) {
        double highest = data[row][0];
        for (double value : data[row]) 
            highest = Math.max(highest, value);
        return highest;
    }

    public static int getHighestInRowIndex(double[][] data, int row) {
        double highest = data[row][0];
        int index = 0;
        for (int i = 0; i < data[row].length; i++) 
            if (data[row][i] > highest) {
                highest = data[row][i];
                index = i;
            }
        return index;
    }

    public static double getLowestInArray(double[][] data) {
        double lowest = data[0][0];
        for (double[] row : data)
            for (double value : row)
                lowest = Math.min(lowest, value);
        return lowest;
    }

    public static double getLowestInColumn(double[][] data, int col) {
        double lowest = Double.MAX_VALUE;
        for (double[] row : data)
            if (col < row.length) lowest = Math.min(lowest, row[col]);
        return lowest;
    }

    public static int getLowestInColumnIndex(double[][] data, int col) {
        double lowest = data[0][col];
        int index = 0;
        for (int i = 0; i < data.length; i++) 
            if (col < data[i].length && data[i][col] < lowest) {
                lowest = data[i][col];
                index = i;
            }
        return index;
    }

    public static double getLowestInRow(double[][] data, int row) {
        double lowest = data[row][0];
        for (double value : data[row]) 
            lowest = Math.min(lowest, value);
        return lowest;
    }

    public static int getLowestInRowIndex(double[][] data, int row) {
        double lowest = data[row][0];
        int index = 0;
        for (int i = 0; i < data[row].length; i++) 
            if (data[row][i] < lowest) {
                lowest = data[row][i];
                index = i;
            }
        return index;
    }

    public static double getRowTotal(double[][] data, int row) {
        double sum = 0;
        for (double value : data[row]) 
            sum += value;
        return sum;
    }

    public static double getTotal(double[][] data) {
        double sum = 0;
        for (double[] row : data)
            for (double value : row) 
                sum += value;
        return sum;
    }

    public static double[][] readFile(java.io.File file) {
        int numRows = 0;
        try (Scanner dataReader = new Scanner(file)) {
            while (dataReader.hasNextLine()) {
                numRows++;
                dataReader.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        double[][] data = new double[numRows][]; 
        try (Scanner dataReader = new Scanner(file)) {
            for (int i = 0; i < numRows; i++) {
                String[] nextNumbers = dataReader.nextLine().split(" ");
                data[i] = new double[nextNumbers.length];
                for (int j = 0; j < nextNumbers.length; j++) 
                    data[i][j] = Double.parseDouble(nextNumbers[j]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return data;
    }

    public static void writeToFile(double[][] data, java.io.File outputFile) {
        try (FileWriter fileWriter = new FileWriter(outputFile)) {
            for (double[] row : data) {
                for (double value : row)
                    fileWriter.write(value + " ");
                fileWriter.write('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
