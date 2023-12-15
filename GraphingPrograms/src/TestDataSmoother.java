
public class TestDataSmoother {

	public static void main(String[] args) {
		
		DataSmoother test = new DataSmoother();
		
		test.readCSV("SaltedData.csv");
		
		test.smoothData(5);
		
		test.writeToCSV("SmoothedData.csv", 51, 1);
	}
}
