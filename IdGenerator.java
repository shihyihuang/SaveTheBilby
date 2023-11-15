/**
 * Class to generate uniqueId of animals
 *
 * @author Shih-Yi Huang
 * @version ver1.0.0
 */
public class IdGenerator {
    private int bilbyNumber;
    private int foxNumber;
    private int catNumber;

    /**
     * Default constructor which creates the object of the class IdGenerator.
     *
     */
    public IdGenerator() {
        this.bilbyNumber = 0;
        this.foxNumber = 0;
        this.catNumber = 0;
    }

    /**
     * Non-Default constructor which creates the object of the class IdGenerator.
     *
     * @param bilbyNumber Accepts the bilbyNumber as an integer.
     * @param foxNumber   Accepts the foxNumber as an integer.
     * @param catNumber   Accepts the catNumber as an integer.
     */
    public IdGenerator(int bilbyNumber, int foxNumber, int catNumber) {
        this.bilbyNumber = bilbyNumber;
        this.foxNumber = foxNumber;
        this.catNumber = catNumber;
    }

    /**
     * Method to generate uniqueId of the bilby.
     *
     * @return The uniqueId of the bilby as a String.
     */
    public String generateBilbyId() {
        this.bilbyNumber++;
        String bilbyId = "B" + String.format("%03d", this.bilbyNumber);
        return bilbyId;
    }

    /**
     * Method to generate uniqueId of the fox.
     *
     * @return The uniqueId of the fox as a String.
     */
    public String generateFoxId() {
        this.foxNumber++;
        String foxId = "F" + String.format("%03d", this.foxNumber);
        return foxId;
    }

    /**
     * Method to generate uniqueId of the cat.
     *
     * @return The uniqueId of the cat as a String.
     */
    public String generateCatId() {
        this.catNumber++;
        String catId = "C" + String.format("%03d", this.catNumber);
        return catId;
    }

    /**
     * Accessor method to get the number of bilbies.
     *
     * @return The uniqueId of the bilby as an integer.
     */
    public int getBilbyNumber() {
        return this.bilbyNumber;
    }

    /**
     * Accessor method to get the number of cats.
     *
     * @return The uniqueId of the cat as an integer.
     */
    public int getCatNumber() {
        return this.catNumber;
    }

    /**
     * Accessor method to get the number of foxes.
     *
     * @return The uniqueId of the fox as an integer.
     */
    public int getFoxNumber() {
        return this.foxNumber;
    }

    /**
     * Mutator method to set the number of bilbies.
     *
     * @param bilbyNumber The number of bilbies as an integer.
     */
    public void setBilbyNumber(int bilbyNumber) {
        this.bilbyNumber = bilbyNumber;
    }

    /**
     * Mutator method to set the number of cats.
     *
     * @param catNumber The number of cats as an integer.
     */
    public void setCatNumber(int catNumber) {
        this.catNumber = catNumber;
    }

    /**
     * Mutator method to set the number of foxes.
     *
     * @param foxNumber The number of foxes as an integer.
     */
    public void setFoxNumber(int foxNumber) {
        this.foxNumber = foxNumber;
    }
}
