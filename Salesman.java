package Algorithms;

import hw7.RPI_map_parser;
import hw7.building;
import hw4.*;

import java.io.IOException;
import java.util.Map;
import java.util.*;

public class Salesman {
	private String nodesFile;// = "Algorithms/att48_d";
	//private static String nodesFile2 = "Algorithms/dantzig42_d";
	private static graph<City,Double> g;
	//private vertex<City,Double> startNode = new vertex<City,Double>(new City("0"));
	public Salesman(String nodesFile_) {
		nodesFile = nodesFile_;
		g = new graph<City,Double>();
	}
	/*public static void main(String[] args){
		Salesman s1 = new Salesman();
		
		try{
			parser.readData(nodesFile, g);
		}catch(IOException c){
			System.out.println("d");
		}
		City startCity = new City("0");
		Iterator<edge<City,Double>> itr = g.getVertex(startCity).listEdgesWeights();
		
		//while(itr.hasNext()){
		//	System.out.println(itr.next());
		//}
		s1.getShortest();
	}*/
	public void setup(){
		SalsemanParser parser = new SalsemanParser();
		City startCity = new City("0");
		try{
			parser.readData(nodesFile, g);
		}catch(IOException c){
			System.out.println("d");
		}
	}
	public double getShortest(){
		double min = 10000000.0;
		double startCitynum = 0;
		int count = 0;
		for(City start : g.getVertices().keySet()){
			double curScore = this.visitor(start);
			//System.out.println(count+" -> "+curScore);
			if(curScore<min){
				min = curScore;
				startCitynum = count;
			}
			count++;
		}
		System.out.println(count+" -> "+min);
		return min;
	}
	
	public double visitor(City start){
		vertex<City,Double> currentVertex = g.getVertex(start);
		//vertex<City,Double> previousVertex = g.getVertex(new City("0"));
		double totalDistance = 0.0;
		//System.out.print(currentVertex.getId().toString()+" -> ");
		while(true){
			//System.out.println("test");
			Iterator<edge<City,Double>> itr = currentVertex.listEdgesWeights();
			boolean noneLeft = true;
			while(itr.hasNext()){
				//System.out.println(currentVertex.getId().toString()+"X -> ");
				edge<City,Double> currentEdge = itr.next();
				if(currentEdge.child().getId().visit()){
					//previousVertex = currentVertex;
					currentVertex = currentEdge.child();
					//System.out.print("("+currentEdge.parent().getId().toString()+")-"+currentEdge.getLabel()+"-("+currentEdge.child().getId().toString()+")");
					//System.out.print(currentEdge.getLabel()+"+");
					noneLeft = false;
					totalDistance+= currentEdge.getLabel();
					break;
				}
			}
			if(noneLeft){break;}
		}
		//System.out.println(" ");
		for(City c : g.getVertices().keySet()){
			c.reset();
		}
		//System.out.println("fuck2");
		//System.out.println("Distance: "+totalDistance);
		return totalDistance;
	}

}
