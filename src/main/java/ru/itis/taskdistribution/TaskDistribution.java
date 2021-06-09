package ru.itis.taskdistribution;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TaskDistribution {

    public static void main(String[] args) {
        SpringApplication.run(TaskDistribution.class, args);
    }
}