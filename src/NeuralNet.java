import java.util.ArrayList;

public class NeuralNet {
	public ArrayList<Neuron> Layer;
	public ArrayList<Neuron> prevLayer = new ArrayList<Neuron>();
	public ArrayList<Neuron> outputLayer = new ArrayList<Neuron>();
	public ArrayList<Neuron> hiddenLayer = new ArrayList<Neuron>();
	public ArrayList<Neuron> nextLayer = new ArrayList<Neuron>();
	public double m_recentAverageError = 100.0;

	NeuralNet(final ArrayList<Integer> topology) {
		int numLayers = topology.size();
		for (int layerNum = 0; layerNum < numLayers; ++layerNum) {
			Layer = new ArrayList<Neuron>();
			this.m_layer.add(Layer);
			int numOutputs = layerNum == topology.size() - 1 ? 0 : topology
					.get(layerNum + 1);
			for (int neuronNum = 0; neuronNum < topology.get(layerNum)+1; ++neuronNum) {

				Neuron Neuron = new Neuron(numOutputs,neuronNum);

				m_layer.get(m_layer.size() - 1).add(Neuron);
				//m_layer.get(layerNum).add(Neuron);
			}
			//Set Bias to constant value of 1.0
			m_layer.get(layerNum).get(m_layer.get(layerNum).size()-1).setoutputVal(1.0);
		}
		
	}

	public void feedForward(final ArrayList<Double> inputVals) {
	//assert (inputVals.size() == m_layer.get(0).size() - 1);
		// This will Assign the input values into the input neurons
		for (int i = 0; i < inputVals.size(); i++) {
			m_layer.get(0).get(i).setoutputVal(inputVals.get(i));
		}

		// Forward Propagate
		for (int layerNum = 1; layerNum < m_layer.size(); ++layerNum) {
			// Gets instance of object
			prevLayer = m_layer.get(layerNum -1); //here 
			for (int n = 0; n < m_layer.get(layerNum).size()-1; ++n) {
				m_layer.get(layerNum).get(n).feedForward(prevLayer);
			}
		}

	}

	public void backProp(final ArrayList<Double> targetVals) {
		//check this... // For all layers from outputs to first hidden layer
		outputLayer = m_layer.get(m_layer.size() - 1);
		m_error = 0.0;
		
		// Calculate Net Error (using RMS)
		for(int n =0; n < outputLayer.size()-1; ++n){
			double delta = targetVals.get(n) - outputLayer.get(n).getoutputVal();
			
			m_error += delta * delta;
		}
		
		m_error /= outputLayer.size() -1;
		m_error = Math.sqrt(m_error);
		
		//Determine recent average measure
		
		m_recentAverageError = (m_recentAverageError * m_recentAverageSmoothingFactor + m_error) / (m_recentAverageSmoothingFactor + 1.0);
		
		// Calculate the Output Layer Gradients
		for(int n= 0; n < outputLayer.size() -1; ++n){
	
			outputLayer.get(n).calcOutputGradients(targetVals.get(n));
		}
		
		// Calculate gradients on hidden layers
		for(int layerNum = m_layer.size()-2; layerNum > 0; --layerNum){
			hiddenLayer = m_layer.get(layerNum);
			nextLayer = m_layer.get(layerNum + 1);
			for(int n = 0; n < hiddenLayer.size(); ++n){
				hiddenLayer.get(n).calcHiddenGradients(nextLayer);
			}
		}
		
		// update the connections
		
		for (int layerNum = m_layer.size() - 1; layerNum > 0; --layerNum){
			Layer = m_layer.get(layerNum);
			prevLayer = m_layer.get(layerNum -1);
			
			for(int n = 0; n < Layer.size()-1; ++n){
				Layer.get(n).updateInputWeights(prevLayer);
				
			}
		}
		
	}

	public void getResults(ArrayList<Double> resultVals) {
		resultVals.clear();
		for(int n = 0; n < m_layer.get(m_layer.size() - 1).size()-1; ++n ){
			resultVals.add(m_layer.get(m_layer.size() - 1).get(n).getoutputVal());
		}
	}
	
	private ArrayList<ArrayList<Neuron>> m_layer = new ArrayList<ArrayList<Neuron>>(); // m_layer has [layerNum][NeuronNum]
	private double m_error;
	private double m_recentAverageSmoothingFactor;

	public double getRecentAverageError() {
		// TODO Auto-generated method stub
		return m_recentAverageError;
	}
	
	public ArrayList<ArrayList<Neuron>> getm_layer(){
		return this.m_layer;
	}

}
