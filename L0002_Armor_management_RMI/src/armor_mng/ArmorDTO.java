/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armor_mng;
import java.util.Date;

/**
 *
 * @author winnh
 */
public class ArmorDTO {
    String ArmorID;
    String Classification;
    String Description;
    String status;
    String TimeOfCreate;
    int Defense;

    public ArmorDTO(String ArmorID, String Classification, String Description, String status, String TimeOfCreate, int Defense) {
        this.ArmorID = ArmorID;
        this.Classification = Classification;
        this.Description = Description;
        this.status = status;
        this.TimeOfCreate = TimeOfCreate;
        this.Defense= Defense;
    }

    public ArmorDTO() {
    }
    

    public String getArmorID() {
        return ArmorID;
    }

    public void setArmorID(String ArmorID) {
        this.ArmorID = ArmorID;
    }

    public String getClassification() {
        return Classification;
    }

    public void setClassification(String Classification) {
        this.Classification = Classification;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTimeOfCreate() {
        return TimeOfCreate;
    }

    public void setTimeOfCreate(String TimeOfCreate) {
        this.TimeOfCreate = TimeOfCreate;
    }

    public int getDefense() {
        return Defense;
    }

    public void setDefense(int Defense) {
        this.Defense = Defense;
    }

    @Override
    public String toString() {
        return   ArmorID + "," + Classification + "," + Description + "," + status + "," + TimeOfCreate + "," + Defense ;
    }
    
    
}
