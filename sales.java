
package nmsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.JOptionPane;

public class sales extends javax.swing.JFrame {
    DefaultTableModel model;
    DateFormat dt=new SimpleDateFormat("dd/MM/yyyy");
    Date d1=new Date();
    String d=dt.format(d1);
    String data[][]=new String[100][14];
    Set<String> s;
    int pid;
    int sid;
    int saleid;
    int bid;
    int srno=0;
    int ta=0;
    int aa=0;
    int sta=0;
    int sra=0;
    int spa=0;
    int saa=0;
    int arrayindex=0;
    String sq;
    String cname;

    public sales() {
        initComponents();
        additem();
        s=new TreeSet<String>();
        addcustomer();
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
        model.addColumn("SR. NO");
        model.addColumn("PRODUCT NAME");
        model.addColumn("COST");
        model.addColumn("QUANTITY");
        model.addColumn("AMOUNT (RS)");
        getbillid();
        getsaleid();
        t1.setText(String.valueOf(bid));
        t8.setText("0");

    }
    public sales(String pname,String cname,String cnumber,String cadd,String quantity,String advamt)
    {
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
        t2.setText(d);
        model=new DefaultTableModel();
        table1.setModel(model);
        model.addColumn("SR. NO");
        model.addColumn("PRODUCT NAME");
        model.addColumn("COST");
        model.addColumn("QUANTITY");
        model.addColumn("AMOUNT (RS)");
        getbillid();
        getsaleid();
        t1.setText(String.valueOf(bid));
        String mpname=pname;
        String mcname=cname;
        String mcadd=cadd;
        String mcnumber=cnumber;
        String mcadvamt=advamt;
        String mquantity=quantity;
        t3.setText(mcname);
        t4.setText(mcnumber);
        t5.setText(mcadd);
        t6.setText(mquantity);
        t8.setText(mcadvamt);
        c1.addItem(mpname);

        
    }
public void addcustomer()
{
    try
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
        PreparedStatement pst=con.prepareStatement("select cutomer_name from bill order by bill_id");
        ResultSet rs=pst.executeQuery();
        while(rs.next())
        {
            s.add(rs.getString(1));
        }
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
    public void removeR()
{
    int cnt=model.getRowCount();
       for(int j=0;j<cnt;j++)
       {
        model.removeRow(0);
       }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane1 = new javax.swing.JOptionPane();
        t3 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        t2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        t1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        t4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        t5 = new javax.swing.JTextArea();
        s1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        c1 = new javax.swing.JComboBox();
        t6 = new javax.swing.JTextField();
        t7 = new javax.swing.JTextField();
        t8 = new javax.swing.JTextField();
        t9 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        c2 = new javax.swing.JComboBox();
        t10 = new javax.swing.JTextField();
        t11 = new javax.swing.JTextField();
        t12 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        save = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        t13 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        P1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        t3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t3FocusLost(evt);
            }
        });
        t3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t3KeyReleased(evt);
            }
        });

        jLabel1.setText("CUSTOMER NAME");

        jLabel2.setText("DATE");

        jLabel3.setText("BILL NUMBER");

        jLabel4.setText("MOBILE NUMBER");

        jLabel5.setText("ADDRESS");

        t5.setColumns(20);
        t5.setRows(5);
        jScrollPane1.setViewportView(t5);

        jButton1.setText("SEARCH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SRNO", "PRODUCT NAME", "COST", "QUANTITY", "AMOUNT(RS)"
            }
        ));
        table1.setToolTipText("");
        table1.setShowHorizontalLines(false);
        table1.setShowVerticalLines(false);
        jScrollPane2.setViewportView(table1);

        t6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t6FocusLost(evt);
            }
        });

        t7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t7FocusLost(evt);
            }
        });

        jLabel6.setText("QUANTITY");

        jLabel7.setText("COST");

        jLabel8.setText("ADVANCED AMT");

        jLabel9.setText("TOTAL AMT");

        c2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ADD", "DELETE" }));
        c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c2ActionPerformed(evt);
            }
        });

        jLabel10.setText("Advanced Amount (RS)");

        jLabel11.setText("Remaining Amount n (RS)");

        jLabel12.setText("Total Amount (RS)");

        jButton2.setText("CLEAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        save.setText("SAVE BILL");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        jButton4.setText("CLOSE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel13.setText("PRODUCT NAME");

        jLabel14.setText("Paid Amount (RS)");

        P1.setText("PRINT");
        P1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                P1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t3)
                            .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(t4)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(c1, 0, 115, Short.MAX_VALUE)
                                .addGap(10, 10, 10))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t6, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t7, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t8, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(t9, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(c2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(s1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(t13)
                                    .addComponent(t12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                    .addComponent(t10, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(t11, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(save)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(P1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4)))))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(s1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(P1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        t3.setText("");
        t4.setText("");
        t5.setText("");
        t6.setText("");
        t7.setText("");
        t8.setText("0");
        t9.setText("");
        t10.setText("");
        t11.setText("");
        t12.setText("");
        t13.setText("");
        t1.setText("");
        s1.setText("");
        getbillid();
        t1.setText(String.valueOf(bid));
        removeR();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void c2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c2ActionPerformed
        // TODO add your handling code here:
        if(c2.getSelectedItem().equals("ADD"))
        {
            System.out.println(saleid);
            getpid();
            srno=srno+1;
            model.addRow(new Object[]{srno,c1.getSelectedItem(),t7.getText(),t6.getText(),t9.getText()});
             t10.setText(t8.getText());
             t12.setText(t9.getText());
             aa=aa+Integer.parseInt(t10.getText());
             ta=ta+Integer.parseInt(t12.getText());
             int r=ta-aa;
             t11.setText(String.valueOf(r));
              t12.setText(String.valueOf(ta));
              t13.setText(t11.getText());
             
             
            int dra=Integer.parseInt(t9.getText())-Integer.parseInt(t8.getText());
             
             data[arrayindex][0]=String.valueOf(saleid);
             data[arrayindex][1]=String.valueOf(t1.getText());
             data[arrayindex][2]=String.valueOf(t2.getText());
             data[arrayindex][3]=String.valueOf(pid);
             data[arrayindex][4]=String.valueOf(c1.getSelectedItem());
             data[arrayindex][5]=String.valueOf(t3.getText());
             data[arrayindex][6]=String.valueOf(t4.getText());
             data[arrayindex][7]=String.valueOf(t5.getText());
             data[arrayindex][8]=String.valueOf(t7.getText());
             data[arrayindex][9]=String.valueOf(t6.getText());
             data[arrayindex][10]=String.valueOf(t8.getText());
             data[arrayindex][11]=String.valueOf(dra);
             data[arrayindex][12]=String.valueOf(t9.getText());
             data[arrayindex][13]=String.valueOf(dra);
                        
                          
             arrayindex=arrayindex+1;
             t8.setText("0");
             t9.setText("");
             t6.setText("");
             t7.setText("");
             
             saleid=saleid+1;
  
                c1.removeAllItems();
                          additem();
        }
        if(c2.getSelectedItem().equals("DELETE"))
        {
            
            int rw=table1.getRowCount();
            System.out.println("row="+rw);
            System.out.println(model.getValueAt(rw-1,4));
            int tta=Integer.parseInt((String)model.getValueAt(rw-1,4));
            System.out.println(tta);
            ta=ta-tta;
            int r=ta-aa;
            t11.setText(String.valueOf(r));
            t12.setText(String.valueOf(ta));
            t13.setText(t11.getText());
            model.removeRow(rw-1);
            arrayindex=arrayindex-1;
            if(t12.getText().equals("0"))
            {
                t10.setText("");
                t11.setText("");
                t12.setText("");
                ta=0;
                aa=0;
            }
        }
    }//GEN-LAST:event_c2ActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
        try
        {

            if(t3.getText().equals(""))
            {
                jOptionPane1.showMessageDialog(null,"Please Enter Customername"); 
            }
            else if(t4.getText().equals(""))
            {
                 jOptionPane1.showMessageDialog(null,"Please Enter Mobile Number");
            }
            else if(t5.getText().equals(""))
            {
                 jOptionPane1.showMessageDialog(null,"Please Enter Address");
            }
            else if(t12.getText().equals(""))
            {
                 jOptionPane1.showMessageDialog(null,"Please Add Items");
            }
            else if(t11.getText().equals(""))
            {
                jOptionPane1.showMessageDialog(null,"Remaining Amount Not Found !");
            }
            else
            {    
                if(t10.getText().equals(""))
                    {
                      t9.setText("0");
                    }
                try
                {
                    
                    arrayindex=0;
                    int insertc=0;
                    int i=table1.getRowCount();

                    int rw=0;
                    savebill();
                    while(rw<i)
                    {
                        try
                        {
                            getsid();
                            int stockq=0;
                            Class.forName("oracle.jdbc.driver.OracleDriver");
                            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
                            
                            PreparedStatement pst=con.prepareStatement("select * from stock where plant_name='"+data[rw][4]+"'");
                            ResultSet rs=pst.executeQuery(); 
                            while(rs.next())
                            {
                              stockq=rs.getInt(5);
                            }                        
                            String qn=data[rw][9];
                            int a=Integer.parseInt(qn);
                            stockq=stockq-a;
                      
                            PreparedStatement sst=con.prepareStatement("insert into stock values("+sid+",'"+d+"','"+pid+"','"+data[rw][4]+"',"+stockq+")");
                            int q=sst.executeUpdate();
                            System.out.println("stock ok");

                            PreparedStatement st=con.prepareStatement("insert into sales values("+data[rw][0]+",'"+data[rw][4]+"',"+data[rw][1]+","+data[rw][8]+","+data[rw][9]+","+data[rw][10]+","+data[rw][11]+","+data[rw][12]+","+data[rw][13]+")");
                            int c=st.executeUpdate();
                            System.out.println("sales ok");
                            insertc=insertc+c;
                            
                            sst.close();
                            st.close();
                            pst.close();
                            con.close();
                        
                                               
                        }
                        catch(Exception e)
                        {
                            
                            jOptionPane1.showMessageDialog(null,e);
                           
                        }
                        rw=rw+1;
                    }
                    if(i==insertc)
                            {
                                jOptionPane1.showMessageDialog(null," Bill Save Successfully !"); 
                                printbill();
                            }
                    else
                            {
                                jOptionPane1.showMessageDialog(null," Bill Not Save !");
      
                            }
                    
                    
                }
                catch(Exception e)
                {
                   jOptionPane1.showMessageDialog(null,e);
                }
                
                
             }
        }
        catch(Exception e)
        {
            jOptionPane1.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_saveActionPerformed

    private void t7FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t7FocusLost
        // TODO add your handling code here:
        if(t6.getText().equals("") && t7.getText().equals(""))
        {
            jOptionPane1.showMessageDialog(null," fill Quantity and cost !");
        }
        else
        {
        int q=Integer.parseInt(t6.getText());
        int c=Integer.parseInt(t7.getText());
        int t=q*c;
        t9.setText(String.valueOf(t));
        }
    }//GEN-LAST:event_t7FocusLost

    private void t6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t6FocusLost
        // TODO add your handling code here:
        try
        {
            if(t6.getText().equals(""))
            {
              jOptionPane1.showMessageDialog(null,"Please fill Quantity !");  
            }
            else
            
                        {
                            int stockq=0;
                            Class.forName("oracle.jdbc.driver.OracleDriver");
                            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
                            
                            PreparedStatement pst=con.prepareStatement("select * from stock where plant_name='"+c1.getSelectedItem()+"'");
                            ResultSet rs=pst.executeQuery(); 
                            while(rs.next())
                            {
                              stockq=rs.getInt(5);
                            }
                            
                            if(stockq<Integer.parseInt(t6.getText()))
                            {
                                jOptionPane1.showMessageDialog(null," Available Stock Is Less ("+c1.getSelectedItem()+" Stock is="+stockq+") !"); 
                            }
                        }
            }
    
                        catch(Exception e)
                        {
                            jOptionPane1.showMessageDialog(null,e);
            
                        }
    }//GEN-LAST:event_t6FocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        t3.setText("");
        t4.setText("");
        t5.setText("");
        t6.setText("");
        t7.setText("");
        t8.setText("0");
        t9.setText("");
        t10.setText("");
        t11.setText("");
        t12.setText("");
        t13.setText("");
        t1.setText("");
        sta=0;
        sra=0;
        spa=0;
        saa=0;
        
        int i=1;
        int sr=0;
        String billno=s1.getText();
        
        try
        {
          
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
        PreparedStatement st=con.prepareStatement("select * from bill where bill_id="+billno+"");
        ResultSet rrs=st.executeQuery();
        if(rrs.next())
        {
                t1.setText(String.valueOf(rrs.getInt(1)));
                t2.setText(rrs.getString(2));
                t3.setText(rrs.getString(3));
                t4.setText(rrs.getString(4));
                t5.setText(rrs.getString(5)); 
                rrs.close();
                st.close();
        }
        else
        {
           jOptionPane1.showMessageDialog(null,"Record Not Exist !"); 
           rrs.close();
           st.close();
        }
        
        
        PreparedStatement pst=con.prepareStatement("select * from sales where bill_id="+billno+"");
        ResultSet rs=pst.executeQuery();
        
        if(rs!=null)
        {
            i=0;
            int w=1;
            removeR();
            while(rs.next())
            {
                w=0;
                sr=sr+1;
                sta=sta+rs.getInt(8);
                sra=sra+rs.getInt(7);
                spa=spa+rs.getInt(9);
                saa=saa+rs.getInt(6);
                t10.setText(String.valueOf(saa));
                t11.setText(String.valueOf(sra));
                t12.setText(String.valueOf(sta));
                t13.setText(String.valueOf(spa));
               model.addRow(new Object[]{sr,rs.getString(2),rs.getString(4),rs.getString(5),rs.getInt(8)});
            }
            if(w==1)
            {
              
              t3.setText("");
              t4.setText("");
              t5.setText("");
              t10.setText("");
              t11.setText("");
              t12.setText("");
              t13.setText("");
            }
        }
        billno=null;
        rs.close();
        pst.close();
        con.close();
    }
        catch(Exception e)
        {
            jOptionPane1.showMessageDialog(null,e);
        }
    /*    
    if(i==1)
        {
        
          cname=s1.getText();
          
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
            PreparedStatement ppst=con.prepareStatement("select * from sales where contact_name='"+cname+"'");
            ResultSet rrs=ppst.executeQuery();             
        if(rrs!=null)
        {
            int w=1;
            removeR(); 
            while(rrs.next())
            {
                w=0;
                sr=sr+1;
                t1.setText(String.valueOf(rrs.getInt(2)));
                t2.setText(rrs.getString(3));
                t3.setText(rrs.getString(6));
                t4.setText(rrs.getString(7));
                t5.setText(rrs.getString(8));
                
                sta=sta+rrs.getInt(13);
                sra=sra+rrs.getInt(12);
                spa=spa+rrs.getInt(14);
                saa=saa+rrs.getInt(11);
                t10.setText(String.valueOf(saa));
                t11.setText(String.valueOf(sra));
                t12.setText(String.valueOf(sta));
                t13.setText(String.valueOf(spa));
                model.addRow(new Object[]{sr,rrs.getString(5),rrs.getString(9),rrs.getString(10),rrs.getInt(13)});
              
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
      */  
    }//GEN-LAST:event_jButton1ActionPerformed

    private void t3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t3KeyReleased
        // TODO add your handling code here:
        String to_check=t3.getText();
            int to_check_len=to_check.length();
            for(String data:s)
            {
                String check_from_data="";
                for(int i=0;i<to_check_len;i++)
                {
                    if(to_check_len<=data.length())
                    {
                        check_from_data = check_from_data+data.charAt(i);
                    }
                }
                //System.out.print(check_from_data);
                if(check_from_data.equals(to_check))
                {
                 //System.out.print("Found");
                    t3.setText(data);
                    t3.setSelectionStart(to_check_len);
                    t3.setSelectionEnd(data.length());
                    break;
                }
            }
    }//GEN-LAST:event_t3KeyReleased

    private void t3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t3FocusLost
        // TODO add your handling code here:
        try
        {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
        PreparedStatement pst=con.prepareStatement("select * from bill where cutomer_name='"+String.valueOf(t3.getText())+"'");
        ResultSet rs=pst.executeQuery();
        if(rs.next())
        {
        t4.setText(rs.getString(4));
        t5.setText(rs.getString(5));
        }
        rs.close();
        pst.close();
        con.close();
        }
        catch(Exception e)
        {
           jOptionPane1.showMessageDialog(null,e); 
        }
    }//GEN-LAST:event_t3FocusLost

    private void P1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_P1ActionPerformed
        // TODO add your handling code here:
        printbill();
    }//GEN-LAST:event_P1ActionPerformed

