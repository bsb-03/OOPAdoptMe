package adoptme.pet;

public class Cat extends Pet{
	
	/**
	 * Default constructor for Cat class.
	 */
	public Cat() {
		this.name = null;
		this.species = null;
		this.age = -1;
		
		this.isAdopted = false;
	}
	
	/**
	 * Parameterized constructor for Cat class.
	 * @param i - Pet ID
	 * @param n - Pet name
	 * @param s - Pet species
	 * @param a - Pet age
	 * @param adopted - Pet adoption status
	 */
	public Cat(int i, String n, String s, int a, boolean adopted) {
		this.id = i;
		this.name = n;
		this.species = s;
		this.age = a;
		
		this.isAdopted = adopted;
	}
	
	/**
	 * Adoption/setter method for isAdopted field.
	 */
	public void adopt() {
		this.isAdopted = true;
	}
	
	/**
	 * Getter method for name field.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Setter method for name field.
	 * @param name - Pet name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Getter method for pet species field.
	 */
	public String getSpecies() {
		return species;
	}
	
	/**
	 * Setter method for pet species field.
	 * @param species - Pet species
	 */
	public void setSpecies(String species) {
		this.species = species;
	}
	
	/**
	 * Getter method for pet age field.
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * Setter method for pet age field.
	 * @param age - Pet age
	 */
	public void setAge(int age) {
		this.age = age;
	}
}
