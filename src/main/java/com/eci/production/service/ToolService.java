package com.eci.production.service;

import com.eci.production.entity.Entry;
import com.eci.production.entity.Tool;

import java.util.List;
import java.util.Optional;

public interface ToolService {

    public void saveTool(Tool tool);
    public List<Tool> findAll();
    public Tool findById(int id);
    public List<Entry> findBySerialNumber(int serialNumber);
}
