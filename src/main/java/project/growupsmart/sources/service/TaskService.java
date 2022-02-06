package project.growupsmart.sources.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.growupsmart.sources.dto.TaskUpdate;
import project.growupsmart.sources.exceptions.TaskAlreadyExistsException;
import project.growupsmart.sources.model.Task;
import project.growupsmart.sources.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {
    private static final Logger log = LoggerFactory.getLogger(TaskService.class);
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void save(Task newTask) {
        log.info("saving task");
        taskRepository.save(newTask);
    }

    public List<Task> findAll() {
        log.info("Finding all tasks");
        return taskRepository.findAll();
    }

    public Task updateEntity(TaskUpdate taskData, Task existingTask) {
        existingTask.setName(taskData.getName());
        existingTask.setDescription(taskData.getDescription());
        return existingTask;
    }

    public void updateTask(Long taskId, TaskUpdate taskData) {
        log.info("update task {}", taskData);
        taskRepository.findById(taskId)
                .map(existingTask -> updateEntity(taskData, existingTask))
                .map(updateTask -> taskRepository.save(updateTask))
                .orElseThrow(() -> new RuntimeException("task not found"));
    }

    public void updateNewTask(Task task){
        log.info("update task {}",task);

        String name = task.getName();

        taskRepository.findByNameIgnoreCase(name).filter(existingTask ->existingTask.getId().equals(task.getId()))
                .map(existingTask -> taskRepository.save(task))
                .orElseThrow(() -> {
                   log.error("task with name {} already exists",name);
                   throw new TaskAlreadyExistsException("task with name " + name + " already exists");
                });
    }
//    public void taskCompleted(Long taskId,TaskUpdate taskData){
//        log.info("task completed");
//        if (taskData.getSuccessDate()<=taskData.getEn2dDate()){ !!!
//        }
//    }

    public void taskExpired(Long taskId,TaskUpdate taskData){
        log.info("task expired");
        if (taskData.getEndDate()==taskData.getLocalDate()){
            taskRepository.deleteTaskByEndDate(taskId);
        }
    }

    @Transactional
    public void deleteTask(Long id){
        log.info("deleting task by id");
        taskRepository.deleteById(id);
    }

    public Task findById(Long id) {
        log.info("finding by id");
        return taskRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Task could not be found"));
    }
}
