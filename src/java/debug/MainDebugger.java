/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package debug;

/**
 *
 * @author sudhan
 */
import beans.BookEventBean;
import beans.BusinessBean;
import beans.EventBean;
import beans.MessageBean;
import dbConnection.DbConnect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import beans.TouristBean;
import helper.ManageEvent;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;


public class MainDebugger {
    
        public ArrayList<MessageBean> getMessages(String receiver, String userType, int eventId) throws SQLException{
        
        Connection con = null;
        ArrayList<MessageBean> msgList = new ArrayList<MessageBean>();
        String colName = null;
        
        if(userType.equals("businessAuth")){
            colName = "business-user";
        }
        else if(userType.equals("touristAuth")){
            colName = "tourist-user";
        }
        
        try {
            con = DbConnect.getConnection();
            
            String sql = "SELECT * FROM `message-table` WHERE `"+colName+"` = ? AND `eventId` = ? ";
            
            PreparedStatement stm = con.prepareCall(sql);
            stm.setString(1, receiver);
            stm.setInt(2, eventId);
            
            ResultSet rslt = stm.executeQuery();
            
            while(rslt.next()){
                MessageBean msg = new MessageBean();
                msg.setNo(rslt.getInt("msgId"));
//                msg.setTouristUser(rslt.getString("tourist-user"));
//                msg.setBusinessUser(rslt.getString("business-user"));
//                msg.setEventId(rslt.getInt("eventId"));
//                msg.setMessage(rslt.getString("message"));
                
                msgList.add(msg);
            }
            
        } 
        catch (Exception e) {
            e.getMessage();
        }
        finally{
            con.close();
            return msgList;        
        }
    }
      
