import java.util.Random;

/**
 * Class which contains probability methods
 *
 * @author Shih-Yi Huang
 * @version ver1.0.0
 */
public class Probability {
    /**
     * Default constructor which creates the object of the class Probability.
     *
     */
    public Probability() {

    }

    /**
     * Method to see whether the bilby will give birth.
     *
     * @return The result of giving birth or not as a boolean.
     */
    public boolean attemptBornBilby() {
        return this.isHappened(15);
    }

    /**
     * Method to see whether the cat will give birth.
     *
     * @return The result of giving birth or not as a boolean.
     */
    public boolean attemptBornCat() {
        return this.isHappened(20);
    }

    /**
     * Method to see whether the fox will give birth.
     *
     * @return The result of giving birth or not as a boolean.
     */
    public boolean attemptBornFox() {
        return this.isHappened(10);
    }

    /**
     * Method to see whether the bilby would be hunted by cat.
     *
     * @return The result of being hunted or not as a boolean.
     */
    public boolean attemptHuntByCat() {
        return this.isHappened(60);
    }

    /**
     * Method to see whether the bilby would be hunted by fox.
     *
     * @return The result of being hunted or not as a boolean.
     */
    public boolean attemptHuntByFox() {
        return this.isHappened(40);
    }

    /**
     * Method to see whether the predators would be hunted.
     *
     * @return The result of being hunted or not as a boolean.
     */
    public boolean attemptIntervenePredators() {
        return this.isHappened(50);
    }

    /**
     * Method to generate a random number from 1 to 100.
     *
     * @return The randomNumber as an integer.
     */
    public int generateRandomNumber() {
        Random random = new Random();
        int randomNumber = (int) random.nextInt(100) + 1;
        return randomNumber;
    }

    /**
     * Method to see whether the event would happen according to the given
     * probability.
     *
     * @param givenProbability Accepts the probability of each event being happened
     *                         as an integer.
     * @return The result of being happened or not as a boolean.
     */
    public boolean isHappened(int givenProbability) {
        int generatedNumber = this.generateRandomNumber();
        return generatedNumber <= givenProbability;
    }
}