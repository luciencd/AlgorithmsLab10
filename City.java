package Algorithms;

import hw7.building;

public class City implements Comparable<City>{
	int id;
	String name;
	boolean visited = false;
	public City(String name_) {
		name = name_;
		id = Integer.parseInt(name_);
		visited = false;
		// TODO Auto-generated constructor stub
	}
	public void reset(){
		visited = false;
	}
	
	public boolean visit(){
		if(!visited){
			visited = true;
			return true;
		}else{
			return false;
		}
	}
	@Override
	public boolean equals(Object c){
		if(c instanceof City){
			if((c.toString().equals(toString()))){
				return true;
			}
		}
		return false;
		
		
	}
	@Override
	public int hashCode(){
		return id;
	}

	@Override
	public int compareTo(City b1){
		//Double distance = Math.pow(Math.pow(this.x-b1.getx(),2)+Math.pow(this.y-b1.gety(),2),.5);
		return name.compareTo(b1.name);
	}
	@Override
	public String toString(){
		return name;
	}

}
