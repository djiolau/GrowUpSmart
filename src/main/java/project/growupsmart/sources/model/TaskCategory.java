package project.growupsmart.sources.model;

import javax.persistence.*;

@Entity
@Table(name = "taskCategory")
public class TaskCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    //Idea : A String type message!Let the kid know that he has completed the task.Now he should check the reward
    //area.Prices are waiting for him :D
    private String rewardValue; // maybe is better in Task class --> to ask trainer

    public TaskCategory() {
    }

    public TaskCategory(String name, String description) {
        this.name = name;
        this.description = description;
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

    public String getRewardValue() {
        return rewardValue;
    }

    public void setRewardValue(String rewardValue) {
        this.rewardValue = rewardValue;
    }
}
