package com.eci.production.service;

import com.eci.production.entity.Entry;
import com.eci.production.entity.Tool;
import com.eci.production.repository.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
    public List<Entry> findBySerialNumber(int serialNumber) {
        return toolRepository.findBySerialNumber(serialNumber);
    }


}
