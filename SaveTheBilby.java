import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Class which contains main logic of the program
 *
 * @author Shih-Yi Huang
 * @version ver1.0.0
 */
public class SaveTheBilby {
    private String areaName;
    private ArrayList<Location> locations;
    private int currentMonth;
    private int beginBilbiesAmount;
    private int beginPredatorAmount;
    private IdGenerator idGenerator;

    /**
     * Default constructor which creates the object of the class SaveTheBilby.
     *
     */
    public SaveTheBilby() {
        this.areaName = "unknown";
        this.locations = new ArrayList<Location>();
        this.currentMonth = 1;
        this.beginBilbiesAmount = 0;
        this.beginPredatorAmount = 0;
        this.idGenerator = new IdGenerator();
    }

    /**
     * Non-Default constructor which creates the object of the class SaveTheBilby.
     *
     * @param areaName            Accepts the areaName as a String.
     * @param locations           Accepts location objects as an ArrayList contains
     *                            Location object arrays.
     * @param currentMonth        Accepts the current month as an integer.
     * @param beginBilbiesAmount  Accepts the amount of the bilbies at the beginning
     *                            as an integer.
     * @param beginPredatorAmount Accepts the amount of the predators at the
     *                            beginning as an integer.
     * @param idGenerator         Accepts the idGenerator object as an IdGenerator.
     */
    public SaveTheBilby(String areaName, ArrayList<Location> locations,
            int currentMonth, int beginBilbiesAmount,
            int beginPredatorAmount, IdGenerator idGenerator) {
        this.areaName = areaName;
        this.locations = locations;
        this.currentMonth = currentMonth;
        this.beginBilbiesAmount = beginBilbiesAmount;
        this.beginPredatorAmount = beginPredatorAmount;
        this.idGenerator = idGenerator;
    }

    /**
     * Method to get the amount of alive animals before the simulation
     *
     */
    public void beginPopulationCount() {
        int beginBilbiesAmount = 0;
        int beginPredatorAmount = 0;
        for (Location location : locations) {
            beginBilbiesAmount += location.countAnimalsByStatus("BILBY", true);
            beginPredatorAmount += location.countAnimalsByStatus("FOX", true);
            beginPredatorAmount += location.countAnimalsByStatus("CAT", true);
        }
        this.setBeginBilbiesAmount(beginBilbiesAmount);
        this.setBeginPredatorAmount(beginPredatorAmount);
    }

    /**
     * Method to calculate bilby population change
     *
     * @return The bilby population change as a float.
     */
    public float calculateBilbyPopulationChange() {
        int finalBilbiesCount = this.finalPopulationCount()[0];
        float populationChange = (float) (finalBilbiesCount - beginBilbiesAmount) * 100 / beginBilbiesAmount;
        return populationChange;
    }

    /**
     * Method to calculate bilby population stability
     *
     * @return The bilby population stability as a float.
     */
    public float calculateBilbyPopulationStability() {
        int totalBilbyBirth = this.finalPopulationCount()[2];
        int totalBilbyDeath = this.finalPopulationCount()[3];
        float populationStability = (float) (totalBilbyBirth + totalBilbyDeath) / beginBilbiesAmount;
        return populationStability;
    }

    /**
     * Method to calculate predator population change
     *
     * @return The predator population change as a float.
     */
    public float calculatePredatorPopulationChange() {
        int finalPredatorCount = this.finalPopulationCount()[1];
        float populationChange = (float) (finalPredatorCount - beginPredatorAmount) * 100 / beginPredatorAmount;
        return populationChange;
    }

    /**
     * Method to display current month
     *
     * @param currentMonth Accepts current month as an integer.
     */
    public void displayCuurentMonth(int currentMonth) {
        System.out.println("\n=Month" + currentMonth + "=");
    }

    /**
     * Method to execute three calculations and print the result
     *
     */
    public void executeFinalCalculator() {
        this.finalPopulationCount();
        System.out.println("\nBilby population change: "
                + this.calculateBilbyPopulationChange() + "%");
        System.out.println("Bilby population stability factor: "
                + this.calculateBilbyPopulationStability());
        System.out.println("Predator population change: "
                + this.calculatePredatorPopulationChange() + "%");
    }

    /**
     * Method to execute monthly simulation and require the action from user
     *
     */
    public void executeSimulate() {
        while (1 <= currentMonth && currentMonth <= 12) {
            for (Location location : locations)
                location.executeMonthlySimulation();
            this.requireActions();
            currentMonth++;
        }
    }

