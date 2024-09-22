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
@WebServlet("/SearchBy")

public class SearchBy extends HttpServlet
{
    static Connect cn;
    public SearchBy()
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
            String id = req.getParameter("ID");
            int Id = Integer.parseInt(id);
            String name = req.getParameter("name");

            RequestDispatcher rd = req.getRequestDispatcher("/SearchBy.html");
            rd.include(req,resp);

            String sql = "Select * from patient_records where id='"+Id+"' and name='"+name+"';";
            ResultSet rs = cn.stmt.executeQuery(sql);
            String cssTag="<link rel='stylesheet' type='text/css' href='css/pr.css'>";
            out.println("<html>");
            out.println("<head><title>Title Name</title>"+cssTag+"</head>");
            out.println("<body>");
            out.println("</br><table border='"+1+"'><tr><th>Patient ID</th><th>Name</th><th>Age</th><th>Phone Number</th><th>Gender</th><th>Address</th><th>Entry Time</th><th>Date</th><th>Visit Status</th><th>Times Visited</th><th>Disease</th><th>Dr. Name</th><th>Present Visit Fee</th><th>Total Fee</th></tr>");
            while (rs.next())
            {
                out.println("<tr>");
                out.println("<td>" + rs.getInt(1) + "</td>" + "<td>" + rs.getString(2) + "</td>" + "<td>" + rs.getInt(3) + "</td>" + "<td>" + rs.getString(4) + "</td>" + "<td>" + rs.getString(5) + "</td>" + "<td>" + rs.getString(6) + "</td>" + "<td>" + rs.getString(7) + "</td>" + "<td>" + rs.getString(8) + "</td>" + "<td>" + rs.getString(9) + "</td>" + "<td>" + rs.getString(10) + "</td>" + "<td>" + rs.getString(11) + "</td>" + "<td>" + rs.getString(12) + "</td>" + "<td>" + rs.getInt(13) + "</td>" + "<td>" + rs.getInt(14) + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("</body></html>");
            cn.con.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
