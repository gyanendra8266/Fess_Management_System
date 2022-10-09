/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fees_management_system;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;

/**
 *
 * @author Gyanendra
 */
public class add_fees extends javax.swing.JFrame {

    /**
     * Creates new form add_fees
     */
    public add_fees() {
        initComponents();
        displayCashFirst();
        fillComboBox();
        int receiptNo=getReceiptNO();
        txt_receipt_no.setText(Integer.toString(receiptNo));
    }
    public void displayCashFirst(){
        lbl_dd_no.setVisible(false);
        lbl_check_no.setVisible(false);
        lbl_bank_name.setVisible(false);
        txt_dd.setVisible(false);
        txt_check_no.setVisible(false);
        txt_bank_name.setVisible(false);
        
    }
    public boolean validation(){
        if(txt_received_form.getText().equals("")){
          JOptionPane.showMessageDialog(this,"Please enter a received  name");
          return false;
        }
        if(date_choser.getDate()==null){
          JOptionPane.showMessageDialog(this,"Please enter a date");
          return false;
        }
        if(txt_amount.getText().equals("") || txt_amount.getText().matches("[0-9]+") ==false){
          JOptionPane.showMessageDialog(this,"Please enter amount in numbers");
          return false;  
        }
        if(combo_payment_mode.getSelectedItem().toString().equalsIgnoreCase("cheque")){
        if(txt_check_no.getText().equals("")){
           JOptionPane.showMessageDialog(this,"Please enter check numbers");
          return false; 
        }
        if(txt_bank_name.getText().equals("")){
           JOptionPane.showMessageDialog(this,"Please enter bank name");
          return false; 
        }
            
    }
        if(combo_payment_mode.getSelectedItem().toString().equalsIgnoreCase("dd")){
         if(txt_dd.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Please enter dd numbers");
          return false;   
         }  
         if(txt_bank_name.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Please enter bank name");
          return false;   
         }   
        }
         if(combo_payment_mode.getSelectedItem().toString().equalsIgnoreCase("card")){
           if(txt_bank_name.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Please enter bank name");
          return false;  
           }
            
         }
        //else{
        //JOptionPane.showMessageDialog(this,"Validation successful");

        return true;
    }
       public void fillComboBox(){
           try{
              Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
         Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/fees_management2","root","root");  
            PreparedStatement pst=con.prepareStatement("select course_name from course");
           ResultSet rs=pst.executeQuery();
           while(rs.next()){
               combo_course.addItem(rs.getString("course_name"));
           }
           }
           catch(Exception e){
             e.printStackTrace();
           }
       }
       
       public int getReceiptNO(){
          int receiptNO=0;
           try{
             Connection con=DBConnection.getConnection();
              PreparedStatement pst=con.prepareStatement("select max(reciept_no) from fees_Details");
              ResultSet rs = pst.executeQuery();
              if(rs.next()==true){
                 receiptNO= rs.getInt(1);
              }
          } catch(Exception e){
              e.printStackTrace();
          }
           return receiptNO+1;
       }
       
