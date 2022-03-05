
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

public class manageorder extends javax.swing.JFrame {
    DefaultTableModel model;
    DateFormat dt=new SimpleDateFormat("dd/MM/yyyy");
    Date d1=new Date();
    String d=dt.format(d1);
    int oid;
    int pid;
    int sid;
    int rcount=0;
    int rindex=0;
    

    public manageorder() {
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
        rcount=model.getRowCount();
        frecord();
    }
    public void refresh()
{
     try
        {
        Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mnsp","root","Neel@1234");
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
public void displaytable()
{
     rcount=model.getRowCount();
      try
    {
        Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mnsp","root","Neel@1234");
        PreparedStatement pst=con.prepareStatement("select * from plantorder where order_id="+model.getValueAt(rindex,0)+"");
        ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
            t1.setText(rs.getString(2));
            t2.setText(rs.getString(8));
            t3.setText(rs.getString(9));
            t4.setText(rs.getString(5));
            t5.setText(rs.getString(6));
            t6.setText(rs.getString(7));
            t7.setText(rs.getString(1));
            t8.setText(rs.getString(4));
            t9.setText(rs.getString(10));
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
public void clearetext()
{
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t6.setText("");
            t7.setText("");
            t8.setText("");
            t9.setText("");
}
public void frecord()
{
    try
    {
       Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mnsp","root","Neel@1234");
        PreparedStatement pst=con.prepareStatement("select * from plantorder where order_id="+model.getValueAt(rindex,0)+"");
        ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
            t1.setText(rs.getString(2));
            t2.setText(rs.getString(8));
            t3.setText(rs.getString(9));
            t4.setText(rs.getString(5));
            t5.setText(rs.getString(6));
            t6.setText(rs.getString(7));
            t7.setText(rs.getString(1));
            t8.setText(rs.getString(4));
            t9.setText(rs.getString(10));
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane1 = new javax.swing.JOptionPane();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        t6 = new javax.swing.JTextArea();
        t3 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        t2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        t7 = new javax.swing.JTextField();
        t4 = new javax.swing.JTextField();
        t1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        t5 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        t8 = new javax.swing.JTextField();
        t9 = new javax.swing.JTextField();
        next = new javax.swing.JButton();
        prev = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        c1 = new javax.swing.JComboBox();
        c3 = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        update = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("CLOSE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        t6.setColumns(20);
        t6.setRows(5);
        jScrollPane1.setViewportView(t6);

        jLabel8.setText("ADDRESS");

        jLabel7.setText("ADVANCE_AMT");

        t2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t2ActionPerformed(evt);
            }
        });

        jLabel6.setText("CURRENT STATUS");

        jLabel9.setText("ORDERD ID");

        jLabel5.setText("QUANTITY");

        jLabel3.setText("CONTACT NUMBER");

        jLabel2.setText("CONTACT PERSON");

        jLabel1.setText("DATE");

        jLabel4.setText("PLANT NAME");

        next.setText("NEXT");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        prev.setText("PREV");
        prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevActionPerformed(evt);
            }
        });

        jLabel10.setText("NEW STATUS");

        c1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DISPATCH", "SALED" }));

        c3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SHOWALL", "ACTIVE", "DISPATCHED", "SALED" }));
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

        update.setText("UPDATE");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(t1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t7)
                            .addComponent(t8)
                            .addComponent(t9)
                            .addComponent(c1, 0, 134, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(t3, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                            .addComponent(t2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(t4)
                                    .addComponent(t5)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(update)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(prev, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(c3, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(t7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(c3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(t3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(c1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
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
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prev, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(107, 107, 107))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void t2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t2ActionPerformed

    private void prevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevActionPerformed
        // TODO add your handling code here:
        if(rindex>0)
    {
    rindex=rindex-1;
    }
    else
    {
        
        //next.setEnabled(false);
    }
       displaytable(); 
    }//GEN-LAST:event_prevActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        // TODO add your handling code here:
        if(rindex<rcount-1)
    {
    rindex=rindex+1;
    }
    else
    {
        
        //next.setEnabled(false);
    }
       displaytable(); 
    }//GEN-LAST:event_nextActionPerformed
public void removeR()
{
    int cnt=model.getRowCount();
       for(int j=0;j<cnt;j++)
       {
        model.removeRow(0);
       }
}
    private void c3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c3ActionPerformed
        // TODO add your handling code here:
        if(c3.getSelectedItem().equals("SHOWALL"))
        {
            clearetext();
            removeR();
            refresh();
            rindex=0;
            frecord();
        }
        if(c3.getSelectedItem().equals("ACTIVE"))
        {
            clearetext();
            removeR();
            try
        {
       Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mnsp","root","Neel@1234");
        PreparedStatement pst=con.prepareStatement("select * from plantorder where order_status='ACTIVE'");
        ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
      model.addRow(new Object[]{rs.getInt(1),rs.getString(2),rs.getString(4),rs.getString(5),rs.getInt(9),rs.getInt(8),rs.getString(10)});
      
            }
            
            rs.close();
            pst.close();
            con.close();
            rindex=0;
            frecord();
        }
        catch(Exception e)
        {
           jOptionPane1.showMessageDialog(null,e);
        }
        }
        if(c3.getSelectedItem().equals("DISPATCHED"))
        {
            clearetext();
            removeR();
            try
        {
        Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mnsp","root","Neel@1234");
        PreparedStatement pst=con.prepareStatement("select * from plantorder where order_status='DISPATCH'");
        ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
      model.addRow(new Object[]{rs.getInt(1),rs.getString(2),rs.getString(4),rs.getString(5),rs.getInt(9),rs.getInt(8),rs.getString(10)});
      
            }
            rs.close();
            pst.close();
            con.close();
            rindex=0;
            frecord();
        }
        catch(Exception e)
        {
            jOptionPane1.showMessageDialog(null,e);
        }
        }
        if(c3.getSelectedItem().equals("SALED"))
        {
            clearetext();
            removeR();
            try
        {
        Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mnsp","root","Neel@1234");
        PreparedStatement pst=con.prepareStatement("select * from plantorder where order_status='SALED'");
        ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
      model.addRow(new Object[]{rs.getInt(1),rs.getString(2),rs.getString(4),rs.getString(5),rs.getInt(9),rs.getInt(8),rs.getString(10)});
      
            }
            rs.close();
            pst.close();
            con.close();
            rindex=0;
            frecord();
        }
        catch(Exception e)
        {
           jOptionPane1.showMessageDialog(null,e);
        }
        }
        
    }//GEN-LAST:event_c3ActionPerformed
public void getpid()
{
   try
       {
       Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mnsp","root","Neel@1234");
        PreparedStatement pst=con.prepareStatement("select plant_id from plats where plant_name='"+t8.getText()+"'");
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
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
public void getsid()
{
    try
       {
        Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mnsp","root","Neel@1234");
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
    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
        if(t9.getText().equals("ACTIVE"))
        {
          if(c1.getSelectedItem().equals("DISPATCH"))
          {
              try
              {
                        getsid();
                        getpid();
                        int stockq=0;
                        Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mnsp","root","Neel@1234");
                        PreparedStatement pst=con.prepareStatement("select * from stock where plant_name='"+c1.getSelectedItem()+"'");
                        ResultSet rs=pst.executeQuery(); 
                        while(rs.next())
                         {
                           stockq=rs.getInt(5);
                         }
                        stockq=stockq+Integer.parseInt(t2.getText());
                        
                         PreparedStatement sst=con.prepareStatement("insert into stock values("+sid+",'"+d+"','"+pid+"','"+t8.getText()+"',"+stockq+")");
                         PreparedStatement ost=con.prepareStatement("update plantorder set order_status='"+c1.getSelectedItem()+"' where order_id='"+t7.getText()+"'");
                         int s=sst.executeUpdate();
                         int o=ost.executeUpdate();
                         if(s>0 &&o>0)
                         {
                          jOptionPane1.showMessageDialog(null,"Order Update Successfully"); 
                          removeR();
                          refresh();
                       
                         }
                         else
                         {
                            jOptionPane1.showMessageDialog(null,"Order  Not Update ! "); 
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
          else
          {
              jOptionPane1.showMessageDialog(null,"Please Select Correct status !");
          }  
        }
        if(t9.getText().equals("DISPATCH"))
        {
          if(c1.getSelectedItem().equals("SALED"))
          {
              try
              {
                  
                 getsid();
                        getpid();
                        int stockq=0;
                       Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mnsp","root","Neel@1234");
                        PreparedStatement pst=con.prepareStatement("select * from stock where plant_name='"+t8.getText()+"'");
                        ResultSet rs=pst.executeQuery(); 
                        System.out.println("stock"+stockq);
                        while(rs.next())
                         {
                           stockq=rs.getInt(5);
                         }
                        
                        System.out.println(stockq);
                        
                        if(stockq<Integer.parseInt(t2.getText()))
                        {
                            jOptionPane1.showMessageDialog(null,"Stock Is Not Sufficient("+stockq+") !");
                        }
                        else
                        {
                                                
                         
                         PreparedStatement ost=con.prepareStatement("update plantorder set order_status='"+c1.getSelectedItem()+"' where order_id='"+t7.getText()+"'");
                         int o=ost.executeUpdate();
                         if(o>0)
                         {
                          jOptionPane1.showMessageDialog(null,"Order Update Successfully"); 
                          removeR();
                          refresh();
                          sales s1=new sales(t8.getText(),t4.getText(),t5.getText(),t6.getText(),t2.getText(),t3.getText());
                          s1.setVisible(true);
                       
                         }
                         else
                         {
                            jOptionPane1.showMessageDialog(null,"Order  Not Update ! "); 
                         }
                        
                         ost.close();
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
          else
          {
              jOptionPane1.showMessageDialog(null,"Please Select Correct status !");
          }
        }
        if(t9.getText().equals("SALED"))
        {
           jOptionPane1.showMessageDialog(null,"This Order Has Been Completed !");
        }
         
    }//GEN-LAST:event_updateActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new manageorder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox c1;
    private javax.swing.JComboBox c3;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton next;
    private javax.swing.JButton prev;
    private javax.swing.JTextField t1;
    private javax.swing.JTextField t2;
    private javax.swing.JTextField t3;
    private javax.swing.JTextField t4;
    private javax.swing.JTextField t5;
    private javax.swing.JTextArea t6;
    private javax.swing.JTextField t7;
    private javax.swing.JTextField t8;
    private javax.swing.JTextField t9;
    private javax.swing.JTable table1;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
