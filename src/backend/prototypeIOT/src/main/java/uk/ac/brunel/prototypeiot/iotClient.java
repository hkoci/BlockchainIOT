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

        //Send message to server using the provided hostname/port arguments
        sendMessage(host,port,"Hello Server, do you see me?");
    }

    public static void receiveMessage(String hostName, int portNumber) throws IOException {
        //Create client socket connection to specified host/port
        Socket socketObject = new Socket(hostName, portNumber);
        
        //Create new reader objects for input/output
        InputStreamReader inputObject = new InputStreamReader(socketObject.getInputStream());
        BufferedReader bufferObject = new BufferedReader(inputObject);
        
        //Print the server output from bufferedreader object
        System.out.println("Server says: " + bufferObject.readLine());

        //Close the socket session when the message has been sent over
        socketObject.close();
    }

    public static void sendMessage(String hostName, int portNumber, String message) throws IOException {
        //Create client socket connection to specified host/port
        Socket socketObject = new Socket(hostName, portNumber);
        
        //Send a message to the server using the PrintWriter
        PrintWriter printObject = new PrintWriter(socketObject.getOutputStream());
        printObject.println(message);
        printObject.flush();

        //Close the socket session when the message has been sent over
        socketObject.close();
    }
}
