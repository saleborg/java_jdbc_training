package com.saleborg.lil.jdbc.models;

import com.saleborg.lil.jdbc.util.DataTransferObject;

public class Order implements DataTransferObject {

    private long id;
    private String creationDate;
    private int totalDue;
    private String status;
    private long customerId;
    private long salespersonId;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public int getTotalDue() {
        return totalDue;
    }

    public void setTotalDue(int totalDue) {
        this.totalDue = totalDue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getSalespersonId() {
        return salespersonId;
    }

    public void setSalespersonId(long salespersonId) {
        this.salespersonId = salespersonId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", creationDate='" + creationDate + '\'' +
                ", totalDue='" + totalDue + '\'' +
                ", status='" + status + '\'' +
                ", customerId='" + customerId + '\'' +
                ", salespersonId='" + salespersonId + '\'' +
                '}';
    }
}
