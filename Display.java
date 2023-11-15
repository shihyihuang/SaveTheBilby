import java.util.ArrayList;

/**
 * Class which contains methods of displaying
 *
 * @author Shih-Yi Huang
 * @version ver1.0.0
 */
public class Display {
    /**
     * Default constructor which creates the object of the class Display.
     *
     */
    public Display() {

    }

    /**
     * Method to get a list of locationId which haven't been intervened.
     *
     * @param locations Accepts location objects as an ArrayList contains Location
     *                  objects.
     * @return A list of locationId which haven't been intervened as an ArrayList of
     *         String.
     */
    public ArrayList<String> availableInterveneLocation(ArrayList<Location> locations) {
        ArrayList<String> availableLocationList = new ArrayList<String>();
        for (Location location : locations) {
            boolean haveIntervened = location.getHaveIntervened();
            if (!haveIntervened)
                availableLocationList.add(Integer.toString(location.getLocationId()));
        }
        return availableLocationList;
    }

    /**
     * Method to get a list of locationId in which the bilbies are able to be
     * relocated in.
     *
     * @param locations Accepts location objects as an ArrayList contains Location
     *                  object.
     * @return A list of locationId which can be relocated in as an ArrayList of
     *         String.
     */
    public ArrayList<String> availableRelocateInLocation(ArrayList<Location> locations) {
        ArrayList<String> availableLocationList = new ArrayList<String>();
        for (Location location : locations) {
            availableLocationList.add(Integer.toString(location.getLocationId()));
        }
        return availableLocationList;
    }

    /**
     * Method to get a list of locationId in which the bilbies are able to be
     * relocated out.
     *
     * @param locations Accepts location objects as an ArrayList contains Location
     *                  object.
     * @return A list of locationId which can be relocated in as an ArrayList of
     *         String.
     */
    public ArrayList<String> availableRelocateOutLocation(ArrayList<Location> locations) {
        ArrayList<String> availableLocationList = new ArrayList<String>();
        for (Location location : locations) {
            int aliveBilbiesCount = location.countAnimalsByStatus("BILBY", true);
            if (aliveBilbiesCount > 20)
                availableLocationList.add(Integer.toString(location.getLocationId()));
        }
        return availableLocationList;
    }

    /**
     * Method to display all available locations to conduct the intervention
     *
     * @param locations             Accepts location objects as an ArrayList
     *                              contains Location objects.
     * @param availableLocationList A list of locationId which haven't been
     *                              intervened
     *                              as an ArrayList of String.
     */
    public void displayAvailableInterveneLocation(ArrayList<Location> locations,
            ArrayList<String> availableLocationList) {
        boolean flag = false;
        while (!flag) {
            if (availableLocationList.size() == 0) {
                System.out.println("There's no location available");
                flag = true;
            } else {
                for (String locationIdString : availableLocationList) {
                    for (Location location : locations) {
                        int locationIdInt = Integer.parseInt(locationIdString);
                        if (location.getLocationId() == locationIdInt) {
                            int aliveFoxes = location.countAnimalsByStatus("FOX", true);
                            int aliveCats = location.countAnimalsByStatus("CAT", true);
                            System.out.println("- Location" + locationIdInt + " - " +
                                    aliveFoxes + " foxes, " + aliveCats + " cats");
                            flag = true;
                        }
                    }
                }
                System.out.println("\nPlease choose a location to conduct the intervention");
            }
        }
        System.out.println("< Press B back to Action Menu >");
    }

    /**
     * Method to display all available locations to be relocated in
     *
     * @param locations Accepts location objects as an ArrayList contains Location
     *                  objects.
     */
    public void displayAvailableRelocateInLocation(ArrayList<Location> locations) {
        System.out.println("\n= RELOCATE IN =");
        for (Location location : locations) {
            int aliveBilbies = location.countAnimalsByStatus("BILBY", true);
            System.out.println("Location" + location.getLocationId() + " - "
                    + aliveBilbies + " bilbies");
        }
        System.out.println("\nPlease choose a location to move IN the bilbies");
        System.out.println("< Press B back to Action Menu >");
    }

    /**
     * Method to display all available locations to be relocated out
     *
     * @param locations             Accepts location objects as an ArrayList
     *                              contains Location objects.
     * @param availableLocationList A list of locationId in which bilbies are able
     *                              to be relocated out
     *                              as an ArrayList of String.
     */
    public void displayAvailableRelocateOutLocation(ArrayList<Location> locations,
            ArrayList<String> availableLocationList) {
        boolean flag = false;
        while (!flag) {
            if (availableLocationList.size() == 0) {
                System.out.println("There's no location available");
                flag = true;
            } else {
                System.out.println("= RELOCATE OUT =");
                System.out.println("You can choose any number of bilbies you want"
                        + " but only from the following locations to relocate out");
                for (String locationIdString : availableLocationList) {
                    for (Location location : locations) {
                        int locationIdInt = Integer.parseInt(locationIdString);
                        if (location.getLocationId() == locationIdInt) {
                            int aliveBilbies = location.countAnimalsByStatus("BILBY", true);
                            int excessBilbies = aliveBilbies - 20;
                            System.out.println("Location" + locationIdInt
                                    + " - excess " + excessBilbies + " bilbies");
                            flag = true;
                        }
                    }
                }
                System.out.println("\nPlease choose a location to move OUT the bilbies");
            }
        }
        System.out.println("< Press B back to Action Menu >");
    }

    /**
     * Method to display action options for user
     *
     */
    public void displayActionOptions() {
        System.out.println("\n1) Relocate Bilbies" +
                "\n2) Hunt the foxes and cats" +
                "\n3) Continue the next simulation");
    }

    /**
     * Method to display the introduction of the simulation
     *
     */
    public void displayIntro() {
        System.out.println("\n===================================="
                + "\nWelcome to Bilby survival simulation" +
                "\n====================================");
        System.out.println("\nThis Bilby survival program will simulate" +
                "\none year of variation to a population of bilbies and their predators" +
                "\nin 10 locations of the area which you are going to name it later." +
                "\nEach month the following events may occur: " +
                "\n1) The new bilbies, foxes and cats may be born" +
                "\n2) A fox and a cat may eat a bilby" +
                "\n3) The excess bilbies will be daed if the population is more than 20" +
                "\nAfter these events occur in each month, you can see the monthly report," +
                "\nwhich contains the amount of new born animals and the amount of eaten bilbies in each month," +
                "\nand total amount of the alive and dead animals of the location" +
                "\n\nYou can then decide to relocate bilbies OR hunt the foxes and cats," +
                "\nBUT the hunting can only happen once a year in each location.");
    }

    /**
     * Method to display monthly report
     *
     * @param locations Accepts location objects as an ArrayList contains Location
     *                  objects.
     */
    public void monthlyDisplay(ArrayList<Location> locations) {
        for (Location location : locations) {
            location.display();
        }
    }
}
