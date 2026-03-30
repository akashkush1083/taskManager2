package com.taskManager.project.Repository;

import com.taskManager.project.Entity.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task,String> {
}
