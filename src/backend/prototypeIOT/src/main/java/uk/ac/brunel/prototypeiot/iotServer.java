/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package uk.ac.brunel.prototypeiot;

//Import networking modules
import java.io.*;
import java.net.*;

/**
 *
 * @author Henri
 */
public class iotServer {

    public static void main(String[] args) throws IOException {
        //Create server socket with port 4999
        ServerSocket serverSockObject = new ServerSocket(4999);
        Socket socketObject = serverSockObject.accept();
        
        //Socket accepted by client - display successful connection
        System.out.println("Socket connected to client!");
        
        //Create new reader objects for input/output
        InputStreamReader inputObject = new InputStreamReader(socketObject.getInputStream());
        BufferedReader bufferObject = new BufferedReader(inputObject);
        
        //Print the client output from bufferedreader object
        System.out.println("Client says: " + bufferObject.readLine());
        
        //Send a message to the client using the PrintWriter
        PrintWriter printObject = new PrintWriter(socketObject.getOutputStream());
        printObject.println("Hello Client - I see you!");
        printObject.flush();
        
    }
    
}
