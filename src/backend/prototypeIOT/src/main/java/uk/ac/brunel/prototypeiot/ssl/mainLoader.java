/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package uk.ac.brunel.prototypeiot.ssl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/**
 *
 * @author Henri
 */
public class mainLoader {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        /*SSLSocketFactory sslsocketfactory = SSLSocketFactory.getDefault();
        SSLSocket sslsocket = (SSLSocket) sslsocketfactory.createSocket("localhost", 4999);
        InputStream in = sslsocket.getInputStream();
        OutputStream out = sslsocket.getOutputStream();

        out.write(1);
        while (in.available() > 0) {
            System.out.print(in.read());
        }

        System.out.println("Secured connection performed successfully");*/
    }
    
}
