
package nmsp;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import jaco.mp3.player.MP3Player;
import java.io.*;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;


public final class home extends javax.swing.JFrame {
    public static final String song="C:\\Users\\lenovo\\Desktop\\javaproject\\nmsp\\src\\images\\Ascensions.mp3";
    MP3Player mp=new MP3Player(new File(song)); 
    int nfc=0;
    int stcnt=0;
    String stname[]=new String[100];
    String  oname[]=new String[100];
    
    int onamec=0;

    public home() {
        
        initComponents();
        Dimension ss=Toolkit.getDefaultToolkit().getScreenSize();
        double sh=ss.getHeight();
        double sw=ss.getWidth();
        int csh=(int)sh;
        int csw=(int)sw;
        this.setSize(ss);
        lb.setBounds(0,0, csw, csh);
        panelnf.setBounds(csw-350,csh-450,350,450);
        panelnf.setBackground(new Color(0,0,0,80));
        panelnf.setVisible(false);
       getnotification();
       shownotification();
        mp.play();
        
        
        
    }
   
   
    public void getnotification()
    {
        
        
        try
        {
            String pname[]=new String[20];
            int pstock[] =new int[20];
            int i=0;
            int j=0;
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
            PreparedStatement ppst=con.prepareStatement("select * from plats");
            System.out.println("ok");
            ResultSet rrs=ppst.executeQuery();
            while(rrs.next())
            {
                pname[i]=rrs.getString(2);
                i=i+1;
            }
            for(int k=0;k<=i;k++)
            {
                System.out.println("ok");
            PreparedStatement qst=con.prepareStatement("select stock_quantity from stock where plant_name='"+pname[k]+"'");
            ResultSet qs=qst.executeQuery();
            System.out.println("ok");
            while(qs.next())
            {
                pstock[j]=qs.getInt(5);
                
            }
            j=j+1;
            qs.close();
            qst.close();
            }
            
            for(int z=0;z<=j;j++)
            {
            if(pstock[z]<100)
            {
            stname[z]=pname[z];
            nfc=nfc+1;
            
            }
            
            }
            System.out.println("ok");
            String a="ACTIVE";
          PreparedStatement st=con.prepareStatement("select * from plantorder where order_status='"+a+"'");
          ResultSet s=st.executeQuery();
          int x=0;
          System.out.println("ok");
          while(s.next())
          {
              oname[x]=s.getString(4);
              nfc=nfc+1;
              x=x+1;
          }
          
          s.close();
          st.close();
          rrs.close();
          ppst.close();
            con.close();
            
            
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        
    }
    public void shownotification()
    {
        try
        {
            if(nfc>0)
            {
                panelnf.setVisible(true);
                clearlabel();
                showlabel();
                
            }
            
        }
        catch(Exception e)
        {
          jOptionPane1.showMessageDialog(null,e);  
        }
    }
    public void clearlabel()
    {
        nl1.setText("");
        nl2.setText("");
        nl3.setText("");
        nl4.setText("");
        nl5.setText("");
        nl6.setText("");
        nl7.setText("");
        nl8.setText("");
        nl9.setText("");
        nl10.setText("");
        nl11.setText("");
        nl12.setText("");
    }
    public void showlabel()
    {
        System.out.println("showblock");
       String s="";
       int sc=0;
       int nc=0;
       
       nl1.setText("You have "+nfc+" new notification");
      
       for(int i=0;i<stcnt;i++)
       {
        s=s+stname[i];  
        
       }
       
       mp.play();
       s=s+" stock is less than 100";
       
       System.out.println("s="+s);
       
       nl2.setText(s);
       
       for(int i=0;i<onamec;i++)
       {
           nc=nc+1;
       }
       if(nc>0)
       {
        nl3.setText("Order of "+oname[0]+" is active ");
        nc=nc-1;
        
       }
       if(nc>0)
       {
        nl4.setText("Order of "+oname[1]+" is active ");
        nc=nc-1;  
        
       }
       if(nc>0)
       {
        nl5.setText("Order of "+oname[2]+" is active ");
        nc=nc-1;  
        
       }
        if(nc>0)
       {
        nl6.setText("Order of "+oname[3]+" is active ");
        nc=nc-1;
        
       }
       if(nc>0)
       {
        nl7.setText("Order of "+oname[4]+" is active ");
        nc=nc-1;  
        
       }
       if(nc>0)
       {
        nl8.setText("Order of "+oname[5]+" is active ");
        nc=nc-1;  
        
       }
       if(nc>0)
       {
        nl9.setText("Order of "+oname[6]+" is active ");
        nc=nc-1;  
        
       }
       if(nc>0)
       {
        nl10.setText("Order of "+oname[7]+" is active ");
        nc=nc-1;  
      
       }
       if(nc>0)
       {
        nl11.setText("Order of "+oname[8]+" is active ");
        nc=nc-1;  
        
       }
       if(nc>0)
       {
        nl12.setText("Order of "+oname[9]+" is active ");
        nc=nc-1;  
        
       }
       
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane1 = new javax.swing.JOptionPane();
        panelnf = new javax.swing.JPanel();
        nl1 = new javax.swing.JLabel();
        nl2 = new javax.swing.JLabel();
        nl3 = new javax.swing.JLabel();
        nl4 = new javax.swing.JLabel();
        nl5 = new javax.swing.JLabel();
        nl6 = new javax.swing.JLabel();
        nl7 = new javax.swing.JLabel();
        nl8 = new javax.swing.JLabel();
        nl9 = new javax.swing.JLabel();
        nl10 = new javax.swing.JLabel();
        nl11 = new javax.swing.JLabel();
        nl12 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        lb = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        nl1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nl1.setForeground(new java.awt.Color(255, 255, 255));
        nl1.setText("You have 3 new notfivation");

        nl2.setForeground(new java.awt.Color(255, 255, 255));
        nl2.setText("jLabel2");

        nl3.setForeground(new java.awt.Color(255, 255, 255));
        nl3.setText("jLabel3");

        nl4.setForeground(new java.awt.Color(255, 255, 255));
        nl4.setText("jLabel4");

        nl5.setForeground(new java.awt.Color(255, 255, 255));
        nl5.setText("jLabel5");

        nl6.setForeground(new java.awt.Color(255, 255, 255));
        nl6.setText("jLabel6");

        nl7.setForeground(new java.awt.Color(255, 255, 255));
        nl7.setText("jLabel7");

        nl8.setForeground(new java.awt.Color(255, 255, 255));
        nl8.setText("jLabel8");

        nl9.setForeground(new java.awt.Color(255, 255, 255));
        nl9.setText("jLabel9");

        nl10.setForeground(new java.awt.Color(255, 255, 255));
        nl10.setText("jLabel10");

        nl11.setForeground(new java.awt.Color(255, 255, 255));
        nl11.setText("jLabel11");

        nl12.setForeground(new java.awt.Color(255, 255, 255));
        nl12.setText("jLabel12");

        lb2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb2.setForeground(new java.awt.Color(255, 255, 255));
        lb2.setText("CLOSE");
        lb2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb2MouseEntered(evt);
            }
        });

        javax.swing.GroupLayout panelnfLayout = new javax.swing.GroupLayout(panelnf);
        panelnf.setLayout(panelnfLayout);
        panelnfLayout.setHorizontalGroup(
            panelnfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelnfLayout.createSequentialGroup()
                .addGroup(panelnfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelnfLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(panelnfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nl1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nl2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelnfLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelnfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nl4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nl3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nl5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nl6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nl7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nl8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nl9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nl10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nl11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nl12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelnfLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelnfLayout.setVerticalGroup(
            panelnfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelnfLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(nl1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(nl2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nl3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nl4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nl5, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nl6, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nl7, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nl8, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nl9, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nl10, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nl11, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nl12, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(lb2)
                .addGap(119, 119, 119))
        );

        getContentPane().add(panelnf);
        panelnf.setBounds(500, 10, 350, 450);

        lb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/28.jpg"))); // NOI18N
        getContentPane().add(lb);
        lb.setBounds(40, 150, 80, 90);

        jMenu2.setText("Plant_Master");

        jMenuItem2.setText("ADD PLANTS");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        jMenu7.setText("Stock_Master");

        jMenuItem1.setText("MANAGE STOCK");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem1);

        jMenuBar1.add(jMenu7);

        jMenu3.setText("Order_Master");

        jMenuItem3.setText("NEW ORDER");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuItem11.setText("PROCESS ORDER");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem11);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Sales_Master");

        jMenuItem4.setText("CREATE INVOICE");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Report");

        jMenuItem6.setText("PLANT REPORT");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem6);

        jMenuItem7.setText("STOCK REPORT");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem7);

        jMenuItem8.setText("ORDER REPORT");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem8);

        jMenuItem14.setText("SALES REPORT");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem14);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Help");

        jMenuItem13.setText("ABOUT");
        jMenu6.add(jMenuItem13);

        jMenuItem5.setText("BACKUP");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem5);

        jMenuItem9.setText("RESTORE");
        jMenu6.add(jMenuItem9);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        new plant().setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        new stock().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        new order().setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:
        new manageorder().setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        new sales().setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void lb2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb2MouseClicked
        // TODO add your handling code here:
        clearlabel();
        panelnf.setVisible(false);
    }//GEN-LAST:event_lb2MouseClicked

    private void lb2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb2MouseEntered
        // TODO add your handling code here:
     
    }//GEN-LAST:event_lb2MouseEntered

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
   
        plantreport p=new plantreport();
        try
        {
            String bpath=System.getProperty("user.dir");
            String browser=bpath+"\\Chrome\\Application\\chrome.exe";
            String path=System.getProperty("user.dir");
            Runtime.getRuntime().exec(browser+" "+path+"\\Plantreport.html");
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        stockreport s=new stockreport();
        try
        {
            String bpath=System.getProperty("user.dir");
            String browser=bpath+"\\Chrome\\Application\\chrome.exe";
            String path=System.getProperty("user.dir");
            Runtime.getRuntime().exec(browser+" "+path+"\\Stockreport.html");
        }
        catch (Exception e)
        {
           jOptionPane1.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        orderreport s=new orderreport();
        try
        {
            String bpath=System.getProperty("user.dir");
            String browser=bpath+"\\Chrome\\Application\\chrome.exe";
            String path=System.getProperty("user.dir");
            Runtime.getRuntime().exec(browser+" "+path+"\\Orderreport.html");
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        // TODO add your handling code here:
        salesreport p=new salesreport();
        try
        {
            String bpath=System.getProperty("user.dir");
            String browser=bpath+"\\Chrome\\Application\\chrome.exe";
            String path=System.getProperty("user.dir");
            Runtime.getRuntime().exec(browser+" "+path+"\\Salesreport.html");
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    public static void main(String args[]) {
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new home().setVisible(true);
               
               
              
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel nl1;
    private javax.swing.JLabel nl10;
    private javax.swing.JLabel nl11;
    private javax.swing.JLabel nl12;
    private javax.swing.JLabel nl2;
    private javax.swing.JLabel nl3;
    private javax.swing.JLabel nl4;
    private javax.swing.JLabel nl5;
    private javax.swing.JLabel nl6;
    private javax.swing.JLabel nl7;
    private javax.swing.JLabel nl8;
    private javax.swing.JLabel nl9;
    private javax.swing.JPanel panelnf;
    // End of variables declaration//GEN-END:variables
}
