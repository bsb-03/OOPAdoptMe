package adoptme.shelter;
import java.util.ArrayList;
import adoptme.pet.*;

public class Shelter<T extends Pet> {
	private ArrayList<T> petArray;
	
	/**
	 * Default constructor for Shelter class.
	 */
	public Shelter() {
		petArray = new ArrayList<T>();
	}
	
	/**
	 * Method to add pet objects to the pet array.
	 * @param p - Pet object
	 */
	public void addPet(T p) {
		petArray.add(p);
	}
	
	/**
	 * Method to find a pet object according to the value assigned within the name field. Returns
	 * Pet object if the name field is matching the string passed to the method, otherwise returns
	 * null if no matches are found.
	 * @param name - Name string
	 * @return
	 */
	public Pet getPetByName(String name) {
		for(Pet p : petArray) {
			if(p.getName() == name) {
				return p;
			}
		}
		
		return null;
	}
	
	/**
	 * Method to find a pet object according to the value assigned within the name field, and
	 * remove it from the array list. Returns the Pet object that is found with a matching
	 * name field, or returns null if no matches are found.
	 * @param name
	 * @return
	 */
	public Pet removePetByName(String name) {
		for(Pet p : petArray) {
			if(p.getName() == name) {
				petArray.remove(p);
				return p;
			}
		}
		
		return null;
	}
	
	/**
	 * Method to sort the pets within the pet list by name.
	 */
	public void sortByName() {
		petArray.sort( (a, b) -> {return a.getName().compareTo(b.getName());});
	}
	
	/**
	 * Method to sort the pets within the pet list by species.
	 */
	public void sortBySpecies() {
		petArray.sort( (a, b) -> {return a.getSpecies().compareTo(b.getSpecies());});
	}
	
	/**
	 * Method to sort the pets within the pet list by age,
	 */
	public void sortByAge() {
	    petArray.sort((a, b) -> Integer.compare(a.getAge(), b.getAge()));
	}
	
	/**
	 * toString method for Shelter class.
	 */
	@Override
	public String toString() {
		String outputString = "";
		
		for(Pet p : petArray) {
			outputString = outputString + p.toString() + "\n";
		}
		
		return outputString;
	}
	
	public ArrayList<T> getArray() {
		return petArray;
	}
	
	public Shelter<T> merge(Shelter<T> s) {
		for(T p : s.getArray()) {
			petArray.add(p);
		}
		
		return this;
	}
	
}
