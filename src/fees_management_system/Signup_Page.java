/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fees_management_system;
//import com.sun.jdi.connect.spi.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;

//import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Gyanendra
 */
public class Signup_Page extends javax.swing.JFrame {
    
   String fname,lname,uname,passward,con_passward,contact_no;
   Date dob;
   int id=0;
     //Object DriverManager;
    
      
   
     //Creates new form Signup_Page
     
    public Signup_Page() {
        initComponents();
    }
    
    public int getId()
    {
         ResultSet rs=null; 
        try
        {
              
           Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
          Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/fees_management2","root","root");
          String sql="select max(id) from signup2";
           Statement st=con.createStatement();
                rs = st.executeQuery(sql);
          while (rs.next())
          {
            id=rs.getInt(1);
            id++;
          }
        }
            
          catch(Exception e)
                    {
                        e.printStackTrace();
                    }
        return id;
    }
    
    boolean validation()
    {
        
     fname=txt_fname.getText();
     lname=txt_last_name.getText();
     uname=txt_username.getText();
     passward=txt_passward.getText();
     con_passward=txt_con_passward.getText();
     contact_no=txt_contactno.getText();
     dob=txt_dob.getDate();
     
     if(fname.equals(""))
     {
         JOptionPane.showMessageDialog(this,"Please enter First name");
         return false;
     }
     if(lname.equals(""))
     {
         JOptionPane.showMessageDialog(this,"Please enter Lastname");
         return false;
     }
     if(uname.equals(""))
     {
         JOptionPane.showMessageDialog(this,"Please enter User name");
         return false;
     }
     if(passward.equals(""))
     {
         JOptionPane.showMessageDialog(this,"Please enter Passward");
         return false;
     }
     if(con_passward.equals(""))
     {
         JOptionPane.showMessageDialog(this,"Please enter Confirm Passward");
         return false;
     }
     if(contact_no.equals(""))
     {
         JOptionPane.showMessageDialog(this,"Please enter Contact no");
         return false;
     }
     if(  dob.equals(null))
     {
      JOptionPane.showMessageDialog(this,"Please enter Date of birth");
         return false;
      }
     if((!passward.equals(con_passward))){
         JOptionPane.showMessageDialog(this,"passward not mached");
         return false;
     }
    
     return true;
    }
    
    public void checkPassward(){
        passward=txt_passward.getText();
        if(passward.length()<8)
        {
            lbl_passward_error.setText("passward should be of 8 digits");
        }
        else
        {
           lbl_passward_error.setText(""); 
        }
    }
    
     public void checkContactNO(){
       contact_no=txt_contactno.getText();
        if(contact_no.length()==11)
        {
            lbl_contact_error.setText("");
        }
        else
        {
           lbl_contact_error.setText("Contact no should be 10 digits"); 
        }
    }
     
