package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/header.jsp");
    _jspx_dependants.add("/footer.jsp");
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Home Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"Styles/index-css.css\">\n");
      out.write("        <style>\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("     \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("      <div class=\"pageDiv\">\n");
      out.write("          \n");
      out.write("        <div class=\"header\">\n");
      out.write("            ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"Styles/header-css.css\">\n");
      out.write("        <script src=\"Script/indexScript.js\" charset=\"utf-8\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("      <header>\n");
      out.write("        <div class=\"nav-bar\">\n");
      out.write("            <a href=\"index.jsp\" class=\"nav-content\">\n");
      out.write("                <button class=\"nav-btn\">Home</button>\n");
      out.write("                <b\n");
      out.write("              </a>\n");
      out.write("              <a href=\"#\" class=\"nav-content\">\n");
      out.write("                <button class=\"nav-btn\">About us</button>\n");
      out.write("              </a>\n");
      out.write("              <a href=\"#\" class=\"nav-content\">\n");
      out.write("                <button class=\"nav-btn\">Services</button>\n");
      out.write("              </a>\n");
      out.write("              <a href=\"#\" class=\"nav-content\">\n");
      out.write("                <button class=\"nav-btn\">Blog</button>\n");
      out.write("              </a>\n");
      out.write("              <a href=\"#\" class=\"nav-content\">\n");
      out.write("                <button class=\"nav-btn\">Contact us</button>\n");
      out.write("              </a>\n");
      out.write("            ");

                // clean session
                HttpSession userSession = request.getSession(false);
//                userSession.invalidate();
                String linkPage = null;
            if (userSession.getAttribute("username") != null){
//                String name = (String)userSession.getAttribute("username");
                    String usert = userSession.getAttribute("userType").toString();
                    
                    if(usert.equals("businessAuth")){
                        linkPage = "dashboard-business.jsp"; 
                    }
                    else if (usert.equals("touristAuth")){
                        linkPage = "dashboard-tourist.jsp";
                    }
                    
                out.print(""
                        + "<a href='LogoutServlet' class='nav-content-left'>"
                        + "<button class='nav-btn'>Log out</button>"
                        + "</a>"
                        + "<a href="+linkPage +">"
                        + "<text class='nav-content-left'>"+userSession.getAttribute("username")+"</text>"
                        + "</a>");
            }
            else{
                out.print("<a href='login.jsp' class='nav-content-left'>"
                        + "<button class='nav-btn'>Login</button>"
                        + "</a>" );
            }
            
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    <!--          <a href=\"#\" class=\"nav-content-left\">\n");
      out.write("                Login\n");
      out.write("              </a>\n");
      out.write("              <a href=\" \" class=\"nav-content-left\">\n");
      out.write("                Signup\n");
      out.write("              </a>\n");
      out.write("        -->\n");
      out.write("        </div>\n");
      out.write(" <!--       <div class=\"login-panel\" id=\"id01\">\n");
      out.write("            <div class=\"login-panel-content\"><center>\n");
      out.write("                <a href=\"Signup-tourist.jsp\">\n");
      out.write("                    <button type=\"submit\" name=\"tourist-login-btn\" class=\"login-panel-btn\">Login as Tourist</button>\n");
      out.write("                </a>\n");
      out.write("                &nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("                <a href=\"Signup-business.jsp\">\n");
      out.write("                    <button type=\"button\" name=\"business-login-btn\" class=\"login-panel-btn\">Login as Business</button>\n");
      out.write("                </a>\n");
      out.write("            </center></div>\n");
      out.write("        </div>\n");
      out.write("      </header>\n");
      out.write("-->\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <img src=\"Images/bg-img-1.jpg\" class=\"images-in-slide\" style=\"height: auto; width: 100%;\">\n");
      out.write("            \n");
      out.write("            \n");
      out.write("<!--            <div class=\"text-block\">\n");
      out.write("                    <div id=\"container\">\n");
      out.write("                        \t  <div id=\"text\"></div>\n");
      out.write("                                  <h2 id=\"text\" style=\"color:black;\"></h2>\n");
      out.write("                    </div>\n");
      out.write("                </div>    -->\n");
      out.write("            <div class=\"text-image-container\">\n");
      out.write("                <!--<div class=\"test-container\">-->\n");
      out.write("          \n");
      out.write("                <h2 class=\"text\" id=\"text\" style=\"color:black;\n");
      out.write("                    position:absolute;\n");
      out.write("                    right: 10%;\n");
      out.write("                    top: 10%;\n");
      out.write("                    font-size: 54px;\n");
      out.write("                    font-family: 'Raleway', sans-serif;\n");
      out.write("                    \" > Names here</h2>\n");
      out.write("            <!--</div>-->\n");
      out.write("                    <br><br><br><br><br><br><br><br><br><br>\n");
      out.write("                    \n");
      out.write("                  <h1>Travel with culture and heritage</h1>\n");
      out.write("                  <p>\n");
      out.write("                      Visit attactive places with locals <br>\n");
      out.write("                      Experiance the taste of foods and life style\n");
      out.write("                  </p>\n");
      out.write("                  <div class=\"main-btn-container\">\n");
      out.write("                  <br>\n");
      out.write("                  <br>\n");
      out.write("                  <br>\n");
      out.write("                  <a href=\"Signup-tourist.jsp\"\n");
      out.write("                  <button class=\"tourist-signup-btn\">Signup as Tourist</button>\n");
      out.write("                  </a>\n");
      out.write("                  <br>\n");
      out.write("                  <br>\n");
      out.write("                  <br>\n");
      out.write("                  <br>\n");
      out.write("                  <a href=\"Signup-business.jsp\"\n");
      out.write("                  <button class=\"tourist-signup-btn\">Signup as Business</button>\n");
      out.write("                  </a>\n");
      out.write("                  </div>\n");
      out.write("              </div>\n");
      out.write("                   <script type=\"text/javascript\">\n");
      out.write("            \n");
      out.write("                    var _CONTENT = [\"Ampara\", \"Anuradhapura\",\"Badulla\",\"Batticaloa\",\"Colombo\",\"Galle\",\"Gampaha\",\"Hambantota\",\"Jaffna\",\"Kalutara\",\"Kandy\",\"Kilinochchi\",\"Kurunegala\",\"Manner\",\"Matale\",\"Monaragala\",\"Mullaitivu\",\"Nuwara Eliya\",\"Polonnaruwa\",\"Puttalam\",\"Ratnapura\",\"Trincomalee\",\"Vavuniya\"];\n");
      out.write("\n");
      out.write("                    var _PART = 0;\n");
      out.write("                    var _PART_INDEX = 0;\n");
      out.write("\n");
      out.write("                    var _INTERVAL_VAL;\n");
      out.write("\n");
      out.write("                    var _ELEMENT = document.querySelector(\"#text\");\n");
      out.write("\n");
      out.write("                    function Type() {\n");
      out.write("                      var text = _CONTENT[_PART].substring(0, _PART_INDEX + 1);\n");
      out.write("                      _ELEMENT.innerHTML = text;\n");
      out.write("                      _PART_INDEX++;\n");
      out.write("\n");
      out.write("                      if (text === _CONTENT[_PART]) {\n");
      out.write("                        clearInterval(_INTERVAL_VAL);\n");
      out.write("                        setTimeout(function () {\n");
      out.write("                          _INTERVAL_VAL = setInterval(Delete, 50);\n");
      out.write("                        }, 1000);\n");
      out.write("                      }\n");
      out.write("                    }\n");
      out.write("\n");
      out.write("                    function Delete() {\n");
      out.write("                      var text = _CONTENT[_PART].substring(0, _PART_INDEX - 1);\n");
      out.write("                      _ELEMENT.innerHTML = text;\n");
      out.write("                      _PART_INDEX--;\n");
      out.write("\n");
      out.write("                      if (text === '') {\n");
      out.write("                        clearInterval(_INTERVAL_VAL);\n");
      out.write("\n");
      out.write("                        if (_PART == (_CONTENT.length - 1))\n");
      out.write("                          _PART = 0;\n");
      out.write("                        else\n");
      out.write("                          _PART++;\n");
      out.write("                        _PART_INDEX = 0;\n");
      out.write("\n");
      out.write("                        setTimeout(function () {\n");
      out.write("                          _INTERVAL_VAL = setInterval(Type, 100);\n");
      out.write("                        }, 200);\n");
      out.write("                      }\n");
      out.write("                    }\n");
      out.write("\n");
      out.write("                    _INTERVAL_VAL = setInterval(Type, 100);\n");
      out.write("            </script>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"footer\">\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"Styles/footer-css.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("      <footer>\n");
      out.write("          <div class=\"footer-div\">\n");
      out.write("            <table class=\"footer-table\">\n");
      out.write("              <tr>\n");
      out.write("                <td><b>Facebook</b></td>\n");
      out.write("                <td>Blogs</td>\n");
      out.write("                <td rowspan=\"3\"><b>Newsletter</b><br>\n");
      out.write("                  <form class=\"\" action=\"#\" method=\"post\">\n");
      out.write("                    <input type=\"text\" name=\"newsletter-sub\" class=\"newsletter-text-box\" placeholder=\"Enter your email\">\n");
      out.write("                    <button type=\"submit\" class=\"newsletter-btn\">></button>\n");
      out.write("                  </form>\n");
      out.write("                </td>\n");
      out.write("              </tr>\n");
      out.write("              <tr>\n");
      out.write("                <td>Instagram</td>\n");
      out.write("                <td>Career</td>\n");
      out.write("              </tr>\n");
      out.write("              <tr>\n");
      out.write("                <td>Twitter</td>\n");
      out.write("                <td>Partnerships</td>\n");
      out.write("                <td></td>\n");
      out.write("              </tr>\n");
      out.write("              <tr>\n");
      out.write("                <td>Youtube</td>\n");
      out.write("              <td><a href=\"adminLogin.jsp\">\n");
      out.write("                  Admin Page</a>\n");
      out.write("              </td>\n");
      out.write("              \n");
      out.write("              </tr>\n");
      out.write("            </table>\n");
      out.write("          </div>\n");
      out.write("        </footer>\n");
      out.write("       </footer>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>\n");
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
