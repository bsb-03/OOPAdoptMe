package adoptme.shelter;
import java.util.ArrayList;
import adoptme.pet.*;

public class Shelter<T extends Pet> {
	private ArrayList<T> petArray;
	
	public Shelter() {
		petArray = new ArrayList<T>();
	}
	
	public void addPet(T p) {
		petArray.add(p);
	}
	
	public Pet getPetByName(String name) {
		for(Pet p : petArray) {
			if(p.getName() == name) {
				return p;
			}
		}
		
		return null;
	}
	
	public Pet removePetByName(String name) {
		for(Pet p : petArray) {
			if(p.getName() == name) {
				petArray.remove(p);
				return p;
			}
		}
		
		return null;
	}
	
	public void sortByName() {
		petArray.sort( (a, b) -> {return a.getName().compareTo(b.getName());});
	}
	
	public void sortBySpecies() {
		petArray.sort( (a, b) -> {return a.getSpecies().compareTo(b.getSpecies());});
	}
	
	public void sortByAge() {
	    petArray.sort((a, b) -> Integer.compare(a.getAge(), b.getAge()));
	}
	
	@Override
	public String toString() {
		String outputString = "";
		
		for(Pet p : petArray) {
			outputString = outputString + p.toString() + "\n";
		}
		
		return outputString;
	}
	
}
