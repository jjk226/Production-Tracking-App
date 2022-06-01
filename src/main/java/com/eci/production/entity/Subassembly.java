package com.eci.production.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="db_sumbassembly")
public class Subassembly {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name="id")
    private int id;

    @Column(name="serial_number")
    private int serialNumber;

    @Column(name="part_number")
    private String partNumber;

    @Column(name="product_line")
    private String productLine;

    @Column(name="customer")
    private String customer;

    @Column(name="name")
    private String name;

    @OneToMany(
            mappedBy="tool",
            cascade=CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Entry> entries;

    public Subassembly() {}
}
