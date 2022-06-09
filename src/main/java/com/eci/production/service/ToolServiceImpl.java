package com.eci.production.service;

import com.eci.production.entity.Tool;
import com.eci.production.repository.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ToolServiceImpl implements ToolService {

    private ToolRepository toolRepository;

    @Autowired
    public ToolServiceImpl(ToolRepository toolRepository) {
        this.toolRepository = toolRepository;
    }

    @Override
    public void saveTool(Tool tool) {
        toolRepository.save(tool);
    }

    @Override
    public List<Tool> findAll() {
        return toolRepository.findAll();
    }

    @Override
    public Tool findById(int id) {
        return toolRepository.findById(id);
    }

    @Override
    public List<Tool> findBySerialNumber(int serialNumber) {
        return toolRepository.findBySerialNumber(serialNumber);
    }

    public List<Tool> findByProductionOrder(int productionOrder) {
        return toolRepository.findByProductionOrder(productionOrder);
    }

    @Override
    public List<Tool> findByPartNumber(String partNumber) {
        return toolRepository.findByPartNumber(partNumber);
    }


}
