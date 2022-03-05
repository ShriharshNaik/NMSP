
package nmsp;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class login extends javax.swing.JFrame {

    public login() {
        initComponents();
        Dimension ss=Toolkit.getDefaultToolkit().getScreenSize();
        double sh=ss.getHeight();
        double sw=ss.getWidth();
        int csh=(int)sh;
        int csw=(int)sw;
        this.setSize(650,400);
        csh=csh/4;
        csw=csw/4;
        this.setLocation(csw, csh);
       l1.setSize(650,400);
       l1.setBounds(0,0,650,400);
        hpanel.setSize(250,240);
        hpanel.setBackground(new Color(0,0,0,90));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane1 = new javax.swing.JOptionPane();
        hpanel = new javax.swing.JPanel();
        b1 = new javax.swing.JButton();
        username = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        b2 = new javax.swing.JButton();
        l2 = new javax.swing.JLabel();
        l3 = new javax.swing.JLabel();
        l1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        hpanel.setPreferredSize(new java.awt.Dimension(900, 100));

        b1.setText("LOGIN");
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });

        username.setBorder(null);
        username.setCaretColor(new java.awt.Color(0, 153, 0));

        password.setBorder(null);

        b2.setText("CLOSE");
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });

        l2.setForeground(new java.awt.Color(255, 255, 255));
        l2.setText("USERNAME");

        l3.setForeground(new java.awt.Color(255, 255, 255));
        l3.setText("PASSWORD");

        javax.swing.GroupLayout hpanelLayout = new javax.swing.GroupLayout(hpanel);
        hpanel.setLayout(hpanelLayout);
        hpanelLayout.setHorizontalGroup(
            hpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hpanelLayout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(hpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(l3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                    .addComponent(l2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        hpanelLayout.setVerticalGroup(
            hpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, hpanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(l2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(l3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        getContentPane().add(hpanel);
        hpanel.setBounds(320, 90, 250, 240);

        l1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images (30).jpeg"))); // NOI18N
        getContentPane().add(l1);
        l1.setBounds(20, 160, 120, 100);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
        // TODO add your handling code here:
        dispose();
        
    }//GEN-LAST:event_b2ActionPerformed

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        // TODO add your handling code here:
        try
        {
            String u=username.getText();
            String p=password.getText();
            int i=0;
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mnsp","root","Neel@1234");
            PreparedStatement pst=con.prepareStatement("select * from login");
            ResultSet rs=pst.executeQuery();
            while(rs.next())
            {
               
                if(u.equals(rs.getString(1)) && p.equals(rs.getString(2)))
                {
                 i=1; 
                }

            }
            if(i==1)
            {
                
                jOptionPane1.showMessageDialog(null,"login success");
                dispose();
                new home().setVisible(true);
            }
            else
                
            {
             jOptionPane1.showMessageDialog(null,"login failed");  
            }
            rs.close();
            pst.close();
            con.close();
        }
        catch(Exception e)
        {
           jOptionPane1.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_b1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JPanel hpanel;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l2;
    private javax.swing.JLabel l3;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
