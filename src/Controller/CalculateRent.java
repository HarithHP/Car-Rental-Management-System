/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Hadaragama
 */
public class CalculateRent {
     int days;
     double feeday;
    public double esti;
    public CalculateRent(int days,double feeday){
        this.days=days;
        this.feeday=feeday; 
    }
    public double calEstimate(){
        esti=days*feeday;
        return esti;
    }
    
    
}
