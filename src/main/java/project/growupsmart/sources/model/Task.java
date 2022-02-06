package project.growupsmart.sources.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date creationDate;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date endDate;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date successDate;
    @ManyToOne
    private TaskCategory taskCategory;

    public Task(String name, String description, TaskCategory taskCategory) {
        this.name = name;
        this.description = description;
        this.taskCategory = taskCategory;
    }

    public Task() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getSuccessDate() {
        return successDate;
    }

    public void setSuccessDate(Date successDate) {
        this.successDate = successDate;
    }

    public TaskCategory getTaskCategory() {
        return taskCategory;
    }

    public void setTaskCategory(TaskCategory taskCategory) {
        this.taskCategory = taskCategory;
    }

    public String toString(){
        return "Task{" + "name=" + name + ", description=" + description + "" +
                ", creationDate=" + creationDate + "endDate=" + endDate + "successDate=" + successDate +'}';
    }
}
