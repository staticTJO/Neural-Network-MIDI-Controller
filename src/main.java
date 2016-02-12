import java.io.IOException;
import java.util.ArrayList;

public class main {

	public static void main(String[] args) {

		Training XOR = new Training(2, 4, 1, "trainingData.txt");
		
		try {
			XOR.RunANN();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*ArrayList<Double> inputVals = new ArrayList<Double>();
		Net.feedForward(inputVals);

		ArrayList<Double> targetVals = new ArrayList<Double>();
		Net.backProp(targetVals);

		ArrayList<Double> resultVals = new ArrayList<Double>();
		Net.getResults(resultVals);
		
*/
	
	
	}


}
