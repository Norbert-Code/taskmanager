package com.taskmaster.taskmaster;

import org.springframework.boot.SpringApplication;

public class TestTaskMasterApplication {

	public static void main(String[] args) {
		SpringApplication.from(TaskMasterApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
