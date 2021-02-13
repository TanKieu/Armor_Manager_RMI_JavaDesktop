/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armor_mng;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author winnh
 */
public interface ArmorInterface extends Remote{
    boolean createArmor(ArmorDTO dto)throws RemoteException;
    ArmorDTO findByArmorID(String id)throws RemoteException;
    Vector findAllArmor()throws RemoteException;
    boolean removeArmor(String id)throws RemoteException;
    boolean updateArmor(ArmorDTO dto)throws RemoteException;
}
