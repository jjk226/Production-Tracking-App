package com.eci.production.repository;


import com.eci.production.entity.Entry;
import com.eci.production.entity.Tool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ToolRepository extends JpaRepository<Tool, Integer> {

    public Tool findById(int id);
    public List<Tool> findBySerialNumber(int serialNumber);

    public List<Tool> findByProductionOrder(int productionOrder);

    public List<Tool> findByPartNumber (String partNumber);

}
