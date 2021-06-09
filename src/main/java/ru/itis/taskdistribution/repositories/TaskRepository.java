package ru.itis.taskdistribution.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.taskdistribution.models.TaskNew;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskNew, Long> {
   List<TaskNew> findAll();
}
