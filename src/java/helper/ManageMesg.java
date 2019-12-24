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
import beans.MessageBean;
import dbConnection.DbConnect;
import java.sql.*;
import java.util.ArrayList;

public class ManageMesg {
    
    public boolean sendMsg(MessageBean msg) throws SQLException{
        
        Connection con = null;
        boolean actionStatus = false;
        
        try {
            con = DbConnect.getConnection();
            
            String sql = "INSERT INTO `mesg-table`"
                    + "(`sender`, `receiver`, `eventno`, `msg`, `scope`) "
                    + "VALUES (?,?,?,?,?)";
            
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, msg.getSender());
            stm.setString(2, msg.getReceiver());
            stm.setInt(3, msg.getEventno());
            stm.setString(4, msg.getMsg());
            stm.setString(5, msg.getScope());
            stm.execute();
            actionStatus = true;
            
        } 
        catch (Exception e) {
            actionStatus = false;
        }
        finally{
            con.close();
            return actionStatus;
        }
    }
                // restructure 
    public ArrayList<MessageBean> getMessages(String msgScope) throws SQLException{
        
        Connection con = null;
        ArrayList<MessageBean> msgList = new ArrayList<MessageBean>();
        String colName = null;
        
        try {
            con = DbConnect.getConnection();
            
            String sql = "SELECT * FROM `mesg-table` WHERE `scope` = ?";
            
            PreparedStatement stm = con.prepareCall(sql);
            stm.setString(1, msgScope);
            
            ResultSet rslt = stm.executeQuery();
            
            while(rslt.next()){
                MessageBean msg = new MessageBean();
                msg.setNo(rslt.getInt("no"));
                msg.setSender(rslt.getString("sender"));
                msg.setReceiver(rslt.getString("receiver"));
                msg.setEventno(rslt.getInt("eventno"));
                msg.setMsg(rslt.getString("msg"));
                msg.setScope(rslt.getString("scope")); 
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
    
    public ArrayList<MessageBean> getNewMsgScope(String receiver) throws SQLException{
        
        Connection  con= null;
        ArrayList<MessageBean> scopeList = new ArrayList<MessageBean>();
        
        try {
            con = DbConnect.getConnection();
            String sql = "SELECT DISTINCT `scope`, `sender`,`receiver`, `eventno`,`msg`,`no` FROM `mesg-table` WHERE `receiver` = ?";
            PreparedStatement stm = con.prepareCall(sql);
            stm.setString(1, receiver);
            
            ResultSet rslt = stm.executeQuery();
            
            while (rslt.next()){
                MessageBean msg = new MessageBean();
                msg.setNo(rslt.getInt("no"));
                msg.setSender(rslt.getString("sender"));
                msg.setReceiver(rslt.getString("receiver"));
                msg.setEventno(rslt.getInt("eventno"));
                msg.setMsg(rslt.getString("msg"));
                msg.setScope(rslt.getString("scope"));
               scopeList.add(msg);
            }
        }
        catch (Exception e){
            
        }
        finally{
            con.close();
            return scopeList;
        }
    }
    
    public ArrayList<MessageBean> getScopeMsgs(String scope) throws SQLException{
        
        Connection  con= null;
        ArrayList<MessageBean> scopeList = new ArrayList<MessageBean>();
        
        try {
            con = DbConnect.getConnection();
            String sql = "SELECT * FROM `mesg-table` WHERE `scope` = ?";
            PreparedStatement stm = con.prepareCall(sql);
            stm.setString(1, scope);
            
            ResultSet rslt = stm.executeQuery();
            
            while (rslt.next()){
                MessageBean msg = new MessageBean();
                msg.setNo(rslt.getInt("no"));
                msg.setSender(rslt.getString("sender"));
                msg.setReceiver(rslt.getString("receiver"));
                msg.setEventno(rslt.getInt("eventno"));
                msg.setMsg(rslt.getString("msg"));
                msg.setScope(rslt.getString("scope"));
               scopeList.add(msg);
            }
        }
        catch (Exception e){
            
        }
        finally{
            con.close();
            return scopeList;
        }
    }
    
    public MessageBean getMsgDetailSingle(String scope) throws SQLException{
        
        Connection con = null;
        MessageBean msgDetail = new MessageBean();
        
        try {
            con = DbConnect.getConnection();
            
            String sql = "SELECT * FROM `mesg-table` WHERE `scope` = ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, scope);
            
            ResultSet rslt = stm.executeQuery();
            
            if (rslt.next()){
                msgDetail.setNo(rslt.getInt("no"));
                msgDetail.setSender(rslt.getString("sender"));
                msgDetail.setReceiver(rslt.getString("receiver"));
                msgDetail.setEventno(rslt.getInt("eventno"));
                msgDetail.setMsg(rslt.getString("msg"));
                msgDetail.setScope(rslt.getString("scope"));
            }
            else{
                msgDetail.setMsg("sc404"); 
            }
        } 
        catch (Exception e) {
            msgDetail.setMsg("sc404");
        }
        finally{
            con.close();
            return msgDetail;
        }
    }
    
    public MessageBean getMsgDetailUsingEventIdUserNameR(int eventId, String sender) throws SQLException{
        
        Connection con = null;
        MessageBean msgDetail = new MessageBean();
        
        try {
            con = DbConnect.getConnection();
            
            String sql = "SELECT * FROM `mesg-table` WHERE `eventno` = ?  AND `receiver`= ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, eventId);
            stm.setString(1, sender);
            
            ResultSet rslt = stm.executeQuery();
            
            if (rslt.next()){
                msgDetail.setNo(rslt.getInt("no"));
                msgDetail.setSender(rslt.getString("sender"));
                msgDetail.setReceiver(rslt.getString("receiver"));
                msgDetail.setEventno(rslt.getInt("eventno"));
                msgDetail.setMsg(rslt.getString("msg"));
                msgDetail.setScope(rslt.getString("scope"));
            }
            else{
                msgDetail.setMsg("sc404"); 
            }
        } 
        catch (Exception e) {
            msgDetail.setMsg("sc404");
        }
        finally{
            con.close();
            return msgDetail;
        }
        
    }
    
                //  restructure
//    public ArrayList<MessageBean> getMesgCount(String receiver, String userType) throws SQLException{
//        
//        Connection con = null;
//        ArrayList<MessageBean> CountList = new ArrayList<MessageBean>(); 
//        String colName = null;
//        
//        if(userType.equals("businessAuth")){
//            colName = "business-user";
//        }
//        else if(userType.equals("touristAuth")){
//            colName = "tourist-user";
//        }
//        
//        try {
//            con = DbConnect.getConnection();
//
//            String sql = "SELECT DISTINCT `tourist-user`,`business-user`,`eventId` FROM `message-table` WHERE `"+colName+"` = ? ";
//            
//            PreparedStatement stm = con.prepareCall(sql);
//            stm.setString(1, receiver);
//            
//            ResultSet rslt = stm.executeQuery();
//            
//            while(rslt.next()){
//                MessageBean msg = new MessageBean();
//                msg.setNo(rslt.getInt("no"));
//                msg.setSender(rslt.getString("sender"));
//                msg.setReceiver(rslt.getString("receiver"));
//                msg.setEventno(rslt.getInt("eventno"));
//                msg.setMsg(rslt.getString("msg"));
//                
//                CountList.add(msg);
//            }
//            
//        } 
//        catch (Exception e) {
//            e.getMessage();
//        }
//        finally{
//            con.close();
//            return CountList;        
//        }
//        
//    }
    
}
