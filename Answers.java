/**
 * @author Andrew Duncan
 */
package Career_Fair_Challenge;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Answers {
    public static void main(String[] args) throws FileNotFoundException {
        Utilities soln = new Utilities(args[1], args[0]);

        //Create the file which contains all the answers
        PrintWriter input = new PrintWriter(new File("task1_solution-" + args[0] + ".txt"));

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







    }
}
