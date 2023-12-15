
public class TestGraphPlotter {

	public static void main(String[] args) {
		
		GraphPlotter test = new GraphPlotter();
		
		test.calculateFunction(-100, 101);
		
		test.writeToCSV("GraphPoints.csv", 101, 5);
	}
}
