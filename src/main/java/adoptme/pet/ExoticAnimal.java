package adoptme.pet;

public class ExoticAnimal extends Pet {
    private String category;
    
    /**
     * Parameterized constructor for ExoticAnimal class
     * @param id - Pet ID
     * @param name - Pet name
     * @param species - Pet species
     * @param age - Pet age
     */
    public ExoticAnimal(String id, String name, String species, int age) {
        this.id = Integer.parseInt(id.replaceAll("\\D+", "")); // convert "exo001" → 1
        this.name = name;
        this.species = species;
        this.age = age;
        this.category = category;
        this.isAdopted = false;
    }
    
    /**
     * Setter/adopter method for isAdopted field
     */
    public void adopt() {
        this.isAdopted = true;
    }
    
    /**
     * Getter method for category field.
     * @return
     */
    public String getCategory() {
        return category;
    }
    
    /**
     * Getter method for name field.
     */
    public String getName() {
    	return name;
    }
    
    /**
     * Getter method for species field.
     */
    public String getSpecies() {
    	return species;
    }
    
    /**
     * Getter method for age field.
     */
    public int getAge() {
    	return age;
    }
	
}
