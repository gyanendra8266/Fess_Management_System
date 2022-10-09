/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fees_management_system;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.Set;
//import static java.util.Map.entry;
import java.util.TreeMap;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import java.util.Map.entry(...);

/**
 *
 * @author Gyanendra
 */
public class Report_Generate extends javax.swing.JFrame {

    /**
     * Creates new form Report_Generate
     */
    DefaultTableModel model;
    public Report_Generate() {
        initComponents();
       fillComboBox();
    }
    public void fillComboBox(){
           try{
              Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
         Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/fees_management2","root","root");  
            PreparedStatement pst=con.prepareStatement("select course_name from course");
           ResultSet rs=pst.executeQuery();
           while(rs.next()){
               comboCourse.addItem(rs.getString("course_name"));
           }
           }
           catch(Exception e){
             e.printStackTrace();
           }
       }
    public void setRecordsTable(){
        String cname=comboCourse.getSelectedItem().toString();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyy-MM-dd");
        String fromDate=dateFormat.format(dateChooserFrom.getDate());
        String toDate=dateFormat.format(dateChooserTo.getDate());
        Float amountTotal=0.0f;
        
        try{
           Connection con=DBConnection.getConnection();
              PreparedStatement pst=con.prepareStatement("select * from fees_details where date between ? and ? and course_name = ?");
             pst.setString(1,fromDate);
             pst.setString(2, toDate);
             pst.setString(3,cname);
              ResultSet rs = pst.executeQuery(); 
              while(rs.next()){
                  String receiptNO=rs.getString("reciept_no");
                  String rollNO=rs.getString("roll_no");
                  String studentName=rs.getString("student_name");
                  String courseName=rs.getString("course_name");
                  String paymentMode=rs.getString("payment_mode");
                  float amount=rs.getFloat("total_amount");
                  String remark=rs.getString("remark");
                  
                  amountTotal=amountTotal+amount;
                  
                  Object[] obj ={receiptNO,rollNO,studentName,courseName,paymentMode,amount,remark};
                  
                  model=(DefaultTableModel)tbl_feesDetails.getModel();
                  model.addRow(obj);
                  
              }
              lbl_courseSelected.setText(cname);
              lbl_totalAmount.setText(amountTotal.toString());
               lbl_amountInWords.setText(NumberToWordsConverter.convert(amountTotal.intValue()));
              
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void clearTable(){
        DefaultTableModel model=(DefaultTableModel)tbl_feesDetails.getModel();
        model.setRowCount(0);
        }
    
    public void exportToExcel(){
        XSSFWorkbook wb= new XSSFWorkbook();
        XSSFSheet ws =wb.createSheet();
        TreeMap<String,Object[]>map=new TreeMap<>();
        map.put("0",new Object[]{model.getColumnName(0),model.getColumnName(1),model.getColumnName(2),
        model.getColumnName(3),model.getColumnName(4),model.getColumnName(5)});
        
       for(int i=0;i<model.getRowCount();i++){
           map.put(Integer.toString(i),new Object[]{model.getValueAt(i,0),model.getValueAt(i,1),model.getValueAt(i,2),
        model.getValueAt(i,3),model.getValueAt(i,4),model.getValueAt(i,5)});
       }
           Set<String> id=map.keySet();
           XSSFRow fRow;
           int rowId=0;
           for(String key :id){
               fRow=ws.createRow(rowId++);
               Object[] value= map.get(key);
               int cellId=0;
               for(Object object:value){
                   XSSFCell cell=fRow.createCell(cellId++);
                   cell.setCellValue(object.toString());
               }
                 
       
        }
           try( FileOutputStream fos= new FileOutputStream(new File(txt_FilePath.getText()))){
          wb.write(fos);
          JOptionPane.showMessageDialog(this,"file exported succellfully:"+txt_FilePath.getText());
           }
           catch(Exception e){
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_feesDetails = new javax.swing.JTable();
        comboCourse = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        dateChooserTo = new com.toedter.calendar.JDateChooser();
        dateChooserFrom = new com.toedter.calendar.JDateChooser();
        btn_Print = new javax.swing.JButton();
        btn_Submit = new javax.swing.JButton();
        txt_FilePath = new javax.swing.JTextField();
        btn_Browse = new javax.swing.JButton();
        btn_ExportToExcle = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbl_amountInWords = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_totalAmount = new javax.swing.JLabel();
        lbl_courseSelected = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        btn_back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_feesDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Receipt_no", "Roll_no", "Student_name", "Course", "Payment_mode", "Amount", "Remark"
            }
        ));
        jScrollPane1.setViewportView(tbl_feesDetails);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 880, 530));

        comboCourse.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel1.add(comboCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 140, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Select Course :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 110, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Select Date :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 110, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("From Date :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 110, 30));
        jPanel1.add(dateChooserTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 160, 30));
        jPanel1.add(dateChooserFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 160, 30));

        btn_Print.setBackground(new java.awt.Color(0, 102, 102));
        btn_Print.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Print.setText("Print ");
        btn_Print.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_Print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PrintActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Print, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, 110, 30));

        btn_Submit.setBackground(new java.awt.Color(0, 102, 102));
        btn_Submit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Submit.setText("Submit");
        btn_Submit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SubmitActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 110, 30));

        txt_FilePath.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel1.add(txt_FilePath, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 200, -1));

        btn_Browse.setBackground(new java.awt.Color(0, 102, 102));
        btn_Browse.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Browse.setText("Browse");
        btn_Browse.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_Browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BrowseActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Browse, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 410, 110, 30));

        btn_ExportToExcle.setBackground(new java.awt.Color(0, 102, 102));
        btn_ExportToExcle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_ExportToExcle.setText("Export to Excle");
        btn_ExportToExcle.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_ExportToExcle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ExportToExcleActionPerformed(evt);
            }
        });
        jPanel1.add(btn_ExportToExcle, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 230, 30));

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Total Amount In Words :");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 170, 30));

        lbl_amountInWords.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel2.add(lbl_amountInWords, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 390, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Total Amount Calculated :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 190, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Course Selected :");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 30));

        lbl_totalAmount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel2.add(lbl_totalAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 130, 30));

        lbl_courseSelected.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel2.add(lbl_courseSelected, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 130, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 390, 160));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("To Date :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 110, 30));

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jLabel6.setText("Report");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 30, 170, 60));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 20));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 90, 270, 6));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/view all record.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 40, 70, 90));

        btn_back.setBackground(new java.awt.Color(0, 102, 102));
        btn_back.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_back.setForeground(new java.awt.Color(255, 255, 255));
        btn_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/back1.png"))); // NOI18N
        btn_back.setText("Back");
        btn_back.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });
        jPanel1.add(btn_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 110, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1670, 1010));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_PrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PrintActionPerformed
        SimpleDateFormat Date_Format = new SimpleDateFormat("YYYY-MM-dd"); 
        String datefrom=  Date_Format.format(dateChooserFrom.getDate());
      String dateto=  Date_Format.format(dateChooserTo.getDate());
       
        MessageFormat header=new MessageFormat("Report From "+datefrom+" To " +dateto);
