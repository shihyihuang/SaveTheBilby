/**
 * Child class of Animal for storing information of the cat
 *
 * @author Shih-Yi Huang
 * @version ver1.0.0
 */
public class Cat extends Animal {
    private int healthStatus;

    /**
     * Default constructor which creates the object of the class Cat.
     *
     */
    public Cat() {
        super();
        this.healthStatus = 0;
    }

    /**
     * Non-Default constructor which creates the object of the class Cat.
     *
     * @param uniqueId     Accepts the uniqueId as a String.
     * @param alive        Accepts whether the cat is alive or not as a boolean.
     * @param newBorn      Accepts whether the cat is born
     *                     during the simulation as a boolean.
     * @param healthStatus Accepts the healthStatus of the cat as an integer.
     */
    public Cat(String uniqueId, boolean alive, boolean newBorn, int healthStatus) {
        super(uniqueId, alive, newBorn);
        this.healthStatus = healthStatus;
    }

    /**
     * Display information of the cat.
     *
     * @return The information of the cat as a String.
     */
    public void display() {
        super.display();
        System.out.println("\nHealth Status: " + healthStatus);
    }

    /**
     * Method to set the alive status to false if the health status of the cat is 0.
     *
     */
    public void failedPunishment() {
        healthStatus--;
        if (this.getHealthStatus() == 0)
            this.setAlive(false);
    }

    /**
     * Accessor method to get the health status of the cat.
     *
     * @return The health status of the cat as an integer.
     */
    public int getHealthStatus() {
        return this.healthStatus;
    }

    /**
     * Mutator method to set the health status of the cat.
     *
     * @param healthStatus The health status of the cat as an integer.
     */
    public void setHealthStatus(int healthStatus) {
        this.healthStatus = healthStatus;
    }
}