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
    public static void main(String[] args) {
        String petsFilePath = "./src/main/resources/pets.json";
        String exoticFilePath = "./src/main/resources/exotic_animals.json";
        Shelter<Pet> petShelter = parseJsonToShelter(petsFilePath);
        Shelter<Pet> exoticShelter = parseExoticJsonToShelter(exoticFilePath);
        
        System.out.println(petShelter.toString());
        System.out.println(exoticShelter.toString());
    	
        /**
    	 * Launch the application.
    	 */
        EventQueue.invokeLater(new Runnable() {
    		public void run() {
    			try {
    				View frame = new View();
    				frame.setVisible(true);
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    		}
    	});
    }
    
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
            System.out.println("Loaded " + pets.size() + " pets into the shelter.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //System.out.println(petShelter.toString());
        return petShelter;
    }

	
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
