import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/stdrec")
public class student_record extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");
            Statement stmt = con.createStatement();
            String State=req.getParameter("State");
            String City = req.getParameter("City");
            String sql = "Select * from student_record where state ='"+State+"' and city ='"+City+"'";
            ResultSet rs = stmt.executeQuery(sql);
            out.println("<table border='"+2+"'><tr><th>Name</th><th>State</th><th>City</th><th>Roll No.</th><tr>");
            while (rs.next())
            {
                out.println("<tr>");
                out.println("<td>"+rs.getString(1)+"</td>"+"<td>"+ rs.getString(2)+"</td>"+"<td>"+rs.getString(3)+"</td>"+"<td>"+rs.getInt(4)+"</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            con.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
