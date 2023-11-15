import java.util.ArrayList;
// import java.io.*;

/**
 * Class which contains methods happened in each location
 *
 * @author Shih-Yi Huang
 * @version ver1.0.0
 */
public class Location {
    private int locationId;
    private ArrayList<Bilby> bilbies;
    private ArrayList<Fox> foxes;
    private ArrayList<Cat> cats;
    private boolean haveIntervened;
    private int[] newBornAnimalsAmount;
    private int eatenBilbyAmount;
    private IdGenerator idGenerator;

    /**
     * Default constructor which creates the object of the class Location.
     *
     */
    public Location() {
        this.locationId = locationId;
        this.bilbies = new ArrayList<Bilby>();
        this.foxes = new ArrayList<Fox>();
        this.cats = new ArrayList<Cat>();
        this.haveIntervened = false;
        this.newBornAnimalsAmount = new int[] { 0, 0, 0 };
        this.eatenBilbyAmount = 0;
        this.idGenerator = new IdGenerator();
    }

    /**
     * Non-Default constructor which creates the object of the class Location.
     *
     * @param locationId           Accepts the locationId as an integer.
     * @param bilbies              Accepts bilbies as an ArrayList containing Bilby
     *                             object arrays.
     * @param foxes                Accepts foxes as an ArrayList containing Fox
     *                             object arrays.
     * @param cats                 Accepts cats as an ArrayList containing Cat
     *                             object arrays.
     * @param haveIntervened       Accepts whether the location have been intervened
     *                             as a boolean.
     * @param newBornAnimalsAmount Accepts the number of new born animals of each
     *                             month as an integer array.
     * @param eatenBilbyAmount     Accepts the number of eaten bilbies as an
     *                             integer.
     * @param idGenerator          Accepts the idGenerator object as an IdGenerator.
     */
    public Location(int locationId, ArrayList<Bilby> bilbies, ArrayList<Fox> foxes,
            ArrayList<Cat> cats, boolean haveIntervened, int[] newBornAnimalsAmount,
            int eatenBilbyAmount, IdGenerator idGenerator) {
        this.locationId = locationId;
        this.bilbies = bilbies;
        this.foxes = foxes;
        this.cats = cats;
        this.haveIntervened = haveIntervened;
        this.newBornAnimalsAmount = new int[] { 0, 0, 0 };
        this.eatenBilbyAmount = eatenBilbyAmount;
        this.idGenerator = idGenerator;
    }

    /**
     * Non-Default constructor which creates the object of the class Location.
     *
     * @param locationId     Accepts the locationId as an integer.
     * @param haveIntervened Accepts whether the location have been intervened as a
     *                       boolean.
     * @param idGenerator    Accepts the idGenerator object as an IdGenerator.
     */
    public Location(int locationId, boolean haveIntervened, IdGenerator idGenerator) {
        this.locationId = locationId;
        this.bilbies = new ArrayList<Bilby>();
        this.foxes = new ArrayList<Fox>();
        this.cats = new ArrayList<Cat>();
        this.haveIntervened = haveIntervened;
        this.newBornAnimalsAmount = new int[] { 0, 0, 0 };
        this.eatenBilbyAmount = 0;
        this.idGenerator = idGenerator;
    }

    /**
     * Method to add a Bilby object into the ArrayList bilbies.
     *
     * @param bilby A Bilby object to be added.
     */
    public void addBilbies(Bilby bilby) {
        this.bilbies.add(bilby);
    }

    /**
     * Method to add a Cat object into the ArrayList cats.
     *
     * @param cat A Cat object to be added.
     */
    public void addCats(Cat cat) {
        this.cats.add(cat);
    }

    /**
     * Method to add a Fox object into the ArrayList foxes.
     *
     * @param fox A Fox object to be added.
     */
    public void addFoxes(Fox fox) {
        this.foxes.add(fox);
    }

    /**
     * Method to consider weather each Bilby object can give birth
     * and create a Bilby object if it satisfies the condition.
     *
     * @return The total number of monthly new born bilbies in the location as an
     *         integer.
     */
    public int bornBilby() {
        int newBornCount = 0;
        Probability probability = new Probability();
        for (Bilby bilby : bilbies) {
            if (bilby.getAlive() && probability.attemptBornBilby())
                newBornCount++;
        }
        this.createBilby(true, newBornCount);
        return newBornCount;
    }

    /**
     * Method to consider weather each Cat object can give birth
     * and create a Cat object if it satisfies the condition.
     *
     * @return The total number of monthly new born cats in the location as an
     *         integer.
     */
    public int bornCat() {
        int newBornCount = 0;
        Probability probability = new Probability();
        for (Cat cat : cats) {
            if (cat.getAlive() && probability.attemptBornCat())
                newBornCount++;
        }
        this.createCat(true, newBornCount);
        return newBornCount;
    }

