/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package uk.ac.brunel.prototypeiot.ssl;

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
    }
    
}
