package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class aboutus_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>About Us Section</title>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta name=\"viewpoint\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <link rel=\"stylesheet\"  href=\"aboutus.css\">\r\n");
      out.write("    <style type=\"text/css\">\r\n");
      out.write("        body{\r\n");
      out.write("            background-image: url(\"donut.jpg\");\r\n");
      out.write("            background-repeat: no-repeat;\r\n");
      out.write("            background-attachment: fixed;\r\n");
      out.write("            background-size:100% 100%;\r\n");
      out.write("            \r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("    \r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <div class=\"heading\">\r\n");
      out.write("        <h1>About Us</h1>\r\n");
      out.write("        <p>choconutz</p>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"aboutus\"> \r\n");
      out.write("        <div> \r\n");
      out.write("             Welcome to our artisanal donut haven!\r\n");
      out.write("             At ?choconutz?, we believe that life is enhanced by a sprinkle of sweetness.\r\n");
      out.write("             our journey began in a cozy kitchen, a passion for crafting mouthwatering donuts and witness the joy on people?s faces.\r\n");
      out.write("\r\n");
      out.write("            <span id=\"span1\">...</span> \r\n");
      out.write("            <span class=\"content\" id=\"content\"> \r\n");
      out.write("                our little corner of sweetness is more than just a shop it?s a gathering place.\r\n");
      out.write("                we use only the freshest ingredients to create these delectable rings of happiness.\r\n");
      out.write("                We offer a wide variety of donuts from classic glazed to unique creations of donuts.\r\n");
      out.write("                whether you are chocolate enthusiasts or a fruity devotee we offer for you the desired flavor according to your preference.\r\n");
      out.write("                We invite you to come visit us and experience the magic of ?choconutz?.\r\n");
      out.write("            </span> \r\n");
      out.write("        </div> \r\n");
      out.write("        \r\n");
      out.write("        <button id=\"btn\" onclick=\"changeReadMore()\"> Read More </button> \r\n");
      out.write("\r\n");
      out.write("        <script src=\"aboutus.js\"></script>\r\n");
      out.write("        <!--Add comments-->\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("       \r\n");
      out.write("     \r\n");
      out.write("     \r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
