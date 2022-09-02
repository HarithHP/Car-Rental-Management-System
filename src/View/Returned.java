/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Controller.CalculateReturn;
import Model.ManageReturn;
import Model.SqlConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Hadaragama
 */
public class Returned extends javax.swing.JDialog {
    Connection con = SqlConnection.getCon();
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form Return
     */
    public Returned(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        fetchRent();
        fetchReturn();
    }
 
    private void fetchRentClick(){
       int row = tbl_rent.getSelectedRow();
       String tc =tbl_rent.getModel().getValueAt(row,0).toString();
       try{
           String query = "SELECT * FROM `rent` WHERE rent_id ="+tc+""; 
           //con = DriverManager.getConnection("jdbc:mysql://localhost/harith","root","");
           pst = con.prepareStatement(query);
           rs =pst.executeQuery();
           if(rs.next()){
                
                int rent_id=rs.getInt("car_id");
                int cus_id=rs.getInt("cus_id");
                String cus_name=rs.getString("cus_name");
                int car_id=rs.getInt("car_id");
                String car_brand=rs.getString("car_brand");
                String car_model=rs.getString("car_model");
                String car_feeday=rs.getString("car_feeday");
                String car_fineday=rs.getString("car_fineday");
                String no_days=rs.getString("no_days");
                String rentdate=rs.getString("rentdate");
                String returndate=rs.getString("returndate");
                String estimate=rs.getString("estimate");                             

                txt_carid.setText(""+car_id);
                txt_rentid.setText(""+rent_id);
                txt_cusid.setText(""+cus_id);
                txt_cusname.setText(cus_name);
                cmb_carbrand.setSelectedItem(car_brand);
                txt_carmodel.setText(car_model);
                txt_feeday.setText(car_feeday);
                txt_dayfine.setText(car_fineday);
                txt_nodays.setText(no_days);
                 txt_estifee.setText(estimate);
                ((JTextField)dtp_rentdate.getDateEditor().getUiComponent()).setText(rentdate);
                ((JTextField)dtp_returndate.getDateEditor().getUiComponent()).setText(returndate);               
           }           
       }catch(Exception ex){
         JOptionPane.showMessageDialog(null, ex);  
       }
    }
    private void fetchRent(){
        try{String query = "SELECT * FROM rent";
           //con = DriverManager.getConnection("jdbc:mysql://localhost/harith","root","");
           pst = con.prepareStatement(query);
           rs=pst.executeQuery();
           tbl_rent.setModel(DbUtils.resultSetToTableModel(rs));           
        }catch(Exception ex){
           JOptionPane.showMessageDialog(null, ex);          
        }        
    }
    private void fetchReturn(){
        try{String query = "SELECT * FROM returnt";
           con = DriverManager.getConnection("jdbc:mysql://localhost/harith","root","");
           pst = con.prepareStatement(query);
           rs=pst.executeQuery();
           tbl_renturn.setModel(DbUtils.resultSetToTableModel(rs));           
        }catch(Exception ex){
           JOptionPane.showMessageDialog(null, ex);          
        }        
    }
    private void clear(){
       txt_rentid.setText("");
       txt_cusid.setText("");
       txt_cusname.setText("");
       txt_carid.setText("");
       txt_carmodel.setText("");
       txt_feeday.setText("");
       txt_dayfine.setText("");
       cmb_carbrand.setSelectedIndex(0);
       txt_estifee.setText("");
       txt_nodays.setText("");
       dtp_rentdate.setDate(null);
       dtp_returndate.setDate(null);
       dtp_returned.setDate(null);
       txt_delaydays.setText("");
       txt_delayamount.setText("");
       txt_total.setText("");   
    }
    private void noDelayDaysCal(){
       try{
           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
           Date returnDate = dtp_returndate.getDate();
           Date returnedDate = dtp_returned.getDate();
           
           long diffInMillies = Math.abs(returnedDate.getTime()-returnDate.getTime());
           long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
           txt_delaydays.setText(String.valueOf(diff));
       }catch(Exception ex){
           JOptionPane.showMessageDialog(null, ex);
       }
   }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_total = new javax.swing.JTextField();
        lbl_carbrand = new javax.swing.JLabel();
        lbl_carmodel = new javax.swing.JLabel();
        lbl_feeday = new javax.swing.JLabel();
        lbl_fineday = new javax.swing.JLabel();
        lbl_rentdate = new javax.swing.JLabel();
        txt_dayfine = new javax.swing.JTextField();
        txt_nodays = new javax.swing.JTextField();
        txt_estifee = new javax.swing.JTextField();
        lbl_returndate = new javax.swing.JLabel();
        dtp_rentdate = new com.toedter.calendar.JDateChooser();
        lbl_nodays = new javax.swing.JLabel();
        dtp_returndate = new com.toedter.calendar.JDateChooser();
        lbl_esti = new javax.swing.JLabel();
        txt_rentid = new javax.swing.JTextField();
        txt_cusid = new javax.swing.JTextField();
        txt_cusname = new javax.swing.JTextField();
        dtp_returned = new com.toedter.calendar.JDateChooser();
        txt_carid = new javax.swing.JTextField();
        lbl_returneddate = new javax.swing.JLabel();
        cmb_carbrand = new javax.swing.JComboBox<>();
        lbl_delaydays = new javax.swing.JLabel();
        txt_carmodel = new javax.swing.JTextField();
        txt_delaydays = new javax.swing.JTextField();
        txt_feeday = new javax.swing.JTextField();
        lbl_delattotal = new javax.swing.JLabel();
        lbl_rentid = new javax.swing.JLabel();
        txt_delayamount = new javax.swing.JTextField();
        lbl_cusid = new javax.swing.JLabel();
        lbl_total = new javax.swing.JLabel();
        lbl_cusname = new javax.swing.JLabel();
        lbl_carid = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbl_renttable1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_renturn = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_rent = new javax.swing.JTable();
        lbl_renttable = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lbl_maintitle = new javax.swing.JLabel();
        lbl_close = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btn_cal = new javax.swing.JButton();
        btn_return = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1039, 529));

        jPanel1.setBackground(new java.awt.Color(173, 170, 168));

        txt_total.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N

        lbl_carbrand.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbl_carbrand.setText("Car Brand");

        lbl_carmodel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbl_carmodel.setText("Car Model");

        lbl_feeday.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbl_feeday.setText("Fee for a Day");

        lbl_fineday.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbl_fineday.setText("Fine for a Day");

        lbl_rentdate.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbl_rentdate.setText("Rent Date");

        txt_dayfine.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N

        txt_nodays.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        txt_nodays.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_nodaysMouseEntered(evt);
            }
        });
        txt_nodays.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nodaysActionPerformed(evt);
            }
        });

        txt_estifee.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N

        lbl_returndate.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbl_returndate.setText("Return Date");

        dtp_rentdate.setDateFormatString("yyyy-MM-dd");

        lbl_nodays.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbl_nodays.setText("No of Days");

        dtp_returndate.setDateFormatString("yyyy-MM-dd");
        dtp_returndate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dtp_returndateMouseClicked(evt);
            }
        });
        dtp_returndate.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                dtp_returndateInputMethodTextChanged(evt);
            }
        });

        lbl_esti.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbl_esti.setText("Estimate Bill");

        txt_rentid.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N

        txt_cusid.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N

        txt_cusname.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N

        dtp_returned.setDateFormatString("yyyy-MM-dd");
        dtp_returned.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dtp_returnedMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dtp_returnedMouseEntered(evt);
            }
        });
        dtp_returned.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dtp_returnedPropertyChange(evt);
            }
        });

        txt_carid.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N

        lbl_returneddate.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbl_returneddate.setText("Returned Date");

        cmb_carbrand.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "BMW", "Benz", "Toyota" }));

        lbl_delaydays.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbl_delaydays.setText("Delay Days");

        txt_carmodel.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N

        txt_delaydays.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N

        txt_feeday.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N

        lbl_delattotal.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbl_delattotal.setText("Total Delay Fee");

        lbl_rentid.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbl_rentid.setText("Rent ID");

        txt_delayamount.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N

        lbl_cusid.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbl_cusid.setText("Customer ID");

        lbl_total.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbl_total.setText("Total Bill Amount");

        lbl_cusname.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbl_cusname.setText("Customer Name");

        lbl_carid.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbl_carid.setText("Car ID");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_rentid)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(lbl_cusid)
                            .addGap(19, 19, 19))
                        .addComponent(lbl_returneddate))
                    .addComponent(lbl_cusname))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_cusname)
                        .addGap(22, 22, 22)
                        .addComponent(lbl_carmodel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_carmodel, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_rentid, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                .addComponent(txt_cusid))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dtp_returned, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_carid)
                                    .addComponent(lbl_carbrand))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cmb_carbrand, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_carid, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_delaydays)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_delaydays, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 24, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_rentdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dtp_rentdate, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_fineday)
                            .addComponent(lbl_feeday))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_dayfine, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_feeday, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_delattotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_delayamount, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lbl_returndate)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_esti, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_nodays)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbl_total)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_nodays)
                    .addComponent(dtp_returndate, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(txt_total)
                    .addComponent(txt_estifee))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(dtp_returndate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_nodays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_rentid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_rentid)
                                    .addComponent(lbl_carid))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_cusid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_cusid)
                                    .addComponent(lbl_carbrand)
                                    .addComponent(cmb_carbrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_fineday)
                                    .addComponent(txt_dayfine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_carid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_feeday)
                                    .addComponent(txt_feeday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_returndate))
                                .addGap(18, 18, 18)
                                .addComponent(lbl_nodays)))
                        .addGap(1, 1, 1)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_cusname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_cusname)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_estifee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_esti)))
                    .addComponent(dtp_rentdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_rentdate, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_carmodel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_carmodel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_returneddate, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(dtp_returned, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_delaydays)
                            .addComponent(txt_delaydays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_delattotal)
                            .addComponent(txt_delayamount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_total)
                            .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        jPanel2.setBackground(new java.awt.Color(173, 170, 168));

        lbl_renttable1.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        lbl_renttable1.setText("Return Table");

        tbl_renturn.setBackground(new java.awt.Color(165, 222, 232));
        tbl_renturn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_renturn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_renturnMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_renturn);

        tbl_rent.setBackground(new java.awt.Color(165, 222, 232));
        tbl_rent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_rent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_rentMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_rent);

        lbl_renttable.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        lbl_renttable.setText("Rent Table");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(506, 506, 506)
                .addComponent(lbl_renttable)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(502, 502, 502)
                        .addComponent(lbl_renttable1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lbl_renttable1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_renttable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(6, 159, 186));

        lbl_maintitle.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        lbl_maintitle.setText("Return Car ");

        lbl_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        lbl_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_closeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(429, Short.MAX_VALUE)
                .addComponent(lbl_maintitle)
                .addGap(442, 442, 442)
                .addComponent(lbl_close, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_maintitle)
                    .addComponent(lbl_close, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(173, 170, 168));

        btn_cal.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btn_cal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cal.png"))); // NOI18N
        btn_cal.setText("Calculate");
        btn_cal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_cal.setPreferredSize(new java.awt.Dimension(150, 30));
        btn_cal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calActionPerformed(evt);
            }
        });

        btn_return.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btn_return.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cl.png"))); // NOI18N
        btn_return.setText("Return Vehicle");
        btn_return.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_return.setPreferredSize(new java.awt.Dimension(150, 30));
        btn_return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_returnActionPerformed(evt);
            }
        });

        btn_clear.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btn_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close Jframe.png"))); // NOI18N
        btn_clear.setText("Clear");
        btn_clear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_clear.setPreferredSize(new java.awt.Dimension(150, 30));
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(btn_cal, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_return, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(147, 147, 147)
                .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_return, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nodaysMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_nodaysMouseEntered

    }//GEN-LAST:event_txt_nodaysMouseEntered

    private void txt_nodaysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nodaysActionPerformed

    }//GEN-LAST:event_txt_nodaysActionPerformed

    private void dtp_returndateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dtp_returndateMouseClicked

    }//GEN-LAST:event_dtp_returndateMouseClicked

    private void dtp_returndateInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_dtp_returndateInputMethodTextChanged

    }//GEN-LAST:event_dtp_returndateInputMethodTextChanged

    private void btn_calActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calActionPerformed
        noDelayDaysCal();
       int delaydays = Integer.parseInt(txt_delaydays.getText());
       double delayfineday =Double.parseDouble(txt_dayfine.getText());
       CalculateReturn cr = new CalculateReturn(delaydays,delayfineday);
       txt_delayamount.setText(""+cr.calDelay());
       double estimate =Double.parseDouble(txt_estifee.getText());
       double delayfine =Double.parseDouble(txt_delayamount.getText());
       cr.setTot(estimate, delayfine);
       txt_total.setText(""+cr.calTot());
       
    }//GEN-LAST:event_btn_calActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        clear();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void tbl_rentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_rentMouseClicked
        fetchRentClick();
    }//GEN-LAST:event_tbl_rentMouseClicked

    private void btn_returnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_returnActionPerformed
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        ManageReturn mr = new ManageReturn();
        mr.setInput(txt_rentid.getText(), txt_cusid.getText(), txt_cusname.getText(), txt_carid.getText(), cmb_carbrand.getSelectedItem().toString(), txt_carmodel.getText(), txt_feeday.getText(), txt_dayfine.getText(), sdf.format(dtp_rentdate.getDate()), sdf.format(dtp_returndate.getDate()), txt_nodays.getText(), txt_estifee.getText(), sdf.format(dtp_returned.getDate()), txt_delaydays.getText(), txt_delayamount.getText(), txt_total.getText());
        mr.validateInputForm();
        fetchReturn();
    }//GEN-LAST:event_btn_returnActionPerformed

    private void dtp_returnedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dtp_returnedMouseClicked
        
    }//GEN-LAST:event_dtp_returnedMouseClicked

    private void dtp_returnedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dtp_returnedMouseEntered
       
    }//GEN-LAST:event_dtp_returnedMouseEntered

    private void dtp_returnedPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dtp_returnedPropertyChange
       
    }//GEN-LAST:event_dtp_returnedPropertyChange

    private void tbl_renturnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_renturnMouseClicked

    }//GEN-LAST:event_tbl_renturnMouseClicked

    private void lbl_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_closeActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_lbl_closeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Returned.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Returned.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Returned.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Returned.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Returned dialog = new Returned(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cal;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_return;
    private javax.swing.JComboBox<String> cmb_carbrand;
    private com.toedter.calendar.JDateChooser dtp_rentdate;
    private com.toedter.calendar.JDateChooser dtp_returndate;
    private com.toedter.calendar.JDateChooser dtp_returned;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbl_carbrand;
    private javax.swing.JLabel lbl_carid;
    private javax.swing.JLabel lbl_carmodel;
    private javax.swing.JButton lbl_close;
    private javax.swing.JLabel lbl_cusid;
    private javax.swing.JLabel lbl_cusname;
    private javax.swing.JLabel lbl_delattotal;
    private javax.swing.JLabel lbl_delaydays;
    private javax.swing.JLabel lbl_esti;
    private javax.swing.JLabel lbl_feeday;
    private javax.swing.JLabel lbl_fineday;
    private javax.swing.JLabel lbl_maintitle;
    private javax.swing.JLabel lbl_nodays;
    private javax.swing.JLabel lbl_rentdate;
    private javax.swing.JLabel lbl_rentid;
    private javax.swing.JLabel lbl_renttable;
    private javax.swing.JLabel lbl_renttable1;
    private javax.swing.JLabel lbl_returndate;
    private javax.swing.JLabel lbl_returneddate;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JTable tbl_rent;
    private javax.swing.JTable tbl_renturn;
    private javax.swing.JTextField txt_carid;
    private javax.swing.JTextField txt_carmodel;
    private javax.swing.JTextField txt_cusid;
    private javax.swing.JTextField txt_cusname;
    private javax.swing.JTextField txt_dayfine;
    private javax.swing.JTextField txt_delayamount;
    private javax.swing.JTextField txt_delaydays;
    private javax.swing.JTextField txt_estifee;
    private javax.swing.JTextField txt_feeday;
    private javax.swing.JTextField txt_nodays;
    private javax.swing.JTextField txt_rentid;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables
}
