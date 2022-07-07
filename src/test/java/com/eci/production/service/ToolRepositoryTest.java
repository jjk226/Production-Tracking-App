package com.eci.production.service;
import com.eci.production.entity.Tool;
import com.eci.production.repository.ToolRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class ToolRepositoryTest {
    @Autowired
    private ToolRepository toolRepository;

    @Test
    public void toolRepositoryIsNotNull() {
        assertThat(toolRepository).isNotNull();
    }

    @Test
    void findById() {
        Tool tool = new Tool();
        toolRepository.save(tool);

        int id = tool.getId();

        assertThat(toolRepository.findById(id).getId() > 0);
    }

    @Test
    void findBySerialNumber() {
        Tool tool = new Tool();
        tool.setSerialNumber(123);

        toolRepository.save(tool);

        List<Tool> toolBySerialNumber = toolRepository.findBySerialNumber(123);

        assertThat(toolBySerialNumber.get(0).getSerialNumber() == 123);
    }

    @Test
    void findByProductionOrder() {
        Tool tool = new Tool();
        tool.setProductionOrder(123456);

        toolRepository.save(tool);

        assertThat(toolRepository.findByProductionOrder(123456).get(0).getProductionOrder() == 123456);
    }

    @Test
    void findByPartNumber() {
        Tool tool = new Tool();
        tool.setPartNumber("TQPR123456");

        toolRepository.save(tool);

        assertThat(toolRepository.findByPartNumber("TQPR123456").get(0).getPartNumber().equals("TQPR123456"));
    }

    @Test
    void findAll() {
        List<Tool> tools = toolRepository.findAll();
        System.out.println("number of saved tools: " + tools.size());
    }
}