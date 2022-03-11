/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.brunel.prototypeiot.blockchain;

/**
 *
 * @author Henri
 * 
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
    public String getCurrentHash(){
        return hash;
    }
    
    //Hash Getter
    public String getPreviousHash(){
        return previousHash;
    }
    
}
