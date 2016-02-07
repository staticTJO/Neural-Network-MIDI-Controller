import java.util.ArrayList;

public class NeuralNet {

public ArrayList<Neuron> Layer = new ArrayList<Neuron>();

public ArrayList<Neuron> prevLayer = new ArrayList<Neuron>();


public NeuralNet( final ArrayList<Integer> topology) {
	int numLayers = topology.size();
	for (int layerNum = 0; layerNum < numLayers; ++layerNum){
		m_layer.add(Layer);
		
		for(int neuronNum = 0; neuronNum <= topology.size()-1; ++neuronNum){
			
			int numOutputs = layerNum == topology.size() - 1 ? 0: topology.get(layerNum +1);
			
			Neuron Neuron = new Neuron(numOutputs);
			
			m_layer.get(m_layer.size()-1).add(Neuron);
			System.out.println("Added a Neuron!");
		}
	}
}




public void feedForward(final ArrayList<Double> inputVals) {

	assert(inputVals.size() == m_layer.get(0).size() -1);
	
	// This will Assign the input values into the input neurons
	for(int i = 0; i < inputVals.size(); i++){
		m_layer.get(0).get(i).setoutputVal(inputVals.get(i));
	}
	
	//Forward Propagate
	for(int layerNum = 1; layerNum < m_layer.size(); ++layerNum){
		for(int n = 0; n < m_layer.get(layerNum).size()-1; ++n){
			m_layer.get(layerNum).get(n).feedForward(prevLayer);
		}
	}
	
}

public void backProp(final ArrayList<Double> targetVals) {
	// TODO Auto-generated method stub
	
}

public static final void getResults(ArrayList<Double> resultVals) {
	// TODO Auto-generated method stub
	
}


private ArrayList<ArrayList<Neuron>> m_layer = new ArrayList<ArrayList<Neuron>>(); // m_layers has [layerNum][NeuronNum]


}
