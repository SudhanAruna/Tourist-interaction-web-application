<%--
    Document   : message-dashboard
    Created on : Jun 16, 2019, 4:06:39 PM
    Author     : sudhan
--%>

<%@page import="sun.misc.CompoundEnumeration"%>
<%@page import="java.util.Enumeration"%>
<%@page import="beans.MessageBean"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.ArrayList"%>
<%@page import="helper.ManageMesg"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
  <%        // Session Checking 
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
                
        %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="Styles/messageDasboard.css">
        <script>
            
        </script>
    
    </head>
    
    <body>

      <div class="header">
        <%@include file="header.jsp"%>
      </div>
        <div class="pageDiv">
           <%
                
                  String status = response.getHeader("msgStatus");

                  if(status != null){
                    out.print("<h4>"+status+"</h4>");
                  }
                  if(status == null){
                      out.print("<h4>"+status+"</h4>");
                  }
                
          %> 
          <div class="firstDiv" style="width:auto;height: 800px;">
            <table>
              <tr>
                <td>Pro pic</td>
              </tr>
              <tr>
                  <td>
                    <form class="" action="#" method="get">
                      <input type="text" name="searchLocation" class="form-text-box" value="" placeholder="Search location in Sri lanka">
                        <input type="submit" name="" value="Search" class="dash-menu-content">
                    </form>
                  </td>
              </tr>
              <tr>
                <td>
                  <a href="#">
                    <button type="button" name="button" class="dash-menu-content">
                      Setting</button>
                  </a>
                </td>
              </tr>
              <tr>
                <td>
                  <a href="#">
                    <button type="button" name="button" class="dash-menu-content">
                      Booking</button>
                    </a>
                </td>
              </tr>
              <tr>
                <td>
                  <a href="message-dashboard.jsp">
                    <button type="button" name="button" class="dash-menu-content">
                      Messages</button>
                    </a>
                </td>
              </tr>
            </table>
          </div>
          <div class="secondDiv">
                          <div class="tble" height=10%>
                <section align='center' >
                  
                  <%
                      
                      if(msgScope != null){
                          
                          out.print("<text> Contact : "+receiveContact +"</text>");
                      }
                      else{
                           out.print("<text>Please select your contact</text>");
                      }

                  %>
                   
                </section>
              </div><br>
    
              
              <div class="message-panel" >
                  <%
                      
                  %>
                <div class="messages">
                    <%
                        
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
                    
                    %>
                </div>
              </div>
              <br><center>
                <div class="msg-form-div">
                  <form class="" action="MessageServlet" method="post">
                    <input type="text" class="msg-form" name="msgFromSender" value="" placeholder="Enter your message"> &nbsp;
                    <input type="hidden" name="eventId" value='<%= eventId %>' >
                    <input type="hidden" name="receiver" value="<%= receiver %>"
                    <input type="hidden" name="userType" value='<%= userType %>'>
                    <input type="hidden" name="msgScope" value="<%= msgScope %>">
                    <button type="submit" name="send-msg-btn" class="">
                        Send </button>
                    
                  </form>
                </div>
                    <%
//                    out.print(eventId+" r- "+receiver+" ut- "+userType+" msscope- "+msgScope);
                    %>
                  </center>

        </div>
          <div class="thirdDiv">
              <form action="message-dashboard.jsp" method="get">
                        <%
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
                        

                

                        %>
                        </form>
          </div>
    </div>
                        
<!--        <div class="footer">
      <%@include file="footer.jsp"%>
      </div>-->
        </body>
</html>
