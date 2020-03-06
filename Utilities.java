/**
 * @author Andrew Duncan
 */
package Career_Fair_Challenge;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;

public class Utilities {
    //Store the countries by their name and Country object in a hashtable
    private Hashtable<String, Country> countries = new Hashtable<>();

    //Declare the necessary instance variables
    private String countryWithHighestDeathRate;
    private double highestDeathRate;
    private String countryWithHighestInfectionRate;
    private double highestInfectionRate;

    //Declare the variables for the input files
    Scanner populationData, infectionCases;


    /**
     * Constructor for the Utilities class which populates the Hashtable and each country with info when instantiated.
     * @param countryData Path to the csv file containing the details about countries, population, country code and year
     * @param infectionData Path to the csv file containing the details about infections each day in each country.
     * @throws FileNotFoundException
     */
    public Utilities(String countryData, String infectionData) throws FileNotFoundException {
        //Initialize instance variables
        countryWithHighestDeathRate = "";
        highestDeathRate = 0;
        countryWithHighestInfectionRate = "";
        highestInfectionRate = 0;

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

        //Loop through the entire file to populate the countries with the respective data
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
     * This method produces the country with the highest death rate.
     * @return Returns the name of the country with the highest death rate
     */
    public String CountryWithHighestDeathRate(){
        Set<String> keys = countries.keySet(); //Get all countries in the hashtable;
        for (String key: keys){
            if (countryWithHighestDeathRate.equals("")) //Check if the highest death rate country variable is empty
                countryWithHighestDeathRate = key; //Make the first country the highest for further comparison.

            //Check if the current country has a higher death rate that the set one and replace it if so.
            else if (countries.get(key).deathRate() > countries.get(countryWithHighestDeathRate).deathRate()) {
                countryWithHighestDeathRate = key; //Assign the name to be the country with the highest death rate

                //assign the value of the death rate
                highestDeathRate = countries.get(countryWithHighestDeathRate).deathRate();
            }

        }
        return countryWithHighestDeathRate;
    }

    /**
     * This method gets the highest death rate value
     * @return Returns the highest death rate as a decimal
     */
    public double getHighestDeathRate(){
        return highestDeathRate;
    }

    /**
     * This method produces the country with the highest infection rate.
     * @return Returns the name of the country with the highest infection rate
     */
    public String CountryWithHighestInfectionRate(){
        Set<String> keys = countries.keySet(); //Get all countries in the hashtable;
        for (String key: keys){
            if (countryWithHighestInfectionRate.equals("")) //Check if the highest infection rate country variable is empty
                countryWithHighestInfectionRate = key; //Make the first country the highest for further comparison.

                //Check if the current country has a higher infection rate that the set one and replace it if so.
            else if (countries.get(key).deathRate() > countries.get(countryWithHighestInfectionRate).deathRate()) {
                countryWithHighestInfectionRate = key; //Assign the name to be the country with the highest infection rate

                //assign the value of the infection rate
                highestDeathRate = countries.get(countryWithHighestInfectionRate).deathRate();
            }

        }
        return countryWithHighestInfectionRate;
    }

    /**
     * This method gets the highest infection rate value
     * @return Returns the highest infection rate as a decimal
     */
    public double getHighestInfectionRate(){
        return highestInfectionRate;
    }
}
