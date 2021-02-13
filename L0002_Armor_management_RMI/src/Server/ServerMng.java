/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import armor_mng.ArmorServer;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author winnh
 */
public class ServerMng {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String serviceName ="rmi://localhost:1123/ArmorInterface";
         ArmorServer server = null;
        try {
            LocateRegistry.createRegistry(1123);
            server = new ArmorServer();
            Naming.rebind(serviceName, server);
            System.out.println("Sercice " + serviceName + "is running.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