       public String insertData(){
           String status="";
        int recieptNo=Integer.parseInt(txt_receipt_no.getText());
        String studentName=txt_received_form.getText();
        String rollNo=(txt_rollno.getText());
       String paymentMode=combo_payment_mode.getSelectedItem().toString();
       String chequeNo=txt_check_no.getText();
       String bankName=txt_bank_name.getText();
       String ddno=txt_dd.getText();
       String coursename=txt_course_name.getText();
       String gstin=txt_gst_no.getText();
       float totalAmount=Float.parseFloat(txt_total.getText());
       SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
       String date=dateFormat.format(date_choser.getDate());
       float initialAmount=Float.parseFloat(txt_amount.getText());
       float cgst=Float.parseFloat(txt_cgst.getText());
       float sgst=Float.parseFloat(txt_sgst.getText());
       String totalInWords=txt_totalinwords.getText();
       String remark=txt_remark.getText();
       int year1=Integer.parseInt(txt_year1.getText());
        int year2=Integer.parseInt(txt_year2.getText());
        
       try{
           Connection con=DBConnection.getConnection();
           PreparedStatement pst=con.prepareStatement("insert into fees_details values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
           pst.setInt(1,recieptNo);
           pst.setString(2,studentName);
           pst.setString(3,rollNo);
           pst.setString(4,paymentMode);
          pst.setString(5,chequeNo);
          pst.setString(6,bankName);
          pst.setString(7,ddno);
          pst.setString(8,coursename);
          pst.setString(9,gstin);
          pst.setFloat(10,totalAmount);
          pst.setString(11,date);
          pst.setFloat(12,initialAmount);
          pst.setFloat(13,cgst);
          pst.setFloat(14,sgst);
          pst.setString(15,totalInWords);
          pst.setString(16,remark);
          pst.setInt(17,year1);
          pst.setInt(18,year2);
          int rowCount=pst.executeUpdate();
          if(rowCount==1)
          {
              status="success";
          }else{
             status="failed";  
          }
       }
       catch(Exception e)
       {
          e.printStackTrace();
       }
        return status;
       }

   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_parent = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_dd_no = new javax.swing.JLabel();
        lbl_check_no = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_gst_no = new javax.swing.JLabel();
        txt_receipt_no = new javax.swing.JTextField();
        txt_dd = new javax.swing.JTextField();
        txt_bank_name = new javax.swing.JTextField();
        combo_payment_mode = new javax.swing.JComboBox<>();
        date_choser = new com.toedter.calendar.JDateChooser();
        panel_child = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_year1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_year2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        combo_course = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        txt_course_name = new javax.swing.JTextField();
        txt_amount = new javax.swing.JTextField();
        txt_cgst = new javax.swing.JTextField();
        txt_sgst = new javax.swing.JTextField();
        txt_total = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        txt_totalinwords = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_remark = new javax.swing.JTextArea();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        txt_received_form = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_bank_name = new javax.swing.JLabel();
        txt_button = new javax.swing.JButton();
        txt_check_no = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_rollno = new javax.swing.JTextField();
        panel_sidebar = new javax.swing.JPanel();
        panel_home = new javax.swing.JPanel();
        lbl_home = new javax.swing.JLabel();
        panel_search_record = new javax.swing.JPanel();
        btn_search_record = new javax.swing.JLabel();
        panel_edit_course = new javax.swing.JPanel();
        btn_edit_course = new javax.swing.JLabel();
        panel_course_list = new javax.swing.JPanel();
        btn_course_list = new javax.swing.JLabel();
        panel_all_record = new javax.swing.JPanel();
        btn_all_record = new javax.swing.JLabel();
        panel_back = new javax.swing.JPanel();
        btn_back = new javax.swing.JLabel();
        panel_logout = new javax.swing.JPanel();
        btn_logout = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_parent.setBackground(new java.awt.Color(204, 204, 204));
        panel_parent.setForeground(new java.awt.Color(255, 255, 255));
        panel_parent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Recipet no : SOC - ");
        panel_parent.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 160, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Mode of payment :");
        panel_parent.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 180, 30));

        lbl_dd_no.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_dd_no.setText("DD No :");
        panel_parent.add(lbl_dd_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 160, 30));

        lbl_check_no.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_check_no.setText("Cheque No :");
        panel_parent.add(lbl_check_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 160, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Date :");
        panel_parent.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, 60, 30));

        txt_gst_no.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txt_gst_no.setText("GST NO : 546GRE65");
        panel_parent.add(txt_gst_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, 240, 30));

        txt_receipt_no.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_receipt_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_receipt_noActionPerformed(evt);
            }
        });
        panel_parent.add(txt_receipt_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 190, 30));

        txt_dd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_dd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ddActionPerformed(evt);
            }
        });
        panel_parent.add(txt_dd, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 190, 30));

        txt_bank_name.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_bank_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bank_nameActionPerformed(evt);
            }
        });
        panel_parent.add(txt_bank_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 190, 30));

        combo_payment_mode.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        combo_payment_mode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DD", "Cheque", "Cash", "Card" }));
        combo_payment_mode.setSelectedIndex(2);
        combo_payment_mode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_payment_modeActionPerformed(evt);
            }
        });
        panel_parent.add(combo_payment_mode, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 190, 30));

        date_choser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        panel_parent.add(date_choser, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 50, 140, 30));

        panel_child.setBackground(new java.awt.Color(204, 204, 204));
        panel_child.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Recived Form :");
        panel_child.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 0, 160, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 19)); // NOI18N
        jLabel9.setText("Session : ");
        panel_child.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 41, 123, 30));

        txt_year1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_year1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_year1ActionPerformed(evt);
            }
        });
        panel_child.add(txt_year1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 43, 78, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("to");
        panel_child.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 41, -1, 30));

        txt_year2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_year2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_year2ActionPerformed(evt);
            }
        });
        panel_child.add(txt_year2, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 43, 84, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Course :");
        panel_child.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 85, -1, -1));

        combo_course.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        combo_course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_courseActionPerformed(evt);
            }
        });
        panel_child.add(combo_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 85, 192, 31));

        jSeparator2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        panel_child.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 157, 1291, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("Head");
        panel_child.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(329, 162, -1, -1));

        jSeparator3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        panel_child.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 205, 1285, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setText("Amount");
        panel_child.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(742, 162, -1, -1));

        txt_course_name.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_course_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_course_nameActionPerformed(evt);
            }
        });
        panel_child.add(txt_course_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 247, 322, 30));

        txt_amount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_amountActionPerformed(evt);
            }
        });
        panel_child.add(txt_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(666, 232, 214, 30));

        txt_cgst.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_cgst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cgstActionPerformed(evt);
            }
        });
        panel_child.add(txt_cgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(666, 274, 214, 30));

        txt_sgst.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_sgst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_sgstActionPerformed(evt);
            }
        });
        panel_child.add(txt_sgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(666, 314, 214, -1));

        txt_total.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalActionPerformed(evt);
            }
        });
        panel_child.add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(666, 364, 214, -1));

        jSeparator4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        panel_child.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1118, 348, 173, -1));

        txt_totalinwords.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_totalinwords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalinwordsActionPerformed(evt);
            }
        });
        panel_child.add(txt_totalinwords, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 322, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setText("Total In words :");
        panel_child.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 310, -1, 30));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setText("Sr No");
        panel_child.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 162, -1, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setText("Remarks :");
        panel_child.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 348, -1, 30));

        txt_remark.setColumns(20);
        txt_remark.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_remark.setRows(5);
        jScrollPane1.setViewportView(txt_remark);

        panel_child.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 348, 322, 65));

        jSeparator5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        panel_child.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(662, 410, 232, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setText("Receiver Signature");
        panel_child.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(697, 425, 232, -1));

        txt_received_form.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_received_form.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_received_formActionPerformed(evt);
            }
        });
        panel_child.add(txt_received_form, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 6, 192, -1));

        jLabel3.setBackground(new java.awt.Color(0, 153, 153));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("CGST 9% :");
        panel_child.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(556, 275, 92, -1));

        jLabel5.setBackground(new java.awt.Color(0, 153, 153));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("SGST 9% :");
        panel_child.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(556, 313, 92, -1));

        jLabel4.setBackground(new java.awt.Color(0, 153, 153));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Total :");
        panel_child.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(573, 363, -1, -1));

        panel_parent.add(panel_child, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 1080, 540));

        lbl_bank_name.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_bank_name.setText("Bank No :");
        panel_parent.add(lbl_bank_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 160, 30));

        txt_button.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_button.setText("Print");
        txt_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_buttonActionPerformed(evt);
            }
        });
        panel_parent.add(txt_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 41, 100, 30));

        txt_check_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_check_noActionPerformed(evt);
            }
        });
        panel_parent.add(txt_check_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 190, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("Roll NO :  ");
        panel_parent.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, -1, 31));

        txt_rollno.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_rollno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rollnoActionPerformed(evt);
            }
        });
        panel_parent.add(txt_rollno, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 90, 140, 30));

        getContentPane().add(panel_parent, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 1080, 760));

        panel_sidebar.setBackground(new java.awt.Color(51, 51, 51));
        panel_sidebar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));
        panel_sidebar.setForeground(new java.awt.Color(255, 255, 255));
        panel_sidebar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_home.setBackground(new java.awt.Color(0, 0, 0));
        panel_home.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel_home.setForeground(new java.awt.Color(255, 255, 255));
        panel_home.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_home.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_home.setForeground(new java.awt.Color(255, 255, 255));
        lbl_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/home.png"))); // NOI18N
        lbl_home.setText("  Home");
        lbl_home.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        lbl_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_homeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_homeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_homeMouseExited(evt);
            }
        });
        panel_home.add(lbl_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 60));

        panel_sidebar.add(panel_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 200, 60));

        panel_search_record.setBackground(new java.awt.Color(0, 0, 0));
        panel_search_record.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));
        panel_search_record.setForeground(new java.awt.Color(255, 255, 255));
        panel_search_record.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_search_record.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_search_record.setForeground(new java.awt.Color(255, 255, 255));
        btn_search_record.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/search2.png"))); // NOI18N
        btn_search_record.setText("Search Record");
        btn_search_record.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_search_recordMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_search_recordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_search_recordMouseExited(evt);
            }
        });
        panel_search_record.add(btn_search_record, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 60));

        panel_sidebar.add(panel_search_record, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 200, 60));

        panel_edit_course.setBackground(new java.awt.Color(0, 0, 0));
        panel_edit_course.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));
        panel_edit_course.setForeground(new java.awt.Color(255, 255, 255));
        panel_edit_course.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_edit_course.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_edit_course.setForeground(new java.awt.Color(255, 255, 255));
        btn_edit_course.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/edit2.png"))); // NOI18N
        btn_edit_course.setText("Edit Courses");
        btn_edit_course.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_edit_courseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_edit_courseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_edit_courseMouseExited(evt);
            }
        });
        panel_edit_course.add(btn_edit_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 60));

        panel_sidebar.add(panel_edit_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 200, 60));

        panel_course_list.setBackground(new java.awt.Color(0, 0, 0));
        panel_course_list.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));
        panel_course_list.setForeground(new java.awt.Color(255, 255, 255));
        panel_course_list.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_course_list.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_course_list.setForeground(new java.awt.Color(255, 255, 255));
        btn_course_list.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/list_1.png"))); // NOI18N
        btn_course_list.setText("Course List");
        btn_course_list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_course_listMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_course_listMouseExited(evt);
            }
        });
        panel_course_list.add(btn_course_list, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 180, 60));

        panel_sidebar.add(panel_course_list, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 200, 60));

        panel_all_record.setBackground(new java.awt.Color(0, 0, 0));
        panel_all_record.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));
        panel_all_record.setForeground(new java.awt.Color(255, 255, 255));
        panel_all_record.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_all_record.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_all_record.setForeground(new java.awt.Color(255, 255, 255));
        btn_all_record.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/view all record.png"))); // NOI18N
        btn_all_record.setText("View All Record");
        btn_all_record.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_all_recordMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_all_recordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_all_recordMouseExited(evt);
            }
        });
        panel_all_record.add(btn_all_record, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 60));

        panel_sidebar.add(panel_all_record, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 200, 60));

        panel_back.setBackground(new java.awt.Color(0, 0, 0));
        panel_back.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));
        panel_back.setForeground(new java.awt.Color(255, 255, 255));
        panel_back.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_back.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_back.setForeground(new java.awt.Color(255, 255, 255));
        btn_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/back-button.png"))); // NOI18N
        btn_back.setText("   Back");
        btn_back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_backMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_backMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_backMouseExited(evt);
            }
        });
        panel_back.add(btn_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 60));

        panel_sidebar.add(panel_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 480, 200, 60));

        panel_logout.setBackground(new java.awt.Color(0, 0, 0));
        panel_logout.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, null, null));
        panel_logout.setForeground(new java.awt.Color(255, 255, 255));
        panel_logout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_logout.setBackground(new java.awt.Color(0, 0, 0));
        btn_logout.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_logout.setForeground(new java.awt.Color(255, 255, 255));
        btn_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/logout.png"))); // NOI18N
        btn_logout.setText("Logout");
        btn_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_logoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_logoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_logoutMouseExited(evt);
            }
        });
        panel_logout.add(btn_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 60));

        panel_sidebar.add(panel_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 580, 200, 60));

        jSeparator1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        panel_sidebar.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 430, 942, -1));

        getContentPane().add(panel_sidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 760));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_homeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_homeMouseEntered
        Color clr=new Color(51,0,51);
        panel_home.setBackground(clr);
    }//GEN-LAST:event_lbl_homeMouseEntered

    private void lbl_homeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_homeMouseExited
      Color clr=new Color(0,0,0);
        panel_home.setBackground(clr);
    }//GEN-LAST:event_lbl_homeMouseExited

    private void btn_search_recordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_search_recordMouseEntered
        Color clr=new Color(51,0,51);
        panel_search_record.setBackground(clr);
    }//GEN-LAST:event_btn_search_recordMouseEntered

    private void btn_search_recordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_search_recordMouseExited
         Color clr=new Color(0,0,0);
        panel_search_record.setBackground(clr);
    }//GEN-LAST:event_btn_search_recordMouseExited

    private void btn_edit_courseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_edit_courseMouseEntered
       Color clr=new Color(51,0,51);
        panel_edit_course.setBackground(clr);
    }//GEN-LAST:event_btn_edit_courseMouseEntered

    private void btn_edit_courseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_edit_courseMouseExited
       Color clr=new Color(0,0,0);
        panel_edit_course.setBackground(clr);
    }//GEN-LAST:event_btn_edit_courseMouseExited

    private void btn_course_listMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_course_listMouseEntered
       Color clr=new Color(51,0,51);
        panel_course_list.setBackground(clr); 
    }//GEN-LAST:event_btn_course_listMouseEntered

    private void btn_course_listMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_course_listMouseExited
        Color clr=new Color(0,0,0);
        panel_course_list.setBackground(clr);  
    }//GEN-LAST:event_btn_course_listMouseExited

    private void btn_all_recordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_all_recordMouseEntered
       Color clr=new Color(51,0,51);
        panel_all_record.setBackground(clr);
    }//GEN-LAST:event_btn_all_recordMouseEntered

    private void btn_all_recordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_all_recordMouseExited
      Color clr=new Color(0,0,0);
        panel_all_record.setBackground(clr); 
    }//GEN-LAST:event_btn_all_recordMouseExited

    private void btn_backMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_backMouseEntered
        Color clr=new Color(51,0,51);
        panel_back.setBackground(clr);
    }//GEN-LAST:event_btn_backMouseEntered

    private void btn_backMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_backMouseExited
         Color clr=new Color(0,0,0);
        panel_back.setBackground(clr); 
    }//GEN-LAST:event_btn_backMouseExited

    private void btn_logoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_logoutMouseEntered
         Color clr=new Color(51,0,51);
        panel_logout.setBackground(clr);
    }//GEN-LAST:event_btn_logoutMouseEntered

    private void btn_logoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_logoutMouseExited
       Color clr=new Color(0,0,0);
        panel_logout.setBackground(clr);
    }//GEN-LAST:event_btn_logoutMouseExited

    private void txt_receipt_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_receipt_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_receipt_noActionPerformed

    private void txt_ddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ddActionPerformed

    private void txt_bank_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bank_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bank_nameActionPerformed

    private void combo_payment_modeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_payment_modeActionPerformed
         if(combo_payment_mode.getSelectedIndex()==0){
            lbl_dd_no.setVisible(true);
            txt_dd.setVisible(true);
            lbl_check_no.setVisible(false);
            txt_check_no.setVisible(false);
            lbl_bank_name.setVisible(true);
            txt_bank_name.setVisible(true);
        }
         if(combo_payment_mode.getSelectedIndex()==1){
            lbl_dd_no.setVisible(false);
            txt_dd.setVisible(false);
            lbl_check_no.setVisible(true);
            txt_check_no.setVisible(true);
            lbl_bank_name.setVisible(true);
            txt_bank_name.setVisible(true);
        }
         if(combo_payment_mode.getSelectedIndex()==2){
            lbl_dd_no.setVisible(false);
            txt_dd.setVisible(false);
            lbl_check_no.setVisible(false);
            txt_check_no.setVisible(false);
            lbl_bank_name.setVisible(false);
            txt_bank_name.setVisible(false);
        }
          if(combo_payment_mode.getSelectedIndex()==3){
            lbl_dd_no.setVisible(false);
            txt_dd.setVisible(false);
            lbl_check_no.setVisible(false);
            txt_check_no.setVisible(false);
            lbl_bank_name.setVisible(true);
            txt_bank_name.setVisible(true);
        }
         
        
           
    }//GEN-LAST:event_combo_payment_modeActionPerformed

    private void txt_year1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_year1ActionPerformed
      
    }//GEN-LAST:event_txt_year1ActionPerformed

    private void txt_year2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_year2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_year2ActionPerformed

    private void txt_course_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_course_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_course_nameActionPerformed

    private void txt_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_amountActionPerformed
           Float amnt=Float.parseFloat(txt_amount.getText());
            Float cgst=(float)(amnt*0.09);
             Float sgst=(float)(amnt*0.09);
             
             txt_cgst.setText(cgst.toString());
             txt_sgst.setText(sgst.toString());
             
             float total = amnt + cgst+sgst;
             
             txt_total.setText(Float.toString(total));
            txt_totalinwords.setText(NumberToWordsConverter.convert((int)total));
      
    }//GEN-LAST:event_txt_amountActionPerformed

    private void txt_cgstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cgstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cgstActionPerformed

    private void txt_sgstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sgstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sgstActionPerformed

    private void txt_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalActionPerformed

    private void txt_totalinwordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalinwordsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalinwordsActionPerformed

    private void txt_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buttonActionPerformed
      if(validation()==true){
          
          String status=insertData();
          if(status.equals("success"))
          {
          JOptionPane.showMessageDialog(this,"record insertion successfully");    
         
          Print_receipt p=new Print_receipt();
          p.setVisible(true);
          this.dispose();
           }else
          {
          JOptionPane.showMessageDialog(this,"record insertion failed");    
          }
          
      }
    }//GEN-LAST:event_txt_buttonActionPerformed

    private void txt_received_formActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_received_formActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_received_formActionPerformed

    private void txt_check_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_check_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_check_noActionPerformed

    private void combo_courseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_courseActionPerformed
        txt_course_name.setText(combo_course.getSelectedItem().toString());
    }//GEN-LAST:event_combo_courseActionPerformed

    private void txt_rollnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rollnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_rollnoActionPerformed

    private void lbl_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_homeMouseClicked
       home1 home=new home1();
       home.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_lbl_homeMouseClicked

    private void btn_search_recordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_search_recordMouseClicked
         Search_Rocord search=new Search_Rocord();
     search.setVisible(true);
     this.dispose();
    }//GEN-LAST:event_btn_search_recordMouseClicked

    private void btn_edit_courseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_edit_courseMouseClicked
          Edit_Course edit=new Edit_Course();
       edit.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btn_edit_courseMouseClicked

    private void btn_all_recordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_all_recordMouseClicked
      View_All_Record record=new View_All_Record();
        record.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_all_recordMouseClicked

    private void btn_backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_backMouseClicked
       home1 home=new home1();
       home.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btn_backMouseClicked

    private void btn_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_logoutMouseClicked
          int a=JOptionPane.showConfirmDialog(null,"Do you want to Logout Application","Select",JOptionPane.YES_NO_OPTION);
        if(a==0){
            System.exit(0);
        }
    }//GEN-LAST:event_btn_logoutMouseClicked

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
            java.util.logging.Logger.getLogger(add_fees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(add_fees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(add_fees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(add_fees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new add_fees().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_all_record;
    private javax.swing.JLabel btn_back;
    private javax.swing.JLabel btn_course_list;
    private javax.swing.JLabel btn_edit_course;
    private javax.swing.JLabel btn_logout;
    private javax.swing.JLabel btn_search_record;
    private javax.swing.JComboBox<String> combo_course;
    private javax.swing.JComboBox<String> combo_payment_mode;
    private com.toedter.calendar.JDateChooser date_choser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lbl_bank_name;
    private javax.swing.JLabel lbl_check_no;
    private javax.swing.JLabel lbl_dd_no;
    private javax.swing.JLabel lbl_home;
    private javax.swing.JPanel panel_all_record;
    private javax.swing.JPanel panel_back;
    private javax.swing.JPanel panel_child;
    private javax.swing.JPanel panel_course_list;
    private javax.swing.JPanel panel_edit_course;
    private javax.swing.JPanel panel_home;
    private javax.swing.JPanel panel_logout;
    private javax.swing.JPanel panel_parent;
    private javax.swing.JPanel panel_search_record;
    private javax.swing.JPanel panel_sidebar;
    private javax.swing.JTextField txt_amount;
    private javax.swing.JTextField txt_bank_name;
    private javax.swing.JButton txt_button;
    private javax.swing.JTextField txt_cgst;
    private javax.swing.JTextField txt_check_no;
    private javax.swing.JTextField txt_course_name;
    private javax.swing.JTextField txt_dd;
    private javax.swing.JLabel txt_gst_no;
    private javax.swing.JTextField txt_receipt_no;
    private javax.swing.JTextField txt_received_form;
    private javax.swing.JTextArea txt_remark;
    private javax.swing.JTextField txt_rollno;
    private javax.swing.JTextField txt_sgst;
    private javax.swing.JTextField txt_total;
    private javax.swing.JTextField txt_totalinwords;
    private javax.swing.JTextField txt_year1;
    private javax.swing.JTextField txt_year2;
    // End of variables declaration//GEN-END:variables
}
