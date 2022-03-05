
package nmsp;
import java.sql.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
public class plantreport 
{
  Connection cn;
  Statement st;
  ResultSet rs;
  DateFormat dt=new SimpleDateFormat("dd/MM/yyyy");
  java.util.Date d1=new java.util.Date();
  String d=dt.format(d1);
  plantreport()
  {
      try
      {
          Class.forName("oracle.jdbc.driver.OracleDriver");
          cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123");
          st=cn.createStatement();
          rs=st.executeQuery("select * from plats order by plant_id");
          
          BufferedWriter bw=new BufferedWriter(new FileWriter("Plantreport.html"));
          ResultSetMetaData rsm=rs.getMetaData();
          int cols=rsm.getColumnCount();
          bw.write("<center><h2><font color=green>PLANT NESERY MANAGEMENT SYSTEM</font></h2>");
          bw.write("<center><h3><u><b><font color=green>PLANTS REPORT</font></b></u></h3></center>");
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
 public static void main(String args[])
 {
     
 }
    
}
