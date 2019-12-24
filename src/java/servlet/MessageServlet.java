/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sudhan
 */
import beans.MessageBean;
import beans.BusinessBean;
import beans.TouristBean;
import beans.EventBean;
import helper.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

public class MessageServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // debug purpose
        PrintWriter out = response.getWriter();
        RequestDispatcher debugDispatcher = request.getRequestDispatcher("TestServlet");
        
        ManageEvent magEvent = new ManageEvent();
        ManageUsers magUser = new ManageUsers();
        
        EventBean eventDetail = new EventBean();
        MessageBean msg = new MessageBean();
//        BusinessBean business = new BusinessBean();
        TouristBean tourist = new TouristBean();
        ManageMesg magMsg = new ManageMesg();
        
        int eventId = Integer.parseInt(request.getParameter("eventId"));
        String msgScope = null;
        
        HttpSession userSession = request.getSession(false);
        
        String sender = userSession.getAttribute("username").toString();
        String userType = userSession.getAttribute("userType").toString();
        String ifScope = request.getParameter("msgScope");
        String receiver = request.getParameter("receiver");
        
        out.print("Sender : "+sender+" ");
            out.print("userrtype : "+userType+"  ");
            out.print("ifScope : "+ifScope+" ");
            out.print("Reciever : "+receiver+" ");
            out.print("Event Id : "+Integer.toString(eventId)+" "); 
        ManageMesg mngMsg = new ManageMesg();
        
        
        String messages = request.getParameter("msgFromSender");
        out.print("meg : "+messages+" "); 
        
        msg.setMsg(messages);
           
        msg.setSender(sender);
        try{
        if(receiver.equals("None") && eventId != 0){
            if(userType.equals("touristAuth")){
                
                try {
//                    MessageBean preMsg = mngMsg.getMsgDetailUsingEventIdUserNameR(eventId, sender);
                eventDetail = magEvent.getSingleEvent(eventId);
                    String r = eventDetail.getBusinessUsername();
                    msg.setReceiver(r); 
                    msg.setEventno(eventId);
                    msg.setScope(msgScope = sender+"-"+receiver+"-"+Integer.toString(eventId));  
                    
                } 
                catch (Exception e) {
                    response.addHeader("ERROR", "No record found");
                    debugDispatcher.forward(request, response); 
                }
                
            }
            else{
                response.addHeader("ERROR", "No exception from new msg from tourist");
                debugDispatcher.forward(request, response); 
            }
        }    
            
        else if(userType.equalsIgnoreCase("touristAuth") && !ifScope.equals("null")){
//                receiver = eventDetail.getBusinessUsername();
                msg.setReceiver(receiver);
                    
                if (ifScope.equals("null")){
                    msgScope = receiver+"-"+sender+"-"+Integer.toString(eventId);
                }
                else{
                  MessageBean cmsg = mngMsg.getMsgDetailSingle(ifScope); 
                  String sc =cmsg.getMsg();
                    if (sc.equals("sc404")){
                        response.addHeader("ERROR", "No scope msg retrived");
                        debugDispatcher.forward(request, response); 
                    }
                    else{
                        msg.setEventno(cmsg.getEventno()); 
                        if(receiver.equals(cmsg.getSender())){
                           msg.setReceiver(receiver); 
                        }
                    }
                }
            }
        else if(userType.equals("businessAuth")){
                
                MessageBean oldMsg = mngMsg.getMsgDetailSingle(ifScope); 
                String sc = oldMsg.getMsg();
                if (sc.equals("sc404")){
                    debugDispatcher.forward(request, response); 
                }
                else{
                    msg.setSender(sender);
                    
                    if (!sender.equals(oldMsg.getSender())){
                        msg.setReceiver(oldMsg.getSender());
                    }
                    else{
                        response.addHeader("ERROR", "SENDER AND RECEIVER ARE the SAME");
                        debugDispatcher.forward(request, response); 
                    }
                    msg.setEventno(oldMsg.getEventno());
                    
                }
                        
                if (ifScope.equals("null")){
                    msgScope = sender+"-"+receiver+"-"+Integer.toString(eventId); 
                }
            }
            
            if (!ifScope.equals("null")){
                msgScope = ifScope;
            }
            msg.setScope(msgScope); 
            
//            out.print("\n Sender: "+msg.getSender()+"\n"
//                    +"Rece : "+msg.getReceiver()+ "\n"
//                    +"Mesg : "+msg.getMsg()+ "\n"
//                    +"event no : "+msg.getEventno() + "\n"
//                    + "scope : "+msg.getScope()+"\n"
//                            + "\n");
            
////debuginnnng            
            boolean status = magMsg.sendMsg(msg);
            out.print(status);
            String eid = Integer.toString(eventId);
            response.addHeader("msg-scope", msgScope);
            if(status) {
                
                response.addHeader("msgStatus", "message sent");
                response.sendRedirect("message-dashboard.jsp");
            } 
            else{
                
                response.addHeader("msgStatus", "message NOT sent");
                response.sendRedirect("message-dashboard.jsp");
            }
            
        } 
        catch (Exception er) {
            
            out.print(er.getMessage()); 
        }
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
//        PrintWriter out = response.getWriter();
//        ManageEvent magEvent = new ManageEvent();
//        ManageUsers magUser = new ManageUsers();
//        EventBean eventDetail = new EventBean();
//        MessageBean msg = new MessageBean();
////        BusinessBean business = new BusinessBean();
//        TouristBean tourist = new TouristBean();
//        ManageMesg magMsg = new ManageMesg();
//        
//        int eventId = Integer.parseInt(request.getParameter("eventId"));
//        String sender = request.getParameter("sender");
//        String userType = request.getParameter("userType");
//        String messages = request.getParameter("msg");
//        try {
//            eventDetail = magEvent.getSingleEvent(14);
//            out.print(sender+"\n");
//           out.print(userType+"\n"); 
//            out.print(messages+"\n");
//            out.print(eventId+"\n");
//            
//            if(userType.equals("touristAuth")){
//                
//                out.print("TouristSender : "+eventDetail.getBusinessUsername()+"\n");
//            }
//            else if(userType.equals("businessAuth")){
//                out.print("BusinesSender : "+sender);
//                // tourist are receiver
//                        //  use MsgManager 
//                        msg.setTouristUser(null);
//            }
//
//    }
//        catch(Exception e){
//            out.print("Exception "+e.getMessage());
//            }
        }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
