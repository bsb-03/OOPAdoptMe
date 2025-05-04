package adoptme.pet;

public class ExoticAnimal extends Pet {
    private String category;

    public ExoticAnimal(String id, String name, String species, int age) {
        this.id = Integer.parseInt(id.replaceAll("\\D+", "")); // convert "exo001" → 1
        this.name = name;
        this.species = species;
        this.age = age;
        this.category = category;
        this.isAdopted = false;
    }

    public void adopt() {
        this.isAdopted = true;
    }

    public String getCategory() {
        return category;
    }
    
    public String getName() {
    	return name;
    }
    
    public String getSpecies() {
    	return species;
    }
    
    public int getAge() {
    	return age;
    }
	
}
