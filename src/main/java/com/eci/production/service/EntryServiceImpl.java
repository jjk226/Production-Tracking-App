package com.eci.production.service;

import com.eci.production.entity.Entry;
import com.eci.production.entity.Tool;
import com.eci.production.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EntryServiceImpl implements EntryService {

    private EntryRepository entryRepository;

    @Autowired
    public EntryServiceImpl(EntryRepository entryRepository) {
        System.out.println("--> EntryServiceImpl constructor");
        this.entryRepository = entryRepository;
    }

    @Override
    @Transactional
    public List<Entry> findAll() {
        return entryRepository.findAll();
    }

    @Override
    public List<Entry> findByEmployeeId(int employeeId) {

        return entryRepository.findByEmployeeId(employeeId);
    }

    @Override
    public Entry findById(int id) {
        return entryRepository.findById(id);
    }

    @Override
    public void save(Entry entry) {
        entryRepository.save(entry);
    }

    @Override
    public void deleteById(int id) {
        entryRepository.deleteById(id);
    }

    @Override
    public List<Entry> findByProductionOrder(int productionOrder) {
        return entryRepository.findByProductionOrder(productionOrder);
    }

    @Override
    public List<Entry> findByTool(Tool tool) {
        return entryRepository.findByTool(tool);
    }
}
