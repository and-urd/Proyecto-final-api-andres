package com.example.ejerciciohibernateandres.controller;

import com.example.ejerciciohibernateandres.dao.TaskDAO;
import com.example.ejerciciohibernateandres.model.Task;
import com.example.ejerciciohibernateandres.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TaskController {

    private final TaskService taskService;
    private final TaskDAO taskDAO;
    public TaskController(TaskService taskService, TaskDAO taskDAO) {
        this.taskService = taskService;
        this.taskDAO = taskDAO;
    }

    // CREA TASK
    @PostMapping("/tasks")
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        Task tagNueva = taskService.createTask(task);
        if(tagNueva == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else{
            return ResponseEntity.ok().body(tagNueva);
        }
    }

    // RECUPERAR TODAS TASKS
    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> findAll(){
        List<Task> taksList = taskService.findAllTasks();

        if(taksList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return ResponseEntity.ok().body(taksList);
        }
    }

    // RECUPERAR UNA TASK
    @GetMapping("/task/{id}")
    public ResponseEntity<Optional<Task>> findOne(@PathVariable Long id) {
        Optional<Task> resultTask =  taskService.findOneTask(id);
        if(resultTask.isPresent()){
            return ResponseEntity.ok().body(resultTask);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // RECUPERA UNA TASK POR SU TITULO
    @GetMapping("/tasks/titulo/{titulo}")
    public  ResponseEntity<List<Task>> findByTitulo(@PathVariable String titulo) {

        List<Task> taskList = taskDAO.findAllTagsByTitulo(titulo);
        if(taskList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return ResponseEntity.ok().body(taskList);
        }
    }

    // ACTUALIZAR UNA TASK
    @PutMapping("/task")
    public ResponseEntity<Task> updateTask(@RequestBody Task task) {
        Task resultTask = taskService.updateTask(task);
        if(resultTask == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else{
            return ResponseEntity.ok().body(resultTask);
        }
    }
}
