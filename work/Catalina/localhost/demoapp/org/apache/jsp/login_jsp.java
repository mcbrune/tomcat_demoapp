/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.56
 * Generated at: 2020-03-24 15:28:58 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import org.json.simple.*;
import org.json.simple.parser.*;
import java.net.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


// 
// Just run local shell commands for now ... 
// FUTURE: Convert to API calls directly to Engine 
//
public String doCommand(String cmd){
   String directory = "";
   try {
      int exitCode;
      // out.println("Setting Shell Environment ...");
      String [] params = new String[]{"/bin/bash", "-c", "cd "+System.getProperty("user.home")+";. ./.delphix_profile 1> /dev/null;set -e;" + cmd };
      //String [] params = new String[]{"/bin/bash", "-c", "cd "+System.getProperty("user.home")+";. ./.delphix_profile 1> /dev/null;set -e;" + ""+request.getParameter("dir")};
      int c;
      BufferedReader b;
      // System.out.println("Parameters ..."+params);
      Process subProc = Runtime.getRuntime().exec(params);
      StringBuffer sb = new StringBuffer();
      // System.out.println("Opening Buffer for Reading ...");
      b = new BufferedReader(new InputStreamReader(subProc.getInputStream()));
      c = b.read();
      while (c != -1) {
        sb.append((char)c);
        c = b.read();
      }
      b.close();
      // System.out.println("Buffer Closed ...");
      exitCode = subProc.waitFor();
      if (exitCode != 0) {
        sb = new StringBuffer();
        b = new BufferedReader(new InputStreamReader(subProc.getErrorStream()));
        c = b.read();
        while (c != -1) {
           sb.append((char)c);
           c = b.read();
        }    //end while
        b.close();
        System.out.println("ERROR: Output from 'doCommand' "+ sb.toString());
      } else {
         //System.out.println("Output from 'doCommand' "+ sb.toString());
         directory =  sb.toString().trim();
      }
   } catch(Exception e) {
      System.out.println("ERROR: "+e.getMessage());
   }
   return directory;
}



public String getJob(String job){
   String str = doCommand("/Users/abitterman/Development/APIs/book/API/job_status.sh "+job+"");
   System.out.println(str+"<br />");
   String jobstate = "";
   String percentcomplete = "";
   try {
      if (str != "") {
         JSONParser parser = new JSONParser();
         JSONObject jsonObject = (JSONObject) parser.parse(str);
         jobstate = (String) jsonObject.get("JobState");
         percentcomplete = (String) jsonObject.get("PercentComplete");
         System.out.println(jobstate+" "+percentcomplete);
      }
   } catch(Exception e) {
      System.out.println("ERROR: "+e.getMessage());
   }
   String result = "[ \""+jobstate+"\", \""+percentcomplete+"\" ]";
   return result;
}


public boolean isJSONValid(String test) {
    try {
        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(test);
    } catch (Exception ex) {
        // e.g. in case JSONArray is valid as well...
        try {
        JSONParser parser1 = new JSONParser();
         JSONArray arr = (JSONArray) parser1.parse(test);
        } catch (Exception ex1) {
            return false;
        }
    }
    return true;
}

/**
 * Sample usage:
 * <pre>
 * Writer writer = new JSONWriter(); // this writer adds indentation
 * jsonobject.writeJSONString(writer);
 * System.out.println(writer.toString());
 * </pre>
 * 
 * @author Elad Tabak
 * @author Maciej Komosinski, minor improvements, 2015
 * @since 28-Nov-2011
 * @version 0.2
 */
public class JSONWriter extends StringWriter
{
	final static String indentstring = "  "; //define as you wish
	final static String spaceaftercolon = " "; //use "" if you don't want space after colon

	private int indentlevel = 0;

	@Override
	public void write(int c)
	{
		char ch = (char) c;
		if (ch == '[' || ch == '{')
		{
			super.write(c);
			super.write('\n');
			indentlevel++;
			writeIndentation();
		} else if (ch == ',')
		{
			super.write(c);
			super.write('\n');
			writeIndentation();
		} else if (ch == ']' || ch == '}')
		{
			super.write('\n');
			indentlevel--;
			writeIndentation();
			super.write(c);
		} else if (ch == ':')
		{
			super.write(c);
			super.write(spaceaftercolon);
		} else
		{
			super.write(c);
		}

	}

