/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package debug;

import dbConnection.DbConnect;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author sudhan
 */


public class TestServlet extends HttpServlet {

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
            
            PrintWriter out = response.getWriter();
            out.print("<h1>\t ERROR </h1>");
            out.print("   Error header msg : "+response.getHeader("ERROR"));
//            HttpSession userSession = request.getSession(false); 
//            String sender = userSession.getAttribute("username").toString();
//        String userType = userSession.getAttribute("userType").toString();
//        String ifScope = request.getParameter("msgScope");
//        String receiver = request.getParameter("receiver");
//            out.print("<h1>\t ERROR </h1>"); 
//            out.print("Sender : "+request.getParameter(sender)+" ");
//            out.print("userrtype : "+request.getParameter(userType)+"  ");
//            out.print("ifScope : "+request.getParameter(ifScope)+" ");
//            out.print("Reciever : "+request.getParameter(receiver)+" ");
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
//       PrintWriter out = response.getWriter();
//       Part img = request.getPart("image");
//       Connection con = null;
//        try {
//        con = DbConnect.getConnection();
//        PreparedStatement stm = con.prepareStatement("INSERT INTO `testImagetable` (`image`) VALUES(?)");
//        InputStream istream = img.getInputStream();
//        stm.setBlob(1, istream);
//        int rslt =stm.executeUpdate();
//            if (rslt>0){
//                response.sendRedirect("testimagePage.jsp");
//            }
//            else{
//                out.print("Error occured");
//            }
//            con.close();
//        } 
//        catch (Exception e) {
//            out.print(e.getMessage());
//        }
        
       
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
