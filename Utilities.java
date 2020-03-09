/**
 * @author Andrew Duncan
 */
package Career_Fair_Challenge;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class Utilities {
    // Create and store the countries information by their name to Country object in a hashtable
    private Hashtable<String, Country> countries = new Hashtable<>();
    private int count;
    private int deaths;

    //Declare the variables for the input files
    Scanner populationData, infectionCases;


    /**
     *
     * @param countryData Path to the csv file containing the details about countries, population, country code and year
     * @param infectionData Path to the csv file containing the details about infections each day in each country.
     * @throws FileNotFoundException Produce an error when the file indicated has not been found
     */
    public Utilities(String countryData, String infectionData) throws FileNotFoundException {
        try {

            //Read the files
            infectionCases = new Scanner(new File(infectionData));
            populationData = new Scanner(new File(countryData));

        }catch (Exception e){
            System.out.println("Error: " + e);
        }

        //Ignore the headers in each csv file
        populationData.nextLine();
        infectionCases.nextLine();

        //Loop through the entire file to populate the hashtable with the respective information
        while (populationData.hasNextLine()) {
            String data = populationData.nextLine();
            String[] row = data.split(","); //Split each row using the commas
            
            Country country = new Country(row[0], Long.parseLong(row[2]));
            countries.put(country.getName(), country);
        }


        while (infectionCases.hasNextLine()){
            String data = infectionCases.nextLine();
            String[] row = data.split(","); //Split each row using the commas

            // Create an Infection case object of date of capture, number of confirmed cases, and number of deaths.
            InfectionCase theCase = new InfectionCase(row[0], Integer.parseInt(row[2]), Integer.parseInt(row[3]));

            //Accumulate the number of deaths and infections to their respective instance variables
            count += Integer.parseInt(row[2]);
            deaths += Integer.parseInt(row[3]);
            
            //add each infection case to the country they belong to.
            if (countries.get(row[1])!=null) 
            	countries.get(row[1]).addInfection(theCase);
            }

    }
    /**
     *
     * Get the country with the highest infection count
     * @return The country with the highest infection count
     */
    public Country getHighestInfection() {
        // The variable to keep the country with the highest infection cases
        Country highest = null;
        for (Country country : countries.values()) {
            // The first country will be considered the highest from the start
            if (highest == null) {
                highest = country;

    // Compare the current country and current highest country and replace the highest if the current country has a higher infection count
            } else if (highest.getInfectionCount() < country.getInfectionCount()) {
                highest = country;
            }
        }
        return highest;
    }

    /**
     *
     * Get the country with the second highest infection count
     * @return The country with the second highest infection count
     */
    public Country getSecondHighestInfection () {
        // The variable to keep the country with the highest and second highest infection cases
        Country Highest = null;
        Country sHighest = null;
        for (Country country : countries.values()) {
            // The first country will be considered the highest from the start
        	
            if (Highest == null) {
                Highest = country;

                /* Compare the current country and current highest country and replace the highest if
				   the current country has a higher infection count and store the old highest
				*/
            } else if (country.getInfectionCount()>Highest.getInfectionCount()) {
                sHighest = Highest;
                Highest = country;
            }// The first country smaller than the highest will be considered the second highest
            else if(sHighest==null) {
            	sHighest=country;
            }/* Compare the cunCompare the current country and current highest country and replace the highest if
			   the current country has a higher infection count*/
            else if(country.getInfectionCount()>sHighest.getInfectionCount()) {
            	sHighest = country;
            }
        }
        return sHighest;
    }

    /**
     *
     * This method produces the country with the highest death rate.
     * @return Returns a country object of the country with the highest death rate
     */
    public Country getCountryWithHighestDeathRate(){
        Country countryWithHighestDeathRate = null;

        for (Country country: countries.values()){
            if (countryWithHighestDeathRate == null) //Check if the highest death rate country variable is empty
                countryWithHighestDeathRate = country; //Make the first country the highest for further comparison.

            //Check if the current country has a higher death rate that the set one and replace it if so.
            else if (country.getDeathRate() > countryWithHighestDeathRate.getDeathRate()) {
                countryWithHighestDeathRate = country; //Assign the name to be the country with the highest death rate
                
            }
        }
        return countryWithHighestDeathRate;

    }

    /**
     *
     * This method produces the country with the highest infection rate.
     * @return Returns a country object of the country with the highest infection rate
     */
    public Country getCountryWithHighestInfectionRate(){
        Country countryWithHighestInfectionRate = null;
        for (Country country: countries.values()){
            if (countryWithHighestInfectionRate == null) //Check if the highest infection rate country variable is empty
                countryWithHighestInfectionRate = country; //Make the first country the highest for further comparison.

                //Check if the current country has a higher infection rate that the set one and replace it if so.
            else if (country.getInfectionRate() > countryWithHighestInfectionRate.getInfectionCount()) {
                countryWithHighestInfectionRate = country; //Assign the name to be the country with the highest infection rate
            }

        }
        return countryWithHighestInfectionRate;
    }

    /**
     * Get the overall death rate in the covid_data file
     * @return A double (decimal) of the result
     */
    public double getOverallDeathRate(){
    	
        return (double)deaths/(double)count;
    }

    /**
     * Return the Hashtable keeping all the data of the population_data file and the covid_data file
     * @return A hashtable of the information on each country
     */
    public Hashtable<String, Country> getCountries(){
        return countries;
    }
    /**
     * Return all countries that have increasing infections trends
     * @return ArrayList of all countries with increasing infection trends
     */
    public ArrayList<Country> getOnTheRise(){
    	ArrayList<Country> coun = new ArrayList<Country>();
    	for (Country country : countries.values()) {
			if(country.getCorrelation()>0) {
				coun.add(country);
			}
		}
    	return coun;
    }
    /**
     * Return all countries that have decreasing infections trends
     * @return ArrayList of all countries with decreasing infection trends
     */
    public ArrayList<Country> getOnTheFall(){
    	ArrayList<Country> coun = new ArrayList<Country>();
    	for (Country country : countries.values()) {
			if(country.getCorrelation()<0) {
				coun.add(country);
			}
		}
    	return coun;
    }
    /**
     * Return the country with the steepest increase
     * @return the country with the steepest increase
     */
    public Country getSteepestRise() {
    	Country c = null;
    	
    	for (Country coun : this.getOnTheRise()) {
			if (c==null) {
				c = coun;
			}
			if (c.getCorrelation()<coun.getCorrelation()) {
				c =coun;
			}
		}
    	return c;
    }
    /**
     * Return the country with the steepest decrease
     * @return the country with the steepest decrease
     */
    public Country getSteepestFall() {
    	Country c = null;
    	for (Country coun : this.getOnTheFall
    			()) {
			if (c==null) {
				c = coun;
			}
			if (c.getCorrelation()>coun.getCorrelation()) {
				c =coun;
			}
		}
    	return c;
    }
    /**
     * Return the country that has the earliest peak of all the countries that have decreasing infections
     * @return The country with the earliest peak
     */
    public Country getEarliestPeak() {
    	Country coun = null;
    	for (Country c : this.getOnTheFall()) {
    		if (c.getHighestInfections()!=-1) {
				if (coun == null) {
					coun =c;
				}
				else {
					if (c.getHighestInfections()>coun.getHighestInfections())
						coun=c;
				}
	    	}
		}
    	return coun;
    }
}