MessageFormat footer=new MessageFormat("page{0,number,integer}");
        try {
            tbl_feesDetails.print(JTable.PrintMode.FIT_WIDTH, header, footer);
            
        } catch (Exception e) {
            e.getMessage();
        } 
    }//GEN-LAST:event_btn_PrintActionPerformed

    private void btn_SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SubmitActionPerformed
        clearTable();
        setRecordsTable();
    }//GEN-LAST:event_btn_SubmitActionPerformed

    private void btn_BrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BrowseActionPerformed
        JFileChooser fileChooser=new JFileChooser();
        fileChooser.showOpenDialog(this);
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String date=dateFormat.format(new Date());
        try{
         File f=fileChooser.getSelectedFile();
         String path=f.getAbsolutePath();
         path=path+"_"+date+".xlsx";
         txt_FilePath.setText(path);
        }
        catch(Exception e){
          e.printStackTrace();
        }
    }//GEN-LAST:event_btn_BrowseActionPerformed

    private void btn_ExportToExcleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ExportToExcleActionPerformed
        exportToExcel();
    }//GEN-LAST:event_btn_ExportToExcleActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
       home1 home=new home1();
       home.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btn_backActionPerformed

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
            java.util.logging.Logger.getLogger(Report_Generate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Report_Generate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Report_Generate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Report_Generate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Report_Generate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Browse;
    private javax.swing.JButton btn_ExportToExcle;
    private javax.swing.JButton btn_Print;
    private javax.swing.JButton btn_Submit;
    private javax.swing.JButton btn_back;
    private javax.swing.JComboBox<String> comboCourse;
    private com.toedter.calendar.JDateChooser dateChooserFrom;
    private com.toedter.calendar.JDateChooser dateChooserTo;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_amountInWords;
    private javax.swing.JLabel lbl_courseSelected;
    private javax.swing.JLabel lbl_totalAmount;
    private javax.swing.JTable tbl_feesDetails;
    private javax.swing.JTextField txt_FilePath;
    // End of variables declaration//GEN-END:variables
}
