package animals.petstore.pet.types; // package together with petstore model

// Import all relevant pet model and attributes
import animals.AnimalType;
import animals.petstore.pet.Pet;
import animals.petstore.pet.attributes.Breed;
import animals.petstore.pet.attributes.Gender;
import animals.petstore.pet.attributes.PetType;
import animals.petstore.pet.attributes.Skin;

import java.math.BigDecimal;

/**
 * Bird attributes
 */
public class Snake extends Pet implements PetImpl {

    /* Properties */
    private int numberOfLegs;
    private Breed breed;

    /**
     * Constructor, define attributes
     * @param animalType {@link AnimalType} that defines if it domesticated or wild snake
     * @param skinType The {@link Skin} of the snake
     * @param gender The {@link Gender} of the snake
     * @param breed The type of snake {@link Breed}
     */
    public Snake(AnimalType animalType, Skin skinType, Gender gender, Breed breed)
    {
        this(animalType, skinType, gender, breed, new BigDecimal(0));
    } // end of snake constructor

    /**
     * Constructor, define attributes w/ cost
     * @param animalType {@link AnimalType} that defines if it domesticated or wild snake
     * @param skinType The {@link Skin} of the snake
     * @param gender The {@link Gender} of the snake
     * @param breed The type of snake {@link Breed}
     * @param cost The cost of the snake
     */

    public Snake(AnimalType animalType, Skin skinType, Gender gender, Breed breed, BigDecimal cost)
    {
        this(animalType, skinType, gender, breed, cost,0);
    } // end of Snake constructor (cost)

    /**
     * Constructor, define and initializing attributes w/ cost and petstore id
     * @param animalType {@link AnimalType} that defines if it domesticated or wild snake
     * @param skinType The {@link Skin} of the snake
     * @param gender The {@link Gender} of the snake
     * @param breed The type of snake {@link Breed}
     * @param cost The cost of the snake
     * @param petStoreId The pet store id
     */
    public Snake(AnimalType animalType, Skin skinType, Gender gender, Breed breed, BigDecimal cost, int petStoreId)
    {
        super(PetType.SNAKE, cost, gender, petStoreId);
        super.skinType = skinType;
        super.animalType = animalType;
        this.numberOfLegs = 0;
        this.breed = breed;
    } // end of Snake Constructor (cost, petstoreid)

    /**
     * Is the snake allergy friendly determined by skin type
     * @return A message that tells if the snake is hypoallergenic
     */
    public String snakeHypoallergenic()
    {
        return super.petHypoallergenic(this.skinType).replaceAll("pet", "snake");
    } // end of snakeHypoallergenic

    /**
     * Depending on if the snake is domestic, wild, or neither what can the say
     * @return what snakes would speak
     */
    public String speak()
    {
        String language;
        switch (this.animalType)
        {
            case DOMESTIC:
                language = "The snake goes hiss! hiss!";
                break;
            case WILD:
                language = "The snake goes SSS! SSS!";
            default:
                language = "The snake goes " + super.getPetType().speak + "! " + super.getPetType().speak + "!";
                break;
        }
        return language;
    } // end of speak

    private String numberOfLegs()
    {
        return "Snakes have " + numberOfLegs + " legs!";
    } // end of numberOfLegs

    public int getNumberOfLegs()
    {
        return numberOfLegs;
    } // end of getNumberOfLegs

    public void setNumberOfLegs(int numberOfLegs)
    {
        this.numberOfLegs = numberOfLegs;
    } // end of setNumberOfLegs

    /**
     * {@inheritDoc}
     */
    // Functions to return snake attributes
    public Breed getBreed() {
        return this.breed;
    }
    public String typeOfPet() {
        return "The type of pet is " + petType + "!";
    }
    public AnimalType getAnimalType()
    {
        return super.animalType;
    } // end of getAnimalType

    // Output snake attributes as a string
    @Override
    public String toString() {
        return super.toString() +
                "The snake is " + this.animalType + "!\n" +
                "The snake breed is " + this.getBreed() + "!\n" +
                this.snakeHypoallergenic() + "!\n" +
                this.speak() + "\n" +
                this.numberOfLegs();
    }

} // end of Snake class