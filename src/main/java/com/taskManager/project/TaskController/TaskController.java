package com.taskManager.project.TaskController;

import com.taskManager.project.Entity.Task;
import com.taskManager.project.TaskService.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/taskManger")
public class TaskController {

    @Autowired
   private TaskService taskService;

    @PostMapping
    public boolean createTodo(@RequestBody Task task){
        taskService.saveTask(task);
        return true;
    }

    @GetMapping
    public ResponseEntity<?> getTodo(){
        List<Task> todoList=taskService.getTodo();
        return new ResponseEntity<>(todoList, HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable String id){
        taskService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
