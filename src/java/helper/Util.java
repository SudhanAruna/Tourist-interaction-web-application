/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import dbConnection.DbConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author sudhan
 */
public class Util {
    
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
}
