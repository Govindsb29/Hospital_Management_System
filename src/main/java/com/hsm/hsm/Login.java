package com.hsm.hsm;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

@WebServlet("/login")
public class Login extends HttpServlet {
    static Connect cn;
    public Login()
    {
        cn = new Connect();
        cn.connectdb();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String id = req.getParameter("UserID");
        int user_id = Integer.parseInt(id);
        String password = req.getParameter("password");
        try
        {
            String sql = "select * from receptionist where receptionist_id = '" + user_id + "' AND password = '" + password + "';";

            ResultSet rs = cn.stmt.executeQuery(sql);
            if (rs.next())
            {
                out.print("Welcome");
                RequestDispatcher rd = req.getRequestDispatcher("/Entry.html");
                rd.forward(req,resp);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
