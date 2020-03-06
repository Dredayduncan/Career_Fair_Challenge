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
        populationData = new Scanner(new File(countryData));
        infectionCases = new Scanner(new File(infectionData));


    }
}
