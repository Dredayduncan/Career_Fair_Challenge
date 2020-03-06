/**
 * 
 * @author Bryan Tetteh Ayertey
 *
 */
package Career_Fair_Challenge;
import java.util.ArrayList;

public class Country {
	String name;
	ArrayList<InfectionCase> infections;
	int population;
	int count;
	int deaths;
	/**
	 * The constructor for the Country calls that takes the countries name and poplutaion.
	 * @param name The name of the country
	 * @param population The population of the country
	 */
	public Country(String name, int population) {
		this.name = name;
		this.population = population;
		count = 0;
		infections = new ArrayList<>();
		deaths=0;
	}

	/**
	 * Get tbe number of infections that occured in the country
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

}
