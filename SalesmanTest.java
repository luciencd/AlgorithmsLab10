package Algorithms;

import static org.junit.Assert.*;
import Algorithms.Salesman.*;
import org.junit.Test;

public class SalesmanTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
		Salesman s = new Salesman("Algorithms/att48_d");
		s.setup();
		assertTrue(35162.0==s.getShortest());
		
	}
	@Test
	public void test2(){
		Salesman s = new Salesman("Algorithms/dantzig42_d");
		s.setup();
		assertTrue(704.0==s.getShortest());
	}

}
