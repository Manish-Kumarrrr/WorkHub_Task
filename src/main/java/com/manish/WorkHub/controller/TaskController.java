package com.manish.WorkHub.controller;


import com.manish.WorkHub.dto.TaskRequest;
import com.manish.WorkHub.dto.TaskResponse;
import com.manish.WorkHub.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Repeatable;
import java.util.List;

@RestController
@RequestMapping("/v1/api/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @PostMapping("/add")
    public ResponseEntity<TaskResponse> addTask(@RequestBody TaskRequest taskRequest){
        return new ResponseEntity<>(taskService.addTask(taskRequest), HttpStatus.CREATED);
    }

    @PutMapping("/changeStatus/{taskId}")
    public ResponseEntity<Boolean> changeStatus(@PathVariable String taskId,@PathVariable String status){
        return new ResponseEntity<>(taskService.changeStatus(taskId,status),HttpStatus.ACCEPTED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TaskResponse>> getAll(){
        return new ResponseEntity<>(taskService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/all/{userId}")
    public ResponseEntity<List<TaskResponse>> getByUserId(@PathVariable String userId){
        return new ResponseEntity<>(taskService.getByUserId(userId),HttpStatus.OK);
    }
}
