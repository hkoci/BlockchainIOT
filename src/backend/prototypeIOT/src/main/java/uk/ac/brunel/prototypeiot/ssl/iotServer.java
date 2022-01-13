/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package uk.ac.brunel.prototypeiot.ssl;

import javax.net.ssl.*;
import javax.net.*; 
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Henri
 */
public class iotServer {
    
    //Server configuration variables assigned with default values
    private static int serverPort = 4999;
    private static String serverHost = "localhost";
    private static final Logger debugLogger = Logger.getLogger(iotServer.class.getName());
    
    //Default values assigned in constructor
    iotServer(int port, String hostName){
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
        System.out.println("Port" + serverPort);
        
        //Recieve client message, starting server argument at defined port
        String message = receiveMessage(serverPort);

        //Print message recieved from client
        System.out.println("Client says: " + message);
        
        //Send message to client, starting server argument at defined port with message
        sendMessage(serverPort, "Hello Client - I see you!");
    }
    
    public static String receiveMessage(int portNumber) throws IOException{
        //Instantiate SSLSocketFactory to create ServerSocket with SSL comms.
        SSLServerSocketFactory socketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        
        //Create Socket object at defined port number
        SSLServerSocket serverSockObject =  (SSLServerSocket) socketFactory.createServerSocket(portNumber);
        
        //Launch server socket with port specified port parameter
        Socket socketObject = serverSockObject.accept();
        
        //Socket accepted by client - display successful connection
        System.out.println("Socket connected to client!");
        
        //Create new reader objects for input/output
        InputStreamReader inputObject = new InputStreamReader(socketObject.getInputStream());
        BufferedReader bufferObject = new BufferedReader(inputObject);

        //Close the socket session when the message has been recived
        serverSockObject.close();

        //Return the client output from bufferedreader object
        return bufferObject.readLine();
    }

    public static void sendMessage(int portNumber, String message) throws IOException{
        //Instantiate SSLSocketFactory to create ServerSocket with SSL comms.
        SSLServerSocketFactory socketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        
        //Create Socket object at defined port number
        SSLServerSocket serverSockObject =  (SSLServerSocket) socketFactory.createServerSocket(portNumber);
        
        //Launch server socket with port specified port parameter
        Socket socketObject = serverSockObject.accept();
        
        //Socket accepted by client - display successful connection
        System.out.println("Socket connected to client!");
        
        //Send a message to the client using the PrintWriter
        PrintWriter printObject = new PrintWriter(socketObject.getOutputStream());
        printObject.println(message);
        printObject.flush();

        //Close the socket session when the message has been sent over
        serverSockObject.close();
    }
    
}
