package com.eci.production.service;

import com.eci.production.entity.Tool;

import java.util.List;

public interface ToolService {

    public void saveTool(Tool tool);
    public List<Tool> findAll();
    public Tool findById(int id);
    public List<Tool> findBySerialNumber(int serialNumber);
}
