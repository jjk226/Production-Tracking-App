package com.eci.production.repository;


import com.eci.production.entity.Entry;
import com.eci.production.entity.Tool;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToolRepository extends JpaRepository<Tool, Integer> {

    public Tool findById(int id);
    public List<Entry> findBySerialNumber(int serialNumber);

}
