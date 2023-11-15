/**
 * Child class of Animal for storing information of the fox
 *
 * @author Shih-Yi Huang
 * @version ver1.0.0
 */
public class Fox extends Animal {
    private int healthStatus;

    /**
     * Default constructor which creates the object of the class Fox.
     *
     */
    public Fox() {
        super();
        this.healthStatus = 0;
    }

    /**
     * Non-Default constructor which creates the object of the class Fox.
     *
     * @param uniqueId     Accepts the uniqueId as a String.
     * @param alive        Accepts whether the fox is alive or not as a boolean.
     * @param newBorn      Accepts whether the fox is born
     *                     during the simulation as a boolean.
     * @param healthStatus Accepts the healthStatus of the fox as an integer.
     */
    public Fox(String uniqueId, boolean alive, boolean newBorn, int healthStatus) {
        super(uniqueId, alive, newBorn);
        this.healthStatus = healthStatus;
    }

    /**
     * Display information of the fox.
     *
     * @return The information of the fox as a String.
     */
    public void display() {
        super.display();
        System.out.println("\nHealth Status: " + healthStatus);
    }

    /**
     * Method to set the alive status to false if the health status of the fox is 0.
     *
     */
    public void failedPunishment() {
        healthStatus--;
        if (this.getHealthStatus() == 0)
            this.setAlive(false);
    }

    /**
     * Accessor method to get the health status of the fox.
     *
     * @return The health status of the fox as an integer.
     */
    public int getHealthStatus() {
        return this.healthStatus;
    }

    /**
     * Mutator method to set the health status of the fox.
     *
     * @param healthStatus The health status of the fox as an integer.
     */
    public void setHealthStatus(int healthStatus) {
        this.healthStatus = healthStatus;
    }
}