    /**
     * Method to consider weather each Fox object can give birth
     * and create a Fox object if it satisfies the condition.
     *
     * @return The total number of monthly new born foxes in the location as an
     *         integer.
     */
    public int bornFox() {
        int newBornCount = 0;
        Probability probability = new Probability();
        for (Fox fox : foxes) {
            if (fox.getAlive() && probability.attemptBornFox())
                newBornCount++;
        }
        this.createFox(true, newBornCount);
        return newBornCount;
    }

    /**
     * Method to count the total number of alive or dead animals in the location
     * according to the given type and the required status.
     *
     * @param animal         Accepts the animal type as a String.
     * @param requiredStatus Accepts the animal's alive status as a boolean.
     * @return The total number of alive or dead animals in the location.
     */
    public int countAnimalsByStatus(String animal, boolean requiredStatus) {
        // if the requiredStatus is true, the alive is true
        boolean alive = requiredStatus == true;
        int count = 0;
        switch (animal) {
            case "BILBY":
                for (Bilby bilby : bilbies) {
                    if (bilby.getAlive() == alive)
                        count++;
                }
                break;
            case "FOX":
                for (Fox fox : foxes) {
                    if (fox.getAlive() == alive)
                        count++;
                }
                break;
            case "CAT":
                for (Cat cat : cats) {
                    if (cat.getAlive() == alive)
                        count++;
                }
                break;
        }
        return count;
    }

    /**
     * Method to create Bilby objects according to the given amount
     *
     * @param amount Accepts the amount of bilbies to create as an integer.
     */
    public void createBilby(boolean isNewBorn, int amount) {
        for (int createdNumber = 0; createdNumber < amount; createdNumber++) {
            String bilbyId = idGenerator.generateBilbyId();
            Bilby bilby = new Bilby(bilbyId, true, isNewBorn);
            this.addBilbies(bilby);
        }
    }

    /**
     * Method to create Cat objects according to the given amount
     *
     * @param amount Accepts the amount of cats to create as an integer.
     */
    public void createCat(boolean isNewBorn, int amount) {
        for (int createdNumber = 0; createdNumber < amount; createdNumber++) {
            String catId = idGenerator.generateCatId();
            Cat cat = new Cat(catId, true, isNewBorn, 3);
            this.addCats(cat);
        }
    }

    /**
     * Method to create Fox objects according to the given amount
     *
     * @param amount Accepts the amount of foxes to create as an integer.
     */
    public void createFox(boolean isNewBorn, int amount) {
        for (int createdNumber = 0; createdNumber < amount; createdNumber++) {
            String foxId = idGenerator.generateFoxId();
            Fox fox = new Fox(foxId, true, isNewBorn, 3);
            this.addFoxes(fox);
        }
    }

    /**
     * Method to count total amount of new born babies of each animal in each
     * location.
     *
     * @param animal Accepts the animal type as a String.
     * @return The total amount of new born babies according to the given type.
     */
    public int countTotalNewBorn(String animal) {
        int totalNewBorn = 0;
        switch (animal) {
            case "BILBY":
                for (Bilby bilby : bilbies) {
                    if (bilby.getNewBorn())
                        totalNewBorn++;
                }
                break;
            case "FOX":
                for (Fox fox : foxes) {
                    if (fox.getNewBorn())
                        totalNewBorn++;
                }
                break;
            case "CAT":
                for (Cat cat : cats) {
                    if (cat.getNewBorn())
                        totalNewBorn++;
                }
                break;
        }
        return totalNewBorn;
    }

    /**
     * Display information of the location.
     *
     */
    public void display() {
        System.out.println("----------------------- LOCATION " + locationId +
                " -----------------------");
        System.out.println("  | New Born | Bilby: " + newBornAnimalsAmount[0]
                + " Fox: " + newBornAnimalsAmount[1]
                + " Cat: " + newBornAnimalsAmount[2]
                + " | Eaten | Bilby: " + eatenBilbyAmount);
        System.out.println("   - BILYBY - alive: " + this.countAnimalsByStatus("BILBY", true)
                + " dead: " + this.countAnimalsByStatus("BILBY", false));
        System.out.println("   -   FOX  - alive: " + this.countAnimalsByStatus("FOX", true)
                + " dead: " + this.countAnimalsByStatus("FOX", false));
        System.out.println("   -   CAT  - alive: " + this.countAnimalsByStatus("CAT", true)
                + " dead: " + this.countAnimalsByStatus("CAT", false));
    }

