/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.brunel.prototypeiot.blockchain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 *
 * @author Henri
 */
public class stringManipulation {
    
    /* JSON
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
    
}
