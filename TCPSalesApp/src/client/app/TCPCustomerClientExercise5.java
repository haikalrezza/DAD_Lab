package client.app;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.List;

import client.view.CustomerViewer;
import model.Customer;

public class TCPCustomerClientExercise5 {


    public static void main(String[] args) {

        try {

            // Server information
            int serverPortNo = 8087;
            InetAddress serverAddress = InetAddress.getLocalHost();

            // 1. Connect to remote machine
            Socket socket = new Socket(serverAddress, serverPortNo);

            // Create stream to receive response from the server

            // get int input from user
            CustomerViewer customerViewer = new CustomerViewer();
            // int customerId = customerViewer.getCustomerId();

            // get customer object from server
            // Create stream to receive response from the server
            InputStream is = socket.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);

            // 3. Read respond from the server - cast the object
            // read customers object from server
            List<Customer> customers = (List<Customer>) ois.readObject();

            // display result
            customerViewer.displayResult(customers);

            // 4. Close connection
            socket.close();

        } catch (Exception ex) {

            ex.printStackTrace();

        }

    }
	
}
