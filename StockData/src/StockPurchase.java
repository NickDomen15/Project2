import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 * 
 * @author Nick Domenico
 */
public class StockPurchase {

	private int day = 0;
	private int decision = 0;
	private double startingMoney = 10000;
	private double currentMoney = 10000;
	private double netWorth = 0;
	private double mean = 0;
	private double variance = 0;
	private double standardDeviation = 0;
	
	
	ArrayList<Double> openData = new ArrayList<Double>();
	
	
	public void tradeEvaluator() {
		
		double currentDayValue = openData.get(openData.size() - 1);
		
		if (currentDayValue > mean + 25) {
			currentMoney = currentMoney + currentDayValue * 10;
			decision = 1;
		}
		else if (currentDayValue < mean - 25) {
			currentMoney = currentMoney - currentDayValue * 10;
			decision = -1;
		}
		else {
			decision = 0;
		}
		
		netWorth = currentMoney - startingMoney;
	}
	
	
	/**
	 * 
	 */
	public void updateInternalData() {
		
		// mean
		double meanSum = 0;
		int count = 0;
		for (int i = 0; i < openData.size(); i++) {
			meanSum = meanSum + openData.get(i);
			count++;
		}
		mean = meanSum/count;
		
		// variance
		double varSum = 0;
		for (int i = 0; i < openData.size(); i++) {
			varSum = varSum + Math.pow(openData.get(i) - mean, 2);
		}
		variance = varSum/(openData.size() - 1);
		
		// standard deviation
		standardDeviation = Math.sqrt(variance);
		
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
				openData.add(Double.valueOf(data[1]));
				
				day++;
				updateInternalData();
				tradeEvaluator();
				
				System.out.println("Day " + day + "\n   - Mean: " + mean + "\n   - Variance: " + variance + "\n   - Standard Deviation: " + standardDeviation);
				if (decision == 1) {
					System.out.println("\n   - Decision: sell");
				}
				if (decision == -1) {
					System.out.println("\n   - Decision: purchase");
				}
				if (decision == 0) {
					System.out.println("\n   - Decision: nothing");
				}
				System.out.println("\n   - Net worth: " + netWorth);
			
				line = reader.readLine();
			}
			
			reader.close();
		}
		
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	
}
