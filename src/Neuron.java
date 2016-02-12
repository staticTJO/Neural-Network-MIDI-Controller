import java.util.ArrayList;
import java.util.Random;


public class Neuron {
	
Neuron(int numOutputs, int myIndex) {
	for(int i = 0; i < numOutputs ; ++i ){
		Connection Connection = new Connection();
		m_outputWeights = new ArrayList<Connection>();
		m_outputWeights.add(Connection);
		// Initialize with Random Weight of the last Neuron Appended thats why I have size()-1
		m_outputWeights.get(m_outputWeights.size()-1).weight = randomWeight();
		// Test to see weight values of neurons are properly set
	}
		m_myIndex = myIndex;
}



// Public Methods
public double getoutputVal() {
	return m_outputVal;
}

public void setoutputVal(double m_outputVal) {
	this.m_outputVal = m_outputVal;
}

public void feedForward(final ArrayList<Neuron> prevLayer) {
	double sum = 0.0;
	for (int n = 0; n < prevLayer.size(); ++n){
		// output = Function(sum of Iconnections * IWeights)
		// m_myIndex Number ensures all Neurons Know their own Index Number.
		sum += prevLayer.get(n).getoutputVal() * prevLayer.get(n).m_outputWeights.get(m_myIndex).weight;	
	}
	m_outputVal = transferFunction(sum);
}

public void calcOutputGradients(double targetVal) {

	double delta = targetVal - m_outputVal;
	m_gradient = delta * transferFunctionDerivative(m_outputVal);
}

public void calcHiddenGradients(final ArrayList<Neuron> nextLayer) {

	double dow = sumDow(nextLayer);
	m_gradient = dow * transferFunctionDerivative(m_outputVal);
}

public void updateInputWeights(final ArrayList<Neuron> prevLayer){ //Good
	// The weights are updated in the Connection container
	// of the neuron in the preceding layer
	
	for(int n = 0; n < prevLayer.size(); ++n){
		// I think this is correct.
		Neuron neuron = prevLayer.get(n);
		double oldDeltaWeight = neuron.m_outputWeights.get(m_myIndex).deltaWeight;
/*		n (eta) - Overall net learning Rate
		0.0 - slow learner
		0.2 - medium learner
		1.0 - reckless learner
		
		a (alpha) - momentum
		0.0 - no momentum
		0.5 - moderate momentum*/
		// Individual input, magnified by the gradient and training rate
		double newDeltaWeight = eta * neuron.getoutputVal() * m_gradient * alpha * oldDeltaWeight;
		neuron.m_outputWeights.get(m_myIndex).deltaWeight = newDeltaWeight;
		neuron.m_outputWeights.get(m_myIndex).weight += newDeltaWeight;
	}
}

public double sumDow(final ArrayList<Neuron> nextLayer){ //Good
	double sum = 0.0;
	
	// Sum up the contributed errors at the nodes fed
	for(int n =0; n < nextLayer.size()-1; ++n ){
		sum += m_outputWeights.get(n).weight * nextLayer.get(n).m_gradient;
	}
	
	return sum;
}



private double m_outputVal;
private int m_myIndex;
private ArrayList<Connection> m_outputWeights;

// Private Methods
private double randomWeight() {
	double randomdbl = new Random().nextDouble();
	return (randomdbl);
}

private double transferFunction(double x) {
// using tanH - output range[-1.0 - 1.0]
	
	return Math.tanh(x);
}

private double transferFunctionDerivative(double x){
	//tanh Derivative
	return 1.0 - x*x;
}

private double m_gradient;
public static double eta = 0.15; // [0.0 .. 1.0] learning rate
public static double alpha = 0.5; // [0.0 .. n] Multiplier of last weight change is the MOMENTUM
}

