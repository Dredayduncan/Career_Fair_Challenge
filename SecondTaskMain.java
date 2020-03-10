/**
 * @author Andrew Duncan
 */
package Career_Fair_Challenge;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class SecondTaskMain {
    public static void main(String[] args) throws FileNotFoundException {
        //instantiate the SecondTask class
        SecondTask task2 = new SecondTask(args[0], args[1]);

        //Write the result to the file.
        PrintWriter input = new PrintWriter(new File("task2_solution-"+args[1]+".txt"));
        input.println(task2.identifyCountry()[0]);
        input.println(task2.identifyCountry()[1]);
        input.close();
    }
}
