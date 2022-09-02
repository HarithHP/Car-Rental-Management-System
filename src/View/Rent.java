/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Controller.CalculateRent;
import Model.ManageRent;
import Model.SqlConnection;
import java.sql.Connection;
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
public class Rent extends javax.swing.JDialog {
    Connection con = SqlConnection.getCon();
    PreparedStatement pst = null;
    ResultSet rs = null;
    /**
     * Creates new form Rent
     */
    public Rent(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        fetchCustomer();
        fetchCar();
        fetchRent();
    }
   private void fetchCustomer(){
           try{String query = "SELECT * FROM customer";
           //con = DriverManager.getConnection("jdbc:mysql://localhost/harith","root","");
           pst = con.prepareStatement(query);
           rs=pst.executeQuery();
           tbl_customer.setModel(DbUtils.resultSetToTableModel(rs));           
           }catch(Exception ex){
           JOptionPane.showMessageDialog(null, ex);          
         }        
    }
   private void fetchCar(){
        try{String query = "SELECT `car_id`, `car_brand`, `car_model`, `car_feeday`, `car_fineday` FROM `car` WHERE car_availability ='Yes'";
           //con = DriverManager.getConnection("jdbc:mysql://localhost/harith","root","");
           pst = con.prepareStatement(query);
           rs=pst.executeQuery();
           tbl_car.setModel(DbUtils.resultSetToTableModel(rs));           
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
    private void fetchCustomerClick(){
       int row = tbl_customer.getSelectedRow();
       String tc =tbl_customer.getModel().getValueAt(row,0).toString();
       try{
           String query = "SELECT * FROM `customer` WHERE cus_id ="+tc+""; 
           //con = DriverManager.getConnection("jdbc:mysql://localhost/harith","root","");
           pst = con.prepareStatement(query);
           rs =pst.executeQuery();
           if(rs.next()){
                int cus_id=rs.getInt("cus_id");
                String cus_name=rs.getString("cus_name");
                
                txt_cusid.setText(""+cus_id);
                txt_cusname.setText(cus_name);               
           }           
       }catch(Exception ex){
         JOptionPane.showMessageDialog(null, ex);  
       }
    }
   private void fetchCarClick(){
       int row = tbl_car.getSelectedRow();
       String tc =tbl_car.getModel().getValueAt(row,0).toString();
       try{
           String query = "SELECT * FROM `car` WHERE car_id ="+tc+""; 
           //con = DriverManager.getConnection("jdbc:mysql://localhost/harith","root","");
           pst = con.prepareStatement(query);
           rs =pst.executeQuery();
           if(rs.next()){
                int car_id=rs.getInt("car_id");
                String car_brand=rs.getString("car_brand");
                String car_model=rs.getString("car_model");
                String car_fee=rs.getString("car_feeday");
                String car_fine=rs.getString("car_fineday");
                String car_availability=rs.getString("car_availability");
                
                txt_carid.setText(""+car_id);
                cmb_carbrand.setSelectedItem(car_brand);
                txt_carmodel.setText(car_model);
                txt_feeday.setText(car_fee);
                txt_dayfine.setText(car_fine);
           }           
       }catch(Exception ex){
         JOptionPane.showMessageDialog(null, ex);  
       }
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
   private void noDaysCal(){
       try{
           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
           Date rentDate = dtp_rentdate.getDate();
           Date returnDate = dtp_returndate.getDate();
           
           long diffInMillies = Math.abs(returnDate.getTime()-rentDate.getTime());
           long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
           txt_nodays.setText(String.valueOf(diff));
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
       
    }
   public void setDates(){

           
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
        txt_cusid = new javax.swing.JTextField();
        txt_cusname = new javax.swing.JTextField();
        txt_carid = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_rent = new javax.swing.JTable();
        cmb_carbrand = new javax.swing.JComboBox<>();
        txt_carmodel = new javax.swing.JTextField();
        txt_feeday = new javax.swing.JTextField();
        lbl_renttable = new javax.swing.JLabel();
        txt_dayfine = new javax.swing.JTextField();
        lbl_custable_title = new javax.swing.JLabel();
        txt_nodays = new javax.swing.JTextField();
        lbl_cartable_title = new javax.swing.JLabel();
        txt_estifee = new javax.swing.JTextField();
        lbl_rentid = new javax.swing.JLabel();
        dtp_rentdate = new com.toedter.calendar.JDateChooser();
        lbl_cusid = new javax.swing.JLabel();
        lbl_cusname = new javax.swing.JLabel();
        dtp_returndate = new com.toedter.calendar.JDateChooser();
        btn_cal = new javax.swing.JButton();
        lbl_carid = new javax.swing.JLabel();
        btn_rent = new javax.swing.JButton();
        lbl_carbrand = new javax.swing.JLabel();
        btn_clear = new javax.swing.JButton();
        lbl_carmodel = new javax.swing.JLabel();
        lbl_feeday = new javax.swing.JLabel();
        lbl_fineday = new javax.swing.JLabel();
        lbl_rentdate = new javax.swing.JLabel();
        lbl_returndate = new javax.swing.JLabel();
        lbl_nodays = new javax.swing.JLabel();
        lbl_esti = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_customer = new javax.swing.JTable();
        txt_rentid = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_car = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        lbl_rent_title = new javax.swing.JLabel();
        lbl_close = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1024, 590));
        setMinimumSize(new java.awt.Dimension(1024, 590));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(173, 170, 168));
        jPanel1.setPreferredSize(new java.awt.Dimension(1024, 576));

        txt_cusid.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        txt_cusid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cusidKeyPressed(evt);
            }
        });

        txt_cusname.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N

        txt_carid.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        txt_carid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_caridKeyPressed(evt);
            }
        });

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

        cmb_carbrand.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        cmb_carbrand.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "BMW", "Benz", "Toyota" }));

        txt_carmodel.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N

        txt_feeday.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N

        lbl_renttable.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        lbl_renttable.setText("Rent Table");

        txt_dayfine.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N

        lbl_custable_title.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        lbl_custable_title.setText("Customer Table");

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

        lbl_cartable_title.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        lbl_cartable_title.setText("Available Car Table");

        txt_estifee.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N

        lbl_rentid.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbl_rentid.setText("Rent ID");

        dtp_rentdate.setDateFormatString("yyyy-MM-dd");

        lbl_cusid.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbl_cusid.setText("Customer ID");

        lbl_cusname.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbl_cusname.setText("Customer Name");

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

        btn_cal.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btn_cal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cal.png"))); // NOI18N
        btn_cal.setText("Calculate");
        btn_cal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_cal.setPreferredSize(new java.awt.Dimension(120, 30));
        btn_cal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calActionPerformed(evt);
            }
        });

        lbl_carid.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbl_carid.setText("Car ID");

        btn_rent.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btn_rent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/calre.png"))); // NOI18N
        btn_rent.setText("Rent");
        btn_rent.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_rent.setPreferredSize(new java.awt.Dimension(120, 30));
        btn_rent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rentActionPerformed(evt);
            }
        });

        lbl_carbrand.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbl_carbrand.setText("Car Brand");

        btn_clear.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btn_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close Jframe.png"))); // NOI18N
        btn_clear.setText("Clear");
        btn_clear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_clear.setPreferredSize(new java.awt.Dimension(120, 30));
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        lbl_carmodel.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbl_carmodel.setText("Car Model");

        lbl_feeday.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbl_feeday.setText("Fee for a Day");

        lbl_fineday.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbl_fineday.setText("Fine for a Day");

        lbl_rentdate.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbl_rentdate.setText("Rent Date");

        lbl_returndate.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbl_returndate.setText("Return Date");

        lbl_nodays.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbl_nodays.setText("No of Days");

        lbl_esti.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbl_esti.setText("Estimate Bill");

        tbl_customer.setBackground(new java.awt.Color(165, 222, 232));
        tbl_customer.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_customer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_customerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_customer);

        txt_rentid.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        txt_rentid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_rentidKeyPressed(evt);
            }
        });

        tbl_car.setBackground(new java.awt.Color(165, 222, 232));
        tbl_car.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_car.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_carMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_car);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_cusname)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_cusid)
                                    .addComponent(lbl_rentid))
                                .addGap(222, 222, 222))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_carid)
                                    .addComponent(lbl_carmodel)))
                            .addComponent(lbl_carbrand))
                        .addGap(95, 95, 95)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_cusname, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cmb_carbrand, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_carid)
                                .addComponent(txt_carmodel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_rentid, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_cusid, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_feeday)
                                    .addComponent(lbl_returndate))
                                .addGap(79, 79, 79))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbl_fineday, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_esti, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_nodays, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_rentdate, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_estifee)
                            .addComponent(txt_nodays, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dtp_returndate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dtp_rentdate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_dayfine, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_feeday, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(317, 317, 317)
                        .addComponent(lbl_custable_title, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(325, 325, 325)
                                .addComponent(lbl_renttable, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(105, 105, 105)
                                .addComponent(btn_cal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(108, 108, 108)
                                .addComponent(btn_rent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(99, 99, 99)
                                .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_cartable_title, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(250, 250, 250))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_renttable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_custable_title)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_cartable_title)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_rentid)
                            .addComponent(txt_rentid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_cusid)
                            .addComponent(txt_cusid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_cusname)
                            .addComponent(txt_cusname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_carid)
                            .addComponent(txt_carid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmb_carbrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_carbrand))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_carmodel)
                            .addComponent(txt_carmodel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_feeday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_feeday))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_dayfine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_fineday))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(dtp_rentdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_rentdate)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_returndate)
                            .addComponent(dtp_returndate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_nodays)
                            .addComponent(txt_nodays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_esti)
                        .addComponent(txt_estifee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_rent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(94, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(6, 159, 186));

        lbl_rent_title.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        lbl_rent_title.setText("Rent A Car");

        lbl_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        lbl_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_closeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_rent_title)
                .addGap(408, 408, 408)
                .addComponent(lbl_close, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_rent_title)
                    .addComponent(lbl_close, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1024, 576));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_customerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_customerMouseClicked
        fetchCustomerClick();
    }//GEN-LAST:event_tbl_customerMouseClicked

    private void tbl_carMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_carMouseClicked
        fetchCarClick();
    }//GEN-LAST:event_tbl_carMouseClicked

    private void dtp_returndateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dtp_returndateMouseClicked
        
    }//GEN-LAST:event_dtp_returndateMouseClicked

    private void dtp_returndateInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_dtp_returndateInputMethodTextChanged
        
    }//GEN-LAST:event_dtp_returndateInputMethodTextChanged

    private void txt_nodaysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nodaysActionPerformed
        
    }//GEN-LAST:event_txt_nodaysActionPerformed

    private void txt_nodaysMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_nodaysMouseEntered
        
    }//GEN-LAST:event_txt_nodaysMouseEntered

    private void btn_calActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calActionPerformed
        noDaysCal();
        int days = Integer.parseInt(txt_nodays.getText());
        double feeday =Double.parseDouble(txt_feeday.getText());
        CalculateRent cr = new CalculateRent(days,feeday);
        txt_estifee.setText(""+cr.calEstimate());
        
    }//GEN-LAST:event_btn_calActionPerformed

    private void btn_rentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rentActionPerformed
         //validateInputForm();clear();
           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
           ManageRent mr = new ManageRent();
           mr.setInput(txt_rentid.getText(), txt_cusid.getText(),txt_cusname.getText(),txt_carid.getText(),cmb_carbrand.getSelectedItem().toString(),txt_carmodel.getText(),txt_feeday.getText(),txt_dayfine.getText(),sdf.format(dtp_rentdate.getDate()),sdf.format(dtp_returndate.getDate()), txt_nodays.getText(),txt_estifee.getText());
           mr.validateInputForm();
           fetchCar();
           fetchRent();
           clear();
    }//GEN-LAST:event_btn_rentActionPerformed

    private void tbl_rentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_rentMouseClicked
        //fetchRentClick();
    }//GEN-LAST:event_tbl_rentMouseClicked

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        clear();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void lbl_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_closeActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_lbl_closeActionPerformed

    private void txt_rentidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_rentidKeyPressed
       char c = evt.getKeyChar();
           if(Character.isLetter(c))
           {
              JOptionPane.showMessageDialog(null,"This Field must have a Number");
           }
    }//GEN-LAST:event_txt_rentidKeyPressed

    private void txt_cusidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cusidKeyPressed
        char c = evt.getKeyChar();
           if(Character.isLetter(c))
           {
              JOptionPane.showMessageDialog(null,"This Field must have a Number");
           }
    }//GEN-LAST:event_txt_cusidKeyPressed

    private void txt_caridKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_caridKeyPressed
        char c = evt.getKeyChar();
           if(Character.isLetter(c))
           {
              JOptionPane.showMessageDialog(null,"This Field must have a Number");
           }
    }//GEN-LAST:event_txt_caridKeyPressed

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
            java.util.logging.Logger.getLogger(Rent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Rent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Rent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Rent dialog = new Rent(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btn_rent;
    private javax.swing.JComboBox<String> cmb_carbrand;
    private com.toedter.calendar.JDateChooser dtp_rentdate;
    private com.toedter.calendar.JDateChooser dtp_returndate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_carbrand;
    private javax.swing.JLabel lbl_carid;
    private javax.swing.JLabel lbl_carmodel;
    private javax.swing.JLabel lbl_cartable_title;
    private javax.swing.JButton lbl_close;
    private javax.swing.JLabel lbl_cusid;
    private javax.swing.JLabel lbl_cusname;
    private javax.swing.JLabel lbl_custable_title;
    private javax.swing.JLabel lbl_esti;
    private javax.swing.JLabel lbl_feeday;
    private javax.swing.JLabel lbl_fineday;
    private javax.swing.JLabel lbl_nodays;
    private javax.swing.JLabel lbl_rent_title;
    private javax.swing.JLabel lbl_rentdate;
    private javax.swing.JLabel lbl_rentid;
    private javax.swing.JLabel lbl_renttable;
    private javax.swing.JLabel lbl_returndate;
    private javax.swing.JTable tbl_car;
    private javax.swing.JTable tbl_customer;
    private javax.swing.JTable tbl_rent;
    private javax.swing.JTextField txt_carid;
    private javax.swing.JTextField txt_carmodel;
    private javax.swing.JTextField txt_cusid;
    private javax.swing.JTextField txt_cusname;
    private javax.swing.JTextField txt_dayfine;
    private javax.swing.JTextField txt_estifee;
    private javax.swing.JTextField txt_feeday;
    private javax.swing.JTextField txt_nodays;
    private javax.swing.JTextField txt_rentid;
    // End of variables declaration//GEN-END:variables
}
