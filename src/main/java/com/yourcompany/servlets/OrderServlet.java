package com.yourcompany.servlets;

import com.yourcompany.utils.DatabaseConnection;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

@WebServlet("/api/orders")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        int readerId = Integer.parseInt(request.getParameter("readerId"));
        Date orderDate = new Date();

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO orders (book_id, reader_id, order_date) VALUES (?, ?, ?)")) {
            statement.setInt(1, bookId);
            statement.setInt(2, readerId);
            statement.setDate(3, new java.sql.Date(orderDate.getTime()));
            statement.executeUpdate();
            response.setStatus(201); // Created
        } catch (SQLException e) {
            e.printStackTrace();
            response.setStatus(500);
            response.getWriter().println("Internal server error");
        }
    }
}
