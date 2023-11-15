/**
 * Parent class of Bilby, Cat, and Fox for storing information
 *
 * @author Shih-Yi Huang
 * @version ver1.0.0
 */
public class Animal {
    private String uniqueId;
    private boolean alive;
    private boolean newBorn;

    /**
     * Default constructor which creates the object of the class Animal.
     *
     */
    public Animal() {
        this("A000", true, false);
    }

    /**
     * Non-Default constructor which creates the object of the class Animal.
     *
     * @param uniqueId Accepts the uniqueId as a String.
     * @param alive    Accepts whether the animal is alive or not as a boolean.
     * @param newBorn  Accepts whether the animal is born
     *                 during the simulation as a boolean.
     */
    public Animal(String uniqueId, boolean alive, boolean newBorn) {
        this.setUniqueId(uniqueId);
        this.setAlive(alive);
        this.setNewBorn(newBorn);
    }

    /**
     * Display information of the animal.
     *
     * @return The information of the animal as a String.
     */
    public void display() {
        System.out.println("Unique ID : " + uniqueId +
                "\nIs Alive: " + alive +
                "\nIs New Born: " + newBorn);
    }

    /**
     * Accessor method to get the animal alive status.
     *
     * @return The animal alive status as a boolean.
     */
    public boolean getAlive() {
        return this.alive;
    }

    /**
     * Accessor method to get the animal new born status.
     *
     * @return The animal new born status as a boolean.
     */
    public boolean getNewBorn() {
        return this.newBorn;
    }

    /**
     * Accessor method to get the animal uniqueId.
     *
     * @return The animal uniqueId as a String.
     */
    public String getUniqueId() {
        return this.uniqueId;
    }

    /**
     * Mutator method to set the animal's alive status.
     *
     * @param alive The alive status of the animal as a boolean.
     */
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    /**
     * Mutator method to set the animal's new born status.
     *
     * @param newBorn The new born status of the animal as a boolean.
     */
    public void setNewBorn(boolean newBorn) {
        this.newBorn = newBorn;
    }

    /**
     * Mutator method to set the animal's uniqueId.
     *
     * @param uniqueId The uniqueId of the animal as a String.
     */
    public void setUniqueId(String uniqueId) {
        boolean isCorrect = true;
        if (uniqueId.isBlank()) {
            System.out.println("Unique ID must not be null");
            isCorrect = false;
        } else if (uniqueId.length() == 0) {
            System.out.println("Unique ID must not be empty");
            isCorrect = false;
        } else if (uniqueId.length() != 4) {
            System.out.println("Unique ID must be 4 character");
            isCorrect = false;
        }
        if (isCorrect)
            this.uniqueId = uniqueId;
        else if (this.uniqueId == null)
            this.uniqueId = "A000";
    }
}