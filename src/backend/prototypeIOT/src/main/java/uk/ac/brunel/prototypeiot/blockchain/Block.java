/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.brunel.prototypeiot.blockchain;

import java.util.Date;

/**
 *
 * @author Henri
 * 
 */
public class Block {
    
    private String hash;
    private String previousHash;
    private String data;
    private long timeStamp;
    private int nonce;
 
    public Block(String data, String previousHash, long timeStamp) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = timeStamp;
    }
    
}
