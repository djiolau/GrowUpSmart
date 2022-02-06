package project.growupsmart.sources.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="taskKidsUnion")
public class TaskKidsUnion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    private List<Task> tasks = new ArrayList<>();
    @OneToMany
    private List<TaskCategory> taskCategory = new ArrayList<>();
    @OneToMany
    private List<User> users = new ArrayList<>();



}
