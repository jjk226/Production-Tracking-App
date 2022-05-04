package com.eci.production.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

@Entity
@Table(name="db_entries")
public class Entry {
    public enum Status {OPEN, CLOSED}
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name="id")
    private int id;

    @Column(name="employee_id")
    private int employeeId;

    @Column(name="production_order")
    private int productionOrder;

    @Column(name="start_date")
    private Date startDate;

    @Column(name="end_date")
    private Date endDate;

    @Column(name="status")
    private String status;

    @Column(name="serial_number")
    private int serialNumber;

    @Column(name="operation")
    private String operation;

    @ManyToOne(optional=false)
    @JoinColumn(name="tool_id", nullable=false)
    private Tool tool;

    private double timeDiff;

    public Entry() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getProductionOrder() {
        return productionOrder;
    }

    public void setProductionOrder(int productionOrder) {
        this.productionOrder = productionOrder;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Tool getTool() {
        return tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }

    public double getTimeDiff() {
        if(this.endDate == null || this.startDate == null) {
            return 0;
        } else {
            this.setTimeDiff(calculateTimeDiff());
        }

        return timeDiff;
    }

    public void setTimeDiff(double timeDiff) {
        this.timeDiff = timeDiff;
    }

    public double calculateTimeDiff() {
        long diffInMillies = Math.abs(this.endDate.getTime() - this.startDate.getTime());
        long diff = TimeUnit.SECONDS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        double diffInDecimal = (double) diff/60/60;

        DecimalFormat df = new DecimalFormat("#.##");

        return Double.valueOf(df.format(diffInDecimal));
    }

    @Override
    public String toString() {
        return "Entry {" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", productionOrder=" + productionOrder +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status=" + status +
                ", serialNumber =" + serialNumber +
                '}';
    }
}
