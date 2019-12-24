/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

/**
 *
 * @author sudhan
 */
import beans.BookEventBean;
import beans.EventBean;
import dbConnection.DbConnect;
import helper.ManageBookEvent;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
public class ManageBookEvent {
    
    public BookEventBean getBookingIdUsingTouristEmail(String tableName , BookEventBean evnt){
        
        Connection con = null;
        BookEventBean bookingDetail = null;
        
        try {
            con = DbConnect.getConnection();
            
            String sql = "SELECT * FROM `"+tableName+"` WHERE `touristEmailAdd` = ? ";
            PreparedStatement stm = con.prepareStatement(sql); 
            stm.setString(1, evnt.getTouristEmailAdd());
            
            ResultSet rslt = stm.executeQuery();
            if (rslt.next()){
                bookingDetail.setEventBookId(rslt.getInt("eventBookId")); 
            }
        } 
        catch (Exception e) {
        
        }
        finally{
            return bookingDetail;
        }    
    }
    
    public boolean delBookingUsingEmailAdd(BookEventBean evnt, String tableName) throws SQLException{
        
        boolean delStatus = false;
        Connection con = null;
        
        try {
            con = DbConnect.getConnection();
            String sql = "DELETE FROM `"+tableName+"` WHERE `touristEmailAdd` = (?)";
            
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, evnt.getTouristEmailAdd());
            
            stm.execute();
            delStatus = true;
        } 
        catch (Exception e) {
            delStatus = false;
        }
        finally{
            con.close();
            return delStatus;
        }
    }
    
    
    public boolean addbookEvent(BookEventBean evnt, EventBean eventDetail) throws SQLException{
        
        Connection con = null;
        boolean status = false;
        ManageBookEvent mag = new ManageBookEvent();
        Util util = new Util();
        String tableName = null;
        
        try {
            con = DbConnect.getConnection();
            tableName = evnt.getEventBookTable();
            
            String eventPageSql = "INSERT INTO `"+tableName+"`"
                    + "(`touristFirstName`, `touristLastName`, `touristEmailAdd`, `mobileNumber`, `bookingDate`, `bookingTime`, `numberOfPerson`, `totalPrice`)"
                    + "VALUES (?,?,?,?,?,?,?,?)";
            
            PreparedStatement eventPageStm = con.prepareStatement(eventPageSql);
            eventPageStm.setString(1, evnt.getTouristFirstName());
            eventPageStm.setString(2, evnt.getTouristLastName());
            eventPageStm.setString(3, evnt.getTouristEmailAdd());
            eventPageStm.setInt(4, evnt.getMobileNumber());
            eventPageStm.setString(5, evnt.getBookingDate());
            eventPageStm.setString(6, evnt.getBookingTime());
            eventPageStm.setInt(7, evnt.getNumberOfPerson());
            eventPageStm.setInt(8, evnt.getTotalPrice());
            
            eventPageStm.execute();
            if(addbookRegDetailToUser(evnt,eventDetail)){
            status = true;    
            }
            
        } 
        catch (Exception e) {
            status = false;
              
            
            
            if (tableName != null && util.validateEntry("touristEmailAdd", evnt.getTouristEmailAdd(), tableName)){
                try {
                    mag.delBookingUsingEmailAdd(evnt, tableName);
                } 
                catch (Exception e1) {
                    
                }
                    
            }
        }
        finally{
         con.close();
         return status;
            
        }
    }
    
    public boolean addbookRegDetailToUser(BookEventBean evnt, EventBean eventDetail) throws SQLException{
        Connection con = null;
        boolean status = false;
        
        try {
            con = DbConnect.getConnection();
            String tableName = evnt.getEventBookTable();
            
            String eventHisSql = "INSERT INTO `"+tableName+"`"
                    + "(`eventName`, `catOfEvent`, `bookedDate`, `city`, `orgBy`, `rating`)"
                    + "VALUES (?,?,?,?,?,?)";
            
            PreparedStatement eventHistoryStm = con.prepareStatement(eventHisSql);
            eventHistoryStm.setString(1, eventDetail.getEventName());
            eventHistoryStm.setString(2, eventDetail.getCategory());
            eventHistoryStm.setString(3, evnt.getBookingDate());
            eventHistoryStm.setString(4, eventDetail.getEventCity());
            eventHistoryStm.setString(5, eventDetail.getBusinessUsername());
            eventHistoryStm.setString(6, "pending");
            
            eventHistoryStm.execute();
            status = true;
        } 
        catch (Exception e) {
            status = false;
        }
        finally{
         con.close();
         return status;
            
        }
    }

    public ArrayList<BookEventBean> getBookingDetails(String tableName) throws SQLException{
        
        Connection con = null;
        ArrayList<BookEventBean> detailList = new ArrayList<>();
        
        try {
            con = DbConnect.getConnection();
            
            String sql = "SELECT * FROM `"+tableName+"`";
            
            PreparedStatement stm = con.prepareCall(sql);
//            stm.setString(1, tableName);
            
            ResultSet rslt = stm.executeQuery();
                
            while(rslt.next()){
                BookEventBean booking = new BookEventBean();
                
                booking.setEventBookId(rslt.getInt("eventBookId"));
                booking.setTouristFirstName(rslt.getString("touristFirstName"));
                booking.setTouristLastName(rslt.getString("touristLastName"));
                booking.setTouristEmailAdd(rslt.getString("touristEmailAdd"));
                booking.setMobileNumber(rslt.getInt("mobileNumber")); 
                booking.setBookingDate(rslt.getString("bookingDate"));
                booking.setBookingTime(rslt.getString("bookingTime"));
                booking.setNumberOfPerson(rslt.getInt("numberOfPerson"));
                booking.setTotalPrice(rslt.getInt("totalPrice")); 
                
                detailList.add(booking);
            }
            
        } 
        catch (Exception e) {
            e.getMessage();
        }
        finally{
            con.close();
            return detailList;        
        }
    }

}