    /**
     * Method to stop the program and clean the terminal
     *
     */
    public void enterToContinue() {
        System.out.println("Please press Enter to continue...");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.print("\033\143");
    }

    /**
     * Method to count the population after the simulation
     *
     * @return The population of the specific animal and status as an integer array.
     */
    public int[] finalPopulationCount() {
        int finalBilbiesCount = 0;
        int finalPredatorCount = 0;
        int totalBilbyBirth = 0;
        int totalBilbyDeath = 0;
        for (Location location : locations) {
            finalBilbiesCount += location.countAnimalsByStatus("BILBY", true);
            finalPredatorCount += location.countAnimalsByStatus("FOX", true);
            finalPredatorCount += location.countAnimalsByStatus("CAT", true);
            totalBilbyBirth += location.countTotalNewBorn("BILBY");
            totalBilbyDeath += location.countAnimalsByStatus("BILBY", false);
        }
        int[] finalPopulation = new int[] { finalBilbiesCount, finalPredatorCount,
                totalBilbyBirth, totalBilbyDeath };
        return finalPopulation;
    }

    /**
     * Accessor method to get the area name.
     *
     * @return The area name as a String.
     */
    public String getAreaName() {
        return this.areaName;
    }

    /**
     * Accessor method to get the amount of bilbies before the simulation.
     *
     * @return The amount of bilbies as an integer.
     */
    public int getBeginBilbiesAmount() {
        return this.beginBilbiesAmount;
    }

    /**
     * Accessor method to get the amount of predators before the simulation.
     *
     * @return The amount of predators as an integer.
     */
    public int getBeginPredatorAmount() {
        return this.beginPredatorAmount;
    }

    /**
     * Accessor method to get the current month.
     *
     * @return The current month as an integer.
     */
    public int getCurrentMonth() {
        return this.currentMonth;
    }

    /**
     * Accessor method to get the generated uniqueId.
     *
     * @return The idGenerator object as an IdGenerator.
     */
    public IdGenerator getIdGenerator() {
        return this.idGenerator;
    }

    /**
     * Accessor method to get the ArrayList containing Location object arrays.
     *
     * @return The ArrayList containing Location object arrays.
     */
    public ArrayList<Location> getLocations() {
        return this.locations;
    }

    /**
     * Method to execute the intervention on the specfic location according to the
     * given locationId
     *
     * @param locationId Accepts location Id as an integer.
     */
    public void interveneOnLocation(int locationId) {
        for (Location location : locations) {
            if (location.getLocationId() == locationId)
                location.executeIntervention();
        }
    }

    /**
     * Method to generate Bilby, Fox, and Cat object
     * according to the number of bilbies, foxes, and cats in the file.
     *
     */
    public void loadAnimals()
            throws FileNotFoundException, IOException {
        FileIO fileIO = new FileIO();
        ArrayList<int[]> populationInfo = fileIO.readFile();
        for (int line = 0; line < 10; line++) {
            Location location = new Location((line + 1), false, idGenerator);
            int numberOfBilbies = populationInfo.get(line)[0];
            int numberOfFoxes = populationInfo.get(line)[1];
            int numberOfCats = populationInfo.get(line)[2];
            location.createBilby(false, numberOfBilbies);
            location.createFox(false, numberOfFoxes);
            location.createCat(false, numberOfCats);
            locations.add(location);
        }
    }

    /**
     * Method to being the program.
     *
     * @param args An array of Strings representing command line arguments.
     */
    public static void main(String[] args)
            throws FileNotFoundException, IOException {
        SaveTheBilby saveTheBilby = new SaveTheBilby();
        Display display = new Display();
        display.displayIntro();
        saveTheBilby.enterToContinue();
        saveTheBilby.requireAreaName();
        saveTheBilby.loadAnimals();
        saveTheBilby.beginPopulationCount();
        saveTheBilby.executeSimulate();
        saveTheBilby.yearlyDisplay();
    }

