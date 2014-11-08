package ru.kfu.itis;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Created by mg on 08.11.14.
 */
public class Num2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        PrintWriter pw = resp.getWriter();



        String url = "jdbc:mysql://localhost:3306/goodsHW";
        Connection connection;
        ResultSet res;
        String temp = "INSERT INTO BOOKS VALUES(?,?,?,?,?)";
        PreparedStatement preparedStatement;
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url, "user", "password");
            Statement statement = connection.createStatement();
            statement.execute("USE CW;");



            preparedStatement = connection.prepareStatement(temp);
            preparedStatement.setString(1, req.getParameter("author"));
            preparedStatement.setString(2, req.getParameter("name"));
            preparedStatement.setString(3, req.getParameter("genre"));
            preparedStatement.setInt(4, new Integer(req.getParameter("pages")));
            preparedStatement.setInt(5, new Integer(req.getParameter("rating")));
            preparedStatement.execute();
            preparedStatement = connection.prepareStatement("SELECT * FROM BOOKS ORDER BY rating");

            res = preparedStatement.executeQuery();
            pw.println("<table>");


            while(res.next()){
                pw.println("<tr>");
                pw.println("<td>" + res.getString("author") + "</td>");
                pw.println("<td>" + res.getString("name") + "</td>");
                pw.println("<td>" + res.getString("genre") + "</td>");
                pw.println("<td>" + res.getString("number_of_pages") + "</td>");
                pw.println("<td>" + res.getString("rating") + "</td>");
                pw.println("</tr>");

            }
            pw.println("</table>");
            pw.close();

            //hibernate

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
