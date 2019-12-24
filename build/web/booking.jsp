<%--
    Document   : booking
    Created on : Jul 9, 2019, 1:18:55 AM
    Author     : sudhan
--%>

<%@page import="beans.EventBean"%>
<%@page import="helper.ManageEvent"%>
<%@page import="helper.ManageBookEvent"%>
<%@page import="beans.BookEventBean"%>
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
            String tableName = null;
          
            try {
                   tableName = request.getParameter("bookingEventDetail");
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
                      
                     boolean displayDetails = false;
                     if(tableName != null){
                        displayDetails = true;
                     }
                     else{
                         tableName = "debugBuinessBooking";
                     }
                    out.print("<text> Event Name :"+tableName+"</text>");

                  %>

                </section>
              </div><br>


              <div class="message-panel" >
                  <%

                  %>
                <div class="messages">
                    <%

                    ManageBookEvent manageBooking = new ManageBookEvent();
                    ArrayList<BookEventBean> detailList =  manageBooking.getBookingDetails(tableName);
                    Enumeration<BookEventBean> booking = Collections.enumeration(detailList);

                    %>
                    <table>
                      <tr>
                        <th>Tourist First Name</th>
                        <th>Tourist Last Name</th>
                        <th>Tourist Email Address</th>
                        <th>Mobile Number</th>
                        <th>Booking Date</th>
                        <th>Booking Time</th>
                        <th>Number of People</th>
                        <th>Total Price</th>
                      </tr>
                      <%
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
                                + "<td colspan='8'>No Records</td>"
                                + "</tr>");
                    }
                      %>
                      <tr>
                          <td "7"></td>
                      </tr>
                    </table>

                </div>
              </div>
              <br>
              <center>
<!--                <div class="msg-form-div">
                  <form class="" action="MessageServlet" method="post">
                    <input type="text" class="msg-form" name="msgFromSender" value="" placeholder="Enter your message"> &nbsp;
                    <input type="hidden" name="eventId" value='' >
                    <input type="hidden" name="receiver" value=""
                    <input type="hidden" name="userType" value=''>
                    <input type="hidden" name="msgScope" value="">
                    <button type="submit" name="send-msg-btn" class="">
                        Send </button>

                  </form>
                </div>-->
                    <%
//                    out.print(eventId+" r- "+receiver+" ut- "+userType+" msscope- "+msgScope);
                    %>
                  </center>

        </div>
          <div class="thirdDiv">
              <form action="booking.jsp" method="get">
              <%
              
                              String evntName = "";
                String evntTableName = null;
                ManageEvent evntDetail = new ManageEvent();
                        ArrayList<EventBean> bookingList = evntDetail.getBusinessEvents(username);
                        Enumeration<EventBean> bookEvnt = Collections.enumeration(bookingList);    
                        out.print("New Messages\n");
//                        out.print(bookingList.isEmpty());
                        if(!bookingList.isEmpty()){
                            while(bookEvnt.hasMoreElements()){
                                EventBean evt = bookEvnt.nextElement();
//                                senderContact = msg.getSender();
                                evntName = evt.getEventName();
                                evntTableName = evt.getEventBookDetail();
                                out.println("<br>"
                                    + "<button type='submit' name='bookingEventDetail' class='contact-btn' value='"+evntTableName+"'>"
                                    + " "+evntName +" Event no : "+Integer.toString(evt.getEventId()) 
                                    + "</button>"+"<br>");
                                 
                            }
                        }
                        else{
                                out.println("<br>"
                                    + "<button type='submit' name='bookingEventDetail' class='contact-btn' value=''>"
                                    +  "No event records"
                                    + "</button>"+"<br>");
                            
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
