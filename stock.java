
package nmsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
public class stock extends javax.swing.JFrame {
    DefaultTableModel model;
    DateFormat dt=new SimpleDateFormat("dd/MM/yyyy");
    Date d1=new Date();
    String d=dt.format(d1);
    int pid;
    int sid;
    int wid;
    String sq;
    public stock() {
        initComponents();
        additem();
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
        t2.setText(d);
        model=new DefaultTableModel();
        table1.setModel(model);
        model.addColumn("Stock_ID");
        model.addColumn("Stock_DATE");
        model.addColumn("Plant_ID");
        model.addColumn("Plant_NAME");
        model.addColumn("Stock_QUANTITY");
        refresh();
    }

    @SuppressWarnings("unchecked")
    
public void refresh()
{
     try
        {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
        PreparedStatement pst=con.prepareStatement("select * from stock");
        ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
      model.addRow(new Object[]{rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)});
      
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane1 = new javax.swing.JOptionPane();
        c1 = new javax.swing.JComboBox();
        t1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        close = new javax.swing.JButton();
        s1 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        t2 = new javax.swing.JTextField();
        updatec = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Date");

        jLabel2.setText("Qunatity");

        add.setText("ADD  ");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        delete.setText("REFRESH");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stock_ID", "Stock_DATE", "Plant_ID", "Plant_NAME", "Stock_QUNTITY"
            }
        ));
        jScrollPane1.setViewportView(table1);

        close.setText("CLOSE");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });

        jButton5.setText("search");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel3.setText("Select Plant");

        updatec.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "UPDATE", "WASTE PLANTS", " " }));
        updatec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatecActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(add)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(updatec, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(delete))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(s1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(close)
                                    .addComponent(jButton5)))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(108, 108, 108))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(s1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(c1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(updatec, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void additem()
{
    try
        {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
        PreparedStatement pst=con.prepareStatement("select Plant_Name from plats");
        ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
                
                c1.addItem(rs.getString(1));
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
public void getsid()
{
    try
       {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
        PreparedStatement pst=con.prepareStatement("select MAX(stock_id) from stock");
        ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
               sid=rs.getInt(1); 
            }
            sid=sid+1;
            System.out.println(sid);
            rs.close();
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            jOptionPane1.showMessageDialog(null,e);
        }  
}
public void getwid()
{
    try
       {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
        PreparedStatement pst=con.prepareStatement("select * from waste");
        ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
               wid=rs.getInt(1); 
            }
            wid=wid+1;
            //System.out.println(wid);
            rs.close();
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            jOptionPane1.showMessageDialog(null,e);
        } 
}
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        int i=1;
        String pname=s1.getText();
        
        try
        {
          
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
        PreparedStatement pst=con.prepareStatement("select * from stock where plant_id="+pname+"");
        ResultSet rs=pst.executeQuery();
        

        if(rs!=null)
        {
            i=0;
            int w=1;
            removeR(); 
            while(rs.next())
            {
                w=0;
               model.addRow(new Object[]{rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)});
            }
            if(w==1)
            {
              jOptionPane1.showMessageDialog(null,"Record Not Exist !");  
            }
        }
        pname=null;
        rs.close();
        pst.close();
        con.close();
    }
        catch(Exception e)
        {
            jOptionPane1.showMessageDialog(null,e);
        }
        
    if(i==1)
        {
          
          pname=s1.getText();
          
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
            PreparedStatement ppst=con.prepareStatement("select * from stock where plant_name='"+pname+"'");
            ResultSet rrs=ppst.executeQuery();             
        if(rrs!=null)
        {
            int w=1;
            removeR(); 
            while(rrs.next())
            {
                w=0;
              model.addRow(new Object[]{rrs.getInt(1),rrs.getString(2),rrs.getString(3),rrs.getString(4),rrs.getInt(5)});
            }
            if(w==1)
            {
                jOptionPane1.showMessageDialog(null,"Record Not Exist");
            }
        }
            rrs.close();
            ppst.close();
            con.close();
        }
        catch(Exception e)
                {
                    jOptionPane1.showMessageDialog(null,e);
                }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_closeActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
        int stockq=0;
        try
        {
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
            PreparedStatement pst=con.prepareStatement("select * from stock where plant_name='"+c1.getSelectedItem()+"'");
            ResultSet rs=pst.executeQuery(); 
            while(rs.next())
            {
                stockq=rs.getInt(5);
            }
            
            stockq=stockq+Integer.parseInt(t1.getText());
            
            rs.close();
            pst.close();
            con.close();
        }
 
        catch(Exception e)
        {
            jOptionPane1.showMessageDialog(null,e);
        }
        try
        {
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
            PreparedStatement pst=con.prepareStatement("select plant_id from plats where PLANT_NAME='"+c1.getSelectedItem()+"'");
            ResultSet rs=pst.executeQuery(); 
            rs.next();
            pid=rs.getInt(1);
            rs.close();
            pst.close();
            con.close();
        }
 
        catch(Exception e)
        {
            jOptionPane1.showMessageDialog(null,e);
        }
    try
      {
        getsid();
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
        PreparedStatement pst=con.prepareStatement("insert into stock values("+sid+",'"+t2.getText()+"','"+pid+"','"+c1.getSelectedItem()+"',"+stockq+")");
       int q=pst.executeUpdate();
        if(q>0)
        {
            jOptionPane1.showMessageDialog(null,"Stock Add Successfully");
            stockq=0;
            removeR();
            refresh();
        }
        else
        {
           jOptionPane1.showMessageDialog(null,"Stock Not Add ! ");
           stockq=0;
        }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            jOptionPane1.showMessageDialog(null,e);
        }
        
    }//GEN-LAST:event_addActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        removeR();
        refresh();
    }//GEN-LAST:event_deleteActionPerformed

    private void updatecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatecActionPerformed
        // TODO add your handling code here:
        if(updatec.getSelectedItem().equals("UPDATE"))
        {
        try
        {
            System.out.println(c1.getSelectedItem());
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
            PreparedStatement pst=con.prepareStatement("select * from plats where PLANT_NAME='"+c1.getSelectedItem()+"'");
            ResultSet rs=pst.executeQuery(); 
            rs.next();
            pid=rs.getInt(1);
            rs.close();
            pst.close();
            con.close();
        }
 
        catch(Exception e)
        {
            jOptionPane1.showMessageDialog(null,e);
        }
    try
      {
        getsid();
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
        PreparedStatement pst=con.prepareStatement("insert into stock values("+sid+",'"+t2.getText()+"','"+pid+"','"+c1.getSelectedItem()+"',"+t1.getText()+")");
       int q=pst.executeUpdate();
        if(q>0)
        {
            jOptionPane1.showMessageDialog(null,"Stock Update Successfully");
            removeR();
            refresh();
        }
        else
        {
           jOptionPane1.showMessageDialog(null,"Stock Not Update ! ");
        }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            jOptionPane1.showMessageDialog(null,e);
        }
        }
        
        
        
        
        if(updatec.getSelectedItem().equals("WASTE PLANTS"))
        {
            
            int ckst=1;
         int prevstk=0;
            int pstock=0;
              int wasteq=Integer.parseInt(jOptionPane1.showInputDialog("Enter "+c1.getSelectedItem()+" Wasteplants"));
              try
        {
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
            PreparedStatement pst=con.prepareStatement("select * from stock where plant_name='"+c1.getSelectedItem()+"'");
            ResultSet rs=pst.executeQuery(); 
            while(rs.next())
            {
                pstock=rs.getInt(5);
            }
            if(pstock>wasteq)
            {
            prevstk=pstock;
            pstock=pstock-wasteq;
            
            }
            else
            {
              jOptionPane1.showMessageDialog(null,"Enter Valid Number Of Wasteplants ! "); 
              ckst=0;
            }
            
            rs.close();
            pst.close();
            con.close();
        }
 
        catch(Exception e)
        {
            jOptionPane1.showMessageDialog(null,e);
        }
        if(ckst==1)
        {
        try
        {
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
            PreparedStatement pst=con.prepareStatement("select * from plats where PLANT_NAME='"+c1.getSelectedItem()+"'");
            ResultSet rs=pst.executeQuery(); 
            rs.next();
            pid=rs.getInt(1);
            rs.close();
            pst.close();
            con.close();
        }
 
        catch(Exception e)
        {
            jOptionPane1.showMessageDialog(null,e); 
        }
    try
      {
        getsid();
        getwid();
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
        PreparedStatement pst=con.prepareStatement("insert into stock values("+sid+",'"+t2.getText()+"','"+pid+"','"+c1.getSelectedItem()+"',"+pstock+")");
        PreparedStatement ppst=con.prepareStatement("insert into waste values("+wid+",'"+t2.getText()+"',"+sid+",'"+pid+"','"+c1.getSelectedItem()+"',"+prevstk+","+wasteq+")");
        int q=pst.executeUpdate();
        int r=ppst.executeUpdate();
        if(q>0 &&r>0)
        {
            jOptionPane1.showMessageDialog(null,"Stock Update Successfully");
            pstock=0;
            removeR();
            refresh();
        }
        else
        {
           jOptionPane1.showMessageDialog(null,"Stock Not Update ! ");
           pstock=0;
        }
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
           jOptionPane1.showMessageDialog(null,e);
        }
        }
        }
    }//GEN-LAST:event_updatecActionPerformed

    private void c1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new stock().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JComboBox c1;
    private javax.swing.JButton close;
    private javax.swing.JButton delete;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField s1;
    private javax.swing.JTextField t1;
    private javax.swing.JTextField t2;
    private javax.swing.JTable table1;
    private javax.swing.JComboBox updatec;
    // End of variables declaration//GEN-END:variables
}
