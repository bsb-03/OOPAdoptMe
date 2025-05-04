package adoptme.pet;

public abstract class Pet {
	protected String name;
	protected String species;
	protected int age;
	
	@Override
	public String toString() {
		String petString = "Name: " + this.name + " Species: " + this.species + " Age: " + this.age;
		
		return petString;
	}
}
