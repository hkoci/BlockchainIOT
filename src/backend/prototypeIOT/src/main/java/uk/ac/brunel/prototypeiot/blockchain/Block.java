/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.brunel.prototypeiot.blockchain;

/**
 *
 * @author Henri
 * @author (tutorial reference) https://medium.com/programmers-blockchain/create-simple-blockchain-java-tutorial-from-scratch-6eeed3cb03fa
 */
public class block {
    
    //Block global variables
    private String hash;
    private String previousHash;
    private String blockData;
    private long timeStamp;
    private int nonce;
 
    /*Block constructor
    The block is defined in this data structure where hashData is last!
    */
    public block(String data, String previousHash, long timeStamp) {
        this.blockData = data;
        this.previousHash = previousHash;
        this.timeStamp = timeStamp;
        this.hash = hashData();
    }
    
    /*Hashing Algorithm
    Returns a SHA3-256 hash generated on the block byte data
    */
    public String hashData() {
        return hashAlgorithm.hashSHA3Byte(previousHash + Long.toString(timeStamp) + Integer.toString(nonce) + blockData);
    }
    
    //Hash Getter
    public String getCurrentBlockHash(){
        return hash;
    }
    
    //Hash Getter
    public String getPreviousBlockHash(){
        return previousHash;
    }
    
    /*Block Mining (PoW)
    Set the difficulty of mined block and then calculate the hash result of this block
    */
    public void proofBlockMiner(int difficulty) {
        //Difficulty is based on the number of starting zero's to be matched
        String hashStartZeros = stringManipulation.getMiningDificulty(difficulty);
        
        System.out.println("hashStartZeros" + hashStartZeros);
        
        //If the difficulty has not been reached, then mine the block, increasing nonce on each attempt
        while(!hash.substring(0, difficulty).equals(hashStartZeros)) {
            nonce ++;
            hash = hashData();
        }
    }
    
}
