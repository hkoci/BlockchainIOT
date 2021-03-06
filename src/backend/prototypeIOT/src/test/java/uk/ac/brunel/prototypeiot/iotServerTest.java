/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package uk.ac.brunel.prototypeiot;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author hkoci
 */
public class iotServerTest {
    
    public iotServerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    //Server parameters, including message
    String hostName = "localhost";
    int portNumber = 4999;
    String expMessage = "Test1234!";

    /**
     * Test of receiveMessage method, of class iotServer.
     */
    @Test
    public void testReceiveMessage() throws Exception {        
        //Start asynchronous thread for starting client (client-server)
        new Thread(() -> {
            //Try-catch I/O error handling
            try {
                //Start IOT Client at specified port, send message
                iotClient.sendMessage(hostName, portNumber, expMessage);
            } catch (IOException ex) {
                //Log exception error and fail the unit test
                Logger.getLogger(iotServerTest.class.getName()).log(Level.SEVERE, null, ex);
                fail("Exception in IOTServer" + ex.getMessage());
            }
        }).start();
        
        //Start asynchronous thread for starting server (client-server)
        new Thread(() -> {
            //Try-catch I/O error handling
            try {
                //Start IOT Client at specified hostname and port, store message
                String result = iotServer.receiveMessage(portNumber);
                assertEquals(expMessage, result); //If message received matches - pass unit test
            } catch (IOException ex) {
                //Log exception error and fail the unit test
                Logger.getLogger(iotServerTest.class.getName()).log(Level.SEVERE, null, ex);
                fail("Exception in IOTClient" + ex.getMessage());
            }
        }).start();
    }

    /**
     * Test of sendMessage method, of class iotServer.
     */
    @Test
    public void testSendMessage() throws Exception {        
        //Start asynchronous thread for starting client (client-server)
        new Thread(() -> {
            //Try-catch I/O error handling
            try {
                //Start IOT Client at specified port, send message
                iotClient.sendMessage(hostName, portNumber, expMessage);
            } catch (IOException ex) {
                //Log exception error and fail the unit test
                Logger.getLogger(iotServerTest.class.getName()).log(Level.SEVERE, null, ex);
                fail("Exception in IOTServer" + ex.getMessage());
            }
        }).start();
        
        //Start asynchronous thread for starting server (client-server)
        new Thread(() -> {
            //Try-catch I/O error handling
            try {
                //Start IOT Client at specified hostname and port, store message
                String result = iotServer.receiveMessage(portNumber);
                assertEquals(expMessage, result); //If message received matches - pass unit test
            } catch (IOException ex) {
                //Log exception error and fail the unit test
                Logger.getLogger(iotServerTest.class.getName()).log(Level.SEVERE, null, ex);
                fail("Exception in IOTClient" + ex.getMessage());
            }
        }).start();
    }
    
}
