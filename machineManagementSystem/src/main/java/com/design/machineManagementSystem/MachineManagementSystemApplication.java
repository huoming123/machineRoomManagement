package com.design.machineManagementSystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.design.machineManagementSystem.mapper")
@ComponentScan(value="com.design")
public class MachineManagementSystemApplication {

	public static void main(String[] args) {

		try {
			SpringApplication.run(MachineManagementSystemApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
