package adoptme.pet;

public class Dog extends Pet{
	public Dog() { // default constructor
		this.name = null;
		this.species = null;
		this.age = -1;
	}
	
	public Dog(int i, String n, String s, int a, boolean adopted) {
		this.id = i;
		this.name = n;
		this.species = s;
		this.age = a;
		
		this.isAdopted = adopted;
	}
	
	public void adopt() {
		this.isAdopted = true;
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
