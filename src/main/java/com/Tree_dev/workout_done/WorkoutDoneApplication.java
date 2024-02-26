package com.Tree_dev.workout_done;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class WorkoutDoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkoutDoneApplication.class, args);
	}

}
