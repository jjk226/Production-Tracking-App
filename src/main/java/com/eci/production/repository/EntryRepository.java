package com.eci.production.repository;

import com.eci.production.entity.Entry;
import com.eci.production.entity.Tool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EntryRepository extends JpaRepository<Entry, Integer> {

    public List<Entry> findAll();

    public Entry findById(int id);

    List<Entry> findByEmployeeId(int employeeId);

    List<Entry> findByProductionOrder(int productionOrder);

    List<Entry> findByTool(Tool tool);


}
