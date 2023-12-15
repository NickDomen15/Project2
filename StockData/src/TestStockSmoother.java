
public class TestStockSmoother {

	public static void main(String[] args) {
		
		StockSmoother test = new StockSmoother();
		
		test.readCSV("C:\\Users\\Owner\\Downloads\\Programming Classes\\eclipse-workspace\\StockData\\AMZN.csv");
		
		test.smoothData(3);
		
		test.writeToCSV("AMZNsmoothed.csv");
	}
}
