import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/**
 * 
 * @author Nick Domenico
 */
public class StockSmoother {

	ArrayList<Double> openData = new ArrayList<Double>();
	ArrayList<String> dates = new ArrayList<String>();
	
	
	/**
	 * 
	 * @param int windowValue
	 */
	public void smoothData(int windowValue) {
		
		for (int i = 0; i < openData.size(); i++) {
			
			double smoothedValue = 0;
			int numberOfPoints = 0;
			double windowTotal = 0;
			
			if ((i - windowValue) < 0) {
				for (int j = 0; j < i + windowValue; j++) {
					windowTotal += openData.get(j);
					numberOfPoints++;
				}
			}
			
			else if ((i + windowValue) > openData.size()) {
				for (int j = i - windowValue; j < openData.size(); j++) {
					windowTotal += openData.get(j);
					numberOfPoints++;
				}
			}
			else {
				for (int j = i - windowValue; j < i + windowValue; j++) {
					windowTotal += openData.get(j);
					numberOfPoints++;
				}
			}
			
			smoothedValue = windowTotal / numberOfPoints;
			openData.set(i, smoothedValue);
		}
	}
	
	
	/**
	 * 
	 * @param fileName
	 */
	/*
	 * Code used from:
	 * https://www.studytonight.com/java-examples/reading-a-csv-file-in-java#:~:text=Reading%20CSV%20Files%20by%20Using,the%20comma%20as%20a%20delimiter.
	 */
	public void readCSV(String fileName) {
		
		try {
			
			openData.clear();
			
			FileReader fReader = new FileReader(fileName);
			BufferedReader reader = new BufferedReader(fReader);
			
			String line = reader.readLine();
			line = reader.readLine();
			
			while (line != null) {
				String[] data = line.split(",");
				dates.add(data[0]);
				openData.add(Double.valueOf(data[1]));
				line = reader.readLine();
			}
			
			for (int i = 0; i < openData.size(); i++) {
				System.out.print(openData.get(i).toString() + "\n");
			}
			
			reader.close();
		}
		
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 * @param fileName
	 */
	/*
	 * Code used from:
	 * https://beginnersbook.com/2014/01/how-to-write-to-file-in-java-using-bufferedwriter/
	 */
	public void writeToCSV(String fileName) {
		
		try {
			
			File file = new File(fileName);
			
			if (!file.exists()) {
				file.createNewFile();
			}
			
			FileWriter fWriter = new FileWriter(file);
			BufferedWriter writer = new BufferedWriter(fWriter); 
			
			writer.write("Date,open data\n");
			
			for (int i = 0; i < openData.size(); i++) {
				writer.write(dates.get(i) + "," + (openData.get(i)).toString() + "\n");
			}
			
			writer.close();
			
		}
		
		catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}
}
