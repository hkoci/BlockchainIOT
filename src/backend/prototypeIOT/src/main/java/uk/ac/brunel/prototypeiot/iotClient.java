/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.brunel.prototypeiot;

//Import networking modules
import java.net.*;
import java.io.*;

/**
 *
 * @author Henri
 */
public class iotClient {
    
    public static void main(String[] args) throws IOException {

        //Server Vars
        String host = "localhost"; //hostname
        int port = 4999; //port number

        //Receive message from server using the provided hostname/port arguments
        receiveMessage(host,port);
    }

    public static void receiveMessage(String hostName, int portNumber) throws IOException {
        //Create client socket connection to localhost with port 4999
        Socket socketObject = new Socket(hostName, portNumber);
        
        //Send a message to the server using the PrintWriter
        PrintWriter printObject = new PrintWriter(socketObject.getOutputStream());
        printObject.println("Hello Server, do you see me?");
        printObject.flush();
        
        //Create new reader objects for input/output
        InputStreamReader inputObject = new InputStreamReader(socketObject.getInputStream());
        BufferedReader bufferObject = new BufferedReader(inputObject);
        
        //Print the server output from bufferedreader object
        System.out.println("Server says: " + bufferObject.readLine());

        //Close the socket session when the message has been sent over
        socketObject.close();
    }
}
