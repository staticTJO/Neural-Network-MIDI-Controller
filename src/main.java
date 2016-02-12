import java.io.IOException;
import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		
//		ArrayList<Integer> topology = new ArrayList<Integer>();
//		topology.add(2);
//		topology.add(4);
//		topology.add(1);
//		ArrayList<ArrayList<Neuron>> layerTest = new ArrayList<ArrayList<Neuron>>();
//		
//		
//		NeuralNet newNet = new NeuralNet(topology);
//		
//		layerTest = newNet.getm_layer();
//		
//		for(int i = 0; i< layerTest.size(); i++){
//			for(int n =0; n < layerTest.get(i).size(); n++){
//				System.out.println(layerTest.get(i).get(n).getoutputVal());
//			}
//			System.out.println("Layer");
//		}
//	

		
		
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
