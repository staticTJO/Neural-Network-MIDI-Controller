import java.util.ArrayList;

public class NeuralNet {

public ArrayList<Neuron> Layer = new ArrayList<Neuron>();

Neuron Neuron = new Neuron();

public NeuralNet( final ArrayList<Integer> topology) {
	int numLayers = topology.size();
	for (int layerNum = 0; layerNum < numLayers; ++layerNum){
		m_layer.add(Layer);
		
		for(int neuronNum = 0; neuronNum <= topology.size(); ++neuronNum){
			
			m_layer.get(m_layer.size()-1).add(Neuron);
			System.out.println("Added a Neuron!");
		}
	}
}




public void feedForward(final ArrayList<Double> inputVals) {
	// TODO Auto-generated method stub
	
}

public void backProp(final ArrayList<Double> targetVals) {
	// TODO Auto-generated method stub
	
}

public static final void getResults(ArrayList<Double> resultVals) {
	// TODO Auto-generated method stub
	
}


private ArrayList<ArrayList<Neuron>> m_layer = new ArrayList<ArrayList<Neuron>>(); // m_layers has [layerNum][NeuronNum]


}
