package com.taskManager.project.TaskService;

import com.taskManager.project.Entity.Task;
import com.taskManager.project.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public boolean saveTask(Task task){
        taskRepository.save(task);
        return true;
    }

    public List<Task> getTodo(){
        List<Task> taskList=taskRepository.findAll();
        return taskList;
    }

    public boolean deleteById(String id){
        taskRepository.deleteById(id);
        return true;
    }
}
