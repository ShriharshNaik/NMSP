
package nmsp;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class printinvoice 
{
int rcnt;
int billno;
String date;
String cname;
String cnumber;
String caddress;
int advamt;
int remamt;
int totalamt;
int paidamt;
String data[][]=new String[100][5];

public void generatebill()
{
    
       System.out.println(billno);
       System.out.println(date);
       System.out.println(cname);
       System.out.println(cnumber);
       System.out.println(caddress);
       System.out.println(advamt);
       System.out.println(remamt);
       System.out.println(totalamt);
       System.out.println(paidamt);
       for(int i=0;i<rcnt;i++)
          {
             
              for(int j=0;j<5;j++)
              {
                System.out.print(data[i][j]+" ");
              }
              System.out.println("");
          }
    try
    {
        
        
        
         
          BufferedWriter bw=new BufferedWriter(new FileWriter("Printinvoice.html"));
          
          bw.write("<center><h2><font color=green>PLANT NESERY MANAGEMENT SYSTEM</font></h2>");
          bw.write("<center><h3><u><b><font color=green>INVOICED DETAILES</font></b></u></h3>");
          //bw.write("<div style=height:300px;width:300px>");
          bw.write("<table height=150 width=650>");
          bw.write("<tr>");
          bw.write("<td>Bill No. :-&nbsp;&nbsp;"+billno+"</td><td align=right>Date :-&nbsp;&nbsp;"+date+"</td></tr>");
          bw.write("<tr colspane=2><td>Customer Name   :-&nbsp;&nbsp;"+cname+"</td></tr>");
          bw.write("<tr colspane=2><td>Contact Number  :-&nbsp;&nbsp;"+cnumber+"</td></tr>");
          bw.write("<tr colspane=2><td>Contact Address :-&nbsp;&nbsp;"+caddress+"</td></tr></center>");
          bw.write("</table>");
          bw.write("<hr><center>");
          bw.write("<table width=650>");
          bw.write("<th><font color=purple>SRNO.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font>");
          bw.write("<th><font color=purple>PRODUCT_NAME&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font>");
          bw.write("<th><font color=purple>COST&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font>");
          bw.write("<th><font color=purple>QUANTITY&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font>");
          bw.write("<th><font color=purple>AMMOUNT_(RS)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font>");
          for(int i=0;i<rcnt;i++)
          {
              bw.write("<tr>");
              for(int j=0;j<5;j++)
              {
                  bw.write("<td>"+data[i][j]);
              }
          }

          bw.write("</table>");
          bw.write("<br><br><br><br>");
          bw.write("<table height=150 width=650>");
          bw.write("<tr><td align=right>Advanced Ammount(RS)&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;"+advamt);
          bw.write("<br>Remaining Ammount(RS):&nbsp&nbsp;&nbsp;;&nbsp;&nbsp;&nbsp;"+remamt);
          bw.write("<br>Total Ammount(RS)&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;"+totalamt);
          bw.write("<br>Paid Ammount(RS)&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;"+paidamt+"</td></tr>");
          //bw.write("</div");
          bw.write("</center>");
          bw.close();
          
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
}
}
