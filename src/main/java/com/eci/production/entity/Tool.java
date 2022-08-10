package com.eci.production.entity;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="db_tools")
public class Tool {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="serial_number")
    private int serialNumber;

    @Column(name="production_order")
    private int productionOrder;

    @Column(name="part_number")
    private String partNumber;

    @Column(name="product_line")
    private String productLine;

    @Column(name="customer")
    private String customer;

    @Column(name="name")
    private String name;

    @Column(name="subassembly")
    private boolean isSubassembly = false;

    @OneToMany(
            mappedBy="tool",
            cascade=CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Entry> entries;

    public Tool() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Entry> getEntries() {

        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }

    public void addEntry(Entry entry) {
        entries.add(entry);

    }

    public boolean isSubassembly() {
        return isSubassembly;
    }

    public void setIsSubassembly(boolean subassembly) {
        isSubassembly = subassembly;
    }

    public int getProductionOrder() {
        return productionOrder;
    }

    public void setProductionOrder(int productionOrder) {
        this.productionOrder = productionOrder;
    }
}
