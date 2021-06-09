package ru.itis.taskdistribution.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskNew {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    public String executor;
    public Date dateTime;
    public String deadline;
    public String status;
    public String team;
    public String project;
    public String napravlenie;

//    private TaskStatus status;
//
//    private TaskPriority priority;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskNew taskNew = (TaskNew) o;
        return id.equals(taskNew.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}