/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.brunel.blockchainIOT.fogBlockchain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 *
 * @author Henri
 */
public class stringManipulation {
    
    /* JSON Generation Method
    Generate JSON from a object using GsonBuilder
    */
    public static String generateJSON(Object dataObject){
        //Instantiate GsonBuilder object to use the Gson libary
        Gson GSONObject = new GsonBuilder().setPrettyPrinting().create();
        
        //Convert the dataObject parameter to JSON as String
        String jsonString = GSONObject.toJson(dataObject);
        
        //Return result
        return jsonString;
    }
    
    /*Block Mining Difficulty level
    This method generates a number of 0's based on a integer given - required when mining to search for x zeros
    */
    public static String getMiningDificulty(int difficulty) {
        return "0".repeat(difficulty);
    }
    
}
