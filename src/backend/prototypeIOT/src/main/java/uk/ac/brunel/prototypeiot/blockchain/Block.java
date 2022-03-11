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
    
    private String hash;
    private String previousHash;
    private String blockData;
    private long timeStamp;
    private int nonce;
 
    //Block constructor
    public block(String data, String previousHash, long timeStamp) {
        this.blockData = data;
        this.previousHash = previousHash;
        this.timeStamp = timeStamp;
        this.hash = hashData();
    }
    
    //Hashing Algorithm
    public String hashData() {
        return hashAlgorithm.hashSHA3Byte(previousHash + Long.toString(timeStamp) + Integer.toString(nonce) + blockData);
    }
    
    //Hash Getter
    public String getHash(){
        return hash;
    }
    
}
