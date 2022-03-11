/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package uk.ac.brunel.prototypeiot.blockchain;

import java.util.Date;

/**
 *
 * @author Henri
 */
public class mainLoader {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        block genesisBlock = new block("Hello World!", "0", new Date().getTime());
        System.out.println("(Block 1) Hash: " + genesisBlock.getHash());

        block secondBlock = new block("IoT Block 1" , genesisBlock.getHash(), new Date().getTime());
        System.out.println("(Block 2) Hash: " + secondBlock.getHash());

        block thirdBlock = new block("IoT Block 2" , secondBlock.getHash(), new Date().getTime());
        System.out.println("(Block 3) Hash: " + thirdBlock.getHash());
    }
    
}
