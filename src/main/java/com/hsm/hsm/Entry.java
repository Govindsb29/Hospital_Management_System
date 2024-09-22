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

@WebServlet("/Entry")
public class Entry extends HttpServlet
{
    static Connect cn;
    public Entry()
    {
        cn = new Connect();
        cn.connectdb();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        try
        {
            String ID = req.getParameter("PatientID");
            int PatientID = Integer.parseInt(ID);

            String PatientName = req.getParameter("PatientName");

            String Age_s = req.getParameter("Age");
            int Age = Integer.parseInt(Age_s);

            String ph_no = req.getParameter("ph_no");

            String Gender = req.getParameter("Gender");

            String Address = req.getParameter("Address");

            String Entry_Time = req.getParameter("Time");
            String[] timeParts = Entry_Time.split(":");
            int hours = Integer.parseInt(timeParts[0]);
            int minutes = Integer.parseInt(timeParts[1]);
            float EntryTime = hours + (float) minutes / 100;

            String Date = req.getParameter("Date");

            String VisitStatus = req.getParameter("Visit");

            String Disease = req.getParameter("Disease");

            String dr_assigned=null, dr_sp; //dr.specialization
            int ff=0,rf=0; //first fee, repeat fee
            String dsql = "select * from dr_records order by d_id;";
            ResultSet rs = cn.stmt.executeQuery(dsql);
            while(rs.next())
            {
                ff= rs.getInt(6); //first fee = first visit charges
                rf = rs.getInt(7); //repeatfee = repeat visit charges
                dr_sp = rs.getString(5); //dr_specialization
                if (EntryTime >= 8.0 && EntryTime <= 17.0 && Disease.equals(dr_sp))
                {
                    dr_assigned= rs.getString(2);
                }
                if (EntryTime >= 17.0 && EntryTime <= 24.0 && Disease.equals(dr_sp))
                {
                    dr_assigned= rs.getString(2);
                }
            }

            if (VisitStatus.equals("First Visit"))
            {
                int times_visited = 1;
                int cvf = ff; //first visit so current visit fee = first fee
                int tfy = ff; // first visit so total fee yet = first fee
                String sql = "insert into patient_records values('" +PatientID+ "','" +PatientName+ "','" + Age + "','" + ph_no + "','" + Gender + "','" + Address + "','" + Entry_Time + "','" + Date + "','" + VisitStatus + "','" + times_visited + "','" + Disease + "','" + dr_assigned + "','" + cvf + "','" + tfy + "');";
                int result = cn.stmt.executeUpdate(sql);
                if (result>0)
                {
                    out.println("<h2 style=\"color: #9f1312;\">Record Entered Successfully</h2>");
                    RequestDispatcher rd = req.getRequestDispatcher("/Entry.html");
                    rd.include(req,resp);
                }
                else
                {
                    out.println("<h2>Error in Record Insertion</h2>");
                    RequestDispatcher rd = req.getRequestDispatcher("/Entry.html");
                    rd.include(req,resp);
                }
            }

            else if (VisitStatus.equals("Repeat Visit"))
            {
                int tv = 0, tf=0; //total visit old, total fee old
                String psql = "select * from patient_records order by id;";
                ResultSet rs1 = cn.stmt.executeQuery(psql);
                while(rs1.next())
                {
                    tv = rs1.getInt(10); //total visit old
                    tf= rs1.getInt(14); //total fee = total fee yet old wali
                }

                int tfy = tf+rf; //total fee = total old fee+repeat fee
                int times_visited = tv+1; //times visited = old time visited + 1
                String sql = "update patient_records set times_visited='"+times_visited+"',current_visit_fee='"+rf+"',total_fee_yet='"+tfy+"',visit_status='"+"Multiple Visits"+"' where id='"+PatientID+"';";
                int result = cn.stmt.executeUpdate(sql);
                if (result>0)
                {
                    out.println("<h2 style=\"color: #9f1312;\">Record Entered Successfully</h2>");
                            RequestDispatcher rd = req.getRequestDispatcher("/Entry.html");
                            rd.include(req,resp);
                }
                else
                {
                    out.println("<h2>Error in Record Insertion</h2>");
                    RequestDispatcher rd = req.getRequestDispatcher("/Entry.html");
                    rd.include(req,resp);
                }
            }
            cn.con.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
