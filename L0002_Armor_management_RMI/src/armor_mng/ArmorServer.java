/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armor_mng;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 *
 * @author winnh
 */
public class ArmorServer extends UnicastRemoteObject implements ArmorInterface {

    String filename="ArmorData.txt";

    public ArmorServer() throws RemoteException {
        super();
        this.filename = filename;
    }


    private Vector<ArmorDTO> getInitialData() {
        Vector<ArmorDTO> data = new Vector();
        try {
            FileReader f = new FileReader(filename);
            BufferedReader br = new BufferedReader(f);
            String line;
            StringTokenizer stk;
            String Id, classification, descrip, status;
            int defense;
            String date;
            while ((line = br.readLine()) != null) {
                stk = new StringTokenizer(line, ",");

                Id = stk.nextToken();
                classification = stk.nextToken();
                descrip = stk.nextToken();
                status = stk.nextToken();
                date = stk.nextToken();
                defense = Integer.parseInt(stk.nextToken());
//                Vector row=new Vector();
//                row.add(Id);
//                row.add(classification);
//                row.add(descrip);
//                row.add(status);
//                row.add(date);
//                row.add(defense);
                ArmorDTO dto= new ArmorDTO(Id, classification, descrip, status, date, defense);
                
                data.add(dto);

            }
            br.close();
            f.close();

        } catch (Exception e) {
        }

        return data;
    }

    private boolean save(Vector<ArmorDTO> data) {
        try {
            PrintWriter pw = new PrintWriter(filename);
            for (int i = 0; i < data.size(); i++) {
                ArmorDTO dto=data.get(i);
                String S="";
                S+=dto.getArmorID()+","+dto.getClassification()+","+dto.getDescription()+","+dto.getStatus()+","+dto.getTimeOfCreate()+","+dto.getDefense();
                pw.println(S);
                pw.flush();
                
            }
            pw.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean createArmor(ArmorDTO dto) {
        try {
            Vector<ArmorDTO> data = new Vector<>();
            data = getInitialData();
            data.add(dto);
            save(data);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public ArmorDTO findByArmorID(String id) {
        for (ArmorDTO dto: findAllArmor()) {
            if (id.equals(dto.getArmorID())) {
                return dto;
            }
        }
        return null;
    }

    @Override
    public List<ArmorDTO> findAllArmor() {
        List<ArmorDTO> list= new ArrayList<>();
        Vector<ArmorDTO> data=new Vector();
        data= getInitialData();
        for(int i=0;i<data.size();i++){
            ArmorDTO dto= data.get(i);
            list.add(dto);
        }
        return list;
    }

    @Override
    public boolean removeArmor(String id) {
        Vector<ArmorDTO> data = new Vector<>();
        data=getInitialData();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getArmorID().equals(id)) {
                data.remove(i);
            }
        }
        save(data);
        return true;
    }

    @Override
    public boolean updateArmor(ArmorDTO dto) {
        Vector<ArmorDTO> data = new Vector<>();
        data=getInitialData();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getArmorID().equals(dto.getArmorID())) {
                data.get(i).setClassification(dto.getClassification());
                data.get(i).setDescription(dto.getDescription());
                data.get(i).setStatus(dto.getStatus());
                data.get(i).setTimeOfCreate(dto.getTimeOfCreate());
                data.get(i).setDefense(dto.getDefense());
            }

        }
        save(data);
        return true;
    }
}
