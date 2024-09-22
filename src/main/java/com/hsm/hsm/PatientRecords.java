package com.hsm.hsm;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

@WebServlet("/Records")
public class PatientRecords extends HttpServlet
{
    static Connect cn;
    public PatientRecords()
    {
        cn = new Connect();
        cn.connectdb();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        try
        {
            String sql = "Select * from patient_records;";
            ResultSet rs = cn.stmt.executeQuery(sql);



            RequestDispatcher rd = req.getRequestDispatcher("/SearchBy.html");
            rd.include(req,resp);
            out.println("</br><table style='border: 1.5px solid white; border-collapse: collapse; width: 100%;'><tr style='background-color: #275d7d;'><th style='border: 1px solid white; padding: 8px;'>Patient ID</th><th style='border: 1.5px solid white; padding: 8px;'>Name</th><th style='border: 1.5px solid white; padding: 8px;'>Age</th><th style='border: 1.5px solid white; padding: 8px;'>Phone Number</th><th style='border: 1.5px solid white; padding: 8px;'>Gender</th><th style='border: 1.5px solid white; padding: 8px;'>Address</th><th style='border: 1.5px solid white; padding: 8px;'>Entry Time</th><th style='border: 1.5px solid white; padding: 8px;'>Date</th><th style='border: 1.5px solid white; padding: 8px;'>Visit Status</th><th style='border: 1.5px solid white; padding: 8px;'>Times Visited</th><th style='border: 1.5px solid white; padding: 8px;'>Disease</th><th style='border: 1.5px solid white; padding: 8px;'>Dr. Name</th><th style='border: 1.5px solid white; padding: 8px;'>Present Visit Fee</th><th style='border: 1.5px solid white; padding: 8px;'>Total Fee</th></tr>");
            while (rs.next())
            {
                out.println("<tr>");
                out.println("<td style='border: 1.5px solid white; padding: 8px;'>" + rs.getInt(1) + "</td>" + "<td style='border: 1.5px solid white; padding: 8px;'>" + rs.getString(2) + "</td>" + "<td style='border: 1.5px solid white; padding: 8px;'>" + rs.getInt(3) + "</td>" + "<td style='border: 1.5px solid white; padding: 8px;'>" + rs.getString(4) + "</td>" + "<td style='border: 1.5px solid white; padding: 8px;'>" + rs.getString(5) + "</td>" + "<td style='border: 1.5px solid white; padding: 8px;'>" + rs.getString(6) + "</td>" + "<td style='border: 1.5px solid white; padding: 8px;'>" + rs.getString(7) + "</td>" + "<td style='border: 1.5px solid white; padding: 8px;'>" + rs.getString(8) + "</td>" + "<td style='border: 1.5px solid white; padding: 8px;'>" + rs.getString(9) + "</td>" + "<td style='border: 1.5px solid white; padding: 8px;'>" + rs.getString(10) + "</td>" + "<td style='border: 1.5px solid white; padding: 8px;'>" + rs.getString(11) + "</td>" + "<td style='border: 1.5px solid white; padding: 8px;'>" + rs.getString(12) + "</td>" + "<td style='border: 1.5px solid white; padding: 8px;'>" + rs.getInt(13) + "</td>" + "<td style='border: 1.5px solid white; padding: 8px;'>" + rs.getInt(14) + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");


            cn.con.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}




