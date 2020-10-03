package io.alapierre.task.service.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.TimeZone;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = {"pl.ey.task.service.core.repository"})
//@EnableDiscoveryClient
@Slf4j
public class TaskService {

	public static void main(String[] args) {
		SpringApplication.run(TaskService.class, args);
	}

	@PostConstruct
	public void printDiag() {
//Europe/Warsaw
		log.info("Time Zone is {}, current system time is {}", TimeZone.getDefault(), LocalDateTime.now());

	}

}
