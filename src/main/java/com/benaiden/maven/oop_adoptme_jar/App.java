package com.benaiden.maven.oop_adoptme_jar;
import adoptme.pet.*;
import adoptme.shelter.*;


public class App 
{
    public static void main( String[] args )
    {
    	/*
    	 * PSEUDOCODE
    	 * Make new shelter
    	 * Fill shelter with data from .json files
    	 * Open interface, display info
    	 * Interface buttons (add, delete, adopt, etc.)
    	 * On close: fill .json with updated data
    	 */
    	Shelter myShelter = new Shelter<Pet>();
    	
        //Pet myPet = new Dog("Spot", "Boston Terrier", 5, false);
        
    }
}
