/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.56
 * Generated at: 2020-03-24 15:50:38 UTC
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

public final class masking_005fjob_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"       \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");
      out.write("\n");
      out.write('\n');
      out.write('\n');
      out.write('\n');


   String path = application.getRealPath("/").replace('\\', '/');
   // ... or ... path = getServletContext().getRealPath("/").replace('\\', '/');
   //out.println("Path "+path+"<br />");

   String jsonpath = path+File.separator+"jsonfiles"+File.separator;
   String jsonFile = "delphix_platforms.json";

   //String baseurl = request.getParameter("baseurl");
   //String username = request.getParameter("username");
   //String userpwd = request.getParameter("userpwd");

   String engine = request.getParameter("engine");
   String job = request.getParameter("job");

   String str = doCommand(path+"api/masking_status_tc.sh \""+jsonpath+jsonFile+"\" \""+engine+"\" "+job+"");
   //out.println(str+"<br />");

   JSONParser parser = new JSONParser();
   String jobstate = "";
   String startTime = "";
   String rowsMasked = "";
   String rowsTotal = "";
   String endTime = "";
   String jobcolor = "lightpink";
   String bgcolor = "lightpink";

   if (str != "") {
      JSONObject jsonObject = (JSONObject) parser.parse(str);
      jobstate = (String) jsonObject.get("status");
      startTime = (String) jsonObject.get("startTime");
      rowsMasked = "0";
      rowsTotal = "0";
      endTime = "";

      //out.println(jobstate+"<br />");
      //out.println("<hr />");
      jobcolor = "pink";
      if ( jobstate.equals("RUNNING")) { jobcolor="lightgreen"; }
      if ( jobstate.equals("SUCCEEDED")) { 
         jobcolor="lightgreen"; 
         long lcnt = (Long) jsonObject.get("rowsMasked"); 
         rowsMasked = String.valueOf(lcnt);
         lcnt = (Long) jsonObject.get("rowsTotal");
         rowsTotal = String.valueOf(lcnt);
         endTime = (String) jsonObject.get("endTime");
      }
   }

      out.write("\n");
      out.write("<table class=\"tid\">\n");
      out.write("<tr>\n");
      out.write("<th>Exec<br />Id</th>\n");
      out.write("<th>Status</th>\n");
      out.write("<th>Row<br />Masked</th>\n");
      out.write("<th>Rows<br />Total</th>\n");
      out.write("<th>Start Time</th>\n");
      out.write("<th>End Time</th>\n");
      out.write("</tr>\n");
      out.write("\n");
      out.write("<tr>\n");
      out.write("<td>");
      out.print( job );
      out.write("</td>\n");
      out.write("<td id=jobstate style=\"background-color:");
      out.print(jobcolor);
      out.write('"');
      out.write('>');
      out.print(jobstate);
      out.write("</td>\n");
      out.write("<td>");
      out.print(rowsMasked);
      out.write("</td>\n");
      out.write("<td>");
      out.print(rowsTotal);
      out.write("</td>\n");
      out.write("<td>");
      out.print(startTime);
      out.write("</td>\n");
      out.write("<td>");
      out.print(endTime);
      out.write("</td>\n");
      out.write("</tr>\n");
      out.write("</table>\n");
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