public void getpid()
{
   try
       {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
        
        
        PreparedStatement pst=con.prepareStatement("select plant_id from plats where plant_name='"+c1.getSelectedItem()+"'");
        ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
               pid=rs.getInt(1); 
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
public void getsaleid()
{
   try
       {
        saleid=0;
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
        PreparedStatement pst=con.prepareStatement("select * from sales");
        ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
               saleid=rs.getInt(1); 
            }
            saleid=saleid+1;
            System.out.println(saleid);
            rs.close();
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
            jOptionPane1.showMessageDialog(null,e);
        }   
    
}
public void getbillid()
{
   try
       {
           bid=0;
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
        PreparedStatement pst=con.prepareStatement("select MAX(bill_id) from sales");
        ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
               bid=rs.getInt(1); 
            }
            bid=bid+1;
            t1.setText(String.valueOf(bid));
            System.out.println(bid);
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
                new sales().setVisible(true);
            }
        });
    }
    public void savebill()
    {
        try
        {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
        PreparedStatement bst=con.prepareStatement("insert into bill values("+Integer.parseInt(t1.getText())+",'"+String.valueOf(t2.getText())+"','"+String.valueOf(t3.getText())+"','"+String.valueOf(t4.getText())+"','"+String.valueOf(t5.getText())+"')");
        int b=bst.executeUpdate();
        //System.out.println("bill ok");
        bst.close();
        con.close();
        }
        catch(Exception e)
        {
            jOptionPane1.showMessageDialog(null,e);
        }
    }
    public void printbill()
    {
        printinvoice p=new printinvoice();
        p.billno=Integer.parseInt(t1.getText());
        p.date=t2.getText();
        p.cname=t3.getText();
        p.cnumber=t4.getText();
        p.caddress=t5.getText();
        p.advamt=Integer.parseInt(t10.getText());
        p.remamt=Integer.parseInt(t11.getText());
        p.totalamt=Integer.parseInt(t12.getText());
        p.paidamt=Integer.parseInt(t13.getText());
       int cnt=model.getRowCount();
       System.out.println("cnt="+cnt);
       System.out.println(p.billno);
       System.out.println(p.date);
       System.out.println(p.cname);
       System.out.println(p.cnumber);
       System.out.println(p.caddress);
       System.out.println(p.advamt);
       System.out.println(p.remamt);
       System.out.println(p.totalamt);
       System.out.println(p.paidamt);
       p.rcnt=0;
       for(int j=0;j<cnt;j++)
       {
        for(int k=0;k<5;k++)
        {
            p.data[j][k]=String.valueOf(model.getValueAt(j,k));
            System.out.print(model.getValueAt(j,k)+" ");
        }
        System.out.println("");
        p.rcnt=p.rcnt+1;
        
       }
       System.out.println("array count="+p.rcnt);
       for(int i=0;i<p.rcnt;i++)
          {
             
              for(int j=0;j<5;j++)
              {
                System.out.print(p.data[i][j]+" ");
              }
              System.out.println("");
          }
       p.generatebill();
       
        try
        {
            String bpath=System.getProperty("user.dir");
            String browser=bpath+"\\Chrome\\Application\\chrome.exe";
            String path=System.getProperty("user.dir");
            Runtime.getRuntime().exec(browser+" "+path+"\\Printinvoice.html");
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton P1;
    private javax.swing.JComboBox c1;
    private javax.swing.JComboBox c2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JTextField s1;
    private javax.swing.JButton save;
    private javax.swing.JTextField t1;
    private javax.swing.JTextField t10;
    private javax.swing.JTextField t11;
    private javax.swing.JTextField t12;
    private javax.swing.JTextField t13;
    private javax.swing.JTextField t2;
    private javax.swing.JTextField t3;
    private javax.swing.JTextField t4;
    private javax.swing.JTextArea t5;
    private javax.swing.JTextField t6;
    private javax.swing.JTextField t7;
    private javax.swing.JTextField t8;
    private javax.swing.JTextField t9;
    private javax.swing.JTable table1;
    // End of variables declaration//GEN-END:variables
}
