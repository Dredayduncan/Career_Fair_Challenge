/**
 * @author Andrew Duncan
 */
package Career_Fair_Challenge;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Scanner;

public class Utilities {
    //Store the countries by their name and Country object in a hashtable
    private Hashtable<String, Country> countries = new Hashtable<>();

    //Declare the variables for the input files
    Scanner populationData, infectionCases;


    /**
     *
     * @param countryData Path to the csv file containing the details about countries, population, country code and year
     * @param infectionData Path to the csv file containing the details about infections each day in each country.
     * @throws FileNotFoundException
     */
    public Utilities(String countryData, String infectionData) throws FileNotFoundException {
        //Read the files
        populationData = new Scanner(new File(countryData));
        infectionCases = new Scanner(new File(infectionData));

        //Ignore the headers in each csv file
        populationData.nextLine();
        infectionCases.nextLine();

        //Loop through the entire file to populate the hashtable with the respective information
        while (populationData.hasNextLine()) {
            String data = populationData.nextLine();
            String[] row = data.split(","); //Split each row using the commas
            Country country = new Country(row[0], Integer.parseInt(row[2]));
            countries.put(country.getName(), country);
        }


        while (infectionCases.hasNextLine()){
            String data = infectionCases.nextLine();
            String[] row = data.split(","); //Split each row using the commas

            // Create an Infection case object of date of capture, number of confirmed cases, and number of deaths.
            InfectionCase theCase = new InfectionCase(row[0], Integer.parseInt(row[2]), Integer.parseInt(row[3]));
            
            //add each infection case to the country they belong to.
            countries.get(row[1]).addInfection(theCase);
        }

    }
    /**
     * Get the country with the highest infection count
     * @return The country with the highest infection count
     */
    public Country getHighestInfection() {
    	Country highest=null;
    	for (Country country : countries.values()) {
			if (highest==null) {
				highest=country;
			}else {
				if (highest.getInfectionCount() < country.getInfectionCount()){
					highest = country;
				}
			}
		}
    	return highest;
    }
    /**
     * Get the country with the second highest infection count
     * @return The country with the second highest infection count
     */
    public Country getSecondHighestInfection() {
    	Country Highest = null;
    	Country sHighest = null;
    	for (Country country : countries.values()) {
			if (Highest == null) {
				Highest = country;
			}else {
				if (Highest.getInfectionCount() < country.getInfectionCount()){
					sHighest = Highest;
					Highest = country;
				}
			}
		}
    	return sHighest;
    }
}

