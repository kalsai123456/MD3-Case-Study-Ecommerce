package model;

import java.util.Date;

public class Order {
    private int idOrder;
    private Date timeOrder;
    private User user;

    public Order() {
    }

    public Order(int idOrder, Date timeOrder, User user) {
        this.idOrder = idOrder;
        this.timeOrder = timeOrder;
        this.user = user;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public Date getTimeOrder() {
        return timeOrder;
    }

    public void setTimeOrder(Date timeOrder) {
        this.timeOrder = timeOrder;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOrder=" + idOrder +
                ", timeOrder=" + timeOrder +
                ", user=" + user +
                '}';
    }
}
