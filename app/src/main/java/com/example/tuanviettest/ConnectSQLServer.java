package com.example.tuanviettest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.StrictMode;
import android.util.Log;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectSQLServer {
    Connection connection;
    Statement statement;
    String Per,Site,Date,User;

    @SuppressLint("NewApi")
    public Connection connectionclass() {
        String ip = "125.212.238.246";
        String port = "9898";
        String db = "TVApp_TEST";
        String un = "dangld";
        String password = "Dang@123";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection conn = null;
        String ConnectionURL = null;
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConnectionURL = "jdbc:jtds:sqlserver://" + ip + ":" + port + ";" + "databaseName=" + db + ";user=" + un + ";password=" + password + ";";
            conn = DriverManager.getConnection(ConnectionURL);

        } catch (Exception ex) {
            Log.e("ERROR", ex.getMessage());
        }
        return conn;
    }

    // get from sql server
    public void GetCheckKho() {
        String ConnectionResult = "";

        try {
            ConnectSQLServer connectionHelper = new ConnectSQLServer();
            connection = connectionHelper.connectionclass();
            if (connection != null) {
                String query = "select PerNbr,SiteID,Crtd_Datetime,Crtd_User from IN_WrkCosting";
                statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(query);
                while (rs.next()) {
                    Per = rs.getString(1);
                    Site = rs.getString(2);
                    Date = rs.getString(3);
                    User = rs.getString(4);
                    break;
                }

                rs.close();
            } else {
                ConnectionResult = "Check Connection";
            }
        } catch (Exception ex) {
            Log.e("Error: ", ex.getMessage());
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (Exception e) {}
        }
    }
    public void XuLyLoiKho() {
        String ConnectionResult = "";
        try {
            ConnectSQLServer connectionHelper = new ConnectSQLServer();
            connection = connectionHelper.connectionclass();
            if (connection != null) {
                String query = "delete IN_WrkCosting";
                statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(query);
                rs.close();
            } else {
                ConnectionResult = "Check Connection";
            }
        } catch (Exception ex) {
            Log.e("Error: ", ex.getMessage());
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (Exception e) {}
        }
    }
}
