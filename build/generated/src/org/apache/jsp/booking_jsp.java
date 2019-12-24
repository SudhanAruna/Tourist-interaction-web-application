package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import helper.ManageBookEvent;
import beans.BookEventBean;
import sun.misc.CompoundEnumeration;
import java.util.Enumeration;
import beans.MessageBean;
import java.util.Collections;
import java.util.ArrayList;
import helper.ManageMesg;

public final class booking_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("  ");
        // Session Checking
            String username = "";
            String userType = null;
            int eventId = 0;
            String tableName = null;
          
            try {
                   tableName = response.getHeader("tableName-booking");
            }
            catch(Exception e){
                tableName = null;
                out.print("Exception : "+e.getMessage());
            }

            try {
                username = (String)session.getAttribute("username");
                userType = (String)session.getAttribute("userType");

                    if ( userType == null ){
                        response.sendRedirect("login.jsp");
                    }
                    else{

                    }
                }
            catch (Exception e) {
                    RequestDispatcher indexReqDispatch = request.getRequestDispatcher("index.jsp");
                    indexReqDispatch.forward(request, response);
            }
        
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"Styles/messageDasboard.css\">\n");
      out.write("        <script>\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("      <div class=\"header\">\n");
      out.write("        ");
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
      out.write("      </div>\n");
      out.write("        <div class=\"pageDiv\">\n");
      out.write("           ");


                  String status = response.getHeader("msgStatus");

                  if(status != null){
                    out.print("<h4>"+status+"</h4>");
                  }
                  if(status == null){
                      out.print("<h4>"+status+"</h4>");
                  }

          
      out.write("\n");
      out.write("          <div class=\"firstDiv\" style=\"width:auto;height: 800px;\">\n");
      out.write("            <table>\n");
      out.write("              <tr>\n");
      out.write("                <td>Pro pic</td>\n");
      out.write("              </tr>\n");
      out.write("              <tr>\n");
      out.write("                  <td>\n");
      out.write("                    <form class=\"\" action=\"#\" method=\"get\">\n");
      out.write("                      <input type=\"text\" name=\"searchLocation\" class=\"form-text-box\" value=\"\" placeholder=\"Search location in Sri lanka\">\n");
      out.write("                        <input type=\"submit\" name=\"\" value=\"Search\" class=\"dash-menu-content\">\n");
      out.write("                    </form>\n");
      out.write("                  </td>\n");
      out.write("              </tr>\n");
      out.write("              <tr>\n");
      out.write("                <td>\n");
      out.write("                  <a href=\"#\">\n");
      out.write("                    <button type=\"button\" name=\"button\" class=\"dash-menu-content\">\n");
      out.write("                      Setting</button>\n");
      out.write("                  </a>\n");
      out.write("                </td>\n");
      out.write("              </tr>\n");
      out.write("              <tr>\n");
      out.write("                <td>\n");
      out.write("                  <a href=\"#\">\n");
      out.write("                    <button type=\"button\" name=\"button\" class=\"dash-menu-content\">\n");
      out.write("                      Booking</button>\n");
      out.write("                    </a>\n");
      out.write("                </td>\n");
      out.write("              </tr>\n");
      out.write("              <tr>\n");
      out.write("                <td>\n");
      out.write("                  <a href=\"message-dashboard.jsp\">\n");
      out.write("                    <button type=\"button\" name=\"button\" class=\"dash-menu-content\">\n");
      out.write("                      Messages</button>\n");
      out.write("                    </a>\n");
      out.write("                </td>\n");
      out.write("              </tr>\n");
      out.write("            </table>\n");
      out.write("          </div>\n");
      out.write("          <div class=\"secondDiv\">\n");
      out.write("                          <div class=\"tble\" height=10%>\n");
      out.write("                <section align='center' >\n");
      out.write("\n");
      out.write("                  ");

                      
                     boolean displayDetails = false;
                     if(tableName != null){
                        displayDetails = true;
                     }
                     else{
                         tableName = "debugBuinessBooking";
                     }
                    out.print("<text> Event Name :"+tableName+"</text>");

                  
      out.write("\n");
      out.write("\n");
      out.write("                </section>\n");
      out.write("              </div><br>\n");
      out.write("\n");
      out.write("\n");
      out.write("              <div class=\"message-panel\" >\n");
      out.write("                  ");


                  
      out.write("\n");
      out.write("                <div class=\"messages\">\n");
      out.write("                    ");


                    ManageBookEvent manageBooking = new ManageBookEvent();
                    ArrayList<BookEventBean> detailList =  manageBooking.getBookingDetails(tableName);
                    Enumeration<BookEventBean> booking = Collections.enumeration(detailList);

                    
      out.write("\n");
      out.write("                    <table>\n");
      out.write("                      <tr>\n");
      out.write("                        <th>Tourist First Name</th>\n");
      out.write("                        <th>Tourist Last Name</th>\n");
      out.write("                        <th>Tourist Email Address</th>\n");
      out.write("                        <th>Mobile Number</th>\n");
      out.write("                        <th>Booking Date</th>\n");
      out.write("                        <th>Booking Time</th>\n");
      out.write("                        <th>Number of People</th>\n");
      out.write("                        <th>Total Price</th>\n");
      out.write("                      </tr>\n");
      out.write("                      ");

                    if(!detailList.isEmpty() && displayDetails){
                        while(booking.hasMoreElements()){
                            BookEventBean bd = booking.nextElement();

                            out.print("<tr class='eventBookingRow'>"
                            +"<td>"+bd.getTouristFirstName()+"</td>"
                            + "<td>"+bd.getTouristLastName()+"</td>"
                            + "<td>"+bd.getTouristEmailAdd()+"</td>"
                            + "<td>"+Integer.toString(bd.getMobileNumber())+"</td>"
                            + "<td>"+bd.getBookingDate()+"</td>"
                            + "<td>"+bd.getBookingTime()+"</td>"
                            + "<td>"+Integer.toString(bd.getNumberOfPerson())+"</td>"
                            + "<td>"+Integer.toString(bd.getTotalPrice())+"</td>" 
                            + "</tr>");
                        }

                    }
                    else{
                        out.print("<tr class='eventBookingRow'>"
                                + "<td colspan='7'>No Records</td>"
                                + "</tr>");
                    }
                      
      out.write("\n");
      out.write("                      <tr>\n");
      out.write("                          <td \"7\"></td>\n");
      out.write("                      </tr>\n");
      out.write("                    </table>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("              <br>\n");
      out.write("              <center>\n");
      out.write("<!--                <div class=\"msg-form-div\">\n");
      out.write("                  <form class=\"\" action=\"MessageServlet\" method=\"post\">\n");
      out.write("                    <input type=\"text\" class=\"msg-form\" name=\"msgFromSender\" value=\"\" placeholder=\"Enter your message\"> &nbsp;\n");
      out.write("                    <input type=\"hidden\" name=\"eventId\" value='' >\n");
      out.write("                    <input type=\"hidden\" name=\"receiver\" value=\"\"\n");
      out.write("                    <input type=\"hidden\" name=\"userType\" value=''>\n");
      out.write("                    <input type=\"hidden\" name=\"msgScope\" value=\"\">\n");
      out.write("                    <button type=\"submit\" name=\"send-msg-btn\" class=\"\">\n");
      out.write("                        Send </button>\n");
      out.write("\n");
      out.write("                  </form>\n");
      out.write("                </div>-->\n");
      out.write("                    ");

//                    out.print(eventId+" r- "+receiver+" ut- "+userType+" msscope- "+msgScope);
                    
      out.write("\n");
      out.write("                  </center>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("          <div class=\"thirdDiv\">\n");
      out.write("              <form action=\"message-dashboard.jsp\" method=\"get\">\n");
      out.write("                        ");

//                        ArrayList<MessageBean> contactList = manageMsg.getNewMsgScope(username);
//                        Enumeration<MessageBean> contacts = Collections.enumeration(contactList);
//                        out.print("New Messages\n");
//                        out.print(contactList.isEmpty());
//                        if(!contactList.isEmpty()){
//                            while(contacts.hasMoreElements()){
//                                MessageBean msg = contacts.nextElement();
//                                senderContact = msg.getSender();
//                                msgScope = msg.getScope();
//                                if(senderContact.equals(username)){
//
//                                }
//                                else{
//                                  out.println("<br>"
//                                            + "<button type='submit' name='contactShift' class='contact-btn' value='"+msgScope+"'>"
//                                            + " From : "+senderContact +" Event no : "+Integer.toString(msg.getEventno())
//                                            + "</button>"+"<br>");
//                                }
//                            }
//                            if ( senderContact == null ){
//                                senderContact = "None Receiver";
//                            }
//                        }
                        
      out.write("\n");
      out.write("                        </form>\n");
      out.write("          </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("<!--        <div class=\"footer\">\n");
      out.write("      ");
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
      out.write("      </div>-->\n");
      out.write("        </body>\n");
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
