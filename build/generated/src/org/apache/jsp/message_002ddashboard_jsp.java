package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import sun.misc.CompoundEnumeration;
import java.util.Enumeration;
import beans.MessageBean;
import java.util.Collections;
import java.util.ArrayList;
import helper.ManageMesg;

public final class message_002ddashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("  ");
        // Session Checking 
            String username = "";
            String userType = null;
            int eventId = 0;
            String msgS = null;
            String senderContact = null;
            String receiveContact = null;
            try{
                eventId = Integer.parseInt(request.getParameter("eventId"));
            }
            catch(Exception e){
                    // change to 0 >> for debug purpose it 14
            eventId = 0;
            out.print("Exception event Id : "+e.getMessage());
            }
            try {
                msgS = request.getParameter("contactShift");
//                    ManageMesg mm = new ManageMesg();
//                    MessageBean n = mm.getMsgDetailSingle(msgS); 
                  MessageBean m = new ManageMesg().getMsgDetailSingle(msgS);
                if(username.equals(m.getReceiver())){
                    receiveContact = m.getSender();
                }
                else{
                    receiveContact = m.getReceiver();
                }
            }
            catch(Exception e){
                msgS = null;
                out.print("\nException msg scope : "+e.getMessage());
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
                
                boolean newMsgEvnt = false;
                if (eventId == 0){
                    out.print("\nMessager contact\n");
                }
                else{
                        newMsgEvnt = true;
                    out.print("\nNew contact msg \n");
                
                }
                 
                
                
                String msgScope = null;
                
                ManageMesg manageMsg = new ManageMesg();
                if (msgS == null){
                    
                    out.print("\n msgS is null");        
                            
                    ArrayList<MessageBean> contactList = manageMsg.getNewMsgScope(username);
                    Enumeration<MessageBean> contacts = Collections.enumeration(contactList);
                }
                else {
                    
                    out.print("\n msgS is not null \n value : "+msgS);
                    
                    msgScope = msgS;
                }
                
                
                
                
//                if (newMsgEvnt){
//                    
//                }
//                else if(msgS != null){
//                    msgScope = msgS;
//                }
//                else{
//                    if(!contactList.isEmpty()){
//                        if(contacts.hasMoreElements()){
//                            MessageBean msg = contacts.nextElement();
//                            
//                            // **NOTE**   sender of this msg becomes receiver if there is 
//                            senderContact = msg.getSender();
//                            receiveContact =  msg.getReceiver();
//                            if (msgS != null){
//                                msgScope = msgS;
//                            }
//                            else{
//                                msgScope = msg.getScope();
//                            }
//                            
//                            
//                        }
//                           
//                    }
//                }
                
        
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"Styles/messageDasboard.css\">\n");
      out.write("        <script>\n");
      out.write("            \n");
      out.write("        </script>\n");
      out.write("    \n");
      out.write("    </head>\n");
      out.write("    \n");
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
                
          
      out.write(" \n");
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
      out.write("                  \n");
      out.write("                  ");

                      
                      if(msgScope != null){
                          
                          out.print("<text> Contact : "+receiveContact +"</text>");
                      }
                      else{
                           out.print("<text>Please select your contact</text>");
                      }

                  
      out.write("\n");
      out.write("                   \n");
      out.write("                </section>\n");
      out.write("              </div><br>\n");
      out.write("    \n");
      out.write("              \n");
      out.write("              <div class=\"message-panel\" >\n");
      out.write("                  ");

                      
                  
      out.write("\n");
      out.write("                <div class=\"messages\">\n");
      out.write("                    ");

                        
                        String receiver = "None";
                        
                        
                        
                        
//                        ArrayList<MessageBean> userList = new ArrayList<MessageBean>();
                        if(msgScope != null){
                            ArrayList<MessageBean> msgList = manageMsg.getMessages(msgScope);
                            Enumeration<MessageBean> msges = Collections.enumeration(msgList);
                            
                            if(!msgList.isEmpty()){
                                while(msges.hasMoreElements()){
                                    MessageBean msg = msges.nextElement();
                            
                                // **NOTE**   sender of this msg becomes receiver if there is 
                                        String r = msg.getSender();
                                        if(r.equals(username)){ 
                                            r = "you";
                                            receiver = msg.getReceiver();
                                        }
                                        else{
                                            r = msg.getSender();
                                            receiver = r;
                                        }
                                        out.print("<div class='msg-single-div-left'>"
                                            +r+" : " +msg.getMsg()
                                            + "</div><br>");
                                        
                                        
                                }
                                
                                if ( receiver == null ){
                                    receiver = "None";
                                }
                                
                            }
                            else{
                                out.print("Currently no messages");
                            }   
                        }
                        else if (msgScope == null){
                            out.print("msgScope is null");
                        }
                    
                    
      out.write("\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("              <br><center>\n");
      out.write("                <div class=\"msg-form-div\">\n");
      out.write("                  <form class=\"\" action=\"MessageServlet\" method=\"post\">\n");
      out.write("                    <input type=\"text\" class=\"msg-form\" name=\"msgFromSender\" value=\"\" placeholder=\"Enter your message\"> &nbsp;\n");
      out.write("                    <input type=\"hidden\" name=\"eventId\" value='");
      out.print( eventId );
      out.write("' >\n");
      out.write("                    <input type=\"hidden\" name=\"receiver\" value=\"");
      out.print( receiver );
      out.write("\"\n");
      out.write("                    <input type=\"hidden\" name=\"userType\" value='");
      out.print( userType );
      out.write("'>\n");
      out.write("                    <input type=\"hidden\" name=\"msgScope\" value=\"");
      out.print( msgScope );
      out.write("\">\n");
      out.write("                    <button type=\"submit\" name=\"send-msg-btn\" class=\"\">\n");
      out.write("                        Send </button>\n");
      out.write("                    \n");
      out.write("                  </form>\n");
      out.write("                </div>\n");
      out.write("                    ");

//                    out.print(eventId+" r- "+receiver+" ut- "+userType+" msscope- "+msgScope);
                    
      out.write("\n");
      out.write("                  </center>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("          <div class=\"thirdDiv\">\n");
      out.write("              <form action=\"message-dashboard.jsp\" method=\"get\">\n");
      out.write("                        ");

                        ArrayList<MessageBean> contactList = manageMsg.getNewMsgScope(username);
                        Enumeration<MessageBean> contacts = Collections.enumeration(contactList);    
                        out.print("New Messages\n");
                        out.print(contactList.isEmpty());
                        if(!contactList.isEmpty()){
                            while(contacts.hasMoreElements()){
                                MessageBean msg = contacts.nextElement();
                                senderContact = msg.getSender();
                                msgScope = msg.getScope();
                                if(senderContact.equals(username)){
                                
                                }
                                else{
//                                    receiveContact =  msg.getReceiver();
                                    
                                    out.println("<br>"
                                            + "<button type='submit' name='contactShift' class='contact-btn' value='"+msgScope+"'>"
                                            + " From : "+senderContact +" Event no : "+Integer.toString(msg.getEventno()) 
                                            + "</button>"+"<br>");
                                } 
                            }
                            if ( senderContact == null ){
                                senderContact = "None Receiver";
                            }
                        }
                        

                

                        
      out.write("\n");
      out.write("                        </form>\n");
      out.write("          </div>\n");
      out.write("    </div>\n");
      out.write("                        \n");
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
