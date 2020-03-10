/**
 * @author Andrew Duncan
 */
package Career_Fair_Challenge;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Answers {
    public static void main(String[] args) throws FileNotFoundException {
        Utilities soln = new Utilities(args[0], args[1]);

        //Create the file which contains all the answers
        PrintWriter input = new PrintWriter(new File("task1_solution-"+args[0]+".txt"));

        //Get and write the country with the highest infection count and the count to the file.
        Country highestInfectionCount = soln.getHighestInfection();
        input.println("a) " + highestInfectionCount.getName() + ", " + highestInfectionCount.getInfectionCount());

        //Get and write the country with the second highest infection count and the count to the file.
        Country secondHighest = soln.getSecondHighestInfection();
        input.println("b) " + secondHighest.getName() + ", " + secondHighest.getInfectionCount());

        //Get and write the country with the highest infection rate and the rate to the file
        Country highestInfectionRate = soln.getCountryWithHighestInfectionRate();
        input.println("c) " + highestInfectionRate.getName() + ", " + highestInfectionRate.getInfectionRate());

        //Get and write the overall death rate for the COVID-19 file to the file
        input.println("d) " + soln.getOverallDeathRate());

        //Get and write the country with the highest infection rate and the rate to the file
        Country highestDeathRate = soln.getCountryWithHighestDeathRate();
        input.println("e) " + highestDeathRate.getName() + ", " + highestDeathRate.getDeathRate());

        //Get and write which countries have a rising trend of infection to a file
        input.println("f) The countries with a rising trend of infections are:");
        for (Country country: soln.getOnTheRise()) {
			input.println("--"+country.getName());
		}
        //Get and write the country with the steepest increase to a file
        Country steeph =soln.getSteepestRise();
        input.println("g) "+steeph.getName());
        
        //Get and write which countries have a falling trend of infection to a file
        input.println("h) The countries with a falling trend of infections are:");
        for (Country country: soln.getOnTheFall()) {
			input.println("--"+country.getName());
		}
        //Get and write the country with the steepest decrease to a file
        Country steepf =soln.getSteepestFall();
        input.println("i) "+steepf.getName());
        
        //Get and write the country with the earliest peak infections in a day to a file
        Country peak =soln.getEarliestPeak();
        input.println("j) "+peak.getName()+", "+peak.getInfections().get(peak.getHighestInfections()).getNewConfCases());
        input.close();
    }
}
