package com.yourcompany.models;

import java.util.Date;

public class Order {
    private int id;
    private int bookId;
    private int readerId;
    private Date orderDate;

    public Order() {

    }

    public Order(int id, int bookId, int readerId, Date orderDate) {
        this.id = id;
        this.bookId = bookId;
        this.readerId = readerId;
        this.orderDate = orderDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", readerId=" + readerId +
                ", orderDate=" + orderDate +
                '}';
    }
}
