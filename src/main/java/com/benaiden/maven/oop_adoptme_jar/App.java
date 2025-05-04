package com.benaiden.maven.oop_adoptme_jar;
import adoptme.pet.*;


public class App 
{
    public static void main( String[] args )
    {
        Pet myPet = new Dog("Spot", "Boston Terrier", 5);
        
        System.out.println(myPet.toString());
    }
}
