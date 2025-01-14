package main.java.com.example;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class BookServlet extends HttpServlet {
    private Connection connection;

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdb", "root", "");
        } catch (Exception e) {
            throw new ServletException("Database connection error", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String author = request.getParameter("author");
        String genre = request.getParameter("genre");

        try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO books (name, author, genre) VALUES (?, ?, ?)")) {
            stmt.setString(1, name);
            stmt.setString(2, author);
            stmt.setString(3, genre);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new IOException("Database error", e);
        }

        response.sendRedirect("index.jsp");
    }

    @Override
    public void destroy() {
        try {
            if (connection != null) connection.close();
        } catch (SQLException ignored) {}
    }
}
