/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package uk.ac.brunel.prototypeiot.ssl;

import javax.net.ssl.*;
import javax.net.*; 
import java.net.*;
import java.io.*;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.core.io.ClassPathResource;

/**
 *
 * @author Henri
 */
public class iotClient {
    
    //Server configuration variables assigned with default values
    private static int serverPort = 4999;
    private static String serverHost = "localhost";
    private static final Logger debugLogger = Logger.getLogger(iotServer.class.getName());
    
    //Default values assigned in constructor
    iotClient(int port, String hostName){
        serverPort = setServerPort(port);
        serverHost = setServerHost(hostName);
    }
    
    //Setter Method (server port)
    public final int setServerPort(int port){
        //Input validation check (negative port)
        if(port < 1){
            //Invalid port - so use the default port number
            debugLogger.log(Level.WARNING, "Server Port; {0} cannot be a negative number, using default port " + serverPort, port);
            return serverPort;
        }
        else{
            //Valid port - change the port
            return serverPort;
        }
    }
    
    //Setter Method (server port)
    public final String setServerHost(String host){
        //TODO: Host name validation
        return host;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        //Get Absolute path of Java KeyStore certificate (Public/Private key pair)
        ClassPathResource resource = new ClassPathResource("certs/cert-keyStore.jks");

        //Set KeyStore key pair certificate to TrustStore
        System.setProperty("javax.net.ssl.keyStore",Paths.get(resource.getURI()).toString());
        System.setProperty("javax.net.ssl.keyStorePassword","Bl0ckCh41nI0T");
        System.setProperty("javax.net.ssl.trustStore",Paths.get(resource.getURI()).toString());
        System.setProperty("javax.net.ssl.trustStorePassword","Bl0ckCh41nI0T");
        System.setProperty("javax.net.ssl.keyStoreType", "JKS");
        
        //Receive message from server using the provided hostname/port arguments
        String message = receiveMessage(serverHost,serverPort);
        System.out.println("Server says: " + message);

        //Send message to server using the provided hostname/port arguments
        sendMessage(serverHost,serverPort,"Hello Server, do you see me?");
    }
    
    public static String receiveMessage(String hostName, int portNumber) throws IOException {
        SSLSocketFactory socketFactory =  (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket socketObject = (SSLSocket) socketFactory.createSocket(hostName, portNumber);
        //socketObject.startHandshake();
        
        //Create client socket connection to specified host/port
        //Socket socketObject = new Socket(hostName, portNumber);
        
        //Create new reader objects for input/output
        InputStreamReader inputObject = new InputStreamReader(socketObject.getInputStream());
        BufferedReader bufferObject = new BufferedReader(inputObject);
        
        //Try-catch error handling
        try{
            //Attempt to read message from Server
            String message = bufferObject.readLine();

            //Close socket connection
            socketObject.close();

            //Return the message
            return message;
        }
        //Catch exception error technique
        catch(Exception e) {
            //Close socket
            socketObject.close();

            //Return the error
            return e.toString();
        }
    }

    public static void sendMessage(String hostName, int portNumber, String message) throws IOException {
        SSLSocketFactory socketFactory =  (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket socketObject = (SSLSocket) socketFactory.createSocket(hostName, portNumber);
        //socketObject.startHandshake();

        //Create client socket connection to specified host/port
        //Socket socketObject = new Socket(hostName, portNumber);
        
        //Send a message to the server using the PrintWriter
        PrintWriter printObject = new PrintWriter(socketObject.getOutputStream());
        printObject.println(message);
        printObject.flush();

        //Close the socket session when the message has been sent over
        socketObject.close();
    }
    
}
