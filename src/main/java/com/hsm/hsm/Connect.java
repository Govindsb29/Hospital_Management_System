package com.hsm.hsm;

import java.sql.*;
public class Connect
{
    public Connection con;
    public Statement stmt;
    public void connectdb()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hsm", "root", "0000");
            stmt = con.createStatement();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] arg)
    {
        Connect cn = new Connect();
        cn.connectdb();
    }
}