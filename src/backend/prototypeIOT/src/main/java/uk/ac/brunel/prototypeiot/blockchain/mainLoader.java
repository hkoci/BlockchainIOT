/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package uk.ac.brunel.prototypeiot.blockchain;

import java.util.Date;
import java.util.ArrayList;
import com.google.gson.GsonBuilder;

/**
 *
 * @author Henri
 */
public class mainLoader {
    
    public static ArrayList<block> blockchain = new ArrayList<block>(); 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Add data to blockchain
        blockchain.add(new block("Hello World!", "0", new Date().getTime()));
        blockchain.add(new block("IoT Block 1" , blockchain.get(blockchain.size()-1).getCurrentHash(), new Date().getTime()));
        blockchain.add(new block("IoT Block 2" , blockchain.get(blockchain.size()-1).getCurrentHash(), new Date().getTime()));
        
        //Convert to JSON and print
	String blockchainJSON = stringManipulation.generateJSON(blockchain);		
	System.out.println(blockchainJSON);
    }
    
}
