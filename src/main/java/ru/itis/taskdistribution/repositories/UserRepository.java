package ru.itis.taskdistribution.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.taskdistribution.models.Worker;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Worker, Long> {
    List<Worker> findAll();
}