	private void writeIndentation()
	{
		for (int i = 0; i < indentlevel; i++)
		{
			super.write(indentstring);
		}
	}
}


  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/self_classes.jsp", Long.valueOf(1527219588000L));
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
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\n');
      out.write('\n');
      out.write('\n');
      out.write('\n');
      out.write('\n');
      out.write('\n');

String key = UUID.randomUUID().toString();
String sessionid = "";
if (request.getParameter("sessionid") == null) {
   //session.invalidate();
   sessionid = UUID.randomUUID().toString();
} else {
   sessionid = (String) request.getParameter("sessionid");
}

String platform = "";
platform = (request.getParameter("platform") != null) ? request.getParameter("platform") : "";

String dbType = "";
dbType = (request.getParameter("dbType") != null) ? request.getParameter("dbType") : "";

String dbSources = "";
dbSources = (request.getParameter("dbSources") != null) ? request.getParameter("dbSources") : "";

String engine = "";
engine = (request.getParameter("engine") != null) ? request.getParameter("engine") : "";

String username = "";
username = (request.getParameter("username") != null) ? request.getParameter("username") : "delphix_admin";

String password = "";
password = (request.getParameter("password") != null) ? request.getParameter("password") : "";

String submit = "";
submit = (request.getParameter("submit") != null) ? request.getParameter("submit") : "";

String path = application.getRealPath("/").replace('\\', '/');
// ... or ... path = getServletContext().getRealPath("/").replace('\\', '/');
//out.println("Path "+path+"<br />");

String jsonpath = path+"jsonfiles"+File.separator;
String jsonFile = "delphix_platforms.json";

String msg = "";
String str = "";
String enginename = "";
String enginetype = "";
String protocol = "";
String hostname = "";
String user = "";
String userpwd = "";
String baseurl = "";

//
// JSON Parser ...
//
JSONParser parser = new JSONParser();
boolean isValid;

