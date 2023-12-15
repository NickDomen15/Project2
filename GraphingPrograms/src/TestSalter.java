
public class TestSalter {

	public static void main(String[] args) {
		
		Salter test = new Salter();
		
		test.readCSV("GraphPoints.csv");
		
		test.saltData(500);
		
		test.writeToCSV("SaltedData.csv", 51, 1);
	}
}
