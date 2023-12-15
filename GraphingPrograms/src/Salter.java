import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
/**
 * Program to salt the points of the 
 * function from the GraphPlotter program
 * @author Nick Domenico
 */
public class Salter {

	Random rand = new Random();
	
	ArrayList<Double> xValues = new ArrayList<Double>();
	ArrayList<Double> yValues = new ArrayList<Double>();
	
	
	/**
	 * Adds or subtracts random values within saltValueRange 
	 * from all of the values in ArrayList yValues
	 * @param int saltValueRange
	 */
	public void saltData(int saltValueRange) {
		
		for (int i = 0; i < yValues.size(); i++) {
			int opperation = rand.nextInt(1);
			int saltValue = rand.nextInt(saltValueRange);
			
			if (opperation == 0) {
				yValues.set(i, yValues.get(i) - saltValue);
			}
			
			else if (opperation == 1){
				yValues.set(i, yValues.get(i) + saltValue);
			}
		}
		
	}
	
	
	/**
	 * Reads a CSV file of graph points and 
	 * adds to xValues and yValues ArrayLists
	 * @param fileName
	 */
	/*
	 * Code used from:
	 * https://www.studytonight.com/java-examples/reading-a-csv-file-in-java#:~:text=Reading%20CSV%20Files%20by%20Using,the%20comma%20as%20a%20delimiter.
	 */
	public void readCSV(String fileName) {
		
		try {
			
			xValues.clear();
			yValues.clear();
			
			FileReader fReader = new FileReader(fileName);
			BufferedReader reader = new BufferedReader(fReader);
			
			String line = reader.readLine();
			line = reader.readLine();
			
			while (line != null) {
				String[] data = line.split(", ");
				xValues.add(Double.valueOf(data[0]));
				yValues.add(Double.valueOf(data[1]));
				line = reader.readLine();
			}
			
			reader.close();
		}
		
		catch (IOException ioe) {
			ioe.printStackTrace();
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
