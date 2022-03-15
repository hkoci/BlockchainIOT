/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package uk.ac.brunel.blockchainIOT.fogBlockchain;

import java.util.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Henri
 * @author (tutorial reference) https://medium.com/programmers-blockchain/create-simple-blockchain-java-tutorial-from-scratch-6eeed3cb03fa
 */
public class blockService {
    
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
        
        System.out.println("Valid" + ledgerValidity());
        createBlock("Hello World!");
        //mineBlock();
        
        System.out.println(displayBlockchain());
        
        System.out.println("Valid2" + ledgerValidity());
        createBlock("Hello Again World!");
        //mineBlock();
        
        System.out.println("Valid3" + ledgerValidity());
        System.out.println(displayBlockchain());
        
        createBlock("Hello Again Again World!");
        //mineBlock();
        
        System.out.println("Valid4" + ledgerValidity());
        
        
        
        //Debug the data integrity
        infoLogObj.log(Level.INFO, "(validility): Data integrity of blockchain ledger {0}", ledgerValidity());
    }
    
    public static boolean createBlock(String blockData){
        //Base case: Check for data integrity of blockchain hashes being valid (!)
        if(ledgerValidity()){
            //Genesis block condition: Requires block hash to be set to 0
            if((ledger.size() - 1) < 0){
                ledger.add(new block(blockData, "0", new Date().getTime()));
                infoLogObj.info("(blockchain): Created new genesis block");
                return true;
            }
            
            //Otherwise, use the previous hash
            ledger.add(new block(blockData, ledger.get(ledger.size() - 1).getCurrentBlockHash(), new Date().getTime()));
            infoLogObj.info("(blockchain): Created new block");
            return true;
        }else{
            //Blockchain data integrity failed, do not store data!
            infoLogObj.severe("(blockchain): Blockchain data integrity failed, block not created (!)");
            return false;
        }
    }
    
    public static void setMiningDifficulty(int difficulty){
        miningDifficulty = difficulty;
    }
    
    public static void mineBlock(){
        infoLogObj.log(Level.INFO, "(miner): Mining Block {0}", ledger.size() - 1);
        ledger.get(ledger.size() - 1).proofBlockMiner(miningDifficulty);
    }
    
    public static String displayBlockchain(){
	return stringManipulation.generateJSON(ledger);
    }
    
    //Method overloading, using params for specific block
    public static String displayBlockchain(int blockIndex){
	return stringManipulation.generateJSON(ledger.get(blockIndex));
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
                infoLogObj.warning("(validility): Calculated hash of current block is not equal to the previous block (!)");
                return false;
            }

            //Data Integrity Case: Check if former hash is not the same as the referenced previous hash (!!)
            if (!formerBlock.getCurrentBlockHash().equals(iterationBlock.getPreviousBlockHash())) {
                infoLogObj.warning("(validility): Calculated hash of the previous block is not equal to the current block's previous hash (!)");
                return false;
            }

            //Unsuccessful Mined Case: Check if caclulated hash is equal to the referenced hash
            if (!iterationBlock.getCurrentBlockHash().substring(0, miningDifficulty).equals(hashTarget)) {
                infoLogObj.warning("(validility): Calculated hash has been modified, does not match difficulty");
                return false;
            }
            
            indexElement++;
        }
        return true;
    }
    
}
