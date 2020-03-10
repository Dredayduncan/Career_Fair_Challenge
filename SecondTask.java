/**
 *
 * @author Andrew Duncan
 */
package Career_Fair_Challenge;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SecondTask {
    private Utilities data; //Declare a Utilities variable to generate the data from the respective files
    private ArrayList<Integer> missingData;
    private Country found; //Declare the variable for the country which the missing data belongs


    /**
     * A constructor t
     * @param covidData The file containing information infections cases in countries on different dates
     * @param partialTimeSeries The file that has the anonymous data
     * @throws FileNotFoundException Throw an error when the file cannot be found.
     */
    public SecondTask(String covidData, String partialTimeSeries) throws FileNotFoundException {
        missingData = new ArrayList<>();
        found = null;

        //instantiate the utilities class to generate the data
        data = new Utilities(covidData, "population_data.csv");

        //Store the data from the partialTimeSeries file into an Integer array
        Scanner input = new Scanner(new File(partialTimeSeries));
        input.nextLine();

        while (input.hasNextLine()){
            String value = input.nextLine();
            missingData.add(Integer.parseInt(value));
        }
    }

    /**
     * A method to get the country which the information held in the partTimeSeries file.
     * @return The country which been identified to bear the data in the partTimeSeries file as a Country object.
     */
    private void traceCountryOfData(){
        for (Country country: data.getCountries().values()){

            if (country.getAllConfCases().containsAll(missingData)){
                found = country;
                break;
            }
        };
    }

    /**
     * A method to get the country which has the data in the partTimeSeries, and the date of the first occurence of the
     * missing data.
     * @return A string
     */
    public String[] identifyCountry(){
        //Get the last index which is the first occurrence of the in the partTimeSeries file.
        int indexOfStartDate = missingData.size()-1;
        traceCountryOfData(); //Get the country the data belongs to.

        String missedConfCases = setMissingCases(); //Combine all the values of the partTimeSeries file into one string
        String identifiedConfCases = setFoundCases(); //Combine all the values of the confirmed cases in the identified country into one string.

        //Get the index of the missing data in the identified country's string
        indexOfStartDate += identifiedConfCases.indexOf(missedConfCases);

        //Get the country and date of the first occurrence in the partTimeSeries file
        String[] result = new String[2];
        result[0] = found.getName();
        result[1] = found.getInfections().get(indexOfStartDate).getDateRep();
        return result;
    }

    /**
     * This method accumulates the number of confirmed cases in the partTimeSeriesFile into one string.
     * @return A String of the the values of confirmed cases in the partTimeSeries file as one.
     */
    private String setMissingCases(){
        String missingCases = "";//Variable to hold the number of cases each day in the partialTimeSeries file as one string

        //Add the number values to the string as one.
        for (Integer confCase: missingData)
            missingCases += confCase.toString();

        return missingCases;
    }

    /**
     * This method accumulates the number of confirmed cases in the identified country into one string.
     * @return A String
     */
    private String setFoundCases(){
        String foundCases = ""; //Variable to hold the number of cases reported in the identified country as one string.

        //Add the number values to the string as one.
        for (Integer theCase: found.getAllConfCases()){
            foundCases += String.valueOf(theCase);
        }

        return foundCases;
    }
}
