package project.growupsmart.sources.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import project.growupsmart.sources.model.UserCategory;

@Repository
public interface UserCategoryRepository extends CrudRepository<UserCategory, Long> {
}
