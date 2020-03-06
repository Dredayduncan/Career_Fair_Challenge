import java.util.ArrayList;
/**
 * 
 * @author Bryan Tetteh Ayertey
 *
 */
public class Country {
	String name;
	ArrayList<Integer> infections;
	int population;
	int count;
	/**
	 * Default constructor
	 */
	private Country() {
		
	}
	/**
	 * The constructor for the Country calls that takes the countries name and poplutaion.
	 * @param name The name of the country
	 * @param population The population of the country
	 */
	private Country(String name, int population) {
		this.name = name;
		this.population = population;
	
	}
	/**
	 * Get tbe number of infections that occured in the country
	 * @return the number of infections
	 */
	public int getCount() {
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
	 * Get the population the country
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
	 * @param infection The day's infection count
	 */
	public void addInfection(Integer infection) {
		infections.add(infection);
		count = count + infection;
	}
	
}
