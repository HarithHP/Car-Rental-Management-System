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
public class ManageCustomer {
    Connection con = SqlConnection.getCon();
    PreparedStatement pst = null;
    ResultSet rs = null;
    
                String cus_id;
                String cus_name;
                String cus_contact;
                String cus_gender;
                String cus_email;
                String cus_address;
public void setInput(String cus_id,String cus_name,String cus_contact,String cus_gender,String cus_email,String cus_address){
       this.cus_id=cus_id;
       this.cus_name=cus_name;
       this.cus_contact=cus_contact;
       this.cus_gender=cus_gender;
       this.cus_email=cus_email;
       this.cus_address=cus_address;
     }
    
public void setInput(String cus_id){
           
          this.cus_id=cus_id;      
       }
  public  void validateInputForm(){
      
        if(cus_id.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter Customer ID");
        }else if(cus_name.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter Customer Name");
        }else if(cus_contact.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter Customer Contact No");
        }else if(cus_gender.equals("Select")){
            JOptionPane.showMessageDialog(null, "Please Select Cusomer Gender");
        }else if(cus_email.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter Customer Email");
        }else if(cus_address.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter Customer Address");
        }
        else{
            input();
        }
    }
private void input(){
        try{ String query = "INSERT INTO `customer`(`cus_id`, `cus_name`, `cus_contact`, `cus_gender`, `cus_email`, `cus_address`) VALUES (?,?,?,?,?,?)"; 
          // con = DriverManager.getConnection("jdbc:mysql://localhost/harith","root","");
           pst = con.prepareStatement(query);
           pst.setString(1,cus_id);
           pst.setString(2,cus_name);
           pst.setString(3,cus_contact);
           pst.setString(4,cus_gender);
           pst.setString(5,cus_email);
           pst.setString(6,cus_address);
           pst.executeUpdate();
             JOptionPane.showMessageDialog(null, "Customer Register Successfully");
         }catch(Exception ex){
             JOptionPane.showMessageDialog(null, ex);
         }
    }
public void validateUpdateForm(){
        
       if(cus_id.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter Customer ID");
        }else if(cus_name.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter Customer Name");
        }else if(cus_contact.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter Customer Contact No");
        }else if(cus_gender.equals("Select")){
            JOptionPane.showMessageDialog(null, "Please Select Cusomer Gender");
        }else if(cus_email.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter Customer Email");
        }else if(cus_address.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter Customer Address");
        }
        else{
            update();
        }
    }
    private void update(){
          try{
           String sql = "UPDATE customer SET cus_name=?,cus_contact=?,cus_gender=?,cus_email=?,cus_address=? WHERE cus_id=?";
           //con = DriverManager.getConnection("jdbc:mysql://localhost/harith","root","");
           pst = con.prepareStatement(sql);
           pst.setString(6,cus_id);
           pst.setString(1,cus_name);
           pst.setString(2,cus_contact);
           pst.setString(3,cus_gender);
           pst.setString(4,cus_email);
           pst.setString(5,cus_address);
           pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Customer Data Updated Successfully");
            }
                catch(SQLException | HeadlessException ex){
                JOptionPane.showMessageDialog(null, ex);
            }
    }
public void validateDeleteForm(){
        if(cus_id.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter Customer ID");
        }
        else{
            delete();
        }
    }
private void delete(){
        try{ String query = "DELETE FROM `customer` WHERE cus_id =?"; 
          // con = DriverManager.getConnection("jdbc:mysql://localhost/harith","root","");
           pst = con.prepareStatement(query);
           pst.setString(1,cus_id);
           pst.executeUpdate();
             JOptionPane.showMessageDialog(null, "Customer Data Delete Successfully");
         }catch(SQLException | HeadlessException ex){
             JOptionPane.showMessageDialog(null, ex);
         }
    }
}
