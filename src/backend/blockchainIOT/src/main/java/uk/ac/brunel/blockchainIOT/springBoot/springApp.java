package uk.ac.brunel.blockchainIOT.springBoot;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uk.ac.brunel.blockchainIOT.edgeClient.iotServer;

@SpringBootApplication
public class springApp {

    public static void main(String[] args) {
        SpringApplication.run(springApp.class, args);
        
        //Run the server continuously.

            try {
                iotServer.main(args);
            } catch (IOException ex) {
                Logger.getLogger(springApp.class.getName()).log(Level.SEVERE, null, ex);
            }

    }
}