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
}