if (submit.equals("Login")) {
if (! engine.equals("")) {
   //
   // Engines ...
   // 
   str = doCommand("cat "+jsonpath+jsonFile);
   //out.println(str);

   isValid = isJSONValid(str);
   if (isValid) {
      Object obj = parser.parse(str);
      JSONObject jsonObject = (JSONObject) obj;
      JSONArray jarr = (JSONArray) jsonObject.get("engines");
      for (int i=0; i < jarr.size(); i++) {
         JSONObject pobj = (JSONObject) jarr.get(i);
         // out.println(i);
         // Long id = (Long) pobj.get("employee_id");
         enginename = (String) pobj.get("enginename");
         enginetype = (String) pobj.get("enginetype");
         if (enginetype.equals(platform)) {
            if ( engine.equals(engine) ) {
               protocol = (String) pobj.get("protocol");
               hostname = (String) pobj.get("hostname");
               user = (String) pobj.get("username");
               userpwd = (String) pobj.get("password");
               baseurl = protocol + "://" + hostname + "/resources/json/delphix";
            }   // end if enginename ...
         }      // end if enginetype ...
      }         // end for loop ...

   } else {
      out.println("Error: Invalid JSON String "+str+"<br />");
   }    // end if isValid ...

//   out.println("Login stuff: "+hostname+" "+username+" "+user+" "+password+" "+userpwd+"<br />");

   // 
   // Redirect if Login Successfull ... 
   // 
   if ( username.equals(user) && password.equals(userpwd) ) {
      if (platform.equals("Masking")) {
         response.sendRedirect("selfmasking.jsp"+"?sessionid="+sessionid+"&platform=Masking&engine="+engine+"&dbType="+dbType+"&dbSources="+dbSources);
         return;
      }
      if (platform.equals("Virtualization")) {  
         response.sendRedirect("selfservice.jsp"+"?sessionid="+sessionid+"&platform=Virtualization&engine="+engine);
         return;
      }
   } else { 
      msg = "Username and/or Password do NOT match or are invalid, please try again ...";
   }

} else {
      msg = "Platform NOT selected, please try again ...";
} 	// end if engine.equals("") ...
}       // end if submit.equals("Login") ...


      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Delphix Rocks - ");
      out.print(platform);
      out.write(" API Demo</title>\n");
      out.write("        <link href=\"./bootstrap/css/bootstrap.css\" rel=\"stylesheet\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("\n");
      out.write("            <div class=\"masthead\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                   <br />\n");
      out.write("                   <table width=\"100%\"><tr>\n");
      out.write("                      <td style=\"text-align:center;\" width=\"40%\">\n");
      out.write("                         <a href=\"redirect.jsp?sessionid=");
      out.print(sessionid);
      out.write("&logout=yes\">\n");
      out.write("                            <img src=\"./img/delphix-logo-black_200w.png\"/>\n");
      out.write("                         </a>\n");
      out.write("                      </td>\n");
      out.write("                      <td style=\"padding-top:6px;text-align:center;font-size:18pt;\">\n");
      out.write("                         ");
      out.print(platform);
      out.write(" API Demo\n");
      out.write("                      </td>\n");
      out.write("                   </tr></table>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <hr>\n");
      out.write("            <br>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"span4 offset4\">\n");
      out.write("                    <div class=\"well\">\n");
      out.write("                        <legend>Please Login</legend>\n");
 
if ( ! msg.equals("") ) { 
   out.println(""+msg);
}
if (platform.equals("Virtualization")) {

      out.write("\n");
      out.write("                        <form method=\"POST\" action=\"login.jsp\" accept-charset=\"UTF-8\">\n");

} else {

      out.write("\n");
      out.write("                        <form method=\"POST\" action=\"login.jsp\" accept-charset=\"UTF-8\">\n");
      out.write("                        <input type=\"hidden\" name=\"dbType\" value=\"");
      out.print(dbType);
      out.write("\" />\n");
      out.write("                        <input type=\"hidden\" name=\"dbSources\" value=\"");
      out.print(dbSources);
      out.write("\" />\n");

}

      out.write("\n");
      out.write("                        <input type=\"hidden\" name=\"sessionid\" value=\"");
      out.print(sessionid);
      out.write("\" />\n");
      out.write("                        <input type=\"hidden\" name=\"platform\" value=\"");
      out.print(platform);
      out.write("\" />\n");
      out.write("\n");
      out.write("\n");
      out.write("Select Delphix Platform:\n");
      out.write("<select name=\"engine\">\n");
      out.write("<option value=\"\">[ Select_Delphix_Platform ]</option>\n");

   //
   // Engines ...
   //
   str = doCommand("cat "+jsonpath+jsonFile);
   //out.println(str);

   isValid = isJSONValid(str);
   if (isValid) {
      Object obj = parser.parse(str);
      JSONObject jsonObject = (JSONObject) obj;
      JSONArray jarr = (JSONArray) jsonObject.get("engines");
      for (int i=0; i < jarr.size(); i++) {
         JSONObject pobj = (JSONObject) jarr.get(i);
         // out.println(i);
         // Long id = (Long) pobj.get("employee_id");
         enginename = (String) pobj.get("enginename");
         enginetype = (String) pobj.get("enginetype");
         if (enginetype.equals(platform)) {
            if ( engine.equals(enginename) ) {
               protocol = (String) pobj.get("protocol");
               hostname = (String) pobj.get("hostname");
               username = (String) pobj.get("username");
               userpwd = (String) pobj.get("password");
               baseurl = protocol + "://" + hostname + "/resources/json/delphix";
               //out.println("enginename: "+enginename+" baseurl: "+baseurl+"<br />");

      out.write("\n");
      out.write("   <option value=\"");
      out.print(enginename);
      out.write("\" selected>");
      out.print(enginename);
      out.write("</option>\n");

            } else {

      out.write("\n");
      out.write("   <option value=\"");
      out.print(enginename);
      out.write('"');
      out.write('>');
      out.print(enginename);
      out.write("</option>\n");

            }   // end if enginename ...
         }      // end if enginetype ...
      }         // end for loop ...

   } else {
      out.println("Error: Invalid JSON String "+str+"<br />");
   }    // end if isValid ...

      out.write("\n");
      out.write("</select>\n");
      out.write("\n");
      out.write("                            <input class=\"span3\" placeholder=\"Username\" type=\"text\" name=\"username\" value=\"");
      out.print(username);
      out.write("\" />\n");
      out.write("                            <input class=\"span3\" placeholder=\"Password\" type=\"password\" name=\"password\" value=\"");
      out.print(password);
      out.write("\" />\n");
      out.write("                            <input class=\"btn-info btn\" type=\"submit\" name=\"submit\" value=\"Login\" />\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
