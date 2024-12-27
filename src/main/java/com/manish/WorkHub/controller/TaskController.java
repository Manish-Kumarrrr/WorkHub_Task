package com.manish.WorkHub.controller;

import com.manish.WorkHub.config.AppConstants;
import com.manish.WorkHub.dto.PaginationResponse;
import com.manish.WorkHub.dto.TaskRequest;
import com.manish.WorkHub.dto.TaskResponse;
import com.manish.WorkHub.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        if(!(status.equals("Open") || status.equals("Close"))){
            return new ResponseEntity<>(false,HttpStatus.OK);
        }
        return new ResponseEntity<>(taskService.changeStatus(taskId,status),HttpStatus.ACCEPTED);
    }

//    @GetMapping("/all")
//    public ResponseEntity<List<TaskResponse>> getAllTask(){
//        return new ResponseEntity<>(taskService.getAll(),HttpStatus.OK);
//    }
    @GetMapping("/all")
    public ResponseEntity<PaginationResponse<TaskResponse>> getAllTask(
            @RequestParam(value="pageNumber",defaultValue = AppConstants.PAGE_NUMBER,required = false) Integer pageNumber,
            @RequestParam(value = "pageSize",defaultValue = AppConstants.PAGE_SIZE ,required = false) Integer pageSize,
            @RequestParam(value="sortBy",defaultValue = AppConstants.SORT_BY,required = false) String sortBy,
            @RequestParam(value="sortDir" , defaultValue = AppConstants.SORT_DIR,required = false) String sortDir)
    {
        return new ResponseEntity<>(taskService.getAllTask(pageNumber,pageSize,sortBy,sortDir),HttpStatus.OK);
    }

//    @GetMapping("/all/{userId}")
//    public ResponseEntity<List<TaskResponse>> getAllTaskByUserId(@PathVariable String userId){
//        return new ResponseEntity<>(taskService.getAllTaskByUserId(userId),HttpStatus.OK);
//    }
    @GetMapping("/all/{userId}")
    public ResponseEntity<PaginationResponse<TaskResponse>> getAllTaskByUserId(
            @PathVariable String userId,
            @RequestParam(value="pageNumber",defaultValue = AppConstants.PAGE_NUMBER,required = false) Integer pageNumber,
            @RequestParam(value = "pageSize",defaultValue = AppConstants.PAGE_SIZE ,required = false) Integer pageSize,
            @RequestParam(value="sortBy",defaultValue = AppConstants.SORT_BY,required = false) String sortBy,
            @RequestParam(value="sortDir" , defaultValue = AppConstants.SORT_DIR,required = false) String sortDir)
    {
        return new ResponseEntity<>(taskService.getAllTaskByUserId(userId,pageNumber,pageSize,sortBy,sortDir),HttpStatus.OK);
    }



}
