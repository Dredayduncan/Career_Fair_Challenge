/**
 *
 * @author Bryan Tetteh Ayertey
 *
 */
package Career_Fair_Challenge;

public class InfectionCase {
	String dateRep;
	int newConfCases;
	int newDeaths;
	/**
	 * The constructor for the InfectionCase class with the date, the number of infections and number of deaths
	 * @param dateRep The date of the case 
	 * @param newConfCases The number of infection cases at that date
	 * @param newDeaths The number of deaths at that date
	 */
	public InfectionCase(String dateRep, int newConfCases, int newDeaths) {
		this.dateRep = dateRep;
		this.newConfCases = newConfCases;
		this.newDeaths = newDeaths;
	}

	/**
	 * Get the date of the infection case
	 * @return The date of the infection case 
	 */
	public String getDateRep() {
		return dateRep;
	}
	
	/**
	 * Set the date of the infection case
	 * @param dateRep The date to be set for the infection case
	 */
	public void setDateRep(String dateRep) {
		this.dateRep = dateRep;
	}

	/**
	 * Get the number of infection cases at the given date
	 * @return the number of infection cases
	 */
	public int getNewConfCases() {
		return newConfCases;
	}

	/**
	 * Set the number of infection cases at the given date
	 * @param newConfCases The number of cases to be set for the infection case
	 */
	public void setNewConfCases(int newConfCases) {
		this.newConfCases = newConfCases;
	}

	/**
	 * Get the number of death from the virus cases at the given date
	 * @return The number of death from the virus
	 */
	public int getNewDeaths() {
		return newDeaths;
	}

	/**
	 * Set the number of death from the virus cases at the given date
	 * @param newDeaths The number of deaths to be set for the infection case
	 */
	public void setNewDeaths(int newDeaths) {
		this.newDeaths = newDeaths;
	}
	
	
}
