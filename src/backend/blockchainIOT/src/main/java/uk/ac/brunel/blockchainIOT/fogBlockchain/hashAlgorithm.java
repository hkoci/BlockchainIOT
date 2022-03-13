/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.brunel.blockchainIOT.fogBlockchain;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Henri
 */

public class hashAlgorithm {
    
    //Generate hashed SHA3 byte from a plaintext argument
    public static String hashSHA3Byte(String plainText) {
        try {
            //Instantiate MessageDigest object to use SHA3 algorithm
            MessageDigest shaDigestObject = MessageDigest.getInstance("SHA-256");

            //Hash the plaintext using the SHA3 algorithm into a Byte data structure
            byte[] hashAsByteArr = shaDigestObject.digest(plainText.getBytes(StandardCharsets.UTF_8));

            //Return the result as Hexadecimal
            return bytesToHex(hashAsByteArr);
        }
        catch(NoSuchAlgorithmException e) {
            throw new RuntimeException("Algorithm Digest Error" + e);
        }
    }
    
    //Convert Byte data structure to a hexadecimal string
    private static String bytesToHex(byte[] hashAsByteArr) {
        //Initialise StringBuilder, where the individual bytes will be stored as String
        StringBuilder hexBuilder = new StringBuilder();
        
        //Loop for each byte in array
        for (byte currentByte : hashAsByteArr) {
            /* Concatenate each byte in the Array using the %02x parameter
               The %02x param, prints atleast 2 digits from the hex, appending 0 if there is only 1 digit present */
            hexBuilder.append(String.format("%02x", currentByte));
        }

        //Return result as String
        return hexBuilder.toString();
    }
   
}
