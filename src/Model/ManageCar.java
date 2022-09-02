/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author Hadaragama
 */
public class ManageCar {
    
    Connection con = SqlConnection.getCon();
    PreparedStatement pst = null;
    ResultSet rs = null;
   
        String car_id;
        String car_brand;
        String car_model;
        String car_feeday;
        String car_fineday;
        String car_availability;
       
       public void setInput(String car_id,String car_brand,String car_model,String car_feeday,String car_fineday,String car_availability){
         this.car_id=car_id;
         this.car_brand=car_brand;
         this.car_model=car_model;
         this.car_feeday=car_feeday;
         this.car_fineday=car_fineday;
         this.car_availability=car_availability;
        }
       public void setInput(String car_id){
           
           this.car_id=car_id;        
       }

        public void validateInputForm(){

        if(car_id.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter Car ID");
        }else if(car_brand.equals("Select")){
            JOptionPane.showMessageDialog(null, "Please Select Car Brand");
        }else if(car_model.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter Car Model");
        }else if(car_feeday.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter Fee for a Day");
        }else if(car_fineday.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter Fine for a Day");
        }else if(car_availability.equals("Select")){
            JOptionPane.showMessageDialog(null, "Please Eelect Availability");
        }
        else{
            input();
        }  
       }
   
      public void input(){
        try{ String query = "INSERT INTO `car`(`car_id`, `car_brand`, `car_model`, `car_feeday`, `car_fineday`, `car_availability`) VALUES (?,?,?,?,?,?)"; 
           pst = con.prepareStatement(query);
           pst.setString(1,car_id);
           pst.setString(2,car_brand);
           pst.setString(3,car_model);
           pst.setString(4,car_feeday);
           pst.setString(5,car_fineday);
           pst.setString(6,car_availability);
           pst.executeUpdate();
             JOptionPane.showMessageDialog(null, "Car Register Successfully");
         }catch(Exception ex){
             JOptionPane.showMessageDialog(null, ex);
         }
    }
        public void validateUpdateForm(){
                if(car_id.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter Car ID");
        }else if(car_brand.equals("Select")){
            JOptionPane.showMessageDialog(null, "Please Select Car Brand");
        }else if(car_model.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter Car Model");
        }else if(car_feeday.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter Fee for a Day");
        }else if(car_fineday.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter Fine for a Day");
        }else if(car_availability.equals("Select")){
            JOptionPane.showMessageDialog(null, "Please Eelect Availability");
        }
        else{
            update();
        }     
    }
        public void update(){
          try{
           String sql = "UPDATE car SET car_brand=?,car_model=?,car_feeday=?,car_fineday=?,car_availability=? WHERE car_id=?";
           //con = DriverManager.getConnection("jdbc:mysql://localhost/harith","root","");
           pst = con.prepareStatement(sql);
           pst.setString(6,car_id);
           pst.setString(1,car_brand);
           pst.setString(2,car_model);
           pst.setString(3,car_feeday);
           pst.setString(4,car_fineday);
           pst.setString(5,car_availability);
           pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Car Data Updated Successfully");
            }
                catch(SQLException | HeadlessException ex){
                JOptionPane.showMessageDialog(null, ex);
            }
    }
        public void validateDeleteForm(){
        if(car_id.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter Customer ID");
        }
        else{
            delete();
        }
    }
        
        public void delete(){
        try{ String query = "DELETE FROM `car` WHERE car_id =?"; 
           //con = DriverManager.getConnection("jdbc:mysql://localhost/harith","root","");
           pst = con.prepareStatement(query);
           pst.setString(1,car_id);
           pst.executeUpdate();
             JOptionPane.showMessageDialog(null, "Car Data Delete Successfully");
         }catch(SQLException | HeadlessException ex){
             JOptionPane.showMessageDialog(null, ex);
         }
    }
}
