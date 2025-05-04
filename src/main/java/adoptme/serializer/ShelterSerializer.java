package adoptme.serializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;

import adoptme.pet.*;
import adoptme.shelter.Shelter;

import java.io.FileWriter;
import java.io.IOException;

public class ShelterSerializer {

    public static void writeSheltersToJson(Shelter<Pet> allPets, String petsFilePath, String exoticFilePath) {
        Shelter<Pet> regularPets = new Shelter<>();
        Shelter<ExoticAnimal> exoticPets = new Shelter<>();

        for (Pet pet : allPets.getArray()) {
            if (pet instanceof ExoticAnimal) {
                exoticPets.addPet((ExoticAnimal) pet);
            } else {
                regularPets.addPet(pet);
            }
        }

        
        RuntimeTypeAdapterFactory<Pet> typeFactory = RuntimeTypeAdapterFactory // runtime adapter set up for polymorphism
                .of(Pet.class, "type")
                .registerSubtype(Cat.class, "Cat")
                .registerSubtype(Dog.class, "Dog")
                .registerSubtype(Rabbit.class, "Rabbit")
                .registerSubtype(ExoticAnimal.class, "ExoticAnimal");

        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(typeFactory)
                .setPrettyPrinting()
                .create();

        try (FileWriter writer = new FileWriter(petsFilePath)) { // handle pets
            gson.toJson(regularPets.getArray(), writer);
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        try (FileWriter writer = new FileWriter(exoticFilePath)) { // handle exotic animals
            gson.toJson(exoticPets.getArray(), writer);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

