/**
 * 
 * @author Bryan Tetteh Ayertey
 *
 */
package Career_Fair_Challenge;
import java.util.ArrayList;

public class Country {
	private String name;
	private ArrayList<InfectionCase> infections = new ArrayList<>();
	private int population;
	private int count;
	private int deaths;
	/**
	 * The constructor for the Country calls that takes the countries name and poplutaion.
	 * @param name The name of the country
	 * @param population The population of the country
	 */
	public Country(String name, int population) {
		this.name = name;
		this.population = population;
		count = 0;
		deaths=0;
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
	public int getPopulation() {
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
		return getFatalityCount()/getInfectionCount();

	}

	/**
	 * Get the infection rate of the country
	 * @return Returns a decimal of the ratio of infections to population
	 */
	public double getInfectionRate(){
		return getInfectionCount()/getPopulation();
	}

	/**
	 * Get the infection cases recorded in the country
	 * @return An array of infection cases recorded in the country
	 */
	public ArrayList<InfectionCase> getInfections() {
		return infections;
	}
}
