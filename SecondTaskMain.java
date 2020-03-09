/**
 * @author Andrew Duncan
 */
package Career_Fair_Challenge;

import java.io.FileNotFoundException;

public class SecondTaskMain {
    public static void main(String[] args) throws FileNotFoundException {
        //instantiate the SecondTask class
        SecondTask task2 = new SecondTask(args[0], args[1]);
        System.out.println(task2.identifyCountry());
    }
}
