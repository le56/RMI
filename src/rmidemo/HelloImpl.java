/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmidemo;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ly Quynh Tran
 */
public class HelloImpl extends UnicastRemoteObject implements IHello {

    public HelloImpl() throws RemoteException {
        super();

    }
    private static final long serialVersionUID = 1L;

    @Override
    public String sayHello(String name) throws RemoteException {
        System.out.println("Friend "+ name );
        return "Hello my friend" + name;
    }

    // public method to the server for client using
    public static void main(String[] args) {
        try {
            try {
                LocateRegistry.createRegistry(5000);
                Naming.rebind("rmi://localhost:5000/sayHello", new HelloImpl());
                System.out.println("Server ready");
            } catch (MalformedURLException ex) {
                Logger.getLogger(HelloImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(HelloImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
