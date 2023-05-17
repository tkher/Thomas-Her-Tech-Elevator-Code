package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class Tutorial {
	

    public static void main(String[] args) {

        // Step One: Declare a Map
<<<<<<< HEAD
        Map<String,String> projects = new HashMap<String, String>();

    	
    	// Step Two: Add items to a Map
        projects.put("Ada", "Inventing Computer Programming");
        projects.put("Grace", "COBOL");
        projects.put("Margaret", "Apollo Guidance Computer");
        projects.put("Adele", "Graphical User Interfaces");
    	
    	// Step Three: Loop through a Map
//        for (Map.Entry<String,String> project : projects.entrySet()) {
//            System.out.println("The key " + project.getKey() + " is linked to the value " + project.getValue());

          for (String i : projects.keySet()) {
              System.out.println("Key = " + i + "and value = " + (projects.get(i)));

        }
=======


    	// Step Two: Add items to a Map


    	// Step Three: Loop through a Map

>>>>>>> 6cf82d46e82b190b79c85c70bfcc67aaf55f72dc
    }

}
