/**
 * Child class of Animal for storing information of the bilby
 *
 * @author Shih-Yi Huang
 * @version ver1.0.0
 */
public class Bilby extends Animal {
    /**
     * Default constructor which creates the object of the class Bilby.
     *
     */
    public Bilby() {
        super();
    }

    /**
     * Non-Default constructor which creates the object of the class Bilby.
     *
     * @param uniqueId Accepts the uniqueId as a String.
     * @param alive    Accepts whether the bilby is alive or not as a boolean.
     * @param newBorn  Accepts whether the bilby is born
     *                 during the simulation as a boolean.
     */
    public Bilby(String uniqueId, boolean alive, boolean newBorn) {
        super(uniqueId, alive, newBorn);
    }

    /**
     * method to execute testing of Bilby class.
     *
     */
    // public void test()
    // {
    // System.out.println("Create a Bilby object with the default constructor");
    // Bilby bilby1 = new Bilby();
    // bilby1.display();

    // System.out.println("\nCreate a Bilby object with the non-default constructor
    // with valid field values");
    // Bilby bilby2 = new Bilby("B001", true, false);
    // bilby2.display();

    // System.out.println("\nCreate a Bilby object with the non-default constructor
    // with invalid field values");
    // Bilby bilby3 = new Bilby("", false, true);
    // bilby3.display();

    // System.out.println("\nCreate a Bilby object with the non-default constructor
    // with invalid field values");
    // Bilby bilby4 = new Bilby("B01", false, true);
    // bilby4.display();

    // System.out.println("\nTest get methods - getUniqueId()");
    // Bilby bilby5 = new Bilby();
    // System.out.println(bilby5.getUniqueId());

    // System.out.println("\nTest get methods - getAlive()");
    // Bilby bilby6 = new Bilby();
    // System.out.println(bilby6.getAlive());

    // System.out.println("\nTest get methods - getNewBorn()");
    // Bilby bilby7 = new Bilby();
    // System.out.println(bilby7.getNewBorn());

    // System.out.println("\nTest set methods - setUniqueId() with valid field
    // values");
    // Bilby bilby8 = new Bilby();
    // bilby8.setUniqueId("B001");
    // System.out.println(bilby8.getUniqueId());

    // System.out.println("\nTest set methods - setUniqueId() with invalid field
    // values");
    // Bilby bilby9 = new Bilby();
    // bilby9.setUniqueId("");
    // System.out.println(bilby9.getUniqueId());

    // System.out.println("\nTest set methods - setUniqueId() with invalid field
    // values");
    // Bilby bilby10 = new Bilby();
    // bilby10.setUniqueId("B01");
    // System.out.println(bilby10.getUniqueId());
    // }

    /**
     * Method to being the program.
     *
     * @param args An array of Strings representing command line arguments.
     */
    // public static void main(String[] args)
    // {
    // Bilby bilby = new Bilby();
    // bilby.test();
    // }
}
