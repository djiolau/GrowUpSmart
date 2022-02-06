package project.growupsmart.sources.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.growupsmart.sources.dto.TaskCategoryUpdate;
import project.growupsmart.sources.exceptions.TaskAlreadyExistsException;
import project.growupsmart.sources.model.TaskCategory;
import project.growupsmart.sources.repository.TaskCategoryRepository;

import java.util.List;

@Service
public class TaskCategoryService {
    private static final Logger log = LoggerFactory.getLogger(TaskCategoryService.class);
    private final TaskCategoryRepository taskCategoryRepository;

    public TaskCategoryService(TaskCategoryRepository taskCategoryRepository) {
        this.taskCategoryRepository = taskCategoryRepository;
    }

    public void save(TaskCategory newCategory) {
        log.info("saving category");
        taskCategoryRepository.save(newCategory);
    }

    public List<TaskCategory> findAll() {
        log.info("finding all categories");
        return taskCategoryRepository.findAll();
    }

    public void updateTaskCategory(Long taskCategoryId, TaskCategoryUpdate taskCategoryData) {
        log.info("update taskCategory {}", taskCategoryData);

        taskCategoryRepository.findById(taskCategoryId)
                .map(existingTaskCategory -> updateEntity(taskCategoryData, existingTaskCategory))
                .map(updateTaskCategory -> taskCategoryRepository.save(updateTaskCategory))
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public TaskCategory updateEntity(TaskCategoryUpdate taskCategoryData, TaskCategory existingCategory) {
        existingCategory.setName(taskCategoryData.getName());
        existingCategory.setDescription(taskCategoryData.getDescription());
        return existingCategory;
    }

    public void updateNewTask(TaskCategory category) {
        log.info("update taskCategory {}", category);

        String name = category.getName();

        taskCategoryRepository.findByNameIgnoreCase(name).filter(existingCategory -> existingCategory.getId().equals(category.getId()))
                .map(existingCategory -> taskCategoryRepository.save(category))
                .orElseThrow(() -> {
                    log.error("category with name {} already exists", name);
                    throw new TaskAlreadyExistsException("category with name " + name + " already exists");
                });
    }

    @Transactional
    public void deleteCategory(Long id) {
        log.info("deleting category by id");
        taskCategoryRepository.deleteById(id);
    }


}
