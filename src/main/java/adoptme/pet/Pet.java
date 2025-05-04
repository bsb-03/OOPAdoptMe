package adoptme.pet;

public abstract class Pet {
	protected int id;
	protected String name;
	protected String species;
	protected int age;
	
	protected boolean isAdopted;
	
	@Override
	public String toString() {
		String petString = "Name: " + this.name + " ID: " + this.id + " Species: " + this.species + " Age: " + this.age;
		
		return petString;
	}
	
	public abstract String getName();
	public abstract String getSpecies();
	public abstract int getAge();
	public abstract void adopt();
}
