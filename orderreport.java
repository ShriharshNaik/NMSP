
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

public class orderreport 
{
  Connection cn;
  Statement st;
  ResultSet rs;
  DateFormat dt=new SimpleDateFormat("dd/MM/yyyy");
  Date d1=new Date();
  String d=dt.format(d1);
  
orderreport()
{
  try
      {
          Class.forName("oracle.jdbc.driver.OracleDriver");
          cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
          st=cn.createStatement();
          rs=st.executeQuery("select * from plantorder order by order_id");
          
          BufferedWriter bw=new BufferedWriter(new FileWriter("Orderreport.html"));
          ResultSetMetaData rsm=rs.getMetaData();
          int cols=rsm.getColumnCount();
          //bw.write("<body bgcolor=silver align=center");
          bw.write("<center><h2><font color=green>PLANT NESERY MANAGEMENT SYSTEM</font></h2>");
          bw.write("<center><h3><u><b><font color=green>PLANTS ORDER REPORT</font></b></u></h3></center>");
          bw.write("<h4 align=left>"+"DATE :- "+d+"</h4>");
          bw.write("<hr><center>");
          bw.write("<table border=1>");
          bw.write("<tr>");
           for(int i=1;i<=cols;i++)
            bw.write("<th><font color=purple>"+rsm.getColumnLabel(i)+"</font>");
            while(rs.next())
           {
             bw.write("<tr>");
             for(int i=1;i<=cols;i++)
             bw.write("<td>"+rs.getString(i));
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
