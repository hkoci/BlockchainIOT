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

        //Recieve client message, starting server argument at port 4999
        String message = receiveMessage(4999);

        //Print message recieved from client
        System.out.println("Client says: " + message);
        
        //Send message to client, starting server argument at port 4999 and with message arg.
        sendMessage(4999, "Hello Client - I see you!");
    }

    public static String receiveMessage(int portNumber) throws IOException{
        //Create server socket with port specified port parameter
        ServerSocket serverSockObject = new ServerSocket(portNumber);
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
        //Create server socket with port 4999
        ServerSocket serverSockObject = new ServerSocket(portNumber);
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
