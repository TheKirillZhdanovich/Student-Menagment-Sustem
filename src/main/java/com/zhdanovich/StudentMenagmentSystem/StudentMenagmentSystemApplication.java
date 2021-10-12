package com.zhdanovich.StudentMenagmentSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.zhdanovich"})
public class StudentMenagmentSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentMenagmentSystemApplication.class, args);
	}

}
