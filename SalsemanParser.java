package Algorithms;

import hw4.graph;
import Algorithms.City;
import hw7.building;
import hw4.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class SalsemanParser {

	public static void readData(String fileroads, graph<City,Double> g) 
    		throws IOException {

		//Place initial Vertices.
    	BufferedReader reader = new BufferedReader(new FileReader(fileroads));
        String line = null;
        //HashMap<City,Double>
        int source = 0;
        while ((line = reader.readLine()) != null) {
        	//System.out.println(line);
        	//System.out.println("hashcode : "+(new City(String.valueOf(source))).hashCode());
            g.addVertex(new City(String.valueOf(source)));
            
            source++;
        }
        reader.close();
        //
        HashMap<City,vertex<City,Double>> h = g.getVertices();
        //for(City c : h.keySet()){
        //	System.out.println("hashcode1: "+c.hashCode());
        //}
        //Add edges.
        reader = new BufferedReader(new FileReader(fileroads));
        line = null;
        
        source = 0;
        while ((line = reader.readLine()) != null) {
            List<String> items =  new ArrayList<String>(Arrays.asList(line.split(" ")));
            
            items.removeAll(Arrays.asList("", null));

            int target = 0;
            
            for(String item : items){
              	Double distance = Double.parseDouble(item);
              	City c1 = new City(String.valueOf(source));
              	City c2 = new City(String.valueOf(target));

              	g.addEdge(c1,c2,distance);
              	//g.addEdge(c2,c1,distance);
              	target++;
            }
            source++;
        	
        }
        
    }
}
