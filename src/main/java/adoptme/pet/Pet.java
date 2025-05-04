package adoptme.pet;

public abstract class Pet {
	
	/**
	 * Fields that will be used within the specific pet classes.
	 */
	protected int id;
	protected String name;
	protected String species;
	protected int age;
	
	protected boolean isAdopted;
	
	/**
	 * toString for Pet class.
	 */
	@Override
	public String toString() {
		String petString = "Name: " + this.name + " ID: " + this.id + " Species: " + this.species + " Age: " + this.age;
		
		return petString;
	}
	
	/**
	 * Abstract getter/setter methods for fields within the Pet class.
	 * @return
	 */
	public abstract String getName();
	public abstract String getSpecies();
	public abstract int getAge();
	public abstract void adopt();
}