        public TouristBean getTouristSingleUser(String username) throws SQLException{
        Connection con = null;
        TouristBean tourist = new TouristBean();
        
        try {
            con =DbConnect.getConnection();
            
            String sql = "SELECT * FROM `tourist-user` WHERE `username` =(?) ";
            
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, username);
            
            ResultSet rslt = stm.executeQuery();
            if(rslt.next()){
                tourist.setFirstName(rslt.getString("firstName"));
                tourist.setLastName(rslt.getString("lastName"));
                tourist.setEmailAdd(rslt.getString("emailAdd"));
                tourist.setUsername(rslt.getString("username"));
            
                // Complete others also
            }
            else{
                tourist.setUsername(null);
            }
        } 
        catch (Exception e) {
            e.getMessage();
            tourist.setUsername(null);
        }
        finally{
            con.close();
            return tourist;
        }
        
    }
    
        public String addbookEvent(BookEventBean evnt) throws SQLException{
        Connection con = null;
        String status = null;
        
        try {
            con = DbConnect.getConnection();
            String tableName = evnt.getEventBookTable();
            String sql = "INSERT INTO `"+tableName+"`"
                    + "(`touristFirstName`, `touristLastName`, `touristEmailAdd`, `mobileNumber`, `bookingDate`, `bookingTime`, `numberOfPerson`, `totalPrice`)"
                    + "VALUES (?,?,?,?,?,?,?,?)";
            
            PreparedStatement stm = con.prepareStatement(sql);
             stm.setString(1, evnt.getTouristFirstName());
            stm.setString(2, evnt.getTouristLastName());
            stm.setString(3, evnt.getTouristEmailAdd());
            stm.setInt(4, evnt.getMobileNumber());
            stm.setString(5, evnt.getBookingDate());
            stm.setString(6, evnt.getBookingTime());
            stm.setInt(7, evnt.getNumberOfPerson());
            stm.setInt(8, evnt.getTotalPrice());
            
            stm.execute();
            status = "Done";
        } 
        catch (Exception e) {
            status = e.getMessage();
        }
        finally{
         con.close();
         return status;
            
        }
    }
  
        public ArrayList<EventBean> getEvents(String city) throws SQLException{
        
        Connection con = null;
        String sqlQuery;
        ArrayList<EventBean> eventsList = new ArrayList<EventBean>();
        boolean queryChange = false;
        
        try {
            con = DbConnect.getConnection();
            
            if (city.equalsIgnoreCase("all")){
                sqlQuery = "SELECT * FROM `events-table`;";
            }
            else{
                sqlQuery = "SELECT * FROM `events-table` WHERE `eventCity` =(?)";
                queryChange =true;
            }
            
            PreparedStatement stm = con.prepareStatement(sqlQuery);
            if (queryChange){
                stm.setString(1, city);
            }
            
            ResultSet rslt = stm.executeQuery();
            while(rslt.next()){
                EventBean event = new EventBean();
                
                event.setEventId(rslt.getInt("eventId"));
                event.setEventName(rslt.getString("eventName"));
                event.setBusinessUsername(rslt.getString("businessEventUsername"));
                event.setCategory(rslt.getString("eventCategory"));
                event.setStartDate(rslt.getString("startDate"));
                event.setEndDate(rslt.getString("endDate"));
                event.setEventContactNumber(rslt.getInt("eventContactNumber"));
                event.setEventContactPerson(rslt.getString("eventContactPerson"));
                event.setEventPrice(rslt.getInt("eventPrice"));
                event.setEventCity(rslt.getString("eventCity"));
                event.setEventDetails(rslt.getString("eventDetails"));
                event.setEventImage(rslt.getBlob("eventImage"));
            
                eventsList.add(event);
            }
            
        } 
        catch (Exception e) {
            
        }
        finally{
            con.close();
            return eventsList;
        }
    }
    
    
        public String getInfo() throws SQLException{
        String str = "null-info";
        ResultSet rslt=null;
        Connection conn = null;
        try {
            conn = dbConnection.DbConnect.getConnection();
            
        
        boolean loginStatus = false;
        Connection con = null;
        
            con = DbConnect.getConnection();
            String tour = "QWERT";
                  String sqlQueryCreateTable = "CREATE TABLE "+tour+"_tourist_event_history ("
                    + "Id int KEY AUTO_INCREMENT,"
                    + "eventName varchar(30),"
                    + "catOfEvent varchar(30),"
                    + "bookedDate Date,"
                    + "city varchar(30),"
                    + "orgBy varchar(30)"
                    + ")";
            
            
            PreparedStatement stmTable = con.prepareStatement(sqlQueryCreateTable);
       
            
            System.out.println(stmTable.execute());
            str = "Success";
            
        } 
        catch (Exception e) {
            
            str = e.getMessage()+"Failed";
                
        }
        finally{
            conn.close();
        }
        
        
        return str;
    }
    
        public int validateResult(ResultSet rslt) throws SQLException{
        
        rslt.last();
        int size = rslt.getRow(); 
        return size;
    }

        public void getMsgScope(String receiver) throws SQLException{
        
        Connection  con= null;
        ArrayList<MessageBean> scopeList = new ArrayList<MessageBean>();
        
        try {
            con = DbConnect.getConnection();
            String sql = "SELECT DISTINCT `scope`, `sender` FROM `mesg-table` WHERE `receiver` = ?";
            PreparedStatement stm = con.prepareCall(sql);
            stm.setString(1, receiver);
            
            ResultSet rslt = stm.executeQuery();
            
            while (rslt.next()){
                System.out.println("Sender : "+rslt.getString("sender")+" scope : "+rslt.getString("scope"));
            }
            
        }
        catch (Exception e){
            System.out.println("Exception is function : "+e.getMessage());
        }
        finally{
            con.close();
            
        }
    }
        
        public String addEvent(EventBean event) throws SQLException{
        
            boolean status = false;
            Connection con = null;
            ManageEvent mag = new ManageEvent();
            
            // debug 
            String v = null;
            
            try {
                con = DbConnect.getConnection();

                String sqlQuery = "INSERT INTO `events-table` (`eventName`, `businessEventUsername`,"
                         + " `startDate`, `endDate`, `eventCategory`, `eventContactNumber`, `eventContactPerson`,"
                         + " `eventPrice`, `eventCity`, `eventDetails`, `eventImage`,`eventBookDetail`)"
                         + " VALUES ( ?,?,?,?,?,?,?,?,?,?,?,?);";

                String sqlCreateTable = "CREATE TABLE `"+event.getEventBookDetail()+"`("
                         + "eventBookId int AUTO_INCREMENT,"
                         + "touristFirstName varchar(50),"
                         + "touristLastName varchar(50),"
                         + "touristEmailAdd varchar(50),"
                         + "mobileNumber int(50),"
                         + "bookingDate varchar(50),"
                         + "bookingTime varchar(50),"
                         + "numberOfPerson int,"
                         + "totalPrice int,"
                         + ""
                         + "PRIMARY KEY (eventBookId)"
                         + ");";

                 PreparedStatement stm = con.prepareStatement(sqlQuery);
                 PreparedStatement stmCreateTable = con.prepareStatement(sqlCreateTable);

                 stm.setString(1, event.getEventName());
                 stm.setString(2, event.getBusinessUsername());
                 stm.setString(3, event.getStartDate());
                 stm.setString(4, event.getEndDate());
                 stm.setString(5, event.getCategory());
                 stm.setInt(6, event.getEventContactNumber());
                 stm.setString(7, event.getEventContactPerson());
                 stm.setInt(8, event.getEventPrice());
                 stm.setString(9, event.getEventCity());
                 stm.setString(10, event.getEventDetails());

    //             Part img = event.getEventImage();
    //             InputStream istream = img.getInputStream();
                 stm.setBlob(11, event.getInsertImage());
                 stm.setString(12, event.getEventBookDetail());

                 stm.execute();
                 stmCreateTable.execute();
                 status = true;
                 v = "Success";
            } 
            catch (Exception e) {
                v ="Exception : "+ e.getMessage()+"\n";
                status = false;


                if (mag.validateEntry("eventBookDetail", event.getEventBookDetail(), "events-table")){
                    try {
                        mag.delEvents(event.getEventId());
                    } 
                    catch (Exception e1){
                        v = v+ e1.getMessage();
                    }
                        
                }

            }   
            finally{
                con.close();
                return v;
            }
    }
    
            
        public boolean validateEntry(String colName, String colValue, String tableName) throws SQLException{
        
        Connection con = null;
        boolean  validateResult = false;
        // debug 
        String v = null;
        try{
            con = DbConnect.getConnection();
            String sql = "SELECT * FROM `"+tableName+"` WHERE `"+colName+"` = ? ";
            PreparedStatement stm = con.prepareStatement(sql);
            
            stm.setString(1, colValue);
            
            ResultSet r = stm.executeQuery();
            int rows = 0;
            if (r.next()){
               validateResult = true;
            }
            else{
                validateResult = false;
            }
            
        }
        catch (Exception e){
            validateResult = false;
        }
        finally{
            con.close();
            return validateResult;
        }
        
    }
        
        public boolean delEvents(int eventId) throws SQLException   {
        Connection con = null;
        boolean actionStatus = false;
        String bookTableName = null;
        try {
            con = DbConnect.getConnection();
            String sqlSelectQuery = "SELECT `eventBookDetail` FROM `events-table` WHERE `eventId` = (?)";
            String sqlQuery = "DELETE FROM `events-table` WHERE `eventId` = (?)";
            
            
            PreparedStatement stm = con.prepareStatement(sqlQuery);
            PreparedStatement stmSelect = con.prepareStatement(sqlSelectQuery);
            stm.setInt(1, eventId);
            stmSelect.setInt(1, eventId);
            
            ResultSet rslt = stmSelect.executeQuery();
            if(rslt.next()){
                bookTableName = rslt.getString("eventBookDetail");
            }
            
            
            stm.execute();
            boolean delAction = true;
            
            if(bookTableName != null && delAction){
                String sqlDropQuery = "DROP TABLE IF EXISTS `"+bookTableName+"`;";
                PreparedStatement stmdel = con.prepareStatement(sqlDropQuery);
                stmdel.execute();
                actionStatus = true;
            }
            
                    
        } 
        catch (Exception e) {
           actionStatus = false;  
        }
        finally{
            con.close();
            return actionStatus;
        }
    }
    
        public void getBookingDetails(String tableName) throws SQLException{
        
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
            System.out.println(e.getMessage());
        }
        finally{
            con.close();
            System.out.println(detailList.isEmpty());        
        }
    }
        
        public static void main(String[] args) throws SQLException {
    
            try{
            MainDebugger debug = new MainDebugger();
        debug.getBookingDetails("thu-booking-fourthEvent");
//            ArrayList<BookEventBean> detailList =debug.getBookingDetails("adminbusiness-booking-adminBusinessEvent1");
//              
//            Enumeration<BookEventBean> booking = Collections.enumeration(detailList);
//                        
//                System.out.println(detailList.isEmpty());
//                System.out.println("\n Result");
            
        // debuggin del event function 
//         boolean rslt = debug.delEvents(28);
//        System.out.println("Result is : "+rslt);
            
            
         //   debugging add event function 
//         
//         EventBean event = new EventBean();
//         event.setEventName("DebugTEST");
//         event.setBusinessUsername("Debugger");
//         event.setCategory("debug"); 
//         event.setStartDate("1"); 
//         event.setEndDate("1");
//         event.setCategory("TEST");
//         event.setEventContactNumber(2456); 
//         event.setEventContactPerson("testdebug"); 
//         event.setEventPrice(250); 
//         event.setEventCity("test city");
//         event.setEventDetails("detailare test");
//            InputStream inst = new ByteArrayInputStream("dasacacd".getBytes()); 
//            event.setInsertImage(inst); 
//         event.setEventBookDetail("DebugTable");
//         
//         String r = debug.addEvent(event);
//                System.out.println("Result is : \n"+r);

        // delete function is exits
//            boolean rslt = debug.validateEntry("eventName", "secondEvent", "events-table");
//            
//            while  (debug.validateEntry("eventBookDetail","adminbusiness-booking-testsecondevent", "events-table")){
//                Connection con = null;
//                try{
//                    con = DbConnect.getConnection();
//                    String sqlQuery = "DELETE FROM `events-table` WHERE `eventBookDetail` = 'adminbusiness-booking-testsecondevent'";
//                    
//                    Statement stm  = con.createStatement();
//                    stm.execute(sqlQuery);
//                    System.out.println("Entry Deleted");
//                }
//                catch(Exception ex){
//                    System.out.println("exception : "+ex.getMessage());
//                    System.out.println("Failed to delete");
//                }
//                finally{
//                    con.close();
//                }
//                System.out.println(debug.validateEntry("eventBookDetail","adminbusiness-booking-testsecondevent", "events-table"));
//            }
            
            
            
            

                
      // Message Area           
//            ArrayList<MessageBean> msgList = debug.getMsgScope("thu");
//         
//         Enumeration<MessageBean> msges = Collections.enumeration(msgList);
//         System.out.println(msgList.isEmpty());
//         if(!msgList.isEmpty()){
//            while(msges.hasMoreElements()){
//                MessageBean msg = msges.nextElement();
//                    System.out.println(msg.getScope()+" >  "+msg.getSender()+"\n");
//             }
//        }
//        else{
//             System.out.println("No contacts");
//        }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
           
//        
    }
    
}

