
package nmsp;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

public class order extends javax.swing.JFrame {
    DefaultTableModel model;
    DateFormat dt=new SimpleDateFormat("dd/MM/yyyy");
    Date d1=new Date();
    String d=dt.format(d1);
    int oid;
    int pid;
    int sid;

    public order() {
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
        t1.setText(d);
        model=new DefaultTableModel();
        table1.setModel(model);
        model.addColumn("ORDER ID");
        model.addColumn("ORDER DATE");
        model.addColumn("PLANT NAME");
        model.addColumn("CONTACT NAME");
        model.addColumn("ADVANCED AMT");
        model.addColumn("QUANTITY");
        model.addColumn("STATUS");
        refresh();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane1 = new javax.swing.JOptionPane();
        t1 = new javax.swing.JTextField();
        t4 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        t5 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        c1 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        t2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        c2 = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        t3 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        t6 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        c3 = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("DATE");

        jLabel2.setText("CONTACT PERSON");

        jLabel3.setText("CONTACT NUMBER");

        jLabel4.setText("PLANT NAME");

        jLabel5.setText("QUANTITY");

        t2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t2ActionPerformed(evt);
            }
        });

        jLabel6.setText("STATUS");

        c2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ACTIVE", "DISPATCH", " " }));

        jLabel7.setText("ADVANCE_AMT");

        jLabel8.setText("ADDRESS");

        t6.setColumns(20);
        t6.setRows(5);
        jScrollPane1.setViewportView(t6);

        jButton1.setText("CLOSE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setText("ADD");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        c3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SHOWALL", "ACTIVE", "DISPACHED", "SALED" }));
        c3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c3ActionPerformed(evt);
            }
        });

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ORDER ID", "DATE", "PLANT NAME", "CONTACT NAME", "ADVANCED AMT", "STATUS"
            }
        ));
        jScrollPane2.setViewportView(table1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(c2, 0, 134, Short.MAX_VALUE)
                                    .addComponent(t1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(c1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(t3, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                    .addComponent(t2)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(t4)
                                    .addComponent(t5)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(c3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(c1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(c2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(t3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(t4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(t5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(182, 182, 182))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void t2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t2ActionPerformed
public void refresh()
{
     try
        {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
        PreparedStatement pst=con.prepareStatement("select * from plantorder");
        ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
      model.addRow(new Object[]{rs.getInt(1),rs.getString(2),rs.getString(4),rs.getString(5),rs.getInt(9),rs.getInt(8),rs.getString(10)});
      
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
public void getoid()
{
   try
       {
           oid=0;
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
        PreparedStatement pst=con.prepareStatement("select * from plantorder");
        ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
               oid=rs.getInt(1); 
            }
            oid=oid+1;
            System.out.println(oid);
            rs.close();
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
           jOptionPane1.showMessageDialog(null,e);
        }   
    
}
public void getpid()
{
   try
       {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
        PreparedStatement pst=con.prepareStatement("select * from plats where plant_name='"+c1.getSelectedItem()+"'");
        ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
               pid=rs.getInt(1); 
            }
            System.out.println(pid);
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
        PreparedStatement pst=con.prepareStatement("select * from stock");
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
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        try
        {
            getoid();
            getpid();
            if(t2.getText().equals(""))
            {
                
                jOptionPane1.showMessageDialog(null,"Please Fill Quantity Of Plants !"); 
            }
            else if(t3.getText().equals(""))
                        {
                        jOptionPane1.showMessageDialog(null,"Please Fill Advanced Ammount !");
                        }
            else if(t4.getText().equals(""))
            {
                jOptionPane1.showMessageDialog(null,"Please Fill Persont Name !");
            }
            else if(t5.getText().equals(""))
            {
                jOptionPane1.showMessageDialog(null,"Please Fill Contact Number !");
            }
            else if(t6.getText().equals(""))
            {
                jOptionPane1.showMessageDialog(null,"Please Fill Contact Address !");
            }
            else
                
            {    
                if(c2.getSelectedItem().equals("ACTIVE"))
                {
                try
                {
                   Class.forName("oracle.jdbc.driver.OracleDriver");
                   Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
                   PreparedStatement pst=con.prepareStatement("insert into plantorder values("+oid+",'"+t1.getText()+"','"+pid+"','"+c1.getSelectedItem()+"','"+t4.getText()+"','"+t5.getText()+"','"+t6.getText()+"',"+t2.getText()+",'"+t3.getText()+"','"+c2.getSelectedItem()+"')");
                   int q=pst.executeUpdate();
                     if(q>0)
                       {
                           jOptionPane1.showMessageDialog(null,"Order Add Successfully");
                          removeR();
                          refresh();
                          t2.setText("");
                          t3.setText("");
                          t4.setText("");
                          t5.setText("");
                          t6.setText("");
                        }
                        else
                        {
                          jOptionPane1.showMessageDialog(null,"Order  Not Add ! ");
                        }
                           pst.close();
                           con.close();    
                }
                catch(Exception e)
                {
                    jOptionPane1.showMessageDialog(null,e);
                }
                }   
                else
                {
                    try
                    {
                        getsid();
                        getpid();
                        int stockq=0;
                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
                        PreparedStatement pst=con.prepareStatement("select * from stock where plant_name='"+c1.getSelectedItem()+"'");
                        ResultSet rs=pst.executeQuery(); 
                        while(rs.next())
                         {
                           stockq=rs.getInt(5);
                         }
                        stockq=stockq+Integer.parseInt(t2.getText());
                        
                         PreparedStatement sst=con.prepareStatement("insert into stock values("+sid+",'"+d+"','"+pid+"','"+c1.getSelectedItem()+"',"+stockq+")");
                         PreparedStatement ost=con.prepareStatement("insert into plantorder values("+oid+",'"+t1.getText()+"','"+pid+"','"+c1.getSelectedItem()+"','"+t4.getText()+"','"+t5.getText()+"','"+t6.getText()+"',"+t2.getText()+",'"+t3.getText()+"','"+c2.getSelectedItem()+"')");
                         int s=sst.executeUpdate();
                         int o=ost.executeUpdate();
                         if(s>0 &&o>0)
                         {
                          jOptionPane1.showMessageDialog(null,"Order Add Successfully"); 
                          removeR();
                          refresh();
                          t2.setText("");
                          t3.setText("");
                          t4.setText("");
                          t5.setText("");
                          t6.setText("");
                         }
                         else
                         {
                            jOptionPane1.showMessageDialog(null,"Order  Not Add ! "); 
                         }
                         ost.close();
                         sst.close();
                         rs.close();
                         pst.close();
                         con.close();
                         
                    }
                    catch(Exception e)
                    {
                        jOptionPane1.showMessageDialog(null,e);
                    }
                }
            }  
    }//GEN-LAST:event_jButton4ActionPerformed
    catch(Exception e)
        {
            jOptionPane1.showMessageDialog(null,e);
        }
}
    
    private void c3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c3ActionPerformed
        // TODO add your handling code here:
        if(c3.getSelectedItem().equals("SHOWALL"))
        {
            removeR();
            refresh();
        }
        if(c3.getSelectedItem().equals("ACTIVE"))
        {
            removeR();
            try
        {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
        PreparedStatement pst=con.prepareStatement("select * from plantorder where order_status='ACTIVE'");
        ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
      model.addRow(new Object[]{rs.getInt(1),rs.getString(2),rs.getString(4),rs.getString(5),rs.getInt(9),rs.getInt(8),rs.getString(10)});
      
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
        if(c3.getSelectedItem().equals("DISPACHED"))
        {
            removeR();
            try
        {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
        PreparedStatement pst=con.prepareStatement("select * from plantorder where order_status='DISPATCH'");
        ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
      model.addRow(new Object[]{rs.getInt(1),rs.getString(2),rs.getString(4),rs.getString(5),rs.getInt(9),rs.getInt(8),rs.getString(10)});
      
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
        if(c3.getSelectedItem().equals("SALED"))
        {
            removeR();
            try
        {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
        PreparedStatement pst=con.prepareStatement("select * from plantorder where order_status='SALED'");
        ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
      model.addRow(new Object[]{rs.getInt(1),rs.getString(2),rs.getString(4),rs.getString(5),rs.getInt(9),rs.getInt(8),rs.getString(10)});
      
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
        
    }//GEN-LAST:event_c3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
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
                System.out.println(rs.getString(1));
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
    public static void main(String args[]) {
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new order().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox c1;
    private javax.swing.JComboBox c2;
    private javax.swing.JComboBox c3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField t1;
    private javax.swing.JTextField t2;
    private javax.swing.JTextField t3;
    private javax.swing.JTextField t4;
    private javax.swing.JTextField t5;
    private javax.swing.JTextArea t6;
    private javax.swing.JTable table1;
    // End of variables declaration//GEN-END:variables
}
