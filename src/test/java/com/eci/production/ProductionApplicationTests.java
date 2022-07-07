package com.eci.production;

import com.eci.production.controller.MainController;
import com.eci.production.entity.Tool;
import com.eci.production.service.EntryService;
import com.eci.production.service.ToolService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.entry;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ProductionApplicationTests {

	@Autowired
	private MainController mainController;

	@Autowired
	private EntryService entryService;

	@Autowired
	private ToolService toolService;

	@Test
	void contextLoads() {
	}

	@Test
	void MainControllerExists() {
		assertThat(mainController).isNotNull();
	}

	@Test
	void EntryServiceExists() {
		assertThat(entryService).isNotNull();
	}



}