     void insertDetails(){
         SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
         String myDob=format.format(dob);
         try
         {
            // Scanner sc=new scanner(System.in);
          Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
         Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/fees_management2","root","root");
          String sql="insert into signup2 values(?,?,?,?,?,?,?)";
          PreparedStatement stmt=con.prepareStatement(sql);
          stmt.setInt(1,getId());
          stmt.setString(2,fname);
          stmt.setString(3,lname);
          stmt.setString(4,uname);
          stmt.setString(5,passward);
          stmt.setString(6,myDob);
          stmt.setString(7,contact_no);
          int i= stmt.executeUpdate();
          if(i>0)
          {
              JOptionPane.showMessageDialog(this,"record inserted");
          }
          else
          {
          JOptionPane.showMessageDialog(this,"record  not inserted");    
          }
         }
         catch(Exception e)
          {
           e.printStackTrace();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_contactno = new javax.swing.JTextField();
        txt_username = new javax.swing.JTextField();
        txt_fname = new javax.swing.JTextField();
        txt_last_name = new javax.swing.JTextField();
        txt_con_passward = new javax.swing.JPasswordField();
        txt_passward = new javax.swing.JPasswordField();
        btn_login = new javax.swing.JButton();
        btn_signup = new javax.swing.JButton();
        txt_dob = new com.toedter.calendar.JDateChooser();
        lbl_passward_error = new javax.swing.JLabel();
        lbl_contact_error = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(192, 65, 115));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 50, 242));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SIGN UP");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 20, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background images/signup back.jpg"))); // NOI18N
        jLabel9.setText("jLabel9");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 670, 430));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 90));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(0, 153, 153));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Username :");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 118, 124, 28));

        jLabel3.setBackground(new java.awt.Color(0, 153, 153));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText(" Last Name :");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 72, 124, 28));

        jLabel4.setBackground(new java.awt.Color(0, 153, 153));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText(" First Name :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 26, 124, 28));

        jLabel5.setBackground(new java.awt.Color(0, 153, 153));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("Confirm Passward :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 208, 179, 28));

        jLabel6.setBackground(new java.awt.Color(0, 153, 153));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("Passward :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 158, 124, 38));

        jLabel7.setBackground(new java.awt.Color(0, 153, 153));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("Contact no :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 289, 124, 28));

        jLabel8.setBackground(new java.awt.Color(0, 153, 153));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 0));
        jLabel8.setText("D.O.B :");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 249, 124, 28));

        txt_contactno.setBackground(new java.awt.Color(255, 204, 204));
        txt_contactno.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_contactno.setForeground(new java.awt.Color(255, 255, 255));
        txt_contactno.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 102)));
        txt_contactno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_contactnoActionPerformed(evt);
            }
        });
        txt_contactno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_contactnoKeyPressed(evt);
            }
        });
        jPanel2.add(txt_contactno, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 291, 134, -1));

        txt_username.setBackground(new java.awt.Color(255, 204, 204));
        txt_username.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_username.setForeground(new java.awt.Color(255, 255, 255));
        txt_username.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 102)));
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });
        jPanel2.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 112, 134, -1));

        txt_fname.setBackground(new java.awt.Color(255, 204, 204));
        txt_fname.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_fname.setForeground(new java.awt.Color(255, 255, 255));
        txt_fname.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 102)));
        txt_fname.setCaretColor(new java.awt.Color(0, 102, 102));
        txt_fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_fnameActionPerformed(evt);
            }
        });
        jPanel2.add(txt_fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 26, 134, -1));

        txt_last_name.setBackground(new java.awt.Color(255, 204, 204));
        txt_last_name.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_last_name.setForeground(new java.awt.Color(255, 255, 255));
        txt_last_name.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 102)));
        txt_last_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_last_nameActionPerformed(evt);
            }
        });
        jPanel2.add(txt_last_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 72, 134, -1));

        txt_con_passward.setBackground(new java.awt.Color(255, 204, 204));
        txt_con_passward.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_con_passward.setForeground(new java.awt.Color(255, 255, 255));
        txt_con_passward.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 102)));
        txt_con_passward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_con_passwardActionPerformed(evt);
            }
        });
        jPanel2.add(txt_con_passward, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 202, 134, -1));

        txt_passward.setBackground(new java.awt.Color(255, 204, 204));
        txt_passward.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_passward.setForeground(new java.awt.Color(255, 255, 255));
        txt_passward.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 102)));
        txt_passward.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_passwardKeyPressed(evt);
            }
        });
        jPanel2.add(txt_passward, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 157, 134, -1));

        btn_login.setBackground(new java.awt.Color(0, 0, 0));
        btn_login.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_login.setForeground(new java.awt.Color(255, 255, 255));
        btn_login.setText("Login");
        btn_login.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 204), null, null));
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });
        jPanel2.add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 380, -1, -1));

        btn_signup.setBackground(new java.awt.Color(0, 102, 102));
        btn_signup.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_signup.setForeground(new java.awt.Color(255, 255, 255));
        btn_signup.setText("Signup");
        btn_signup.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 0, 0), null, null));
        btn_signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_signupActionPerformed(evt);
            }
        });
        jPanel2.add(btn_signup, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 382, -1, -1));

        txt_dob.setBackground(new java.awt.Color(255, 204, 204));
        txt_dob.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 102)));
        jPanel2.add(txt_dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 251, 134, 28));

        lbl_passward_error.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_passward_error.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(lbl_passward_error, new org.netbeans.lib.awtextra.AbsoluteConstraints(413, 157, 247, 27));

        lbl_contact_error.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(lbl_contact_error, new org.netbeans.lib.awtextra.AbsoluteConstraints(413, 291, 247, 27));

        jLabel10.setBackground(new java.awt.Color(255, 204, 204));
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background images/signup back.jpg"))); // NOI18N
        jLabel10.setText("jLabel10");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 430));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 680, 430));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_contactnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_contactnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_contactnoActionPerformed

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void txt_fnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_fnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fnameActionPerformed

    private void txt_last_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_last_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_last_nameActionPerformed

    private void txt_con_passwardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_con_passwardActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_con_passwardActionPerformed

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_loginActionPerformed

    private void btn_signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_signupActionPerformed
      
        if(validation())
        {
            insertDetails();
        }
    }//GEN-LAST:event_btn_signupActionPerformed

    private void txt_passwardKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passwardKeyPressed
       checkPassward();
    }//GEN-LAST:event_txt_passwardKeyPressed

    private void txt_contactnoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_contactnoKeyPressed
        checkContactNO();
    }//GEN-LAST:event_txt_contactnoKeyPressed

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
            java.util.logging.Logger.getLogger(Signup_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Signup_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Signup_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Signup_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Signup_Page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_login;
    private javax.swing.JButton btn_signup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_contact_error;
    private javax.swing.JLabel lbl_passward_error;
    private javax.swing.JPasswordField txt_con_passward;
    private javax.swing.JTextField txt_contactno;
    private com.toedter.calendar.JDateChooser txt_dob;
    private javax.swing.JTextField txt_fname;
    private javax.swing.JTextField txt_last_name;
    private javax.swing.JPasswordField txt_passward;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables

    

    
}