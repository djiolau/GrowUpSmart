package project.growupsmart.sources.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import project.growupsmart.sources.model.Task;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

    List<Task> findAll();

    Optional<Task> findByNameIgnoreCase(String name);

    Optional<Task> deleteTaskByEndDate(Long id);
}
