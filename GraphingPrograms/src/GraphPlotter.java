import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/**
 * Program to write points of a function 
 * to a CSV to be used in Excel
 * @author Nick Domenico
 */
public class GraphPlotter {

	ArrayList<Double> xValues = new ArrayList<Double>();
	ArrayList<Double> yValues = new ArrayList<Double>();
	
	
	/**
	 * Adds the x and y values of a function 
	 * to the xValues and yValues ArrayLists
	 * 
	 * The function that I am using is y = 2x^2 + 4x + 3
	 * @param int range
	 */
	public void calculateFunction(int lowerRange, int upperRange) {
		
		for (int i = lowerRange; i < upperRange; i++) {
			xValues.add(Double.valueOf(i));
			yValues.add(Double.valueOf(2 * Math.pow(i, 2) + 4 * i + 3));
		}
		
	}
	
	
	/**
	 * Writes the x and y values in the xValues 
	 * and yValues ArrayLists to a CSV file
	 * @param String fileName
	 * @param int numberOfPoints
	 * @param int interval
	 */
	/*
	 * Code used from:
	 * https://beginnersbook.com/2014/01/how-to-write-to-file-in-java-using-bufferedwriter/
	 */
	public void writeToCSV(String fileName, int numberOfPoints, int interval) {
		
		try {
			
			File file = new File(fileName);
			
			if (!file.exists()) {
				file.createNewFile();
			}
			
			FileWriter fWriter = new FileWriter(file);
			BufferedWriter writer = new BufferedWriter(fWriter); 
			
			writer.write("x values, y values \n");
			
			for (int i = 0; i < numberOfPoints; i = i + interval) {
				writer.write(xValues.get(i) + ", " + yValues.get(i) + "\n");
			}
			
			writer.close();
			
		}
		
		catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}
}
