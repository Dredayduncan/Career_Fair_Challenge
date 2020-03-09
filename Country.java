/**
 * 
 * @author Bryan Tetteh Ayertey
 *
 */
package Career_Fair_Challenge;
import java.util.ArrayList;


public class Country {
	private String name;
	ArrayList<InfectionCase> infections = new ArrayList<>();
	private long population;
	private int count;
	private int deaths;
	private int highestInfections;
	/**
	 * The constructor for the Country calls that takes the countries name and poplutaion.
	 * @param name The name of the country
	 * @param population The population of the country
	 */
	public Country(String name, long population) {
		this.name = name;
		this.population = population;
		count = 0;
		deaths=0;
		highestInfections=-1;
	}

	/**
	 * Set the number of recorded infections
	 * @param count Number of infections reported
	 */
	public void setInfectionCount(int count){
		this.count = count;
	}

	/**
	 * Get the number of infections that occured in the country
	 * @return the number of infections
	 */
	public int getInfectionCount() {
		return count;
	}
	
	/**
	 * Get the name of the country
	 * @return the name of the country
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Set the name of the country
	 * @param name the new name of the country
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the population of the country
	 * @return the population of the country
	 */
	public long getPopulation() {
		return population;
	}

	/**
	 * Get the population the country
	 * @param population The population of the country
	 */
	public void setPopulation(int population) {
		this.population = population;
	}

	/**
	 * Set the number of recorded deaths
	 * @param deaths Number of deaths reported
	 */
	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}

	/**
	 * Add a day's infection cases count to the countries list of cases and count
	 * @param infection An infection object which holds data on infection date, number of confirmed cases and deaths.
	 */
	public void addInfection(InfectionCase infection) {
		count += infection.getNewConfCases();
		infections.add(infection);
		if (highestInfections==-1) highestInfections=0;
		if (infections.get(highestInfections).getNewConfCases()<infection.getNewConfCases()) {
			highestInfections=infections.size()-1;
		}
		this.deaths += infection.getNewDeaths();
		
		
	}
	/**
	 * Get the number of deaths caused by the virus in the country
	 * @return the number of deaths
	 */
	public int getFatalityCount() {
		return deaths;
	}

	/**
	 * Get the death rate of the country
	 * @return Returns a decimal of the ratio of deaths to infections
	 */
	public double getDeathRate() {
		if (getInfectionCount()==0)
			return 0;
		
		return (double)getFatalityCount()/(double)getInfectionCount();

	}

	/**
	 * Get the infection rate of the country
	 * @return Returns a decimal of the ratio of infections to population
	 */
	public double getInfectionRate(){
		return (double)getInfectionCount()/(double)getPopulation();
	}

	/**
	 * Get the infection cases recorded in the country
	 * @return An array of infection cases recorded in the country
	 */
	public ArrayList<InfectionCase> getInfections() {
		return infections;
	}
	/**
	 * Return the standard deviation of a set of integer values
	 * @param values a set of integer values
	 * @return The standard deviation of the set of integer values
	 */
	private double STD(int[] values) {
		int squaredsum =0;
		int sum = 0;
		for (int i : values) {
			squaredsum+= i*i;
			sum+= i;
		}
	
		return Math.sqrt(squaredsum/values.length - Math.pow(sum/values.length,2));
		
	}
	/**
	 * Return the correlation co-efficient for the last week of infections
	 * @return the correlation co-efficient
	 */
	public double getCorrelation() {
		if (this.infections.size()>0) {
			int[] val1;
			int[] val2;
			if (this.infections.size()>6) {
				val1 = new int[7];
				val2 = new int[] {7,6,5,4,3,2,1};
			}else {
				val1 = new int[this.infections.size()];
				val2 = new int[this.infections.size()];
				for (int i = 0; i < val2.length; i++) {
					val2[i] = i;
				 }
			}
			
			int c =0;
			int sum1 =0;
			for( InfectionCase i :infections.subList(0, val1.length)) {
				val1[c]=i.getNewConfCases();
				sum1+=i.getNewConfCases();
				c+=1;
			}
			
			if (sum1==0) {
				return 0;
			}
			double mean1 =this.getInfectionCount()/this.infections.size();
			double mean2 =4;
			double s1 = STD(val1);
			double s2 = STD(val2);
			
			if(s1==0)
				return 0;
			int sum =0;
			for (int i = 0; i < val1.length ; i++) {
				sum +=(val1[i]-mean1)*(val2[i]-mean2);	
			}
			return sum/((val1.length-1)*(s1*s2));
		}
		return 0;
	}
	/**
	 * Return the index of the infection case that has the highest infections in a single day
	 * @return the index of the highest infection case count
	 */
	public int getHighestInfections() {
		return highestInfections;
	}

}