    /**
     * Display information of the statistics population of the year in each
     * location.
     *
     */
    public void displayStatisticsPopulation() {
        System.out.println("- Location " + locationId + " -");
        System.out.println("  Alive Animals : ");
        System.out.println("    Bilbies: " + this.countAnimalsByStatus("BILBY", true) +
                ", Foxes: " + this.countAnimalsByStatus("FOX", true) +
                ", Cats: " + this.countAnimalsByStatus("CAT", true));
        System.out.println("  New Born Babies : ");
        System.out.println("    Bilbies: " + this.countTotalNewBorn("BILBY") +
                ", Foxes: " + this.countTotalNewBorn("FOX") +
                ", Cats: " + this.countTotalNewBorn("CAT"));
        System.out.println("  Dead Animals : ");
        System.out.println("    Bilbies: " + this.countAnimalsByStatus("BILBY", false) +
                ", Foxes: " + this.countAnimalsByStatus("FOX", false) +
                ", Cats: " + this.countAnimalsByStatus("CAT", false));
    }

    /**
     * Method to execute born methods of three animals and set the amount of new
     * born animals.
     *
     */
    public void executeBorn() {
        int newBornBilby = this.bornBilby();
        int newBornFox = this.bornFox();
        int newBornCat = this.bornCat();
        int[] newBornAmount = new int[] { newBornBilby, newBornFox, newBornCat };
        this.setNewBornAnimalsAmount(newBornAmount);
    }

    /**
     * Method to execute hunt methods of two predators and set the amount of eaten
     * bilbies.
     *
     */
    public void executeHunt() {
        int eatenByCatCount = this.huntedByCat();
        int eatenByFoxCount = this.huntedByFox();
        int sum = eatenByCatCount + eatenByFoxCount;
        this.setEatenBilbyAmount(sum);
    }

    /**
     * Method to execute intervention to two predators and set haveIntervened to
     * true.
     *
     */
    public void executeIntervention() {
        int huntedFoxesCount = this.interveneAnimals("FOX");
        int huntedCatsCount = this.interveneAnimals("CAT");
        System.out.print("\nThe intervention hunt " + huntedFoxesCount
                + " foxes and " + huntedCatsCount + " cats");
        this.setHaveIntervened(true);
    }

    /**
     * Method to execute monthly simulation.
     *
     */
    public void executeMonthlySimulation() {
        this.killExcessBilbies();
        this.executeBorn();
        this.executeHunt();
    }

    /**
     * Accessor method to get ArrayList bilbies.
     *
     * @return The arrays of Bilby object as an ArrayList.
     */
    public ArrayList<Bilby> getBilbies() {
        return this.bilbies;
    }

    /**
     * Accessor method to get ArrayList cats.
     *
     * @return The arrays of Cat object as an ArrayList.
     */
    public ArrayList<Cat> getCats() {
        return this.cats;
    }

    /**
     * Accessor method to get amount of eaten bilbies.
     *
     * @return The amount of eaten bilbies as an integer.
     */
    public int getEatenBilbyAmount() {
        return this.eatenBilbyAmount;
    }

    /**
     * Accessor method to get ArrayList foxes.
     *
     * @return The arrays of Fox object as an ArrayList.
     */
    public ArrayList<Fox> getFoxes() {
        return this.foxes;
    }

