package project.growupsmart.sources.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import project.growupsmart.sources.model.UserCategory;
import project.growupsmart.sources.repository.UserCategoryRepository;

@Service
public class UserCategoryService {
    private static final Logger log = LoggerFactory.getLogger(UserCategoryService.class);

    private final UserCategoryRepository userCategoryRepository;

    public UserCategoryService(UserCategoryRepository userCategoryRepository) {
        this.userCategoryRepository = userCategoryRepository;
    }

    public void save(UserCategory newCategory){
        log.info("saving category");
        userCategoryRepository.save(newCategory);
    }
}
