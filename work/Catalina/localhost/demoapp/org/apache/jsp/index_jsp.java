/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.56
 * Generated at: 2020-02-04 17:39:54 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.net.*;
import java.io.*;
import java.sql.*;
import com.ibm.db2.jcc.*;
import oracle.jdbc.driver.*;
import oracle.jdbc.OracleDriver;
import java.util.*;
import javax.servlet.*;
import org.json.simple.*;
import org.json.simple.parser.*;
import java.net.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/read_session.jsp", Long.valueOf(1527219588000L));
    _jspx_dependants.put("/init.jsp", Long.valueOf(1527219588000L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"ShowError.jsp", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write(" \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

String serverIP = request.getLocalAddr();
String hostname, serverAddress;
hostname = "error";
serverAddress = "error";
try {
   InetAddress inetAddress;
   inetAddress = InetAddress.getLocalHost();
   hostname = inetAddress.getHostName();
   serverAddress = inetAddress.toString();
} catch (UnknownHostException e) {
   e.printStackTrace();
}

      out.write('\n');
      out.write('\n');

String sessionid = "";
if (request.getParameter("sessionid") == null) {
   //session.invalidate();
   sessionid = UUID.randomUUID().toString();
} else {
   sessionid = (String) request.getParameter("sessionid");
}
String uri = request.getRequestURI();
String pageName = uri.substring(uri.lastIndexOf("/")+1);
String cdsid = (String)session.getAttribute("cdsid");
//
// Application Pages ...
//
String marr[] = new String[3];
marr[0] = "index";
marr[1] = "index_app";
marr[2] = "masking_app";
//
// Rows per Page Selections ...
//
int arr[] = new int[10];
arr[0] = 5;
arr[1] = 10;
arr[2] = 20;
arr[3] = 25;
arr[4] = 50;
arr[5] = 100;
arr[6] = 200;
arr[7] = 500;
arr[8] = 1000;
arr[9] = 5000;
session.setAttribute("rows_per_page",arr);
int[] rows_per_page_arr = (int[])session.getAttribute("rows_per_page");

      out.write('\n');

//
// Application Variables ...
//
int icnt = 0;
int ipage = 0;
int itotal = 0;
String isearch = "";
String sortname = "";
String sortdirection = "";
String ifilter = "";
String json_default = "{ \"session_name\": \"default\" ,\"cdsid\": \"ezstore\" ,\"pages\": { \"index.jsp\": { \"icnt\": 5 , \"ipage\": 1 , \"itotal\": 0 , \"sortname\": \"\" , \"sortdirection\": \"\" , \"isearch\": \"\" , \"ifilter\": {\"\": \"\"} } , \"index_app.jsp\": { \"icnt\": 10 , \"ipage\": 1 , \"itotal\": 0 , \"sortname\": \"\" , \"sortdirection\": \"ASC\" , \"isearch\": \"\" , \"ifilter\": {\"\": \"\"} } , \"masking_app.jsp\": { \"icnt\": 10 , \"ipage\": 1 , \"itotal\": 0 , \"sortname\": \"\" , \"sortdirection\": \"ASC\" , \"isearch\": \"\" , \"ifilter\": {\"\": \"\"} } } } ";

//out.println("sessionid: "+sessionid+" cdsid: "+cdsid+" pageName:"+pageName+"<br />");

//
// Session File Information ...
//
String path = "";
String webRootPath = application.getRealPath("/").replace('\\', '/');
// ... or ... webRootPath = getServletContext().getRealPath("/").replace('\\', '/');
//out.println("Path "+webRootPath+"<br />");

path = webRootPath+File.separator+"META-INF"+File.separator;

String sessionFilename = path+"session_"+cdsid+"_"+sessionid+".json";
String defaultFilename = path+"session_"+cdsid+"_default.json";
String masterFilename = path+"session_demoapp_default.json";

//out.println("fn: "+masterFilename+"<br />");

File sessionFile = new File(sessionFilename);
File defaultFile = new File(defaultFilename);
File masterFile = new File(masterFilename);

//
// Check for a new User/File ...
//
if ( !masterFile.exists() ) {
   try {
     PrintWriter sout = new PrintWriter(masterFilename);
     sout.println( json_default );
     sout.close();
   } catch (Exception e) {
      e.printStackTrace();
   }
}
//
// Check for a new User/File ...
//
if ( !sessionFile.exists() ) {
   if ( !defaultFile.exists() ) {
      try {
         FileInputStream fileInputStream = new FileInputStream(masterFilename);
         FileOutputStream fileOutputStream = new FileOutputStream(defaultFilename);
         FileOutputStream fileOutputStream1 = new FileOutputStream(sessionFilename);
         int bufferSize;
         byte[] bufffer = new byte[512];
         while ((bufferSize = fileInputStream.read(bufffer)) > 0) {
            fileOutputStream.write(bufffer, 0, bufferSize);
            fileOutputStream1.write(bufffer, 0, bufferSize);

         }
         fileInputStream.close();
         fileOutputStream.close();
         fileOutputStream1.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
   } else { 
      try {
         FileInputStream fileInputStream = new FileInputStream(defaultFile);
         FileOutputStream fileOutputStream = new FileOutputStream(sessionFile);
         int bufferSize;
         byte[] bufffer = new byte[512];
         while ((bufferSize = fileInputStream.read(bufffer)) > 0) {
            fileOutputStream.write(bufffer, 0, bufferSize);
         }
         fileInputStream.close();
         fileOutputStream.close();
      } catch (Exception e) {
         e.printStackTrace();
      } 
   }   
}

// out.println("sessionFilename: "+sessionFilename+"<br />");

//
// Read Session File JSON Data Parameters ...
//
try {

   JSONParser parser = new JSONParser();

   Object obj = parser.parse(new FileReader(sessionFilename));

   JSONObject jsonObject = (JSONObject) obj;

   /*
   for(Iterator iterator = jsonObject.keySet().iterator(); iterator.hasNext();) {
      String key = (String) iterator.next();
      out.println(key + "---" + jsonObject.get(key));
      out.println("<br />");
   }
   */

   // 
   // Get Session Name ...
   //
   String session_name = (String) jsonObject.get("session_name");
   //out.println("session_name: "+session_name+"<br />");
	  
   //
   // Process Pages ... 
   //
   JSONObject pobj = (JSONObject) jsonObject.get("pages");
   for(Iterator iterator = pobj.keySet().iterator(); iterator.hasNext();) {
      String key = (String) iterator.next();
      //out.println(key + " --- " + pobj.get(key) + "<br />");
      //
      // Get Current Page Data ...
      //
      if (key.equals(pageName)) {
         JSONObject pg = (JSONObject) pobj.get(pageName); 
/*********
         for (Iterator iterator3 = pg.keySet().iterator(); iterator3.hasNext();) {
            String key3 = (String) iterator3.next();
            out.println(key3 + " --- " + pg.get(key3) + "<br />");
         }
*********/
	 long lcnt = (Long) pg.get("icnt");
         icnt = (int)lcnt;
         long lpage = (Long) pg.get("ipage");
         ipage = (int)lpage;
         long ltotal = (Long) pg.get("itotal");
         itotal = (int)ltotal;
         isearch = (String) pg.get("isearch");
         sortname = (String) pg.get("sortname");
         sortdirection = (String) pg.get("sortdirection");

         JSONObject fobj = (JSONObject) pg.get("ifilter");
         for (Iterator iterator2 = fobj.keySet().iterator(); iterator2.hasNext();) {
            String key2 = (String) iterator2.next();
            //out.println(key2 + " --- " + fobj.get(key2));
            ifilter = ifilter+key2+":"+fobj.get(key2)+"::";
            //out.println("<br />");
         }

      }      // if key ...
   }         // for pobj iterator ...

   /* 
   out.println("icnt = "+String.valueOf(icnt)+" | ");
   out.println("ipage = "+String.valueOf(ipage)+" | ");
   out.println("itotal = "+String.valueOf(itotal)+" | ");
   out.println("isearch = "+isearch+" | ");
   out.println("sortname = "+sortname+" | ");
   out.println("sortdirection = "+sortdirection+" | ");
   out.println("ifilter = "+ifilter+"<br />");
   out.println("<hr />");
   */

} catch (Exception e) {
   out.println(e);
}   


      out.write('\r');
      out.write('\n');
      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        ");
      out.write("\n");
      out.write("        <link href=\"./bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\" media=\"screen\"/>\n");
      out.write("        <title>Delphix Demo Applications</title>\n");
      out.write("        <link rel=\"shortcut icon\" href=\"favicon.ico?v=3\" />\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            body {\n");
      out.write("                padding-top: 20px;\n");
      out.write("                padding-bottom: 60px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .source {\n");
      out.write("                background-color: pink;\n");
      out.write("            }\n");
      out.write("            .target {\n");
      out.write("                background-color: brown;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Custom container */\n");
      out.write("            .container {\n");
      out.write("                margin: 0 auto;\n");
      out.write("                max-width: 1000px;\n");
      out.write("            }\n");
      out.write("            .container > hr {\n");
      out.write("                margin: 60px 0;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Main marketing message and sign up button */\n");
      out.write("            .jumbotron {\n");
      out.write("                margin: 80px 0;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            .jumbotron h1 {\n");
      out.write("                font-size: 100px;\n");
      out.write("                line-height: 1;\n");
      out.write("            }\n");
      out.write("            .jumbotron .lead {\n");
      out.write("                font-size: 24px;\n");
      out.write("                line-height: 1.25;\n");
      out.write("            }\n");
      out.write("            .jumbotron .btn {\n");
      out.write("                font-size: 21px;\n");
      out.write("                padding: 14px 24px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Supporting marketing content */\n");
      out.write("            .marketing {\n");
      out.write("                margin: 60px 0;\n");
      out.write("            }\n");
      out.write("            .marketing p + h4 {\n");
      out.write("                margin-top: 28px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /* Customize the navbar links to be fill the entire space of the .navbar */ \n");
      out.write("            .navbar .navbar-inner {\n");
      out.write("                padding: 0;\n");
      out.write("            }\n");
      out.write("            .navbar .nav {\n");
      out.write("                margin: 0;\n");
      out.write("                display: table;\n");
      out.write("                width: 100%;\n");
      out.write("            }\n");
      out.write("            .navbar .nav li {\n");
      out.write("                display: table-cell;\n");
      out.write("                width: 0%;\n");
      out.write("                float: none;\n");
      out.write("            }\n");
      out.write("            .navbar .nav li a {\n");
      out.write("                font-weight: bold;\n");
      out.write("                text-align: center;\n");
      out.write("                border-left: 1px solid rgba(255,255,255,.75);\n");
      out.write("                border-right: 1px solid rgba(0,0,0,.1);\n");
      out.write("            }\n");
      out.write("            .navbar .nav li:first-child a {\n");
      out.write("                border-left: 0;\n");
      out.write("                border-radius: 3px 0 0 3px;\n");
      out.write("            }\n");
      out.write("            .navbar .nav li:last-child a {\n");
      out.write("                border-right: 0;\n");
      out.write("                border-radius: 0 3px 3px 0;\n");
      out.write("            }\n");
      out.write("            .box {\n");
      out.write("                width: 800px;\n");
      out.write("                height: 300px;\n");
      out.write("                position: relative;\n");
      out.write("                background: -webkit-linear-gradient(top, #888 0%,#fff 30%);\n");
      out.write("                box-shadow: 3px 3px 5px #666;\n");
      out.write("                padding: 12px\n");
      out.write("            }           \n");
      out.write("            .box1 {\n");
      out.write("                width: 800px;\n");
      out.write("                height: 350px;\n");
      out.write("                position: relative;\n");
      out.write("                background: -webkit-linear-gradient(top, #ccebff 0%,#fff 30%);\n");
      out.write("                box-shadow: 3px 3px 5px #666;\n");
      out.write("                padding: 12px;\n");
      out.write("            }           \n");
      out.write("            .box2 {\n");
      out.write("                width: 500px;\n");
      out.write("                height: 110px;\n");
      out.write("                position: relative;\n");
      out.write("                background: -webkit-linear-gradient(top, #ccebff 0%,#fff 30%);\n");
      out.write("                box-shadow: 3px 3px 5px #666;\n");
      out.write("                padding: 5px;\n");
      out.write("            }   \n");
      out.write("            .box3 {\n");
      out.write("                width: 500px;\n");
      out.write("                height: 115px;\n");
      out.write("                position: relative;\n");
      out.write("                background: -webkit-linear-gradient(top, #ccebff 0%,#fff 30%);\n");
      out.write("                box-shadow: 3px 3px 5px #666;\n");
      out.write("                padding: 5px;\n");
      out.write("                font-size: 12px;\n");
      out.write("            }                       \n");
      out.write("            .accordion {\n");
      out.write("                background-color: #eee;\n");
      out.write("                color: #444;\n");
      out.write("                cursor: pointer;\n");
      out.write("                padding: 2px;\n");
      out.write("                width: 100%;\n");
      out.write("                border: none;\n");
      out.write("                text-align: left;\n");
      out.write("                outline: none;\n");
      out.write("                font-size: 15px;\n");
      out.write("                transition: 0.4s;\n");
      out.write("            }\n");
      out.write("            .active, .accordion:hover {\n");
      out.write("                background-color: #ccc;\n");
      out.write("            }\n");
      out.write("            .panel {\n");
      out.write("                padding: 0 18px;\n");
      out.write("                display: none;\n");
      out.write("                background-color: white;\n");
      out.write("                overflow: hidden;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("        <link href=\"./bootstrap/css/bootstrap-responsive.min.css\" rel=\"stylesheet\" media=\"screen\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("<table border=0 style=\"background-color:black;width:100%;\">\n");
      out.write("<tr>\n");
      out.write("<td width=\"40%\" align=\"center\" valign=\"top\" style=\"padding-left:100px;\"><a href=\"\"><image src=\"img/delphix-logo-white.png\" /></a></td>\n");
      out.write("<td align=\"center\">\n");
      out.write("<span style=\"font-size:18pt;\"><font color=\"#1AD6F5\">Welcome to Delphix Demo Applications</font></span>\n");
      out.write("</td>\n");
      out.write("</tr>\n");
      out.write("</table>\n");
      out.write("\n");
      out.write("<hr size=\"3\" color=\"teal\" />\n");
      out.write("\n");
      out.write("<center>\n");
      out.write("<div class = \"box1\">\n");
      out.write("<table border=0 width=\"700\" style=\"font-size:11pt;\">\n");
      out.write("\n");
      out.write("<tr>\n");
      out.write("<th>Database Vendor</th>\n");
      out.write("<th>Source Applications</th>\n");
      out.write("<th>Break Fix</th>\n");
      out.write("<th>Dev</th>\n");
      out.write("<th>QA</th>\n");
      out.write("<!-- th>Masking</th -->\n");
      out.write("</tr>\n");
      out.write("\n");
      out.write("<!-- MS SQL Server -->\n");
      out.write("<tr>\n");
      out.write("<td height=90 align=\"center\"><image src=\"img/mssql_logo.png\" width=125><br /><br /></td>\n");
      out.write("<td align=\"center\">\n");
      out.write("<a href=\"redirect.jsp?sessionid=");
      out.print(sessionid);
      out.write("&dbType=mssql&dataSource=mssql_source&sqlUpper=yes&dbname=winsrc1&envtype=Source%20DB\">winsrc1</a>\n");
      out.write("</td>\n");
      out.write("<td align=\"center\">\n");
      out.write("<a href=\"redirect.jsp?sessionid=");
      out.print(sessionid);
      out.write("&dbType=mssql&dataSource=mssql_target&sqlUpper=yes&dbname=vwin1&envtype=Break%20Fix\">vwin1</a>\n");
      out.write("</td>\n");
      out.write("<td align=\"center\">\n");
      out.write("<a href=\"redirect.jsp?sessionid=");
      out.print(sessionid);
      out.write("&dbType=mssql&dataSource=mssql_target2&sqlUpper=yes&dbname=vwindev1&envtype=Dev\">vwindev1</a>\n");
      out.write("</td>\n");
      out.write("<td align=\"center\">\n");
      out.write("<a href=\"redirect.jsp?sessionid=");
      out.print(sessionid);
      out.write("&dbType=mssql&dataSource=mssql_target3&sqlUpper=yes&dbname=vwinqa1&envtype=QA\">vwinqa1</a>\n");
      out.write("</td>\n");
      out.write("<!--\n");
      out.write("<td align=\"center\">\n");
      out.write("<a href=\"login.jsp?sessionid=");
      out.print(sessionid);
      out.write("&platform=Masking&dbType=mssql&dbSources=mssql_source,mssql_target,mssql_target2\">Mask Data</a>\n");
      out.write("</td>\n");
      out.write("-->\n");
      out.write("</tr>\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- Oracle -->\n");
      out.write("<tr>\n");
      out.write("<td height=60 align=\"center\">\n");
      out.write("<image src=\"img/oracle_logo.png\" width=125>\n");
      out.write("</td>\n");
      out.write("<td align=\"center\">\n");
      out.write("<a href=\"redirect.jsp?sessionid=");
      out.print(sessionid);
      out.write("&dbType=oracle&dataSource=oracle_source&sqlUpper=yes&dbname=orasrc1&envtype=Source%20DB\">orasrc1</a>\n");
      out.write("</td>\n");
      out.write("<td align=\"center\">\n");
      out.write("<a href=\"redirect.jsp?sessionid=");
      out.print(sessionid);
      out.write("&dbType=oracle&dataSource=oracle_target&sqlUpper=yes&dbname=vora1&envtype=Break%20Fix\">vora1</a>\n");
      out.write("</td>\n");
      out.write("<td align=\"center\">\n");
      out.write("<a href=\"redirect.jsp?sessionid=");
      out.print(sessionid);
      out.write("&dbType=oracle&dataSource=oracle_target2&sqlUpper=yes&dbname=voradev1&envtype=Dev\">voradev1</a>\n");
      out.write("</td>\n");
      out.write("<td align=\"center\">\n");
      out.write("<a href=\"redirect.jsp?sessionid=");
      out.print(sessionid);
      out.write("&dbType=oracle&dataSource=oracle_target3&sqlUpper=yes&dbname=voraqa1&envtype=QA\">voraqa1</a>\n");
      out.write("</td>\n");
      out.write("\n");
      out.write("<!-- td align=\"center\">\n");
      out.write("<a href=\"login.jsp?sessionid=");
      out.print(sessionid);
      out.write("&platform=Masking&dbType=oracle&dbSources=oracle_source,oracle_target,oracle_target2\">Mask Data</a>\n");
      out.write("</td -->\n");
      out.write("</tr>\n");
      out.write("\n");
      out.write("<!-- Sybase -->\n");
      out.write("<tr>\n");
      out.write("<td height=80 align=\"center\"><image src=\"img/sybase_logo.png\" width=115></td>\n");
      out.write("<td align=\"center\">\n");
      out.write("<a href=\"redirect.jsp?sessionid=");
      out.print(sessionid);
      out.write("&dbType=sybase&dataSource=sybase_source&sqlUpper=yes\">Source Sybase</a>\n");
      out.write("</td>\n");
      out.write("<td align=\"center\">\n");
      out.write("<a href=\"redirect.jsp?sessionid=");
      out.print(sessionid);
      out.write("&dbType=sybase&dataSource=sybase_target&sqlUpper=yes\">Target1 Sybase</a>\n");
      out.write("</td>\n");
      out.write("<td align=\"center\">\n");
      out.write("<a href=\"redirect.jsp?sessionid=");
      out.print(sessionid);
      out.write("&dbType=sybase&dataSource=sybase_target2&sqlUpper=yes\">Target2 Sybase</a>\n");
      out.write("</td>\n");
      out.write("<td align=\"center\">\n");
      out.write("<a href=\"redirect.jsp?sessionid=");
      out.print(sessionid);
      out.write("&dbType=sybase&dataSource=sybase_target3&sqlUpper=yes\">Target3 Sybase</a>\n");
      out.write("</td>\n");
      out.write("</tr>\n");
      out.write("\n");
      out.write("<!-- DB2 --> \n");
      out.write("<tr>\n");
      out.write("<td width=\"160\" height=\"80\" align=\"center\"><image src=\"img/db2_new.jpg\" width=125></td>\n");
      out.write("<td width=\"140\" align=\"center\">\n");
      out.write("<a href=\"redirect.jsp?sessionid=");
      out.print(sessionid);
      out.write("&dbType=db2&dataSource=db2_source&sqlSchema=delphixdb&sqlUpper=yes&sqlQuoted=yes\">Source Db2</a>\n");
      out.write("</td>\n");
      out.write("<td width=\"140\" align=\"center\">\n");
      out.write("<a href=\"redirect.jsp?sessionid=");
      out.print(sessionid);
      out.write("&dbType=db2&dataSource=db2_target&sqlSchema=delphixdb&sqlUpper=yes&sqlQuoted=yes\">Target1 Db2</a>\n");
      out.write("</td>\n");
      out.write("<td width=\"140\" align=\"center\">\n");
      out.write("<a href=\"redirect.jsp?sessionid=");
      out.print(sessionid);
      out.write("&dbType=db2&dataSource=db2_target2&sqlSchema=delphixdb&sqlUpper=yes&sqlQuoted=yes\">Target2 Db2</a>\n");
      out.write("</td>\n");
      out.write("<td width=\"140\" align=\"center\">\n");
      out.write("<a href=\"redirect.jsp?sessionid=");
      out.print(sessionid);
      out.write("&dbType=db2&dataSource=db2_target3&sqlSchema=delphixdb&sqlUpper=yes&sqlQuoted=yes\">Target3 Db2</a>\n");
      out.write("</td>\n");
      out.write("</tr>\n");
      out.write("\n");
      out.write("</table>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<br>\n");
      out.write("<span class=\"accordion\"><font color=grey>Expand/Collapse other Data Sources</font></span>\n");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"panel\">\n");
      out.write("\n");
      out.write("<table border=0 width=\"700\">\n");
      out.write("\n");
      out.write("<!-- Postgres -->\n");
      out.write("<tr>\n");
      out.write("<td height=80 align=\"center\"><image src=\"img/postgres_logo.png\" width=125></td>\n");
      out.write("<td align=\"center\">\n");
      out.write("<a href=\"redirect.jsp?sessionid=");
      out.print(sessionid);
      out.write("&dbType=postgresql&dataSource=postgresql_source&sqlSchema=delphixdb&sqlUpper=yes&sqlQuoted=yes\">Source PostgreSQL</a>\n");
      out.write("</td>\n");
      out.write("<td align=\"center\">\n");
      out.write("<a href=\"redirect.jsp?sessionid=");
      out.print(sessionid);
      out.write("&dbType=postgresql&dataSource=postgresql_target&sqlSchema=delphixdb&sqlUpper=yes&sqlQuoted=yes\">Target1 PostgreSQL</a>\n");
      out.write("</td>\n");
      out.write("<td align=\"center\">\n");
      out.write("<a href=\"redirect.jsp?sessionid=");
      out.print(sessionid);
      out.write("&dbType=postgresql&dataSource=postgresql_target2&sqlSchema=delphixdb&sqlUpper=yes&sqlQuoted=yes\">Target2 PostgreSQL</a>\n");
      out.write("</td>\n");
      out.write("</tr>\n");
      out.write("\n");
      out.write("<!-- MySQL -->\n");
      out.write("<tr>\n");
      out.write("<td height=80 align=\"center\"><image src=\"img/mysql_logo.png\" width=125></td>\n");
      out.write("<td align=\"center\">\n");
      out.write("<a href=\"redirect.jsp?sessionid=");
      out.print(sessionid);
      out.write("&dbType=mysql&dataSource=mysql_source&sqlUpper=yes\">Source MySQL</a><br /> \n");
      out.write("<a href=\"redirect.jsp?sessionid=");
      out.print(sessionid);
      out.write("&dbType=mysql&dataSource=mysql_source\"><font color=blue>(lower case)</font></a><br />\n");
      out.write("</td>\n");
      out.write("<td align=\"center\">\n");
      out.write("<a href=\"redirect.jsp?sessionid=");
      out.print(sessionid);
      out.write("&dbType=mysql&dataSource=mysql_target&sqlUpper=yes\">Target1 MySQL</a><br />\n");
      out.write("<a href=\"redirect.jsp?sessionid=");
      out.print(sessionid);
      out.write("&dbType=mysql&dataSource=mysql_target\"><font color=blue>(lower case)</font></a><br />\n");
      out.write("</td>\n");
      out.write("<td align=\"center\">\n");
      out.write("<a href=\"redirect.jsp?sessionid=");
      out.print(sessionid);
      out.write("&dbType=mysql&dataSource=mysql_target2&sqlUpper=yes\">Target2 MySQL</a><br />\n");
      out.write("<a href=\"redirect.jsp?sessionid=");
      out.print(sessionid);
      out.write("&dbType=mysql&dataSource=mysql_target2\"><font color=blue>(lower case)</font></a><br />\n");
      out.write("</td>\n");
      out.write("</tr>\n");
      out.write("\n");
      out.write("<!-- Mongo -->\n");
      out.write("<tr>\n");
      out.write("<td width=\"160\" height=\"80\" align=\"center\"><image src=\"img/mongodb.png\" width=130></td>\n");
      out.write("<td width=\"140\" align=\"center\">\n");
      out.write("<a href=\"redirect.jsp?sessionid=");
      out.print(sessionid);
      out.write("&dbType=mongo&dataSource=mongo_source\">Source Mongo</a>\n");
      out.write("</td>\n");
      out.write("<td width=\"140\" align=\"center\">\n");
      out.write("<a href=\"redirect.jsp?sessionid=");
      out.print(sessionid);
      out.write("&dbType=mongo&dataSource=mongo_target\">Target1 Mongo</a>\n");
      out.write("</td>\n");
      out.write("<td width=\"140\" align=\"center\">\n");
      out.write("<a href=\"redirect.jsp?sessionid=");
      out.print(sessionid);
      out.write("&dbType=mongo&dataSource=mongo_target2\">Target2 Mongo</a>\n");
      out.write("</td>\n");
      out.write("</tr>\n");
      out.write("\n");
      out.write("<!-- Note -->\n");
      out.write("<tr>\n");
      out.write("<td colspan=4 style=\"text-align:center;font-size:8pt;color:blue;\">Note: Postgres, MySQL and Mongo can be implemented through Delphix Toolkits which are community or customer supported.</td>\n");
      out.write("</tr>\n");
      out.write("\n");
      out.write("</table>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("</center>\n");
      out.write("\n");
      out.write("<hr size=\"3\" color=\"teal\" />\n");
      out.write("\n");
      out.write("<center>\n");
      out.write("<div class = \"box2\">\n");
      out.write("<table border=0 width=610 style=\"font-size:10pt;\">\n");
      out.write("<tr>\n");
      out.write("    <td valign=\"top\">\n");
      out.write("        <h5>Demo Application</h5>\n");
      out.write("        <a href=\"read_xml.jsp?sessionid=");
      out.print(sessionid);
      out.write("\">Configure Demo Database Connections</a><br />\n");
      out.write("        <a href=\"platform_config.jsp?sessionid=");
      out.print(sessionid);
      out.write("\">Configure Delphix Platform Connections</a><br />\n");
      out.write("        <a href=\"redirect.jsp?reset=yes&page=index.jsp\">Reset Session Data</a><br />\n");
      out.write("    <td>\n");
      out.write("\n");
      out.write("    <td valign=\"top\">\n");
      out.write("        <h5>Delphix Platform API Demos</h5>\n");
      out.write("        <a href=\"login.jsp?sessionid=");
      out.print(sessionid);
      out.write("&platform=Virtualization\">Virtualization API Login</a><br />\n");
      out.write("        <a href=\"login.jsp?sessionid=");
      out.print(sessionid);
      out.write("&platform=Masking&dbType=&dbSources=\">Masking API Login</a> <font size=-2>(SQL Server &amp; Oracle Only)</font><br />\n");
      out.write("        <br />\n");
      out.write("    </td>\n");
      out.write("</tr>\n");
      out.write("</table>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div class = \"box3\">\n");
      out.write("<table>\n");
      out.write("<tr>\n");
      out.write("    <td colspan=\"2\" style=\"text-align: center;\">    \n");
      out.write("        <h5>Information Links</h5>\n");
      out.write("        <a href=\"README.txt\" target=\"_new\">README.txt</a><br />\n");
      out.write("        Hostname: ");
      out.print(hostname );
      out.write("<br />\n");
      out.write("        Host IP Address: ");
      out.print(serverIP );
      out.write("<br />\n");
      out.write("        Host Operating System: ");
      out.print(System.getProperty("os.name") );
      out.write("<br />\n");
      out.write("        <br />        \n");
      out.write("    </td>\n");
      out.write("</tr>\n");
      out.write("</table>\n");
      out.write("</div>\n");
      out.write("</center>\n");
      out.write("\n");
      out.write("<hr size=\"3\" color=\"teal\" />\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("var acc = document.getElementsByClassName(\"accordion\");\n");
      out.write("var i;\n");
      out.write("\n");
      out.write("for (i = 0; i < acc.length; i++) {\n");
      out.write("    acc[i].addEventListener(\"click\", function() {\n");
      out.write("        this.classList.toggle(\"active\");\n");
      out.write("        var panel = this.nextElementSibling;\n");
      out.write("        if (panel.style.display === \"block\") {\n");
      out.write("            panel.style.display = \"none\";\n");
      out.write("        } else {\n");
      out.write("            panel.style.display = \"block\";\n");
      out.write("        }\n");
      out.write("    });\n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<!--\n");
      out.write("<script src=\"js/jquery.min.js\"></script>\n");
      out.write("<script src=\"js/jquery.js\"></script>  \n");
      out.write("-->\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}