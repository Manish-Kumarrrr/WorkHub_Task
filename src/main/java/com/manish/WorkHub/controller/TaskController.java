package com.manish.WorkHub.controller;

import com.manish.WorkHub.dto.TaskRequest;
import com.manish.WorkHub.dto.TaskResponse;
import com.manish.WorkHub.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @PutMapping("/changeStatus/{taskId}/{status}")
    public ResponseEntity<Boolean> changeStatus(@PathVariable String taskId,@PathVariable String status){
        if(!(status.equals("Active") || status.equals("Deactive"))){
            return new ResponseEntity<>(false,HttpStatus.OK);
        }
        return new ResponseEntity<>(taskService.changeStatus(taskId,status),HttpStatus.ACCEPTED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TaskResponse>> getAllTask(){
        return new ResponseEntity<>(taskService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/all/{userId}")
    public ResponseEntity<List<TaskResponse>> getAllTaskByUserId(@PathVariable String userId){
        return new ResponseEntity<>(taskService.getAllTaskByUserId(userId),HttpStatus.OK);
    }
}
