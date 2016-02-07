import java.util.ArrayList;

public class main {

	public static void main(String[] args) {

		ArrayList<Integer> topology = new ArrayList<Integer>();
		topology.add(3); // Input Layer 2 + bias
		topology.add(2); // Hidden Layer 1 + bias
		topology.add(1); // Output layer 1 + bias
		


		NeuralNet Net = new NeuralNet(topology);

		/*ArrayList<Double> inputVals = new ArrayList<Double>();
		Net.feedForward(inputVals);

		ArrayList<Double> targetVals = new ArrayList<Double>();
		Net.backProp(targetVals);

		ArrayList<Double> resultVals = new ArrayList<Double>();
		Net.getResults(resultVals);
		
*/
	
	
	}


}