    /**
     * Method to require user actions to conduct relocation,
     * intervention or the next simulation.
     *
     */
    public void requireActions() {
        Scanner scanner = new Scanner(System.in);
        Validation validation = new Validation();
        Display display = new Display();
        String inputOption = "";
        while (!inputOption.equals("3")) {
            do {
                this.displayCuurentMonth(currentMonth);
                display.monthlyDisplay(locations);
                display.displayActionOptions();
                System.out.println("Please enter your option: ");
                inputOption = scanner.nextLine().trim();
            } while (!validation.isValidOption(inputOption));
            if (inputOption.equals("1")) {
                System.out.print("\033\143");
                this.requireRelocation();
            } else if (inputOption.equals("2")) {
                System.out.print("\033\143");
                this.requireIntervention();
            } else
                System.out.println("\nGoing to run monthly simulation");
            this.enterToContinue();
        }
    }

    /**
     * Method to require user to name the area
     *
     */
    public void requireAreaName() {
        Validation validation = new Validation();
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Please name the area: ");
            areaName = scanner.nextLine();
        } while (!validation.isValidAreaName(areaName));
        this.setAreaName(areaName);
    }

    /**
     * Method to require user's action to conduct the intervention
     *
     */
    public void requireIntervention() {
        Display display = new Display();
        int locationId = 0;
        String inputLocationId = "";
        boolean goBack = false;
        ArrayList<String> availableLocationList = display.availableInterveneLocation(locations);
        Validation validation = new Validation();
        Scanner scanner = new Scanner(System.in);
        while (!goBack && !availableLocationList.contains(inputLocationId)) {
            do {
                display.displayAvailableInterveneLocation(locations, availableLocationList);
                System.out.println("\nPlease enter your option: ");
                inputLocationId = scanner.nextLine().trim();
            } while (!validation.isValidLocationId(inputLocationId));
            if (inputLocationId.equalsIgnoreCase("B"))
                goBack = true;
            else if (availableLocationList.contains(inputLocationId))
                locationId = Integer.parseInt(inputLocationId);
            else
                System.out.println("\nThe location is not available");
        }
        if (goBack) {
            System.out.println("\nBack to Action Menu...");
            System.out.print("\033\143");
        } else {
            this.interveneOnLocation(locationId);
            System.out.println("\nYou can't conduct an intervention in location "
                    + locationId + " within 12 months anymore");
        }
    }

    /**
     * Method to relocate in the given bilbies to the given location
     * 
     * @param locationIdRelocateTo Accepts the locationId to move to as an integer.
     * @param bilbiesOut           Accepts the specific bilbies
     *                             as an ArrayList containing Bilby object arrays.
     */
    public void relocateOnLocation(int locationIdRelocateTo, ArrayList<Bilby> bilbiesOut) {
        for (Location location : locations) {
            if (location.getLocationId() == locationIdRelocateTo)
                location.relocateBilbyIn(bilbiesOut);
        }
    }

    /**
     * Method to require user's action to conduct the relocation.
     * 
     */
    public void requireRelocation() {
        Validation validation = new Validation();
        Display display = new Display();
        String inputRelocateFrom = "";
        String inputRelocateTo = "";
        String inputRelocateAmount = "";
        ArrayList<String> availableMoveOutList = display.availableRelocateOutLocation(locations);
        ArrayList<String> availableMoveInList = display.availableRelocateInLocation(locations);
        int locationIdRelocateFrom = 0;
        int locationIdRelocateTo = 0;
        int relocateAmount = 0;
        int aliveBilbiesAmount = 0;
        boolean goBack = false;
        Scanner scanner = new Scanner(System.in);
        while (!goBack && !availableMoveOutList.contains(inputRelocateFrom)) {
            do {
                display.displayAvailableRelocateOutLocation(locations, availableMoveOutList);
                System.out.println("\nPlease enter your option: ");
                inputRelocateFrom = scanner.nextLine().trim();
            } while (!validation.isValidLocationId(inputRelocateFrom));
            if (inputRelocateFrom.equalsIgnoreCase("B"))
                goBack = true;
            else if (availableMoveOutList.contains(inputRelocateFrom))
                locationIdRelocateFrom = Integer.parseInt(inputRelocateFrom);
            else if (!availableMoveOutList.contains(inputRelocateFrom)) {
                System.out.print("\033\143");
                System.out.println("\nThe location " + inputRelocateFrom + " is not available\n");
            }
        }
        while (!goBack && !availableMoveInList.contains(inputRelocateTo)) {
            do {
                display.displayAvailableRelocateInLocation(locations);
                System.out.println("\nPlease enter your option: ");
                inputRelocateTo = scanner.nextLine().trim();
            } while (!validation.isValidLocationId(inputRelocateTo));
            if (inputRelocateTo.equalsIgnoreCase("B"))
                goBack = true;
            else if (availableMoveInList.contains(inputRelocateTo))
                locationIdRelocateTo = Integer.parseInt(inputRelocateTo);
            else if (!availableMoveInList.contains(inputRelocateTo))
                System.out.println("\nThe location is not available\n");
        }
        if (goBack) {
            System.out.println("\nBack to Action Menu...");
            System.out.print("\033\143");
        } else {
            ArrayList<Bilby> bilbiesOutList = new ArrayList<Bilby>();
            for (Location location : locations) {
                if (location.getLocationId() == locationIdRelocateFrom) {
                    aliveBilbiesAmount = location.countAnimalsByStatus("BILBY", true);
                    boolean flag = false;
                    while (!flag) {
                        System.out.println("How many bilbies you want to move: ");
                        inputRelocateAmount = scanner.nextLine().trim();
                        if (validation.isNumeric(inputRelocateAmount)) {
                            relocateAmount = Integer.parseInt(inputRelocateAmount);
                            if (relocateAmount <= aliveBilbiesAmount)
                                flag = true;
                            else
                                System.out.println("\nYou can't move more than "
                                        + aliveBilbiesAmount + " bilbies");
                        }
                    }
                    bilbiesOutList = location.relocateBilbyOut(relocateAmount);
                }
            }
            this.relocateOnLocation(locationIdRelocateTo, bilbiesOutList);
            System.out.println("\nYou just moved " + relocateAmount + " bilbies from "
                    + locationIdRelocateFrom + " to " + locationIdRelocateTo);
        }
    }

    /**
     * Mutator method to set the area name.
     *
     * @param areaName The area name as a String.
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    /**
     * Mutator method to set the amount of bilbies before the simulation.
     *
     * @param beginBilbiesAmount The amount of bilbies as an integer.
     */
    public void setBeginBilbiesAmount(int beginBilbiesAmount) {
        this.beginBilbiesAmount = beginBilbiesAmount;
    }

    /**
     * Mutator method to set the amount of predators before the simulation.
     *
     * @param beginPredatorAmount The amount of predators as an integer.
     */
    public void setBeginPredatorAmount(int beginPredatorAmount) {
        this.beginPredatorAmount = beginPredatorAmount;
    }

    /**
     * Mutator method to set current month.
     *
     * @param currentMonth The current month as an integer.
     */
    public void setCurrentMonth(int currentMonth) {
        this.currentMonth = currentMonth;
    }

    /**
     * Mutator method to set the idGenerator object.
     *
     * @param idGenerator The idGenerator object as an IdGenerator.
     */
    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    /**
     * Mutator method to set locations.
     *
     * @param locations The ArrayList containing Location object arrays.
     */
    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }

    /**
     * Method to count the required info and write them to the file.
     * 
     */
    public void writeResultToFile()
    // throws FileNotFoundException, IOException
    {
        FileIO fileIO = new FileIO();
        int aliveBilbies = 0;
        int deadBilbies = 0;
        int aliveFoxes = 0;
        int deadFoxes = 0;
        int aliveCats = 0;
        int deadCats = 0;
        ArrayList<int[]> results = new ArrayList<int[]>();
        for (Location location : locations) {
            aliveBilbies = location.countAnimalsByStatus("BILBY", true);
            deadBilbies = location.countAnimalsByStatus("BILBY", false);
            aliveFoxes = location.countAnimalsByStatus("FOX", true);
            deadFoxes = location.countAnimalsByStatus("FOX", false);
            aliveCats = location.countAnimalsByStatus("CAT", true);
            deadCats = location.countAnimalsByStatus("CAT", false);
            int[] result = new int[] { aliveBilbies, deadBilbies, aliveFoxes, deadFoxes, aliveCats, deadCats };
            results.add(result);
        }
        fileIO.writeFile(results);
        System.out.println("\nConducted saving data into populationFinal.txt");
        System.out.println("Thanks for joining the bilby survival simulation!");
    }

    /**
     * Method to display the required info at the end of the simulation.
     * 
     */
    public void yearlyDisplay()
    // throws FileNotFoundException, IOException
    {
        System.out.println("======== END OF THE SIMULATION ========");
        System.out.println("Area Name : " + areaName);
        for (Location location : locations) {
            location.displayStatisticsPopulation();
        }
        this.executeFinalCalculator();
        this.writeResultToFile();
    }
}