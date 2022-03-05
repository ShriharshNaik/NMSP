
package nmsp;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class plant extends javax.swing.JFrame {
    int pid=0;
    DefaultTableModel model;
    public void refresh()
    {
        try
        {
        Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mnsp","root","Neel@1234");
        PreparedStatement pst=con.prepareStatement("select * from plats");
        ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
      model.addRow(new Object[]{rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(5)});
      
            }
            rs.close();
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            jOptionPane1.showMessageDialog(null,e);
        }
    }
    public void removeR()
    {
       int cnt=model.getRowCount();
       for(int j=0;j<cnt;j++)
       {
        model.removeRow(0);
       }
    }

    public plant() {
        initComponents();
        
        Dimension ss=Toolkit.getDefaultToolkit().getScreenSize();
        double sh=ss.getHeight();
        double sw=ss.getWidth();
        int csh=(int)sh;
        int csw=(int)sw;
        int dsh=this.getHeight();
        int dsw=this.getWidth();
        csh=csh-dsh;
        csw=csw-dsw;
        csh=csh/2;
        csw=csw/2;
        this.setLocation(csw,csh);
        combo1.setEnabled(false);
        
        model=new DefaultTableModel();
        table1.setModel(model);
        model.addColumn("Plant_ID");
        model.addColumn("Plant_NAME");
        model.addColumn("Plant_TYPE");
        model.addColumn("Germination_TIME");
        refresh();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane1 = new javax.swing.JOptionPane();
        combo1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        t2 = new javax.swing.JTextField();
        t3 = new javax.swing.JTextField();
        t4 = new javax.swing.JTextField();
        t5 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        t1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        ch1 = new javax.swing.JCheckBox();
        t6 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        b4 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        combo1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mango", "Lemon", "Pomegranate", "Tomato", "Brinjal", "Chillies", "Cabbage", "Carrot", "Rose", "Marigold", "Rosemallow" }));
        combo1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo1ItemStateChanged(evt);
            }
        });
        combo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Select Plant :");

        jLabel2.setText("Plant Type :");

        jLabel4.setText("Scintific Name :");

        jLabel5.setText("Germination Period :");

        jButton1.setText("CLOSE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("ADD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setText("Climate Condition :");

        jLabel7.setText("Plant ID :");

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Plant_ID", "Plant_NAME", "Plant_TYPE", "Germination_TIME"
            }
        ));
        jScrollPane1.setViewportView(table1);

        jButton3.setText("DELETE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        ch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ch1ActionPerformed(evt);
            }
        });

        t6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t6FocusLost(evt);
            }
        });

        jLabel3.setText("Plant Name :");

        b4.setText("CLEAR");
        b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4ActionPerformed(evt);
            }
        });

        jLabel8.setText("Add  plant form Database");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(t5)
                            .addComponent(t4)
                            .addComponent(t3)
                            .addComponent(t2)
                            .addComponent(t1)
                            .addComponent(t6)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(8, 8, 8)
                                .addComponent(jButton3)
                                .addGap(8, 8, 8)
                                .addComponent(b4)
                                .addGap(8, 8, 8)
                                .addComponent(jButton1)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ch1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(combo1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ch1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(t6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(t3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(t4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(t5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(199, 199, 199))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int i=0;
        try
        {
        Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/booking","root","Neel@1234");
            PreparedStatement pst=con.prepareStatement("select Plant_ID from plats");
            ResultSet rs=pst.executeQuery();
            if(t6.getText().equals(""))
            {
              jOptionPane1.showMessageDialog(null,"Please Slect Plant Name");  
            }
            else if(t2.getText().equals(""))
            {
              jOptionPane1.showMessageDialog(null,"Please Enter Plant Type");  
            }
            else if(t3.getText().equals(""))
            {
              jOptionPane1.showMessageDialog(null,"Please Enter Scintific Name");  
            }
            else if(t4.getText().equals(""))
            {
              jOptionPane1.showMessageDialog(null,"Please Enter Germination Period");  
            }
            else if(t5.getText().equals(""))
            {
              jOptionPane1.showMessageDialog(null,"Please Enter Climate Condition");  
            }
            else
            {
               
            while(rs.next())
            {
                if(rs.getString(1).equals(t1.getText()))
                {
                   jOptionPane1.showMessageDialog(null,"Plant information Already Exist");
                   i=1;
                }
            }
            if(ch1.isSelected())
            {
            if(i==0)
            {
               PreparedStatement st=con.prepareStatement("insert into plats values("+t1.getText()+",'"+t6.getText()+"','"+t2.getText()+"','"+t3.getText()+"','"+t4.getText()+"','"+t5.getText()+"')");
               int c=st.executeUpdate();
               if(c>0)
               {
                jOptionPane1.showMessageDialog(null,"Saved Successfully");
                removeR();
                refresh();
               }
               else
               {
                   jOptionPane1.showMessageDialog(null,"Not Saved");
               }
               st.close();
            }
            }
            else
            {
               getpid();
               PreparedStatement sst=con.prepareStatement("insert into plats values("+t1.getText()+",'"+t6.getText()+"','"+t2.getText()+"','"+t3.getText()+"','"+t4.getText()+"','"+t5.getText()+"')");
               PreparedStatement mst=con.prepareStatement("insert into pmaster values("+t1.getText()+",'"+t6.getText()+"','"+t2.getText()+"','"+t3.getText()+"','"+t4.getText()+"','"+t5.getText()+"')");
               int c=sst.executeUpdate();
               int d=mst.executeUpdate();
               if(c>0 && d>0)
               {
                jOptionPane1.showMessageDialog(null,"Saved Successfully");
                removeR();
                refresh();
                mst.close();
                sst.close();
            }
            }
            
            rs.next();
            rs.close();
            pst.close();
            con.close();
        }
        }
        catch(Exception e)
        {
            jOptionPane1.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
       dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void combo1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo1ItemStateChanged
   
        
    }//GEN-LAST:event_combo1ItemStateChanged

    private void combo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo1ActionPerformed

        try
        {
       Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mnsp","root","Neel@1234");
            PreparedStatement pst=con.prepareStatement("select * from pmaster where pname='"+combo1.getSelectedItem()+"'");
            ResultSet rs=pst.executeQuery();
            rs.next();
            t1.setText(rs.getString(1));
            t2.setText(rs.getString(3));
            t3.setText(rs.getString(4));
            t4.setText(rs.getString(5));
            t5.setText(rs.getString(6));
            t6.setText(rs.getString(2));
            rs.close();
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
           jOptionPane1.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_combo1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int k=0;
        try
        {
       Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mnsp","root","Neel@1234");
            PreparedStatement pst=con.prepareStatement("select Plant_ID from plats");
            ResultSet rs=pst.executeQuery();
            if(t1.getText().equals(""))
            {
              jOptionPane1.showMessageDialog(null,"Please Slect Plant Name");  
            }
            else
            {
            while(rs.next())
            {
                if(rs.getString(1).equals(t1.getText()))
                {
                   k=1;
                }
            }
            if(k==1)
            {
                PreparedStatement st=con.prepareStatement("delete from plats where Plant_ID="+t1.getText()+"");
               int ck=st.executeUpdate();
               if(ck>0)
               {
                jOptionPane1.showMessageDialog(null,"Delete Record Successfully");
                removeR();
                refresh();
               }
               st.close();
            }
            else
            {
               jOptionPane1.showMessageDialog(null,"Record Not Exist !"); 
            }
            }
            
            rs.next();
            rs.close();
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
          jOptionPane1.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_jButton3ActionPerformed
public void getpid()
{
    try
    {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mnsp","root","Neel@1234");
            PreparedStatement pst=con.prepareStatement("select MAX(pid) from pmaster");
            ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
                pid=rs.getInt(1);
            }
            pid=pid+1;
    }
    catch(Exception e)
    {
     jOptionPane1.showMessageDialog(null,e);
    }
}
    private void ch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ch1ActionPerformed
        // TODO add your handling code here:
        if(ch1.isSelected())
        {
            combo1.setEnabled(true);
        }
        else
        {
            combo1.setEnabled(false);
            
            
        }
    }//GEN-LAST:event_ch1ActionPerformed

    private void b4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4ActionPerformed
        // TODO add your handling code here:
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
        t6.setText("");
    }//GEN-LAST:event_b4ActionPerformed

    private void t6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t6FocusLost
        // TODO add your handling code here:
        if(ch1.isSelected()==false)
        {
            getpid();
            t1.setText(String.valueOf(pid));
        }
    }//GEN-LAST:event_t6FocusLost

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new plant().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b4;
    private javax.swing.JCheckBox ch1;
    private javax.swing.JComboBox combo1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField t1;
    private javax.swing.JTextField t2;
    private javax.swing.JTextField t3;
    private javax.swing.JTextField t4;
    private javax.swing.JTextField t5;
    private javax.swing.JTextField t6;
    private javax.swing.JTable table1;
    // End of variables declaration//GEN-END:variables
}
