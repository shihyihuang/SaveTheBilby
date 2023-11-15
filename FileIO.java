import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class for doing input and output of the file
 *
 * @author Shih-Yi Huang
 * @version ver1.0.0
 */
public class FileIO {
    public static final String Read_File_Path = "population.txt";

    /**
     * Default constructor which creates the object of the class FileIO.
     *
     */
    public FileIO() {

    }

    /**
     * Method to read the file from the given path.
     *
     * @return The population of bilby, fox and cat in 10 locations
     *         as an ArrayList contains integer arrays.
     */
    public static ArrayList<int[]> readFile()
            throws FileNotFoundException, IOException {
        Validation validation = new Validation();
        ArrayList<int[]> locations = new ArrayList<int[]>();
        try {
            FileReader fileReader = new FileReader(Read_File_Path);
            try {
                Scanner readScanner = new Scanner(fileReader);
                int counter = 0;
                while (readScanner.hasNextLine()) {
                    counter++;
                    String[] lineContents = readScanner.nextLine().split(",");
                    if (lineContents.length == 3) {
                        int[] location = new int[3];
                        int numberOfBilbies = 0;
                        int numberOfFoxes = 0;
                        int numberOfCats = 0;
                        try {
                            location[0] = Integer.parseInt(lineContents[0]);
                            location[1] = Integer.parseInt(lineContents[1]);
                            location[2] = Integer.parseInt(lineContents[2]);
                        } catch (Exception e) {
                            System.out.println("Error in line " + counter + " of the input file");
                            continue;
                        }
                        locations.add(location);
                    } else
                        System.out.println("Error while loading number of live Bilbies");
                }
                readScanner.close();
            } finally {
                try {
                    fileReader.close();
                } catch (Exception e) {
                    System.out.println("Error in reading from file");
                }
            }
        } catch (Exception e) {
            System.out.println("Error in writing to file");
        }
        return locations;
    }

    /**
     * Method to write the result to the file.
     *
     * @param results Accepts the result as an ArrayList contains integer arrays.
     */
    public void writeFile(ArrayList<int[]> results)
    // throws FileNotFoundException, IOException
    {
        try {
            FileWriter fileWriter = new FileWriter("populationFinal.txt");
            try {
                for (int[] result : results) {
                    String resultOfLocation = "";
                    for (int position = 0; position < result.length; position++) {
                        resultOfLocation += result[position];
                        if (position < result.length - 1)
                            resultOfLocation += ",";
                    }
                    fileWriter.write(resultOfLocation + "\n");
                }
            } finally {
                try {
                    fileWriter.close();
                } catch (Exception e) {
                    System.out.println("Error in closing file! Exiting...");
                }
            }
        } catch (Exception e) {
            System.out.println("Error in writing to file! Exiting...");
        }
    }
}
