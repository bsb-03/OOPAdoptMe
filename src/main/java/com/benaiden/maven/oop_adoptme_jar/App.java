package com.benaiden.maven.oop_adoptme_jar;

import java.io.*;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;

import adoptme.pet.*;
import adoptme.shelter.*;

public class App {
    public static void main(String[] args) {
        String filename = "./src/main/resources/pets.json";
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
            reader = new JsonReader(new FileReader(filename));
        } catch (FileNotFoundException e) {
            System.out.println("FILE NOT FOUND");
            return;
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
        
        System.out.println(petShelter.toString());
    }
}