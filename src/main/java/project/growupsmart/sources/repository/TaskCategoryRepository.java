package project.growupsmart.sources.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import project.growupsmart.sources.model.TaskCategory;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskCategoryRepository extends CrudRepository<TaskCategory, Long> {
    List<TaskCategory> findAll();

    Optional<TaskCategory> findByNameIgnoreCase(String name);
}
