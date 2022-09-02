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
public class ManageUser {
    Connection con = SqlConnection.getCon();
    PreparedStatement pst = null;
    ResultSet rs = null;
    
        String user_id;
        String user_name;
        String email;
        String password;
       
       public void setInput(String user_id,String user_name,String email,String password){
         this.user_id=user_id;
         this.user_name=user_name;
         this.email=email;
         this.password=password;
        }
       public void setInput(String user_id){
           
           this.user_id=user_id;        
       }

        public void validateInputForm(){

        /*if(user_id.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter User ID");
        }else*/ if(user_name.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter User Name");
        }else if(email.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter Email");
        }else if(password.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter Password");
        }
        else{
            input();
        }  
       }
   
      public void input(){
        try{ String query = "INSERT INTO `user`(`user_name`, `email`, `password`) VALUES (?,?,?)"; 
           pst = con.prepareStatement(query);
           pst.setString(1,user_name);
           pst.setString(2,email);
           pst.setString(3,password);
           pst.executeUpdate();
             JOptionPane.showMessageDialog(null, "User Register Successfully");
         }catch(Exception ex){
             JOptionPane.showMessageDialog(null, ex);
         }
    }
        public void validateUpdateForm(){
        if(user_id.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter User ID");
        }else if(user_name.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter User Name");
        }else if(email.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter Email");
        }else if(password.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter Password");
        }
        else{
            update();
        }     
    }
        public void update(){
          try{
           String sql = "UPDATE `user` SET `user_name`=?,`email`=?,`password`=? WHERE user_id= ?";
           //con = DriverManager.getConnection("jdbc:mysql://localhost/harith","root","");
           pst = con.prepareStatement(sql);
           pst.setString(4,user_id);
           pst.setString(1,user_name);
           pst.setString(2,email);
           pst.setString(3,password);
           pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "User Data Updated Successfully");
            }
                catch(SQLException | HeadlessException ex){
                JOptionPane.showMessageDialog(null, ex);
            }
    }
        public void validateDeleteForm(){
        if(user_id.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter User ID");
        }
        else{
            delete();
        }
    }
        
        public void delete(){
        try{ String query = "DELETE FROM `user` WHERE user_id =?"; 
           //con = DriverManager.getConnection("jdbc:mysql://localhost/harith","root","");
           pst = con.prepareStatement(query);
           pst.setString(1,user_id);
           pst.executeUpdate();
             JOptionPane.showMessageDialog(null, "User Data Delete Successfully");
         }catch(SQLException | HeadlessException ex){
             JOptionPane.showMessageDialog(null, ex);
         }
    }
}
    

