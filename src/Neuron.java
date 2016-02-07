import java.util.ArrayList;
import java.util.Random;


public class Neuron {
	
Neuron(int numOutputs){
	
	for(int i = 0; i < numOutputs; ++i ){
		Connection Connection = new Connection();
		m_outputWeights.add(Connection);
		// Initialize with Random Weight of the last Neuron Appended thats why I have size()-1
		m_outputWeights.get(m_outputWeights.size()-1).weight = randomWeight();
	}
	
}

private double m_outputVal;

private ArrayList<Connection> m_outputWeights = new ArrayList<Connection>();

private double randomWeight(){
	double randomdbl = new Random().nextDouble();
	return (randomdbl);
}

public double getoutputVal() {
	return m_outputVal;
}

public void setoutputVal(double m_outputVal) {
	this.m_outputVal = m_outputVal;
}

}
