/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package uk.ac.brunel.prototypeiot.blockchain;

import java.util.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Henri
 * @author (tutorial reference) https://medium.com/programmers-blockchain/create-simple-blockchain-java-tutorial-from-scratch-6eeed3cb03fa
 */
public class mainLoader {
    
    //Instantiate ledger object containg the block data structure 
    public static ArrayList<block> ledger = new ArrayList<block>();
    
    //Blockchain variables
    public static int miningDifficulty = 5;
    
    //Instantiate debug logger
    private static Logger infoLogObj = Logger.getLogger("InfoLogging");

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Add data to blockchain
        ledger.add(new block("Hello World!", "0", new Date().getTime()));
        ledger.get(0).proofBlockMiner(miningDifficulty);
        
        ledger.add(new block("IoT Block 1" , ledger.get(ledger.size()-1).getCurrentBlockHash(), new Date().getTime()));
        ledger.get(1).proofBlockMiner(miningDifficulty);
        
        ledger.add(new block("IoT Block 2" , ledger.get(ledger.size()-1).getCurrentBlockHash(), new Date().getTime()));
        ledger.get(2).proofBlockMiner(miningDifficulty);
        
        //Debug the data integrity
        infoLogObj.log(Level.INFO, "(validility): Data integrity of blockchain ledger {0}", ledgerValidity());
        
        //Convert to JSON and print
	String blockchainJSON = stringManipulation.generateJSON(ledger);		
	System.out.println(blockchainJSON);
    }
    
    /* Validating blockchain data
    Loop through each block in the blockchain and compare the base cases of calculated hashes
    */
    public static Boolean ledgerValidity() {
        //Set the difficulty of the calculated mined hash
        String hashTarget = stringManipulation.getMiningDificulty(miningDifficulty);

        //Starting at element 1 in blockchain arrayList
        int indexElement = 1;
        
        //Loop until all block bytes in arrayList ledger have been checked
        while(indexElement < ledger.size()){
            //Initalise the current and previous block
            block iterationBlock = ledger.get(indexElement);
            block formerBlock = ledger.get(indexElement - 1);

            //Base Case: Check if mined hash is not the same as the referenced hash (!)
            if (!iterationBlock.getCurrentBlockHash().equals(iterationBlock.hashData())) {
                infoLogObj.warning("(validility): Caclulated hash of current block is not equal to the previous block (!)");
                return false;
            }

            //Data Integrity Case: Check if former hash is not the same as the referenced previous hash (!!)
            if (!formerBlock.getCurrentBlockHash().equals(iterationBlock.getPreviousBlockHash())) {
                infoLogObj.warning("(validility): Caclulated hash of the previous block is not equal to the current block's previous hash (!)");
                return false;
            }

            //Unsuccessful Mined Case: Check if caclulated hash is equal to the referenced hash
            if (!iterationBlock.getCurrentBlockHash().substring(0, miningDifficulty).equals(hashTarget)) {
                infoLogObj.warning("(validility): Caclulated hash has been modified, does not match difficulty");
                return false;
            }
            
            indexElement++;
        }
        return true;
    }
    
}
