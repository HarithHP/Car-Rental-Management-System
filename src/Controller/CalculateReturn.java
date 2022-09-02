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


public class CalculateReturn {
    private int delaydays;
    private double delayfineday;
    public double delayfee;
    private double estimate;
    private double delayfine;
    public double tot;
    public CalculateReturn(int delaydays,double delayfineday){
        this.delaydays=delaydays;
        this.delayfineday=delayfineday; 
    }
    public double calDelay(){
        delayfee=delaydays*delayfineday;
         return delayfee;       
    }
    public void setTot(double estimate,double delayfine ){
        this.estimate=estimate;
        this.delayfine=delayfine;
    }
    public double calTot(){
        tot=estimate+delayfine;
        return tot;
    }
}
