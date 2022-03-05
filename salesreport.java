
package nmsp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class salesreport 
{
  Connection cn;
  Statement st,bst;
  ResultSet rs,brs;
  int i=0;
  String data[][]=new String[1000][13];
  DateFormat dt=new SimpleDateFormat("dd/MM/yyyy");
  Date d1=new Date();
  String d=dt.format(d1);
salesreport()
{
    try
      {
            int saleid;
            String saledate;
            int billno;
            String cname;
            String cnumber;
            String caddress;
            String pname;
            int pcost;
            int pquantity;
            int advamt;
            int remamt;
            int totalamt;
            int paidamt;
          Class.forName("oracle.jdbc.driver.OracleDriver");
          cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
          st=cn.createStatement();
          bst=cn.createStatement();
          rs=st.executeQuery("select * from sales order by sale_id");
          while(rs.next())
          {
              saleid=rs.getInt(1);
              billno=rs.getInt(3);
              pname=rs.getString(2);
              pcost=rs.getInt(4);
              pquantity=rs.getInt(5);
              advamt=rs.getInt(6);
              remamt=rs.getInt(7);
              totalamt=rs.getInt(8);
              paidamt=rs.getInt(9);
              data[i][0]=String.valueOf(saleid);
              data[i][2]=String.valueOf(billno);
              data[i][6]=String.valueOf(pname);
              data[i][7]=String.valueOf(pcost);
              data[i][8]=String.valueOf(pquantity);
              data[i][9]=String.valueOf(advamt);
              data[i][10]=String.valueOf(remamt);
              data[i][11]=String.valueOf(totalamt);
              data[i][12]=String.valueOf(paidamt);
              
              brs=bst.executeQuery("select * from bill where bill_id="+billno+"");
              brs.next();
              saledate=brs.getString(2);
              cname=brs.getString(3);
              cnumber=brs.getString(4);
              caddress=brs.getString(5);
              
              data[i][1]=saledate;
              data[i][3]=cname;
              data[i][4]=cnumber;
              data[i][5]=caddress;
  
              i=i+1;
              brs.close();
          }
          System.out.println("count="+i);
          bst.close();
          rs.close();
          st.close();
          cn.close();
          
          BufferedWriter bw=new BufferedWriter(new FileWriter("Salesreport.html"));
          bw.write("<center><h2><font color=green>PLANT NESERY MANAGEMENT SYSTEM</font></h2>");
          bw.write("<center><h3><u><b><font color=green>PLANTS SALES REPORT</font></b></u></h3></center>");
          bw.write("<h4 align=left>"+"DATE :- "+d+"</h4>");
          bw.write("<hr><center>");
          bw.write("<table border=1>");
          bw.write("<th><font color=purple>SALE_ID</font>");
          bw.write("<th><font color=purple>SALE_DATE</font>");
          bw.write("<th><font color=purple>BILL_NUMBER</font>");
          bw.write("<th><font color=purple>CUSTOMER_NAME</font>");
          bw.write("<th><font color=purple>CONTACT_NUMBER</font>");
          bw.write("<th><font color=purple>CUSTOMER_ADDRESS</font>");
          bw.write("<th><font color=purple>PLANT_NAME</font>");
          bw.write("<th><font color=purple>PLANT_COST</font>");
          bw.write("<th><font color=purple>PLANT_QUANTITY</font>");
          bw.write("<th><font color=purple>ADVANCED_AMMOUNT</font>");
          bw.write("<th><font color=purple>REMAINING_AMMOUNT</font>");
          bw.write("<th><font color=purple>TOTAL_AMMOUNT</font>");
          bw.write("<th><font color=purple>PAID_AMMOUNT</font>");
          for(int k=0;k<i;k++)
          {
           bw.write("<tr>");
           for(int j=0;j<13;j++)
           {
               bw.write("<td>"+data[k][j]);
           }
             
          }

             bw.write("</table>");
             bw.write("</center>");
             bw.close();
             rs.close();
             st.close();
             cn.close();
           }
      catch(Exception e)
      {
          System.out.println(e);
      } 
}
}
