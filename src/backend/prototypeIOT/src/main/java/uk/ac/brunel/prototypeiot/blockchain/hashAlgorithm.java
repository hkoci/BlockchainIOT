/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.brunel.prototypeiot.blockchain;

import java.math.BigInteger;
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
            MessageDigest shaDigestObject = MessageDigest.getInstance("SHA3-256");

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
        
        //Generate Integer sign of byte array
        BigInteger byteSign = new BigInteger(1, hashAsByteArr);
        
        //Generate String of base 16
        StringBuilder hexByteString = new StringBuilder(byteSign.toString(16)); 

        /* Add leading zeros to whole String, only if not completed
        32 digits (1 byte = 2 chars, 16 byte = 32 chars) */
        
        while (hexByteString.length() < 32) {
            hexByteString.insert(0, '0'); 
        }
        
        //Return the complete hexadecimal string
        return hexByteString.toString();
    }
   
}
