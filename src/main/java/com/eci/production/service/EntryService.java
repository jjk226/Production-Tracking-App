package com.eci.production.service;

import com.eci.production.entity.Entry;
import com.eci.production.entity.Tool;

import java.util.List;

public interface EntryService {

    public List<Entry> findAll();

    public List<Entry> findByEmployeeId(int id);

    public Entry findById(int id);

    public void save(Entry entry);

    public void deleteById(int id);

    List<Entry> findByProductionOrder(int productionOrder);

    List<Entry> findByTool(Tool tool);
}
