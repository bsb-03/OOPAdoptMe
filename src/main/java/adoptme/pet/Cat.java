package adoptme.pet;

public class Cat extends Pet{
	public Cat() { // default constructor
		this.name = null;
		this.species = null;
		this.age = -1;
		
		this.isAdopted = false;
	}
	
	public Cat(String n, String s, int a, boolean adopted) {
		this.name = n;
		this.species = s;
		this.age = a;
		
		this.isAdopted = adopted;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
