import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Training {
	
Training(int Numinputneurons, int Numhiddenneurons, int Numoutputneurons,String TrainingFileName){
	this.NumInputNeruons = Numinputneurons;
	this.NumHiddenNeurons = Numhiddenneurons;
	this.NumOutputNeurons = Numoutputneurons;
	this.TrainingFileName = TrainingFileName;
	// Initialize Topology
	this.topology.add(NumInputNeruons);
	this.topology.add(NumHiddenNeurons);
	this.topology.add(NumOutputNeurons);

	// Initialize ANN
	this.ANN = new NeuralNet(topology);
}

public void RunANN() throws IOException{
	ArrayList<Double> inputVals = new ArrayList<Double>();
	ArrayList<Double> resultVals = new ArrayList<Double>();
	ArrayList<Double> targetVals = new ArrayList<Double>();
	FileReader TrainingData = new FileReader(TrainingFileName);
	BufferedReader tr = new BufferedReader(TrainingData);
	String temp;
	String InputVal1;
	String InputVal2;
	String TargetVals;
	int trainingPass = 0;
	Random doubleRand = new Random();
	
	for(int i = 0; i <= 2000; i++){
		++trainingPass;
		System.out.print("Pass " + trainingPass +" ");
		inputVals.clear();
		//Generate Inputs
		int num1 =  (int)(2.0 * doubleRand.nextDouble());
		int num2 = (int)(2.0 * doubleRand.nextDouble());
		int xor = num1 ^ num2;
		TargetVals = xor + ".0";
		InputVal1 = num1 + ".0";
		InputVal2 = num2 + ".0";
		
		inputVals.add(Double.parseDouble(InputVal1));
		inputVals.add(Double.parseDouble(InputVal2));
		
		System.out.print("Inputs:"+ InputVal1 +" " + InputVal2 +" ");
		ANN.feedForward(inputVals);
		
		ANN.getResults(resultVals);
		for(int n =0; n < resultVals.size(); n++){
		System.out.println("");
		System.out.println("Outputs:"+resultVals.get(n));
	}
		targetVals.clear();
		targetVals.add(Double.parseDouble(TargetVals));
		
		for(int v =0; v < targetVals.size(); v++){
			System.out.println("Target:"+ targetVals.get(v));
		}
		ANN.backProp(targetVals);
		System.out.println("Net recent average Error: " + ANN.getRecentAverageError());
		
	}
//	
//	while((temp = tr.readLine()) != null){
//		++trainingPass;
//		System.out.print("Pass " + trainingPass +" ");
//		if(temp.contains("in: ")){
//			inputVals.clear();
//			InputVal1 = temp.substring(4, 7);
//			InputVal2 = temp.substring(8, 11);
//			inputVals.add(Double.parseDouble(InputVal1));
//			inputVals.add(Double.parseDouble(InputVal2));
//			for(int i =0; i < inputVals.size(); i++){
//				System.out.print("Inputs:"+ inputVals.get(i) + " ");
//			}
//			ANN.feedForward(inputVals);
//		}
//		
//		ANN.getResults(resultVals);
//		for(int i =0; i<resultVals.size(); i++){
//			System.out.println("");
//			System.out.println("Outputs:"+resultVals.get(i));
//		}
//		
//		if (temp.contains("out: ")){
//			targetVals.clear();
//			TargetVals = temp.substring(5, 8);
//			targetVals.add(Double.parseDouble(TargetVals));
//			for(int i =0; i < targetVals.size(); i++){
//				System.out.println("Targets:"+ targetVals.get(i));
//			}
//			ANN.backProp(targetVals);
//		}
//		System.out.println("Net recent average Error: " + ANN.getRecentAverageError());
//	}
//	
//	tr.close();
}

public void setTopology(ArrayList<Integer> topology){
this.topology = topology;
	
}
public ArrayList<Integer> getTopology(){
	return topology;
}

public NeuralNet getANN(){
	return this.ANN;
}

public void setANN(NeuralNet ANN){
	this.ANN = ANN;
}

private ArrayList<Integer> topology = new ArrayList<Integer>();
private NeuralNet ANN;
private String TrainingFileName;

private int NumInputNeruons, NumOutputNeurons, NumHiddenNeurons;
}







