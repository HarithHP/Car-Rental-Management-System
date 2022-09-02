/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;


import Model.ManageCustomer;
import Model.SqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;


/**
 *
 * @author Hadaragama
 */
public class CustomerManage extends javax.swing.JDialog {
    Connection con = SqlConnection.getCon();
    PreparedStatement pst = null;
    ResultSet rs = null;
    

    /**
     * Creates new form CustomerManage
     */
    public CustomerManage(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        fetch();
    }
    private void fetch(){
        try{String query = "SELECT * FROM customer";
           //con = DriverManager.getConnection("jdbc:mysql://localhost/harith","root","");
           pst = con.prepareStatement(query);
           rs=pst.executeQuery();
           tbl_customer.setModel(DbUtils.resultSetToTableModel(rs));           
        }catch(Exception ex){
           JOptionPane.showMessageDialog(null, ex);          
        }        
    }
    private void fetchClick(){
               int row = tbl_customer.getSelectedRow();
       String tc =tbl_customer.getModel().getValueAt(row,0).toString();
       try{
           String query = "SELECT * FROM `customer` WHERE cus_id ="+tc+""; 
          // con = DriverManager.getConnection("jdbc:mysql://localhost/harith","root","");
           pst = con.prepareStatement(query);
           rs =pst.executeQuery();
           if(rs.next()){
                int cus_id=rs.getInt("cus_id");
                String cus_name=rs.getString("cus_name");
                String cus_contact=rs.getString("cus_contact");
                String cus_gender=rs.getString("cus_gender");
                String cus_email=rs.getString("cus_email");
                String cus_address=rs.getString("cus_address");
                
                txt_cusid.setText(""+cus_id);
                txt_cusname.setText(cus_name);
                txt_cuscontact.setText(cus_contact);
                combo_cusgender.setSelectedItem(cus_gender);
                txt_cusemail.setText(cus_email);
                txt_cusaddress.setText(cus_address);    
           }           
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

    private void clear(){
       txt_cusid.setText("");
       txt_cusname.setText("");
       txt_cuscontact.setText("");
       txt_cusemail.setText("");
       txt_cusaddress.setText("");
       combo_cusgender.setSelectedIndex(0);
    }
            
  
     
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_cusid = new javax.swing.JLabel();
        txt_cusid = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_customer = new javax.swing.JTable();
        txt_cusname = new javax.swing.JTextField();
        txt_cuscontact = new javax.swing.JTextField();
        combo_cusgender = new javax.swing.JComboBox<>();
        lbl_cusgender = new javax.swing.JLabel();
        lbl_cuscontact = new javax.swing.JLabel();
        lbl_cusname = new javax.swing.JLabel();
        lbl_cusemail = new javax.swing.JLabel();
        txt_cusemail = new javax.swing.JTextField();
        txt_cusaddress = new javax.swing.JTextField();
        lbl_cusaddress = new javax.swing.JLabel();
        btn_register = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lbl_cus_manage_titile = new javax.swing.JLabel();
        lbl_close = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(173, 170, 168));

        lbl_cusid.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbl_cusid.setText("Customer ID");

        txt_cusid.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        txt_cusid.setBorder(null);
        txt_cusid.setPreferredSize(new java.awt.Dimension(200, 25));
        txt_cusid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cusidActionPerformed(evt);
            }
        });
        txt_cusid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cusidKeyPressed(evt);
            }
        });

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

        txt_cusname.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        txt_cusname.setBorder(null);
        txt_cusname.setPreferredSize(new java.awt.Dimension(200, 25));

        txt_cuscontact.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        txt_cuscontact.setBorder(null);
        txt_cuscontact.setPreferredSize(new java.awt.Dimension(200, 25));

        combo_cusgender.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        combo_cusgender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Male", "Female" }));
        combo_cusgender.setBorder(null);
        combo_cusgender.setPreferredSize(new java.awt.Dimension(200, 25));

        lbl_cusgender.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbl_cusgender.setText("Gender");

        lbl_cuscontact.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbl_cuscontact.setText("Contact");

        lbl_cusname.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbl_cusname.setText("Customer Name");

        lbl_cusemail.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbl_cusemail.setText("Email");

        txt_cusemail.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        txt_cusemail.setBorder(null);
        txt_cusemail.setPreferredSize(new java.awt.Dimension(200, 25));

        txt_cusaddress.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        txt_cusaddress.setBorder(null);
        txt_cusaddress.setPreferredSize(new java.awt.Dimension(200, 25));

        lbl_cusaddress.setFont(new java.awt.Font("Yu Gothic UI", 1, 12)); // NOI18N
        lbl_cusaddress.setText("Address");

        btn_register.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btn_register.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btn_register.setText("Register");
        btn_register.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_register.setPreferredSize(new java.awt.Dimension(180, 30));
        btn_register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registerActionPerformed(evt);
            }
        });

        btn_update.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btn_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update.png"))); // NOI18N
        btn_update.setText("Update");
        btn_update.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_update.setPreferredSize(new java.awt.Dimension(180, 30));
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_delete.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        btn_delete.setText("Delete");
        btn_delete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_delete.setPreferredSize(new java.awt.Dimension(180, 30));
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_clear.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        btn_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close Jframe.png"))); // NOI18N
        btn_clear.setText("Clear");
        btn_clear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_clear.setPreferredSize(new java.awt.Dimension(180, 30));
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_cusaddress)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_cusaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_cusname)
                            .addComponent(lbl_cuscontact)
                            .addComponent(lbl_cusgender)
                            .addComponent(lbl_cusid)
                            .addComponent(lbl_cusemail))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_cusid, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo_cusgender, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_cusname, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_cuscontact, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_cusemail, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1)
                .addGap(25, 25, 25))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btn_register, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_cusid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_cusid))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_cusname)
                            .addComponent(txt_cusname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_cuscontact)
                            .addComponent(txt_cuscontact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combo_cusgender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_cusgender))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_cusemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_cusemail)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_cusaddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_cusaddress))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_register, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56))
        );

        jPanel2.setBackground(new java.awt.Color(6, 159, 186));
        jPanel2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N

        lbl_cus_manage_titile.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        lbl_cus_manage_titile.setText("Manage Customer Information");

        lbl_close.setBackground(new java.awt.Color(6, 159, 186));
        lbl_close.setForeground(new java.awt.Color(6, 159, 186));
        lbl_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        lbl_close.setBorder(null);
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
                .addGap(337, 337, 337)
                .addComponent(lbl_cus_manage_titile)
                .addGap(0, 342, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_close, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_close, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(lbl_cus_manage_titile)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(1024, 576));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void btn_registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registerActionPerformed
        ManageCustomer mc = new ManageCustomer();
        mc.setInput(txt_cusid.getText(), txt_cusname.getText(),txt_cuscontact.getText(), combo_cusgender.getSelectedItem().toString(), txt_cusemail.getText(),txt_cusaddress.getText());
        mc.validateInputForm();
        fetch();
        clear();
    }//GEN-LAST:event_btn_registerActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        ManageCustomer mc = new ManageCustomer();
        mc.setInput(txt_cusid.getText());
        mc.validateDeleteForm();
        fetch();
        clear();
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        ManageCustomer mc = new ManageCustomer();
        mc.setInput(txt_cusid.getText(), txt_cusname.getText(),txt_cuscontact.getText(), combo_cusgender.getSelectedItem().toString(), txt_cusemail.getText(),txt_cusaddress.getText());
        mc.validateUpdateForm();
        fetch();
        clear();
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
            clear();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void tbl_customerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_customerMouseClicked
        fetchClick();
    }//GEN-LAST:event_tbl_customerMouseClicked

    private void lbl_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_closeActionPerformed
        this.setVisible(false);
        
    }//GEN-LAST:event_lbl_closeActionPerformed

    private void txt_cusidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cusidKeyPressed
       char c = evt.getKeyChar();
           if(Character.isLetter(c))
           {
              JOptionPane.showMessageDialog(null,"This Field must have a Number");
           }
    }//GEN-LAST:event_txt_cusidKeyPressed

    private void txt_cusidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cusidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cusidActionPerformed

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
            java.util.logging.Logger.getLogger(CustomerManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerManage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CustomerManage dialog = new CustomerManage(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_register;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> combo_cusgender;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lbl_close;
    private javax.swing.JLabel lbl_cus_manage_titile;
    private javax.swing.JLabel lbl_cusaddress;
    private javax.swing.JLabel lbl_cuscontact;
    private javax.swing.JLabel lbl_cusemail;
    private javax.swing.JLabel lbl_cusgender;
    private javax.swing.JLabel lbl_cusid;
    private javax.swing.JLabel lbl_cusname;
    private javax.swing.JTable tbl_customer;
    private javax.swing.JTextField txt_cusaddress;
    private javax.swing.JTextField txt_cuscontact;
    private javax.swing.JTextField txt_cusemail;
    private javax.swing.JTextField txt_cusid;
    private javax.swing.JTextField txt_cusname;
    // End of variables declaration//GEN-END:variables
}