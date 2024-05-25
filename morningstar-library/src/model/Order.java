package model;

import java.util.StringJoiner;
import java.util.Vector;

public class Order {

    private int orderID;
    private String userID;
    private String orderDate;
    private String deliveryAddress;
    private int totalAmount;
    private int totalBookCount;
    private Vector<String> isbns;
    private boolean isValid;

    public Order(int orderID, String userID, String orderDate, String deliveryAddress, int totalAmount, int totalBookCount, Vector<String> isbns, boolean isValid) {
        this.orderID = orderID;
        this.userID = userID;
        this.orderDate = orderDate;
        this.deliveryAddress = deliveryAddress;
        this.totalAmount = totalAmount;
        this.totalBookCount = totalBookCount;
        this.isbns = isbns;
        this.isValid = isValid;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(isbns.elementAt(0));

        for (int i = 1; i < isbns.size(); i++) {
            sb.append(", ").append(isbns.elementAt(i));
        }

        return new StringJoiner(", ", "OrderID: ", "")
                .add(Integer.toString(orderID))
                .add("userID: " + userID)
                .add("OrderDate: " + orderDate)
                .add("DeliveryAddress: " + deliveryAddress)
                .add("TotalAmount: " + Integer.toString(totalAmount))
                .add("TotalBookCount: " + Integer.toString(totalBookCount))
                .add("ISBNS: " + sb.toString())
                .add("isValid: " + isValid)
                .toString();
    }

    public int getOrderID() {
        return orderID;
    }

    public String getUserID() {
        return userID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public int getTotalBookCount() {
        return totalBookCount;
    }

    public Vector<String> getIsbns() {
        return isbns;
    }
    
    public boolean getIsValid() {
    	return isValid;
    }
}