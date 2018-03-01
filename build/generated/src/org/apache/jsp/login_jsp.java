package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/head.html");
  }

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

      out.write("<!doctype html>\n");
      out.write("<html class=\"no-js\" lang=\"\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"description\" content=\"\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <title>Dream Home</title>\n");
      out.write("        <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"style.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"iconic.css\">\n");
      out.write("        <script src=\"js/vendor/modernizr.js\"></script>\n");
      out.write("        <!--[if lt IE 10 ]>\n");
      out.write("          <style type=\"text/css\">\n");
      out.write("         .navigation-mobile{\n");
      out.write("       display: none;\n");
      out.write("     }\n");
      out.write("     </style>\n");
      out.write("     <![endif]-->\n");
      out.write("    </head>");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"col-md-8\">\n");
      out.write("    <div class=\"content-box-2 agents-contact\">\n");
      out.write("        <div class=\"heading\">\n");
      out.write("            <h5>Contact jhone doe</h5>\n");
      out.write("        </div>\n");
      out.write("        <form class=\"form-content pad-top-small\" data-parsley-validate>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-6 form-group-1\">\n");
      out.write("                    <input type=\"text\" class=\"form-control input-lg\" placeholder=\"Name\" required data-parsley-required-message=\"Please insert your name\" name=\"name\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-6 form-group-1\">\n");
      out.write("                    <input type=\"text\" class=\"form-control input-lg\" placeholder=\"E-mail ID\" required data-parsley-required-message=\"Please insert your Email\" name=\"email\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-6 form-group-1\">\n");
      out.write("                    <input type=\"text\" class=\"form-control input-lg\" placeholder=\"Contact no\" required data-parsley-required-message=\"Please insert your contact no\" data-parsley-min=\"10\" name=\"contact\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-6 form-group-1\">\n");
      out.write("                    <input type=\"text\" class=\"form-control input-lg\" placeholder=\"Enter your place\" required name=\"location\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"form-group-1 col-md-12\">\n");
      out.write("                    <textarea class=\"form-control\" placeholder=\"Enter your questions and queries\" rows=\"3\"  required data-parsley-minlength=\"20\" data-parsley-minlength-message = \"Come on! You need to enter at least a 20 character comment..\"  data-parsley-validation-threshold=\"10\" data-parsley-maxlength=\"100\" name=\"message\"></textarea>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row pad-top-small\">\n");
      out.write("                <div class=\"col-md-12\">\n");
      out.write("                    <button class=\"btn btn-primary btn-large pull-right\">Submit</button>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"text-success col-xs-12 hidden form-messges text-center\">\n");
      out.write("                    <p>We will responce as soon as possible.</p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </form>\n");
      out.write("        <div class=\"info-box-1\">\n");
      out.write("            <h5><span>Or call the agent</span></h5>\n");
      out.write("            <p><span class=\"large-text-1\"><span class=\"iconic-phone-square\"></span>0987654321</span> (this is a sample number)</p>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>");
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
