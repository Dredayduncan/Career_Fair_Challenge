package Career_Fair_Challenge;

import java.io.FileNotFoundException;

public class Test {
	public static void main(String[] args) {
		Utilities u=null;
		try {
			u = new Utilities("C:\\Users\\HP\\Desktop\\CFC\\src\\Career_Fair_Challenge\\population_data.csv", "C:\\Users\\HP\\Desktop\\CFC\\src\\Career_Fair_Challenge\\covid_data.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Country c : u.getOnTheFall()) {
			System.out.println(c.getName() +" "+c.getCorrelation()+" "+c.getInfectionCount());
		}
		System.out.println();
		for (Country c : u.getOnTheRise()) {
			System.out.println(c.getName() +" "+c.getCorrelation()+" "+c.getInfectionCount());
		}
		
	}
}
