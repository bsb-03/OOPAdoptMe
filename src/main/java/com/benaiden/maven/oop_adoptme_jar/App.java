package com.benaiden.maven.oop_adoptme_jar;

import java.awt.EventQueue;
import java.io.*;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;

import adoptme.pet.*;
import adoptme.shelter.*;
import adoptme.adapter.*;

public class App {
	
	/**
	 * Main method to run the program.
	 * IMPORTANT NOTE: In order to get the fields to display correctly within the GUI,
	 * the mouse must be hovered over the fields/the fields must be interacted with. Try
	 * clicking around on the GUI to get them all to appear. This is a bug in our program
	 * that we were not able to patch.
	 * @param args
	 */
    public static void main(String[] args) {
        String petsFilePath = "./src/main/resources/pets.json";
        String exoticFilePath = "./src/main/resources/exotic_animals.json";
        Shelter<Pet> petShelter = parseJsonToShelter(petsFilePath);
        Shelter<Pet> exoticShelter = parseExoticJsonToShelter(exoticFilePath);
        
        Shelter<Pet> shelter = petShelter.merge(exoticShelter);
        shelter.sortByName();
        
        View frame = new View(shelter);
        
        //System.out.println(shelter.toString()); debug print to test merge
    	
        /**
    	 * Launch the application.
    	 */
       /* EventQueue.invokeLater(new Runnable() {
    		public void run() {
    			try {
    				View frame = new View();
    				frame.setVisible(true);
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    		}
    	});*/
    }
    
    /**
     * private static Shelter<Pet> parseJsonToShelter(String f) - Method to 
     * convert a JSON file into a list of pet objects.
     * @param f - JSON file.
     * @return
     */
    private static Shelter<Pet> parseJsonToShelter(String f) {
    	Shelter<Pet> petShelter = new Shelter<>();

        RuntimeTypeAdapterFactory<Pet> typeFactory = RuntimeTypeAdapterFactory
                .of(Pet.class, "type") // type field determines pet type
                .registerSubtype(Cat.class, "Cat")
                .registerSubtype(Dog.class, "Dog")
                .registerSubtype(Rabbit.class, "Rabbit");

        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(typeFactory)
                .create();

        JsonReader reader;
        try {
            reader = new JsonReader(new FileReader(f));
        } catch (FileNotFoundException e) {
            System.out.println("FILE NOT FOUND");
            return null;
        }

        try {
            List<Pet> pets = gson.fromJson(reader, new TypeToken<List<Pet>>(){}.getType());
            for (Pet pet : pets) {
                petShelter.addPet(pet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //System.out.println(petShelter.toString());
        return petShelter;
    }

	/**
	 * private static Shelter<Pet> parseExoticJsonToShelter(String f) -
	 * Method to parse through a JSON file and convert it into a list
	 * of exotic pet objects.
	 * @param f - JSON file
	 * @return
	 */
    private static Shelter<Pet> parseExoticJsonToShelter(String f) {
    	Shelter<Pet> exoticShelter = new Shelter<>();
        Gson gson = new Gson();

        try (JsonReader reader = new JsonReader(new FileReader(f))) {
            List<RawExoticAnimal> rawList = gson.fromJson(reader, new TypeToken<List<RawExoticAnimal>>(){}.getType());

            ExoticAnimalAdapter adapter = new ExoticAnimalAdapter();
            for (RawExoticAnimal raw : rawList) {
                ExoticAnimal exotic = adapter.adapt(raw);
                exoticShelter.addPet(exotic);
            }

            return exoticShelter;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }
      
}
