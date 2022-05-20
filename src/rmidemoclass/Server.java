/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmidemoclass;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmidemo.HelloImpl;

/**
 *
 * @author Ly Quynh Tran
 */
public class Server {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(5000);
            
            try {
                Naming.rebind("rmi://localhost:5000/sayHello", new HelloImpl());
            } catch (MalformedURLException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
                System.out.println("Server ready");
        } catch (RemoteException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
}
