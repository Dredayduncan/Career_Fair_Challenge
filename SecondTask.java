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
    Utilities data; //Declare a Utilities variable to generate the data from the respective files
    private ArrayList<Integer> missingData;
    private Country found; //Declare the variable for the country which the missing data belongs
    private String startDate; //Declare the variable for the starting date of the data

    /**
     *
     * @param covidData The file containing information infections cases in countries on different dates
     * @param partialTimeSeries The file that has the anonymous data
     * @throws FileNotFoundException Throw an error when the file cannot be found.
     */
    public SecondTask(String covidData, String partialTimeSeries) throws FileNotFoundException {
        missingData = new ArrayList<>();
        found = null;
        startDate = "";

        //instantiate the utilities class to generate the data
        data = new Utilities("population_data.csv", covidData);

        //Store the data from the partialTimeSeries file into an Integer array
        Scanner input = new Scanner(new File(partialTimeSeries));
        while (input.hasNextLine()){
            Integer value = Integer.parseInt(input.nextLine());
            missingData.add(value);
        }
    }

    public Country traceCountryOfData(){
        for (Country country: data.getCountries().values()){
            if (Arrays.asList(country.getInfections()).containsAll(Arrays.asList(missingData))){
                found = country;
            }
        }
        return found;
    }

//    public String getStartDate(){
//        for (InfectionCase info : found.getInfections())
//            info.newConfCases
//    }
}