    /**
     * Accessor method to get the status of whether the location have been
     * intervened.
     *
     * @return The status of whether the location have been intervened as a boolean.
     */
    public boolean getHaveIntervened() {
        return this.haveIntervened;
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
     * Accessor method to get the locationId.
     *
     * @return The locationId as an integer.
     */
    public int getLocationId() {
        return this.locationId;
    }

    /**
     * Accessor method to get the amount of three new born animals.
     *
     * @return The amount of new born animals as an integer array.
     */
    public int[] getNewBornAnimalsAmount() {
        return this.newBornAnimalsAmount;
    }

    /**
     * Method to consider weather each Cat object can hunt a bilby
     * then either kill it or being panished.
     *
     * @return The number of monthly hunted bilbies by cats in the location as an
     *         integer.
     */
    public int huntedByCat() {
        int count = 0;
        Probability probability = new Probability();
        int aliveBilbiesAmount = this.countAnimalsByStatus("BILBY", true);
        for (Cat cat : cats) {
            if (cat.getAlive() && aliveBilbiesAmount > 0 && probability.attemptHuntByCat()) {
                this.killOneBilby();
                aliveBilbiesAmount--;
                count++;
            } else
                cat.failedPunishment();
        }
        return count;
    }

    /**
     * Method to consider weather each Fox object can hunt a bilby
     * then either kill it or being panished.
     *
     * @return The number of monthly hunted bilbies by foxes in the location as an
     *         integer.
     */
    public int huntedByFox() {
        int count = 0;
        Probability probability = new Probability();
        int aliveBilbiesCount = this.countAnimalsByStatus("BILBY", true);
        for (Fox fox : foxes) {
            if (fox.getAlive() && aliveBilbiesCount > 0 && probability.attemptHuntByFox()) {
                this.killOneBilby();
                aliveBilbiesCount--;
                count++;
            } else
                fox.failedPunishment();
        }
        return count;
    }

    /**
     * Method to consider whether the predators would be hunted
     * then kill it if satisfying the condition.
     *
     * @param animal Accepts the animal type as a String.
     * @return The number of monthly hunted predators as an integer.
     */
    public int interveneAnimals(String animal) {
        int count = 0;
        Probability probability = new Probability();
        switch (animal) {
            case "FOX":
                for (Fox fox : foxes) {
                    if (fox.getAlive() && probability.attemptIntervenePredators()) {
                        fox.setAlive(false);
                        count++;
                    }
                }
                break;
            case "CAT":
                for (Cat cat : cats) {
                    if (cat.getAlive() && probability.attemptIntervenePredators()) {
                        cat.setAlive(false);
                        count++;
                    }
                }
                break;
        }
        return count;
    }

    /**
     * Method to kill excess amount of bilbies in a location.
     *
     */
    public void killExcessBilbies() {
        int aliveBilbiesCount = this.countAnimalsByStatus("BILBY", true);
        if (aliveBilbiesCount > 20) {
            int excessNumber = aliveBilbiesCount - 20;
            for (int i = 0; i < excessNumber; i++) {
                this.killOneBilby();
            }
        }
    }

    /**
     * Method to kill one alive bilby in a location.
     *
     */
    public void killOneBilby() {
        for (Bilby bilby : bilbies) {
            if (bilby.getAlive()) {
                bilby.setAlive(false);
                break;
            }
        }
    }

    /**
     * Method to add the given Bilby objects to the ArrayList bilbies.
     *
     * @param bilbiesIn Accepts the bilby objects as an ArrayList containing Bilby
     *                  objects arrays.
     */
    public void relocateBilbyIn(ArrayList<Bilby> bilbiesIn) {
        bilbies.addAll(bilbiesIn);
    }

    /**
     * Method to create an ArrayList containing Bilby object arrays to move out.
     *
     * @param moveOutAmount Accepts the amount of bilbies to be moved out.
     * @return The Bilby objects to be moved out as an ArrayList of Bilby objects.
     */
    public ArrayList<Bilby> relocateBilbyOut(int moveOutAmount) {
        ArrayList<Bilby> bilbiesOutList = new ArrayList<Bilby>();
        while (moveOutAmount > 0) {
            for (Bilby bilby : bilbies) {
                if (bilby.getAlive()) {
                    bilbiesOutList.add(bilby);
                    bilbies.remove(bilby);
                    moveOutAmount--;
                    break;
                }
            }
        }
        return bilbiesOutList;
    }

    /**
     * Mutator method to set the ArrayList of Bilby objects.
     *
     * @param bilbies As an ArrayList containing Bilby object arrays.
     */
    public void setBilbies(ArrayList<Bilby> bilbies) {
        this.bilbies = bilbies;
    }

    /**
     * Mutator method to set the ArrayList of Cat objects.
     *
     * @param cats As an ArrayList containing Cat object arrays.
     */
    public void setCats(ArrayList<Cat> cats) {
        this.cats = cats;
    }

    /**
     * Mutator method to set the amount of eaten bilbies.
     *
     * @param eatenBilbyAmount The amount of eaten bilbies as an integer.
     */
    public void setEatenBilbyAmount(int eatenBilbyAmount) {
        this.eatenBilbyAmount = eatenBilbyAmount;
    }

    /**
     * Mutator method to set the ArrayList of Fox objects.
     *
     * @param foxes As an ArrayList contains Fox object arrays.
     */
    public void setFoxes(ArrayList<Fox> foxes) {
        this.foxes = foxes;
    }

    /**
     * Mutator method to set the status of whether the location have been
     * intervened.
     *
     * @param haveIntervened The status of whether the location have been intervened
     *                       as a boolean.
     */
    public void setHaveIntervened(boolean haveIntervened) {
        this.haveIntervened = haveIntervened;
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
     * Mutator method to set the location Id.
     *
     * @param locationId The location Id as an integer.
     */
    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    /**
     * Mutator method to set the amount of new born animals.
     *
     * @param newBornAmount The amount of new born animals as an integer array.
     */
    public void setNewBornAnimalsAmount(int[] newBornAmount) {
        this.newBornAnimalsAmount = newBornAmount;
    }
}