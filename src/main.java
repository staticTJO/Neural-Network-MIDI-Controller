import java.util.ArrayList;
public class main {
	

	public static void main(String [] args)
	{
		
		ArrayList<Integer> topology = new ArrayList<Integer>();
		topology.add(3);
		topology.add(2);
		topology.add(1);
		
		NeuralNet Net = new NeuralNet(topology);
		
		ArrayList<Double> inputVals = new ArrayList<Double>();
		Net.feedForward(inputVals);
		
		ArrayList<Double> targetVals = new ArrayList<Double>();
		Net.backProp(targetVals);
		
		ArrayList<Double> resultVals = new ArrayList<Double>();
		Net.getResults(resultVals);

		
	}

}
