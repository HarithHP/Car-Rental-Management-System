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
public class ManageReturn{ 
    Connection con = SqlConnection.getCon();
    PreparedStatement pst = null;
    ResultSet rs = null;
                String return_id;
                String rent_id;
                String cus_id;
                String cus_name;
                String car_id;
                String car_brand;
                String car_model;
                String car_feeday;
                String car_fineday;
                String rentdate;
                String returndate;
                String no_days;
                String estimate;
                String returned_date;
                String delay_days;
                String delay_fee;
                String total;
 public void setInput(String rent_id,String cus_id,String cus_name,String car_id,String car_brand,String car_model,String car_feeday,String car_fineday,String rentdate ,String returndate ,String no_days, String estimate,String returned_date,String delay_days,String delay_fee,String total){
     this.return_id=return_id;
     this.rent_id=rent_id;
     this.cus_id=cus_id;
     this.cus_name=cus_name;
     this.car_id=car_id;
     this.car_brand=car_brand;
     this.car_model=car_model;
     this.car_feeday=car_feeday;
     this.car_fineday=car_fineday;
     this.rentdate=rentdate;
     this.returndate=returndate;
     this.no_days=no_days;
     this.estimate=estimate;
     this.returned_date=returned_date;
     this.delay_days=delay_days;
     this.delay_fee=delay_fee;
     this.total=total;
  } 
 public void validateInputForm(){
        
       if(rent_id.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter Rent ID");
        }else if(cus_id.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter Customer ID");
        }else if(cus_name.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter Customer Name");
        }else if(car_id.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter Car ID");
        }else if(car_brand.equals("Select")){
            JOptionPane.showMessageDialog(null, "Please Select Car Brand");
        }else if(car_model.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter Car Model");
        }else if(car_feeday.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter Fee for a Day");
        }else if(car_fineday.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter Fine for a Day");
        }else if(rentdate.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter Rent Date");
        }else if(returndate.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter Return Date");
        }else if(estimate.equals("")){
            JOptionPane.showMessageDialog(null, "Please Click Rent Table Row");
        }else if(no_days.equals("")){
            JOptionPane.showMessageDialog(null, "Please Click Rent Table Row ");
        }else if(returned_date.equals("")){
            JOptionPane.showMessageDialog(null, "Please Select Return Date");
        }else if(delay_days.equals("")){
            JOptionPane.showMessageDialog(null, "Please Click 'Calculate Button'");
        }else if(delay_fee.equals("")){
            JOptionPane.showMessageDialog(null, "Please Click 'Calculate Button'");
        }else if(total.equals("")){
            JOptionPane.showMessageDialog(null, "Please Click 'Calculate Button'");
        }
        else{
            inputRent();

        }  
       }
 private void inputRent(){
        try{ String query = "INSERT INTO `returnt`(`rent_id`, `cus_id`, `cus_name`, `car_id`, `car_brand`, `car_model`, `car_feeday`, `car_fineday`, `rentdate`, `returndate`, `no_days`, `estimate`, `returned_date`, `delay_days`, `delay_fee`, `total`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
           //con = DriverManager.getConnection("jdbc:mysql://localhost/harith","root","");
           pst = con.prepareStatement(query);
           //pst.setString(1,return_id);
           pst.setString(1,rent_id);
           pst.setString(2,cus_id);
           pst.setString(3,cus_name);
           pst.setString(4,car_id);
           pst.setString(5,car_brand);
           pst.setString(6,car_model);
           pst.setString(7,car_feeday);
           pst.setString(8,car_fineday);
           pst.setString(9,rentdate);
           pst.setString(10,returndate);
           pst.setString(11,no_days);
           pst.setString(12,estimate);
           pst.setString(13,returned_date);
           pst.setString(14,delay_days);
           pst.setString(15,delay_fee);
           pst.setString(16,total);
           pst.executeUpdate();
             JOptionPane.showMessageDialog(null, "Returned Successfully");
             changeCarAvailability();
         }catch(SQLException | HeadlessException ex){
             JOptionPane.showMessageDialog(null, ex);
         }
    }
  private void changeCarAvailability(){
        try{ String query = "UPDATE car SET`car_availability`= 'Yes' WHERE car_id =?"; 
           //con = DriverManager.getConnection("jdbc:mysql://localhost/harith","root","");
           pst = con.prepareStatement(query);
           pst.setString(1,car_id);
           pst.executeUpdate();
             JOptionPane.showMessageDialog(null, "Car Availability change Successfully");
         }catch(SQLException | HeadlessException ex){
             JOptionPane.showMessageDialog(null, ex);
         }
    }
 
                
    
}
