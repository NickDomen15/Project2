import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/**
 * Program to smooth the points of 
 * the graph after being salted
 * @author Nick Domenico
 */
public class DataSmoother {
	
	ArrayList<Double> xValues = new ArrayList<Double>();
	ArrayList<Double> yValues = new ArrayList<Double>();
	
	
	public void smoothData(int windowValue) {
		
		for (int i = 0; i < yValues.size(); i++) {
			
			double smoothedValue = 0;
			int numberOfPoints = 0;
			double windowTotal = 0;
			
			if ((i - windowValue) < 0) {
				for (int j = 0; j < i + windowValue; j++) {
					windowTotal += yValues.get(j);
					numberOfPoints++;
				}
			}
			
			else if ((i + windowValue) > yValues.size()) {
				for (int j = i - windowValue; j < yValues.size(); j++) {
					windowTotal += yValues.get(j);
					numberOfPoints++;
				}
			}
			else {
				for (int j = i - windowValue; j < i + windowValue; j++) {
					windowTotal += yValues.get(j);
					numberOfPoints++;
				}
			}
			
			smoothedValue = windowTotal / numberOfPoints;
			yValues.set(i, smoothedValue);
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
				String[] data = line.split(",");
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
