/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.ForgotPassword;
import View.Home;
import View.Login;
import static com.sun.glass.ui.Cursor.setVisible;
import java.awt.Component;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.mail.Session;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 *
 * @author Hadaragama
 */
public class ManageLoging {
    public int randomCode ;
    
    Connection con = SqlConnection.getCon();
    PreparedStatement pst = null;
    ResultSet rs = null;
    String user_name;
    String password;
    String email;
    String emaili;
    String pw;
    public void setInput(String user_name,String password ){
         
         this.user_name=user_name;
         this.password=password;
        }
    public void setInput(String email ){
         
         this.email=email;
        }
    public void setResetInput(String emaili,String pw ){
         
         this.emaili=emaili;
         this.pw=pw;
        }
    public void validateResetForm(){

         if(emaili.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter User Email");
        }else if(pw.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter User Password");
        }
        else{
            updateResetPassword();
        }  
       }
    public void validateForm(){

         if(user_name.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter User Name");
            new Login().setVisible(true);
        }else if(password.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter User Password");
            new Login().setVisible(true);
        }
        else{
            checkData();
        }  
       }
    public void validateEmailForm(){

         if(email.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter Email");
        }
        else{
             checkEmail(email);
        }  
       }
  public void checkEmail(String mailto){
        try {
            
            Random rand = new Random();
            randomCode = rand.nextInt(999999);
            System.out.println("Preparing to send mail");
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        
        String myEmail = "hphadaragama@gmail.com";
        String password="hpharith1234";
                Session session = Session.getInstance(properties, new Authenticator(){
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(myEmail,password);
                }

        });
        Message message = prepareMessage(session,myEmail,mailto,randomCode);
        Transport.send(message);
        JOptionPane.showMessageDialog(null,"Verify code has been sent to your Email \n Please check your Emails");
        
        } catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e);
        }               
    }
  private static Message prepareMessage(Session session, String myEmail, String mailto, int randomCode) throws MessagingException {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(mailto));
            message.setSubject("Use this code for reset your PASSWORD");
            message.setText("Your Verify Code : "+randomCode);
            return message;        
            
        } catch (Exception ex) {
            Logger.getLogger(ForgotPassword.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
  public int returncode(){

        return randomCode;
  }
   

    private void checkData(){
        try{String query = "select * from user where user_name=? and password=?";
            //con=DriverManager.getConnection("jdbc:mysql://localhost/forgotpassjava","root","");
            pst=con.prepareStatement(query);
            pst.setString(1,user_name);
            pst.setString(2,password);
            rs=pst.executeQuery();
            if(rs.next()){
            JOptionPane.showMessageDialog(null, "Login Successfully");
            new Home().setVisible(true);
            }else{
            JOptionPane.showMessageDialog(null, "username or password do not match");
            new Login().setVisible(true);
            }
    } catch (SQLException ex) {
            Logger.getLogger(ManageLoging.class.getName()).log(Level.SEVERE, null, ex);
            
            }           
    }
    private void updateResetPassword(){
        try{ String query = "UPDATE `user` SET `password`=? WHERE email=?"; 
           //con = DriverManager.getConnection("jdbc:mysql://localhost/harith","root","");
           pst = con.prepareStatement(query);
           pst.setString(1,pw);
           pst.setString(2,emaili);
           pst.executeUpdate();
             JOptionPane.showMessageDialog(null, "Reset Password Successful");
         }catch(SQLException | HeadlessException ex){
             JOptionPane.showMessageDialog(null, ex);
         }
    }

    
    
}
